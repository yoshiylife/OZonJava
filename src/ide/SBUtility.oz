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

class SBUtility {
	/**************
	 * ATTRIBUTES *
	 **************/
	SchoolBrowser sbr;
	String ozHome;


	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SBUtility"
	new create(SchoolBrowser s) {
		sbr = s;
		System system=>create();
		ozHome = system->getOzHome();
		makeTmpDir();
		StringBuffer command;
		Process process;
		if (getPath()==null) return;
		if (ozHome->startsWith("/")) {
			command=>breed("oz -f ");
		} else {
			command=>breed("oz.bat -f ");
		}
		command->append(getScriptPath());
		makeScript();
		process=>create(command->asString());
	}

	new create(String ClassID, String GOL, String param) {
		System system=>create();
		ozHome = system->getOzHome();
		makeTmpDir();
		StringBuffer command;
		Process process;
		if (ozHome->startsWith("/")) {
			command=>breed("oz -f ");
		} else {
			command=>breed("oz.bat -f ");
		}
		command->append(getScriptPath());
		makeScript(ClassID, GOL, param);
		process=>create(command->asString());
	}

	/***********
	 * METHODS *
	 ***********/
	/**make the script file for execute cell 
	 */
	public void makeScript() {
		String scriptPath = getScriptPath();
		StringBuffer buf = constructScript();
		makeScriptFile(scriptPath, buf);
	}

	public StringBuffer constructScript() {
		StringBuffer buf=>breed();
		//create the script
		buf=>breed("create ");
		buf->append(makeGOD());
		buf->append(" ");
		String classID = sbr->getSchool()->getImplementationID(sbr->getLstLabel()->getSelectedItem());
		buf->append(classID);
		buf->append("\n");
		buf->append("watch ");
		buf->append(makeGOD());
		buf->append("\n");
		return buf;
	}

	public void makeScript(String ClassID, String GOL, String param) {
		String scriptPath = getScriptPath();
		StringBuffer buf = constructScript(ClassID, GOL, param);
		makeScriptFile(scriptPath, buf);
	}

	public StringBuffer constructScript(String ClassID, String GOL, String param) {
		StringBuffer buf=>breed();
		//create the script
		buf=>breed("create ");
		if( GOL==null || GOL->compareTo("")!=0 )
			buf->append(makeGOD());
		else
			buf->append(GOL);
		buf->append(" ");
		buf->append(ClassID);
		if( param!=null && param->compareTo("")!=0) {
			buf->append(" ");
			buf->append(param);
		}
		buf->append("\n");
		buf->append("watch ");
		if( GOL==null || GOL->compareTo("")==0 )
			buf->append(makeGOD());
		else
			buf->append(GOL);
		buf->append("\n");
		return buf;
	}

	public String getScriptPath() {
		StringBuffer buf=>breed(ozHome);
		String scriptPath;
		if (ozHome->startsWith("/")) {
			if (ozHome->endsWith("/"))
				buf->append("objects/ide/tmp/tmpTest");
			else
				buf->append("/objects/ide/tmp/tmpTest");
		} else {
			if (ozHome->endsWith("\\"))
				buf->append("objects\\ide\\tmp\\tmpTest");
			else
				buf->append("\\objects\\ide\\tmp\\tmpTest");
		}
		scriptPath = buf->asString();
		//delete the script file
		File file=>breed(scriptPath);
		if (file!=null) file->delete();

		return scriptPath;
	}

	public void makeScriptFile(String scriptPath, StringBuffer script) {
		//create the script file
		try{
			FileOutputStream fout=>breed(scriptPath);
			OutputStreamWriter osw=>breed(fout);
			BufferedWriter bw=>breed(osw);
			int len = script->length();
			bw->write(script->asString(), 0, len);
			bw->close();
			fout->close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	/**get the full path for selected cell 
	 */
	public String getPath() {
		StringBuffer buf=>breed();
		String classID, fullPath;

		classID = sbr->getSchool()->getImplementationID(sbr->getLstLabel()->getSelectedItem());
		classID = classID->substring(0,classID->lastIndexOf("_"));

		if (ozHome->startsWith("/")) {
			classID = classID->replace('.', '/');
			buf->append(ozHome);
			if (ozHome->endsWith("/"))
				buf->append("lib/");
			else
				buf->append("/lib/");
			buf->append(classID);
		} else {
			classID = classID->replace('.', '\\');
			buf->append(ozHome);
			if (ozHome->endsWith("\\"))
				buf->append("lib\\");
			else
				buf->append("\\lib\\");
			buf->append(classID);
		}
		buf->append("_pcl.class");
		fullPath = buf->asString();
		File file=>breed(fullPath);
		if (file->exists()) return fullPath;
		else return null;
	}

	public void makeTmpDir() {
		File file=>breed(getTmpDir());
		if(!file->exists())
			file->mkdir();
	}

	public String getTmpDir() {
		StringBuffer buf=>breed(ozHome);
		if (ozHome->startsWith("/")) {
			if (ozHome->endsWith("/"))
				buf->append("objects/ide/tmp/");
			else
				buf->append("/objects/ide/tmp/");
		} else {
			if (ozHome->endsWith("\\"))
				buf->append("objects\\ide\\tmp\\");
			else
				buf->append("\\objects\\ide\\tmp\\");
		}
		return buf->asString();
	}

	public String makeGOD() {
		StringBuffer buf=>breed(getTmpDir());
		buf->append("testExec");
		File file=>breed(buf->asString());
		buf=>breed("ide.tmp.testExec.");
		buf->append("0 ");
		if(!(file->isDirectory())) return buf->asString();

		Array sourceList = file->list();
		Integer intObj=>breed(sourceList->size());
		buf=>breed("ide.tmp.testExec.");
		buf->append(intObj->asString());
		return buf->asString();
	}
}
