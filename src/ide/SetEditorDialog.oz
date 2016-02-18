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

class SetEditorDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblMessage;
	TextField txtEditor;
	Button btnSet;
	Button btnCancel;
	SetEditorActionListener editorAL;
	ProjectManager projectManager;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SetEditorDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		projectManager =| parent;

		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(3,1,10,10);
		setLayout(grid1);
		addNotify();
		setSize(280, 130);
		Font font=>newFont("TimesRoman", 12);
		lblMessage=>newLabel("   Set your editor by full path.");
		lblMessage->setFont(font);
		add(lblMessage);

		FlowLayout flow1=>newFlowLayout(1,40,3);
		Panel panel1=>newPanel(flow1);
		add(panel1);
		panel1->addNotify();
		if (projectManager->getEditor()!=null)
			txtEditor=>newTextField(projectManager->getEditor(), 30);
		else
			txtEditor=>newTextField(30);
		txtEditor->setFont(font);
		panel1->add(txtEditor);

		FlowLayout flow2=>newFlowLayout(1,40,3);
		Panel panel2=>newPanel(flow2);
		add(panel2);
		panel2->addNotify();
		btnSet=>newButton("Set");
		btnSet->setFont(font);
		panel2->add(btnSet);
		btnCancel=>newButton("Cancel");
		btnCancel->setFont(font);
		panel2->add(btnCancel);

		setTitle("Set Editor Dialog");

//		enableEvents(AWTEvent->getWINDOW_EVENT_MASK());

		//Resister Listeners
		editorAL=>create(this, queue);
		btnSet->addActionListener(editorAL);
		btnCancel->addActionListener(editorAL);
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
            this->dispose();      		// Free the system resource
            this->setVisible(false);		// hide the Frame
		}
	}
*/

	/**set the editor
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void setEditor() {
		if (txtEditor->getText()==null || txtEditor->getText()->compareTo("")==0) return;
		projectManager->setEditor(txtEditor->getText());
	}
}
