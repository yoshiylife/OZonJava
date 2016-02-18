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
 * $Id: AttributeTable.java,v 0.5 1997-06-17 17:56:13+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.2.16
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing symbol table of attribute.
  * 
  * @see ClassImplementation
  */

class AttributeTable extends SymbolTable {
  /**
    * create a attribute table of class implementation
    */
  AttributeTable () { super (); }

  /**
    * override 
    */
  void emitElement (Identifier i) {
    ClassMember a = (ClassMember) i;

    StringBuffer s = new StringBuffer ();
    if (Emitter.isEmittingForBrowser ()) {
      s.append ("a, ");
      s.append (a);
      s.append (", ");
      s.append ("0x" + 
		Integer.toHexString (a.getModifier () + a.getAccess ()));
      s.append (", ");
      s.append (a.type + ", " + a.getStart () + ", " +
		(a.getEnd () - a.getStart () + 1));
    } else {
      s.append (a.modifiers ());
      s.append (a.type);
      s.append (' ');
      s.append (a);
      if (a.type.isCondition ()) {
	s.append (" = new ");
	s.append (OzcProperty.CONDITION);
	s.append (" (this)");
      }
      s.append (";");
    }
    Emitter.emit (s);
  }
}

/* EOF */
