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
 * HashNode
 * contains the key-value pair and the hash code of the key.
 *
 * @version  $Id: _HashNode.java,v 1.6 1997/06/24 08:42:36 hgoto Exp $
 * @see      _Dictionary_cl
 */


class _HashNode extends JP.go.ipa.oz.lang._Root_cl
{
  JP.go.ipa.oz.lang._Root_if  key;
  JP.go.ipa.oz.lang._Root_if  value;
  int  hashCode;
  _HashNode  next;

  _HashNode(JP.go.ipa.oz.lang._Root_if key,
	    JP.go.ipa.oz.lang._Root_if value,
	    int hashCode)
  {
    this.key = key;
    this.value = value;
    this.hashCode = hashCode;
  }

}

// EoF

