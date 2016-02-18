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
 * $Id: _RandomAccessFile_cl.java,v 1.5 1997/06/17 10:38:13 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public class _RandomAccessFile_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _RandomAccessFile_if
{
    public final java.lang.Object _java() { return _body; }
    java.io.RandomAccessFile _body;

    public Object _new_breed(_String_if arg_a, _String_if arg_b) throws Exception
    {
	_String_cl var_a = (_String_cl)arg_a;
	_String_cl var_b = (_String_cl)arg_b;
	try {
	    _body = new java.io.RandomAccessFile((java.lang.String)(var_a._body), (java.lang.String)(var_b._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public Object _new_breed(_File_if arg_a, _String_if arg_b) throws Exception
    {
	_File_cl var_a = (_File_cl)arg_a;
	_String_cl var_b = (_String_cl)arg_b;
	try {
	    _body = new java.io.RandomAccessFile((java.io.File)(var_a._body), (java.lang.String)(var_b._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public final _FileDescriptor_if getFD() throws Exception
    {
	checkSecureInvocation();
	java.io.FileDescriptor work;
	_FileDescriptor_cl ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).getFD();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	if (work == null) return null;
	ret = new _FileDescriptor_cl(work);
	return ret;
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).read();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int read(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).read((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int read(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).read((byte[])(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final void readFully(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).readFully((byte[])(var_a._body));
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	
	}
    }

    public final void readFully(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.RandomAccessFile)_body).readFully((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public int skipBytes(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).skipBytes(var_a);
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).write(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).write((byte[])(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.RandomAccessFile)_body).write((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public long getFilePointer() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).getFilePointer();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void seek(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).seek(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public long length() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).length();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.RandomAccessFile)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final boolean readBoolean() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readBoolean();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final byte readByte() throws Exception
    {
	checkSecureInvocation();
	byte work;
	byte ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readByte();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final int readUnsignedByte() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readUnsignedByte();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final short readShort() throws Exception
    {
	checkSecureInvocation();
	short work;
	short ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readShort();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final int readUnsignedShort() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readUnsignedShort();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final char readChar() throws Exception
    {
	checkSecureInvocation();
	char work;
	char ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readChar();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final int readInt() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readInt();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final long readLong() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readLong();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final float readFloat() throws Exception
    {
	checkSecureInvocation();
	float work;
	float ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readFloat();
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final double readDouble() throws Exception
    {
	checkSecureInvocation();
	double work;
	double ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readDouble();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public final _String_if readLine() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readLine();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public final _String_if readUTF() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.RandomAccessFile)_body).readUTF();
	} catch (java.io.UTFDataFormatException utf) {
		_UTFDataFormatException_if oz_utf = 
			(_UTFDataFormatException_cl)( new _UTFDataFormatException_cl()._new_init(utf.getMessage()));
		throw new  JP.go.ipa.oz.lang.OzException(oz_utf);
	} catch (java.io.EOFException eof) {
		_EOFException_if oz_eof = 
			(_EOFException_cl)( new _EOFException_cl()._new_init(eof.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_eof);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public final void writeBoolean(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeBoolean(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeByte(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeByte(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeShort(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeShort(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeChar(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeChar(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeInt(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeInt(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeLong(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeLong(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeFloat(float arg_a) throws Exception
    {
	checkSecureInvocation();
	float var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeFloat(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeDouble(double arg_a) throws Exception
    {
	checkSecureInvocation();
	double var_a = arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeDouble(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeBytes(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeBytes((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeChars(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeChars((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void writeUTF(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.RandomAccessFile)_body).writeUTF((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _RandomAccessFile_cl()
    {
    }

    _RandomAccessFile_cl(java.io.RandomAccessFile arg_a)
    {
	_body = arg_a;
    }

}
