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

class AboutDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Label lblVersion;
	Button btnOK;
	AboutActionListener aal;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "AboutDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(300, 100);
		Font font=>newFont("TimesRoman", 12);
		FlowLayout flow1=>newFlowLayout();
		Panel panel1=>newPanel(flow1);
		add("Center", panel1);
		lblVersion=>newLabel("OZ Development Environment Ver.1.1");
		lblVersion->setFont(font);
		panel1->add(lblVersion);

		FlowLayout flow2=>newFlowLayout();
		Panel panel2=>newPanel(flow2);
		add("South", panel2);
		panel2->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel2->add(btnOK);

		setTitle("Version Information");

		//Resister Listeners
		aal=>create(this, queue);
		btnOK->addActionListener(aal);
	}

	// Constructor of the class "AboutDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue, String msg, String title) {

		super=>newDialog(parent, modal);

		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(300, 100);
		Font font=>newFont("TimesRoman", 12);
		FlowLayout flow1=>newFlowLayout();
		Panel panel1=>newPanel(flow1);
		add("Center", panel1);
		lblVersion=>newLabel(msg);
		lblVersion->setFont(font);
		panel1->add(lblVersion);

		FlowLayout flow2=>newFlowLayout();
		Panel panel2=>newPanel(flow2);
		add("South", panel2);
		panel2->addNotify();
		btnOK=>newButton("OK");
		btnOK->setFont(font);
		panel2->add(btnOK);

		setTitle(title);

		//Resister Listeners
		aal=>create(this, queue);
		btnOK->addActionListener(aal);
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
}
