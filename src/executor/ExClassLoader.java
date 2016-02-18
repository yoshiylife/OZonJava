/*
 * $Id$
 */

package JP.go.ipa.oz.system;

import	java.io.DataInputStream;
import	java.io.DataOutputStream;
import	java.io.EOFException;
import	java.io.File;
import	java.io.IOException;
import	java.io.InputStream;
import	java.io.InputStreamReader;
import	java.io.ObjectInputStream;
import	java.io.ObjectOutputStream;
import	java.io.StreamTokenizer;
import	java.lang.reflect.Array;
import	java.lang.reflect.Method;
import	java.lang.reflect.Modifier;
import	java.net.MalformedURLException;
import	java.net.Socket;
import	java.net.URL;
import	java.util.Dictionary;
import	java.util.Enumeration;
import	java.util.Hashtable;

/**
 * ClassLoader of OZ system.
 * Classes are distinguished in three categories here.
 *   o System Classes      (neither verified, nor retrieved over the network)
 *   o Released User Classes              (can be retrieved over the network)
 *   o User Classes under Development                  (other than the above)
 * They can be distinguished by its code path (full qualified class name).
 * Class categories are distinguished in the class ExCodePath.
 * Class searching policy is implemented in the class OzClassFile.
 *
 * This class loader cannot load classes which have native methods or methods
 * named readObject or writeObject.
 *
 * <DL><DT>
 * Note<DD>
 * Protocol 'ozclass' isn't implement with java.net.URL frame work.
 * Becase its implementation is very high cost, but not need that is over specification.
 * </DL>
 *
 * @see ExCodePath
 * @see OzClassFile
 *
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:57 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
final
class ExClassLoader
extends ClassLoader
{
    /**
     * For debug & message
     */
    static final String CN = "ExClassLoader";

    /**
     * Flag for debug
     */
    protected static boolean debug
	= (System.getProperty(ExClassLoader.class.getName()+".debug") != null) ? true : false;

    /**
     * The URL of the class delivery agent.
     */
    private final URL deliveryAgentURL;

    /**
     * The flag is true if OZ original protocol is specified.
     */
    private final boolean ozclass;

    /**
     * Retry max count to download zip file exclude first try.
     */
    private final int deliveryAgentRETRY;

    /**
     * The directory separator used in URL.  System indepent.
     */
    static final char urlDirectorySeparator = '/';

    /*
     * Packet Tags.
     */

    /**
     * Request tag to class delivery agent.
     */
    static final String requestTag = "REQ";

    /**
     * Succees reply tag from class delivery agent.
     */
    static final String successReplyTag = "REP";

    /**
     * Failuer reply tag from class delivery agent.
     */
    static final String failureReplyTag = "NA";

    /**
     * Name of the static initializer.
     */
    static final String staticInitializerName = "<clinit>";

    /**
     * Class cache to maintain consistency: a same Class must be retrieved for 
     * a same code path.
     */
    private final Dictionary classes = new Hashtable();

    private static
    void debug(String methodName, String message)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message);
	    } else {
		Executor.syslog(CN, methodName, message);
	    }
	}
    }

    private static
    void debug(String methodName, Throwable ball)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, ball);
	    } else {
		Executor.syslog(CN, methodName, ball);
	    }
	}
    }

    /**
     * Constructs a new class loader and initializes it.
     * <P>
     * Setup its properties with following system properties or default.
     * <DL>
     * <DT>oz.classloader.deliveryAgent.url
     * <DD> URL string that is requested to delivery class.
     * <DT>oz.classloader.deliveryAgent.retry
     * <DD> Max retry to delivery class for agent.
     * </DL>
     * @exception	SecurityException
     *			You must review the constructor in super class.
     *			Here, this part is ommited for its descriptions.
     * @see	java.lang.ClassLoader()
     */
    protected
    ExClassLoader()
    {
	String value;

	value = System.getProperty("oz.classloader.deliveryAgent.url");
	if (value != null) {
	    try {
		if (value.startsWith("ozclass:")) {
		    deliveryAgentURL = new URL("http" + value.substring(7));
		    ozclass = true;
		} else {
		    deliveryAgentURL = new URL(value);
		    ozclass = false;
		}
	    } catch (Exception e) {
	    	Executor.error(CN, "ExClassLoader", "deliveryAgentURL", e);
		deliveryAgentURL = null;
		ozclass = false;
	    }
	} else {
	    Executor.syslog(CN, "ExClassLoader", "oz.classloader.deliveryAgent.url is null");
	    deliveryAgentURL = null; /* default */
	    ozclass = false;
	}

	value = System.getProperty("oz.classloader.deliveryAgent.retry");
	if (value != null) deliveryAgentRETRY = Integer.parseInt(value);
	else deliveryAgentRETRY = 5; /* default */
    }

    /**
     * Recieve class file from delivery agent.
     *
     * @param	url		The URL for delivery agent
     * @param	codePath	A name of a class which should be retrieved
     *				over the network.
     * @exception	Exception	
     *				fail to recieve class file from delivery agent
     */
    ExClassDelivery protocolOzclass(URL url, String packageName)
    throws Exception
    {
    	debug("protocolOzclass", "(url="+url+",packageName="+packageName+")");
	ExClassDelivery delivery = null;
	Socket s = new Socket(url.getHost(), url.getPort());
	DataOutputStream out = new DataOutputStream(s.getOutputStream());
	DataInputStream in = new DataInputStream(s.getInputStream());
    	try {
	    out.writeUTF(requestTag);
	    out.writeUTF(packageName);
	    String answer = in.readUTF();
	    if (answer.equals(successReplyTag)) {
		answer = in.readUTF();
		if (answer.equals(packageName)) {
		    String topPackageName = in.readUTF();
		    long length = (long)in.readInt();
		    delivery = new ExClassDelivery(topPackageName, in, length);
		}
	    } else if (answer.equals(failureReplyTag)) {
		answer = in.readUTF();
		if (answer.equals(packageName)) {
		    Executor.syslog(CN, "protocolOzclass", "Not found by delivery agent: " + packageName);
		    throw new ClassNotFoundException(packageName);
		}
	    } else {
		String message = "Malformed answer from delivery agent (" + answer + ").";
		Executor.error(CN, "protocolOzclass", message);
		throw new ExException(message);
	    }
	} catch (Exception e) {
	    out.close();
	    in.close();
	    s.close();
	    throw e;
	} finally {
	    // Don't close 'out', using 'in' at ExClassDelivery.
	}
	return delivery;
    }

    void skipStartTag(StreamTokenizer s)
    throws IOException
    {
	int ttype;

	while ((ttype = s.nextToken()) != StreamTokenizer.TT_EOF) {
	    switch (ttype) {
	      case '<':
		if (s.nextToken() == '!'
		    && s.nextToken() == '-'
		    && s.nextToken() == '-'
		    && s.nextToken() == StreamTokenizer.TT_WORD
		    && s.sval.equals("Listings")
		    && s.nextToken() == StreamTokenizer.TT_WORD
		    && s.sval.equals("Start")
		    && s.nextToken() == '-'
		    && s.nextToken() == '-'
		    && s.nextToken() == '>') {
		    return;
		}
		break;
	      default:
		break;
	    }
	}
	throw new EOFException();
    }

    String parsePathName(StreamTokenizer s)
    throws IOException
    {
	switch (s.ttype) {
	  case '"':
	    return s.sval;
	  case '<':
	    /*
	     * tentative implementation:
	     * all tags are regarded as a ENDTAG
	     */
	    return null;
	  default:
	    String message
	      = "syntax error at line " + s.lineno()
		+ ": a path name expected near " + s.toString();
	    throw new IOException(message);
	}
    }

    Integer parseLength(StreamTokenizer s)
    throws IOException
    {
	switch (s.ttype) {
	  case s.TT_NUMBER:
	    return new Integer((int)s.nval);
	  default:
	    String message
	      = "syntax error at line " + s.lineno()
		+ ": a length expected near " + s.toString();
	    throw new IOException(message);
	}
    }

    Dictionary makeTable(URL url)
    throws Exception
    {
	InputStream in = null;
    	try {
	    in = url.openStream();
	    StreamTokenizer s = new StreamTokenizer(new InputStreamReader(in));
	    s.parseNumbers();
	    skipStartTag(s);
	    int ttype;
	    /*
	     * state:    0 ... initial state
	     *           1 ... a path name has been read
	     */
	    int state = 0;
	    String path = null;
	    Dictionary table = new Hashtable();
	    while ((ttype = s.nextToken()) != s.TT_EOF) {
		if ((path = parsePathName(s)) == null) {
		    return table;
		} else {
		    if ((ttype = s.nextToken()) == s.TT_EOF) {
			break;
		    } else {
			table.put(path, parseLength(s));
		    }
		}
	    }
	    throw new EOFException();
	} catch (Exception e) {
	    String message = "Can't make index table for " + url;
	    Executor.error(CN, "makeTable", message, e);
	    throw new ExException(message);
	} finally {
	    if (in != null) in.close();
	}
    }

    URL makeURL(URL url, String file)
    throws MalformedURLException
    {
	String orig = url.getFile();
	String head = orig.substring(0, orig.lastIndexOf(urlDirectorySeparator) + 1);
	String newFile = head.concat(file);
	return new URL(url.getProtocol(), url.getHost(), url.getPort(), newFile);
    }

    /**
     * Recieve class file from www server.
     *
     * @param	index		The URL of listing class file for www server
     * @param	codePath	A name of a class which should be retrieved
     *				over the network.
     * @exception	Exception	
     *				fail to recieve class file from www server
     */
    ExClassDelivery protocolOther(URL index, String packageName)
    throws Exception
    {
    	debug("protocolOther", "(index="+index+",packageName="+packageName+")");
	Dictionary table = makeTable(index);
	String topPackageName = packageName;
	while (topPackageName.startsWith(ExCodePath.ReleasedUserClassPackage)) {
	    String fileName = topPackageName.replace('.', urlDirectorySeparator)+".zip";
	    Integer length = (Integer)table.get(fileName);
	    if (length != null) {
		URL url = makeURL(index, fileName);
		return new ExClassDelivery(topPackageName, url.openStream(), length.longValue());
	    }
	    topPackageName = topPackageName.substring(0, topPackageName.lastIndexOf('.'));
	}
	Executor.syslog(CN, "protocolOther", "Not found file included "+packageName);
	throw new ClassNotFoundException(packageName);
    }

    /**
     * Contacts the class delivery agent of this OZ home to get a class.
     * This method is called when a released class couldn't be found in local.
     *
     * @param	packageName	A name of package for a class which should be retrieved
     *				over the network.
     * @exception	ClassNotFoundException
     *			Can't delivery class file from a agnet, but don't retry.
     * @exception	ExException
     *			Can't delivery class file from a agnet.
     */
    void callDeliveryAgent(String packageName)
    throws ClassNotFoundException, ExException
    {
    	try {
	    ExClassDelivery delivery;
	    if (ozclass) {
		delivery = protocolOzclass(deliveryAgentURL, packageName);
	    } else {
		delivery = protocolOther(deliveryAgentURL, packageName);
	    }
	    ExZipFile zipFile = OzLocalRepositoryManager.load(delivery);
	    String message;
	    if (zipFile == null) {
		message = packageName+" is not found.";
	    } else {
		if (delivery.isTransfered()) {
		    message = packageName+" is transfered with "+zipFile.getName();
		} else {
		    message = packageName+" is already transfered with "+zipFile.getName();
		}
	    }
	    Executor.syslog(CN, "callDeliveryAgent", message);
	    delivery.close();
	} catch (SecurityException e) {
	    throw e;
	} catch (ClassNotFoundException e) {
	    throw e;
	} catch (Exception e) {
	    Executor.error(CN, "callDeliveryAgent", packageName+" from "+deliveryAgentURL, e);
	    throw new ExException(packageName);
	}
    }

    /**
     * Reads a file content into a byte array.
     *
     * @param	classFile
     *		The file to be read.
     * @return
     *		The file content.
     * @exception	java.lang.ClassNotFoundException
     *		Either the file is too large (beyond Integer.MAX_VALUE),
     *		or the file cannot be read for some reason.
     */
    byte[] getContents(OzClassFile classFile)
    throws ClassNotFoundException
    {
	long len = classFile.length();
	if (len > Integer.MAX_VALUE) {
	    String message = classFile + ": class file too large (" + len + ")";
	    Executor.error(CN, "getContents", message);
	    throw new ClassNotFoundException(classFile.getCodePath());
	}

	byte[] buffer = new byte[(int)len];
	InputStream in = null;
	try {
	    in = classFile.getInputStream();
	    in.read(buffer);
	} catch (Exception e) {
	    Executor.error(CN, "getContents", "("+classFile+")", e);
	    throw new ClassNotFoundException(classFile.getCodePath());
	} finally {
	    if (in != null) {
		try {
		    in.close();
		} catch (Exception e) {
		    Executor.error(CN, "getContents", e);
		}
	    }
	}
	return buffer;
    }

    /**
     * Define class object.
     * Do not regist the class object to class object table: classes.
     *
     * @param	codePath
     *		The code path (fully qualified name) of the required class.
     * @return
     *		The defined Class.
     * @exception	java.lang.ClassNotFoundException
     *		Can't define the class.
     */
    Class defineClass(ExCodePath codePath)
    throws ClassNotFoundException, ExException
    {
	debug("defineClass", codePath.getName());
	if (codePath.isArrayClass()) {
	    Class baseType = loadClass(codePath.getBasePath(),false);
	    int demensions[] = new int[codePath.getDimension()];
	    for (int i = demensions.length-1; 0 <= i; i --) demensions[i] = 1;
	    return Array.newInstance(baseType,demensions).getClass();
	} else {
	    String fileName = codePath.getName() + ".class";
	    OzClassFile classFile = OzClassFile.search(codePath.getPath(), fileName);
	    if (classFile == null && codePath.isReleasedUserClass()) {
		if (deliveryAgentURL == null) {
		    throw new ClassNotFoundException(codePath.getPath());
		}
		String packageName = codePath.getParent();
		ExZipFile zipFile = OzLocalRepositoryManager.find(packageName);
		if (zipFile != null) {
		    throw new ClassNotFoundException(codePath.getPath());
		}
		callDeliveryAgent(packageName);
		classFile = OzClassFile.search(codePath.getPath(), fileName);
	    }
	    if (classFile != null) {
		try {
		    byte[] b = getContents(classFile);
		    checkStaticInitializer(b);
		    Class c = defineClass(codePath.getPath(), b, 0, b.length);
		    verifyCode(c);
		    return c;
		} catch (ClassNotFoundException e) {
		    throw new ClassNotFoundException(codePath.getPath()
						     + ":" + e);
		}
	    }
	}
	throw new ClassNotFoundException(codePath.getPath());
    }

    private int readInt(byte[] contents, int off, int len) {
	int value = 0;
	for (int i = 0; i < len; i ++) {
	    value = value * 256 + (0xff & contents[off + i]);
	}
	return value;
    }

    private void checkStaticInitializer(byte[] contents)
    throws ClassNotFoundException {
	int len = contents.length;
	for (int i = 10; i < len; i ++) {
	    if (contents[i] == (byte)'<') {
		if (new String(contents, i, 8).equals(staticInitializerName)) {
		    seekForStaticInitializer(contents);
		    return;
		}
	    }
	}
    }

    private void seekForStaticInitializer(byte[] contents)
    throws ClassNotFoundException {
	int poolCount = readInt(contents, 8, 2);
	int p = 10;
	int index = 0;
	for (int i = 1; i < poolCount; i ++) {
	    int tag = (0xff & contents[p]);
	    p ++;
	    switch (tag) {
	      case 1: // UTF8
		int len = readInt(contents, p, 2);
		p += 2;
		if (new String(contents, p, len).equals(staticInitializerName)) {
		    index = i;
		}
		p += len;
		break;
	      case 3: // integer
	      case 4: // float
	      case 9: // field reference
	      case 10: // method reference
	      case 11: // interface method reference
	      case 12: // name and type
		p += 4;
		break;
	      case 5: // long
	      case 6: // double
		p += 8;
		i ++; // double and long constants occupies two entries
		break;
	      case 7: // class
	      case 8: // String
		p += 2;
		break;
	      default:
		throw new ClassNotFoundException("Unknown constant tag ("
						 + tag + ") at " + (p - 1) +
						 ", index: " + i);
	    }
	}
	if (index == 0) {
	    return;
	}
	p += 6;
	int interfaceCount = readInt(contents, p, 2);
	p += 2;
	p += 2 * interfaceCount;
	int fieldCount = readInt(contents, p, 2);
	p += 2;
	for (int i = 0; i < fieldCount; i ++) {
	    p += 6;
	    int attributeCount = readInt(contents, p, 2);
	    p += 2;
	    for (int j = 0; j < attributeCount; j ++) {
		p += 2;
		int count = readInt(contents, p, 4);
		p += 4 + count;
	    }
	}
	int methodCount = readInt(contents, p, 2);
	p += 2;
	for (int i = 0; i < methodCount; i ++) {
	    p += 2;
	    if (readInt(contents, p, 2) == index) {
		throw new ClassNotFoundException("static initializer found");
	    }
	    p += 4 ;
	    int attributeCount = readInt(contents, p, 2);
	    p += 2;
	    for (int j = 0; j < attributeCount; j ++) {
		p += 2;
		int count = readInt(contents, p, 4);
		p += 4 + count;
	    }
	}
    }

    /**
     * Loads a class.
     *
     * @param	name
     *		The code path (fully qualified name) of the required class.
     * @param	resolve
     *		True if the Class needs to be resolved.
     * @return
     *		The resulting Class.
     * @exception	java.lang.ClassNotFoundException
     *		Cannot find a definition for the class.
     */
    protected
    Class loadClass(String name, boolean resolve)
    throws ClassNotFoundException
    {
	Class c = null;
	ExCodePath codePath = new ExCodePath(name);
	if (codePath.isUserClass()) {
	    debug("loadClass", "loading "+name);
	    for (int retry = 0; /* nothing */; retry ++) {
		Object o = classes.get(name);
		if (o == null) {
		    ExFakeObject current = new ExFakeObject();
		    o = classes.put(name, current);
		    if (o == null) {
		    	try {
			    c = defineClass(codePath);
			    classes.put(name, c);
			    current.ready();
			    debug("loadClass", "defined "+name);
			    break;
			} catch (Exception e) {
			    classes.remove(name);
			    if (e instanceof ClassNotFoundException) {
				debug("loadClass", e);
				current.abort();
				throw (ClassNotFoundException)e; /* Not retry */
			    } else {
				debug("loadClass", e);
				current.ready();
				/* Not throw exception to retry */
			    }
			}
		    } else {
			if (o instanceof ExFakeObject) {
			    debug("loadClass", "waiting to defined "+name);
			    ExFakeObject fake = (ExFakeObject)o;
			    if (fake.await()) {
				current.ready();
			    } else {
				current.abort();
				throw new ClassNotFoundException(name);
			    }
			} else {
			    debug("loadClass", "already defined "+name);
			    classes.put(name, o);
			    current.ready();
			    c = (Class)o;
			    break;
			}
		    }
		} else {
		    if (o instanceof ExFakeObject) {
			debug("loadClass", "wait to defined "+name);
			ExFakeObject fake = (ExFakeObject)o;
			if (! fake.await()) {
			    throw new ClassNotFoundException(name);
			}
		    } else {
			c = (Class)o;
			break;
		    }
		}
		if (deliveryAgentRETRY < retry) {
		    debug("loadClass", "Over retry max("+deliveryAgentRETRY+") "+name);
		    throw new ClassNotFoundException(name);
		}
		if (retry != 0) {
		    Executor.syslog(CN, "loadClass", "Retry["+retry+"/"+deliveryAgentRETRY+"] "+name);
		}
	    }
	    debug("loadClass", "loaded  "+name);
	} else {
	    c = findSystemClass(name);
	}
	if (resolve) {
	    debug("loadClass", "resolve: "+c.getName());
	    resolveClass(c);
	}
	debug("loadClass", "return: "+c.getName());
	return c;
    }

    /**
     * Verifies that a class doesn't have a method which is not allowed to
     * have for OZ classes.
     * Verification will fail if the class has any of the following method:
     * <UL>
     *   <LI> a native method
     *   <LI> a readObject(java.io.ObjectInputStream) method
     *   <LI> a writeObject(java.io.ObjectOutputStream) method
     *   <LI> a static initializer method
     * </UL>
     *
     * @param	c
     *		A class object which should be verified.
     * @exception	java.lang.ClassNotFoundException
     *		Either the class definition cannot be read, or the
     *		verification failed.
     */
    void verifyCode(Class c)
    throws ClassNotFoundException
    {
	/*
	 * Don't must use Class#getDeclaredMethod(String,Class[]),
	 * becase this method will raise NoSuchMethodException usualy.
	 */
	Method methods[] = c.getDeclaredMethods();
	int length = methods.length;
	for (int i = 0; i < length; i ++) {
	    Method method = methods[i];
	    debug("verifyCode", method.toString());
	    if (Modifier.isNative(method.getModifiers())) {
		String message = "Native method found: "+method;
		Executor.syslog(CN, "verifyCode", message);
		if ( System.getSecurityManager() != null) {
		    throw new ClassNotFoundException(message);
		}
	    }
	    Class paramTypes[] = method.getParameterTypes();
	    if (paramTypes.length == 1) {
		String name = method.getName();
		if (name.equals("readObject")) {
		    Class now = paramTypes[0];
		    do {
			if (ObjectInputStream.class == now) {
			    String message = "Method readObject found: "+method;
			    Executor.syslog(CN, "verifyCode", message);
			    if ( System.getSecurityManager() != null) {
				throw new ClassNotFoundException(message);
			    }
			}
		    } while ((now = now.getSuperclass()) != null);
		}
		if (name.equals("writeObject")) {
		    Class now = paramTypes[0];
		    do {
			if (ObjectOutputStream.class == now) {
			    String message = "Method writeObject found: "+method;
			    Executor.syslog(CN, "verifyCode", message);
			    if ( System.getSecurityManager() != null) {
				throw new ClassNotFoundException(message);
			    }
			}
		    } while ((now = now.getSuperclass()) != null);
		}
	    }
	}
    }

    /**
     * Loads a package(class archive file).
     */
    void loadPackage(String packageName)
    throws ClassNotFoundException, ExException
    {
	ExZipFile zipFile = OzLocalRepositoryManager.find(packageName);
	if (zipFile == null) {
	    if (deliveryAgentURL == null) {
		throw new ClassNotFoundException(packageName);
	    }
	    callDeliveryAgent(packageName);
	}
    }
}
