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

class ProjectSaveAsDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblProject;
	TextField txtProjectName;
	Button btnOK;
	Button btnCancel;
	ProjectSaveAsActionListener addAL;
	ProjectManager projectManager;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "ProjectSaveAsDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		projectManager =| parent;

		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(3,1,10,10);
		setLayout(grid1);
		addNotify();
		setSize(280, 130);
		Font font=>newFont("TimesRoman", 12);
		lblProject=>newLabel("   Project Name");
		lblProject->setFont(font);
		add(lblProject);

		FlowLayout flow1=>newFlowLayout(1,40,3);
		Panel panel1=>newPanel(flow1);
		add(panel1);
		panel1->addNotify();
		txtProjectName=>newTextField(30);
		txtProjectName->setFont(font);
		panel1->add(txtProjectName);

		FlowLayout flow2=>newFlowLayout(1,40,3);
		Panel panel2=>newPanel(flow2);
		add(panel2);
		panel2->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel2->add(btnOK);
		btnCancel=>newButton("Cancel");
		btnCancel->setFont(font);
		panel2->add(btnCancel);

		setTitle("SAVE AS PROJECT DIALOG");

		txtProjectName->setText(projectManager->getProjectName());

//		enableEvents(AWTEvent->getWINDOW_EVENT_MASK());

		//Resister Listeners
		addAL=>create(this, queue);
		btnOK->addActionListener(addAL);
		btnCancel->addActionListener(addAL);
	}

	/***********
	 * METHODS *
	 ***********/
	/**Shows or hides the component depending on the boolean flag b.
	 * @param	b:boolean
	 * @return	void
	 * @exception	Exception
	 */
	public void setVisible(boolean b) {
		Rectangle bounds = getParent()->getBounds();
		Rectangle abounds = getBounds();
		setLocation(bounds->getX() + (bounds->getWidth() - abounds->getWidth())/ 2,
								bounds->getY() + (bounds->getHeight() - abounds->getHeight())/2);

		super->setVisible(b);
	}

	/**Processes window events occurring on this window by dispatching them
	 * to any registered WindowListener objects. 
	 * @param	event:WindowEvent
	 * @return	void
	 * @exception	Exception
	 */
/*
	public void processWindowEvent(WindowEvent event) {
		switch(event->getID()) {
    	case WindowEvent->getWINDOW_CLOSING():
            this->dispose();			// Free the system resource
            this->setVisible(false);	// hide the Frame
		}
	}
*/

	/** get for Project Name
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public String getProjectName() {
		return txtProjectName->getText();
	}


	/** add the project in the ProjectManager
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public void saveAsProject() {
		String projectName;
		projectName = txtProjectName->getText();
		if (projectName->compareTo("")!=0) {
			int size;
			size = projectManager->getSrcList()->getItemCount();

			Dictionary dict = projectManager->getProjects();
			Project prj=>create(projectName);
			projectManager->setProjectName(projectName);
			dict->put(projectName, prj);

			for(int i=0; i<size; i++) {
				prj->addFile(projectManager->getSrcList()->getItem(i));
			}

			// set the gui
			StringBuffer buf=>breed("OZ Project Manager [");
			buf->append(getProjectName());
			buf->append("]");
			projectManager->setTitle(buf->asString());
		}
	}
}
