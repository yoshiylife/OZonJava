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

class IDGenActionListener : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	IDGenDialog dlg;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "IDGenActionListener"
	new create(IDGenDialog i, EventDispatchingQueue q) {
		super=>newActionListener(q);
		dlg = i;
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
		if ( event->getActionCommand()->compareTo("OK")==0 ) {
			if ( dlg->getRbtnSelected()->getState() ) {
				if (dlg->getLabel()==null) return;
				dlg->generateID(dlg->getLabel());
				//REDISPLAY
				dlg->getSchoolBrowser()->setSchoolList(dlg->getSchoolBrowser()->getChoSubject()->getSelectedItem());
			}	else {
				dlg->generateID(dlg->getChoSubject()->getSelectedItem());
				//REDISPLAY
				dlg->getSchoolBrowser()->setSchoolList(dlg->getSchoolBrowser()->getChoSubject()->getSelectedItem());
			}
			dlg->dispose();
			dlg->setVisible(false);
		}
		else
		{
			dlg->dispose();
			dlg->setVisible(false);
		}
	}
}
