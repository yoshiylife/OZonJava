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

// DEV: Class Browser


/**
 * CIRecordTokenizer
 * 
 * @version  "$Id$"
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIRecordTokenizer
{

  String  record;
  String  delimiters;
  int  current;
  int  length;

  final char  LIST_BEGIN;
  final char  LIST_END;


  //------------------------------------------------------------------
  new newCIRecordTokenizer(String rec)
  {
    this->record = rec;
    this->delimiters = "\t\n\r ,";
    this->current = 0;
    this->length = rec->length();
    LIST_BEGIN = '(';
    LIST_END = ')';
  }


  //================================================== public methods

  //------------------------------------------------------------------
  public boolean hasMoreTokens()
  {
    skipDelimiters();
    return (current < length);
  }


  //------------------------------------------------------------------
  public String nextToken()
  {
    int  start;
    
    skipDelimiters();

    if (length <= current) {
      CIException  ex;
      ex => newCIException("no more tokens");
      throw ex;
    }

    start = current;
    while ((current < length) &&
	   (delimiters->indexOf(record->charAt(current)) == -1)) {
      current++;
    }

    return record->substring(start, current);
  }


  //------------------------------------------------------------------
  public String nextList()
  {
    int  start;
    int  nest;  // depth of nest
    String  rv;

    skipDelimiters();

    if (record->charAt(current) == LIST_BEGIN) {
      current++;
    } else {
      CIException  ex;
      ex => newCIException("unexpected CID list begin character");
      throw ex;
    }

    /* list may be nested, e.g. (((...))), ((...) (...)),... */
    start = current;
    nest = 0;
    while ((current < length) &&
         (nest > 0 || (record->charAt(current) != LIST_END))) {
      if (record->charAt(current) == LIST_BEGIN) {
        nest++;
      }
      if (record->charAt(current) == LIST_END) {
        nest--;
      }
      current++;
    }

    /*
    while ((current < length) && (record->charAt(current) != LIST_END)) {
      current++;
    }
    */

    rv = record->substring(start, current);
    if (record->charAt(current) == LIST_END) {
      current++;
    }

    return rv;
  }


  //------------------------------------------------------------------
  public int countTokens()
  {
    int  tmpCurr = current;
    int  count = 0;

    while (tmpCurr < length) {
      // skip delimiters
      while ((tmpCurr < length) &&
	     (delimiters->indexOf(record->charAt(tmpCurr)) != -1)) {
        tmpCurr++;
      }

      if (length <= tmpCurr) {
        break;
      }

      // read the token
      while ((tmpCurr <length) &&
	     (delimiters->indexOf(record->charAt(tmpCurr)) == -1)) {
	tmpCurr++;
      }

      count++;
    }

    return count;
  }

  
  //================================================== private methods

  //------------------------------------------------------------------
  void skipDelimiters()
  {
    while ((current < length) &&
	   delimiters->indexOf(record->charAt(current)) != -1) {
      current++;
    }
  }

  

}

// EoF

