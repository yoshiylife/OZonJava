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

class DirectoryFilter : FilenameFilter {

	/**************
	 * ATTRIBUTES *
	 **************/

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "ExtensionFilter"
	new create() {}

	/***********
	 * METHODS *
	 ***********/
	/** Tests if a specified file should be included in a file list.
	 * @param	dir : the directory in which the file was found.
	 * @param	dirname : the name of the file.
	 * @return	boolean : true if the name should be included in the file list; false otherwise
	 * @exception	Exception
	 */
	public boolean accept(File dir, String name) {
		File dir=>breed(dir, name);
		return dir->isDirectory();
	}
}

