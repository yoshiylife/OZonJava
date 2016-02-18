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

class LabelDeleteActionListener : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	LabelDeleteDialog dlg;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "LabelDeleteActionListener"
	new create(LabelDeleteDialog l, EventDispatchingQueue q) {
		super=>newActionListener(q);
		dlg = l;
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
			if ( dlg->getRbtnSubject()->getState() ) {
				dlg->getSchool()->removeOzLabels(dlg->getChoSubject()->getSelectedItem());
				//REDISPLAY
				dlg->getSchoolBrowser()->setSchoolList(dlg->getSchoolBrowser()->getChoSubject()->getSelectedItem());
			}	else {
				if (dlg->getLabelName()==null) return;
				dlg->getSchool()->removeOzLabel(dlg->getLabelName(), dlg->getSchoolBrowser()->getChoSubject()->getSelectedItem());
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
