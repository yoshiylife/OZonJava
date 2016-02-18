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

/**
 * ZipArchive interface
 *
 * @version  $Id: _ZipArchive_if.java,v 1.3 1997/12/04 06:48:44 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

import JP.go.ipa.oz.lang._Root_if;

public interface _ZipArchive_if extends _Root_if
{
    //public void add(_String_if entryname) throws Exception;
    public void store(_String_if filePath, _String_if entryPath, _Collection_if entrynames) throws Exception;
    public void extract(_String_if filePath, _String_if entryname) throws Exception;
    public _Collection_if list() throws Exception;
}
