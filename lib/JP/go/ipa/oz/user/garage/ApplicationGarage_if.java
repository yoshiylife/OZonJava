package JP.go.ipa.oz.user.garage;

public interface ApplicationGarage_if extends JP.go.ipa.oz.user.garage.SGarage_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.user.ide.Application_if getApplication (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if putApplication (JP.go.ipa.oz.user.ide.Application_if app) throws Exception ;
  void replaceApplication (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Application_if app) throws Exception ;
}

