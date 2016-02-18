package JP.go.ipa.oz.user.garage;

public interface SubjectGarage_if extends JP.go.ipa.oz.user.garage.SGarage_if {
  static final boolean _global_ = true;
  
  JP.go.ipa.oz.user.ide.Subject_if getSubject (JP.go.ipa.oz.user.garage.Key_if key) throws Exception ;
  void replaceSubject (JP.go.ipa.oz.user.garage.Key_if key, JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception ;
  JP.go.ipa.oz.user.garage.Key_if putSubject (JP.go.ipa.oz.user.ide.Subject_if sbj) throws Exception ;
}

