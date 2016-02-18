/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

package JP.go.ipa.oz.lib.standard;

public interface _ClassProperty_if extends JP.go.ipa.oz.lib.standard._File_if {
    public _String_if getClassName() throws Exception;
    public _String_if getCodePath()throws Exception;
    public _InputStream_if getInputStream() throws Exception;
    public _OutputStream_if getOutputStream() throws Exception;
    public boolean isReleasedUserClassFile() throws Exception;
    public boolean isUserClassFile() throws Exception;
}