package JP.go.ipa.oz.user.inter.lib;

public interface FTP_if extends JP.go.ipa.oz.user.inter.lib.NetworkProtocol_if {
  
  JP.go.ipa.oz.lib.standard._String_if stor (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if port (JP.go.ipa.oz.lib.standard._String_if host_port) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if site (JP.go.ipa.oz.lib.standard._String_if str) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if retr (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._OutputStream_if out) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if mkd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if allo (JP.go.ipa.oz.lib.standard._String_if integer) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if abor () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if quit () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if nlst (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if nlst () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if cwd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rnfr (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getData () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if acct (JP.go.ipa.oz.lib.standard._String_if username) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rest (JP.go.ipa.oz.lib.standard._String_if marker) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rnto (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if user (JP.go.ipa.oz.lib.standard._String_if username) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if smnt (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if appe (JP.go.ipa.oz.lib.standard._String_if pathname, JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if syst () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rmd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stru (JP.go.ipa.oz.lib.standard._String_if structure) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if dele (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if help (JP.go.ipa.oz.lib.standard._String_if str) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if help () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if cdup () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if noop () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if pwd () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if mode (JP.go.ipa.oz.lib.standard._String_if mode_code) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if type (JP.go.ipa.oz.lib.standard._String_if type_code) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if rein () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if pasv () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if list (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if list () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getRecvData () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if pass (JP.go.ipa.oz.lib.standard._String_if password) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stat (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stat () throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if stou (JP.go.ipa.oz.lib.standard._InputStream_if in) throws Exception ;
}

