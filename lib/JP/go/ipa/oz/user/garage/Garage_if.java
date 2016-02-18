package JP.go.ipa.oz.user.garage;

public interface Garage_if extends JP.go.ipa.oz.lang._Root_if {
  
  void remove (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  int size () throws Exception ;
  void replace (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.lang._Root_if value) throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if put (JP.go.ipa.oz.lang._Root_if value) throws Exception ;
  JP.go.ipa.oz.lib.standard._Collection_if keys () throws Exception ;
  JP.go.ipa.oz.lib.standard._Iterator_if iterator () throws Exception ;
  JP.go.ipa.oz.lang._Root_if get (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
}

