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

class IDGenDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	CheckboxGroup group;
	Checkbox rbtnSelected;
	Checkbox rbtnSubject;
	Choice choSubject;
	Button btnOK;
	Button btnCancel;
	Label lblComment;
	Label lblIfID;
	Label lblImplID;
	Label lblHead;
	TextField txtIfHead;
	TextField txtImpleHead;
	IDGenActionListener genAL;
	IDGenItemListener genIL;
	School school;
	SchoolBrowser schoolBrowser;
	ClassIDGenerator idGen;
	OzLabel label;
	Array ruleOfInterfaceID;
	Array ruleOfImplementationID;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "IDGenDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();
		idGen=>create();;
		if(schoolBrowser->getLstLabel()->getSelectedItem()!=null)
			label = school->getOzLabel(schoolBrowser->getLstLabel()->getSelectedItem());
		else
			label = null;
		ruleOfInterfaceID=>create(2);
		ruleOfImplementationID=>create(2);

		//INIT CONTROLS
		GridLayout grid1=>newGridLayout(8,1);
		setLayout(grid1);
		addNotify();
		setSize(400, 250);
		Font font=>newFont("TimesRoman", 12);
		group=>newCheckboxGroup();
		rbtnSelected=>newCheckbox("generate the ID for selected Labels.", group, true);
		rbtnSelected->setFont(font);
		add(rbtnSelected);
		rbtnSubject=>newCheckbox("generate the ID for Labaels belonging to the same Subject.", group, false);
		rbtnSubject->setFont(font);
		add(rbtnSubject);
		choSubject=>newChoice();
		Iterator lblIterator;
		lblIterator = school->getSubjects()->iterator();
		Subject subject=>create();
		while( lblIterator->hasMoreElements() ) { 
			subject =| lblIterator->nextElement();
			choSubject->addItem(subject->getSubjectName());
		}
		choSubject->setEnabled(false);
		choSubject->setFont(font);
		add(choSubject);
		lblComment=>newLabel("  Rule of generation : ");
		lblComment->setFont(font);
		add(lblComment);

		GridLayout grid2=>newGridLayout(1,2);
		Panel panel1=>newPanel(grid2);
		add(panel1);
		panel1->addNotify();
		Label lblDummy=>newLabel("");
		panel1->add(lblDummy);
		lblHead=>newLabel("PREFIX");
		lblHead->setFont(font);
		panel1->add(lblHead);

		ruleOfInterfaceID = idGen->getRuleOfInterfaceID();
		ruleOfImplementationID = idGen->getRuleOfImplementationID();
		String tmp=>breed();

		GridLayout grid3=>newGridLayout(1,2);
		Panel panel2=>newPanel(grid3);
		add(panel2);
		panel2->addNotify();
		lblIfID=>newLabel("  InterfaceID");
		lblIfID->setFont(font);
		panel2->add(lblIfID);
		tmp =| ruleOfInterfaceID->at(0);
		txtIfHead=>newTextField(tmp);
		txtIfHead->setFont(font);
		panel2->add(txtIfHead);

		GridLayout grid4=>newGridLayout(1,2);
		Panel panel3=>newPanel(grid4);
		add(panel3);
		panel3->addNotify();
		lblImplID=>newLabel("  ImplementaionID");
		lblImplID->setFont(font);
		panel3->add(lblImplID);
		tmp =| ruleOfImplementationID->at(0);
		txtImpleHead=>newTextField(tmp);
		txtImpleHead->setFont(font);
		panel3->add(txtImpleHead);

		FlowLayout flow1=>newFlowLayout(1,20,3);
		Panel panel4=>newPanel(flow1);
		add(panel4);
		panel4->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel4->add(btnOK);
		btnCancel=>newButton("Cancel");
		btnCancel->setFont(font);
		panel4->add(btnCancel);
		setTitle("Generate Interface and Implementation ID");

		//Resister Listeners
		genAL=>create(this, queue);
		btnOK->addActionListener(genAL);
		btnCancel->addActionListener(genAL);
		genIL=>create(this, queue);
		rbtnSelected->addItemListener(genIL);
		rbtnSubject->addItemListener(genIL);
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
		setLocation(bounds->getX() + 50, bounds->getY() + 50);
		super->setVisible(b);
	}

	/**Processes window events occurring on this window by dispatching them
	 * to any registered WindowListener objects. 
	 * @param	event:WindowEvent
	 * @return	void
	 * @exception	Exception
	 */

	/** Generate and set the ID for one label.
	 * @param	label : OzLabel
	 * @return	void
	 * @exception	Exception
	 */
	public void generateID(OzLabel label) {
		//set the ClassIDGenerator
		ruleOfInterfaceID->putAt(0, txtIfHead->getText());
		ruleOfInterfaceID->putAt(1, "_if");
		ruleOfImplementationID->putAt(0, txtImpleHead->getText());
		ruleOfImplementationID->putAt(1, "_cl");
		idGen->setRuleOfInterfaceID(ruleOfInterfaceID);
		idGen->setRuleOfImplementationID(ruleOfImplementationID);
		//generate the ID and set the ID to the label.
		label->setInterfaceID(idGen->generateInterfaceID(label->getOzLabelName()));
		label->setImplementationID(idGen->generateImplementationID(label->getOzLabelName()));
	}

	/** Generate and set the ID for labels belonging to the same subject.
	 * @param	subjectName : String
	 * @return	void
	 * @exception	Exception
	 */
	public void generateID(String subjectName) {
		OzLabel tmpLabel;
		Dictionary labels = school->getOzLabels(subjectName);
		Iterator lblIterator;
		lblIterator = labels->iterator();

		//set the ClassIDGenerator
		ruleOfInterfaceID->putAt(0, txtIfHead->getText());
		ruleOfInterfaceID->putAt(1, "_if");
		ruleOfImplementationID->putAt(0, txtImpleHead->getText());
		ruleOfImplementationID->putAt(1, "_cl");
		idGen->setRuleOfInterfaceID(ruleOfInterfaceID);
		idGen->setRuleOfImplementationID(ruleOfImplementationID);

		while( lblIterator->hasMoreElements() ) { 
			tmpLabel =| lblIterator->nextElement();
			tmpLabel->setInterfaceID(idGen->generateInterfaceID(tmpLabel->getOzLabelName()));
			tmpLabel->setImplementationID(idGen->generateImplementationID(tmpLabel->getOzLabelName()));
		}

	}

	/** Access method for choSubject
	 * @param	
	 * @return	Choice
	 * @exception	Exception
	 */
	public Choice getChoSubject() {
		return choSubject;
	}

	/** Access method for rbtnSelected
	 * @param	
	 * @return	Checkbox
	 * @exception	Exception
	 */
	public Checkbox getRbtnSelected() {
		return rbtnSelected;
	}

	/** Access method for rbtnSubject
	 * @param	
	 * @return	Checkbox
	 * @exception	Exception
	 */
	public Checkbox getRbtnSubject() {
		return rbtnSubject;
	}

	/** Access method for btnOK
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnOK() {
		return btnOK;
	}

	/** Access method for btnCancel
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnCancel() {
		return btnCancel;
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

	/** Access method for idGen
	 * @param	
	 * @return	ClassIDGenerator
	 * @exception	Exception
	 */
	public ClassIDGenerator getIdGen() {
		return idGen;
	}

	/** Access method for label
	 * @param	
	 * @return	OzLabel
	 * @exception	Exception
	 */
	public OzLabel getLabel() {
		return label;
	}
}
