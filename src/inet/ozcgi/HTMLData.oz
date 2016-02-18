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
 * $Id: HTMLData.oz,v 0.11 1998-01-30 11:04:08+09 otokawa Exp $
 */

/** 
  * A class representaion HTML data for input/output
  */

class HTMLData {
  /**
    * buffer for output
    */
  StringBuffer output;

  /**
    * buffer for binary data
    */
  ByteArray binary_data;

  /**
    * storage for input data; dictionary of <String, Srting>
    */
  Dictionary input_data;

  /**
    * reuest ID 
    */
  String request_id;

  /**
    * form ID  (for short cut)
    */
  String form_id;

  /**
    * stack of tags 
    */
  SList starting_tags;

  /**
    * request number 
    */
  int request_number;

  /**
    * create new one 
    *
    * @param is input stream to read receiving data
    * @param req_no request number;
    */
  new create (InputStream is, int req_no) {
    request_number = req_no;
    parse_data (is);
    if (request_number < 0) return;
    request_id = form_id->concat (form_id->valueOf (req_no));
  }

  /**
    * create new one 
    */
  new create () {}

  /**
    * get one value of input data 
    *
    * @param label label of input data 
    */
  public Root getValue (String label) {
    if (isGreen () && input_data->isRed ()) 
      turnGreen (input_data);

    return input_data->get (label);
  }

  /**
    * get all labels 
    *
    * @return iterator of labels
    */
  public Iterator getLabels () {
    return input_data->keys ()->iterator ();
  }

  /**
    * begin creation of output data
    */
  public void startOutput (String content) {
    if (starting_tags == null)
      starting_tags=>create ();

    output=>breed ();

    if (content != null) {
      output->append ("Content-Type: ");
      output->append (content);
      output->append ("\n\n");
    }
  }

  /**
    * begin creation of output data (for send file)
    */
  public void startOutput (String content, String name) {
    if (starting_tags == null)
      starting_tags=>create ();

    output=>breed ();

    output->append ("Content-Type: ");
    output->append (content);
    output->append ("\nContent-Disposition: filename=");
    output->append (name);
    output->append ("\n\n");
  }

  /**
    * create start tag 
    *
    * @param tag tag string
    */
  public void beginTag (String tag) {
    output->append ("\n<");
    output->append (tag);
    output->append ('>');

    starting_tags->pushFront (tag);
  }
   
  /**
    * add a string  
    *
    * @param str string
    */
  public void addOutput (String str) {
    String tag;
    tag =| starting_tags->first ();

    if (tag == null || !tag->equalsIgnoreCase ("<pre>")) {
      output->append (escape (str));
    } else {
      output->append (str);
    }
  }

  /**
    * add a binary data
    *
    * @param in input starem of binary data
    * @param size data size
    */
  public void addOutput (InputStream in, int size) {
    binary_data=>create (size);
    in->read (binary_data, 0, size);
  }

  /**
    * add a tag
    *
    * @param tag tag string
    */
  public void addTag (String tag) {
    output->append ('<');
    output->append (tag);
    output->append ('>');
  }

  /**
    * converting escape representation
    *
    * @param str output data
    * @return converted data
    */
  String escape (String str) {
    /*
     * if no in <pre> tag, converting:
     *   & ---> &amp;
     *   < ---> &lt;
     *   > ---> &gt;
     *   " ---> &quot;
     */
    StringBuffer buf=>breed ();

    CharArray original_chars=>create (4);
    original_chars->putAt (0, '&');
    original_chars->putAt (1, '<');
    original_chars->putAt (2, '>');
    original_chars->putAt (3, '\"');

    Array converted_strs=>create (4);
    converted_strs->putAt (0, "&amp;");
    converted_strs->putAt (1, "&lt;");
    converted_strs->putAt (2, "&gt;");
    converted_strs->putAt (3, "&quot;");

    int len = original_chars->length (), from = 0;
    int str_len = str->length ();
    while (true) {
      int idx = str_len;
      int found_char;
      for (int i = 0; i < len; i++) {
	int found = str->indexOf (original_chars->at (i), from);
	if (found != -1 && found < idx) {
	  idx = found;
	  found_char = i;
	}
      }

      if (idx < str_len) {
	buf->append (str->substring (from, idx));
	buf->append (converted_strs->at (found_char));
	from = idx + 1;
      } else {
	break;
      }
    }

    buf->append (str->substring (from));

    return buf->asString ();
  }

  /**
    * create end tag correspod to most recent start tag
    */
  public void endTag () {
    String tag;

    tag =| starting_tags->first ();

    if (tag == null) return;

    starting_tags->popFront ();

    output->append ("</");
    output->append (tag);
    output->append ('>');
  }

  /**
    * end creation of output data
    */
  public void endOutput () {
    for (int i = 0, size = starting_tags->size (); i < size; i++) {
      endTag ();
    }
  }

  /**
    * return output data contens 
    */
  public String output () {
    return output->asString ();
  }

  /**
    * return input stream of binay data
    */
  public ByteArray binaryData () {
    return binary_data;
  }

  /**
    * access for request ID
    */
  public String getRequestID () {
    return request_id;
  }

  /**
    * access for form ID (for short cut)
    */
  public String getFormID () {
    return form_id;
  }

  /**
    * parse input data 
    *
    * @param is input stream for input data
    */
  void parse_data (InputStream is) {
    System sys=>create ();
    sys->debugPrintln ("HTMLData: parsing");

    StringComparator scomp=>create ();
    input_data=>create (scomp);

    if (request_number >= 0) {
      ByteArray b=>create (3);
      is->mark (3);
      while (true) {
	int size = is->available ();

	if (size >= 3) break;
      }

      is->read (b, 0, 3);
      is->reset ();
      String buf=>breed (b, 0, 3);

      if (buf->startsWith ("---")) 
	parse_multipart (is);
      else
	parse_singlepart (is);
    } else {
      if (request_number == -1)
	sys->println ("HTMLData: parsing");
      parse_singlepart (is);
    }

    /* setup short cut for form ID */
    form_id =| getValue (".formId");

    if (request_number == -1)
      sys->println ("HTMLData: parsing done");
  }

  /**
    * parse input data containing multi parts 
    *
    * @param input input stream
    */
  void parse_multipart (InputStream input) {
    BufferedInputStream is=>breed (input);
    String delimiter = read_one_line (is)->trim ();

    System sys=>create ();
    sys->debugPrintln ("delimiter");
    sys->debugPrintln (delimiter);

    while (true) {
      String label = null;
      boolean file_data = false;

      String one_line = read_one_line (is)->trim ();
      sys->debugPrintln (one_line);

      int prev_semi = one_line->indexOf (';');
      while (true) {
	/* cut a item */
	int next_semi = one_line->indexOf (';', prev_semi + 1);

	String item;
	if (next_semi == -1) 
	  item = one_line->substring (prev_semi + 2);
	else
	  item = one_line->substring (prev_semi + 2, next_semi);

	sys->debugPrintln ("item");
	sys->debugPrintln (item);
	  
	int equal = item->indexOf ('=');
	String name = item->substring (0, equal);
	String value= item->substring (equal + 2, item->length () - 1);

	if (label == null)
	  label = value;
	else {
	  input_data->put (label->concat (name), decode(value));
	  file_data = true;
	}

	if (next_semi == -1) break;

	prev_semi = next_semi;
      }

      if (file_data) {
	one_line 
	  = read_file_data (is, label, delimiter)
	  ->concat (read_one_line (is))->trim ();
      } else {
	read_one_value (is, label);
	one_line = read_one_line (is)->trim ();
      }

      if (one_line->startsWith (delimiter->concat ("--")))
	break;
    }
  }

  /**
    * read one value (not file contents) 
    *
    * @param is input stream
    * @param label label string
    */
  void read_one_value (InputStream is, String label) {
    skip_header (is);

    input_data->put (label, read_one_line (is)->trim ());
  }
	
  /**
    * read file contents data
    *
    * @param is input stream
    * @param label label string
    * @param delimiter delimiter string
    */
  String read_file_data (InputStream is, String label, String delimiter) {
    String tmp_file = createPath ("file");
    File f=>breed (tmp_file);

    /* read contents and write to tempolary file */
    FileOutputStream out=>breed (f);
    skip_header (is);

    int len = delimiter->length ();
    ByteArray buf=>create (len);

    /* read file contents */
    int last_cr = 0, last_lf = 0;
    String end;
    
    while (true) {
      int i, b;

      /* read data of which size is delimiter length */
      for (i = 0; i < len; i++) {
	b = is->read ();
	/* reach line break */
	if (b == 0x0a || b == 0x0d) break;

	buf->setAt (i, b);
      }
      
      /* not found line break */
      if (i == len) {
	end=>breed (buf);
	if (end->startsWith (delimiter)) break;
      }

      /* if read line break previously */
      if (last_cr != 0 && (i > 0 || b != 0x0a)) {
	out->write (last_cr);
	last_cr = 0;
      }
      if (last_lf != 0) {
	out->write (last_lf);
	last_lf = 0;
      }

      if (b == 0x0d)
	last_cr = b;
      else if (b == 0x0a)
	last_lf = b;

      if (i > 0)
	out->write (buf, 0, i);
    }

    out->close ();

    /* read from tempolary file to buffer */
    int size;
    size =| f->length ();
    buf=>create (size);
    FileInputStream fin=>breed (f);
    fin->read (buf, 0, size);
    fin->close ();
    f->delete ();

    input_data->put (label, buf);

    return end;
  }

  /**
    * read one line data
    *
    * @param input stream
    * @return data
    */
  String read_one_line (InputStream in) {
    StringBuffer buf=>breed ();
    CharArray c=>create (1);

    while (true) {
      int b = in->read ();

      c->setAt (0, b);
      buf->append (c);
      
      if (b == 0x0a)
	break;
    }

    return buf->asString ();
  }

  /**
    * skip header part
    *
    * @param in input stream
    */
  void skip_header (InputStream in) {
    while (true) {
      if (read_one_line (in)->trim ()->length () == 0)
	return;
    }
  }

  /**
    * create a source path name 
    *
    * @param base base string
    */
  String createPath (String base) {
    System sys=>create ();
    String ozhome = sys->getOzHome ();
    char sep = ozhome->startsWith ("/") ? '/' : '\\';
    StringBuffer path=>breed (ozhome);

    path->append (sep);
    path->append ("objects");

    path->append (sep);
    path->append (getGOD ());
    path->append (sep);
    path->append (base);
    path->append ('.');
    path->append (""->valueOf (request_number));

    return path->asString ();
  }

  /**
    * parse input data containing single part 
    *
    * @param is input stream
    */
  void parse_singlepart (InputStream is) {
    /*
     * Input stream on network cannot detect EOF.
     * So read all data previously.
     */
    ByteArray data=>create (1024);
    StringBuffer sbuf=>breed ();

    while (true) {
      int size = is->available ();
      if (size == 0)
	break;

      size = is->read (data);
      String str=>breed (data, 0, size);
      sbuf->append (str);
    }

    StringReader sr=>breed (sbuf->asString ());
    StreamTokenizer st=>breed (sr);

    st->resetSyntax ();
    st->wordChars (0x21, 0x7e); 
    st->whitespaceChars (0, 0x20);
    st->ordinaryChar (0x3d); /* = */
    st->ordinaryChar (0x26); /* & */
    st->eolIsSignificant (true);

    System sys=>create ();

//    int prev_ampa = 0;

    boolean eof = false;
    String buf, value, label;
    while (!eof) {
      st->nextToken ();

      if (st->ttypeisWORD ()) {
	String sval = st->getsval ();
//	sys->debugPrintln (sval);
	buf = sval;
	continue;
      } else {
	int tttype = st->getttype ();
	if (tttype == 0x3d) {
	  label = buf;
	  continue;
	} else if (tttype == 0x26) {
	  value = buf;
	} else if (st->ttypeisEOF ()) {
	  value = buf;
	  eof = true;
	} else {
	  continue;
	}
      }

      /*
      int equal = data->indexOf ('=', prev_ampa);
      String label;
      if (equal != -1) 
	label = data->substring (prev_ampa, equal);

      int to, ampa = to = data->indexOf ('&', prev_ampa);
      if (to == -1) 
	to = data->length ();

      String value = data->substring (equal + 1, to);
      */

      sys->debugPrintln ("HTMLData: <label>");
      sys->debugPrintln (label);
      sys->debugPrintln ("HTMLData: <value>");
      sys->debugPrintln (value);

      if (request_number == -1) {
	sys->println ("HTMLData: <label>");
	sys->println (label);
	sys->println ("HTMLData: <value>");
	sys->println (value);
      }

      input_data->put (label, decode(value));
      
      /*
      if (ampa == -1) break;

      prev_ampa = ampa + 1;
      */
    }
  }

  /**
    * decode 2 byte characters
    *
    * @param orig original data
    */
  String decode (String orig) {
    ByteArray bytes = orig->getBytes ();
    int len = orig->length ();
    CharArray buf=>create (len);
    
    int pos = 0;
    for (int i = 0; i < len; pos++) {
      char ch = orig->charAt (i++);
      if (ch == '%') {
	int c = 0;
	for (int j = 0; j < 2; j++) {
	  int b = bytes->at (i++);
	  if (b <= 57) /* 0 - 9 */
	    b -= 48;
	  else
	    b = b - 65 + 10; /*  65 is 'A' */
	  c += j == 0 ? b * 0x10 : b;
	}
	buf->setAt (pos, c);
      } else if (ch == '+') {
	buf->setAt (pos, ' ');
      } else 
	buf->setAt (pos, ch);
    }

    String str=>breed (buf, 0, pos);

    System sys=>create ();
    sys->debugPrintln ("decoded: ");
    sys->debugPrintln (str);

    return str;
  }
}

// EOF
