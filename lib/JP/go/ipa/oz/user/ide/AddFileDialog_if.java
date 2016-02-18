package JP.go.ipa.oz.user.ide;

public interface AddFileDialog_if extends JP.go.ipa.oz.lib.standard._Dialog_if {
  
  void initGUI () throws Exception ;
  void setNextDirectory () throws Exception ;
  void setFiles (JP.go.ipa.oz.lib.standard._Array_if selectedFiles) throws Exception ;
  void setDirectory (JP.go.ipa.oz.lib.standard._String_if dirName) throws Exception ;
  void changeDrive () throws Exception ;
  void setItem () throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getFiles () throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getSelectedFiles () throws Exception ;
  void setFile (JP.go.ipa.oz.lib.standard._String_if fileName) throws Exception ;
  JP.go.ipa.oz.lib.standard._Array_if getFilesInDirectory () throws Exception ;
}

