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

public interface _ByteArray_if extends JP.go.ipa.oz.lang._Root_if {
    public int length() throws Exception ;
    public byte at(int idx) throws Exception ;
    public void putAt(int idx, int i) throws Exception ;
    public void putAt(int idx, byte b) throws Exception ;
    public void setAt(int idx, int i) throws Exception ;
    public void setAt(int idx, byte b) throws Exception ;
    public _String_if asString() throws Exception ;
}
