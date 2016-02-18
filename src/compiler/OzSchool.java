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
 * $Id: OzSchool.java,v 0.7 1997-08-20 17:20:46+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.27
 */

package JP.go.ipa.oz.compiler;

/**
  * A class handling school to use with OZ level school
  *
  * @see School
  */

class OzSchool extends School {
  /**
    * search class (override)
    * 
    * @param name name of class
    * @return class implementation
    */
  ClassImplementation search (String name) {
    ClassImplementation ci = super.search (name);
    if (ci != null) return ci;

    return createClass (name);
  }

  /**
    * create and register a class 
    *
    * @param name class name
    * @return class implementation
    */
  private ClassImplementation createClass (String name) {
    String if_cid = OzOzc_cl.searchInterface (name);
    String impl_cid = OzOzc_cl.searchImplementation (name);

    if (if_cid == null || impl_cid == null) return null;

    /* add class name postfix 
    if_cid += OzcProperty.INTERFACE_POSTFIX;
    impl_cid += OzcProperty.IMPLEMENTATION_POSTFIX;
    */

    //JP.go.ipa.oz.system.OzSystem.println ("if_cid: " + if_cid);
    //JP.go.ipa.oz.system.OzSystem.println ("impl_cid: " + impl_cid);

    ClassInterface cif = new ClassInterface (name, if_cid);
    ClassImplementation ci = new ClassImplementation (name, impl_cid, cif);
    register (ci, name);

    return ci;
  }

  /**
    * search class (override)
    *
    * @param cid class id
    * @return class
    */
  ClassType searchAsClassID (String cid) {
    ClassType c = super.searchAsClassID (cid);
    if (c != null) return c;

    ClassImplementation ci;
    String name;
    if (cid.endsWith (OzcProperty.INTERFACE_POSTFIX)) {
      name = OzOzc_cl.searchAsInterface (cid);

      if (name != null) {
	ci = createClass (name);
	return ci.getInterface ();
      }
    } else {
      name = OzOzc_cl.searchAsImplementation (cid);
      if (name != null) {
	ci = createClass (name);
	return ci;
      }
    }

    return null;
  }
}
  
/* EOF */
