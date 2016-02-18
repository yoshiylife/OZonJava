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

class AddFileDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblDirName;
	Label lblFileName;
	List lstDirName;
	List lstFileName;
	Choice choDrive;
	Button btnAddDir;
	Button btnCancel;
	AddFileActionListener addAL;
	AddFileItemListener addIL;
	String ozHome;
	ProjectManager projectManager;
	int ozEnv;	//0:WIndows 1:Unix
	Array files;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "AddFileDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		projectManager =| parent;

		//Initialize GUIs
		initGUI();

		System system=>create();
		ozHome = system->getOzHome();
		if (ozHome->startsWith("/")) {
			ozEnv = 1;
			choDrive->setVisible(false);
		} else {
			ozEnv = 0;
			choDrive->select(ozHome->substring(0,2));
		}

		setDirectory(ozHome);

		//Resister Listeners
		addAL=>create(this, queue);
		btnAddDir->addActionListener(addAL);
		btnCancel->addActionListener(addAL);
		lstDirName->addActionListener(addAL);
		addIL=>create(this, queue);
		choDrive->addItemListener(addIL);
	}

	/***********
	 * METHODS *
	 ***********/
	/**initialize the GUIs
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void initGUI() {
		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();

		setSize(500, 400);
		GridLayout grid1=>newGridLayout(1,2,20,20);
		GridLayout grid2=>newGridLayout(1,2,20,20);
		GridLayout grid3=>newGridLayout(1,3,40,40);
		Panel panel1=>newPanel(grid1);
		Panel panel2=>newPanel(grid2);
		Panel panel3=>newPanel(grid3);
		add("North", panel1);
		add("Center", panel2);
		add("South", panel3);
		panel1->addNotify();
		panel2->addNotify();
		panel3->addNotify();

		lblDirName=>newLabel("Directory");
		panel1->add(lblDirName);
		lblFileName=>newLabel("File");
		panel1->add(lblFileName);

		lstDirName=>newList(10,false);
		panel2->add(lstDirName);
		lstFileName=>newList(10,true);
		panel2->add(lstFileName);

		choDrive=>newChoice();
		setItem();
		panel3->add(choDrive);
		btnAddDir=>newButton("set dir");
		panel3->add(btnAddDir);
		btnCancel=>newButton("Cancel");
		panel3->add(btnCancel);
	}

	public void setItem() {
		choDrive->addItem("a:");
		choDrive->addItem("b:");
		choDrive->addItem("c:");
		choDrive->addItem("d:");
		choDrive->addItem("e:");
		choDrive->addItem("f:");
		choDrive->addItem("g:");
		choDrive->addItem("h:");
		choDrive->addItem("i:");
		choDrive->addItem("j:");
		choDrive->addItem("k:");
		choDrive->addItem("l:");
		choDrive->addItem("m:");
		choDrive->addItem("n:");
		choDrive->addItem("o:");
		choDrive->addItem("p:");
		choDrive->addItem("q:");
		choDrive->addItem("r:");
		choDrive->addItem("s:");
		choDrive->addItem("t:");
		choDrive->addItem("u:");
		choDrive->addItem("v:");
		choDrive->addItem("w:");
		choDrive->addItem("x:");
		choDrive->addItem("y:");
		choDrive->addItem("z:");
	}

	/**Shows or hides the component depending on the boolean flag b.
	 * @param	b:boolean
	 * @return	void
	 * @exception	Exception
	 */
	public void setVisible(boolean b) {
		setLocation(50,50);
		super->setVisible(b);
	}

	/** Access method for files
	 * @param	
	 * @return	Array
	 * @exception	Exception
	 */
	public Array getFiles() {
		return files;
	}

	/** Access method for files
	 * @param	selectedFiles : Array
	 * @return	void
	 * @exception	Exception
	 */
	public void setFiles(Array selectedFiles) {
		files = selectedFiles;
	}

	/** Set the Directory List
	 * @param	dirName : String(full path)
	 * @return	void
	 * @exception	Exception
	 */
	public void setDirectory(String dirName) {
		Array dirList;
		File file => breed(dirName);
		DirectoryFilter filter=>create();
		dirList = file->list(filter);
		int max;
		String tmp;
		if (dirList==null) return;
		lstDirName->removeAll();
		if (file->getParent()!=null)
			lstDirName->addItem("..");
		max = dirList->size();
		for(int i=0; i<max; i++){
			tmp =| dirList->at(i);
			lstDirName->addItem(tmp);
		}
		setTitle(dirName);
		setFile(dirName);
	}

	/** Set the Selected Directory List
	 * @param	dirName : String(not full path)
	 * @return	void
	 * @exception	Exception
	 */
	public void setNextDirectory() {
		String selectedDirName;
		selectedDirName = lstDirName->getSelectedItem();

		if(selectedDirName->compareTo("..")!=0) {
			StringBuffer dirName=>breed();
			dirName->append(getTitle());
			if (!(getTitle()->endsWith("\\")) && !(getTitle()->endsWith("/"))) {
				if (ozEnv==0)
					dirName->append("\\");
				else
					dirName->append("/");
			}
			dirName->append(selectedDirName);
			setDirectory(dirName->asString());
		} else {
			File file => breed(getTitle());
			String upperDirName;
			upperDirName = file->getParent();
			if (upperDirName==null) return;
			setDirectory(upperDirName);
		}
	}

	/** Set the File List
	 * @param	fileName : String
	 * @return	void
	 * @exception	Exception
	 */
	public void setFile(String fileName) {
		Array fileList;
		File file => breed(fileName);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		int max;
		String tmp;
		if (fileList==null) return;
		max = fileList->size();
		lstFileName->removeAll();
		for(int i=0; i<max; i++){
			tmp =| fileList->at(i);
			lstFileName->addItem(tmp);
		}
	}

	/** Change the Drive (for Windows only)
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void changeDrive() {
		String newDrive;
		newDrive = choDrive->getSelectedItem();
		StringBuffer buf=>breed(newDrive);
		buf->append("\\");
		File file => breed(buf->asString());
		if (file->isDirectory())
			setDirectory(buf->asString());
		else
			choDrive->select(getTitle()->substring(0,2));
	}

	/** Get the Selected File List
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public Array getSelectedFiles() {
		Array fileList;
		fileList =| lstFileName->getSelectedItems();
		if (fileList->size()==0) return null;

		StringBuffer dirName=>breed();
		dirName->append(getTitle());
		if (ozEnv==0)
			dirName->append("\\");
		else
			dirName->append("/");
		String path;
		path = dirName->asString();

		String tmp;
		int max;
		max = fileList->size();
		for(int i=0; i<max; i++){
			dirName=>breed(path);
			tmp =| fileList->at(i);
			dirName->append(tmp);
			fileList->putAt(i, dirName->asString());
		}
		return fileList;
	}

	/** Get the File in Selected Directory
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public Array getFilesInDirectory() {
		StringBuffer dirName=>breed();
		dirName->append(getTitle());
		if (ozEnv==0)
			dirName->append("\\");
		else
			dirName->append("/");
		if (lstDirName->getSelectedItem()==null) return null;
		dirName->append(lstDirName->getSelectedItem());
		if (ozEnv==0)
			dirName->append("\\");
		else
			dirName->append("/");
		String path;
		path = dirName->asString();

		Array fileList;
		File file => breed(path);
		ExtensionFilter filter=>create(".oz");
		fileList = file->list(filter);
		if (fileList==null) return null;

		String tmp;
		int max;
		max = fileList->size();
		for(int i=0; i<max; i++){
			dirName=>breed(path);
			tmp =| fileList->at(i);
			dirName->append(tmp);
			fileList->putAt(i, dirName->asString());
		}
		return fileList;
	}
}
