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
 * $Id: OzOzc_if.java,v 0.9 1998-01-22 09:01:41+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1997.5.28
 */

package JP.go.ipa.oz.compiler;

import JP.go.ipa.oz.lib.standard.*;
import JP.go.ipa.oz.user.ide.*;

/**
  * main interface to use with OZ level school.
  *
  * @see OzOzc_cl
  */

public interface OzOzc_if {
  /**
    * invoke compilation 
    *
    * @param source source file name
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc);

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc, _String_if dir);

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @param output logging destination
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc, 
			  _Writer_if output);

  /**
    * invoke compilation 
    *
    * @param source source file name
    * @param output logging destination
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compile (_String_if source, OzSchool_if sc, 
			  _Writer_if output, _String_if dir);

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc);

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc, 
				   _String_if dir);

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @param output logging destination
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc, 
				   _Writer_if output);

  /**
    * invoke compilation of interface
    *
    * @param source source file name
    * @param output logging destination
    * @param dir output directory
    * @return if sucess true, otherwise false
    */
  public boolean compileInterface (_String_if source, OzSchool_if sc, 
				   _Writer_if output, _String_if dir);

  /**
    * display usage 
    *
    * @return usage string
    */
  public _String_if displayUsage ();

  /**
    * set domain name
    *
    * @param name domain name
    */
  public void setDomain (_String_if name);
}

/* EOF */
