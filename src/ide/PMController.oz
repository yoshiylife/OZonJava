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

class PMController : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	ProjectManager prj;
	EventDispatchingQueue dlgQueue;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "PMController"
	// This controlls the menus of ProjectManager
	new create(ProjectManager p, EventDispatchingQueue q) {
		super=>newActionListener(q);
//		dlgQueue => create();
		prj = p;
	}

	/***********
	 * METHODS *
	 ***********/

	/*******************************************/
	/***   Begin of Event Process Methods    ***/
	/*******************************************/
	public void saveEvent() {
		prj->deleteListeners();
		prj->getSchoolBrowser()->deleteListeners();
		flushCell();
		EventDispatchingQueue pmQueue => create();
		prj->activateListeners(pmQueue);
		EventDispatchingQueue sbQueue => create();
		prj->getSchoolBrowser()->activateListeners(sbQueue);
	}

	public void refreshEvent() {
		if(prj->getProjectDir()==null || prj->getProjectDir()->compareTo("")==0) return;

		prj->getSrcList()->removeAll();
		Dictionary dict = prj->getProjects();
		String projectName;
		projectName = prj->getProjectName();
		Project project;
		project =| dict->get(projectName);
		project->removeAllFiles();

		Array fileList;
		File file => breed(project->getProjectDir());
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return;
		String tmp;
		int max;
		max = fileList->size();
		for(int i=0; i<max; i++){
			tmp =| fileList->at(i);
			if(!(tmp->endsWith("_cl.oz"))) {
				prj->getSrcList()->addItem(tmp);
				project->addFile(tmp);
			}
		}
	}

	public void setDirEvent() {
		AddFileDialog addDialog=>create(prj, true, dlgQueue);
		addDialog->setVisible(true);
		Array files;
		files = addDialog->getFiles();
		if (files==null) return;
		Dictionary dict = prj->getProjects();
		String projectName = prj->getProjectName();
		Project project;
		project =| dict->get(projectName);
		String tmp;
		int max;
		max = files->size();
		if(max == 0) return;	//OZファイルがない場合は設定しない

		// set the Project Directory
		int point;
		tmp =| files->at(0);
		if(tmp->lastIndexOf("\\")!=-1) point = tmp->lastIndexOf("\\");
		if(tmp->lastIndexOf("/")!=-1) point = tmp->lastIndexOf("/");
		project->setProjectDir(tmp->substring(0,point));
		prj->setProjectDir(tmp->substring(0,point));
		File tmpFile;
		// set the Project Files
		for(int i=0; i<max; i++){
			tmp =| files->at(i);
			if(!(tmp->endsWith("_cl.oz"))) {
				tmpFile=>breed(tmp);
				prj->getSrcList()->addItem(tmpFile->getName());
				project->addFile(tmpFile->getName());
			}
		}
		prj->getSchoolBrowser()->setProjectDir(prj->getProjectDir());
		refreshEvent();
	}

	public void compileEvent(int flag) {	//flag=1:implementation 2:interface
		CompilerAgent ozc;
		School school;
		StringBuffer fileName;
		String ozHome, separator;
		System system=>create();
		ozHome = system->getOzHome();
		if (ozHome->startsWith("/"))
			separator = "/";
		else
			separator = "\\";
		fileName=>breed(prj->getProjectDir());
		fileName->append(separator);
		fileName->append(prj->getSrcList()->getSelectedItem());

		school = prj->getSchoolBrowser()->getSchool();
		ozc=>create(school);
		CompileInfoDialog comInfoDlg=>create(prj, false, dlgQueue);
		comInfoDlg->setVisible(true);
		StringWriter out=>breed();
		CompileLog cl=>create(out, comInfoDlg);
		if(flag==1){
			if (!(ozc->compile(fileName->asString(), cl))) {
				comInfoDlg->appendText("Compile failed!!!");
			}
		} else if(flag==2){
			if (!(ozc->compileInterface(fileName->asString(), cl))) {
				comInfoDlg->appendText("Compile failed!!!");
			}
		}
		comInfoDlg->setButtonEnabled(true);
	}

	public void compileSubjectEvent() {
		CompilerAgent ozc;
		School school;
		school = prj->getSchoolBrowser()->getSchool();
		ozc=>create(school);
		CompileInfoDialog comInfoDlg=>create(prj, false, dlgQueue);
		comInfoDlg->setVisible(true);
		StringWriter out=>breed();
		CompileLog cl=>create(out, comInfoDlg);
		ozc->compileSubject(prj->getProjectDir(), cl); 
		comInfoDlg->setButtonEnabled(true);
	}

	public void compileReleaseEvent() {
		CompilerAgent ozc;
		School school;
		school = prj->getSchoolBrowser()->getSchool();
		ozc=>create(school);
		CompileInfoDialog comInfoDlg=>create(prj, false, dlgQueue);
		comInfoDlg->setVisible(true);
		StringWriter out=>breed();
		CompileLog cl=>create(out, comInfoDlg);
		ozc->compileSubjectForRelease(prj->getProjectDir(), cl); 
		comInfoDlg->setButtonEnabled(true);
	}

	public void compileAutoEvent() {
		CompilerAgent ozc;
		School school;
		ClassBrowser cb;

		school = prj->getSchoolBrowser()->getSchool();
		cb = prj->getSchoolBrowser()->getClassBrowser();
		CompilerUtility cu=>create(school,cb);
		ozc=>create(school,cu);
		CompileInfoDialog comInfoDlg=>create(prj, false, dlgQueue);
		comInfoDlg->setVisible(true);
		StringWriter out=>breed();
		CompileLog cl=>create(out, comInfoDlg);
		ozc->compileAuto(prj->getProjectDir(), cl); 
		comInfoDlg->setButtonEnabled(true);
	}

	/*******************************************/
	/***   End of Event Process Methods      ***/
	/*******************************************/

	/**Invoked when button click actions occur. 
	 * @param	event:ActionEvent
	 * @return	void
	 * @exception	Exception
	 */
	public void actionPerformed(ActionEvent event) {
		Frame frame = prj;
		String menuItem;
		menuItem = event->getActionCommand();

		if ( menuItem->compareTo("")==0 ) {
		}
		else if ( menuItem->compareTo("new")==0 ) {
			prj->setProjectDir("");
			prj->getSrcList()->removeAll();
			ProjectNewDialog newDlg=>create(prj, true, dlgQueue);
			newDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("open...")==0 ) {
			ProjectOpenDialog openDlg=>create(prj, true, dlgQueue);
			openDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("save")==0 ) {
			saveEvent();
		}
		else if ( menuItem->compareTo("save as...")==0 ) {
			ProjectSaveAsDialog saveAsDlg=>create(prj, true, dlgQueue);
			saveAsDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("remove...")==0 ) {
			ProjectRemoveDialog openDlg=>create(prj, true, dlgQueue);
			openDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("end")==0 ) {
			QuitDialog quitDlg=>create(frame, true, dlgQueue);
			quitDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("refresh")==0 && prj->getSrcList()->getSelectedItem()!=null) {
			refreshEvent();
		}
		else if ( menuItem->compareTo("set directory...")==0 ) {
			setDirEvent();
		}
		else if ( menuItem->compareTo("edit file")==0 ) {
			prj->openEditor();
		}
		else if ( menuItem->compareTo("set editor...")==0 ) {
			SetEditorDialog setEditDlg=>create(prj, true, dlgQueue);
			setEditDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("compile")==0 ) {
			if (prj->getSrcList()->getSelectedItem()==null) return;
			compileEvent(1);
		}
		else if ( menuItem->compareTo("compile interface")==0 ) {
			if (prj->getSrcList()->getSelectedItem()==null) return;
			compileEvent(2);
		}
		else if ( menuItem->compareTo("compile subject")==0 ) {
			compileSubjectEvent();
		}
		else if ( menuItem->compareTo("compile for release")==0 ) {
			if(checkSubjectState())
				compileReleaseEvent();
			else {
				AboutDialog aboutDlg=>create(frame, true, dlgQueue, "Subject is not a Release mode!", "Can not compile");
				aboutDlg->setVisible(true);
			}
		}
		else if ( menuItem->compareTo("compile auto")==0 ) {
			compileAutoEvent();
		}
		else if ( menuItem->compareTo("version...")==0 ) {
			AboutDialog aboutDlg=>create(frame, true, dlgQueue);
			aboutDlg->setVisible(true);
		}
	}

	/** Access method for dlgQueue
	 * @param	
	 * @return	EventDispatchingQueue
	 * @exception	Exception
	 */
	public EventDispatchingQueue getDlgQueue() {
		return dlgQueue;
	}

	/** Access method for dlgQueue
	 * @param	q : EventDispatchingQueue
	 * @return	void
	 * @exception	Exception
	 */
	public void setDlgQueue(EventDispatchingQueue q) {
		dlgQueue = q;
	}

	/** destroy dlgQueue
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void destroyDlgQueue() {
		if (!dlgQueue->isDestroyed()) dlgQueue->destroy();
	}

	/** サブジェクトのリリース状態チェック
			true :リリースコンパイル可能
			false:リリースコンパイル不可
	 */
	public boolean checkSubjectState() {
		School school = prj->getSchoolBrowser()->getSchool();
		Dictionary dict = prj->getProjects();
		String projectName = prj->getProjectName();
		Project project;
		project =| dict->get(projectName);
		Array lblNames = project->getFiles();
		String lblName;
		lblName =| lblNames->at(1);
		OzLabel label = school->getOzLabel(lblName->substring(0, lblName->lastIndexOf(".")));
		String sbjName = label->getSubjectName();
		Subject subject = school->getSubject(sbjName);
		return subject->isReleased();
	}
}
