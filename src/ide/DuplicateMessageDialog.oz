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

class DuplicateMessageDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblDuplicate;
	List lstDuplicate;
	Button btnOK;
	DuplicateMessageActionListener deleteAL;
	School school;
	SchoolBrowser schoolBrowser;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "DuplicateMessageDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		schoolBrowser =| parent;
		school = schoolBrowser->getSchool();

		//INIT CONTROLS
		BorderLayout grid1=>newBorderLayout();
		setLayout(grid1);
		addNotify();
		setSize(300, 300);
		Font font=>newFont("TimesRoman", 12);
		lblDuplicate=>newLabel("   List of Duplicate Labels. Please modify them.");
		lblDuplicate->setFont(font);
		add("North", lblDuplicate);
		lstDuplicate=>newList(10);

		String lblName, dupLblName;
		StringBuffer tmp;
		Set tmpSet = school->getDuplicates()->keys();
		Iterator tmpIterator = tmpSet->iterator();
		while( tmpIterator->hasMoreElements() ) {
			lblName =| tmpIterator->nextElement();
			dupLblName =| school->getDuplicates()->get(lblName);
			tmp=>breed(lblName);
			tmp->append(", ");
			tmp->append(dupLblName);
			lstDuplicate->addItem(tmp->asString());
		}
		lstDuplicate->setFont(font);
		add("Center", lstDuplicate);

		FlowLayout flow=>newFlowLayout(1,40,3);
		Panel panel=>newPanel(flow);
		add("South", panel);
		panel->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel->add(btnOK);

		setTitle("DUPLICATE LABEL DIALOG");

		//Resister Listeners
		deleteAL=>create(this, queue);
		btnOK->addActionListener(deleteAL);
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

	/** Access method for btnOK
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnOK() {
		return btnOK;
	}
}
