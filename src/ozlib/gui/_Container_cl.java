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

// OZ Class Library (AWT)


package JP.go.ipa.oz.lib.standard;


/**
 * Container implementation
 *
 * @version  $Id: _Container_cl.java,v 1.13 1997/07/04 02:27:07 nito Exp $
 * @see      _Container_if
 * @see      _Component_cl
 */


public abstract class _Container_cl
  extends JP.go.ipa.oz.lib.standard._Component_cl
  implements JP.go.ipa.oz.lib.standard._Container_if
{

  //================================================== constructors

  protected _Container_cl()
    throws Exception
  {
  }

  //======================================== OZ constructor implementation

  protected java.lang.Object _new_newContainer()
    throws Exception
  {
    return this;
  }


  //======================================== OZ method implementation

  //------------------------------------------------------------------
  public _Component_if add(_Component_if comp)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    ((java.awt.Container)_body).add(arg_comp);
    return comp;
  }

  //------------------------------------------------------------------
  public _Component_if add(_String_if name, _Component_if comp)
    throws Exception
  {
    checkSecureInvocation();
    java.lang.String  arg_name = ((_String_cl)name)._body;
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    ((java.awt.Container)_body).add(arg_name, arg_comp);
    return comp;
  }

  //------------------------------------------------------------------
  public _Component_if add(_Component_if comp, int index)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    ((java.awt.Container)_body).add(arg_comp, index);
    return comp;
  }

  //------------------------------------------------------------------
  public void add(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    java.lang.Object  arg_constraints = constraints;
    ((java.awt.Container)_body).add(arg_comp, arg_constraints);
  }

  //------------------------------------------------------------------
  public void add(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints,
		  int index)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    java.lang.Object  arg_constraints = constraints;
    ((java.awt.Container)_body).add(arg_comp, arg_constraints, index);
  }

  //------------------------------------------------------------------
  public void addContainerListener(_ContainerListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ContainerListener  arg_l = (java.awt.event.ContainerListener)(((_ContainerListener_cl)l)._body);
    ((java.awt.Container)_body).addContainerListener(arg_l);
  }

  //------------------------------------------------------------------
  public void addNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).addNotify();
  }

  //------------------------------------------------------------------
  public void doLayout()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).doLayout();
  }
    
  //------------------------------------------------------------------
  public float getAlignmentX()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Container)_body).getAlignmentX();
  }
    
  //------------------------------------------------------------------
  public float getAlignmentY()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Container)_body).getAlignmentY();
  }
    
  //------------------------------------------------------------------
  public _Component_if getComponent(int n)
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable rv_tmp;
    _Component_if  rv;
    rv_tmp = (_OzHoldable)(((java.awt.Container)_body).getComponent(n));
    rv = (_Component_if)(rv_tmp.oz());
    return rv;
  }
    
  //------------------------------------------------------------------
  public _Component_if getComponentAt(int x, int y)
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable rv_tmp = (_OzHoldable)(((java.awt.Container)_body).getComponentAt(x, y));
    _Component_if  rv = (_Component_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Component_if getComponentAt(_Point_if p)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Point  arg_p = ((_Point_cl)p)._body;
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Container)_body).getComponentAt(arg_p));
    _Component_if  rv = (_Component_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public int getComponentCount()
    throws Exception
  {
    checkSecureInvocation();
    return ((java.awt.Container)_body).getComponentCount();
  }

  //------------------------------------------------------------------
  public _Array_if getComponents()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable[]  rv_tmp = (_OzHoldable[])(((java.awt.Container)_body).getComponents());
    _Array_if rv = null;
    if (0 < rv_tmp.length) {
      rv = (_Array_if)new _Array_cl()._new_create(rv_tmp.length, new _StringComparator_cl());
      for (int i = 0; i < rv_tmp.length; i++) {
	rv.putAt(i, (_Component_if)(rv_tmp[i].oz()));
      }
    }
    return rv;
  }

  //------------------------------------------------------------------
  public _Insets_if getInsets()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Insets  rv_tmp = ((java.awt.Container)_body).getInsets();
    if (rv_tmp == null) return null;
    _Insets_if  rv = new _Insets_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _LayoutManager_if getLayout()
    throws Exception
  {
    checkSecureInvocation();
    _OzHoldable  rv_tmp = (_OzHoldable)(((java.awt.Container)_body).getLayout());
    if (rv_tmp == null) return null;
    _LayoutManager_if  rv = (_LayoutManager_if)(rv_tmp.oz());
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMaximumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Container)_body).getMaximumSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getMinimumSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Container)_body).getMinimumSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public _Dimension_if getPreferredSize()
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Dimension  rv_tmp = ((java.awt.Container)_body).getPreferredSize();
    if (rv_tmp == null) return null;
    _Dimension_if  rv = new _Dimension_cl(rv_tmp);
    return rv;
  }

  //------------------------------------------------------------------
  public void invalidate()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).invalidate();
  }

  //------------------------------------------------------------------
  public boolean isAncestorOf(_Component_if comp)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    return ((java.awt.Container)_body).isAncestorOf(arg_comp);
  }

  //------------------------------------------------------------------
  //*public void list(PrintStream out, int indent) {}

  //------------------------------------------------------------------
  public void list(_PrintWriter_if out, int indent)
    throws Exception
  {
    checkSecureInvocation();
    java.io.PrintWriter  arg_g = (java.io.PrintWriter)(((_PrintWriter_cl)out)._body);
    ((java.awt.Container)_body).list(arg_g, indent);
  }

    
  //------------------------------------------------------------------
  public void paint(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Container)_body).paint(arg_g);
  }

  //------------------------------------------------------------------
  public void paintComponents(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Container)_body).paintComponents(arg_g);
  }

  //------------------------------------------------------------------
  public void print(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Container)_body).print(arg_g);
  }

  //------------------------------------------------------------------
  public void printComponents(_Graphics_if g)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Graphics  arg_g = ((_Graphics_cl)g)._body;
    ((java.awt.Container)_body).printComponents(arg_g);
  }

  //------------------------------------------------------------------
  public void remove(int index)
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).remove(index);
  }

  //------------------------------------------------------------------
  public void remove(_Component_if comp)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.Component  arg_comp = (java.awt.Component)(((_Component_cl)comp)._body);
    ((java.awt.Container)_body).remove(arg_comp);
  }

  //------------------------------------------------------------------
  public void removeAll()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).removeAll();
  }

  //------------------------------------------------------------------
  public void removeContainerListener(_ContainerListener_if l)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.event.ContainerListener  arg_l = ((_ContainerListener_cl)l)._body;
    ((java.awt.Container)_body).removeContainerListener(arg_l);
  }

  //------------------------------------------------------------------
  public void removeNotify()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).removeNotify();
  }

  //------------------------------------------------------------------
  public void setLayout(_LayoutManager_if mgr)
    throws Exception
  {
    checkSecureInvocation();
    java.awt.LayoutManager  arg_mgr = (java.awt.LayoutManager)((_OzHoldable)(mgr.java()));
    ((java.awt.Container)_body).setLayout(arg_mgr);
  }

  //------------------------------------------------------------------
  public void setDefaultLayout()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).setLayout(null);
  }

  //------------------------------------------------------------------
  public void validate()
    throws Exception
  {
    checkSecureInvocation();
    ((java.awt.Container)_body).validate();
  }


  //================================================== protected methods
  //protected void addImpl(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints, int index){}
  //protected String paramString(){}
  //protected void processEvent(_AWTEvent_if e){}
  //protected void processContainerEvent(ContainerEvent e){}
  //protected void validateTree(){}
    
}

// EoF

