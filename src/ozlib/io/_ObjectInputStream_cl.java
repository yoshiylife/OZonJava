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
 * $Id: _ObjectInputStream_cl.java,v 1.2 1997/10/01 07:18:50 hgoto Exp $
*/
package JP.go.ipa.oz.lib.standard;

public class _ObjectInputStream_cl
    extends _InputStream_cl
    implements _ObjectInputStream_if
{
	public final java.lang.Object _java() { return _body; }
	
    public Object _new_breed(_InputStream_if arg_a) throws Exception
    {
	_InputStream_cl var_a = (_InputStream_cl)arg_a;
	try {
	    _body = new java.io.ObjectInputStream((java.io.InputStream)(var_a._body));
	} catch (java.io.StreamCorruptedException ex_a) {
		_StreamCorruptedException_if oz_sce = 
			(_StreamCorruptedException_cl)( new _StreamCorruptedException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_sce);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public final JP.go.ipa.oz.lang._Root_if readObject() 
    	throws Exception
    {
	checkSecureInvocation();
	java.lang.Object work;
	JP.go.ipa.oz.lang._Root_cl ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readObject();
	} catch (java.io.OptionalDataException ode) {
		_OptionalDataException_if oz_ode = 
			(_OptionalDataException_cl)( new _OptionalDataException_cl()._new_init(ode.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_ode);
	} catch (java.lang.ClassNotFoundException cnfe) {
		_ClassNotFoundException_if oz_cnfe = 
			(_ClassNotFoundException_cl)( new _ClassNotFoundException_cl()._new_init(cnfe.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_cnfe);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return (JP.go.ipa.oz.lang._Root_if)work;
    }

    public final void defaultReadObject() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.ObjectInputStream)_body).defaultReadObject();
	} catch (java.io.NotActiveException nae) {
		_NotActiveException_if oz_nae = 
			(_NotActiveException_cl)( new _NotActiveException_cl()._new_init(nae.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_nae);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	} catch (java.lang.ClassNotFoundException cnfe) {
		_ClassNotFoundException_if oz_cnfe = 
			(_ClassNotFoundException_cl)( new _ClassNotFoundException_cl()._new_init(cnfe.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_cnfe);
	}
    }

    public int read() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).read();
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
	    work = ((java.io.ObjectInputStream)_body).read((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int available() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).available();
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
	    ((java.io.ObjectInputStream)_body).close();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public boolean readBoolean() throws Exception
    {
	checkSecureInvocation();
	boolean work;
	boolean ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readBoolean();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public byte readByte() throws Exception
    {
	checkSecureInvocation();
	byte work;
	byte ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readByte();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int readUnsignedByte() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readUnsignedByte();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public short readShort() throws Exception
    {
	checkSecureInvocation();
	short work;
	short ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readShort();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int readUnsignedShort() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readUnsignedShort();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public char readChar() throws Exception
    {
	checkSecureInvocation();
	char work;
	char ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readChar();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public int readInt() throws Exception
    {
	checkSecureInvocation();
	int work;
	int ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readInt();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public long readLong() throws Exception
    {
	checkSecureInvocation();
	long work;
	long ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readLong();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public float readFloat() throws Exception
    {
	checkSecureInvocation();
	float work;
	float ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readFloat();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public double readDouble() throws Exception
    {
	checkSecureInvocation();
	double work;
	double ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readDouble();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public void readFully(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	try {
	    ((java.io.ObjectInputStream)_body).readFully((byte[])(var_a._body));
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void readFully(_ByteArray_if arg_a, int arg_b, int arg_c) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	int var_b = arg_b;
	int var_c = arg_c;
	try {
	    ((java.io.ObjectInputStream)_body).readFully((byte[])(var_a._body), var_b, var_c);
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
	    work = ((java.io.ObjectInputStream)_body).skipBytes(var_a);
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = work;
	return ret;
    }

    public _String_if readLine() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readLine();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	if (work == null) return null;
	ret = new _String_cl(work);
	return ret;
    }

    public _String_if readUTF() throws Exception
    {
	checkSecureInvocation();
	java.lang.String work;
	_String_cl ret;
	try {
	    work = ((java.io.ObjectInputStream)_body).readUTF();
	} catch (java.io.IOException ex_a) {
		_IOException_if oz_io = 
			(_IOException_cl)( new _IOException_cl()._new_init(ex_a.getMessage()));
		throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	ret = new _String_cl(work);
	return ret;
    }

    public _ObjectInputStream_cl()
    {
    }

    _ObjectInputStream_cl(java.io.ObjectInputStream arg_a)
    {
	_body = arg_a;
    }

}
