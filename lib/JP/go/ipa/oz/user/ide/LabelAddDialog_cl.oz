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

class LabelAddDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Button btnOK;
	Button btnCancel;
	Choice choSubject;
	TextField txtLabel;
	TextField txtIfID;
	TextField txtImplID;
	Label lblSubject;
	Label lblLabel;
	Label lblIfID;
	Label lblImplID;
	LabelAddActionListener addAL;
	School school;
	SchoolBrowser schoolBrowser;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "LabelAddDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();

		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(5,1,10,10);
		setLayout(grid1);
		addNotify();
		setSize(330, 200);
		Font font=>newFont("TimesRoman", 12);

		GridLayout grid2=>newGridLayout(1,2);
		Panel panel1=>newPanel(grid2);
		add(panel1);
		panel1->addNotify();
		lblSubject=>newLabel("   Subject :");
		lblSubject->setFont(font);
		panel1->add(lblSubject);
		choSubject=>newChoice();
		Iterator lblIterator;
		lblIterator = school->getSubjects()->iterator();
		Subject subject;
		while( lblIterator->hasMoreElements() ) { 
			subject =| lblIterator->nextElement();
			choSubject->addItem(subject->getSubjectName());
		}
		choSubject->setFont(font);
		panel1->add(choSubject);

		GridLayout grid3=>newGridLayout(1,2);
		Panel panel2=>newPanel(grid3);
		add(panel2);
		panel2->addNotify();
		lblLabel=>newLabel("   Class Name : ");
		lblLabel->setFont(font);
		panel2->add(lblLabel);
		txtLabel=>newTextField();
		txtLabel->setFont(font);
		panel2->add(txtLabel);

		GridLayout grid4=>newGridLayout(1,2);
		Panel panel3=>newPanel(grid4);
		add(panel3);
		panel3->addNotify();
		lblIfID=>newLabel("   Interface ID :");
		lblIfID->setFont(font);
		panel3->add(lblIfID);
		txtIfID=>newTextField();
		txtIfID->setFont(font);
		panel3->add(txtIfID);

		GridLayout grid5=>newGridLayout(1,2);
		Panel panel4=>newPanel(grid5);
		add(panel4);
		panel4->addNotify();
		lblImplID=>newLabel("   Implementaion ID :");
		lblImplID->setFont(font);
		panel4->add(lblImplID);
		txtImplID=>newTextField();
		txtImplID->setFont(font);
		panel4->add(txtImplID);

		FlowLayout flow=>newFlowLayout(1,40,3);
		Panel panel5=>newPanel(flow);
		add(panel5);
		panel5->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel5->add(btnOK);
		btnCancel=>newButton("Cancel");
		btnCancel->setFont(font);
		panel5->add(btnCancel);

		setTitle("ADD LABEL DIALOG");

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

	/** Add Label to the School
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void putLabel() {
		if (txtLabel->getText()->compareTo("")==0) return;
		OzLabel label=>create();
		label->setSubjectName(choSubject->getSelectedItem());
		label->setOzLabelName(txtLabel->getText());
		label->setInterfaceID(txtIfID->getText());
		label->setImplementationID(txtImplID->getText());
		school->putOzLabel(label, choSubject->getSelectedItem());
	}

	/** Access method for schoolBrowser
	 * @param	
	 * @return	SchoolBrowser
	 * @exception	Exception
	 */
	public SchoolBrowser getSchoolBrowser() {
		return schoolBrowser;
	}

	/** Access method for btnOK
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnOK() {
		return btnOK;
	}

	/** Access method for choSubject
	 * @param	
	 * @return	Choice
	 * @exception	Exception
	 */
	public Choice getChoSubject() {
		return choSubject;
	}
}
