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

package JP.go.ipa.oz.user.cda;

import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.Enumeration;
import java.io.IOException;

public class _CDAZipFile_cl extends JP.go.ipa.oz.lang._Root_cl implements JP.go.ipa.oz.user.cda._CDAZipFile_if {

  ZipFile _body;

  public Object _new_breed(JP.go.ipa.oz.lib.standard._String_if name) throws Exception{
    java.lang.String _name = ((JP.go.ipa.oz.lib.standard._String_cl)name).toString();
    try{
      _body = new ZipFile(_name);
    } catch(ZipException e){
      JP.go.ipa.oz.lib.standard._FileNotFoundException_if ex = (JP.go.ipa.oz.lib.standard._FileNotFoundException_cl)new JP.go.ipa.oz.lib.standard._FileNotFoundException_cl()._new_init();
      throw new JP.go.ipa.oz.lang.OzException(ex);
    } catch(IOException e){
      JP.go.ipa.oz.lib.standard._FileNotFoundException_if ex = (JP.go.ipa.oz.lib.standard._FileNotFoundException_cl)new JP.go.ipa.oz.lib.standard._FileNotFoundException_cl()._new_init();
      throw new JP.go.ipa.oz.lang.OzException(ex);
    }
    return this;
  }

  public JP.go.ipa.oz.lib.standard._Array_if list() throws Exception{
    checkSecureInvocation();
    Enumeration entries = _body.entries();
    java.util.Vector contents = new java.util.Vector();
    while (entries.hasMoreElements()) {
      ZipEntry entry = (ZipEntry)entries.nextElement();
      java.lang.String name = entry.getName();
      contents.addElement(name);
    }
    int i, len = contents.size();
    Enumeration enum = contents.elements();
    JP.go.ipa.oz.lib.standard._StringComparator_if comp = new JP.go.ipa.oz.lib.standard._StringComparator_cl();
    JP.go.ipa.oz.lib.standard._Array_if ret = (JP.go.ipa.oz.lib.standard._Array_cl)new JP.go.ipa.oz.lib.standard._Array_cl()._new_create(len, comp);
    for (i = 0; i < len; i ++) {
      java.lang.String name = (java.lang.String)enum.nextElement();
      JP.go.ipa.oz.lib.standard._String_if ozname = new JP.go.ipa.oz.lib.standard._String_cl(name);
      ret = ret.putAt(i,ozname);
    }
    return ret;
  }
  
  public _CDAZipFile_cl () throws Exception { super (); }
  
}

