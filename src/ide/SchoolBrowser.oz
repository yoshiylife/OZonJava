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

class SchoolBrowser : *Frame {

	/**************
	 * ATTRIBUTES *
	 **************/
	School aSchool;
  ClassBrowser classBrowser;
	SubjectGarageBrowser subjectGarageBrowser;
	ApplicationGarageBrowser applGarageBrowser;
	String projectDir;

	//DECLARE CONTROLS
	FileDialog openFileDialog, saveFileDialog;
	Label lblSubject;
	Label lblLabel;
	List lstLabel;
	Label lblIfID;
	TextField txtIfID;
	Label lblImplID;
	TextField txtImplID;
	Choice choSubject;
	CheckboxGroup group;
	Checkbox rbtnDevelopment;
	Checkbox rbtnRelease;

	//DECLARE MENUS
	MenuBar mainMenuBar;
	Menu menu1;
	Menu menu2;
	Menu menu3;
	Menu menu4;
	Menu menu5;
	Menu menu6;
	Menu menu7;
	Menu menu8;
	MenuItem menuItemImport, menuItemExport, menuItemEnd, menuItemAdd,menuItemSelectSubjecs;
	MenuItem menuItemRemove, menuItemRename, menuItemIDGen, menuItemAddSubject;
	MenuItem menuItemRemoveSubject, menuItemRenameSubject, menuItemRun;
	MenuItem menuItemOpenCBif, menuItemOpenCBcl, menuItemSubjectExportIF;
	MenuItem menuItemSubjectExportCL, menuItemSubjectImport, menuItemAppResister;
	MenuItem menuItemVersion;

	//DECLARE Controllers
	SBController sbCtrl;
	ListLabelController listLabelCtrl;
	ChoiceSubjectController choiceSubjectCtrl;
	SubjectStateController subjectStateCtrl;

	EventDispatchingQueue queue;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SchoolBrowser"
	new create(EventDispatchingQueue queue) {
		super=>newFrame();

		initGUI();
		initMenu();
		// initialize FIleDialogs
		openFileDialog=>newFileLoadDialog(this, "IMPORT");
		saveFileDialog=>newFileSaveDialog(this, "EXPORT");
		// initialize School
		aSchool=>create();
		Dictionary subjects=>create();
		subjects = aSchool->getSubjects();
		Subject subject1=>create("lib");
		subject1->setImported(true);
		subjects->put("lib", subject1);
		choSubject->addItem("lib");
		Subject subject2=>create("ide");
		subject2->setImported(true);
		subjects->put("ide", subject2);
		choSubject->addItem("ide");
		Subject subject3=>create("sample");
		subjects->put("sample", subject3);
		choSubject->addItem("sample");

		// initialize Listeners
		activateListeners(queue);
	}

	public void initGUI() {
		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(1,2,10,10);
		setLayout(grid1);
		addNotify();
		setSize(500, 410);

		BorderLayout border1=>newBorderLayout();
		GridLayout grid2=>newGridLayout(12,1,10,10);

		Panel panel1=>newPanel(border1);
		Panel panel2=>newPanel(grid2);
		add(panel1);
		add(panel2);
		panel1->addNotify();
		panel2->addNotify();

		GridLayout grid3=>newGridLayout(1,2,10,10);
		Panel panel3=>newPanel(grid3);
		panel1->add("North", panel3);
		panel3->addNotify();
		lblSubject=>newLabel("  Subject :");
		panel3->add(lblSubject);
		choSubject=>newChoice();
		panel3->add(choSubject);

		lblLabel=>newLabel("  Label :");
		panel1->add("Center", lblLabel);

		lstLabel=>newList(20,false);
		panel1->add("South", lstLabel);

		group=>newCheckboxGroup();
		rbtnDevelopment=>newCheckbox("for Development", group, true);
		panel2->add(rbtnDevelopment);
		rbtnDevelopment->setVisible(false);
		rbtnRelease=>newCheckbox("for Release", group, false);
		panel2->add(rbtnRelease);
		rbtnRelease->setVisible(false);
		lblIfID=>newLabel("Interface ID : ");
		panel2->add(lblIfID);
		txtIfID=>newTextField("",30);
		panel2->add(txtIfID);
		Label lblTmp3=>newLabel();
		panel2->add(lblTmp3);
		lblImplID=>newLabel("Implementation ID : ");
		panel2->add(lblImplID);
		txtImplID=>newTextField("",30);
		panel2->add(txtImplID);
		txtIfID->setEditable(false);
		txtImplID->setEditable(false);

		setTitle("School Browser");
	}

	public void initMenu() {

		//INIT MENUS
		mainMenuBar=>newMenuBar();
		//1.File Menu
		menu1=>newMenu("File");
		menuItemImport=>newMenuItem("import...");
		menu1->add(menuItemImport);
		menuItemExport=>newMenuItem("export...");
		menu1->add(menuItemExport);
		menu1->addSeparator();
		menuItemEnd=>newMenuItem("end");
		menu1->add(menuItemEnd);
		mainMenuBar->add(menu1);
		//2.School Menu
		menu2=>newMenu("School");
		menuItemAdd=>newMenuItem("add class...");
		menu2->add(menuItemAdd);
		menuItemRemove=>newMenuItem("remove class...");
		menu2->add(menuItemRemove);
		menuItemRename=>newMenuItem("rename class...");
		menu2->add(menuItemRename);
		menu2->addSeparator();
		menuItemAddSubject=>newMenuItem("add subject...");
		menu2->add(menuItemAddSubject);
		menuItemRemoveSubject=>newMenuItem("remove subject...");
		menu2->add(menuItemRemoveSubject);
		menuItemRenameSubject=>newMenuItem("rename subject...");
		menu2->add(menuItemRenameSubject);
		menu2->addSeparator();
		menuItemIDGen=>newMenuItem("class ID Generate...");
		menu2->add(menuItemIDGen);
		menu2->addSeparator();
		menuItemSelectSubjecs=>newMenuItem("select subjects...");
		menu2->add(menuItemSelectSubjecs);
		mainMenuBar->add(menu2);
		//3.Subject Menu
		menu3=>newMenu("Run");
		menuItemRun=>newMenuItem("run...");
		menu3->add(menuItemRun);
		mainMenuBar->add(menu3);
		//4.ClassBrowser Menu
		menu4=>newMenu("ClassBrowser");
		menu6=>newMenu("open (selected label)");
		menu4->add(menu6);
		menuItemOpenCBif=>newMenuItem("interface part..");
		menu6->add(menuItemOpenCBif);
		menuItemOpenCBcl=>newMenuItem("implementaion part..");
		menu6->add(menuItemOpenCBcl);
		mainMenuBar->add(menu4);
		//5.Catalog Menu
		menu7=>newMenu("Catalog");
		menuItemSubjectImport=>newMenuItem("import subject...");
		menu7->add(menuItemSubjectImport);
		menu8=>newMenu("export subject");
		menu7->add(menu8);
		menuItemSubjectExportIF=>newMenuItem("interface part...");
		menu8->add(menuItemSubjectExportIF);
		menuItemSubjectExportIF->setEnabled(false);
		menuItemSubjectExportCL=>newMenuItem("implementation part...");
		menu8->add(menuItemSubjectExportCL);
		menuItemSubjectExportCL->setEnabled(false);
		menuItemAppResister=>newMenuItem("resister application...");
		menu7->add(menuItemAppResister);
		menuItemAppResister->setEnabled(false);
		mainMenuBar->add(menu7);
		//6.Help Menu
		menu5=>newMenu("Help");
		menuItemVersion=>newMenuItem("version...");
		menu5->add(menuItemVersion);
		mainMenuBar->add(menu5);

		setMenuBar(mainMenuBar);
	}

	/***********
	 * METHODS *
	 ***********/

	public void deleteListeners() {
		//Destroy Queue
		if (! queue->isDestroyed()) queue->destroy();
		queue = null;
		sbCtrl->destroyDlgQueue();
		sbCtrl->setDlgQueue(null);
		//Remove Listeners
		menuItemImport->removeActionListener(sbCtrl);
		menuItemExport->removeActionListener(sbCtrl);
		menuItemEnd->removeActionListener(sbCtrl);
		menuItemAdd->removeActionListener(sbCtrl);
		menuItemRemove->removeActionListener(sbCtrl);
		menuItemRename->removeActionListener(sbCtrl);
		menuItemIDGen->removeActionListener(sbCtrl);
		menuItemSelectSubjecs->removeActionListener(sbCtrl);
		menuItemAddSubject->removeActionListener(sbCtrl);
		menuItemRemoveSubject->removeActionListener(sbCtrl);
		menuItemRenameSubject->removeActionListener(sbCtrl);
		menuItemRun->removeActionListener(sbCtrl);
		menuItemOpenCBif->removeActionListener(sbCtrl);
		menuItemOpenCBcl->removeActionListener(sbCtrl);
		menuItemSubjectExportIF->removeActionListener(sbCtrl);
		menuItemSubjectExportCL->removeActionListener(sbCtrl);
		menuItemSubjectImport->removeActionListener(sbCtrl);
		menuItemAppResister->removeActionListener(sbCtrl);
		menuItemVersion->removeActionListener(sbCtrl);
		sbCtrl = null;
		lstLabel->removeItemListener(listLabelCtrl);
		listLabelCtrl = null;
		choSubject->removeItemListener(choiceSubjectCtrl);
		choiceSubjectCtrl = null;
		rbtnDevelopment->removeItemListener(subjectStateCtrl);
		rbtnRelease->removeItemListener(subjectStateCtrl);
		subjectStateCtrl = null;
		classBrowser = null;
		subjectGarageBrowser->quit();
		applGarageBrowser->quit();
	}

	public void activateListeners(EventDispatchingQueue q) {
		queue = q;
		EventDispatchingQueue dlgQueue => create();
		//Resister Listeners
		sbCtrl=>create(this, queue);
		sbCtrl->setDlgQueue(dlgQueue);
		menuItemImport->addActionListener(sbCtrl);
		menuItemExport->addActionListener(sbCtrl);
		menuItemEnd->addActionListener(sbCtrl);
		menuItemAdd->addActionListener(sbCtrl);
		menuItemRemove->addActionListener(sbCtrl);
		menuItemRename->addActionListener(sbCtrl);
		menuItemIDGen->addActionListener(sbCtrl);
		menuItemSelectSubjecs->addActionListener(sbCtrl);
		menuItemAddSubject->addActionListener(sbCtrl);
		menuItemRemoveSubject->addActionListener(sbCtrl);
		menuItemRenameSubject->addActionListener(sbCtrl);
		menuItemRun->addActionListener(sbCtrl);
		menuItemOpenCBif->addActionListener(sbCtrl);
		menuItemOpenCBcl->addActionListener(sbCtrl);
		menuItemSubjectExportIF->addActionListener(sbCtrl);
		menuItemSubjectExportCL->addActionListener(sbCtrl);
		menuItemSubjectImport->addActionListener(sbCtrl);
		menuItemAppResister->addActionListener(sbCtrl);
		menuItemVersion->addActionListener(sbCtrl);
		listLabelCtrl=>create(this, queue);
		lstLabel->addItemListener(listLabelCtrl);
		choiceSubjectCtrl=>create(this, queue);
		choSubject->addItemListener(choiceSubjectCtrl);
		subjectStateCtrl=>create(this, queue);
		rbtnDevelopment->addItemListener(subjectStateCtrl);
		rbtnRelease->addItemListener(subjectStateCtrl);
		// initialize ClassBrowser
		classBrowser=>newClassBrowser(aSchool);
		// initialize SubjectGarageBrowser
		subjectGarageBrowser=>create(this);
		// initialize ApplicationGarageBrowser
		applGarageBrowser=>create(this);
	}

	/**Shows or hides the component depending on the boolean flag b.
	 * @param	b:boolean
	 * @return	void
	 * @exception	Exception
	 */
	public void setVisible(boolean b){
		setLocation(10, 410);
		super->setVisible(b);
	}

	/** Show school data from the attribute "aSchool"
	 * @param	String : Subject Name
	 * @return	void
	 * @exception	Exception
	 */
	public void setSchoolList(String subjectName) {
		Dictionary labels = aSchool->getOzLabels(subjectName);
		Iterator lblIterator;

		lblIterator = labels->iterator();
		String sbjName=>breed();
		OzLabel lbl=>create();
		Subject subject;
		subject = aSchool->getSubject(subjectName);

		if(subject->isImported()) {
			rbtnDevelopment->setVisible(false);
			rbtnRelease->setVisible(false);
		} else {
			rbtnDevelopment->setVisible(true);
			rbtnRelease->setVisible(true);
			rbtnDevelopment->setState(!(subject->isReleased()));
			rbtnRelease->setState(subject->isReleased());
		}

		lstLabel->removeAll();
		txtIfID->setText("");
		txtImplID->setText("");
		while( lblIterator->hasMoreElements() ) {
			lbl =| lblIterator->nextElement();
			lstLabel->addItem(lbl->getOzLabelName());
		}
	}

	/** Merge Subject in this School
	 */
	public void mergeSubject(Subject subject) {
		aSchool->mergeSubject(subject);

		Dictionary subjects = aSchool->getSubjects();
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		choSubject->removeAll();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			choSubject->addItem(subject->getSubjectName());
		}
		setSchoolList(choSubject->getSelectedItem());
		DuplicateMessageDialog dlg=>create(this, true, queue);
		dlg->setVisible(true);
	}

	/** Access method for aSchool
	 * @param	
	 * @return	School
	 */
	public School getSchool() {
		return aSchool;
	}

	/** Access method for lstLabel
	 * @param	
	 * @return	List
	 */
	public List getLstLabel() {
		return lstLabel;
	}

	/** Access method for txtIfID
	 * @param	
	 * @return	TextField
	 */
	public TextField getTxtIfID() {
		return txtIfID;
	}

	/** Access method for txtImplID
	 * @param	
	 * @return	TextField
	 */
	public TextField getTxtImplID() {
		return txtImplID;
	}

	/** Access method for choSubject
	 * @param	
	 * @return	Choice
	 */
	public Choice getChoSubject() {
		return choSubject;
	}

	/** Access method for menuItemSubjectExportIF
	 * @return	MenuItem
	 */
	public MenuItem getMenuItemSubjectExportIF() {
		return menuItemSubjectExportIF;
	}

	/** Access method for menuItemSubjectExportCL
	 * @return	MenuItem
	 */
	public MenuItem getMenuItemSubjectExportCL() {
		return menuItemSubjectExportCL;
	}

	/** Access method for menuItemAppResister
	 * @return	MenuItem
	 */
	public MenuItem getMenuItemAppResister() {
		return menuItemAppResister;
	}

	/** Access method for openFileDialog
	 * @param	
	 * @return	FileDialog
	 */
	public FileDialog getOpenFileDialog() {
		return openFileDialog;
	}

	/** Access method for saveFileDialog
	 * @param	
	 * @return	FileDialog
	 */
	public FileDialog getSaveFileDialog() {
		return saveFileDialog;
	}

	/** Access method for classBrowser
	 * @param	
	 * @return	ClassBrowser
	 * @exception	Exception
	 */
	public ClassBrowser getClassBrowser() {
		return classBrowser;
	}

	/** Access method for subjectGarageBrowser
	 * @param	
	 * @return	SubjectGarageBrowser
	 * @exception	Exception
	 */
	public SubjectGarageBrowser getSubjectGarageBrowser() {
		return subjectGarageBrowser;
	}

	/** Access method for applGarageBrowser
	 * @param	
	 * @return	ApplicationGarageBrowser
	 * @exception	Exception
	 */
	public ApplicationGarageBrowser getApplicationGarageBrowser() {
		return applGarageBrowser;
	}

	/** Access method for rbtnDevelopment
	 * @param	
	 * @return	Checkbox
	 * @exception	Exception
	 */
	public Checkbox getRbtnDevelopment() {
		return rbtnDevelopment;
	}

	/** Access method for rbtnRelease
	 * @param	
	 * @return	Checkbox
	 * @exception	Exception
	 */
	public Checkbox getRbtnRelease() {
		return rbtnRelease;
	}

	/** Access method for projectDir
	 */
	public String getProjectDir() {
		return projectDir;
	}

	/** Access method for projectDir
	 */
	public void setProjectDir(String dir) {
		projectDir = dir;
	}
}
