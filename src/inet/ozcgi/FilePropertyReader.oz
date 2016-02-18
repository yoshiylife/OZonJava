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
 * $Id: FilePropertyReader.oz,v 0.1 1998-01-22 16:59:03+09 otokawa Exp $
 */

/**
  * a class for reader and evaluator of property file
  */

abstract class FilePropertyReader {
  /**
    * evaluator read value pairs
    *
    * @param label label string
    * @param value value string
    */
  public abstract void eval (String label, String value);
}

/* EOF */
