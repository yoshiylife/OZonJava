package JP.go.ipa.oz.user.inter.lib;

public interface SMTP_if extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_if {
  
  JP.go.ipa.oz.lib.standard._String_if turn () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if help (JP.go.ipa.oz.lib.standard._String_if str) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if help () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if vrfy (JP.go.ipa.oz.lib.standard._String_if user) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rset () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if mail (JP.go.ipa.oz.lib.standard._String_if from) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if soml (JP.go.ipa.oz.lib.standard._String_if from) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if helo (JP.go.ipa.oz.lib.standard._String_if domain) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if noop () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if send (JP.go.ipa.oz.lib.standard._String_if from) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if expn (JP.go.ipa.oz.lib.standard._String_if ml) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if data (JP.go.ipa.oz.lib.standard._String_if contents) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if quit () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rcpt (JP.go.ipa.oz.lib.standard._String_if to) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if saml (JP.go.ipa.oz.lib.standard._String_if from) throws Exception ;
}

