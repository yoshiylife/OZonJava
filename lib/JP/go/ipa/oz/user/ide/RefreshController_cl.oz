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

class RefreshController : *ActionListener {

	/**************
	 * ATTRIBUTES *
	 **************/
	ProjectManager prj;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "RefreshController"
	new create(ProjectManager p, EventDispatchingQueue q) {
		super=>newActionListener(q);
		prj = p;
	}

	/***********
	 * METHODS *
	 ***********/
	/**Invoked when button click actions occur. 
	 * @param	event:ActionEvent
	 * @return	void
	 */
    public void actionPerformed(ActionEvent event) {
		if ( event->getActionCommand()->compareTo("Refresh")==0 ) {
		if(prj->getProjectDir()==null || prj->getProjectDir()->compareTo("")==0) return;
			prj->getSrcList()->removeAll();
			Dictionary dict = prj->getProjects();
			String projectName;
			projectName = prj->getProjectName();
			Project project;
			project =| dict->get(projectName);
			project->removeAllFiles();

			Array fileList;
			File file => breed(project->getProjectDir());
			ExtensionFilter filter=>create(".oz");
			fileList = file->list(filter);
			if (fileList==null) return;
			String tmp;
			int max;
			max = fileList->size();
			for(int i=0; i<max; i++){
				tmp =| fileList->at(i);
				if(!(tmp->endsWith("_cl.oz"))) {
					prj->getSrcList()->addItem(tmp);
					project->addFile(tmp);
				}
			}
		}
	}

}
