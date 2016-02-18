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

// DEV: CIExcpeption


/**
 * CIException
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIException
{

  String  message;
  String  cid;


  //////////////////////////////////////////////////// constructors

  new newCIException(String msg)
  {
    this->message = msg;
    this->cid = "unknown";
  }


  new newCIException(String msg, String cid)
  {
    this->message = msg;
    this->cid = cid;
  }


  //////////////////////////////////////////////////// public methods

  public String asString()
  {
    StringBuffer  str;

    str => breed(message);
    if (cid != null) {
      str->append(" (CID=")->append(cid)->append(")");
    }

    return str->asString();
  }

  public String getMessage()
  {
    return message;
  }

  public String getCID()
  {
    return cid;
  }

  public void setCID(String cid)
  {
    this->cid = cid;
  }
  
}

// EoF

