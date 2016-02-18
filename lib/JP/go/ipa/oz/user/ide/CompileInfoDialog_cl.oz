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

class CompileInfoDialog : *Dialog {

	/**************
	 * ATTRIBUTES *
	 **************/
	TextArea txtInfo;
	Button btnOK;
	CompileInfoActionListener editCtrl;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "CompileInfoDialog"
	new create(Frame parent, boolean modal, EventDispatchingQueue queue) {

		super=>newDialog(parent, modal);

		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(500, 500);
		txtInfo=>newTextArea(30, 120);
		add("Center", txtInfo);
		btnOK=>newButton("OK");
		FlowLayout flow=>newFlowLayout();
		Panel panel=>newPanel(flow);
		add("South", panel);
		panel->addNotify();
		panel->add(btnOK);
		btnOK->setEnabled(false);
		setTitle("Compile Information");

//		enableEvents(AWTEvent->getWINDOW_EVENT_MASK());

		//Resister Listeners
		editCtrl=>create(this, queue);
		btnOK->addActionListener(editCtrl);
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
		setLocation(bounds->getX() + (abounds->getWidth() - bounds->getWidth())/ 2,
   	     bounds->getY() + (abounds->getHeight() - bounds->getHeight())/2);

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

	/**attribute access method for txtInfo
	 * @param	txtInfo:String
	 * @return	void
	 * @exception	Exception
	 */
	public void setTxtInfo(String tmp) {
		txtInfo->setText(tmp);
	}

	/**attribute access method for txtInfo
	 * @param	
	 * @return	String
	 * @exception	Exception
	 */
	public String getTxtInfo() {
		return txtInfo->getText();
	}

	/**append the text to txtInfo
	 * @param	appendText:String
	 * @return	void
	 * @exception	Exception
	 */
	public void appendText(String appendText) {
		txtInfo->append(appendText);
		txtInfo->append("\"\n");
	}

	/**set the Button enabled
	 * @param	b:boolean
	 * @return	void
	 * @exception	Exception
	 */
	public void setButtonEnabled(boolean b) {
		btnOK->setEnabled(b);
	}

}
