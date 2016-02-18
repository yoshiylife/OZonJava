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
 * School.oz,v 1 1997/5/14
 */

/**
 * School is ...
 *
 * @see	OzLabel
 * @see	SchoolBrowser
 *
 * @version		1
 * @author		Hiroshi Sugino
 */

class School : OzSchool
{
	/**************
	 * ATTRIBUTES *
	 **************/
	// subjects including in this School using dictionary
	Dictionary subjects;
	// information for duplicate labels in this School using dictionary
	Dictionary duplicates;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "School"
	new create(){
		StringComparator sc=>create();
		subjects=>create(sc);
		duplicates=>create(sc);
	}

	/***********
	 * METHODS *
	 ***********/
// Overriding  Methods ************ BEGIN *********************
	/**get the Interface part Identifier of this label.
	 * @param	labelName:OzLabel name
	 * @return	Interface part Identifier
	 * @exception	Exception
	 */
	public String getInterfaceID(String labelName) {
		OzLabel lbl;
		String interfaceID;
		StringBuffer buf;
		Subject subject;

		lbl =| getAllLabels()->get(labelName);
		interfaceID = lbl->getInterfaceID();
		subject = getSubject(lbl->getSubjectName());

		if(interfaceID->startsWith(".")) {
			buf=>breed("JP.go.ipa.oz");
			buf->append(interfaceID);
		} else {
			if (subject->isReleased()) {
				buf=>breed("JP.go.ipa.oz.user.released.");
//				buf->append((getGOL()->replace('.', '_'))->replace(':', '_') );
//				buf->append(".");
				buf->append(interfaceID);
			} else {
				buf=>breed("JP.go.ipa.oz.user.");
				buf->append(interfaceID);
			}
		}

		return buf->asString();
	}

	/**get the Implementation part Identifier of this label.
	 * @param	labelName:OzLabel name
	 * @return	Implementation part Identifier
	 * @exception	Exception
	 */
	public String getImplementationID(String labelName) {
		OzLabel lbl;
		String implementationID;
		StringBuffer buf;
		Subject subject;

		lbl =| getAllLabels()->get(labelName);
		implementationID = lbl->getImplementationID();
		subject = getSubject(lbl->getSubjectName());

		if(implementationID->startsWith(".")) {
			buf=>breed("JP.go.ipa.oz");
			buf->append(implementationID);
		} else {
			if (subject->isReleased()) {
				buf=>breed("JP.go.ipa.oz.user.released.");
//				buf->append((getGOL()->replace('.', '_'))->replace(':', '_') );
//				buf->append(".");
				buf->append(implementationID);
			} else {
				buf=>breed("JP.go.ipa.oz.user.");
				buf->append(implementationID);
			}
		}

		return buf->asString();
	}

	/**get the label name relating to this Interface part Identifier.
	 * @param	interfaceID:Interface part Identifier.
	 * @return	String
	 * @exception	Exception
	 */
	public String getNameOfInterface(String interfaceID) {
		OzLabel label;
		String ifID;

		if(interfaceID->startsWith("JP.go.ipa.oz.user.released."))
			ifID = interfaceID->substring(27);
		else if(interfaceID->startsWith("JP.go.ipa.oz.user."))
			ifID = interfaceID->substring(18);
		else if(interfaceID->startsWith("JP.go.ipa.oz.lib.") || interfaceID->startsWith("JP.go.ipa.oz.lang."))
			ifID = interfaceID->substring(12);

    label = getOzLabelOfInterface (ifID);
    if (label == null) return null;
    return label->getOzLabelName ();
	}

	/**get the label name relating to this Implementation part Identifier.
	 * @param	implementationID:Implementation part Identifier.
	 * @return	String
	 * @exception	Exception
	 */
	public String getNameOfImplementation(String implementationID) {
    OzLabel label;
		String clID;

		if(implementationID->startsWith("JP.go.ipa.oz.user.released."))
			clID = implementationID->substring(27);
		else if(implementationID->startsWith("JP.go.ipa.oz.user."))
			clID = implementationID->substring(18);
		else if(implementationID->startsWith("JP.go.ipa.oz.lib.") || implementationID->startsWith("JP.go.ipa.oz.lang."))
			clID = implementationID->substring(12);

    label = getOzLabelOfImplementation (clID);
    if (label == null) return null;
    return label->getOzLabelName ();

	}
// Overriding  Methods ************ END *********************

	/**get the dictionary of labels of this school.
	 * @return	Dictionary:dictionary of labels
	 * @exception	Exception
	 */
	public Dictionary getOzLabels() {
		return getAllLabels();
	}

	/**get the dictionary of labels of this school and subject.
	 * @param	subjectName:subject name
	 * @return	Dictionary:dictionary of labels
	 * @see 
	 */
	public Dictionary getOzLabels(String subjectName) {
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(subjectName)==0) {
				return subject->getOzLabels();
			}
		}
		return null;
	}

	/**get the OzLabel Object
	 * @param	labelName:OzLabel name
	 * @return	OzLabel
	 * @exception	Exception
	 */
	public OzLabel getOzLabel(String labelName) {
		OzLabel lbl;
		lbl =| getAllLabels()->get(labelName);
		return lbl;
	}

	/**get the label relating to this Interface part Identifier.
	 * @param	interfaceID:Interface part Identifier.
	 * @return	OzLabel object
	 * @exception	Exception
	 */
	public OzLabel getOzLabelOfInterface(String interfaceID) {
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		lblIterator = getAllLabels()->iterator();

		while( lblIterator->hasMoreElements() ) { 
			tmpOzLabel =| lblIterator->nextElement();
			if(tmpOzLabel->getInterfaceID()->compareTo(interfaceID)==0) return tmpOzLabel;
		}
		return null;
	}

	/**get the label relating to this Implementation part Identifier.
	 * @param	implementationID:Implementation part Identifier.
	 * @return	OzLabel object
	 * @exception	Exception
	 */
	public OzLabel getOzLabelOfImplementation(String implementationID) {
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		lblIterator = getAllLabels()->iterator();
		while( lblIterator->hasMoreElements() ) {
			tmpOzLabel =| lblIterator->nextElement();
			if(((tmpOzLabel->getImplementationID())->compareTo(implementationID))==0) return tmpOzLabel;
		}
		return null;
	}

	/**register the label to this school.
	 * @param	aOzLabel:OzLabel object you want to register.
	 * @return	School
	 * @exception	Exception
	 */
	public School putOzLabel(OzLabel aOzLabel, String subjectName) {
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(subjectName)==0){
				subject->putOzLabel(aOzLabel);
				return this;
			}
		}
		return this;
	}

	/**remove the label from this school.
	 * @param	aOzLabel:OzLabel name you want to delete.
	 * @return	School
	 * @exception	Exception
	 */
	public School removeOzLabel(String labelName, String subjectName) {
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(subjectName)==0){
				subject->removeOzLabel(labelName);
				return this;
			}
		}
		return this;
	}

	/**remove the labels from this school by Subject.
	 * @param	subjectName:Subject name you want to delete.
	 * @return	School
	 * @exception	Exception
	 */
	public School removeOzLabels(String subjectName) {
		subjects->remove(subjectName);
		return this;
	}

	/**register subject to this school.
	 * @param	aSubject:Subject
	 * @exception	Exception
	 */
	public School putSubject(Subject aSubject) {
		String subjectName=>breed();
		subjectName = aSubject->getSubjectName();
		subjects->put(subjectName, aSubject);
		return this;
	}

	/**remove the group of labels to this school.
	 * @param	subjectName:OzLabels relating to this subject.
	 * @exception	Exception
	 */
	public School removeSubject(String subjectName) {
		subjects->remove( subjectName );
		return this;
	}

	/**get the subject in this school.
	 * @param	subjectName:OzLabels relating to this subject.
	 * @exception	Exception
	 */
	public Subject getSubject(String subjectName) {
		Subject sbj;
		sbj =| subjects->get(subjectName);
		return sbj;
	}

	/**get the subjects in this school.
	 * @return	Dictionary:dictionary of subjects
	 * @exception	Exception
	 */
	public Dictionary getSubjects() {
		return subjects;
	}

	/**Rename the Subject name.
	 * @param	String:old subject name
	 * @param	String:new subject name
	 * @return	void
	 * @exception	Exception
	 */
	public void renameSubject(String oldSubjectName, String newSubjectName) {
		Dictionary tmpLabels;
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		Subject subject;
		Subject sbj=>create(newSubjectName);
		subjects->put(newSubjectName, sbj);
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(oldSubjectName)==0) {
				tmpLabels = subject->getOzLabels();
				lblIterator = tmpLabels->iterator();
				while( lblIterator->hasMoreElements() ) {
					tmpOzLabel =| lblIterator->nextElement();
					tmpOzLabel->setSubjectName(newSubjectName);
					sbj->putOzLabel(tmpOzLabel);
				}
				sbj->setImported(subject->isImported());
				removeSubject(oldSubjectName);
				return;
			}
		}
	}

	/**get the full path of the label.
	 * @param	String:Label Name
	 * @return	String:Full Path for the Label
	 * @exception	Exception
	 */
	public String getLabelPath(String labelName) {

		//get ozhome path
		String ozHome;
		System system=>create();
		ozHome = system->getOzHome();
		StringBuffer fullPath=>breed();

		if (ozHome->startsWith("/")) {
			fullPath->append(ozHome);
			if (!(ozHome->endsWith("/")))
				fullPath->append("/");
			fullPath->append("lib/");
		} else {
			fullPath->append(ozHome);
			if (!(ozHome->endsWith("\\")))
				fullPath->append("\\");
			fullPath->append("lib\\");
		}

		//get library path
		String cid;
		if (ozHome->startsWith("/"))
			cid = getInterfaceID(labelName)->replace('.','/');
		else
			cid = getInterfaceID(labelName)->replace('.','\\');

		fullPath->append(cid);

		String path;
		path = fullPath->asString();
		if (ozHome->startsWith("/"))
			path = path->substring(0,path->lastIndexOf("/")+1);
		else
			path = path->substring(0,path->lastIndexOf("\\")+1);

		return path;
	}

	/**get the relative path of the label.
	 * @param	String:Label Name
	 * @return	String:Full Path for the Label
	 * @exception	Exception
	 */
	public String getLabelPath2(String labelName) {
		//get ozhome path
		String ozHome;
		System system=>create();
		ozHome = system->getOzHome();

		//get library path
		String path;
		if (ozHome->startsWith("/"))
			path = getInterfaceID(labelName)->replace('.','/');
		else
			path = getInterfaceID(labelName)->replace('.','\\');

		if (ozHome->startsWith("/"))
			path = path->substring(0,path->lastIndexOf("/")+1);
		else
			path = path->substring(0,path->lastIndexOf("\\")+1);

		return path;
	}

	/**get the number of label in the subject.
	 * @param	String:subject name
	 * @return	int:the number of label
	 * @exception	Exception
	 */
	public int getNumOfLabels(String subjectName) {
		return getOzLabels(subjectName)->size();
	}

	//•K—v‚Èƒ‰ƒxƒ‹‚Ì‚Ý‚Ü‚Æ‚ß‚é
	public Dictionary getAllLabels() {
		Dictionary tmpLabels, labels;
		StringComparator sc=>create();
		labels=>create(sc);
		String labelName;
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		Subject subject;
		Iterator sbjIterator = subjects->iterator();
		while( sbjIterator->hasMoreElements() ) {
			subject =| sbjIterator->nextElement();
			if(subject->getUsing()) {
				tmpLabels = subject->getOzLabels();
				lblIterator = tmpLabels->iterator();
				while( lblIterator->hasMoreElements() ) {
					tmpOzLabel =| lblIterator->nextElement();
					labelName = tmpOzLabel->getOzLabelName();
					labels->put(labelName, tmpOzLabel);
				}
			}
		}
		return labels;
	}

	public void mergeSubject(Subject subject) {
		Subject existSubject;
		Iterator sbjIterator = subjects->iterator();
		duplicates->clear();
		while( sbjIterator->hasMoreElements() ) {
			existSubject =| sbjIterator->nextElement();
			if(subject->getSubjectName()->compareTo(existSubject->getSubjectName())!=0) {
				checkDuplicate(existSubject, subject); //1‚Â‚ß‚Ìˆø”‚ð‚Ü‚í‚·
			}
		}
		//merge
		subject->setImported(true);
		putSubject(subject);

//debug routine
System system=>create();
String lblName, dupLblName;
Set tmpSet = duplicates->keys();
Iterator tmpIterator = tmpSet->iterator();
while( tmpIterator->hasMoreElements() ) {
	lblName =| tmpIterator->nextElement();
	dupLblName =| duplicates->get(lblName);
	system->println(lblName);
	system->println(dupLblName);
}
	system->println("-----------------------");

	}

	public void checkDuplicate(Subject subject1, Subject subject2) {
		Dictionary labels1, labels2;
		String labelName;
		String subjectName1 = subject1->getSubjectName();
		String subjectName2 = subject2->getSubjectName();
		StringBuffer tmp1, tmp2;
		OzLabel tmpOzLabel;
		labels1 = subject1->getOzLabels();
		labels2 = subject2->getOzLabels();
		Iterator lblIterator = labels1->iterator();
		while( lblIterator->hasMoreElements() ) {
			tmpOzLabel =| lblIterator->nextElement();
			labelName = tmpOzLabel->getOzLabelName();
			if(labels2->containsKey(labelName)) {
				tmp1=>breed(subjectName1);
				tmp2=>breed(subjectName2);
				tmp1->append(":");
				tmp2->append(":");
				tmp1->append(labelName);
				tmp2->append(labelName);
				duplicates->put(tmp1->asString(), tmp2->asString());
			}
		}
	}

	public void toReleasState(String subjectName) {
		Subject subject = getSubject(subjectName);
		subject->setReleased(true);
		String gol = (getGOL()->replace('.', '_'))->replace(':', '_');

		Dictionary labels = subject->getOzLabels();
		Iterator lblIterator = labels->iterator();
		String labelName;
		StringBuffer tmp;
		OzLabel tmpOzLabel;
		while( lblIterator->hasMoreElements() ) {
			tmpOzLabel =| lblIterator->nextElement();
			if(!(tmpOzLabel->getInterfaceID()->startsWith(gol))) {
				tmp=>breed(gol);
//				tmp->append(".");
				tmp->append("_if.");
				tmp->append(tmpOzLabel->getInterfaceID());
				tmpOzLabel->setInterfaceID(tmp->asString());
				tmp=>breed(gol);
//				tmp->append(".");
				tmp->append("_cl.");
				tmp->append(tmpOzLabel->getImplementationID());
				tmpOzLabel->setImplementationID(tmp->asString());
			}
		}
		String pkgName = getInterfaceID(tmpOzLabel->getOzLabelName());
		pkgName = pkgName->substring(0, pkgName->lastIndexOf("."));
		subject->setIfPackageName(pkgName);
		pkgName = getImplementationID(tmpOzLabel->getOzLabelName());
		pkgName = pkgName->substring(0, pkgName->lastIndexOf("."));
		subject->setClPackageName(pkgName);
	}

	public void toDevelopState(String subjectName) {
		Subject subject = getSubject(subjectName);
		subject->setReleased(false);
		String gol = (getGOL()->replace('.', '_'))->replace(':', '_');

		Dictionary labels = subject->getOzLabels();
		Iterator lblIterator = labels->iterator();
		String labelName, tmp;
		OzLabel tmpOzLabel;
		while( lblIterator->hasMoreElements() ) {
			tmpOzLabel =| lblIterator->nextElement();
			if(tmpOzLabel->getInterfaceID()->startsWith(gol)) {
				tmp = tmpOzLabel->getInterfaceID();
				tmp = tmp->substring(tmp->indexOf(".")+1);
				tmpOzLabel->setInterfaceID(tmp);
				tmp = tmpOzLabel->getImplementationID();
				tmp = tmp->substring(tmp->indexOf(".")+1);
				tmpOzLabel->setImplementationID(tmp);
			}
		}
	}

	public Dictionary getDuplicates() {
		return duplicates;
	}

	public void setDuplicates(Dictionary dict) {
		duplicates = dict;
	}

	public void saveToFile(String fileName, String subjectName) {
		SchoolUtility schoolUtility=>create(subjects);
		schoolUtility->saveToFile(fileName, subjectName);
	}

	public void loadFromFile(String fileName, String subjectName) {
		SchoolUtility schoolUtility=>create(subjects);
		schoolUtility->loadFromFile(fileName, subjectName);
	}
}
