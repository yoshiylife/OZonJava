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
 * $Id: ExFileContentHolder.java,v 1.1 1997/11/07 05:04:10 yoshi Exp $
 */

package JP.go.ipa.oz.system;

import java.io.*;

/**
 * An interface representing a container of a file content.  In OZ system, a
 * class file can be either a (read) file or a zip file entry.  Thus, a common
 * interface to them is required.  To handle the class file as a ordinary
 * file, this interface has enough methods to implement class java.io.File.
 * There are only two methods not availabe in java.io.File: getInputStream and
 * getOutputStream.  The file of which the contents is held in this content
 * holder is called `source file'.
 *
 * @see ExFile
 * @see ExZipEntry
 * @version		$Revision: 1.1 $, $Date: 1997/11/07 05:04:10 $
 * @author		Toshihiro Nishioka
 * @author		Yasumitsu Yoshida(reviser)
 */
interface ExFileContentHolder {

    /**
     * Returns a boolean indicating whether or not the file content is
     * readable.
     */
    boolean canRead();

    /**
     * Returns a boolean indicating whether or not the file content is
     * writable.
     */
    boolean canWrite();

    /**
     * Deletes this file content holder.
     * Returns true if it could be deleted.
     */
    boolean delete();

    /**
     * Compares this object against the specified object. 
     *
     * @param	obj
     *		The object to compare with.
     * @return
     *		true if obj is also a file content holder and contain the
     *		contents of same file.
     */
    boolean equals(Object obj);

    /**
     * Returns a boolean indicating whether or not the file content holder
     * exists.
     */
    boolean exists();

    /**
     * Gets the abolute path of the source file.
     */
    String getAbsolutePath();

    /**
     * Returns an InputStream of this content holder.
     *
     * @see java.io.InputStream
     * @exception	java.io.IOException
     *		This content holder is corrupted.
     */
    InputStream getInputStream() throws IOException;

    /**
     * Returns an OutputStream of this content holder.
     *
     * @exception	OzOutputStreamNotAvailableException
     *		This content holder is not modifiable.
     */
    OutputStream getOutputStream() throws IOException;

    /**
     * Gets the name of the source file.  The directory name is not included.
     *
     * @return
     *		The file name.
     */
    String getName();

    /**
     * Gets the name of the parent directory of the source file.
     *
     * @return
     *		The parent directory, or null if it is not found.
     */
    String getParent();

    /**
     * Gets the path name of the source file.
     *
     * @return
     *		The path name.
     */
    String getPath();

    /**
     * Computes a hash code for thie content holder, which is same as that of
     * a File object representing the source file.
     */
    int hashCode();

    /**
     * Returns a boolean indicating whether the path name of the source file
     * is absolute.
     */
    boolean isAbsolute();

    /**
     * Returns a boolean indicating whether or not the source file is a
     * directory.
     */
    boolean isDirectory();

    /**
     * Returns a boolean indicating whether or not the source file is a
     * normal file.
     */
    boolean isFile();

    /**
     * Returns the last modification time of this content. The return value
     * should only be used to compare modification dates. It is meaningless as
     * an absolute time.
     *
     * @returns
     *		The last modification time.
     */
    long lastModified();

    /**
     * Returns the length of this content.
     *
     * @return
     *		The length.
     */
    long length();

    /**
     * If the source file is a directory, lists the files in the directory.
     *
     * @return
     *		An array of file names. This list doesn't include "." and
     *		"..".
     */
    String[] list();

    /**
     * If the source file is a directory, lists the files in the directory
     * using a FilenameFilter.
     *
     * @param	filter
     *		A FilenameFilter.
     * @return
     *		The file names listed in an array. This list doesn't include
     *		"." and "..".
     */
    String[] list(FilenameFilter filter);

    /**
     * Creates a directory and returns a boolean indicating the success of the
     * creation.  Will return false if the directory already exists. 
     */
    boolean mkdir();

    /**
     * Creates all directories in this path.  This method returns true if the
     * target (deepest) directory was created, false if the target directory
     * was not created (e.g., if it existed previously).
     */
    boolean mkdirs();

    /**
     * Renames a content holder and returns a boolean indicating whether or
     * not this method was successful.
     *
     * @param	dest
     *		The new content holder name.
     */
    boolean renameTo(File deset);

    /**
     * Returns a String object representing the path name of the source file.
     */
    String toString();
}
