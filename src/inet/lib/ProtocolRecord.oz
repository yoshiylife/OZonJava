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
 * $Id: ProtocolRecord.oz,v 0.1 1997-11-26 11:38:55+09 otokawa Exp $
 */

/** 
  * A class handling record data for communication protcol implementation
  */

class ProtocolRecord : *Dictionary {
  /**
    * format string for encoding
    */
  SList encoding_format;

  /**
    * format string for decoding
    */
  SList decoding_format;

  /**
    * line terminator string
    */
  String line_terminator;

  /**
    * create new one
    *
    * @param encode_format format string for encoding
    * @param decode_format format string for decoding
    * @param line terminator string
    */
  new create (String encode_format, String decode_format, String lt) {
    /* invoke super class constructor */
    StringComparator sc=>create ();
    super=>create (sc);

    encoding_format=>create (sc);
    parse_format (encode_format, encoding_format);

    decoding_format=>create (sc);
    parse_format (decode_format, decoding_format);

    line_terminator = lt;
  }

  /**
    * parsing format string and convert it to list of string
    *
    * @param orig format string
    * @param result format string list
    */
  void parse_format (String orig, SList result) {
//    System sys=>create ();
//    sys->println (orig);

    ByteArray bytes = orig->getBytes ();
    CharArray buf=>create (bytes->length ());
    int j;

    for (int i = 0, len = orig->length (); i < len; i++) {
      byte b = bytes->at (i);

      if (isAlphaOrNumeric (b)) {
	buf->setAt (j++, b);
      } else {
	String str=>breed (buf, 0, j);
//	sys->println (str);
	result->pushBack (str);
	j = 0;

	buf->setAt (j++, b);
	if (b != 0x5c) {
	  String str=>breed (buf, 0, j);
//	  sys->println (str);
	  result->pushBack (str);
	  j = 0;
	} 
      }
    }

    if (j != 0) {
      String str=>breed (buf, 0, j);
//      sys->println (str);
      result->pushBack (str);
    }
  }

  /**
    * encode record data and output string data
    *
    * @return encoded string data
    */
  public String encode () {
    StringBuffer buf=>breed ();
    StringBuffer second_buf=>breed ();
//    System sys=>create ();

    String prev_delimiter;
    for (int i = 0, size = encoding_format->size (); i < size; i++) {
      String key;
      key =| encoding_format->first ();

//      sys->println (key);

      encoding_format->popFront ();
      encoding_format->pushBack (key);
    
      if (isAlphaOrNumeric(key)) {
	String value = get (key);
	if (value != null) {
	  buf->append (value);
//	  sys->println (value);
	} else {
	  if (prev_delimiter != null) {
	    int len = buf->length () - prev_delimiter->length ();
	    buf->setLength (len);
	  }
	}
      } else {
	prev_delimiter = key;
	buf->append (key);
      }
    }

    buf->append (line_terminator);

//    sys->println (buf->asString());

    return buf->asString ();
  }

  /**
    * decode string data and store as record data
    *
    * @param repoonse_data decording stirng data
    */
  public void decode (String response_data) {
    System sys=>create ();
//    sys->println (response_data);

    int from = 0;
    StringReader sr=>breed (response_data);
    BufferedReader lr=>breed (sr);
    StringBuffer buf=>breed ();
    String status = lr->readLine ();
    lr->close ();
    sr->close ();

    for (int i = 0, size = decoding_format->size (); i < size; i++) {
      String key;
      key =| decoding_format->first ();

      decoding_format->popFront ();
      decoding_format->pushBack (key);

      if (i + 1 == size) {
	put (key, response_data->asString ());
	break;
      }

      if (isAlphaOrNumeric (key)) {
	String value = getWord (status, from);
	from += value->length ();

//	sys->println (key);
//	sys->println (value);

	put (key, value);
      } else {
	from += key->length ();
      }
    }
  }

  /**
    * parse word
    *
    * @return parsed string
    */
  String getWord (String str, int from) {
    ByteArray bytes = str->getBytes ();
    CharArray buf=>create (bytes->length ());
    int j = 0;

    for (int i = from, len = str->length (); i < len; i++) {
      byte b = bytes->at (i);

      if (isAlphaOrNumeric (b) || j == 0) {
	buf->setAt (j++, b);
      } else {
	break;
      }
    }

    String str=>breed (buf, 0, j);
    return str;
  }

  /**
    * set command 
    *
    * @param command command string 
    */
  public void setCommand (String command) {
    for (int i = 0, size = encoding_format->size (); i < size; i++) {
      String key;
      key =| encoding_format->first ();

      encoding_format->popFront ();
      encoding_format->pushBack (key);
    
      if (isAlphaOrNumeric(key)) 
	if (containsKey (key)) remove (key);
    }

    set ("COMMAND", command);
  }

  /**
    * set attribute
    *
    * @param label attribute label
    * @param value attribute value 
    */
  public void set (String label, String value) {
    if (value == null)
      return;

//    if (containsKey (label)) remove (label);

    put (label, value);
  }

  /**
    * get status code
    *
    * @return status code
    */
  public String getStatus () {
    return get ("STATUS");
  }

  /**
    * get an attribute value
    *
    * @param label attribute label string
    * @return value string
    */
  public String get (String label) {
    String buf;
    buf =| super->get (label);

    return buf;
  }

  /**
    * check if alphabetci characters
    *
    * @param str checking str
    * @return if so true, otherwise false
    */
  boolean isAlphaOrNumeric (String str) {
    ByteArray bytes = str->getBytes ();
    if (bytes->length () == 0)
      return false;

    return isAlphaOrNumeric (bytes->at (0));
  }

  /**
    * check if alphabetci character
    *
    * @param b checking byte
    * @return if so true, otherwise false
    */
  boolean isAlphaOrNumeric (byte b) {
    if (b == 0x5f || 
	(b >= 0x41 && b <= 0x5a) || 
	(b >= 0x61 && b <= 0x7a) ||
	(b >= 0x30 && b <= 0x39)) 
      return true;

    return false;
  }

  /**
    * access for line terminator string
    *
    * @return line terminator string
    */
  public String getLineTerminator () { return line_terminator; }
}

/* EOF */
