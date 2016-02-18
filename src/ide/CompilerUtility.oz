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

/*
 * CompilerUtility.oz,v 1.1 1997/8/15
 *
 */

/**
 * CompilerUtility supports the programmers who compile the oz program.
 *
 * @see	SchoolBrowser
 *
 * @version		1.1
 * @author		Hiroshi Sugino
 */

class CompilerUtility 
{
	/**************
	 * ATTRIBUTES *
	 **************/
	//  class browser
	ClassBrowser classBrowser;
  // school object
  School school;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "CompilerUtility"
	new create(School sc, ClassBrowser cb){
		classBrowser = cb;
		school = sc;
	}

	/***********
	 * METHODS *
	 ***********/
	/**指定したcidを参照しているcidを探す
	 */
	public Set getReferedCID(String cid){
		String subjectName, labelName, tmp, tmpCID;
		subjectName = getSubjectName(cid);
		tmpCID = cid->substring(0,cid->lastIndexOf("_"));

		OzLabel label;
		Dictionary labels = school->getOzLabels();
		Set cids, results;
		StringComparator sc=>create();
		results=>create(sc);
		Iterator labelItr, itr;
		labelItr = labels->iterator();
    while (labelItr->hasMoreElements()) {
      label =| labelItr->nextElement();
			labelName = label->getImplementationID();
			if(labelName->startsWith(subjectName)) {
				labelName = school->getImplementationID(label->getOzLabelName());
				cids =| classBrowser->getReferingCIDsOf(labelName);
				itr = cids->iterator();
    		while (itr->hasMoreElements()) {
		      tmp =| itr->nextElement();
					tmp = tmp->substring(0,tmp->lastIndexOf("_"));
					if(tmp->compareTo(tmpCID)==0) {
						results->add(labelName);
					}
				}
			}
		}
		return results;
	}

	/**指定したcidを生成しているcidを探す
	 */
	public Set getInstanciatedCID(String cid){
		String subjectName, labelName, tmp, tmpCID;
		subjectName = getSubjectName(cid);
		tmpCID = cid->substring(0,cid->lastIndexOf("_"));

		OzLabel label;
		Dictionary labels = school->getOzLabels();
		Set cids, results;
		StringComparator sc=>create();
		results=>create(sc);
		Iterator labelItr, itr;
		labelItr = labels->iterator();
    while (labelItr->hasMoreElements()) {
      label =| labelItr->nextElement();
			labelName = label->getImplementationID();
			if(labelName->startsWith(subjectName)) {
				labelName = school->getImplementationID(label->getOzLabelName());
				cids =| classBrowser->getInstantiatingCIDsOf(labelName);
				itr = cids->iterator();
    		while (itr->hasMoreElements()) {
		      tmp =| itr->nextElement();
					tmp = tmp->substring(0,tmp->lastIndexOf("_"));
					if(tmp->compareTo(tmpCID)==0) {
						results->add(labelName);
					}
				}
			}
		}
		return results;
	}

	/**指定したcidの子孫クラスのcidを探す
	 */
	public Set getDescendantCID(String cid){
		String subjectName, labelName, tmp, tmpCID;
		subjectName = getSubjectName(cid);
		tmpCID = cid->substring(0,cid->lastIndexOf("_"));
System system=>create();

		OzLabel label;
		Dictionary labels = school->getOzLabels();
		Set cids, results;
		StringComparator sc=>create();
		results=>create(sc);
		Iterator labelItr, itr;
		labelItr = labels->iterator();
    while (labelItr->hasMoreElements()) {
      label =| labelItr->nextElement();
			labelName = label->getImplementationID();
			if(labelName->startsWith(subjectName)) {
				labelName = school->getImplementationID(label->getOzLabelName());
				cids =| classBrowser->getAncestorCIDsOf(labelName);
				itr = cids->iterator();
    		while (itr->hasMoreElements()) {
		      tmp =| itr->nextElement();
					tmp = tmp->substring(0,tmp->lastIndexOf("_"));
					if(tmp->compareTo(tmpCID)==0) {
						results->add(labelName);
system->println(labelName);
					}
				}
			}
		}
		return results;
	}

	/**該当部分文字列の置換を行う
	 */
	public String replace(String target, String oldString, String newString) {
		int lenTarget = target->length();
		int lenOld = oldString->length();
		StringBuffer tmpString;
		for(int i=0; i<lenTarget-lenOld+1; i++) {
			if((target->substring(i,i+lenOld))->compareTo(oldString)==0) {
				tmpString=>breed(target->substring(0,i));
				tmpString->append(newString);
				if(lenTarget>=i+lenOld)
					tmpString->append(target->substring(i+lenOld));
				return tmpString->asString();
			}
		}
		return target;
	}

	/**FQIDよりそのサブジェクトが含まれるパスを取得する
	 */
	public String getSubjectName(String cid){
		String subjectName;
		if(cid->startsWith("JP.go.ipa.oz.user.released."))
			subjectName = replace(cid, "JP.go.ipa.oz.user.released.", "");
		else if(cid->startsWith("JP.go.ipa.oz.user."))
			subjectName = replace(cid, "JP.go.ipa.oz.user.", "");
		subjectName = subjectName->substring(0,subjectName->lastIndexOf("."));
		return subjectName;
	}
}
