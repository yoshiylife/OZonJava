package JP.go.ipa.oz.user.ide;

public interface School_if extends JP.go.ipa.oz.compiler.OzSchool_if {
  
  JP.go.ipa.oz.user.ide.OzLabel_if getOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception ;
  void setDuplicates (JP.go.ipa.oz.lib.standard._Dictionary_if dict) throws Exception ;
  void loadFromFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if putSubject (JP.go.ipa.oz.user.ide.Subject_if aSubject) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if removeOzLabel (JP.go.ipa.oz.lib.standard._String_if labelName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfInterface (JP.go.ipa.oz.lib.standard._String_if interfaceID) throws Exception ;
  int getNumOfLabels (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getLabelPath (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getDuplicates () throws Exception ;
  JP.go.ipa.oz.user.ide.School_if putOzLabel (JP.go.ipa.oz.user.ide.OzLabel_if aOzLabel, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getAllLabels () throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getOzLabels () throws Exception ;
  void saveToFile (JP.go.ipa.oz.lib.standard._String_if fileName, JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  void mergeSubject (JP.go.ipa.oz.user.ide.Subject_if subject) throws Exception ;
  JP.go.ipa.oz.lib.standard._String_if getLabelPath2 (JP.go.ipa.oz.lib.standard._String_if labelName) throws Exception ;
  void checkDuplicate (JP.go.ipa.oz.user.ide.Subject_if subject1, JP.go.ipa.oz.user.ide.Subject_if subject2) throws Exception ;
  void renameSubject (JP.go.ipa.oz.lib.standard._String_if oldSubjectName, JP.go.ipa.oz.lib.standard._String_if newSubjectName) throws Exception ;
  JP.go.ipa.oz.user.ide.Subject_if getSubject (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if removeOzLabels (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  void toDevelopState (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.user.ide.School_if removeSubject (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
  JP.go.ipa.oz.user.ide.OzLabel_if getOzLabelOfImplementation (JP.go.ipa.oz.lib.standard._String_if implementationID) throws Exception ;
  JP.go.ipa.oz.lib.standard._Dictionary_if getSubjects () throws Exception ;
  void toReleasState (JP.go.ipa.oz.lib.standard._String_if subjectName) throws Exception ;
}

