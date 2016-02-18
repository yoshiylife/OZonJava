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
 * $Id: _Math_if.java,v 1.1 1997/07/29 10:47:38 hgoto Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _Math_if
extends JP.go.ipa.oz.lang._Root_if
{
    public double sin(double arg_a) throws Exception;
    public double cos(double arg_a) throws Exception;
    public double tan(double arg_a) throws Exception;
    public double asin(double arg_a) throws Exception;
    public double acos(double arg_a) throws Exception;
    public double atan(double arg_a) throws Exception;
    public double exp(double arg_a) throws Exception;
    public double log(double arg_a) throws Exception;
    public double sqrt(double arg_a) throws Exception;
    public double IEEEremainder(double arg_a, double arg_b) throws Exception;
    public double ceil(double arg_a) throws Exception;
    public double floor(double arg_a) throws Exception;
    public double rint(double arg_a) throws Exception;
    public double atan2(double arg_a, double arg_b) throws Exception;
    public double pow(double arg_a, double arg_b) throws Exception;
    public int round(float arg_a) throws Exception;
    public long round(double arg_a) throws Exception;
    public double random() throws Exception;
    public int abs(int arg_a) throws Exception;
    public long abs(long arg_a) throws Exception;
    public float abs(float arg_a) throws Exception;
    public double abs(double arg_a) throws Exception;
    public int max(int arg_a, int arg_b) throws Exception;
    public long max(long arg_a, long arg_b) throws Exception;
    public float max(float arg_a, float arg_b) throws Exception;
    public double max(double arg_a, double arg_b) throws Exception;
    public int min(int arg_a, int arg_b) throws Exception;
    public long min(long arg_a, long arg_b) throws Exception;
    public float min(float arg_a, float arg_b) throws Exception;
    public double min(double arg_a, double arg_b) throws Exception;
    public double getE() throws Exception;
    public double getPI() throws Exception;
}
