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

class AboutActionListener : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	AboutDialog about;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "AboutActionListener"
	new create(AboutDialog a, EventDispatchingQueue q) {
		super=>newActionListener(q);
		about = a;
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
			about->dispose();
			about->setVisible(false);
		}
	}

}
