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
 * Project.oz,v 1 1997/7/1
 */

/**
 * Project is ...
 *
 * @see	
 * @see	
 *
 * @version		1
 * @author		Hiroshi Sugino
 */

class Project 
{
	/**************
	 * ATTRIBUTES *
	 **************/
	// Project Name
	String projectName;

	// files in this Project
	Array files;
	String projectDir;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "Project"
	new create(){
		projectName=>breed();
		files=>create(1);
		projectDir=>breed();
	}

	// Constructor of the class "Project"
	new create(String prjName){
		projectName=>breed(prjName);
		files=>create(1);
		files->putAt(0, prjName);	// files->at(0) equal to ProjectName.
	}

	/***********
	 * METHODS *
	 ***********/

	/**get the projectName.
	 * @return	String:Project Name
	 * @exception	Exception
	 */
	public String getProjectName() {
		return projectName;
	}

	/**set the projectName.
	 * @param	prjName:String
	 * @return	void
	 * @exception	Exception
	 */
	public void setProjectName(String prjName) {
		 projectName = prjName;
	}

	/**get the projectDir.
	 * @return	String:Project Name
	 * @exception	Exception
	 */
	public String getProjectDir() {
		return projectDir;
	}

	/**set the projectDir.
	 * @param	prjName:String
	 * @return	void
	 * @exception	Exception
	 */
	public void setProjectDir(String prjDir) {
		 projectDir = prjDir;
	}

	/**get the files.
	 * @return	Array:Files in thie Project
	 * @exception	Exception
	 */
	public Array getFiles() {
		return files;
	}

	/**set the files.
	 * @param	f:Array
	 * @return	void
	 * @exception	Exception
	 */
	public void setFiles(Array f) {
		 files = f;
	}

	/**add the file in this Project.
	 * @param	fileName:adding file name
	 * @return	void
	 * @see 
	 */
	public void addFile(String fileName) {
		int sizeOfFiles;
		sizeOfFiles = files->size();
		files->resize(sizeOfFiles + 1);
		files->putAt(sizeOfFiles, fileName);
	}

	/**remove the file in this Project.
	 * @param	fileName:removing file name
	 * @return	void
	 * @see 
	 */
	public locked void removeFile(String fileName) {
		int sizeOfFiles;
		int count;
		int i;
		sizeOfFiles = files->size();
		String fName=>breed();

		for(count = 0; count<sizeOfFiles; count++) {
			fName =| files->at(count);
			if(fName->compareTo(fileName)==0) break;
		}

		for(i=count; i<sizeOfFiles-1; i++) {
			fName =| files->at(i+1);
			files->putAt(i, fName);
		}
		files->resize(sizeOfFiles - 1);
	}

	public locked void removeAllFiles() {
		files->resize(1);
	}

	/**get the number of file in this Project.
	 * @param
	 * @return	int
	 * @see 
	 */
	public int getNumOfFiles() {
		return files->size();
	}
}
