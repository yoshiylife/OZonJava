package JP.go.ipa.oz.user.inter.lib;

abstract public class NetworkProtocol_cl extends JP.go.ipa.oz.user.inter.lib.NetworkClient_cl implements JP.go.ipa.oz.user.inter.lib.NetworkProtocol_if {
  
  public Object _new_create (int port) throws Exception  {
// 16
    super._new_create ((new JP.go.ipa.oz.lib.standard._String_cl("COMMAND PARAM")), (new JP.go.ipa.oz.lib.standard._String_cl("STATUS MESSAGE")), (new JP.go.ipa.oz.lib.standard._String_cl("\r\n")), port);
    return this;
  }
  
  public JP.go.ipa.oz.lib.standard._String_if sendCommand () throws Exception  {
    checkSecureInvocation ();
// 50
    return super.sendCommand ();
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if sendCommand (JP.go.ipa.oz.lib.standard._String_if command) throws Exception  {
// 43
    return sendCommand (command, null);
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if sendCommand (JP.go.ipa.oz.lib.standard._String_if command, JP.go.ipa.oz.lib.standard._String_if param) throws Exception  {
// 30
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        record.setCommand (command);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      record.setCommand (command);
    }
// 31
    JP.go.ipa.oz.lib.standard._String_if string$21 = (new JP.go.ipa.oz.lib.standard._String_cl("PARAM"));
    
// 31
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        record.set (string$21, param);
      } finally {
        changeRunningToGreen ();
      }
    } else {
      record.set (string$21, param);
    }
// 32
    return sendCommand ();
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if decodeResponse (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  {
// 73
    return data;
  }
  
  protected JP.go.ipa.oz.lib.standard._String_if recvMultilineResponse () throws Exception  {
// 59
    if (!isLastLine (getResponse ())) {{
// 60
        while (true) {
          if (!(!isLastLine (moreResponse ()))) break;
          
          /* body */ _loop_1: 
// 60
          ;
        }
      }
    }
// 63
    JP.go.ipa.oz.lib.standard._String_if getStatus$val$107;
    if (changeThreadRedIfNecessary ((JP.go.ipa.oz.system.OzSecure) record)) {
      try {
        getStatus$val$107 = record.getStatus ();
      } finally {
        changeRunningToGreen ();
      }
    } else {
      getStatus$val$107 = record.getStatus ();
    }
// 63
    return decodeResponse (getStatus$val$107);
  }
  
  protected abstract boolean isLastLine (JP.go.ipa.oz.lib.standard._String_if data) throws Exception  ;
  public NetworkProtocol_cl () throws Exception { super (); }
  
}

