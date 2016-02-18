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
 * $Id: OzSchool_if.java,v 0.3 1997-11-13 09:52:23+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.7.4
 */

package JP.go.ipa.oz.compiler;

import JP.go.ipa.oz.lib.standard.*;

/**
  * interface for OZ level school
  */

public interface OzSchool_if extends JP.go.ipa.oz.lang._Root_if {
  public _String_if getInterfaceID (_String_if name) throws Exception;
  public _String_if getImplementationID (_String_if name) throws Exception;
  public _String_if getNameOfInterface (_String_if cid) throws Exception;
  public _String_if getNameOfImplementation (_String_if cid) throws Exception;
}

/* EOF */
