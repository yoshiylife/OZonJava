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
 * $Id: CompilerAgent.oz,v 0.3 1998-01-30 11:04:15+09 otokawa Exp $
 * 
 * CompilerAgent.oz,v 1.1 1997/8/15
 *
 * CompilerAgent supports the programmers who compile the oz program.
 *
 * modified Hidyuki Otokawa for World Wide Programming Server
 *
 * @see	SchoolBrowser
 *
 * @version		1.1m
 * @author		Hiroshi Sugino
 * @author		Hideyuki Otokawa
 */

class CompilerAgent 
{
  /*
   * ATTRIBUTES 
   */

  Ozc aCompiler;

  School school;

  String release_directory;  /* added by Otokawa */

  /*
   * CONSTRUCTORS 
   */

  /**
    * create new one
    * 
    * added by Hideyuki Otokawa
    *
    * @param dir directory path
    */
  new create (String dir) {
    release_directory = dir;
  }

  /**
    * create new one
    * 
    * modified by Hideyuki Otokawa
    *
    * @param dir directory path
    */

  new create (School sc) {
    aCompiler=>create();
    school = sc;
  }

  /*
   * METHODS 
   */

  /**
    * get the used School
    * @return	School
    * @exception	Exception
    */
  public School getSchool() {
    return school;
  }

  /**
    * set the used School
    * @param	sc : School
    * @exception	Exception
    */
  public void setSchool (School sc){
    school = sc;
  }

  /**
    * compile the oz program
    */
  public boolean compile (String source) {
    return aCompiler->compile (source, school);
  }

  /**
    * compile the oz program
    */
  public boolean compile (String source, Writer output) {
    return aCompiler->compile (source, school, output);
  }

  /**
    * compile the oz program
    */
  public boolean compileInterface (String source) {
    return aCompiler->compileInterface (source, school);
  }

  /**
    * compile the oz program
    */
  public boolean compileInterface (String source, Writer output) {
    return aCompiler->compileInterface (source, school, output);
  }

  public boolean deleteClassFiles (Array fileList) {
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

  /**
    * compile the oz program for Release 
    */
  public boolean compileSubjectForRelease (String dirName, Writer output) {
    release_directory = dirName;
    StringBuffer fullPath=>breed (dirName);

    if (!(dirName->endsWith (getKugiri ())))
      fullPath->append(getKugiri());

    /* for oz file dir */
    Array fileList;
    File file => breed(dirName);
    ExtensionFilter filter=>create(".oz");
    fileList = file->list(filter);
    if (fileList==null) return false;

    File releaseDir => breed(getReleaseDir());
    if(!(releaseDir->isDirectory())) {
      releaseDir->mkdir();
    }

    /* deleteAllFiles(); */
    deleteClassFiles(fileList);
    return compileOzFIlesForRelease(fileList, fullPath, output);
  }

  /**
    * delete the All files at release_directory
    */
  public boolean deleteAllFiles() {
    StringBuffer filename;
    String tmp, classPath;
    int max;
    classPath = getReleaseDir ();
    Array classFileList;
    File classFile=>breed (classPath);
    File delFile;
    classFileList = classFile->list ();
    if (classFileList != null) {
      max = classFileList->size ();
      for(int i = 0; i < max; i++){
	tmp =| classFileList->at (i);
	filename=>breed (classPath);
	filename->append (tmp);
	delFile=>breed (filename->asString ());
	if (delFile->isFile ())
	  delFile->delete ();
      }
    }
    return true;
  }

  public boolean compileOzFIlesForRelease(Array fileList, StringBuffer fullPath, Writer output) {
    String tmp, classPath;
    StringBuffer filename, message;
    int max = fileList->size();
    classPath = getReleaseDir();
    boolean result = true;
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
	    result = false;
	  }
	} else {
	  message=>breed(tmp);
	  message->append(" compiled successfully.");
	  output->write(message->asString());
	}
      }
    }
    return result;
  }

  /**
    * @param filename .oz file name by Full Path
    */
  public boolean existClassFileForRelease(String filename) {	
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

  /**
    * zip the oz program for Release 
    */
  public boolean release (String dirName, int flag, String zipFName) {
    Array fileList;
    File file => breed(dirName);
    ExtensionFilter filter=>create(".oz");
    fileList = file->list(filter);
    if (fileList==null) return false;

    zipForRelease (dirName, flag, zipFName);

    return true;
  }

  /**
    * リリース用のZIPファイルを作成する
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

  /**
    * ソースファイルのあるディレクトリから、クラスファイルの
    * 出力先ディレクトリを取得する（絶対パス）
    */
  public String getClassDir(String dirName) {
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

  /**
    * ソースファイルのあるディレクトリから、クラスファイルの
    * 出力先ディレクトリを取得する（相対パス）
    */
  public String getClassDir2 (String dirName) {
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
    classPath = school->getLabelPath2(classPath);

    return classPath->replace('\\','/');
  }

  /**
    * ディレクトリの区切り文字を取得する
    */
  public String getKugiri () {
    System system=>create ();
    String ozHome = system->getOzHome ();
    if (ozHome->startsWith ("/"))
      return "/";
    else
      return "\\";
  }

  /**
    * リリースコンパイル出力先ディレクトリを取得する
    * フルパス、ディレクトリ区切り子で終わる
    */
  public String getReleaseDir () {
    return release_directory;
  }
}

/* EOF */
