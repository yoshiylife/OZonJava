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

class QuitDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	Button btnYes;
	Button btnNo;
	Label lblConfirm;
	QuitActionListener qal;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "QuitDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue){

		super=>newDialog(parent, modal);


		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(450, 130);
		Font font=>newFont("TimesRoman", 12);
		FlowLayout flow1=>newFlowLayout();
		Panel panel1=>newPanel(flow1);
		add("Center", panel1);
		lblConfirm=>newLabel("Would you like to quit the OZ Development Environment?");
		lblConfirm->setFont(font);
		panel1->add(lblConfirm);

		FlowLayout flow2=>newFlowLayout(1,20,20);	//1:CENTER
		Panel panel2=>newPanel(flow2);
		add("South", panel2);
		panel2->addNotify();
		btnYes=>newButton("OK");
		btnYes->setFont(font);
		panel2->add(btnYes);
		btnNo=>newButton("Cancel");
		btnNo->setFont(font);
		panel2->add(btnNo);

		setTitle("Quit Dialog");

//		enableEvents(AWTEvent->getWINDOW_EVENT_MASK());

		//Resister Listeners
		qal=>create(this, queue);
		btnYes->addActionListener(qal);
		btnNo->addActionListener(qal);
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
	public void processWindowEvent(WindowEvent event) {
/*
		switch(event->getID()) {
    	case WindowEvent->getWINDOW_CLOSING():
            this->dispose();			// Free the system resource
            this->setVisible(false);	// hide the Frame
		}
*/;
	}

	/**attribute access method for btnYes
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnYes() {
		return btnYes;
	}

	/**attribute access method for btnNo
	 * @param	
	 * @return	Button
	 * @exception	Exception
	 */
	public Button getBtnNo() {
		return btnNo;
	}
}
