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

package JP.go.ipa.oz.system;

/***
 * Object not found on the executor where that object expected.
 * This exception occures as the result of resolution which use out-of-date cached data.
 */
public
class ExCellNotFoundException
extends ExCellException
{
  public ExCellNotFoundException()
    {
	  super();
    }

  public ExCellNotFoundException(String message)
    {
      super(message);
    }
}
