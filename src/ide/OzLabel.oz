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
 * OzLabel.oz,v 1 1997/5/14
 *
 */

/**
 * OzLabel is ...
 *
 * @see	School
 * @see	Subject
 *
 * @version		1
 * @author		Hiroshi Sugino
 */

class OzLabel 
{
	/**************
	 * ATTRIBUTES *
	 **************/
	// OzLabel Name
	String labelName;

	// Interface part identifier
	String interfaceID;

	// implimentation part Identifier
	String implementationID;

	// subject relating to this label
	String subjectName;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	/**Constructor of the class "OzLabel"
	 *
	 * @exception	Exception
	 */
	new create(){
		subjectName = "default";
	}

	/**Constructor of the class "OzLabel"
	 * @param lname:label name
	 * @exception	Exception
	 */
	new create(String lname){
		subjectName = "default";
		labelName = lname;
	}

	/**Constructor of the class "OzLabel"
	 *
	 * @param sname:subject name
	 * @param lname:label name
	 * @param iname:interfaceID
	 * @param cname:implementationID
	 * @exception	Exception
	 */
	new create(String sname, String lname, String iname, String cname) {
		subjectName = sname;
		labelName = lname;
		interfaceID = iname;
		implementationID = cname;
	}

	/***********
	 * METHODS *
	 ***********/
	/**get the label name.
	 * @return	label name
	 * @exception	Exception
	 */
	public String getOzLabelName() {
		return labelName;
	}

	/**set the label name.
	 * @param	name:label name
	 * @exception	Exception
	 */
	public void setOzLabelName(String name) {
		labelName = name;
	}

	/**get the Interface part identifier.
	 * @return	Interface part identifier
	 * @exception	Exception
	 */
	public String getInterfaceID() {
		return interfaceID;
	}

	/**set the Interface part identifier.
	 * @param	interfaceID:Interface part identifier
	 * @exception	Exception
	 */
	public void setInterfaceID(String ifID) {
		interfaceID = ifID;
	}

	/**get the Implementaion part identifier.
	 * @return	Implementaion part identifier
	 * @exception	Exception
	 */
	public String getImplementationID() {
		return implementationID;
	}

	/**set the Implementaion part identifier.
	 * @param	implementaionID:Implementaion part identifier
	 * @exception	Exception
	 */
	public void setImplementationID(String implID) {
		implementationID = implID;
	}

	/**get the subject relating to this label.
	 * @return	subject name
	 * @exception	Exception
	 */
	public String getSubjectName() {
		return subjectName;
	}

	/**get the subject relating to this label.
	 * @param	subjectName:subject relating to this label
	 * @exception	Exception
	 */
	public void setSubjectName(String sname) {
		subjectName = sname;
	}
}
