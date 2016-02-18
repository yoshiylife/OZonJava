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

class SBController : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	SchoolBrowser sbr;
	EventDispatchingQueue dlgQueue;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SBController"
	// This controlls the menus of SchoolBrowser
	new create(SchoolBrowser s, EventDispatchingQueue q) {
		super=>newActionListener(q);
//		dlgQueue => create();
		sbr = s;
	}

	/***********
	 * METHODS *
	 ***********/
	/**Invoked when button click actions occur. 
	 * @param	event:ActionEvent
	 * @return	void
	 * @exception	Exception
	 */
	public void actionPerformed(ActionEvent event) {
		Frame frame = sbr;
		StringBuffer fName=>breed();
		String file, subjectName, menuItem;
		menuItem = event->getActionCommand();
		if ( menuItem->compareTo("")==0 ) {
		}
		else if ( menuItem->compareTo("import...")==0 ) {
			importEvnet();
		}
		else if ( menuItem->compareTo("export...")==0 ) {
			exportEvnet();
		}
		else if ( menuItem->compareTo("end")==0 ) {
			QuitDialog quitDlg=>create(frame, true, dlgQueue);
			quitDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("add class...")==0 ) {
			LabelAddDialog lblAddDlg=>create(sbr, true, dlgQueue);
			lblAddDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("remove class...")==0 ) {
			LabelDeleteDialog lblDelDlg=>create(sbr, true, dlgQueue);
			lblDelDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("rename class...")==0 ) {
			if (sbr->getLstLabel()->getSelectedItem()==null) return;
			String labelName = sbr->getLstLabel()->getSelectedItem();
			LabelEditDialog lblEditDlg=>create(sbr, true, labelName, dlgQueue);
			lblEditDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("add subject...")==0 ) {
			SubjectAddDialog sbjAddDlg=>create(sbr, true, dlgQueue);
			sbjAddDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("remove subject...")==0 ) {
			SubjectDeleteDialog sbjDelDlg=>create(sbr, true, dlgQueue);
			sbjDelDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("rename subject...")==0 ) {
			SubjectEditDialog sbjEditDlg=>create(sbr, true, dlgQueue);
			sbjEditDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("class ID Generate...")==0 ) {
			IDGenDialog idGenDlg=>create(sbr, true, dlgQueue);
			idGenDlg->setVisible(true);
			String subjectName = sbr->getChoSubject()->getSelectedItem();
			Subject subject = sbr->getSchool()->getSubject(subjectName);
			if (subject->isReleased())
				sbr->getSchool()->toReleasState(subjectName);
		}
		else if ( menuItem->compareTo("select subjects...")==0 ) {
			SubjectSelectDialog sbjSelDlg=>create(sbr, true, dlgQueue);
			sbjSelDlg->setVisible(true);
		}
		else if ( menuItem->compareTo("run...")==0 ) {
			runEvent();
		}
		else if ( menuItem->compareTo("interface part..")==0 ) {
			classBrowserEvent(1);
		}
		else if ( menuItem->compareTo("implementaion part..")==0 ) {
			classBrowserEvent(2);
		}
		else if ( menuItem->compareTo("interface part...")==0 ) {
			releaseEvent(1);
		}
		else if ( menuItem->compareTo("implementation part...")==0 ) {
			releaseEvent(2);
		}
		else if ( menuItem->compareTo("import subject...")==0 ) {
			importSubjectEvnet();
		}
		else if ( menuItem->compareTo("resister application...")==0 ) {
			resisterApplicationEvnet();
		}
		else if ( menuItem->compareTo("version...")==0 ) {
			AboutDialog aboutDlg=>create(frame, true, dlgQueue);
			aboutDlg->setVisible(true);
		}
	}

	/*******************************************/
	/***   Begin of Event Process Methods    ***/
	/*******************************************/
	public void importEvnet() {
		StringBuffer fName=>breed();
		String file, subjectName;
		sbr->getOpenFileDialog()->setFile("*.s");
		sbr->getOpenFileDialog()->addNotify();
		sbr->getOpenFileDialog()->setVisible(true);
		file = sbr->getOpenFileDialog()->getFile();
		if (file != null ) {
			fName->append(sbr->getOpenFileDialog()->getDirectory());
			fName->append(sbr->getOpenFileDialog()->getFile());
			// call the loadFromFile method in class School
			subjectName = sbr->getChoSubject()->getSelectedItem();
			sbr->getSchool()->loadFromFile(fName->asString(), subjectName);
			// show the new school
			sbr->setSchoolList(sbr->getChoSubject()->getSelectedItem());
		}
	}

	public void exportEvnet() {
		StringBuffer fName=>breed();
		String file, subjectName;
		sbr->getSaveFileDialog()->setFile("*.s");
		sbr->getSaveFileDialog()->setVisible(true);
		file = sbr->getSaveFileDialog()->getFile();
		if (file != null ) {
			fName->append(sbr->getSaveFileDialog()->getDirectory());
			fName->append(sbr->getSaveFileDialog()->getFile());
			// call the saveToFile method in class School
			subjectName = sbr->getChoSubject()->getSelectedItem();
			sbr->getSchool()->saveToFile(fName->asString(), subjectName);
		}
	}

	public void classBrowserEvent(int flag) {	//flag=1:interface  2::implementation
		StringBuffer buf=>breed("JP.go.ipa.oz");
		String ClassID;
		if(flag==1)
			ClassID = sbr->getTxtIfID()->getText();
		else if(flag==2)
			ClassID = sbr->getTxtImplID()->getText();
		if(!(ClassID->startsWith(".")) && sbr->getRbtnDevelopment()->getState())
			buf->append(".user.");
		else if(!(ClassID->startsWith(".")) && sbr->getRbtnRelease()->getState())
			buf->append(".user.released.");
		buf->append(ClassID);
	  try{
			sbr->getClassBrowser()->show(buf->asString());
	  } catch (CIException ex) {}
	}

	public void runEvent() {
		if (sbr->getLstLabel()-> getSelectedItem()==null ) return;
		SBUtility sbUtil=>create(sbr);
	}

	public void importSubjectEvnet() {
		SubjectGarageBrowser subjectGarageBrowser = sbr->getSubjectGarageBrowser();
		subjectGarageBrowser->importSubject();
	}

	public void releaseEvent(int flag) {
		//get Subject and set th mode
		String subjectName = sbr->getChoSubject()->getSelectedItem();
		Subject subject = sbr->getSchool()->getSubject(subjectName);
		subject->setReleaseMode(flag);

		//create the ZIP file
		CompilerAgent ozc=>create(sbr->getSchool());
		ozc->release(sbr->getProjectDir(), flag, "test");

		//get the file object of zip file
		System system=>create();
		String ozHome = system->getOzHome();
		StringBuffer classPath;
		String kugiri;
		if (ozHome->startsWith("/"))
			kugiri = "/";
		else
			kugiri = "\\";
		classPath =>breed(ozHome);
		if (!(ozHome->endsWith(kugiri)))
			classPath ->append(kugiri);
		classPath ->append("objects");
		classPath ->append(kugiri);
		classPath ->append("ide");
		classPath ->append(kugiri);
		classPath ->append("tmp");
		classPath ->append(kugiri);
		classPath ->append("test.zip");
		File file =>breed(classPath->asString());

		//register the zip classes to LocalRepository
		String topPackageName = subject->getPackageName();
	 	LocalRepositoryManager localMgr=>create();
		localMgr->add(file, topPackageName);

		if (flag==1 || flag==2) {
			//export the Subject
			SubjectGarageBrowser subjectGarageBrowser = sbr->getSubjectGarageBrowser();
			subjectGarageBrowser->launch();
			subjectGarageBrowser->exportSubject(subject);
		} else if (flag==3) {
			Application app=>create(getCIDofCell(topPackageName));
			ApplicationGarageBrowser applGarageBrowser = sbr->getApplicationGarageBrowser();
			applGarageBrowser->launch();
			applGarageBrowser->exportApplication(app);
		}
	}

	public void resisterApplicationEvnet() {
		releaseEvent(3);
	}

	public String getCIDofCell(String pkgName) {

		//get the class output directory
		System system=>create();
		String ozHome = system->getOzHome();
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

		//get the Cell class file
		String tmp;
		Array fileList;
		File file=>breed(buf->asString());
		ExtensionFilter classFilter=>create(".class");
		fileList = file->list(classFilter);
		if (fileList==null) {
			return null;
		} else {
			int max = fileList->size();
			for(int i=0; i<max; i++){
				tmp =| fileList->at(i);
				if(tmp->endsWith("_pcl.class"))
					break;
			}
		}

		//get the CID of Cell
		StringBuffer cid =>breed(pkgName);
		cid->append(".");
		cid->append(tmp->substring(0, tmp->lastIndexOf("_")));
		cid->append("_cl");
system->println(cid->asString());
		return cid->asString();
	}

	/*******************************************/
	/***   End of Event Process Methods      ***/
	/*******************************************/

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
}
