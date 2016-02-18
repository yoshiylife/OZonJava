package JP.go.ipa.oz.user.inter.lib;

public interface FTPClient_if extends JP.go.ipa.oz.user.inter.lib.FTP_if {
  
  boolean conn (JP.go.ipa.oz.lib.standard._String_if host) throws Exception ;
  boolean conn (JP.go.ipa.oz.lib.standard._String_if host, int port) throws Exception ;
  boolean binary () throws Exception ;
  boolean mkdir (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if dir (JP.go.ipa.oz.lib.standard._String_if path) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if dir () throws Exception ;
  boolean ascii () throws Exception ;
  boolean cd (JP.go.ipa.oz.lib.standard._String_if pathname) throws Exception ;
  boolean disconnect () throws Exception ;
  boolean userAndPassword (JP.go.ipa.oz.lib.standard._String_if user, JP.go.ipa.oz.lib.standard._String_if pass) throws Exception ;
  boolean get (JP.go.ipa.oz.lib.standard._String_if remote_file, JP.go.ipa.oz.lib.standard._String_if source_file) throws Exception ;
  boolean get (JP.go.ipa.oz.lib.standard._String_if files) throws Exception ;
  boolean put (JP.go.ipa.oz.lib.standard._String_if source_file, JP.go.ipa.oz.lib.standard._String_if remote_file) throws Exception ;
  boolean put (JP.go.ipa.oz.lib.standard._String_if files) throws Exception ;
}

