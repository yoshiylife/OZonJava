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

class SubjectAddDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblSubject;
	TextField txtSubject;
	Button btnOK;
	Button btnCancel;
	SubjectAddActionListener addAL;
	School school;
	SchoolBrowser schoolBrowser;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SubjectAddDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();

		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(3,1,10,10);
		setLayout(grid1);
		addNotify();
		setSize(280, 130);
		Font font=>newFont("TimesRoman", 12);
		lblSubject=>newLabel("   Subject");
		lblSubject->setFont(font);
		add(lblSubject);

		FlowLayout flow1=>newFlowLayout(1,40,3);
		Panel panel1=>newPanel(flow1);
		add(panel1);
		panel1->addNotify();
		txtSubject=>newTextField(30);
		txtSubject->setFont(font);
		panel1->add(txtSubject);

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

		setTitle("ADD SUBJECT DIALOG");

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

	/** Add subject to the subjects dictionary in the school
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void addSubject() {
		String subjectName=>breed(txtSubject->getText());
		if (subjectName->compareTo("")!=0) {
			Subject subject=>create(txtSubject->getText());
			school->putSubject(subject);
			schoolBrowser->getChoSubject()->addItem(subjectName);
		}
	}

	/** Access method for btnOK
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnOK() {
		return btnOK;
	}
}
