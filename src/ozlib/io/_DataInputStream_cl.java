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
 * $Id: _DataInputStream_cl.java,v 1.4 1997/06/12 09:50:03 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _DataInputStream_cl
    extends _FilterInputStream_cl
    implements _DataInputStream_if
{
    public final java.lang.Object _java() { return _body; }
    public Object _new_breed(_InputStream_if arg_a) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	_body = new java.io.DataInputStream((java.io.InputStream)(var_a._body));
    return this;
    }

    public final int read(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.DataInputStream)_body).read((byte[])(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	int work;
	int ret;
	try {
	    work = ((java.io.DataInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final void readFully(_ByteArray_if arg_a) 
    	throws Exception    		   
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	try {
	    ((java.io.DataInputStream)_body).readFully((byte[])(var_a._body));
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
    }

    public final void readFully(_ByteArray_if arg_a, int arg_b, int arg_c) 
    	throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.DataInputStream)_body).readFully((byte[])(var_a._body), var_b, var_c);
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
    }

    public final int skipBytes(int arg_a) 
    	throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.DataInputStream)_body).skipBytes(var_a);
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final boolean readBoolean() 
    	throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	try {
	    work = ((java.io.DataInputStream)_body).readBoolean();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final byte readByte() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	byte work;
	byte ret;
	try {
	    work = ((java.io.DataInputStream)_body).readByte();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	} 
	ret = work;
	return ret;
    }

    public final int readUnsignedByte() 
    	throws Exception    		  
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.DataInputStream)_body).readUnsignedByte();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	} 
	ret = work;
	return ret;
    }

    public final short readShort() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	short work;
	short ret;
	try {
	    work = ((java.io.DataInputStream)_body).readShort();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final int readUnsignedShort() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.DataInputStream)_body).readUnsignedShort();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	} 
	ret = work;
	return ret;
    }

    public final char readChar() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	char work;
	char ret;
	try {
	    work = ((java.io.DataInputStream)_body).readChar();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final int readInt() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.DataInputStream)_body).readInt();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	} 
	ret = work;
	return ret;
    }

    public final long readLong() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	long work;
	long ret;
	try {
	    work = ((java.io.DataInputStream)_body).readLong();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final float readFloat() 
    	throws Exception    		   
    {
	checkSecureInvocation();
	float work;
	float ret;
	try {
	    work = ((java.io.DataInputStream)_body).readFloat();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

    public final double readDouble() 
    	throws Exception    		 
    {
	checkSecureInvocation();
	double work;
	double ret;
	try {
	    work = ((java.io.DataInputStream)_body).readDouble();
	}catch( java.io.EOFException eof ){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = work;
	return ret;
    }

// deprecated but keep
    public final _String_if readLine() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.DataInputStream)_body).readLine();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }


    public final _String_if readUTF() 
    	throws Exception    		  
    {
	checkSecureInvocation();
	java.lang.String work=null;
	_String_cl ret;
	try {
	    work = ((java.io.DataInputStream)_body).readUTF();
	
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = new _String_cl(work);
	return ret;
    }

    public final _String_if readUTF(_DataInput_if arg_a) 
    	throws Exception    		   
    {
	checkSecureInvocation();
	try {
	    return _static_readUTF(arg_a);
	} catch (java.io.UTFDataFormatException utf ){
		_UTFDataFormatException_if oz_utf = 
			(_UTFDataFormatException_cl)( new _UTFDataFormatException_cl()._new_init(utf.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_utf);
	}catch (java.io.EOFException eof){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
    }

    static protected final _String_if _static_readUTF(_DataInput_if arg_a) 
    	throws java.io.IOException	        	
    {
	java.lang.String work;
	_String_cl ret;
	try {
	    work = java.io.DataInputStream.readUTF((java.io.DataInput)(arg_a._java()));
	} catch (java.io.IOException ex_a) {
	   throw ex_a;
	}
	ret = new _String_cl(work);
	return ret;
    }

/* ANOTHER CODE
    static protected final _String_if _static_readUTF2(_DataInput_if arg_a) 
    	throws Exception    	      
    {
	java.lang.String work;
	java.io.DataInput javaarg;
	_String_cl ret;

	if (arg_a instanceof java.io.DataInputStream) {
	    javaarg = (java.io.DataInput)(((_DataInputStream_cl)arg_a)._body);
	} else if (arg_a instanceof java.io.RandomAccessFile) {
	    javaarg = (java.io.DataInput)(((_RandomAccessFile_cl)arg_a)._body);
	} else if (arg_a instanceof java.io.ObjectInputStream) {
	    javaarg = (java.io.DataInput)(((_ObjectInputStream_cl)arg_a)._body);
	} else {
		return null;	
	}
	try {
	    work = java.io.DataInputStream.readUTF(javaarg);
	} catch (java.io.UTFDataFormatException utf ){
		_UTFDataFormatException_if oz_utf = 
			(_UTFDataFormatException_cl)( new _UTFDataFormatException_cl()._new_init(utf.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_utf);
	}catch (java.io.EOFException eof){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = new _String_cl(work);
	return ret;
    }
*/
/* ANOTHER CODE
    static protected final _String_if _static_readUTF3(_DataInput_if arg_a) 
    	throws Exception
    {
	java.lang.String work;
	java.io.DataInput javaarg;
	_String_cl ret;
	String	classname;
	classname = arg_a.getClass().getName();

	if (classname == "java.io.DataInputStream") {
	    javaarg = (java.io.DataInput)(((_DataInputStream_cl)arg_a)._body);
	} else if (classname == "java.io.RandomAccessFile") {
	    javaarg = (java.io.DataInput)(((_RandomAccessFile_cl)arg_a)._body);
	} else if (classname == "java.io.ObjectInputStream") {
	    javaarg = (java.io.DataInput)(((_ObjectInputStream_cl)arg_a)._body);
	} else {
		return null;	
	}
	try {
	    work = java.io.DataInputStream.readUTF(javaarg);
	}catch (java.io.UTFDataFormatException utf ){
		_UTFDataFormatException_if oz_utf = 
			(_UTFDataFormatException_cl)( new _UTFDataFormatException_cl()._new_init(utf.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_utf);
	}catch (java.io.EOFException eof){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = new _String_cl(work);
	return ret;
    }
*/
/* ANOTHER CODE
    static protected final _String_if _static_readUTF4(_DataInput_if arg_a) 
    	throws Exception    		   
    {
	java.lang.String work;
	java.io.DataInput javaarg;
        boolean                 isbody = false;
	_String_cl ret;
	java.lang.Class cl;
	java.lang.reflect.Field fi = null;
	cl = arg_a.getClass();
        do {
            try {
            	fi = cl.getDeclaredField("_body");
				isbody = true;
				break;
            } catch (java.lang.NoSuchFieldException e) { //Error
		; // go super class
            	} catch (java.io.IOException ex_a) {
				_IOException_if oz_ex = 
					(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
				throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
        } while((cl = cl.getSuperclass()) != null);
	if (isbody == false) {
		return null;
	}
	try {
	    javaarg = (java.io.DataInput)fi.get(arg_a);
	} catch (java.lang.IllegalArgumentException e) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(e.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	
	try {
	    work = java.io.DataInputStream.readUTF(javaarg);
	} catch (java.io.UTFDataFormatException utf ){
		_UTFDataFormatException_if oz_utf = 
			(_UTFDataFormatException_cl)( new _UTFDataFormatException_cl()._new_init(utf.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_utf);
	}catch (java.io.EOFException eof){
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_ex = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ex);
	}
	ret = new _String_cl(work);
	return ret;
    }
*/

    public _DataInputStream_cl()
    {
    }

    _DataInputStream_cl(java.io.DataInputStream arg_a)
    {
	_body = arg_a;
    }

}
