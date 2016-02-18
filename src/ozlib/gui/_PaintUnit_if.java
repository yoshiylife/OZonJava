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
 * $Id: _PaintUnit_if.java,v 1.1 1997/08/20 05:18:53 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public interface _PaintUnit_if extends JP.go.ipa.oz.lang._Root_if
{
  _Component_if getComponent() throws Exception;
  _Graphics_if getGraphics() throws Exception;
  int getPaintType() throws Exception;
}

