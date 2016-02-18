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
 * $Id: _PaintUnit_cl.java,v 1.1 1997/08/20 05:18:53 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

final public class _PaintUnit_cl
  extends JP.go.ipa.oz.lang._Root_cl
  implements _PaintUnit_if
{
  _Component_if component;
  _Graphics_if  graphics;
  int           type;
  
  public Object _new_create(_Component_if c, _Graphics_if g, int t)
  throws Exception
  {
    component = c;
    graphics = g;
    type = t;
    return this;
  }
  
  public _Component_if getComponent() throws Exception
  {
    checkSecureInvocation();
    return component;
  }
  
  public _Graphics_if getGraphics() throws Exception
  {
    checkSecureInvocation();
    return graphics;
  }
  
  public int getPaintType() throws Exception
  {
    checkSecureInvocation();
    return type;
  }
  
  public _PaintUnit_cl() throws Exception { super (); }
  
}

