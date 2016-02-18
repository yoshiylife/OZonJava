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

