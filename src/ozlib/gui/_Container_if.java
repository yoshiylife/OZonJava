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
 * Container interface
 *
 * @version  $Id: _Container_if.java,v 1.11 1997/07/01 02:29:17 nito Exp $
 * @see      _Component_if
 */


public interface _Container_if
  extends JP.go.ipa.oz.lib.standard._Component_if
{

  //protected _new_newContainer() throws Exception;

  //================================================== OZ methods
  public _Component_if add(_Component_if comp) throws Exception;
  public _Component_if add(_String_if name, _Component_if comp) throws Exception;
  public _Component_if add(_Component_if comp, int index) throws Exception;
  public void add(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints) throws Exception;
  public void add(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints,
		  int index) throws Exception;
  public void addContainerListener(_ContainerListener_if l) throws Exception;
  public void addNotify() throws Exception;
  public void doLayout() throws Exception;
  public float getAlignmentX() throws Exception;
  public float getAlignmentY() throws Exception;
  public _Component_if getComponent(int n) throws Exception;
  public _Component_if getComponentAt(int x, int y) throws Exception;
  public _Component_if getComponentAt(_Point_if p) throws Exception;
  public int getComponentCount() throws Exception;
  public _Array_if getComponents() throws Exception;
  public _Insets_if getInsets() throws Exception;
  public _LayoutManager_if getLayout() throws Exception;
  public _Dimension_if getMaximumSize() throws Exception;
  public _Dimension_if getMinimumSize() throws Exception;
  public _Dimension_if getPreferredSize() throws Exception;
  public void invalidate() throws Exception;
  public boolean isAncestorOf(_Component_if c) throws Exception;
  //*public void list(_PrintStream_if out, int indent) throws Exception;
  public void list(_PrintWriter_if out, int indent) throws Exception;
  public void paint(_Graphics_if g) throws Exception;
  public void paintComponents(_Graphics_if g) throws Exception;
  public void print(_Graphics_if g) throws Exception;
  public void printComponents(_Graphics_if g) throws Exception;
  public void remove(int index) throws Exception;
  public void remove(_Component_if comp) throws Exception;
  public void removeAll() throws Exception;
  public void removeContainerListener(_ContainerListener_if l) throws Exception;
  public void removeNotify() throws Exception;
  public void setLayout(_LayoutManager_if mgr) throws Exception;
  public void setDefaultLayout() throws Exception;
  public void validate() throws Exception;

  //================================================== protected methods
  //protected void addImpl(_Component_if comp, JP.go.ipa.oz.lang._Root_if constraints, int index){}
  //protected String paramString(){}
  //protected void processEvent(_AWTEvent_if e){}
  //protected void processContainerEvent(ContainerEvent e){}
  //protected void validateTree(){}

}

// EoF

