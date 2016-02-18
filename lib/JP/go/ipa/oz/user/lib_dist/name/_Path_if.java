package JP.go.ipa.oz.user.lib_dist.name;

public interface _Path_if extends JP.go.ipa.oz.lang._Root_if {
  static final boolean _final_ = true;
  
  boolean isequal (JP.go.ipa.oz.user.lib_dist.name._Path_if with) throws Exception ;
  boolean isEmpty () throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._Path_if makeLowerPath (JP.go.ipa.oz.lib.standard._String_if delimitor, JP.go.ipa.oz.lib.standard._String_if subdirname) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._Path_if UpperPath (JP.go.ipa.oz.lib.standard._String_if delimiter) throws Exception ;
  JP.go.ipa.oz.user.lib_dist.name._Path_if translateWith (JP.go.ipa.oz.user.lib_dist.name._Path_if from, JP.go.ipa.oz.user.lib_dist.name._Path_if to) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if LowerName (JP.go.ipa.oz.lib.standard._String_if delimiter) throws Exception ;
}

