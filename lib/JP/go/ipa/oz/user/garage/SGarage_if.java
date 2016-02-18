package JP.go.ipa.oz.user.garage;

public interface SGarage_if extends JP.go.ipa.oz.user.lib_dist.tran._TransactionResource_if, JP.go.ipa.oz.user.misc.cell.Stoppable_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.lib.standard._Iterator_if iterator () throws Exception ;
  void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception ;
  JP.go.ipa.oz.user.ide.Summary_if getSummary (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void replaceSummary (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Summary_if sm) throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if summaryIterator () throws Exception ;
  JP.go.ipa.oz.user.ide.Summarizable_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.user.ide.Summarizable_if sbl) throws Exception ;
}

