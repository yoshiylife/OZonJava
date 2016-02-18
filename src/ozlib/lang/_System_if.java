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

package	JP.go.ipa.oz.lib.standard;
import JP.go.ipa.oz.lang._Root_if;
import JP.go.ipa.oz.lang._Proxy_if;

public interface _System_if extends _Root_if
{
    public void println(_Root_if obj) throws Exception;
    public void println(_String_if obj) throws Exception;
    public void systemPrintln(_Root_if obj) throws Exception;
    public void systemPrintln(_String_if obj) throws Exception;
    public void debugPrintln(_Root_if obj) throws Exception;
    public void debugPrintln(_String_if obj) throws Exception;
    public _InputStreamReader_if getStdin() throws Exception;
    public _PrintWriter_if getStdout() throws Exception;
    public _PrintWriter_if getStderr() throws Exception;
    public _Array_if getArguments() throws Exception;
    //public void setUserSecurity(_UserSecurity_if us) throws Exception;
    public _String_if getOzHome() throws Exception;
    public _String_if getGOL(Object proxy) throws Exception;
    public Object createCellForName(_String_if gol, _String_if cell) throws Exception;
    public void exec(_String_if command) throws Exception;
}
