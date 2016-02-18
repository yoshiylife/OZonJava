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
 * $Id: DeclarationSt.java,v 0.9 1998-02-02 08:31:25+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

/* DeclarationSt class, representing declaration statement
    for OZ language compiler */

package JP.go.ipa.oz.compiler;

class DeclarationSt extends Statement {
  /* defined type */
  Type type;
  
  /* defined identifiers */
  IdentifierList identifiers;
  
  /* constructors */
  DeclarationSt (Type t, IdentifierList id_list, int ln) {
    super (ln);
    type = t;
    identifiers = id_list;
  }
  
  /**
    * overide 
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    identifiers.check ();
    super.check (method);
  }

  void emit () {
    if (Emitter.isEmitting ()) {
      for (int i = 0, size = identifiers.size (); i < size; i++)
	identifiers.get (i).preEmitForMethodInvocation ();
    }

    Emitter.emitln (line_no);
    Emitter.emit (type);
    Emitter.emit (" ");
    identifiers.emit ();
    Emitter.emit (";");
  }
}
 
/* EOF */
