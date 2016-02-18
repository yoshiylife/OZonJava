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

class AddFileActionListener : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	AddFileDialog dlg;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "AddFileActionListener"
	new create(AddFileDialog a, EventDispatchingQueue q) {
		super=>newActionListener(q);
		dlg = a;
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
		if ( event->getActionCommand()->compareTo("set dir")==0 ) {
			dlg->setFiles(dlg->getFilesInDirectory());
			dlg->dispose();
			dlg->setVisible(false);
		}
		else if ( event->getActionCommand()->compareTo("Cancel")==0 ) {
			dlg->setFiles(null);
			dlg->dispose();
			dlg->setVisible(false);
		}
		else {
			dlg->setNextDirectory();
		}
	}
}
