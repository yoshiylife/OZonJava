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
 * ZipArchive implementation
 *
 * @version  $Id: _ZipArchive_cl.java,v 1.7 1997/12/09 06:20:38 nito Exp $
 */

package JP.go.ipa.oz.lib.standard;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;

import java.util.Enumeration;

import java.util.zip.ZipFile;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import java.io.IOException;
import java.io.FileNotFoundException;

import java.util.zip.ZipException;

import JP.go.ipa.oz.lang._Root_if;
import JP.go.ipa.oz.lang._Root_cl;

public final class _ZipArchive_cl extends _Root_cl implements _ZipArchive_if
{
    String	archiveName;

    public _ZipArchive_cl() throws Exception
    {
	super();
    }

/**** FOR TEST ****/
/***
    public static void main( String argv[] ) {
	try {
	    _ZipArchive_cl arc
		= (_ZipArchive_cl)
		  (new _ZipArchive_cl()._new_create(new _String_cl("debug.zip")));
	    //arc.add(new _String_cl("debug/main.ps"));
	    //arc.extract(new _String_cl("debug/main.ps"));
	    //arc.list();
            _Set_if entries = (_Set_if)(new _Set_cl()._new_create());
	    _String_if entry;
	    entry = new _String_cl("_ZipException_if.java");
	    if (entry != null) entries.add(entry);
	    entry = new _String_cl("_ZipException_cl.java");
	    if (entry != null) entries.add(entry);
	    arc.store(entries);
	} catch (Exception e) {}
    }
***/

    public _Root_if _new_create(_String_if archivename) throws Exception
    {
	archiveName = ((_String_cl)archivename)._body;
	return this;
    }

/*** 1997/8/26 COMMENT OUT.
    public void add(_String_if entryName) throws Exception
    {
	try {
	    File entry = new java.io.File(((_String_cl)entryName)._body);
	    FileInputStream     fis = new FileInputStream(entry);
	    BufferedInputStream bis = new BufferedInputStream(fis);

	    File archive = new java.io.File(archiveName);
	    FileOutputStream fos = new FileOutputStream(archiveName);
	    ZipOutputStream  zos = new ZipOutputStream(fos);

	    ZipEntry target = new ZipEntry(entry.getPath());

	    zos.putNextEntry(target);

	    byte buf[] = new byte[1024];
	    int count;
	    while((count = bis.read(buf, 0, 1024)) != -1) {
		zos.write(buf, 0, count);
	    }
            bis.close();
	    fis.close();
	    zos.closeEntry();
	    zos.close();
	    fos.close();
	} catch (FileNotFoundException ex) {
	    _FileNotFoundException_if  ex_oz
		= (_FileNotFoundException_cl)(new _FileNotFoundException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (ZipException ex) {
	    _ZipException_if  ex_oz
		= (_ZipException_cl)(new _ZipException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (IOException ex) {
	    _IOException_if  ex_oz
		= (_IOException_cl)(new _IOException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	}
    }
***/

    public void store(_String_if filePath, _String_if entryPath, _Collection_if entryNames) throws Exception
    {
	checkSecureInvocation();
	enter();
	try {
	    _Iterator_if it = entryNames.iterator();
	    File archive = new java.io.File(archiveName);
	    FileOutputStream fos = new FileOutputStream(archiveName);
	    ZipOutputStream  zos = new ZipOutputStream(fos);
	    File entry;
	    FileInputStream fis;
	    BufferedInputStream bis;
	    ZipEntry target;
	    
	    byte buf[] = new byte[1024];
	    int count;

	    target = new ZipEntry(((_String_cl)entryPath)._body);
	    zos.putNextEntry(target);
	    zos.closeEntry();

	    while (it.hasMoreElements()) {
		_String_cl entryName = (_String_cl)it.nextElement();
		_String_cl entryFullPath = (_String_cl)entryPath.concat(entryName);
		_String_cl fileFullPath = (_String_cl)filePath.concat(entryName);
		entry = new java.io.File(((_String_cl)fileFullPath)._body);
		fis = new FileInputStream(entry);
		bis = new BufferedInputStream(fis);

		target = new ZipEntry(entryFullPath._body);

		zos.putNextEntry(target);

		while((count = bis.read(buf, 0, 1024)) != -1) {
		    zos.write(buf, 0, count);
		}
		bis.close();
		fis.close();
		zos.closeEntry();
	    }
	    zos.close();
	    fos.close();
	} catch (FileNotFoundException ex) {
	    _FileNotFoundException_if  ex_oz
		= (_FileNotFoundException_cl)(new _FileNotFoundException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (ZipException ex) {
	    _ZipException_if  ex_oz
		= (_ZipException_cl)(new _ZipException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (IOException ex) {
	    _IOException_if  ex_oz
		= (_IOException_cl)(new _IOException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} finally {
	    leave();
	}
    }

    public void extract(_String_if filePath,_String_if entryname) throws Exception
    {
	checkSecureInvocation();
	enter();
	try {
	    File archive = new java.io.File(archiveName);
	    ZipFile zf = new ZipFile(archive);
	    Enumeration enum = zf.entries();

	    boolean foundFlag = false;
	    while(enum.hasMoreElements()) {
		ZipEntry target = (ZipEntry)enum.nextElement();
		if(target.getName().equals(((_String_cl)entryname)._body)) {
		    File file = new File(((_String_cl)filePath)._body);
		    InputStream is = zf.getInputStream(target); 
		    BufferedInputStream bis = new BufferedInputStream(is);

		    File dir = new File(file.getParent());
		    dir.mkdirs();
		    FileOutputStream fos = new FileOutputStream(file);
		    BufferedOutputStream bos = new BufferedOutputStream(fos);

		    int c;
		    while((c = bis.read()) != -1) {
			bos.write((byte)c);
		    }
		    zf.close();
		    bos.close();
		    fos.close();

		    foundFlag = true;
		    break;
		}
	    }
	    if(!foundFlag) {
		_FileNotFoundException_if  ex_oz
		    = (_FileNotFoundException_cl)(new _FileNotFoundException_cl()._new_init("Target file not found in the zipfile"));
		throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	    }
	} catch (FileNotFoundException ex) {
	    _FileNotFoundException_if  ex_oz
		= (_FileNotFoundException_cl)(new _FileNotFoundException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (ZipException ex) {
	    _ZipException_if  ex_oz
		= (_ZipException_cl)(new _ZipException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (IOException ex) {
	    _IOException_if  ex_oz
		= (_IOException_cl)(new _IOException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} finally {
	    leave();
	}
    }

    public _Collection_if list() throws Exception
    {
	checkSecureInvocation();
	enter();
        _Set_if entries = (_Set_if)(new _Set_cl()._new_create());
	try {
	    File archive = new java.io.File(archiveName);
	    ZipFile zf = new ZipFile(archive);
	    Enumeration enum = zf.entries();

	    while(enum.hasMoreElements()) {
		ZipEntry target = (ZipEntry)enum.nextElement();
		_String_if entry = new _String_cl(target.getName());
		if (entry != null) entries.add(entry);
	    }
	} catch (FileNotFoundException ex) {
	    _FileNotFoundException_if  ex_oz
		= (_FileNotFoundException_cl)(new _FileNotFoundException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (ZipException ex) {
	    _ZipException_if  ex_oz
		= (_ZipException_cl)(new _ZipException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} catch (IOException ex) {
	    _IOException_if  ex_oz
		= (_IOException_cl)(new _IOException_cl()._new_init(ex.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(ex_oz);
	} finally {
	    leave();
	}
	return entries;
    }
}
