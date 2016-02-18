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

/*
 * $Id: _File_if.java,v 1.7 1997/06/26 05:59:51 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _File_if
extends JP.go.ipa.oz.lang._Root_if
{
  
    public _String_if getName() throws Exception;
    public _String_if getPath() throws Exception;
    public _String_if getAbsolutePath() throws Exception;
    public _String_if getCanonicalPath() throws Exception;
    public _String_if getParent() throws Exception;
    public boolean exists() throws Exception;
    public boolean canWrite() throws Exception;
    public boolean canRead() throws Exception;
    public boolean isFile() throws Exception;
    public boolean isDirectory() throws Exception;
    public boolean isAbsolute() throws Exception;
    public long lastModified() throws Exception;
    public long length() throws Exception;
    public boolean mkdir() throws Exception;
    public boolean renameTo(_File_if arg_a) throws Exception;
    public boolean mkdirs() throws Exception;
    public _Array_if list() throws Exception;
    public _Array_if list(_FilenameFilter_if arg_a) throws Exception;
    public boolean delete() throws Exception;
    public boolean isequal(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception;
    public _String_if asString() throws Exception;

    public _String_if getSeparator() throws Exception;
    public char getSeparatorChar() throws Exception;
    public _String_if getPathSeparator() throws Exception;
    public char getPathSeparatorChar() throws Exception;
}
