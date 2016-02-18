/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

/*
 * $Id: ExSecurityManager.java,v 2.2 1997/11/07 05:10:57 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import	java.io.BufferedReader;
import	java.io.File;
import	java.io.FileDescriptor;
import	java.io.FileReader;
import	java.io.IOException;
import	java.io.Reader;
import	java.net.InetAddress;
import	java.util.Dictionary;
import	java.util.Hashtable;

/**
 * The security manager of the OZ system.  The main functionality of the
 * security manager is to check whether some action taken by the Java VM is
 * permitted or not according to the thread context and resources being to be
 * operated.  For most of the actions, whether the action is taken by executor
 * code or not is investigated.  This is done by the method inExecutor().
 * Because the executor classes are designed carefully not to harm the host
 * system, almost all actions are permitted to them.  If it is not by the
 * executor class, it is regarded by user code.  Then, process color is
 * checked.  A green process can do more than a red process. 
 *
 * User security objects can intervene this checking process.  In several
 * case, when a user code is permitted to do the action, a confirmation by a
 * user security object is required.  The user security object can be set to
 * the security manager one per each cell on this executor.  The thread taking
 * the action belongs to the cell which has no user security object is not
 * required the confirmation.
 *
 * The details of the decisions taken by the security manager is described in
 * the description of each checking method, where
 * <UL>
 *   <LI> permitted<BR>         permitted to do the action.
 *   <LI> prohibited<BR>        prohibited to do the action.
 *   <LI> with confirmation<BR> not prohibited, but, if the user security
 *                              object is set, confirmation by it is required.
 * </UL>
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:57 $
 * @author		Unknown
 * @author		Yasumitsu Yoshida(reviser)
 */

class ExSecurityManager
extends SecurityManager
{
    /**
     * For debug and message
     */
    static final String CN = "ExSecurityManager";

    /**
     * A kind of process colors.  A green process is regarded as a `safe'
     * process.
     *
     * @see OzSecure#GREEN
     */
    static final boolean GREEN = OzSecure.GREEN;

    /**
     * A kind of process colors.  A red process is regarded as a `unsafe'
     * process.
     *
     * @see OzSecure#RED
     */
    static final boolean RED = OzSecure.RED;

    /**
     * The executor entry classes:
     * Requests through these classes are unconditionally permitted.
     */
    static String[] entries = {
	OzSystem.class.getName(),
	OzProcess.class.getName(),
	OzProxy.class.getName(),
	OzCell.class.getName(),
	OzClassFile.class.getName(),
	OzThread.class.getName(),
	OzCellManager.class.getName()
    };

    /**
     * Path of OZHOME
     */
    static final String ozHomePath = System.getProperty("oz.home");

    /**
     * The top path of object image directory.
     */
    static final String objectImageDirectoryTop
      = ozHomePath + File.separator + "objects";

    /**
     * The directory for each access pattern.
     */
    static final String secureDirectory
      = ozHomePath + File.separator + "secure";
    static final String insecureDirectory
      = ozHomePath + File.separator + "insecure";
    static final String insecureOutDirectory
      = insecureDirectory + File.separator + "out";

    /**
     * A resolver location file.
     */
    static final String resolverLocationFile
      = ozHomePath + File.separator + ".resolver";

    /**
     * The list file name of available commands.
     */
    static final String availableCommandsFileName
      = secureDirectory + File.separator + "availableCommands";

    /**
     * The available external commands
     */
    private Dictionary commandTable = new Hashtable();

    /**
     * The sub-process execution confirmer.
     */
    private OzExecutionConfirmer executionConfirmer;

    /**
     * The default constructor.
     */
    ExSecurityManager() {
	initCommandTable();
	greeting();
    }

    private void greeting() {
	syslog("greeting", CN+" is ready.");
    }

    /**
     * Takes a log to the executor log file.
     *
     * @param	method
     *		method name
     * @param	message
     *		Message to be logged.
     */
    private void syslog(String method, String message) {
	if (Executor.stdlog != null) {
	    Executor.syslog(CN, method, message, null);
	} else {
	    System.out.println(message);
	}
    }

    /**
     * The constructor with creation of runtime sub-process execution
     * confirmer.
     *
     * @param	className
     *		The class name of execution confirmer.
     * @exception	java.lang.NoClassDefFoundError
     *		The specified class name is not a system class.
     * @exception	java.lang.InstantiationError.
     *		The specified class does not implement the OzUserSecurity.
     */
    ExSecurityManager(String className) {
	try {
	    executionConfirmer = initExecutionConfirmer(className);
	} catch (Error e) {
	    syslog(CN, "Cannot set external command confirmer. exiting.");
	    throw e;
	}
	initCommandTable();
    }

    /**
     * Set the external command confirmer.
     *
     * @param	className
     *		The class name of execution confirmer.
     * @exception	java.lang.NoClassDefFoundError
     *		The specified class name is not a system class.
     * @exception	java.lang.InstantiationError.
     *		The specified class does not implement the OzUserSecurity.
     */
    private OzExecutionConfirmer initExecutionConfirmer(String className) {
	ExCodePath codePath = new ExCodePath(className);
	if (codePath.isUserClass()) {
	    throw new NoClassDefFoundError(className);
	} else {
	    try {
		Object obj = Class.forName(className).newInstance();
		if (! (obj instanceof OzExecutionConfirmer)) {
		    throw new InstantiationError(className);
		} else {
		    return (OzExecutionConfirmer)obj;
		}
	    } catch (ClassNotFoundException e) {
		throw new NoClassDefFoundError(className);
	    } catch (InstantiationException e) {
		throw new InstantiationError(className);
	    } catch (IllegalAccessException e) {
		throw new IllegalAccessError(className);
	    }
	}
    }

    /**
     * Initialize the available command table.
     */
    private
    void initCommandTable()
    {
	try {
	    File file = new File(availableCommandsFileName);
	    if (file.exists()) {
		Reader fin = new BufferedReader(new FileReader(file));
		parseAvailableCommands(fin);
		fin.close();
	    }
	} catch (IOException e) {
	    if (Executor.stdlog != null) {
		Executor.syslog(CN, "initCommandTable",
				"Input error in reading "+availableCommandsFileName,
				null);
	    }
	}
    }

    /**
     * Parse an InputStream to put a available command to the table.
     * <P>
     * <DL>
     * <DT>File format for list of external commands which can be executed safely.
     * <DD>
     * <UL>
     * <LI>A command name is inputed without a sign separated lines.
     * <LI>A sign separated lines is delimiter of command names.
     * <LI>A empty line is ignored.
     * <LI>A command started with # is not registerd to table.(only for debug and test)
     * </UL>
     * </DL>
     *
     * @param	in
     *		The Reader to be parsed.
     */
    private
    void parseAvailableCommands(Reader in)
    throws IOException
    {
	char[] cbuf = new char[1];
	String lineSeparator = System.getProperty("line.separator");
	int lineSeparatorLength = lineSeparator.length();
	StringBuffer buffer = new StringBuffer();
	int nextMatch = 0;
	while (0 < in.read(cbuf)) {
	    buffer.append(cbuf);
	    if (cbuf[0] == lineSeparator.charAt(nextMatch)) {
		++ nextMatch;
	    } else {
		nextMatch = 0;
	    }
	    if (nextMatch == lineSeparatorLength) {
		buffer.setLength(buffer.length()-lineSeparatorLength);
		String cmd = new String(buffer);
		if (cmd.length() != 0 && !cmd.startsWith("#")) {
		    commandTable.put(cmd, new Object());
		}
		buffer = new StringBuffer(); // clear buffer
		nextMatch = 0;
	    }
	}
    }

    /**
     * Returns the color of the current process.
     */
    private boolean currentProcessColor() {
	Thread t = Thread.currentThread();
	if (! (t instanceof ExThread)) {
	    return RED;
	} else {
	    return ((ExThread)t).color;
	}
    }

    /**
     * Returns the absolute path of the GOD with current cell.
     */
    private
    String currentAbsolutePathGOD()
    {
	try {
	    ExCell cell = ExCell.currentCell();
	    ExGOD god = new ExGOD(cell);
	    return god.getAbsolutePath();
	} catch (Exception e) {
	    syslog("currentAbsolutePathGOD","Current thread group is not cell.");
	}
	return objectImageDirectoryTop;
    }

    /**
     * Sets a user security object for a cell.  If the setting process is a
     * green process, the specified user security object is set.
     *
     * @exception	java.lang.SecurityException
     *		User security objects cannot set twice for a cell.
     */
    void setUserSecurity(ExCell cell, OzUserSecurity userSecurity) {
	if (currentProcessColor() != GREEN) {
	    String message
	      = "A red process cannot set a user security object.";
	    syslog("setUserSecurity", message);
	    throw new SecurityException(message);
	}
	if (cell.getUserSecurity() != null) {
	    String message = "User security object has already set";
	    syslog("setUserSecurity", message);
	    throw new SecurityException(message);
	}
	cell.setUserSecurity(userSecurity);
    }

    /**
     * Removes a user security object for a cell.  If no security object is
     * set to the cell, nothing happened.  This method is called only from the
     * executor code, when the cell is released.
     *
     * @param	cell
     *		The cell to be removed.
     */
    void removeUserSecurity(ExCell cell) {
	cell.setUserSecurity(null);
    }

    /**
     * Returns true if an executor class (i.e., a class whose package is
     * JP.go.ipa.oz.system) is the originator of the action which caused this
     * security check.  That is, confirms that there is an executor class in
     * the class context before any class which is loaded by a ClassLoader.
     *
     * @return
     *		true if the action originator is an executor class.
     */
    private boolean inExecutor() {
	int classLoaderDepth = classLoaderDepth();
	if (classLoaderDepth < 0) {
	    return true;
	}
	Class[] classes = getClassContext();
	// classes[0] is always ExSecurityManager itself.
	return classes[classLoaderDepth-1].getName().startsWith(Executor.IPAozSystem);
    }

    /**
     * Returns true if the specified class is the originator of the action
     * which caused this security check.  That is, confirms that there is the
     * specified class in the class context before any class which is loaded
     * by a ClassLoader.
     *
     * @param	className
     *		The assumed class name.
     * @return
     *		true if the action originator is the specified class.
     */
    private
    boolean inSystemClass(String className)
    {
	int classLoaderDepth = classLoaderDepth();
	if (classLoaderDepth < 0) {
	    return true;
	}
	Class[] classes = getClassContext();
	// classes[0] is always ExSecurityManager itself.
	for (int i = 1; i < classLoaderDepth; i ++) {
	    Class c = classes[i];
	    do {
		if (className.equals(c.getName())) {
		    return true;
		}
	    } while ((c = c.getSuperclass()) != null);
	}
	return false;
    }

    /**
     * Checks whether accepting a socket is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		with confirmation.
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	host
     *		The host name to accept.
     * @param	port
     *		The protocol port to accept.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkAccept(String host, int port) {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmAccept(host, port);
	    }
	} else {
	    String message = "A red process cannot accept a socket: ";
	    syslog("checkAccept", message);
	    throw new SecurityException(message + host + ":" + port);
	}
    }

    /**
     * Checks whether accessing to the specified thread is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	t
     *		The thread.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkAccess(Thread t) {
        int classLoaderDepth = classLoaderDepth();
        if (classLoaderDepth < 0) {
            return;
        }
        Class[] classes = getClassContext();
        // classes[0] is always ExSecurityManager itself.
        if (classes[classLoaderDepth - 1] != Thread.class
	    && classes[classLoaderDepth - 1] != ThreadGroup.class) {
            return;
	}
	if (currentProcessColor() == GREEN) {
            return;
	}
	String message = "Red thread cannot access a thread: " + t;
	syslog("checkAccess", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether accessing to the specified thread group is permitted or
     * not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	g
     *		The thread group.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkAccess(ThreadGroup g) {
        int classLoaderDepth = classLoaderDepth();
        if (classLoaderDepth < 0) {
            return;
        }
        Class[] classes = getClassContext();
        // classes[0] is always ExSecurityManager itself.
        if (classes[classLoaderDepth - 1] != Thread.class
	    && classes[classLoaderDepth - 1] != ThreadGroup.class) {
            return;
	}
	if (currentProcessColor() == GREEN) {
            return;
	}
	String message = "Red thread cannot access a thread group: " + g;
	syslog("checkAccess", message);
	throw new SecurityException(message);
    }

    /**
     * A client isn't allowed to access to the AWT event queue.
     */
    public
    void checkAwtEventQueueAccess()
    {
	String message = " A client isn't allowed to access to the AWT event queue.";
	syslog("checkAwtEventQueueAccess", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether connecting to the specified socket is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	host
     *		The host name of the socket.
     * @param	port
     *		The port number of the socket.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkConnect(String host, int port) {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmConnect(host, port);
	    }
	} else {
	    String message
	      = "A red process cannot connect to a socket: "
		+ host + ":" + port;
	    syslog("checkConnect", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether connecting to the specified socket is permitted or not
     * both in the current context and the specified context.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     * Because there is no way to investigate the given context.
     *
     * @param	host
     *		The host name of the socket.
     * @param	port
     *		The port number of the socket.
     * @param	context
     *		The security context.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkConnect(String host, int port, Object context) {
	if (inExecutor()) {
	    return;
	}
	String message = "Cannot check the security context: " + context;
	syslog("checkConnect", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether a ClassLoader can be created or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkCreateClassLoader() {
	if (inExecutor()) {
	    return;
	}
	String message = "A user code cannot create a class loader";
	syslog("checkCreateClassLoader", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether deleting the specified file is permitted.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited for:
     *        <UL>
     *          <LI> a file outside of the OZHOME,
     *     	<LI> a file prefixed by a `.' which is in the object image
     *		     directory and
     *		<LI> a file in the $OZHOME/secure directory.
     *        </UL>
     *	      Otherwise with confirmation.
     *   <LI> Red process<BR>		with confirmation only for:
     *        <UL>
     *		<LI> a file in the $OZHOME/insecure/out directory.
     *        </UL>
     *	      Otherwise prohibited.
     * </UL>
     *
     * @param	file
     *		The file name.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkDelete(String fileName) {
	if (inExecutor()) {
	    return;
	}
	File file = new File(fileName);
	String path = file.getAbsolutePath();
	if (currentProcessColor() == GREEN) {
	    if (! path.startsWith(ozHomePath)) {
		String message
		  = "Files outside of the OZHOME cannot be removed: "
		    + fileName;
		syslog("checkDelete", message);
		throw new SecurityException(message);
	    } else if (path.startsWith(objectImageDirectoryTop) &&
		       file.getName().startsWith(".")) {
	      if(inSystemClass(ExCell.class.getName()))	
		{ /* ExCell can delete object image file */
		  return;
		}

		String message
		  = "Files starts with `.' cannot be removed: " + fileName;
		syslog("checkDelete", message);
		throw new SecurityException(message);
	    } else if (path.startsWith(secureDirectory)) {
		String message
		  = "Files in secure directory cannot be removed: " + fileName;
		syslog("checkDelete", message);
		throw new SecurityException(message);
	    }
	} else {
	    if (! path.startsWith(insecureOutDirectory)) {
		String message
		  = "Files outside of insecure out directory "
		    + "cannot be remove by a red process: " + fileName;
		syslog("checkDelete", message);
		throw new SecurityException(message);
	    }
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmDelete(fileName);
	}
    }

    /**
     * Checks whether the specified command is permitted to use.
     *
     * @params	cmd
     *		The command to be executed.
     * @return
     *		true if the specified command is permitted to use.
     */
    private
    boolean isPermittedCommand(String cmd)
    {
	return (commandTable != null && commandTable.get(cmd) != null) ;
    }

    /**
     * Checks whether the specified
     */
    private void checkRuntimeConfirmableCommand(String cmd) {
	if (executionConfirmer != null) {
	    executionConfirmer.confirmExecution(cmd);
	    commandTable.put(cmd, new Object());
	} else {
	    String message = "Execution not permitted: " + cmd;
	    syslog("checkRuntimeConfirmableCommand", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether executing the specified process is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		First, the command table is searched
     *					to see if the command is permitted to
     *					use.  If not, confirmation by
     *					runtime execution confirmer is
     *					required.  If permitted, confirmation
     *					by user security object is required.
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	cmd
     *		The command to be executed.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkExec(String cmd) {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == GREEN) {
	    if (! isPermittedCommand(cmd)) {
		checkRuntimeConfirmableCommand(cmd);
	    }
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmExec(cmd);
	    }
	} else {
	    String message = "A red process cannot execute command: " + cmd;
	    syslog("checkExec", message);
	    throw new SecurityException(message);
	}
    //syslog("checkExec", "Not available to test");
    }

    /**
     * Checks whether exiting Java VM is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	status
     *		The exit status.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkExit(int status) {
	if (inExecutor()) {
	    return;
	}
	String message = "Cannot terminate the executor directly";
	syslog("checkExit", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether linking dynamic library is permitted or not.
     * Only system classes can link dynamic library.
     *
     * @param	lib
     *		the name of the library
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkLink(String lib) {
	Class[] classes = getClassContext();
	/* classes[0] is always ExSecurityManager itself.
	   classes[1] is always Runtime#load or Runtime#loadLibrary */
	if (new ExCodePath(classes[2].getName()).isUserClass()) {
	    String message = "No user library can link";
	    syslog("checkLink", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether listening a port is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	port
     *		the local port
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkListen(int port) {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmListen(port);
	    }
	} else {
	    String message = "A red process cannot listen a port: " + port;
	    syslog("checkListen", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Always allow a client to access members.
     */
    public
    void checkMemberAccess(Class clazz, int which)
    {
    	return;
    }

    /**
     * A client isn't allowed to use (join/leave/send/receive) IP multicast.
     */
    public
    void checkMulticast(InetAddress maddr)
    {
	String message = "A client isn't allowed to use (join/leave/send/receive) IP multicast.";
	syslog("checkMulticast", message);
	throw new SecurityException(message);
    }

    /**
     * A client isn't allowed to use (join/leave/send/receive) IP multicast.
     */
    public
    void checkMulticast(InetAddress maddr, byte ttl)
    {
	String message = "A client isn't allowed to use (join/leave/send/receive) IP multicast.";
	syslog("checkMulticast", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether using the specified package in a user class is permitted
     * or not.  Since there is no restriction to use any classes in OZ system,
     * this checking is not called from the ClassLoader of OZ.
     *
     * @param	package
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkPackageAccess(String packageName) {
	super.checkPackageAccess(packageName);
    }

    /**
     * A client isn't allowed to initiate a print job request.
     */
    public
    void checkPrintJobAccess()
    {
	String message = "A client isn't allowed to initiate a print job request.";
	syslog("checkPrintJobAccess", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether defining a class in the specified package by a user
     * class is permitted or not.  The ClassLoader of OZ is designed not to
     * load non-user class from network, this checking is not required.
     *
     * @param	package
     * @exception	java.lang.SecurityException
     * 		Security error has occurred.
     */
    public void checkPackageDefinition(String packageName) {
	super.checkPackageDefinition(packageName);
    }

    /**
     * Checks whether accessing to the entire system properties is permitted
     * or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkPropertiesAccess() {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmPropertiesAccess();
	    }
	} else {
	    String message
	      = "A red process cannot access to system properties";
	    syslog("checkPropertiesAccess", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether accessing to a system property is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	key
     *		The property key.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkPropertyAccess(String key) {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmPropertyAccess(key);
	    }
	} else {
	    String message
	      = "A red process cannot access to a system property";
	    syslog("checkPropertyAccess", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether reading from the specified file descriptor is permitted
     * or not.  This method is called from
     * java.io.FileInputStream(FileDescriptor) which is used in
     * java.lang.UNIXProcess(String[], String[]) and
     * java.net.SocketInputStream(SocketImpl), other than the executor
     * classes.  The two methods must be checked prior to open the
     * FileInputStream because they are dangerous operations: to execute an
     * external process and to open a socket.  Thus, if this method is called
     * in the two method, it means the security check is already passed.
     *
     * Therefore, if one of the two classes is in the class context, it is
     * permitted.  Otherwise:
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	fd
     *		The file descriptor.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkRead(FileDescriptor fd) {
	if (inExecutor()) {
	    return;
	}
	if (inSystemClass(java.lang.Process.class.getName())
	    || inSystemClass("java.net.SocketInputStream")) {
	    return;
	}
	String message
	  = "A user code cannot open stream by FileDescriptor: " + fd;
	syslog("checkRead", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether reading from the specified file is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		with confirmation only for:
     *        <UL>
     *		<LI> files in $OZHOME/insecure and its descendent directories
     *   	<LI> $OZHOME/.resolver file
     *	      </UL>
     * </UL>
     *
     * @param	file
     *		The file name.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkRead(String fileName) {
	if (inExecutor()) {
	    return;
	}
	if (currentProcessColor() == RED) {
	    File file = new File(fileName);
	    String path = shrinkPath(file.getAbsolutePath());
	    if (! (path.startsWith(insecureDirectory)
		   || path.equals(resolverLocationFile))) {
		String message
		  = "A red process cannot read files other than "
		    + "several specified files: " + fileName;
		syslog("checkRead", message);
		throw new SecurityException(message);
	    }
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmRead(fileName);
	}
    }

    /**
     * If the path string includes a reference to the parent directory,
     * resolve it and returns shrinked path.
     */
    private String shrinkPath(String arg) {
	String path = arg;
	int i = path.lastIndexOf(File.separator);
	int count = 0;
	String ret = path.substring(i + File.separator.length());
	String segment = null;
	while (i >= 0) {
	    path = path.substring(0, i);
	    i = path.lastIndexOf(File.separator);
	    segment = path.substring(i + File.separator.length());
	    if (segment.equals("..")) {
		count ++;
	    } else {
		if (count > 0) {
		    count --;
		} else {
		    ret = segment + File.separator + ret;
		}
	    }
	}
	if (count >= 0) {
	    if (arg.startsWith(File.separator) &&
		! ret.startsWith(File.separator)) {
		ret = File.separator + ret;
	    } else {
		for (i = 0; i < count; i ++) {
		    ret = ".." + File.separator + ret;
		}
	    }
	}
	return ret;
    }

    /**
     * Checks whether reading from the specified file is permitted or not
     * under specified security context.  No method in the JDK API call this
     * method.  Basically prohibited, because there is no way to investigate
     * the given context.
     * 
     * @param	file
     *		The file name.
     * @param	context
     *		The security context.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkRead(String file, Object context) {
	String message = "Cannot check the security context: " + context;
	syslog("checkRead", message);
	throw new SecurityException(message);
    }

    /**
     * A client isn't allowed to access to certaion operations for a security API action.
     */
    public
    void checkSecurityAccess(String action)
    {
	String message = "A client isn't allowed to access to certaion operations for a security API action.";
	syslog("checkSecurityAccess", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether a socket factory can be set or not.  This method is
     * called when the ServerSocket#setSocketFactory,
     * Socket#setSocketImplFactory or URL#setURLStreamHandlerFactory is
     * called.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkSetFactory() {
	if (inExecutor()) {
	    return;
	}
	String message = "A user code cannot set socket/URL factory";
	syslog("checkSetFactory", message);
	throw new SecurityException(message);
    }

    /**
     * A client isn't allowed to access to the system clipboard.
     */
    public
    void checkSystemClipboardAccess()
    {
	String message = "A client isn't allowed to access to the system clipboard.";
	syslog("checkSecurityAccess", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether the creation of a top level window is trusted or not.
     * <UL>
     *   <LI> Executor class<BR>	trusted
     *   <LI> Green process<BR>		untrusted
     *   <LI> Red process<BR>		untrusted
     * </UL>
     * As opposed to the other checking command, checkTopLevelWindow does not
     * throw SecurityException.  It only returns false to indicate that the
     * top level window should not be trusted.
     *
     * @param	window
     *		The new window that is being created.
     * @return
     *		true if the caller is trusted to put up top-level windows;
     *		false otherwise.
     */
    public boolean checkTopLevelWindow(Object window) {
	return (currentProcessColor() == GREEN);
    }

    /**
     * Checks whether writing to the specified file descriptor is permitted or 
     * not.  This method is called from
     * java.io.FileOutputStream(FileDescriptor) which is used in
     * java.lang.UNIXProcess(String[], String[]) and
     * java.net.SocketOutputStream(SocketImpl), other than the executor
     * classes.  The latter two methods must be checked prior to open the
     * FileOutputStream because they are dangerous operations: to execute an
     * external process and to open a socket.  Thus, if this method is called
     * in the two method, it means the security check is already passed.
     *
     * Therefore, if one of the two classes is in the class context, it is
     * permitted.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		prohibited
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	fd
     *		The file descriptor
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkWrite(FileDescriptor fd) {
	if (inExecutor()) {
	    return;
	}
	if (inSystemClass(java.lang.Process.class.getName())
	    || inSystemClass("java.net.SocketOutputStream")) {
	    return;
	}
	String message
	  = "A user code cannot open stream by FileDescriptor: " + fd;
	syslog("checkWrite", message);
	throw new SecurityException(message);
    }

    /**
     * Checks whether writing to the specified file is permitted or not.
     * <UL>
     *   <LI> Executor class<BR>	permitted
     *   <LI> Green process<BR>		creating a new file is permitted with
     *				        confirmation.<BR>
     *					while prohibited to override:
     *        <UL>
     *		<LI> a file outside of the OZHOME,
     *       	<LI> a file prefixed by a `.' which is in the object image
     *		     directory (ExCell class is exclusively permitted to 
     *               write files in the object image directory)
     *		<LI> a file in the $OZHOME/secure directory,
     *	      </UL>
     *	      Otherwise, with confirmation.
     *   <LI> Red process<BR>		with confirmation only for:
     *	      <UL>
     *		<LI> a file in insecure out directory.
     *	      </UL>
     * </UL>
     *
     * @param	file
     *		The file name.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    public void checkWrite(String fileName) {
	if (inExecutor()) {
	    return;
	}
	File file = new File(fileName);
	String path = shrinkPath(file.getAbsolutePath());
	if (currentProcessColor() == GREEN) {
	    if (file.exists())
	      {
		if(! path.startsWith(ozHomePath)
		   || path.startsWith(secureDirectory)) {
		  String message
		    = "A green process cannot write to this file: " + fileName;
		  syslog("checkWrite", message);
		  throw new SecurityException(message);
		}
		else if(path.startsWith(objectImageDirectoryTop)
			&& file.getName().charAt(0) == '.')
		  {
		    if(inSystemClass(ExCell.class.getName()))
		      {
			/* ExCell exclusively can handle object image file */
			return;
		      }
		    else
		      {
			String message
			  = "A green process cannot write to this file: " + fileName;
			syslog("checkWrite", message);
			throw new SecurityException(message);
		      }
		  }
	      }
	    if (path.startsWith(objectImageDirectoryTop)
		&& !path.startsWith(currentAbsolutePathGOD())) {
	      String message
		= "A process cannot write to this file: " + fileName;
	      syslog("checkWrite", message);
	      throw new SecurityException(message);
	    }
	} else {
	    if (! path.startsWith(insecureOutDirectory)) {
		String message
		  = "A red process cannot write outside of "
		    + "$OZHOME/insecure/out directory: " + fileName;
		syslog("checkWrite", message);
		throw new SecurityException(message);
	    }
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmWrite(fileName);
	}
    }

    /**
     * Checks whether creating a global object is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	codePath
     *		The name of the class to be instantiated.
     * @param	proxy
     *		The proxy object which has the GOL.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryNewGlobalObject(String codePath, OzProxy proxy) {
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmNewGlobalObject(proxy);
	    }
	} else {
	    String message
	      = "A red process cannot create a global object: " + proxy;
	    syslog("tryNewGlobalObject", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether starting a global object is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	proxy
     *		The proxy object which has the GOL.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryGoGlobalObject(OzProxy proxy) {
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmGoGlobalObject(proxy);
	    }
	} else {
	    String message
	      = "A red process cannot start a global object: " + proxy;
	    syslog("tryGoGlobalObject", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether stopping a global object is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	proxy
     *		The proxy object which has the GOL.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryStopGlobalObject(OzProxy proxy) {
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmStopGlobalObject(proxy);
	    }
	} else {
	    String message
	      = "A red process cannot stop a global object: " + proxy;
	    syslog("tryStopGlobalObject", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether removing a global object is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		with confirmation
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	proxy
     *		The proxy object which has the GOL.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryRemoveGlobalObject(OzProxy proxy) {
	if (currentProcessColor() == GREEN) {
	    OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	    if (us != null) {
		us.confirmRemoveGlobalObject(proxy);
	    }
	} else {
	    String message
	      = "A red process cannot remove a global object: " + proxy;
	    syslog("tryRemoveGlobalObject", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether accessing argument count given by the executor command.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryGetArguments()
    {
	if (currentProcessColor() == RED) {
	    String message
	      = "A red process cannot access command line arguments";
	    syslog("tryGetArgc", message);
	    throw new SecurityException(message);
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmGetArguments();
	}
    }

    /**
     * Checks whether accessing an stdin of the Java VM is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryGetStdin() {
	if (currentProcessColor() == RED) {
	    String message = "A red process cannot access standard input";
	    syslog("tryGetStdin", message);
	    throw new SecurityException(message);
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmGetStdin();
	}
    }

    /**
     * Checks whether accessing an stdout of the Java VM is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryGetStdout() {
	if (currentProcessColor() == RED) {
	    String message = "A red process cannot access standard output";
	    syslog("tryGetStdout", message);
	    throw new SecurityException(message);
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmGetStdout();
	}
    }

    /**
     * Checks whether accessing an stderr of the Java VM is permitted or not.
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryGetStderr() {
	if (currentProcessColor() == RED) {
	    String message = "A red process cannot access standard error";
	    syslog("tryGetStderr", message);
	    throw new SecurityException(message);
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmGetStderr();
	}
    }

    /**
     * Checks whether reading a class file is permitted or not
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		permitted only for released user class 
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryClassFileRead(ExCodePath codePath) {
	if (classLoaderDepth() < 0) {
	    return;
	}
	Class[] classes = getClassContext();
	// classes[0] is always ExSecurityManager itself.
	// classes[1] is always OzClassFile.
	if (classes.length >= 2) {
	    String className = classes[2].getName();
	    if (className.equals(ExClassLoader.class.getName())) {
		return;
	    }
	}
	if (currentProcessColor() == RED
	    && ! codePath.isReleasedUserClass()) {
	    String message
	      = "A red process cannot read a class file "
		+ "other than released user class: " + codePath;
	    syslog("tryClassFileRead", message);
	    throw new SecurityException(message);
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmCheckClassFileRead(codePath.getPath());
	}
    }

    /**
     * Checks whether writing a class file is permitted or not
     * Since this method is called directly from the runtime service, checking 
     * whether this is called in executor code is meaningless.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		prohibited for system class
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryClassFileWrite(ExCodePath codePath) {
	if (currentProcessColor() == GREEN) {
	    if (! codePath.isUserClass()) {
		String message
		  = "A user code cannot modify the system class files: "
		    + codePath;
		syslog("tryClassFileWrite", message);
		throw new SecurityException(message);
	    } else if (codePath.isReleasedUserClass()) {
		String message
		  = "A user code cannot modify the released user class files: "
		    + codePath;
		syslog("tryClassFileWrite", message);
		throw new SecurityException(message);
	    }
	} else {
	    String message
	      = "A red process cannot modify class files: " + codePath;
	    syslog("tryClassFileWrite", message);
	    throw new SecurityException(message);
	}
	OzUserSecurity us = ExCell.currentCell().getUserSecurity();
	if (us != null) {
	    us.confirmCheckClassFileWrite(codePath.getPath());
	}
    }

    /**
     * Checks whether add the specified top package to local repository.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	topPackageName
     *		The package name which is added to local repository.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryLocalRepositoryAdd(String topPackageName)
    {
	if (currentProcessColor() == RED) {
	    String message
	      = "A red process cannot add a top package: " + topPackageName;
	    syslog("tryLocalRepositoryAdd", message);
	    throw new SecurityException(message);
	}
    }

    /**
     * Checks whether add the specified top package to local repository.
     * <UL>
     *   <LI> Executor class<BR>	-
     *   <LI> Green process<BR>		permitted
     *   <LI> Red process<BR>		prohibited
     * </UL>
     *
     * @param	topPackageName
     *		The package name which is removed from local repository.
     * @exception	java.lang.SecurityException
     *		Security error has occurred.
     */
    void tryLocalRepositoryRemove(String topPackageName)
    {
	if (currentProcessColor() == RED) {
	    String message
	      = "A red process cannot remove a top package: " + topPackageName;
	    syslog("tryLocalRepositoryRemove", message);
	    throw new SecurityException(message);
	}
    }

    /* for debug */
    private void showClassContenxt(String tag) {
	Class[] classes = getClassContext();
	OzSystem.getStdout().println("showing class context in " + tag);
	for (int i = 0; i < classes.length; i ++) {
	    OzSystem.getStdout().println(classes[i].getName());
	}
    }

}
