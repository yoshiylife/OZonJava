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

class SubjectEditDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblSubject;
	Choice choSubject;
	TextField txtSubject;
	Button btnOK;
	Button btnCancel;
	SubjectEditActionListener editAL;
	School school;
	SchoolBrowser schoolBrowser;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SubjectEditDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();

		//INIT_CONTROLS
		GridLayout grid1=>newGridLayout(4,1,10,10);
		setLayout(grid1);
		addNotify();
		setSize(280, 170);
		Font font=>newFont("TimesRoman", 12);
		lblSubject=>newLabel("   Subject");
		lblSubject->setFont(font);
		add(lblSubject);
		txtSubject=>newTextField();
		txtSubject->setFont(font);
		add(txtSubject);
		choSubject=>newChoice();
		Iterator lblIterator;
		lblIterator = school->getSubjects()->iterator();
		Subject subject;
		while( lblIterator->hasMoreElements() ) { 
			subject =| lblIterator->nextElement();
			choSubject->addItem(subject->getSubjectName());
		}
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

		setTitle("SUBJECT MODIFY DIALOG");

		//Resister Listeners
		editAL=>create(this, queue);
		btnOK->addActionListener(editAL);
		btnCancel->addActionListener(editAL);
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

	/** Modify subject in the subjects dictionary in the school
	 * @param	
	 * @return	void
	 * @exception	Exception
	 */
	public void removeSubject() {
		String subjectNameOld = choSubject->getSelectedItem();
		String subjectNameNew = txtSubject->getText();
		if (subjectNameOld->compareTo(subjectNameNew)!=0 && subjectNameNew->compareTo("")!=0) {
			school->renameSubject(subjectNameOld, subjectNameNew);
			schoolBrowser->getChoSubject()->remove(subjectNameOld);
			schoolBrowser->getChoSubject()->addItem(subjectNameNew);
			schoolBrowser->getChoSubject()->select(subjectNameNew);
			schoolBrowser->setSchoolList(subjectNameNew);
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
