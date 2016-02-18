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
 * $Id: OzClassFile.java,v 2.2 1997/11/07 05:10:58 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

/**
 * A class file of OZ class.
 * `Class file' is a file used by a class.  For example, the file
 * "Object.class" in Java API library is a class file of java.lang.Object.
 * Especially, a class file which contains a class definition of a class is
 * called a `class definition file' of the class.  A class file must be in the 
 * directory where the class definition file of the class located, or one of
 * the descendant directories of it.
 *
 * The class which uses a class file is called the `owner class' of the class
 * file.  
 *
 * A class file can be either a file or a zip file entry.
 *
 * This class implements the class file searching policy of OZ system.  The
 * location of OZ class files are specified as follows:
 * <UL>
 *   <LI> System classes<BR>
 *        System class must be able to be loaded by the premodal class loader.
 *        Thus, the class files of system classes must be in subdirectories of 
 *        one of the CLASSPATH entories.
 *   <LI> Released OZ user classes<BR>
 *        Class files of Released OZ user classes must be an entry of a zip
 *        file located in one of the descendant directories of the lib
 *        diretory of the OZ home.  The zip file is searched in following
 *        manner:
 *        <OL>
 *          <LI> Divides the package path of the class into two portion:
 *               before and after the last `.'.
 *	    <LI> Searches a zip file which is in the directory whose relative
 *               path from the lib directory is same as the package path of
 *               the `before' portion and whose name is same as the `after'
 *               portion follows by an extention `.zip'.
 *          <LI> If such zip file cannot be found, iterate the process by
 *               dividing the `before' part in same manner.
 *        </OL>
 *        For example, class files of a class
 *            JP.go.ipa.oz.user.released.foo.bar.Baz
 *        is contained either
 *            $OZHOME/lib/JP/go/ipa/oz/user/released/foo/bar.zip
 *        or,
 *            $OZHOME/lib/JP/go/ipa/oz/user/released/foo.zip.
 *        If a zip file is found, the class file should be contained in the
 *        zip file, that is, no further search of zip file is needed even if
 *        the entry of the class file cannot be found.  The class file should
 *        be a zip entry whose entry name is same as the following formula:
 *            (the package path of the class)
 *                - {(the directory path where the zip file exists)
 *                   + (the zip file name - ".zip")}
 *	          + (the class file name).
 *        Note that the class file name can include the path separator, which
 *        means that the class file is located at a descendant directory.
 *   <LI> OZ user classes under development<BR>
 *        Class files of OZ user classes under development must be a file
 *        located in one of the descendant directories of the lib directory of
 *        the OZ home.  The directory's relative path from the lib directory
 *        should be same as the package path of the class.  For example, a
 *        class file `figure.jpeg' of a class "JP.go.ipa.oz.user.boo.foo.Woo"
 *        should be at $OZHOME/lib/JP/go/ipa/oz/user/boo/foo/figure.jpeg.
 * </UL>
 *
 * @see ExFileContentHolder
 * @see ExFile
 * @see	ExZipFile
 * @see ExZipEntry
 * @version		$Revision: 2.2 $, $Date: 1997/11/07 05:10:58 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
public final
class OzClassFile
extends File
{
    /**
     * For debug & message
     */
    static final String CN = "OzClassFile";

    /**
     * Flag for debug
     */
    protected static boolean debug
	= (System.getProperty(OzClassFile.class.getName()+".debug") != null) ? true : false;

    static ExClassPath classPath
      = new ExClassPath(System.getProperty("java.class.path"));
    static String ozHomeClassStoragePath
      = System.getProperty("oz.home") + separator + "lib";

    /**
     * An object which has the content of this class file.
     * It is either an ExFile or an ExZipEntry.
     */
    ExFileContentHolder contentHolder;

    /**
     * The code path of the owner class.
     */
    ExCodePath codePath;

    private static
    void debug(String methodName, String message)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message);
	    } else {
		System.err.println(CN+"#"+methodName+": "+message);
	    }
	}
    }

    /**
     * Creates a new OzClassFile.  OzClassFile doesn't have any constructor
     * which can be invoked by other classes.
     *
     * @param	codePath
     *		The code path of the owner class.
     * @param	pathName
     *		The path name of this class file.
     * @param	contentHolder
     *		The object which has the content of this class file.
     */
    private OzClassFile(ExCodePath codePath, String pathName,
			ExFileContentHolder contentHolder) {
	super(pathName);
	this.codePath = codePath;
	this.contentHolder = contentHolder;
    }

    /**
     * Searches a class file.  Usually, a class file is located at the same
     * directory with the class definition file of the class.  However, since
     * the fileName of the class file can include the path separator, the
     * class file can be located at a subdirectory of the directory.
     *
     * @param	codePathString
     *		The code path of the owner class.
     * @param	fileName
     *		The file name.
     *
     * @return
     *		If found, resulting OzClassFile object is returned.  If not
     *          found, a return value is determined as follows:
     *          <UL>
     *            <LI> System Class<BR>
     *		       null
     *		  <LI> Released OZ User Class<BR>
     *		       null, class delivery is not tried by this method.
     *		  <LI> OZ User Class under Development<BR>
     *		       An OzClassFile object representing a non-existed file.
     *		</UL>
     */
    public static OzClassFile search(String codePathString, String fileName) {
	File file = new File(codePathString.replace('.', separatorChar));
	String relativePath = file.getParent() + separator + fileName;
	ExFileContentHolder contentHolder;
	ExCodePath codePath = new ExCodePath(codePathString);
	if (codePath.isUserClass()) {
	    // user class
	    return searchUserClassFile(codePath, relativePath);
	} else {
	    // system class
	    if (codePath.isOzClass()) {
		return searchSystemClassFile(codePath, relativePath);
	    } else {
		// accessing class files other than OZ classes is prohibited
		return null;
	    }
	}
    }

    /**
     * Searches a class file of a system class.
     * Called from the method `search'.
     *
     * @param	codePath
     *		The code path of the owner class.
     * @param	relativePath
     *		The file name of the class file.
     * @return
     *		If found, resulting OzClassFile object is returned; null
     *		otherwise.
     */
    private static OzClassFile searchSystemClassFile(ExCodePath codePath,
						     String relativePath) {
	String target = "target: " + codePath + "(" + relativePath + ")";
	String path;
	Enumeration enum = classPath.elements();
	while (enum.hasMoreElements()) {
	    Object entry = enum.nextElement();
	    if (entry instanceof File) {
		debug("searchSystemClassFile", target + " : try: " + (File)entry);
		path = ((File)entry).getPath() + separator + relativePath;
		ExFile file = new ExFile(path);
		if (file.exists()) {
		    return new OzClassFile(codePath, path, file);
		}
	    } else {
		// zip file
		ExZipFile zf = (ExZipFile)entry;
		debug("searchSystemClassFile", target + " : try: " + zf);
		ExFileContentHolder holder = zf.getHolder(relativePath);
		if (holder != null) {
		    path = zf.zippedDirectory() + separator + relativePath;
		    return new OzClassFile(codePath, path, holder);
		}
	    }
	}
	return null;
    }

    /**
     * Searches a class file of a OZ user class.
     * Called from the method `search'.
     *
     * @see	ExFile
     * @param	codePath
     *		The code path of the owner class.
     * @param	relativePath
     *		The file name of the class file.
     * @return
     *		If found, resulting OzClassFile object is returned.
     *		If not, null for the released OZ user class, an OzClassFile
     *		respresenting not-existed file for the OZ user class under
     *          development.  Note that successful invokation of
     *		getOutputStream on a not-existed OzClassFile will create a
     *		file.
     */
    private static OzClassFile searchUserClassFile(ExCodePath codePath,
						   String relativePath) {
	String path = ozHomeClassStoragePath + separator + relativePath;
	if (codePath.isReleasedUserClass()) {
	    /* released class */
	    ExZipFile zf = OzLocalRepositoryManager.find(codePath.getParent());
	    debug("searchUserClassFile", path + " => " + zf);
	    if (zf != null) {
		ExFileContentHolder holder = zf.getHolder(relativePath);
		if (holder == null) {
		    return null;
		} else {
		    return new OzClassFile(codePath, path, holder);
		}
	    } else {
		return null;
	    }
	} else {
	    /* user class under development */
	    return new OzClassFile(codePath, path, new ExFile(path));
	}
    }

    /**
     * Searches a zip file.
     * Called from the method `searchUserClassFile'.
     *
     * @param	path
     *		The package name of a class.
     * @return
     *		If found, resulting ExZipFile is returned; null otherwise.
     */
    private static ExZipFile searchZipFile(String path) {
	File dir = new File(path);
	String parent;
	while ((parent = dir.getParent()) != null) {
	    File zf = new File(parent, dir.getName() + ".zip");
	    if (zf.exists()) {
		try {
		    return ExZipFile.find(zf);
		} catch (IOException e) {
		    break;
		}
	    }
	    dir = new File(parent);
	}
	return null;
    }

    /**
     * Returns the class name, that is, last portion of the code path, of the
     * owner class.
     */
    public String getClassName() {
	return codePath.getName();
    }

    /**
     * Returns the code path of the owner class.
     */
    public String getCodePath() {
	return codePath.getPath();
    }

    /**
     * Returns true if the owner class is a released OZ user class; false
     * otherwise.
     */
    public boolean isReleasedUserClassFile() {
	return codePath.isReleasedUserClass();
    }

    /**
     * Returns true if the owner class is a OZ user class; false otherwise.
     */
    public boolean isUserClassFile() {
	return codePath.isUserClass();
    }

    /**
     * Returns true if this class file can be read; false otherwise.
     */
    public boolean canRead() {
	return contentHolder.canRead();
    }

    /**
     * Returns true if this class file is modifiable; false otherwise.
     */
    public boolean canWrite() {
	return contentHolder.canWrite();
    }

    /**
     * Deletes this class file.
     *
     * @returns
     *		true if successfully deleted; false otherwise.
     */
    public boolean delete() {
	return contentHolder.delete();
    }

    /**
     * Compares two OzClassFile.
     *
     * @param	obj
     *		Another OzClassFile to be compared.
     * @returns
     *		true if obj is also an OzClassFile representing a same class
     *		file.
     */
    public boolean equals(Object obj) {
	if (obj instanceof OzClassFile) {
	    return contentHolder.equals(((OzClassFile)obj).contentHolder);
	} else {
	    return false;
	}
    }

    /**
     * Returns true if this class file exists.
     */
    public boolean exists() {
	return contentHolder.exists();
    }

    /**
     * Returns the platform dependent absolute path name of this class file.
     */
    public String getAbsolutePath() {
	return contentHolder.getAbsolutePath();
    }

    /**
     * Returns an InputStream of this class file.
     *
     * @see java.io.InputStream
     * @exception	java.io.IOException
     *		This file cannot be read.
     */
    public InputStream getInputStream() throws IOException {
	SecurityManager sm = System.getSecurityManager();
	if (sm instanceof ExSecurityManager) {
	    ((ExSecurityManager)sm).tryClassFileRead(codePath);
	}
	return contentHolder.getInputStream();
    }

    /**
     * Returns a name of the class file, not including the directory.
     */
    public String getName() {
	return contentHolder.getName();
    }

    /**
     * Returns an OutputStream of this class file.
     * Invoking this method on a not-existed file will create a file.
     *
     * @see java.io.OutputStream
     * @exception	java.io.IOException
     *		This file is not modifiable.
     */
    public OutputStream getOutputStream() throws IOException {
	SecurityManager sm = System.getSecurityManager();
	if (sm instanceof ExSecurityManager) {
	    ((ExSecurityManager)sm).tryClassFileWrite(codePath);
	}
	return contentHolder.getOutputStream();
    }

    /**
     * Returns the name of the parent directory.
     */
    public String getParent() {
	return contentHolder.getParent();
    }

    /**
     * Returns of the path name of this class file.
     */
    public String getPath() {
	return contentHolder.getPath();
    }

    /**
     * Returns a has code for this class file.
     */
    public int hashCode() {
	return contentHolder.hashCode();
    }

    /**
     * Returns true if this class file is created by an absolute path name;
     * false otherwise.
     */
    public boolean isAbsolute() {
	return contentHolder.isAbsolute();
    }

    /**
     * Returns true if this class file is a directory; false otherwise.
     */
    public boolean isDirectory() {
	return contentHolder.isDirectory();
    }

    /**
     * Returns true if this class file is a plain file; false otherwise.
     */
    public boolean isFile() {
	return contentHolder.isFile();
    }

    /**
     * The last modification time of this class file.
     *
     * @return
     *		A system dependent time representing the last modification
     *		time.  The value doesn't have any absolute meaning, and should 
     *		neither be used as a time nor be compared to a time.
     *		Comparisons between last modification times of another class
     *		file of same OZ home are meaningful.  0L, if not existed.
     */
    public long lastModified() {
	return contentHolder.lastModified();
    }

    /**
     * Returns the length of this class file.  0L, if not existed.
     */
    public long length() {
	return contentHolder.length();
    }

    /**
     * Lists the files in the directory specified by this class file.
     *
     * @returns
     *		An array of file names in the specified directory. This list
     *		does not include the current directory or the parent directory
     *		("." and ".." on Unix systems).
     */
    public String[] list() {
	return contentHolder.list();
    }

    /**
     * Lists the files in the directory specified by this File that satisfy
     * the specified filter.
     *
     * @see java.io.FileNameFilter
     * @param	filter
     *		A filename filter.
     * @return
     *		An array of file names in the specified directory that satisfy
     *		the filter. This list does not include the current directory
     *		or the parent directory ("." and ".." on Unix systems). 
     */
    public String[] list(FilenameFilter filter) {
	return contentHolder.list(filter);
    }

    /**
     * Creates a directory whose path name is specified by this class file.
     *
     * @return
     *		true if the directory could be created; false otherwise.
     */
    public boolean mkdir() {
	return contentHolder.mkdir();
    }

    /**
     * Creates a directory whose path name is specified by this File
     * object. In addition, create all parent directories as necessary.
     *
     * @return
     *		true if the directory (or directories) could be created; false
     *		otherwise. 
     */
    public boolean mkdirs() {
	return contentHolder.mkdirs();
    }

    /**
     * renames the file specified by this class file object to have the path
     * name given by the argument. 
     *
     * @param	dest
     *		the new file name 
     * @return 
     *		true if the renaming succeeds; false otherwise.
     */
    public boolean renameTo(File dest) {
	return contentHolder.renameTo(dest);
    }

    /**
     * Returns a string representation of this object.
     *
     * @return
     *		A string giving the path name of this object.
     */
    public String toString() {
	return contentHolder.toString();
    }
}
