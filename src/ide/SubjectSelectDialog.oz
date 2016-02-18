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

class SubjectSelectDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblSubject;
	List lstSubject;
	Button btnOK;
	Button btnCancel;
	SubjectSelectActionListener selectAL;
	School school;
	SchoolBrowser schoolBrowser;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SubjectSelectDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();

		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(300, 350);
		Font font=>newFont("TimesRoman", 12);
		lblSubject=>newLabel("   Select the subject you want to use.");
		lblSubject->setFont(font);
		add("North", lblSubject);

		lstSubject=>newList(20,true);
		Iterator lblIterator;
		lblIterator = school->getSubjects()->iterator();
		Subject subject;
		while( lblIterator->hasMoreElements() ) { 
			subject =| lblIterator->nextElement();
			lstSubject->addItem(subject->getSubjectName());
		}
		lstSubject->setFont(font);
		add("Center", lstSubject);

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

		setTitle("SUBJECT SELECT DIALOG");

		//Resister Listeners
		selectAL=>create(this, queue);
		btnOK->addActionListener(selectAL);
		btnCancel->addActionListener(selectAL);
	}

	/***********
	 * METHODS *
	 ***********/
	/**Shows or hides the component depending on the boolean flag b.
	 */
	public void setVisible(boolean b) {
		Rectangle bounds = getParent()->getBounds();
		Rectangle abounds = getBounds();
		setLocation(bounds->getX() + (bounds->getWidth() - abounds->getWidth())/ 2,
								bounds->getY() + (bounds->getHeight() - abounds->getHeight())/2);

		super->setVisible(b);
	}

	/** コンパイルの際に利用するサブジェクトを設定する。
      subject.using=trueとする
	 */
	public void selectSubjects() {
		Array subjectNames;
		subjectNames =| lstSubject->getSelectedItems();
		String subjectName;
		int max = subjectNames->size();
		if (max==0) return;

		//全てのサブジェクトを一旦using=falseに設定する
		Dictionary subjects = school->getSubjects();
		Iterator sbjIterator = subjects->iterator();
		Subject subject;
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			subject->setUsing(false);
		}
		schoolBrowser->getChoSubject()->removeAll();

		//選択されているサブジェクトだけusing=trueに設定する
		for(int i=0; i<max; i++){
			subjectName =| subjectNames->at(i);
			subject = school->getSubject(subjectName);
			subject->setUsing(true);
			schoolBrowser->getChoSubject()->addItem(subjectName);
		}
		schoolBrowser->setSchoolList(subjectName);
	}

	/** Access method for btnOK
	 */
	public Button getBtnOK() {
		return btnOK;
	}
}
