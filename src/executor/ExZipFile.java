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
 * $Id: ExZipFile.java,v 1.1 1997/11/07 05:04:10 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * An object representing a zip file.
 * This class is intended to serve ExZipEntry objects as entries of the zip
 * file.  Although there is a similar class called ZipFile in JDK API, it is
 * rather expensive because succesive searching of ZipFile's return different
 * objects even if a same zip file is searched.  In OZ system, the
 * ExClassLoader will handle many number of zip files, the cost reduction will 
 * be important.
 *
 * @see	ExZipEntry
 * @see ExClassLoader
 * @version		$Revision: 1.1 $, $Date: 1997/11/07 05:04:10 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
final
class ExZipFile
extends ZipFile
{
    /**
     * For debug & message
     */
    static final String CN = "ExZipFile";

    /**
     * A table which associates a path name of a zip file to a ZipFile
     * object.  This table is used to use a same ZipFile object for a same zip
     * file even from different ExZipFile object.
     */
    static private Dictionary zipFiles = new Hashtable();

    /**
     * Load zip file on memory from the file or find zip file object in table.
     *
     * @param	path
     *		The full path name of zip file
     * @return	Zip file object for the path, return null if no load.
     * @exception	IOException
     *		Not load zip file becase of any exception.
     */
    static private
    ExZipFile load(String path)
    throws IOException
    {
	ExZipFile zipFile = null;
	for (;;) {
	    Object o = zipFiles.get(path);
	    if (o == null) {
		ExFakeObject current = new ExFakeObject();
		o = zipFiles.put(path, current);
		if (o == null) {
		    try {
			zipFile = new ExZipFile(path);
		    } catch (IOException e) {
			zipFiles.remove(path);
			current.abort();
			throw e;
		    }
		    zipFiles.put(path, zipFile);
		    current.ready();
		    break;
		} else {
		    if (o instanceof ExFakeObject) {
			ExFakeObject fake = (ExFakeObject)o;
			if (fake.await()) {
			    current.ready();
			} else {
			    current.abort();
			    throw new IOException(path);
			}
		    } else {
			zipFiles.put(path, o);
			current.ready();
			zipFile = (ExZipFile)o;
			break;
		    }
		}
	    } else {
		if (o instanceof ExFakeObject) {
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			throw new IOException(path);
		    }
		} else {
		    zipFile = (ExZipFile)o;
		    break;
		}
	    }
	}
	return zipFile;
    }

    /**
     * Find or create an ExZipFile object from a path string representing a zip
     * file.
     *
     * @param	path
     *		The path string representing a zip file.
     * @exception	IOException
     *		The file represented by the File object doesn't exist or
     *		cannot be read.  Otherwise, an unknown I/O error is occurred.
     */
    static
    ExZipFile find(String path)
    throws IOException
    {
	return load(path);
    }

    /**
     * Find or create an ExZipFile object from a File object representing a zip
     * file.
     *
     * @param	file
     *		The File object representing a zip file.
     * @exception	IOException
     *		The file represented by the File object doesn't exist or
     *		cannot be read.  Otherwise, an unknown I/O error is occurred.
     */
    static
    ExZipFile find(File file)
    throws IOException
    {
    	return load(file.getPath());
    }

    /**
     * Creates an ExZipFile object from a path name of a zip file.
     *
     * @param	path
     *		The path name.
     * @exception	IOException
     *		The path name is not a name of a zip file, or cannot be read.
     *		Otherwise, an unknown I/O error is occurred.
     */
    private
    ExZipFile(String path)
    throws IOException
    {
    	super(path);
    }

    /**
     * Creates an ExZipFile object from a File object representing a zip
     * file.
     *
     * @param	file
     *		The File object.
     * @exception	IOException
     *		The file represented by the File object doesn't exist or
     *		cannot be read.  Otherwise, an unknown I/O error is occurred.
     */
    ExZipFile(File file)
    throws IOException
    {
    	super(file);
    }

    /**
     * Returns a zip file entry.
     *
     * @param	path
     *		The name of an entry to be returned.
     * @returns
     *		An ExZipEntry object if the entry is found; null otherwise.
     */
    public
    ExFileContentHolder getHolder(String path)
    {
	/* Even if in Windows NT, the ZipFile take '/' as a separator. */
	path = path.replace(File.separatorChar,'/');
	ZipEntry ze = super.getEntry(path);
	if (ze == null) {
	    return null;
	} else {
	    return new ExZipEntry(this, ze);
	}
    }

    /**
     * Returns an InputStream of a zip entry.
     *
     * @see java.io.InputStream
     * @exception	java.io.IOException
     *		An unknown error is occured.
     */
    public
    InputStream getInputStream(ExZipEntry entry)
    throws IOException
    {
	return getInputStream(entry.zipEntry);
    }

    /**
     * When the zipped source of a zip entry is a directory, this method
     * returns the contents of the directory also zipped in this zip file.
     *
     * @param	entryPath
     *		The entry name of the directory.
     * @returns
     *		A list of entry names.
     */
    String[] list(String entryPath) {
	return list(entryPath, null);
    }

    /**
     * When the zipped source of a zip entry is a directory, this method
     * returns the contents of the directory also zipped in this zip file
     * using a FilenameFilter.
     *
     * @param	entryPath
     *		The entry name of the directory.
     * @param	filter
     *		The FilenameFilter
     * @returns
     *		A list of entry names.
     */
    String[] list(String entryPath, FilenameFilter filter) {
	Vector contents = new Vector();
	Enumeration entries = entries();
	File dir = new File(entryPath);
	while (entries.hasMoreElements()) {
	    ZipEntry entry = (ZipEntry)entries.nextElement();
	    String path = entry.getName();
	    if (path.length() > entryPath.length()
		&& path.startsWith(entryPath)
		&& path.charAt(entryPath.length()) == File.separatorChar) {
		String name = entry.getName();
		if (filter == null) {
		    contents.addElement(name);
		} else {
		    if (filter.accept(dir, name)) {
			contents.addElement(name);
		    }
		}
	    }
	}
	int i, len = contents.size();
	String[] result = new String[len];
	Enumeration enum = contents.elements();
	for (i = 0; i < len; i ++) {
	    result[i] = (String)enum.nextElement();
	}
	return result;
    }

    /*
     * Returns the path name of the directory zipped in this zip file.
     */
    public String zippedDirectory() {

	String path = getName();

	// 4 is the length of ".zip"
	return path.substring(0, path.length() - 4);
    }

    /**
     * Returns a string representation of the ExZipFile.
     */
    public String toString() {
	return zippedDirectory();
    }

    /*
     * For debug and shell command
     */
    static {

	class List
	extends ExShellCommand
	{
	    List()
	    {
		usage = " [<path>]";
		comment = "list of zip file objects in pool";
	    }

	    String action(ExShell shell, String[] args)
	    throws Exception
	    {
		if (2 < args.length) {
		    shell.stderr.println("Usage: "+args[0]+usage);
		    throw new IllegalArgumentException("Too many arguments");
		}

		if (args.length == 2) {
		    ExZipFile zipFile = (ExZipFile)zipFiles.get(args[1]);
		    if (zipFile != null) {
			shell.stdout.println(zipFile.getName());
		    }
		} else {
		    Enumeration keys = zipFiles.keys();
		    while (keys.hasMoreElements()) {
			String path = (String)keys.nextElement();
			ExZipFile zipFile = (ExZipFile)zipFiles.get(path);
			shell.stdout.println(zipFile.getName());
		    }
		}
		return null;
	    }
	}

	ExShell.append("zipls",new List());
    }
}
