package JP.go.ipa.oz.user.inter.lib;

public interface POP3_if extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_if {
  
  JP.go.ipa.oz.lib.standard._String_if uidl () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if uidl (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if pass (JP.go.ipa.oz.lib.standard._String_if password) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if user (JP.go.ipa.oz.lib.standard._String_if username) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rset () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if param (JP.go.ipa.oz.lib.standard._String_if param) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if retr (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if noop () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if list (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if list () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if quit () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if dele (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if top (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stat () throws Exception ;
}

