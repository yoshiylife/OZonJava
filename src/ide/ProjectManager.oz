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

class ProjectManager : *Frame{

	/**************
	 * ATTRIBUTES *
	 **************/
	SchoolBrowser schoolBrowser;
	Dictionary projects;// Dictionary of Projects
	String projectName;	// Selecting Project Name
	String fName;				// Selecting File Name
	String editor;			// editor used by user

	//DECLARE CONTROLS
	List srcList;
	Label lblProjectDir;
	Label lblProjectFiles;
	TextField txtProjectDir;
	Button btnRefresh;

	//DECLARE MENUS
	MenuBar mainMenuBar;
	Menu menu1;
	Menu menu2;
	Menu menu4;
	Menu menu3;
	MenuItem menuItemNew, menuItemOpen, menuItemSave, menuItemSaveAs;
	MenuItem menuItemProjectRemove,menuItemEnd, menuItemRefresh, menuItemSetDir;
	MenuItem menuItemEdit, menuItemSetEditor;
	MenuItem menuItemCompile, menuItemCompileIf, menuItemCompileSubject, menuItemCompileRelease;
	MenuItem menuItemCompileAuto, menuItemHelp;

	//DECLARE Controllers (for Action Event)
	PMController pmCtrl;
	ListController listCtrl;
	RefreshController refreshCtrl;

	EventDispatchingQueue queue;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "ProjectManager"
	new create(EventDispatchingQueue queue) {

		super=>newFrame();

		// Initialize the projects and set defaut project
		StringComparator sc=>create();
		projects=>create(sc);
		projectName=>breed();
		fName=>breed();
		String projectName=>breed("Project1");
		Project prj=>create(projectName);
		setProjectName(projectName);
		projects->put(projectName, prj);
		setTitle("OZ Project Manager [Project1]");

		initGUI();
		initMenu();

		// initialize Listeners
		activateListeners(queue);

	}

	public void initGUI() {
		//INIT CONTROLS
		BorderLayout border1=>newBorderLayout();
		setLayout(border1);
		addNotify();
		setSize(400, 400);

		GridLayout grid1=>newGridLayout(3,1);
		Panel panel1=>newPanel(grid1);
		add("North", panel1);
		panel1->addNotify();

		FlowLayout flow1=>newFlowLayout(0,10,10);
		Panel panel2=>newPanel(flow1);
		panel1->add(panel2);
		panel2->addNotify();
		lblProjectDir=>newLabel("Project Directory :");
		panel2->add(lblProjectDir);

		FlowLayout flow2=>newFlowLayout(0,10,10);
		Panel panel3=>newPanel(flow2);
		panel1->add(panel3);
		panel3->addNotify();
		txtProjectDir=>newTextField(50);
		panel3->add(txtProjectDir);
		txtProjectDir->setEditable(false);

		FlowLayout flow3=>newFlowLayout(0,10,10);
		Panel panel4=>newPanel(flow3);
		panel1->add(panel4);
		panel4->addNotify();
		lblProjectFiles=>newLabel("Project Files :");
		panel4->add(lblProjectFiles);
		btnRefresh=>newButton("Refresh");
		panel4->add(btnRefresh);

		srcList=>newList(20,false);
		add("Center", srcList);
	}

	public void initMenu() {
		//INIT MENUS
		mainMenuBar=>newMenuBar();
		//1.Project Menu
		menu1=>newMenu("Project");
		menuItemNew=>newMenuItem("new");
		menu1->add(menuItemNew);
		menuItemOpen=>newMenuItem("open...");
		menu1->add(menuItemOpen);
		menuItemSave=>newMenuItem("save");
		menu1->add(menuItemSave);
		menuItemSaveAs=>newMenuItem("save as...");
		menu1->add(menuItemSaveAs);
		menuItemProjectRemove=>newMenuItem("remove...");
		menu1->add(menuItemProjectRemove);
		menu1->addSeparator();
		menuItemEnd=>newMenuItem("end");
		menu1->add(menuItemEnd);
		mainMenuBar->add(menu1);
		//2.Edit Menu
		menu2=>newMenu("Edit");
		menuItemRefresh=>newMenuItem("refresh");
		menu2->add(menuItemRefresh);
		menuItemSetDir=>newMenuItem("set directory...");
		menu2->add(menuItemSetDir);
		menu2->addSeparator();
		menuItemEdit=>newMenuItem("edit file");
		menu2->add(menuItemEdit);
		menuItemSetEditor=>newMenuItem("set editor...");
		menu2->add(menuItemSetEditor);
		mainMenuBar->add(menu2);
		//3.Compile Menu
		menu3=>newMenu("Compile");
		menuItemCompile=>newMenuItem("compile");
		menu3->add(menuItemCompile);
		menuItemCompileIf=>newMenuItem("compile interface");
		menu3->add(menuItemCompileIf);
		menuItemCompileSubject=>newMenuItem("compile subject");
		menu3->add(menuItemCompileSubject);
		menuItemCompileRelease=>newMenuItem("compile for release");
		menu3->add(menuItemCompileRelease);
		menuItemCompileAuto=>newMenuItem("compile auto");
		menu3->add(menuItemCompileAuto);
		mainMenuBar->add(menu3);
		//4.Help Menu
		menu4=>newMenu("Help");
		menuItemHelp=>newMenuItem("version...");
		menu4->add(menuItemHelp);
		mainMenuBar->add(menu4);
		setMenuBar(mainMenuBar);
	}

	/***********
	 * METHODS *
	 ***********/

	public void deleteListeners() {
		//Destroy Queue
		if (! queue->isDestroyed()) queue->destroy();
		queue = null;
		pmCtrl->destroyDlgQueue();
		pmCtrl->setDlgQueue(null);
		//Remove Listeners
		menuItemNew->removeActionListener(pmCtrl);
		menuItemOpen->removeActionListener(pmCtrl);
		menuItemSave->removeActionListener(pmCtrl);
		menuItemSaveAs->removeActionListener(pmCtrl);
		menuItemProjectRemove->removeActionListener(pmCtrl);
		menuItemEnd->removeActionListener(pmCtrl);
		menuItemRefresh->removeActionListener(pmCtrl);
		menuItemSetDir->removeActionListener(pmCtrl);
		menuItemEdit->removeActionListener(pmCtrl);
		menuItemSetEditor->removeActionListener(pmCtrl);
		menuItemCompile->removeActionListener(pmCtrl);
		menuItemCompileIf->removeActionListener(pmCtrl);
		menuItemCompileSubject->removeActionListener(pmCtrl);
		menuItemCompileRelease->removeActionListener(pmCtrl);
		menuItemCompileAuto->removeActionListener(pmCtrl);
		menuItemHelp->removeActionListener(pmCtrl);
		pmCtrl = null;
		srcList->removeActionListener(listCtrl);
		listCtrl = null;
		btnRefresh->removeActionListener(refreshCtrl);
		refreshCtrl = null;
	}

	public void activateListeners(EventDispatchingQueue q) {
		queue = q;
		EventDispatchingQueue dlgQueue => create();
		//Resister Listeners
		pmCtrl=>create(this, queue);
		pmCtrl->setDlgQueue(dlgQueue);
		menuItemNew->addActionListener(pmCtrl);
		menuItemOpen->addActionListener(pmCtrl);
		menuItemSave->addActionListener(pmCtrl);
		menuItemSaveAs->addActionListener(pmCtrl);
		menuItemProjectRemove->addActionListener(pmCtrl);
		menuItemEnd->addActionListener(pmCtrl);
		menuItemRefresh->addActionListener(pmCtrl);
		menuItemSetDir->addActionListener(pmCtrl);
		menuItemEdit->addActionListener(pmCtrl);
		menuItemSetEditor->addActionListener(pmCtrl);
		menuItemCompile->addActionListener(pmCtrl);
		menuItemCompileIf->addActionListener(pmCtrl);
		menuItemCompileSubject->addActionListener(pmCtrl);
		menuItemCompileRelease->addActionListener(pmCtrl);
		menuItemCompileAuto->addActionListener(pmCtrl);
		menuItemHelp->addActionListener(pmCtrl);
		listCtrl=>create(this, queue);
		srcList->addActionListener(listCtrl);
		refreshCtrl=>create(this, queue);
		btnRefresh->addActionListener(refreshCtrl);
	}

	/**Shows or hides the component depending on the boolean flag b.
	 * @param	b:boolean
	 * @return	void
	 * @exception	Exception
	 */
	public void setVisible(boolean b) {
    	setLocation(10, 10);
    	super->setVisible(b);
   }

	/**execute the editor
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void openEditor() {
		StringBuffer edit;
		Process process;

		if (editor==null || editor->compareTo("")==0) return;

		String ozHome, separator;
		System system=>create();
		ozHome = system->getOzHome();
		if (ozHome->startsWith("/"))
			separator = "/";
		else
			separator = "\\";

		try{
			if(srcList->getSelectedItem()!=null) {
				edit=>breed(editor);
				edit->append(" ");
				edit->append(txtProjectDir->getText());
				edit->append(separator);
				edit->append(srcList->getSelectedItem());
				process=>create(edit->asString());
			}
		} catch (IOException e){
			;
		} catch (Exception e){
			;
		}
	}

	/**Access method for schoolBrowser
	 * @param	sb : SchoolBrowser
	 * @return	void
	 * @exception	Exception
	 */
	public void setSchoolBrowser(SchoolBrowser sb) {
		schoolBrowser = sb;
	}

	/**Access method for schoolBrowser
	 * @param	
	 * @return	SchoolBrowser
	 * @exception	Exception
	 */
	public SchoolBrowser getSchoolBrowser() {
		return schoolBrowser;
	}

	/**Access method for projects
	 * @param	
	 * @return	Dictionary
	 * @exception	Exception
	 */
	public Dictionary getProjects() {
		return projects;
	}

	/**Access method for projects
	 * @param	prj : Dictionary
	 * @return	void
	 * @exception	Exception
	 */
	public void setProjects(Dictionary prj) {
		projects = prj;
	}

	/**Access method for projectName
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public String getProjectName() {
		return projectName;
	}

	/**Access method for projectName
	 * @param	prjName : String
	 * @return	void
	 * @exception	Exception
	 */
	public void setProjectName(String prjName) {
		projectName = prjName;
	}

	/**Access method for fName
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public String getFName() {
		return fName;
	}

	/**Access method for fName
	 * @param	fileName : String
	 * @return	void
	 * @exception	Exception
	 */
	public void setFName(String fileName) {
		fName = fileName;
	}

	/**Access method for List
	 * @param	
	 * @return	List
	 * @exception	Exception
	 */
	public List getSrcList() {
		return srcList;
	}

	/**Access method for editor
	 * @param	ed : String
	 * @return	void
	 * @exception	Exception
	 */
	public void setEditor(String ed) {
		editor = ed;
	}

	/**Access method for editor
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public String getEditor() {
		return editor;
	}

	/**set Project Directory
	 * @param	ed : String
	 * @return	void
	 * @exception	Exception
	 */
	public void setProjectDir(String projectDir) {
		txtProjectDir->setText(projectDir);
	}

	/**get Project Directory
	 * @param	ed : 
	 * @return	String
	 * @exception	Exception
	 */
	public String getProjectDir() {
		return txtProjectDir->getText();
	}
}
