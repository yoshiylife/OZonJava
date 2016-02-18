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

class LabelDeleteDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	CheckboxGroup group;
	Checkbox rbtnSelected;
	Checkbox rbtnSubject;
	Choice choSubject;
	Button btnOK;
	Button btnCancel;
	LabelDeleteActionListener deleteAL;
	LabelSelectItemListener selectIL;
	String labelName;
	School school;
	SchoolBrowser schoolBrowser;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "LabelDeleteDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();

		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(4,1,10,10);
		setLayout(grid1);
		addNotify();
		setSize(300, 170);
		Font font=>newFont("TimesRoman", 12);

		group=>newCheckboxGroup();
		rbtnSelected=>newCheckbox("delete selected Labels.", group, true);
		rbtnSelected->setFont(font);
		add(rbtnSelected);
		rbtnSubject=>newCheckbox("delete Labels belonging to the same Subject.", group, false);
		rbtnSubject->setFont(font);
		add(rbtnSubject);
		choSubject=>newChoice();
		Iterator lblIterator;
		lblIterator = school->getSubjects()->iterator();
		Subject subject;
		while( lblIterator->hasMoreElements() ) { 
			subject =| lblIterator->nextElement();
			choSubject->addItem(subject->getSubjectName());
		}
		choSubject->setEnabled(false);
		choSubject->setFont(font);
		add(choSubject);

		FlowLayout flow=>newFlowLayout(1,40,3);
		Panel panel=>newPanel(flow);
		add(panel);
		panel->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel->add(btnOK);
		btnCancel=>newButton("Cancel");
		btnCancel->setFont(font);
		panel->add(btnCancel);

		setTitle("DELETE LABEL DIALOG");
		labelName = schoolBrowser->getLstLabel()->getSelectedItem();

//		enableEvents(AWTEvent->getWINDOW_EVENT_MASK());

		//Resister Listeners
		deleteAL=>create(this, queue);
		btnOK->addActionListener(deleteAL);
		btnCancel->addActionListener(deleteAL);
		selectIL=>create(this, queue);
		rbtnSelected->addItemListener(selectIL);
		rbtnSubject->addItemListener(selectIL);
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
		switch(event.getID()) {
		case WindowEvent->getWINDOW_CLOSING():
			this->dispose();      		// Free the system resource
			this->setVisible(false);		// not show the Frame
		}
	}
*/

	/** Access method for labelName
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public String getLabelName() {
		return labelName;
	}

	/** Access method for rbtnSubject
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public Checkbox getRbtnSubject() {
		return rbtnSubject;
	}

	/** Access method for choSubject
	 * @param	
	 * @return	Choice
	 * @exception	Exception
	 */
	public Choice getChoSubject() {
		return choSubject;
	}

	/** Access method for school
	 * @param	
	 * @return	School
	 * @exception	Exception
	 */
	public School getSchool() {
		return school;
	}

	/** Access method for schoolBrowser
	 * @param	
	 * @return	SchoolBrowser
	 * @exception	Exception
	 */
	public SchoolBrowser getSchoolBrowser() {
		return schoolBrowser;
	}
}
