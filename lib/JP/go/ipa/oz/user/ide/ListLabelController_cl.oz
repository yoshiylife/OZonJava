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

class ListLabelController : *ItemListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	SchoolBrowser sbr;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "ListLabelController"
	new create(SchoolBrowser s, EventDispatchingQueue q) {
		super=>newItemListener(q);
		sbr = s;
	}

	/***********
	 * METHODS *
	 ***********/
	/**Invoked when button click actions occur. 
	 * @param	event:ActionEvent
	 * @return	void
	 * @exception	Exception
	 */
	public void itemStateChanged(ItemEvent event) {
		String labelName;
		labelName = sbr->getLstLabel()->getSelectedItem();
		sbr->getTxtIfID()->setText(sbr->getSchool()->getOzLabel(labelName)->getInterfaceID());
		sbr->getTxtImplID()->setText(sbr->getSchool()->getOzLabel(labelName)->getImplementationID());
	}
}
