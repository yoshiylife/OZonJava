package JP.go.ipa.oz.user.inter.cgi;

public interface OzCGI_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.user.inter.cgi.HTMLData_if receiveRequest (JP.go.ipa.oz.lib.standard._String_if form_id) throws Exception ;
  void ping () throws Exception ;
  void quit () throws Exception ;
  void quiet () throws Exception ;
  void go () throws Exception ;
  void sendResult (JP.go.ipa.oz.user.inter.cgi.HTMLData_if result) throws Exception ;
}

