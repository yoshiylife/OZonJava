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

// OZ Class Library (Collection)


package JP.go.ipa.oz.lib.standard;


/**
 * SListNode implementation
 *
 * @version  $Id: _SListNode.java,v 1.5 1997/06/06 10:56:23 hgoto Exp $
 * @see      _SList_cl
 */


public final class _SListNode
  extends JP.go.ipa.oz.lang._Root_cl
{

  JP.go.ipa.oz.lang._Root_if  value;
  _SListNode  next;

  //================================================== constructors

  _SListNode(JP.go.ipa.oz.lang._Root_if v)
  {
    this.value = v;
  }

  _SListNode(JP.go.ipa.oz.lang._Root_if v, _SListNode next)
  {
    this.value = v;
    this.next = next;
  }


  //================================================== methods

}

// EoF
