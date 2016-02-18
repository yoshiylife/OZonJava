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

class SubjectStateController : *ItemListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	SchoolBrowser sb;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "LabelSelectItemListener"
	new create(SchoolBrowser s, EventDispatchingQueue q) {
		super=>newItemListener(q);
		sb = s;
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
		if(sb->getRbtnRelease()->getState()) {
			sb->getSchool()->toReleasState(sb->getChoSubject()->getSelectedItem());
			sb->getMenuItemSubjectExportIF()->setEnabled(true);
			sb->getMenuItemSubjectExportCL()->setEnabled(true);
			sb->getMenuItemAppResister()->setEnabled(true);
		} else {
			sb->getSchool()->toDevelopState(sb->getChoSubject()->getSelectedItem());
			sb->getMenuItemSubjectExportIF()->setEnabled(false);
			sb->getMenuItemSubjectExportCL()->setEnabled(false);
			sb->getMenuItemAppResister()->setEnabled(false);
		}
	}
}
