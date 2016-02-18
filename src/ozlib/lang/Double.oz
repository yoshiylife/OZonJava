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

// OZ Class Library (Lang)
/*
 * $Id: Double.oz,v 1.2 1997/09/08 11:07:57 hgoto Exp $
 */

class Double {
    double	value;
    
    new breed(double arg) {
	value = arg;
    }

    new breed(String arg) {
	value = arg->parseDouble();
    }

    public double doubleValue() {
	return value;
    }

    public String asString() {
	String work=>breed();
	return work->valueOf(value);
    }
}

