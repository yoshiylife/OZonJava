package JP.go.ipa.oz.user.inter.cgi;

public interface RandezvouPoint_if extends JP.go.ipa.oz.lang._Root_if {
  
  void setHtml (JP.go.ipa.oz.user.inter.cgi.HTMLData_if html) throws Exception ;
  void waitRandezvou () throws Exception ;
  void signalRandezvou () throws Exception ;
  JP.go.ipa.oz.user.inter.cgi.HTMLData_if getHtml () throws Exception ;
}

