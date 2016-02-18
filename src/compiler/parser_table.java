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

package JP.go.ipa.oz.compiler;

/**
  * table for parser
  */

class parser_table {
  /** parse action table */
  protected static short[][] _action_table;

  /** parse action tables */
  static final short[][][] _action_tables = {
    parser_table0._action_table,
    parser_table1._action_table,
  };

  /** access to parse action table */
  static short[][] action_table() {
    if (_action_table != null) return _action_table;

    int len = 0;
    for (int k = 0; k < _action_tables.length; k++) 
      len += _action_tables[k].length;

    _action_table = new short[len][];

    int i = 0;
    for (int k = 0; k < _action_tables.length; k++) {
      for (int j = 0; j < _action_tables[k].length; j++) 
	_action_table[i++] = _action_tables[k][j];
    }

    return _action_table;
  }
}
