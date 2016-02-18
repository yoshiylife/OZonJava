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
 * Subject.oz,v 1 1997/8/19
 */

class Subject : *Summarizable
{
	/**************
	 * ATTRIBUTES *
	 **************/
	// labels including in this Subject using dictionary
	Dictionary labels;

	String subjectName;
	String ifPkgName;
	String clPkgName;
	boolean released;	// true:released, false:development
	boolean imported;	// true:imported, false:not imported
	int releaseMode;	// 1:interface, 2:implementation
	boolean using;	// true:using, false:not using 当該サブジェクトを使用しているかどうか

	/****************
	 * CONSTRUCTORS *
	 ****************/
	/**Constructor of the class "Subject"
	 *
	 * @exception	Exception
	 */
	new create() {
		subjectName = "default";
		StringComparator sc=>create();
		labels=>create(sc);
		released = false;
		imported = false;
		releaseMode =1;
		using = true;
	}

	/**Constructor of the class "Subject"
	 *
	 * @exception	Exception
	 */
	new create(String sname) {
		subjectName = sname;
		released = false;
		imported = false;
		StringComparator sc=>create();
		labels=>create(sc);
		releaseMode =1;
		using = true;
	}

	/***********
	 * METHODS *
	 ***********/
	/**get the subject name.
	 * @return	subject name
	 * @exception	Exception
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**set the subject name.
	 * @param	name:subject name
	 * @exception	Exception
	 */
	public void setSubjectName(String sname) {
		subjectName = sname;
	}

	/**get the using.
	 */
	public boolean getUsing() {
		return using;
	}

	/**set the using.
	 */
	public void setUsing(boolean bo) {
		using = bo;
	}

	/**get the released.
	 */
	public boolean isReleased() {
		return released;
	}

	/**set the released.
	 */
	public void setReleased(boolean bo) {
		released = bo;
	}

	/**get the imported.
	 * @return	boolean
	 */
	public boolean isImported() {
		return imported;
	}

	/**set the imported.
	 */
	public void setImported(boolean bo) {
		imported = bo;
	}

	/**get the pkgName.
	 * @return	String
	 */
	public String getPackageName() {
		if (releaseMode==1)
			return ifPkgName;
		else if (releaseMode==2)
			return clPkgName;
		else if (releaseMode==3)
			return ifPkgName;
		return "";
	}

	/**set the pkgName.
	 * @param	String:zip file name
	 */
	public void setPackageName(String name) {
		if (releaseMode==1)
			ifPkgName = name;
		else if (releaseMode==2)
			clPkgName = name;
		else
			ifPkgName = name;
	}

	/**get the releaseMode.
	 * @return	int:interface(1) or implementation(2)
	 */
	public int getReleaseMode() {
		return releaseMode;
	}

	/**set the releaseMode.
	 * @param	int:interface(1) or implementation(2)
	 */
	public void setReleaseMode(int bo) {
		releaseMode = bo;
	}

	/**get the ifPkgName.
	 * @return	String
	 */
	public String getIfPackageName() {
		return ifPkgName;
	}

	/**set the ifPkgName.
	 * @param	String
	 */
	public void setIfPackageName(String name) {
		ifPkgName = name;
	}

	/**get the clPkgName.
	 * @return	String
	 */
	public String getClPackageName() {
		return clPkgName;
	}

	/**set the clPkgName.
	 * @param	String
	 */
	public void setClPackageName(String name) {
		clPkgName = name;
	}

	/**get the dictionary of labels of this subject.
	 * @return	Dictionary:dictionary of labels
	 */
	public Dictionary getOzLabels() {
		return labels;
	}

	/**get the OzLabel Object
	 * @param	labelName:OzLabel name
	 * @return	OzLabel
	 */
	public OzLabel getOzLabel(String labelName) {
		OzLabel lbl;
		lbl =| labels->get(labelName);
		return lbl;
	}

	/**get the label relating to this Interface part Identifier.
	 * @param	interfaceID:Interface part Identifier.
	 * @return	OzLabel object
	 */
	public OzLabel getOzLabelOfInterface(String interfaceID) {
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		lblIterator = labels->iterator();

		while( lblIterator->hasMoreElements() ) { 
			tmpOzLabel =| lblIterator->nextElement();
			if(tmpOzLabel->getInterfaceID()->compareTo(interfaceID)==0) return tmpOzLabel;
		}
		return null;
	}

	/**get the label relating to this Implementation part Identifier.
	 * @param	implementationID:Implementation part Identifier.
	 * @return	OzLabel object
	 */
	public OzLabel getOzLabelOfImplementation(String implementationID) {
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		lblIterator = labels->iterator();
		while( lblIterator->hasMoreElements() ) {
			tmpOzLabel =| lblIterator->nextElement();
			if(((tmpOzLabel->getImplementationID())->compareTo(implementationID))==0) return tmpOzLabel;
		}
		return null;
	}

	/**register the label to this subject.
	 * @param	aOzLabel:OzLabel object you want to register.
	 */
	public void putOzLabel(OzLabel aOzLabel) {
		String labelName;
		labelName = aOzLabel->getOzLabelName();
		labels->put(labelName, aOzLabel);
	}

	/**register the labels to this subject.
	 * @param	lbls:Dictionary of OzLabels object you want to register.
	 */
	public void putOzLabel(Dictionary lbls) {
		String labelName;
		OzLabel tmpOzLabel;
		Iterator lblIterator;
		lblIterator = lbls->iterator();
		while( lblIterator->hasMoreElements() ) {
			tmpOzLabel =| lblIterator->nextElement();
			labelName = tmpOzLabel->getOzLabelName();
			labels->put(labelName, tmpOzLabel);
		}
	}

	/**remove the label from this Subject.
	 * @param	labelName:OzLabel name you want to delete.
	 */
	public void removeOzLabel(String labelName) {
		labels->remove(labelName);
	}

	/**remove the all labels from this Subject.
	 */
	public void removeAll() {
		labels->clear();
	}
}
