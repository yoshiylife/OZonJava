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
 * $Id: _PaintDispatcher_cl.java,v 1.1 1997/08/20 05:18:53 nito Exp $
 */
package JP.go.ipa.oz.lib.standard;

public final class _PaintDispatcher_cl
  extends    JP.go.ipa.oz.lang._Runnable_cl
  implements _PaintDispatcher_if
{
  _PaintDispatchingQueue_if paintQueue;
  
  public Object _new_create(_PaintDispatchingQueue_if queue) throws Exception
  {
    paintQueue = queue;
    return this;
  }
  
  public void run() throws Exception
  {
    checkSecureInvocation();
    _PaintUnit_if paint = null;
    while (true) {
      if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)paintQueue)) {
        try {
          paint = paintQueue.take();
        } finally {
          changeRunningToGreen();
        }
      } else {
        paint = paintQueue.take();
      }
      
      if (paint == null) break;
      
      dispatch(paint);
    }
  }
  
  void dispatch(_PaintUnit_if unit) throws Exception  {
    _Component_if component = null;
    _Graphics_if graphics = null;
    _Component_if getComponentVal;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)unit)) {
      try {
        getComponentVal = unit.getComponent();
      } finally {
        changeRunningToGreen();
      }
    } else {
      getComponentVal = unit.getComponent();
    }
    component = getComponentVal;
    boolean isRedVal;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)component)) {
      try {
        isRedVal = component.isRed();
      } finally {
        changeRunningToGreen();
      }
    } else {
      isRedVal = component.isRed();
    }
    if (isRedVal) {{
        return;
      }
    }
    _Graphics_if getGraphicsVal;
    int type = -1;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)unit)) {
      try {
        getGraphicsVal = unit.getGraphics();
        type = unit.getPaintType();
      } finally {
        changeRunningToGreen();
      }
    } else {
      getGraphicsVal = unit.getGraphics();
      type = unit.getPaintType();
    }
    graphics = getGraphicsVal;
    if (changeThreadRedIfNecessary((JP.go.ipa.oz.system.OzSecure)component)) {
      try {
        component.dispatch(graphics, type);
      } finally {
        changeRunningToGreen();
      }
    } else {
      component.dispatch (graphics, type);
    }
  }
  
  public _PaintDispatcher_cl() throws Exception { super(); }
}

