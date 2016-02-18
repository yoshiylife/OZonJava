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
	/*** compile the oz program per Auto    ***/
	/******************************************/
	public boolean compileAuto (String dirName, Writer output) {
		Set modifiedLabels;
		//修正されたクラスおよびその関連クラスの取得
		modifiedLabels = relatedLabels(dirName);
		//上記で取得されたクラスの.classファイルを削除
		deleteLabels(modifiedLabels);
		//上記で取得されたクラスのコンパイル処理
		String kugiri = getKugiri();
		StringBuffer fullPath=>breed(dirName);
		if (!(dirName->endsWith(kugiri)))
			fullPath->append(kugiri);

System system=>create();
		int max = modifiedLabels->size();
		if(max==0) output->write("files were not changed.");
		int count=0;
		Array fileList=>create(max);
		String tmp;
		StringBuffer buf;
		Iterator itr;
		itr = modifiedLabels->iterator();
 		while (itr->hasMoreElements()) {
    	tmp =| itr->nextElement();
			tmp = tmp->substring(tmp->lastIndexOf(".")+1, tmp->lastIndexOf("_"));
			buf=>breed(tmp);
			buf->append(".oz");
			tmp = buf->asString();
			fileList->putAt(count, tmp);
			count++;
system->println(tmp);
		}
		return compileOzFIles(fileList, fullPath, output);
	}

	/* 修正のあったラベルに関連するラベルを全て取得する
	*/
	public Set relatedLabels(String dirName) {
		Array modifiedLabels;
		modifiedLabels = getModFiles(dirName, getClassDir(dirName));
		int max = modifiedLabels->size();
		String tmp;
		Set tmpSet, resultSet;
		StringComparator sc=>create();
		resultSet=>create(sc);
		for(int i=0; i<max; i++) {
			tmp =| modifiedLabels->at(i);
			resultSet->add(school->getImplementationID(tmp));
			tmpSet = compilerUtility->getReferedCID(school->getImplementationID(tmp));
			resultSet = resultSet->union(tmpSet);
			tmpSet = compilerUtility->getInstanciatedCID(school->getImplementationID(tmp));
			resultSet = resultSet->union(tmpSet);
//			tmpSet = compilerUtility->getDescendantCID(school->getImplementationID(tmp));
//			resultSet = resultSet->union(tmpSet);
		}
		return resultSet;
	}

	/* 指定されたラベル名の.classファイルを削除する
	*/
	public void deleteLabels(Set labels) {
		String tmp, kugiri;
		kugiri = getKugiri();
		System system=>create();
		String ozHome = system->getOzHome();
		StringBuffer filePath;
		File delFile;
		Iterator itr;
		itr = labels->iterator();
 		while (itr->hasMoreElements()) {
    	tmp =| itr->nextElement();
			filePath=>breed(ozHome);
			if(!(ozHome->endsWith(kugiri)))
				filePath->append(kugiri);
			filePath->append("lib");
			filePath->append(kugiri);
			if(kugiri=="/")
				tmp = tmp->replace('.','/');
			else
				tmp = tmp->replace('.','\\');
			filePath->append(tmp);
			filePath->append(".class");
			tmp = filePath->asString();
			delFile=>breed(tmp);
			if(delFile->exists()) {
				delFile->delete();
system->println(tmp);
			}
			tmp = replace(tmp, "_cl", "_if");
			delFile=>breed(tmp);
			if(delFile->exists()) {
				delFile->delete();
system->println(tmp);
			}
		}
	}

	public boolean compileModifiedLabels(Set labels) {
		return true;
	}

	/******************************************/
	/*** zip the oz program for Release ***/
	/******************************************/
	public boolean release (String dirName, int flag, String zipFName) {
		// for oz file dir
		Array fileList;
		File file => breed(dirName);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return false;

		zipForRelease (dirName, flag, zipFName);

		return true;
	}

	/* リリース用のZIPファイルを作成する
	*/
	public void zipForRelease (String dirName, int flag, String zipFName) {
		String tmp,classPath;
		StringBuffer filename, message;
		Array classFileList,zipFileList;
		int max;
		classPath = getReleaseDir();

		File classFile => breed(classPath);
		int count=0;
		classFileList = classFile->list();
		if (classFileList!=null) {
			max = classFileList->size();
			zipFileList=>create(max);
			for(int i=0; i<max; i++){
				tmp =| classFileList->at(i);
				if( flag==1 && (tmp->endsWith("_if.class") || tmp->endsWith("_if.ci")) ) {
					zipFileList->putAt(count, tmp);
					count++;
				}
				else if( flag==2 && (tmp->endsWith("_cl.class") || tmp->endsWith("_cl.ci") || tmp->endsWith(".oz")) ) {
					zipFileList->putAt(count, tmp);
					count++;
				}
				else if( flag==2 && (tmp->endsWith("_pcl.class") || tmp->endsWith("_pcl.ci")) ) {
					zipFileList->putAt(count, tmp);
					count++;
				}
				else if( flag==3 && ( tmp->endsWith("_if.class") || tmp->endsWith("_if.ci") || 
															tmp->endsWith("_cl.class") || tmp->endsWith("_cl.ci") || tmp->endsWith(".oz") ||
															tmp->endsWith("_pcl.class") || tmp->endsWith("_pcl.ci")) ) {
					zipFileList->putAt(count, tmp);
					count++;
				}
			}
			zipFileList->resize(count);
		}
		StringBuffer fName=>breed(classPath);
		fName->append(zipFName);
		fName->append(".zip");
		ZipArchive zip=>create(fName->asString());
		zip->store(classPath, getClassDir2(dirName), zipFileList);
	}

	/* ソースファイルのあるディレクトリから、クラスファイルの
		出力先ディレクトリを取得する（絶対パス）
	*/
	public String getClassDir(String dirName) {
		// for oz file dir
		Array fileList;
		File file => breed(dirName);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return "";

		String classPath;
		StringBuffer filename, message;
		Array classFileList,zipFileList;
		int max = fileList->size();

		for(int i=0; i<max; i++) {
			classPath =| fileList->at(i);
			if(!(classPath->endsWith("_cl.oz"))) break;
		}
		classPath = classPath->substring(0,classPath->lastIndexOf("."));
		classPath = school->getLabelPath(classPath);
		return classPath;
	}

	/* ソースファイルのあるディレクトリから、クラスファイルの
		出力先ディレクトリを取得する（相対パス）
	*/
	public String getClassDir2(String dirName) {
		// for oz file dir
		Array fileList;
		File file => breed(dirName);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return "";

		String classPath;
		StringBuffer filename, message;
		Array classFileList,zipFileList;
		int max = fileList->size();

		for(int i=0; i<max; i++) {
			classPath =| fileList->at(i);
			if(!(classPath->endsWith("_cl.oz"))) break;
		}
		classPath = classPath->substring(0,classPath->lastIndexOf("."));

//		classPath = school->getLabelPath2(classPath);
//		return classPath->replace('\\','/');
		OzLabel tmpLabel = school->getOzLabel(classPath);
		Subject subject = school->getSubject(tmpLabel->getSubjectName());
		classPath = subject->getPackageName();
		StringBuffer tmp=>breed(classPath->replace('.','/'));
		tmp->append("/");
		return tmp->asString();
	}

	/* 修正されたOZファイルを取得する。帰り値は、ラベル名のArray
	*/
	public Array getModFiles(String sourceDir, String classDir) {
		StringBuffer dir1=>breed(sourceDir);
		if(!(sourceDir->endsWith("\\") || sourceDir->endsWith("/")))
			dir1->append(getKugiri());
		sourceDir = dir1->asString();
		StringBuffer dir2=>breed(classDir);
		if(!(classDir->endsWith("\\") || classDir->endsWith("/")))
			dir2->append(getKugiri());
		classDir = dir2->asString();

		Array sourceList, modFileList;
		File file => breed(sourceDir);
		ExtensionFilter filter=>create(".oz");
		sourceList = file->list(filter);
		if (sourceList==null) return null;

		int max = sourceList->size();
		int count = 0;
		String tmp;
		Array tmpList = sourceList;
		for(int i=0; i<max; i++) {
			tmp =| tmpList->at(i);
			if(!(tmp->endsWith("_cl.oz"))) {
				sourceList->putAt(count, tmp);
				count++;
			}
		}
		sourceList->resize(count);
		max = count;
		count = 0;
		File file1, file2;
		modFileList=>create(max);
		for(int i=0; i<max; i++) {
			tmp =| sourceList->at(i);
			dir1=>breed(sourceDir);
			dir1->append(tmp);
			file1=>breed(dir1->asString());
			dir2=>breed(classDir);
			dir2->append( replace(tmp, ".oz", "_cl.class") );
			file2=>breed(dir2->asString());
			if( file1->lastModified() > file2->lastModified()) {
				tmp = replace(tmp, ".oz", "");
				modFileList->putAt(count, tmp);
				count++;
			}
		}
		modFileList->resize(count);
		return modFileList;
	}

	/* 文字列の一部を他の文字列に置き換える
	*/
	public String replace(String target, String oldString, String newString) {
		int lenTarget = target->length();
		int lenOld = oldString->length();
		StringBuffer tmpString;
		for(int i=0; i<lenTarget-lenOld+1; i++) {
			if((target->substring(i,i+lenOld))->compareTo(oldString)==0) {
				tmpString=>breed(target->substring(0,i));
				tmpString->append(newString);
				if(lenTarget>=i+lenOld)
					tmpString->append(target->substring(i+lenOld));
				return tmpString->asString();
			}
		}
		return target;
	}

	/* ディレクトリの区切り文字を取得する
	*/
	public String getKugiri() {
		System system=>create();
		String ozHome = system->getOzHome();
		if (ozHome->startsWith("/"))
			return "/";
		else
			return "\\";
	}

	/* リリースコンパイル出力先ディレクトリを取得する
		フルパス、ディレクトリ区切り子で終わる
	*/
	public String getReleaseDir() {
		StringBuffer classPath;
		System system=>create();
		String ozHome = system->getOzHome();

		classPath =>breed(ozHome);
		if (!(ozHome->endsWith(getKugiri())))
			classPath ->append(getKugiri());
		classPath ->append("objects");
		classPath ->append(getKugiri());
		classPath ->append("ide");
		classPath ->append(getKugiri());
		classPath ->append("tmp");
		classPath ->append(getKugiri());
		return classPath->asString();
	}
}
