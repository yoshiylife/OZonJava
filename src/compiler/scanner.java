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
 * $Id: scanner.java,v 0.14 1998-01-13 18:29:36+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.11.12
 */

package JP.go.ipa.oz.compiler;

import java_cup.runtime.*;
import java.io.*;

/**
  * A class representing scanner 
  *
  * @see parser
  */

class scanner {
  /**
    * file to read 
    */
  private FileInputStream src_file;

  /**
    * line number 
    */
  int line_no;

  /**
    * debug flag 
    */
  private boolean debug;

  /**
    * single lookahead character 
    */
  private int next_char;

  /**
    * cuurent position in file
    */
  private int offset;

  /**
    * start position of current token 
    */
  private int mark;

  /**
    * reserved words table 
    */
  private static java.util.Hashtable reserved_words;

  static {
    reserved_words = new java.util.Hashtable ();

    reserved_words.put ("abstract", new OzToken (sym.ABSTRACT));
    reserved_words.put ("bool", new OzToken (sym.BOOL));
    reserved_words.put ("break", new OzToken (sym.BREAK));
    reserved_words.put ("byte", new OzToken (sym.BYTE));
    reserved_words.put ("case", new OzToken (sym.CASE));
    reserved_words.put ("catch", new OzToken (sym.CATCH));
    reserved_words.put ("cell", new OzToken (sym.CELL));
    reserved_words.put ("char", new OzToken (sym.CHAR));
    reserved_words.put ("class", new OzToken (sym.CLASS));
    reserved_words.put ("condition", new OzToken (sym.CONDITION));
    reserved_words.put ("continue", new OzToken (sym.CONTINUE));
    reserved_words.put ("default", new OzToken (sym.DEFAULT));
    reserved_words.put ("do", OzToken.DO);
    reserved_words.put ("double", new OzToken (sym.DOUBLE));
    reserved_words.put ("else", new OzToken (sym.ELSE));
    reserved_words.put ("false", new OzStrToken (sym.FALSE, "false"));
    reserved_words.put ("final", new OzToken (sym.FINAL));
    reserved_words.put ("finally", new OzToken (sym.FINALLY));
    reserved_words.put ("float", new OzToken (sym.FLOAT));
    reserved_words.put ("for", OzToken.FOR);
    reserved_words.put ("if", OzToken.IF);
    reserved_words.put ("int", new OzToken (sym.INT));
    reserved_words.put ("locked", new OzToken (sym.LOCKED));
    reserved_words.put ("long", new OzToken (sym.LONG));
    reserved_words.put ("new", new OzToken (sym.NEW));
    reserved_words.put ("null", new OzStrToken (sym.NULL, "null"));
    reserved_words.put ("once", new OzToken (sym.ONCE));
    reserved_words.put ("protected", new OzToken (sym.PROTECTED));
    reserved_words.put ("public", new OzToken (sym.PUBLIC));
    reserved_words.put ("throw", new OzToken (sym.THROW));
    reserved_words.put ("return", new OzToken (sym.RETURN));
    reserved_words.put ("short", new OzToken (sym.SHORT));
    reserved_words.put ("static", new OzToken (sym.STATIC));
    reserved_words.put ("switch", OzToken.SWITCH);
    reserved_words.put ("super", new OzToken (sym.SUPER));
    reserved_words.put ("this", new OzToken (sym.THIS));
    reserved_words.put ("transient", new OzToken (sym.TRANSIENT));
    reserved_words.put ("true", new OzStrToken (sym.TRUE, "true"));
    reserved_words.put ("try", OzToken.TRY);
    reserved_words.put ("void", new OzToken (sym.VOID));
    reserved_words.put ("while", OzToken.WHILE);

    reserved_words.put ("boolean", new OzToken (sym.BOOL));
    reserved_words.put ("const", OzToken.JAVA);
    reserved_words.put ("extends", OzToken.JAVA);
    reserved_words.put ("goto", OzToken.JAVA);
    reserved_words.put ("implements", OzToken.JAVA);
    reserved_words.put ("import", OzToken.JAVA);
    reserved_words.put ("instanceof", OzToken.JAVA);
    reserved_words.put ("interface", OzToken.JAVA);
    reserved_words.put ("native", OzToken.JAVA);
    reserved_words.put ("package", OzToken.JAVA);
    reserved_words.put ("private", OzToken.JAVA);
    reserved_words.put ("synchronized", OzToken.JAVA);
    reserved_words.put ("throws", OzToken.JAVA);
    reserved_words.put ("volatile", OzToken.JAVA);
  }

  /**
    * create new one
    *
    * @param file file name 
    */
  scanner (String file) throws IOException {
    src_file = new FileInputStream (file);
    
    line_no = 1;
    advance ();
    offset = 0;

    if (ozc.isScannerDebug ()) debug = true;
  }

  /**
    * advance input by one character 
    */
  private void advance () throws IOException {
    next_char = src_file.read ();
    offset++;
  }

  /**
    * create a OzStrToken 
    *
    * @param sym kind of token 
    * @param val string value
    * @return token
    */
  private OzStrToken createStrToken (int sym, String val) {
    int pos = mark;
    mark = offset;
    return new OzStrToken (sym, val, line_no, pos);
  }

  /**
    * create a OzStrToken 
    *
    * @param sym kind of token 
    * @return token
    */
  private OzStrToken createStrToken (int sym) {
    return createStrToken (sym, "");
  }

  /**
    * create a OzToken 
    *
    * @param sym kind of token 
    * @param ln line number
    * @return token
    */
  private OzToken createToken (int sym, int ln) {
    int pos = mark;
    mark = offset;
    return new OzToken (sym, ln, pos);
  }

  /**
    * create a OzToken 
    *
    * @param sym kind of token 
    * @return token
    */
  private OzToken createToken (int sym) {
    return createToken (sym, line_no);
  }

  /**
    * parse interger postifx: L, l 
    *
    * @param i_val interger string
    * @return token
    */
  private token parseIntegerPostfix (StringBuffer i_val) throws IOException {
    if (next_char == 'L' || next_char == 'l') {
      i_val.append ((char) next_char);
      advance ();

      /* debug */
      if (debug)
	ozc.debugln ("LONG_LITERAL (" + i_val + ") ");

      return createStrToken (sym.LONG_LITERAL, i_val.toString ());
    }

    /* debug */
    if (debug)
      ozc.debugln ("INT_LITERAL (" + i_val + ") ");

    return createStrToken (sym.INT_LITERAL, i_val.toString ());
  }
  
  /**
    * check if hex integer character 
    *
    * @param c character
    * @return if so true, otherwise false
    */
  private boolean isHex (int c) {
    return ((c >= '0' && c <= '9') ||
	    (c >= 'A' && c <= 'F') ||
	    (c >= 'a' && c <= 'f'));
  }

  /**
    * parse hex integer 
    *
    * @param i_val interger string 
    * @return token
    */
  private token parseHexInteger (StringBuffer i_val) throws IOException {
    while (true) {
      if (!isHex (next_char))
	break;

      i_val.append ((char) next_char);
      advance ();
    }

    /* debug */
    if (debug)
      ozc.debug ("HEX: ");

    return parseIntegerPostfix (i_val);
  }
  
  /**
    * parse octal integer 
    *
    * @param i_val integer string
    * @return token
    */
  private token parseOctalInteger (StringBuffer i_val) throws IOException {
    while (next_char >= '0' && next_char <= '7') {
      i_val.append ((char) next_char);
      advance ();
    }
    
    /* debug */
    if (debug)
      ozc.debug ("OCTAL: ");
    
    return parseIntegerPostfix (i_val);
  }
  
  /**
    * parse decimal integer 
    *
    * @return string representaion
    */
  private String parseDecimalInteger () throws IOException {
    StringBuffer i_val = new StringBuffer ();

    while (next_char >= '0' && next_char <= '9') {
      i_val.append ((char) next_char);
      advance ();
    }

    if (i_val.length () == 0) return "0";

    return i_val.toString ();
  }
  
  /**
    * parse floating-point 
    *
    * @param f_val float string
    * @return token
    */
  private token parseFloatingPoint (StringBuffer f_val) throws IOException {
    while (next_char >= '0' && next_char <= '9') {
      f_val.append ((char) next_char);
      advance ();
    }

    if (next_char == 'E' || next_char == 'e') {
      f_val.append ((char) next_char);
      advance ();
      if (next_char != '+' && next_char != '-')
	return createStrToken (sym.DOUBLE_LITERAL, f_val.toString ());

      f_val.append ((char) next_char);
      advance ();
      f_val.append (parseDecimalInteger ());
    }

    if (next_char == 'f' || next_char == 'F') {
      f_val.append ((char) next_char);
      advance ();

      /* debug */
      if (debug)
	ozc.debugln ("FLOAT_LITERAL (" + f_val + ") ");

      return createStrToken (sym.FLOAT_LITERAL, f_val.toString ());
    }

    /* debug */
    if (debug)
      ozc.debugln ("DOUBLE_LITERAL (" + f_val + ") ");

    return createStrToken (sym.DOUBLE_LITERAL, f_val.toString ());
  }
  
  /**
    * parse number literals 
    *
    * @return token
    */
  private token parseNumberLiteral () throws IOException {
    StringBuffer val = new StringBuffer ();

    if (next_char == '0') {
      val.append ((char) next_char);
      advance ();
      if (next_char == 'x' || next_char == 'X') {
	val.append ((char) next_char);
	advance ();
	return parseHexInteger (val);
      } else if (next_char == '.') {
	/* parse a double floating value */
	val.append ((char) next_char);
	advance ();
	return parseFloatingPoint (val);
      } else 
	return parseOctalInteger (val);
    }

    val.append (parseDecimalInteger ());

    if (next_char != '.') 
      return parseIntegerPostfix (val);

    /* parse a double floating value */
    val.append ((char) next_char);
    advance ();
    return parseFloatingPoint (val);
  }
  
  /**
    * check wheter next character is one of line terminators 
    *
    * @return if so true, otherwise false
    */
  private boolean checkLineTerminator () throws IOException {
    if (next_char == -1)
      return true;
    
    if (next_char == '\r') {
      advance ();
      if (next_char == '\n')
	advance ();
      line_no++;

      /* debug */
//      if (debug)
//	ozc.debugln ("new line");
      return true;
    }
    
    if (next_char == '\n') {
      advance ();
      line_no++;
      /* debug */
//      if (debug)
//	ozc.debugln ("new line");
      return true;
    }
    
    mark = offset;

    return false;
  }
  
  /**
    * parse string literal 
    *
    * @return token
    */
  private OzStrToken parseStringLiteral () throws IOException {
    StringBuffer str = new StringBuffer ("\"");

    while (next_char != '\"') {
      if (checkLineTerminator ()) {
	/* error! cannot contain line terminator in string literal */

	while (next_char != '\"' && next_char != -1) {
	  advance ();
	  checkLineTerminator ();
	}

	/* tempolary code */
	break;
      }

      if (next_char == '\\') {
	str.append ((char) next_char);
	advance ();
      }

      str.append ((char) next_char);
      advance ();
    }
    advance ();

    str.append ("\"");

    /* debug */
    if (debug)
      ozc.debugln ("STRING_LITERAL (" + str + ") ");

    return createStrToken (sym.STRING_LITERAL, str.toString ());
  }
  
  /**
    * parse one line (C++-like) style comment 
    */
  private void parseCommentLine () throws IOException {
    /* debug */
    if (debug)
      ozc.debugln ("comment line");
    while (!checkLineTerminator ()) advance ();
    mark = offset;
  }
  
  /**
    * parse old (C-like) style comment 
    */
  private void parseCommentRegion () throws IOException {
    /* debug */
    if (debug)
      ozc.debugln ("comment region");
    while (next_char != -1) {
      if (next_char == '*') {
	advance();
	if (next_char == '/') {
	  advance ();
	  break;
	}
      } else if (next_char == '/') {
	advance();
	if (next_char == '*') {
	  /* warning: cannot nest regional comment */
	  advance ();
	}
      } else if (!checkLineTerminator ())
	advance ();
    }
    mark = offset;
  }
  
  /**
    * check whether str is one of reserved words 
    *
    * @param str string 
    * @return token (reserved word or identifier)
    */
  private token checkReservedWords (String str) {
    OzToken tkn;

    tkn = (OzToken) reserved_words.get (str);
    if (tkn != null) {
      /* debug */
      if (debug)
	ozc.debugln ("RESERVED (" + str + ") ");
      tkn.setLineNumber (line_no);

      if (tkn == OzToken.DO || 
	  tkn == OzToken.FOR || 
	  tkn == OzToken.IF ||
	  tkn == OzToken.SWITCH || 
	  tkn == OzToken.TRY || 
	  tkn == OzToken.WHILE)
	return createToken (tkn.sym, tkn.line_no);
      else {
	tkn.offset = mark;
	mark = offset;
	return tkn;
      }
    }

    /* debug */
    if (debug)
      ozc.debugln ("IDENTIFIER (" + str + ") ");

    return createStrToken (sym.IDENTIFIER, str);
  }
  
  /**
    * parse reserved words or identifier 
    * 
    * @return token
    */
  private token parseWord () throws IOException {
    StringBuffer str = new StringBuffer ();

    mark = offset;

    if (!Character.isLowerCase ((char) next_char) &&
        !Character.isUpperCase ((char) next_char)) {
      /* error! top of identifier must be [A-Za-z] */
      str.append ((char) next_char);
      OzcError.illegalCharacter (str.toString ());
      str.setLength (0);

      advance ();
    }

    while (Character.isLowerCase ((char) next_char) || 
	   Character.isUpperCase ((char) next_char) ||
	   Character.isDigit ((char) next_char) || next_char == '_') {
      str.append ((char) next_char);
      advance ();
    }

    if (str.length () == 0) {
      return null;
    }

    return checkReservedWords (str.toString ());
  }
  
  /**
    * recognize and return the next complete token 
    *
    * @return token
    */
  token getNextToken () throws IOException {
    while (true)
      switch (next_char) {
      case '0': case '1': case '2': case '3': case '4':
      case '5': case '6': case '7': case '8': case '9':
	return parseNumberLiteral ();

      case '\'':
	StringBuffer c_val = new StringBuffer ("\'");
	advance ();

	boolean skip = false;

	/* scan escaped char */
      escape_char:
	{
	  if (next_char == '\\') {
	    c_val.append ((char) next_char);
	    advance ();
	    
	    if (next_char == 'u') {
	      /* unicode */
	      c_val.append ((char) next_char);
	      advance ();

	      /* skip unicode marker */
	      while (next_char == 'u') advance ();
	      
	      for (int i = 0; i < 4; i++) {
		if (!isHex (next_char)) {
		  skip = true;
		  break escape_char;
		}

		c_val.append ((char) next_char);
		advance ();
	      }
	      break escape_char;
	    } else if (next_char >= '0' && next_char <= '7') {
	      c_val.append ((char) next_char);

	      int len;
	      if (next_char > '3')
		len = 1;
	      else
		len = 2;

	      advance ();
	      
	      for (int i = 0; i < len; i++) {
		if (next_char == '\'')
		  break escape_char;

		if (next_char < '0' || next_char > '7') {
		  skip = true;
		  break escape_char;
		}

		c_val.append ((char) next_char);
		advance ();
	      }
	      break escape_char;
	    } else if (next_char != 'n' && next_char != 't' &&
		       next_char != 'b' && next_char != '\\' &&
		       next_char != 'r' && next_char != 'f' &&
		       next_char != '\'' && next_char != '\"') {
	      skip = true;
	      break escape_char;
	    }
	  }

	  c_val.append ((char) next_char);
	  advance ();
	}

	if (skip || next_char != '\'') {
	  while (next_char != '\'' && next_char != -1) {
	    c_val.append ((char) next_char);
	    advance ();
	    checkLineTerminator ();
	  }

	  if (next_char != -1)
	    c_val.append ((char) next_char);

	  OzcError.illegalCharacterLiteral (c_val.toString ());

	  if (next_char != -1)
	    advance ();

	  continue;
	}

	c_val.append ("\'");
	advance ();

	/* debug */
	if (debug)
	  ozc.debugln ("CHAR_LITERAL (" + c_val + ") ");

	return createStrToken (sym.CHAR_LITERAL, c_val.toString ());

      case '\"':
	advance ();
	return parseStringLiteral ();

      case '(':
	/* debug */ 
	if (debug) ozc.debugln ("LPAREN ");
	advance (); return createToken (sym.LPAREN);
      case ')':
	/* debug */ 
	if (debug) ozc.debugln ("RPAREN ");
	advance (); return createToken (sym.RPAREN);
      case '{':
	/* debug */
	if (debug) ozc.debugln ("LBRACE ");
	advance (); return createToken (sym.LBRACE);
      case '}':
	/* debug */ 
	if (debug) ozc.debugln ("RBRACE ");
	advance (); return createToken (sym.RBRACE);
      case ';':
	/* debug */ 
	if (debug) ozc.debugln ("SEMI ");
	advance (); return createToken (sym.SEMI);
      case '?':
	/* debug */ 
	if (debug) ozc.debugln ("QUESTION ");
	advance (); return createToken (sym.QUESTION);
      case ',':
	/* debug */ 
	if (debug) ozc.debugln ("COMMA ");
	advance (); return createToken (sym.COMMA);

      case '!':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("NOTEQUAL ");
	  advance ();
	  return createStrToken (sym.NOTEQUAL);
	}
	/* debug */ 
	if (debug) ozc.debugln ("EXCLAM ");
	return createStrToken (sym.EXCLAM);
      case '+':
	advance ();
	if (next_char == '+') {
	  /* debug */ 
	  if (debug) ozc.debugln ("PLUSPLUS ");
	  advance ();
	  return createStrToken (sym.PLUSPLUS);
	}
	if (next_char == '=') {
	  advance ();
	  /* debug */ 
	  if (debug) ozc.debugln ("PLUSEQUAL ");
	  return createStrToken (sym.PLUSEQUAL);
	}
	/* debug */ 
	if (debug) ozc.debugln ("PLUS ");
	return createStrToken (sym.PLUS);
      case '-':
	advance ();
	if (next_char == '-') {
	  /* debug */ 
	  if (debug) ozc.debugln ("MINUSMINUS ");
	  advance ();
	  return createStrToken (sym.MINUSMINUS);
	}
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("MINUSEQUAL ");
	  advance ();
	  return createStrToken (sym.MINUSEQUAL);
	}
	if (next_char == '>') {
	  /* debug */ 
	  if (debug) ozc.debugln ("POINTSTAT ");
	  advance ();
	  return createToken (sym.POINTSTAT);
	}
	/* debug */ 
	if (debug) ozc.debugln ("MINUS ");
	return createStrToken (sym.MINUS);
      case '*':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("TIMESEQUAL ");
	  advance ();
	  return createStrToken (sym.TIMESEQUAL);
	}
	/* debug */ 
	if (debug) ozc.debugln ("TIMES ");
	return createStrToken (sym.TIMES);
      case '/':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("DIVIDEEQUAL ");
	  advance ();
	  return createStrToken (sym.DIVIDEEQUAL);
	}
	if (next_char == '/') {
	  advance ();
	  parseCommentLine ();
	  continue;
	}
	if (next_char == '*') {
	  advance ();
	  parseCommentRegion ();
	  continue;
	}
	/* debug */ 
	if (debug) ozc.debugln ("DIVIDE ");
	return createStrToken (sym.DIVIDE);
      case '%':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("MODEQUAL ");
	  advance ();
	  return createStrToken (sym.MODEQUAL);
	}
	/* debug */ 
	if (debug) ozc.debugln ("MOD ");
	return createStrToken (sym.MOD);
      case '<':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("LTE ");
	  advance ();
	  return createStrToken (sym.LTE);
	}
	/* debug */ 
	if (debug) ozc.debugln ("LANGLE ");
	return createStrToken (sym.LANGLE);
      case '>':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("GTE ");
	  advance ();
	  return createStrToken (sym.GTE);
	}
	/* debug */ 
	if (debug) ozc.debugln ("RANGLE ");
	return createStrToken (sym.RANGLE);
      case '=':
	advance ();
	if (next_char == '=') {
	  /* debug */ 
	  if (debug) ozc.debugln ("EQUALEQUAL ");
	  advance ();
	  return createStrToken (sym.EQUALEQUAL);
	}
	if (next_char == '>') {
	  /* debug */ 
	  if (debug) ozc.debugln ("INSTANTIATE ");
	  advance ();
	  return createToken (sym.INSTANTIATE);
	}
	if (next_char == '|') {
	  /* debug */ 
	  if (debug) ozc.debugln ("EQUALBAR ");
	  advance ();
	  return createStrToken (sym.EQUALBAR);
	}
	/* debug */ 
	if (debug) ozc.debugln ("EQUAL ");
	return createStrToken (sym.EQUAL);
      case ':':
	advance ();
	/* debug */ 
	if (debug) ozc.debugln ("COLON ");
	return createToken (sym.COLON);
      case '&':
	advance ();
	if (next_char == '&') {
	  advance ();
	  if (next_char == '=') {
	    /* debug */ 
	    if (debug) ozc.debugln ("ANDANDEQUAL ");
	    advance ();
	    return createStrToken (sym.ANDANDEQUAL);
	  }
	  /* debug */ 
	  if (debug) ozc.debugln ("ANDAND ");
	  return createToken (sym.ANDAND);
	}
	/* debug */ 
	if (debug) ozc.debugln ("AND ");
	return OzToken.JAVA;
      case '|':
	advance ();
	if (next_char == '|') {
	  advance ();
	  if (next_char == '=') {
	    /* debug */ 
	    if (debug) ozc.debugln ("OROREQAUL ");
	    advance ();
	    return createStrToken (sym.OROREQUAL);
	  }
	  /* debug */ 
	  if (debug) ozc.debugln ("OROR ");
	  return createToken (sym.OROR);
	}
	/* debug */ 
	if (debug) ozc.debugln ("OR ");
	return OzToken.JAVA;
      case '.':
	advance ();
	if (next_char >= '0' && next_char <= '9') 
	  return parseFloatingPoint (new StringBuffer ("."));
	/* debug */ 
	if (debug) ozc.debugln ("DOT ");
	return createToken (sym.DOT);

      case -1:
	/* debug */ 
//	if (debug) ozc.debugln ("EOF");
	src_file.close ();
	return createToken (sym.EOF);

      default:
	if (checkLineTerminator ()) break;

	if (Character.isWhitespace ((char) next_char)) {
	  advance ();
	  mark = offset;
	  break;
	}

	token tk = parseWord ();
	if (tk != null)
	  return tk;
      }
  }
};

/* EOF */
