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
 * $Id: _ObjectOutputStream_cl.java,v 1.1 1997/07/25 05:00:46 hgoto Exp $
 */
package JP.go.ipa.oz.lib.standard;

public class _ObjectOutputStream_cl
    extends _OutputStream_cl
    implements _ObjectOutputStream_if
{
    public Object _new_breed(_OutputStream_if arg_a) throws Exception
    {
	_OutputStream_cl var_a = (_OutputStream_cl)arg_a;
	try {
	    _body = new java.io.ObjectOutputStream((java.io.OutputStream)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
	return this;
    }

    public final void writeObject(JP.go.ipa.oz.lang._Root_if arg_a) throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.ObjectOutputStream)_body).writeObject((java.lang.Object)arg_a);
	}catch (java.io.InvalidClassException ex_a) {
	    _InvalidClassException_if oz_ice = 
	    	(_InvalidClassException_cl)(new _InvalidClassException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_ice);
	}catch (java.io.NotSerializableException ex_a) {
	    _NotSerializableException_if oz_nse = 
	    	(_NotSerializableException_cl)(new _NotSerializableException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_nse);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public final void defaultWriteObject() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.ObjectOutputStream)_body).defaultWriteObject();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void reset() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.ObjectOutputStream)_body).reset();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).write(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void write(_ByteArray_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_ByteArray_cl var_a = (_ByteArray_cl)arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).write((byte[])(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
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
	    ((java.io.ObjectOutputStream)_body).write((byte[])(var_a._body), var_b, var_c);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void flush() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.ObjectOutputStream)_body).flush();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void close() throws Exception
    {
	checkSecureInvocation();
	try {
	    ((java.io.ObjectOutputStream)_body).close();
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeBoolean(boolean arg_a) throws Exception
    {
	checkSecureInvocation();
	boolean var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeBoolean(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeByte(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeByte(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeShort(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeShort(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeChar(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeChar(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeInt(int arg_a) throws Exception
    {
	checkSecureInvocation();
	int var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeInt(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeLong(long arg_a) throws Exception
    {
	checkSecureInvocation();
	long var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeLong(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeFloat(float arg_a) throws Exception
    {
	checkSecureInvocation();
	float var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeFloat(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeDouble(double arg_a) throws Exception
    {
	checkSecureInvocation();
	double var_a = arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeDouble(var_a);
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeBytes(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeBytes((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeChars(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeChars((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public void writeUTF(_String_if arg_a) throws Exception
    {
	checkSecureInvocation();
	_String_cl var_a = (_String_cl)arg_a;
	try {
	    ((java.io.ObjectOutputStream)_body).writeUTF((java.lang.String)(var_a._body));
	} catch (java.io.IOException ex_a) {
	    _IOException_if oz_io = (_IOException_cl)(new _IOException_cl()._new_init(ex_a.getMessage()));
	    throw new JP.go.ipa.oz.lang.OzException(oz_io);
	}
    }

    public _ObjectOutputStream_cl()
    {
    }

    _ObjectOutputStream_cl(java.io.ObjectOutputStream arg_a)
    {
	_body = arg_a;
    }

}
