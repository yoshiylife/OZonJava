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
 * $Id: _StreamTokenizer_if.java,v 1.4 1997/06/16 05:30:48 xsun Exp $
 */

package JP.go.ipa.oz.lib.standard;

public interface _StreamTokenizer_if
extends JP.go.ipa.oz.lang._Root_if
{
// deprecated
 
    public void resetSyntax() throws Exception;
    public void wordChars(int arg_a, int arg_b) throws Exception;
    public void whitespaceChars(int arg_a, int arg_b) throws Exception;
    public void ordinaryChars(int arg_a, int arg_b) throws Exception;
    public void ordinaryChar(int arg_a) throws Exception;
    public void commentChar(int arg_a) throws Exception;
    public void quoteChar(int arg_a) throws Exception;
    public void parseNumbers() throws Exception;
    public void eolIsSignificant(boolean arg_a) throws Exception;
    public void slashStarComments(boolean arg_a) throws Exception;
    public void slashSlashComments(boolean arg_a) throws Exception;
    public void lowerCaseMode(boolean arg_a) throws Exception;
    public int nextToken() throws Exception;
    public void pushBack() throws Exception;
    public int lineno() throws Exception;
    public _String_if asString() throws Exception;
    public int getttype() throws Exception;
    public boolean ttypeisEOF() throws Exception;
    public boolean ttypeisEOL() throws Exception;
    public boolean ttypeisNUMBER() throws Exception;
    public boolean ttypeisWORD() throws Exception;
    public _String_if getsval() throws Exception;
    public double getnval() throws Exception;
}
