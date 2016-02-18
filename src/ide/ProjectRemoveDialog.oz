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

class ProjectRemoveDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblProject;
	List lstProjectName;
	Button btnOK;
	Button btnCancel;
	ProjectRemoveActionListener addAL;
	ProjectManager projectManager;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "ProjectRemoveDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		projectManager =| parent;

		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(300, 250);
		Font font=>newFont("TimesRoman", 12);
		lblProject=>newLabel("   Project Name");
		lblProject->setFont(font);
		add("North", lblProject);

		lstProjectName=>newList(20,false);
		lstProjectName->setFont(font);
		add("Center", lstProjectName);

		FlowLayout flow=>newFlowLayout(1,40,3);
		Panel panel=>newPanel(flow);
		add("South", panel);
		panel->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel->add(btnOK);
		btnCancel=>newButton("Cancel");
		btnCancel->setFont(font);
		panel->add(btnCancel);

		setTitle("REMOVE PROJECT DIALOG");

		// set the project list in the list box
		Dictionary dict = projectManager->getProjects();
		Iterator lblIterator;
		lblIterator  = dict->iterator();
		Project prj;
		while( lblIterator->hasMoreElements() ) {
			prj =| lblIterator->nextElement();
			lstProjectName->addItem(prj->getProjectName());
		}

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
		return lstProjectName->getSelectedItem();
	}


	/** remove the project in the ProjectManager
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void removeProject() {
		String projectName;
		projectName = lstProjectName->getSelectedItem();
		if (projectName==null) return;
		if (projectManager->getProjectName()->compareTo(projectName)==0) return;

		// set the gui
		lstProjectName->remove(projectName);

		Dictionary dict = projectManager->getProjects();
		dict->remove(projectName);
	}
}
