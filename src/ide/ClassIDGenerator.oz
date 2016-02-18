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
 * ClassIDGenerator.oz,v 1 1997/5/14
 *
 */

/**
 * ClassIDGenerator is ...
 *
 * @see	CompilerAgent
 *
 * @version		1
 * @author		Hiroshi Sugino
 */

class ClassIDGenerator
{
	/**************
	 * ATTRIBUTES *
	 **************/
	// rule of the Interface part Identifier
	Array ruleOfInterfaceID;

	// rule of the Implementation part Identifier
	Array ruleOfImplementationID;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "ClassIDGenerator"
	new create(){
		ruleOfInterfaceID=>create(2);
		ruleOfInterfaceID->putAt(0, "sample_if.");
		ruleOfInterfaceID->putAt(1, "_if");
		ruleOfImplementationID=>create(2);
		ruleOfImplementationID->putAt(0, "sample_cl.");
		ruleOfImplementationID->putAt(1, "_cl");
	}

	/***********
	 * METHODS *
	 ***********/
	/**generate the Interface part Identifier.
	 * @param	label:Label name you want to generate the ID.
	 * @return	Interface part Identifier
	 * @exception	Exception
	 */
	public String generateInterfaceID(String label){
		StringBuffer buf=>breed();
		String head, tail;
		head =| ruleOfInterfaceID->at(0);
		tail =| ruleOfInterfaceID->at(1);
		buf->append(head);
		buf->append(label);
		buf->append(tail);
		return buf->asString();
	}

	/**generate the Implementation part Identifier.
	 * @param	label:Label name you want to generate the ID.
	 * @return	Implementation part Identifier
	 * @exception	Exception
	 */
	public String generateImplementationID(String label){
		StringBuffer buf=>breed();
		String head, tail;
		head =| ruleOfImplementationID->at(0);
		tail =| ruleOfImplementationID->at(1);
		buf->append(head);
		buf->append(label);
		buf->append(tail);
		return buf->asString();
	}

	/**get the generationrule of the Interface part Identifier.
	 * @return	generation rule of Interface part Identifier
	 * @exception	Exception
	 */
	public Array getRuleOfInterfaceID(){
		return ruleOfInterfaceID;
	}

	/**set the generationrule of the Interface part Identifier.
	 * @param	generation rule of Interface part Identifier
	 * @exception	Exception
	 */
	public void setRuleOfInterfaceID(Array rule){
		String tmp;
		tmp =| rule->at(0);
		ruleOfInterfaceID->putAt(0, tmp);
		tmp =| rule->at(1);
		ruleOfInterfaceID->putAt(1, tmp);

	}

	/**get the generationrule of the Implementation part Identifier.
	 * @return	generation rule of Implementation part Identifier
	 * @exception	Exception
	 */
	public Array getRuleOfImplementationID(){
		return ruleOfImplementationID;
	}

	/**set the generationrule of the Implementation part Identifier.
	 * @param	generation rule of Implementation part Identifier
	 * @exception	Exception
	 */
	public void setRuleOfImplementationID(Array rule){
		String tmp;
		tmp =| rule->at(0);
		ruleOfImplementationID->putAt(0, tmp);
		tmp =| rule->at(1);
		ruleOfImplementationID->putAt(1, tmp);
	}
}
