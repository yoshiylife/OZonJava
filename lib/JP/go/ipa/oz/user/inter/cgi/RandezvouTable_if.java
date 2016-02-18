package JP.go.ipa.oz.user.inter.cgi;

public interface RandezvouTable_if extends JP.go.ipa.oz.lib.standard._Dictionary_if {
  
  void finish () throws Exception ;
  void registerRandezvouPoint (JP.go.ipa.oz.lib.standard._String_if id, JP.go.ipa.oz.user.inter.cgi.RandezvouPoint_if rp) throws Exception ;
  void signalRandezvouPoint (JP.go.ipa.oz.lib.standard._String_if id, JP.go.ipa.oz.user.inter.cgi.HTMLData_if html) throws Exception ;
}

