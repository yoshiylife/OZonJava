package JP.go.ipa.oz.user.inter.lib;

public interface NNTP_if extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_if {
  
  JP.go.ipa.oz.lib.standard._String_if slave () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if head () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if head (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if help () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if last () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if body () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if body (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if post (JP.go.ipa.oz.lib.standard._String_if contents) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if group (JP.go.ipa.oz.lib.standard._String_if group) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if next () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if article () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if article (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if list () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if newgroups (JP.go.ipa.oz.lib.standard._String_if param) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if quit () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if ihave (JP.go.ipa.oz.lib.standard._String_if msg, JP.go.ipa.oz.lib.standard._String_if contents) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if newnews (JP.go.ipa.oz.lib.standard._String_if param) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stat () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stat (JP.go.ipa.oz.lib.standard._String_if msg) throws Exception ;
}

