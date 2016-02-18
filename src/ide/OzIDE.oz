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

cell OzIDE
{
	ProjectManager projectMng;
	SchoolBrowser schoolBrowser;

	protected void initialize()
	{
		EventDispatchingQueue pmQueue => create();
		projectMng=>create(pmQueue);
		projectMng->setVisible(true);

		EventDispatchingQueue sbQueue => create();
		schoolBrowser=>create(sbQueue);
		schoolBrowser->setVisible(true);
		projectMng->setSchoolBrowser(schoolBrowser);
	}

	protected void go()
	{
		EventDispatchingQueue pmQueue => create();
		projectMng->activateListeners(pmQueue);
		projectMng->setVisible(true);

		EventDispatchingQueue sbQueue => create();
		schoolBrowser->activateListeners(sbQueue);
		schoolBrowser->setVisible(true);
	}

	protected void quiet()
	{
		projectMng->deleteListeners();
		schoolBrowser->deleteListeners();
		projectMng->setVisible(false);
		schoolBrowser->setVisible(false);
		flushCell();
	}
}
