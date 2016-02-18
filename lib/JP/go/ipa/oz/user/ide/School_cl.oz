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