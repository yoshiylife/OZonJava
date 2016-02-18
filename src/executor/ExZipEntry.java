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
 * $Id: ExZipEntry.java,v 1.1 1997/11/07 05:04:10 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;

/**
 * A zip file entry, which can be a container of a class file content.
 * An ExZipEntry object can be handled as a file.  It represents a file zipped 
 * in this zip entry.  The file is called `zipped source'.
 *
 * @see ExFileContentHolder
 * @see	ExZipFile
 * @version		$Revision: 1.1 $, $Date: 1997/11/07 05:04:10 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
final
class ExZipEntry
implements ExFileContentHolder
{
    /**
     * For debug & message
     */
    static final String CN = "ExZipEntry";

    /**
     * The zip file which has this entry.
     */
    ExZipFile zipFile;

    /**
     * Implementation of this object.
     */
    ZipEntry zipEntry;

    /**
     * A file object representing a file from which this entry is archived.
     */
    File file;

    /**
     * Creates an ExZipEntry object.
     *
     * @param	zipFile
     *		ExZipFile object which contains this entry.
     * @param	zipEntry
     *		JDK API object which implements this object.
     */
    ExZipEntry(ExZipFile zipFile, ZipEntry zipEntry) {
	this.zipFile = zipFile;
	this.zipEntry = zipEntry;
	String name = zipEntry.getName();
	file = new File(OzClassFile.ozHomeClassStoragePath, name.replace('/',File.separatorChar));
    }

    /**
     * Returns a boolean indicating whether or not a readable zip entry
     * exists. 
     *
     * @return
     * 		Always returns true because ExZipEntry object cannot be created
     *		for not-existed entry.
     */
    public boolean canRead() {
	return true;
    }

    /**
     * Returns a boolean indicating whether or not a writable zip file entry
     * exists.
     *
     * @return
     *		Always returns false because a zip entry is not modifiable.
     */
    public boolean canWrite() {
	return false;
    }

    /**
     * Deletes the specified zip entry.
     * Returns true if the file could be deleted.
     *
     * @return
     *		Always return false because a zip entry cannot be deleted.
     */
    public boolean delete() {
	return false;
    }

    /**
     * Compares this object against the specified object. 
     *
     * @param	obj
     *		The object to compare with.
     * @return
     *		true if obj is the same object.
     */
    public boolean equals(Object obj) {
	if (obj instanceof ExZipEntry) {
	    return zipEntry == ((ExZipEntry)obj).zipEntry;
	} else {
	    return false;
	}
    }

    /**
     * Returns a boolean indicating whether or not a zip entry exists. 
     *
     * @return	
     *		Always returns true because ExZipEntry object cannot be created
     *		for not-existed entry.
     */
    public boolean exists() {
	return true;
    }

    /**
     * Gets the abolute path of the zipped source.
     *
     * @return
     *		the absolute path.
     */
    public String getAbsolutePath() {
	return file.getAbsolutePath();
    }

    /**
     * Returns an InputStream of this zip entry.
     *
     * @see java.io.InputStream
     * @exception	java.io.IOException
     *		This zip entry is corrupted.
     */
    public InputStream getInputStream() throws IOException {
	return zipFile.getInputStream(this);
    }

    /**
     * Returns an OutputStream of this zip entry.
     *
     * @return
     *		Always throws an exception because a zip entry is not
     *		modifiable.
     * @exception	OzOutputStreamNotAvailableException
     *		This zip entry is not modifiable.
     */
    public OutputStream getOutputStream() throws IOException {
	throw new OzOutputStreamNotAvailableException(getPath());
    }

    /**
     * Gets the name of the zipped source.  The directory name is not included.
     *
     * @return
     *		The file name.
     */
    public String getName() {
	/* in Windows NT, File.getName() returns name with directory path. */
	String name = file.getName();
	return name.substring(name.lastIndexOf(File.separator) + 1);
    }

    /**
     * Gets the name of the parent directory of the zipped source.
     *
     * @return
     *		The parent directory, or null if it is not found.
     */
    public String getParent() {
	return file.getParent();
    }

    /**
     * Gets the path name of the zipped source.
     *
     * @return
     *		The path name.
     */
    public String getPath() {
	return file.getPath();
    }

    /**
     * Computes a hash code for thie zip entry, which is same as that of a
     * File object representing the zipped source.
     */
    public int hashCode() {
	return file.hashCode();
    }

    /**
     * Returns a boolean indicating whether the path name of the zipped source
     * is absolute.
     */
    public boolean isAbsolute() {
	return file.isAbsolute();
    }

    /**
     * Returns a boolean indicating whether or not the zipped source is a
     * directory.
     */
    public boolean isDirectory() {
	return zipEntry.isDirectory();
    }

    /**
     * Returns a boolean indicating whether or not the zipped source is a
     * normal file.
     */
    public boolean isFile() {
	return !isDirectory();
    }

    /**
     * Returns the last modification time. The return value should only be
     * used to compare modification dates. It is meaningless as an absolute
     * time.
     *
     * @returns
     *		The last modification time.
     */
    public long lastModified() {

	return zipEntry.getTime();

    }

    /**
     * Returns the length of the zipped source.
     *
     * @return
     *		The length of the file.
     */
    public long length() {

	return zipEntry.getSize();

    }

    /**
     * If the zipped source is a directory, lists the files in the zipped
     * source and also zipped in the same zip file.
     *
     * @return
     *		An array of file names. This list doesn't include "." and
     *		"..".
     */
    public String[] list() {
	if (isDirectory()) {

	    return zipFile.list(zipEntry.getName());

	} else {
	    return null;
	}
    }

    /**
     * If the zipped source is a directory, lists the files in the zipped
     * source and also zipped in the same zip file.  A FilenameFilter is used
     * to list the files.
     *
     * @param	filter
     *		A FilenameFilter.
     * @return
     *		The file names listed in an array. This list doesn't include
     *		"." and "..".
     */
    public String[] list(FilenameFilter filter) {
	if (isDirectory()) {

	    return zipFile.list(zipEntry.getName(), filter);

	} else {
	    return null;
	}
    }

    /**
     * Creates a directory and returns a boolean indicating the success of the
     * creation.
     *
     * @return
     *		Always false because a zip entry cannot be created.
     */
    public boolean mkdir() {
	return false;
    }

    /**
     * Creates all directories in this path.
     *
     * @return
     *		Always false because a zip entry cannot be created.
     */
    public boolean mkdirs() {
	return false;
    }

    /**
     * Renames a zip entry and returns a boolean indicating whether or not this
     * method was successful.
     *
     * @param	dest
     *		The new entry name.
     * @return
     *		Always false because a zip entry cannot be renamed.
     */
    public boolean renameTo(File dest) {
	return false;
    }

    /**
     * Returns a String object representing the path name of the zipped source.
     */
    public String toString() {
	return file.toString();
    }
}
