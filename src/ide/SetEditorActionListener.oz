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

class SetEditorActionListener : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	SetEditorDialog editorDlg;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "SetEditorActionListener"
	new create(SetEditorDialog s, EventDispatchingQueue q) {
		super=>newActionListener(q);
		editorDlg = s;
	}

	/***********
	 * METHODS *
	 ***********/
	/**Invoked when button click actions occur. 
	 * @param	event:ActionEvent
	 * @return	void
	 * @exception	Exception
	 */
    public void actionPerformed(ActionEvent event) {
		if ( event->getActionCommand()->compareTo("Set")==0 ) {
			editorDlg->setEditor();
			editorDlg->dispose();
			editorDlg->setVisible(false);
		} else {
			editorDlg->dispose();
			editorDlg->setVisible(false);
		}
	}

}
