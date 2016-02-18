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
 * $Id: FileProperty.oz,v 0.2 1998-01-22 16:59:23+09 otokawa Exp $
 */

/**
  * a class for read property file
  */

class FileProperty {
  /**
    * create new one
    */
  new create () {
  }

  /**
    * read contents
    *
    * @param file_name file name
    * @param eval evaluator
    */
  public void read (String file_name, FilePropertyReader eval) {
    System sys=>create ();
    String ozhome = sys->getOzHome ();
    String prop = ozhome->concat ("/lib/")->concat (file_name);
    FileReader in=>breed (prop);
    StreamTokenizer st=>breed (in);

    st->resetSyntax ();
    st->wordChars (0x21, 0x7e); 
    st->whitespaceChars (0, 0x20);
    st->ordinaryChar (0x3d); /* = */
    st->eolIsSignificant (true);

    boolean eof = false;
    String buf, value, label;

    while (!eof) {
      st->nextToken ();

      if (st->ttypeisWORD ()) {
	String sval = st->getsval ();

	buf = sval;
	continue;
      } else {
	int tttype = st->getttype ();
	if (tttype == 0x3d) {
	  label = buf;
	  continue;
	} else if (st->ttypeisEOF ()) {
	  value = buf;
	  eof = true;
	} else {
	  continue;
	}
      }

      /*
      sys->println ("label#"->concat (label));
      sys->println ("value#"->concat (value));
      */

      eval->eval (label, value);
    }

    in->close ();
  }
}

/* EOF */
