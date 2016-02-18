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
 * CompilerAgent.oz,v 1.1 1997/8/15
 *
 */

/**
 * CompilerAgent supports the programmers who compile the oz program.
 *
 * @see	SchoolBrowser
 *
 * @version		1.1
 * @author		Hiroshi Sugino
 */

class CompilerAgent 
{
	/**************
	 * ATTRIBUTES *
	 **************/
	//  oz compiler (Java)
	Ozc aCompiler;
	// school object
	 School school;
	// CompilerUtility object
	CompilerUtility compilerUtility;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "CompilerAgent"
	new create(School sc){
		aCompiler=>create();
		school = sc;
		compilerUtility = null;
	}

	// Constructor of the class "CompilerAgent"
	new create(School sc, CompilerUtility cu){
		aCompiler=>create();
		school = sc;
		compilerUtility = cu;
	}

	/***********
	 * METHODS *
	 ***********/
	/**get the used OZ Compiler
	 * @return	ClassIDGenerator
	 * @exception	Exception
	 */
	public Ozc getCompiler(){
		return aCompiler;
	}

	/**set the used OZ Compiler
	 * @param	ClassIDGenerator
	 * @exception	Exception
	 */
	public void setCompiler(Ozc ozc){
		aCompiler = ozc;
	}

	/**get the used School
	 * @return	School
	 * @exception	Exception
	 */
	public School getSchool(){
		return school;
	}

	/**set the used School
	 * @param	sc : School
	 * @exception	Exception
	 */
	public void setSchool(School sc){
		school = sc;
	}

	/**compile the oz program
	 */
	public boolean compile (String source) {
		return aCompiler->compile (source, school);
	}

	/**compile the oz program
	 */
	public boolean compile (String source, Writer output) {
		return aCompiler->compile (source, school, output);
	}

	/**compile the oz program
	 */
	public boolean compileInterface (String source) {
		return aCompiler->compileInterface (source, school);
	}

	/**compile the oz program
	 */
	public boolean compileInterface (String source, Writer output) {
		return aCompiler->compileInterface (source, school, output);
	}

	/******************************************/
	/*** compile the oz program per Subject ***/
	/******************************************/
	public boolean compileSubject (String dirName, Writer output) {

		StringBuffer fullPath=>breed(dirName);

		if (!(dirName->endsWith(getKugiri())))
			fullPath->append(getKugiri());

		// for oz file dir
		Array fileList;
		File file => breed(dirName);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return false;
		deleteClassFiles(fileList);
		compileOzFIles(fileList, fullPath, output);

		return true;
	}

	public boolean deleteClassFiles(Array fileList) {
		// delete the class files
		String tmp,classPath;
		StringBuffer filename, message;
		int max;
		classPath =| fileList->at(0);
		classPath = classPath->substring(0,classPath->lastIndexOf("."));
		classPath = school->getLabelPath(classPath);
		Array classFileList;
		File classFile => breed(classPath);
		File delFile;
		ExtensionFilter classFilter=>create(".class");
		classFileList = classFile->list(classFilter);
		if (classFileList!=null) {
			max = classFileList->size();
			for(int i=0; i<max; i++){
				tmp =| classFileList->at(i);
				filename=>breed(classPath);
				filename->append(tmp);
				delFile => breed(filename->asString());
				if(delFile->isFile())
					delFile->delete();
			}
		}
		return true;
	}

	public boolean compileOzFIles(Array fileList, StringBuffer fullPath, Writer output) {
		String tmp;
		StringBuffer filename, message;
		int max = fileList->size();
		for(int i=0; i<max; i++){
			tmp =| fileList->at(i);
			filename=>breed(fullPath->asString());
			filename->append(tmp);
			if(!(filename->asString()->endsWith("_cl.oz"))) {
				if(!existClassFile(filename->asString())) {
					if(aCompiler->compile (filename->asString(), school)) {
						message=>breed(tmp);
						message->append(" compiled successfully.");
						output->write(message->asString());
					} else {
						message=>breed(tmp);
						message->append(" compiled failed.");
						output->write(message->asString());
					}
				} else {
					message=>breed(tmp);
					message->append(" compiled successfully.");
					output->write(message->asString());
				}
			}
		}
		return true;
	}

	public boolean existClassFile(String filename) {	//filename: .oz file name by Full Path
		String labelName;
		StringBuffer classPath;
		labelName = filename->substring(filename->lastIndexOf(getKugiri())+1, filename->lastIndexOf("."));
		classPath =>breed( school->getLabelPath(labelName));
		classPath->append(labelName);
		classPath->append("_cl.class");
		File classFile => breed(classPath->asString());
		if(classFile->isFile()) {
			return true;
		}
		return false;
	}

	/******************************************/
	/*** compile the oz program for Release ***/
	/******************************************/
	public boolean compileSubjectForRelease (String dirName, Writer output) {

		StringBuffer fullPath=>breed(dirName);

		if (!(dirName->endsWith(getKugiri())))
			fullPath->append(getKugiri());

		// for oz file dir
		Array fileList;
		File file => breed(dirName);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return false;

		File releaseDir => breed(getReleaseDir());
		if(!(releaseDir->isDirectory())) {
			releaseDir->mkdir();
		}
		deleteAllFiles();
		deleteClassFiles(fileList);
		compileOzFIlesForRelease(fileList, fullPath, output);

		return true;
	}

	public boolean deleteAllFiles() {
		// delete the All files
		StringBuffer filename;
		String tmp, classPath;
		int max;
		classPath = getReleaseDir();
		Array classFileList;
		File classFile => breed(classPath);
		File delFile;
		classFileList = classFile->list();
		if (classFileList!=null) {
			max = classFileList->size();
			for(int i=0; i<max; i++){
				tmp =| classFileList->at(i);
				filename=>breed(classPath);
				filename->append(tmp);
				delFile => breed(filename->asString());
				if(delFile->isFile())
					delFile->delete();
			}
		}
		return true;
	}

	public boolean compileOzFIlesForRelease(Array fileList, StringBuffer fullPath, Writer output) {
		String tmp, classPath;
		StringBuffer filename, message;
		int max = fileList->size();
		classPath = getReleaseDir();
		for(int i=0; i<max; i++){
			tmp =| fileList->at(i);
			filename=>breed(fullPath->asString());
			filename->append(tmp);
			if(!(filename->asString()->endsWith("_cl.oz"))) {
				if(!existClassFileForRelease(filename->asString())) {
					if(aCompiler->compile (filename->asString(), school, classPath)) {
						message=>breed(tmp);
						message->append(" compiled successfully.");
						output->write(message->asString());
					} else {
						message=>breed(tmp);
						message->append(" compiled failed.");
						output->write(message->asString());
					}
				} else {
					message=>breed(tmp);
					message->append(" compiled successfully.");
					output->write(message->asString());
				}
			}
		}
		return true;
	}

	public boolean existClassFileForRelease(String filename) {	//filename: .oz file name by Full Path
		String labelName;
		StringBuffer classPath;
		labelName = filename->substring(filename->lastIndexOf(getKugiri())+1, filename->lastIndexOf("."));
		classPath =>breed(getReleaseDir());
		classPath->append(labelName);
		classPath->append("_cl.class");
		File classFile => breed(classPath->asString());
		if(classFile->isFile()) {
			return true;
		}
		return false;
	}

	/******************************************/
	/*** compile the oz program per A