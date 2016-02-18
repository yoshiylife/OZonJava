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
 * $Id: _Math_cl.java,v 1.1 1997/07/29 10:47:38 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public final class _Math_cl
    extends JP.go.ipa.oz.lang._Root_cl
    implements _Math_if
{
    public Object _new_create() throws Exception
    {
	return this;
    }

    public double sin(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_sin(arg_a);
    }

    static protected double _static_sin(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.sin(var_a);
	ret = work;
	return ret;
    }

    public double cos(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_cos(arg_a);
    }

    static protected double _static_cos(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.cos(var_a);
	ret = work;
	return ret;
    }

    public double tan(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_tan(arg_a);
    }

    static protected double _static_tan(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.tan(var_a);
	ret = work;
	return ret;
    }

    public double asin(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_asin(arg_a);
    }

    static protected double _static_asin(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.asin(var_a);
	ret = work;
	return ret;
    }

    public double acos(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_acos(arg_a);
    }

    static protected double _static_acos(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.acos(var_a);
	ret = work;
	return ret;
    }

    public double atan(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_atan(arg_a);
    }

    static protected double _static_atan(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.atan(var_a);
	ret = work;
	return ret;
    }

    public double exp(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_exp(arg_a);
    }

    static protected double _static_exp(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.exp(var_a);
	ret = work;
	return ret;
    }

    public double log(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_log(arg_a);
    }

    static protected double _static_log(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.log(var_a);
	ret = work;
	return ret;
    }

    public double sqrt(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_sqrt(arg_a);
    }

    static protected double _static_sqrt(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.sqrt(var_a);
	ret = work;
	return ret;
    }

    public double IEEEremainder(double arg_a, double arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_IEEEremainder(arg_a, arg_b);
    }

    static protected double _static_IEEEremainder(double arg_a, double arg_b) throws Exception
    {
	double var_a = arg_a;
	double var_b = arg_b;
	double work;
	double ret;
	work = java.lang.Math.IEEEremainder(var_a, var_b);
	ret = work;
	return ret;
    }

    public double ceil(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_ceil(arg_a);
    }

    static protected double _static_ceil(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.ceil(var_a);
	ret = work;
	return ret;
    }

    public double floor(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_floor(arg_a);
    }

    static protected double _static_floor(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.floor(var_a);
	ret = work;
	return ret;
    }

    public double rint(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_rint(arg_a);
    }

    static protected double _static_rint(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.rint(var_a);
	ret = work;
	return ret;
    }

    public double atan2(double arg_a, double arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_atan2(arg_a, arg_b);
    }

    static protected double _static_atan2(double arg_a, double arg_b) throws Exception
    {
	double var_a = arg_a;
	double var_b = arg_b;
	double work;
	double ret;
	work = java.lang.Math.atan2(var_a, var_b);
	ret = work;
	return ret;
    }

    public double pow(double arg_a, double arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_pow(arg_a, arg_b);
    }

    static protected double _static_pow(double arg_a, double arg_b) throws Exception
    {
	double var_a = arg_a;
	double var_b = arg_b;
	double work;
	double ret;
	work = java.lang.Math.pow(var_a, var_b);
	ret = work;
	return ret;
    }

    public int round(float arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_round(arg_a);
    }

    static protected int _static_round(float arg_a) throws Exception
    {
	float var_a = arg_a;
	int work;
	int ret;
	work = java.lang.Math.round(var_a);
	ret = work;
	return ret;
    }

    public long round(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_round(arg_a);
    }

    static protected long _static_round(double arg_a) throws Exception
    {
	double var_a = arg_a;
	long work;
	long ret;
	work = java.lang.Math.round(var_a);
	ret = work;
	return ret;
    }

    public double random() throws Exception
    {
	checkSecureInvocation();
	return _static_random();
    }

    static protected double _static_random() throws Exception
    {
	double work;
	double ret;
	work = java.lang.Math.random();
	ret = work;
	return ret;
    }

    public int abs(int arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_abs(arg_a);
    }

    static protected int _static_abs(int arg_a) throws Exception
    {
	int var_a = arg_a;
	int work;
	int ret;
	work = java.lang.Math.abs(var_a);
	ret = work;
	return ret;
    }

    public long abs(long arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_abs(arg_a);
    }

    static protected long _static_abs(long arg_a) throws Exception
    {
	long var_a = arg_a;
	long work;
	long ret;
	work = java.lang.Math.abs(var_a);
	ret = work;
	return ret;
    }

    public float abs(float arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_abs(arg_a);
    }

    static protected float _static_abs(float arg_a) throws Exception
    {
	float var_a = arg_a;
	float work;
	float ret;
	work = java.lang.Math.abs(var_a);
	ret = work;
	return ret;
    }

    public double abs(double arg_a) throws Exception
    {
	checkSecureInvocation();
	return _static_abs(arg_a);
    }

    static protected double _static_abs(double arg_a) throws Exception
    {
	double var_a = arg_a;
	double work;
	double ret;
	work = java.lang.Math.abs(var_a);
	ret = work;
	return ret;
    }

    public int max(int arg_a, int arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_max(arg_a, arg_b);
    }

    static protected int _static_max(int arg_a, int arg_b) throws Exception
    {
	int var_a = arg_a;
	int var_b = arg_b;
	int work;
	int ret;
	work = java.lang.Math.max(var_a, var_b);
	ret = work;
	return ret;
    }

    public long max(long arg_a, long arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_max(arg_a, arg_b);
    }

    static protected long _static_max(long arg_a, long arg_b) throws Exception
    {
	long var_a = arg_a;
	long var_b = arg_b;
	long work;
	long ret;
	work = java.lang.Math.max(var_a, var_b);
	ret = work;
	return ret;
    }

    public float max(float arg_a, float arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_max(arg_a, arg_b);
    }

    static protected float _static_max(float arg_a, float arg_b) throws Exception
    {
	float var_a = arg_a;
	float var_b = arg_b;
	float work;
	float ret;
	work = java.lang.Math.max(var_a, var_b);
	ret = work;
	return ret;
    }

    public double max(double arg_a, double arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_max(arg_a, arg_b);
    }

    static protected double _static_max(double arg_a, double arg_b) throws Exception
    {
	double var_a = arg_a;
	double var_b = arg_b;
	double work;
	double ret;
	work = java.lang.Math.max(var_a, var_b);
	ret = work;
	return ret;
    }

    public int min(int arg_a, int arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_min(arg_a, arg_b);
    }

    static protected int _static_min(int arg_a, int arg_b) throws Exception
    {
	int var_a = arg_a;
	int var_b = arg_b;
	int work;
	int ret;
	work = java.lang.Math.min(var_a, var_b);
	ret = work;
	return ret;
    }

    public long min(long arg_a, long arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_min(arg_a, arg_b);
    }

    static protected long _static_min(long arg_a, long arg_b) throws Exception
    {
	long var_a = arg_a;
	long var_b = arg_b;
	long work;
	long ret;
	work = java.lang.Math.min(var_a, var_b);
	ret = work;
	return ret;
    }

    public float min(float arg_a, float arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_min(arg_a, arg_b);
    }

    static protected float _static_min(float arg_a, float arg_b) throws Exception
    {
	float var_a = arg_a;
	float var_b = arg_b;
	float work;
	float ret;
	work = java.lang.Math.min(var_a, var_b);
	ret = work;
	return ret;
    }

    public double min(double arg_a, double arg_b) throws Exception
    {
	checkSecureInvocation();
	return _static_min(arg_a, arg_b);
    }

    static protected double _static_min(double arg_a, double arg_b) throws Exception
    {
	double var_a = arg_a;
	double var_b = arg_b;
	double work;
	double ret;
	work = java.lang.Math.min(var_a, var_b);
	ret = work;
	return ret;
    }

    public _Math_cl()
    {
    }

    public double getE() throws Exception
    {
	return _static_getE();
    }

    static protected double _static_getE() throws Exception
    {
	return java.lang.Math.E;
    }

    public double getPI() throws Exception
    {
	return _static_getPI();
    }

    static protected double _static_getPI() throws Exception
    {
	return java.lang.Math.PI;
    }

}
