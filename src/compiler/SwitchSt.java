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
 * $Id: SwitchSt.java,v 0.21 1998-02-02 08:31:42+09 otokawa Exp $
 */

/*
 * created by Hideyuki OTOKAWA, Sharp corp.
 * 1996.12.3
 */

package JP.go.ipa.oz.compiler;

/**
  * A class representing switch statement.
  *
  * @see Statement
  */

class SwitchSt extends Statement {
  /**
    * integral expression 
    */
  Expression exp;
  
  /**
    * block statement 
    */
  CompoundSt comp_st;
  
  /**
    * create new one
    *
    * @param o exrepssion
    * @param c_st statement (block)
    * @param ln line number
    */
  SwitchSt (Expression e, CompoundSt c_st, int ln) { 
    super (ln); 

    exp = e;
    comp_st = c_st; 

    if (!PrimitiveType.INT.isAssignable (e.type)) {
      /* switch exprssion must be compatible with int */
      OzcError.switchExpMustBeInt ();
    }
  }

  /** 
    * override
    *
    * @see Statement
    */
  void check (MethodType method) throws Unreachable { 
    if (exp != null)
      exp.check ();

    int size = comp_st.size ();
    if (size == 0) {
      /* empty block */
      if (method != null) method.checkReturnSt (line_no);
      return;
    }

    /* check if has some breaks which exits this switch block */
    boolean next_is_unreachable = true;
    if (comp_st.hasBreak (null) || 
	(label != null && comp_st.hasBreak (label))) {
      if (method != null) method.checkReturnSt (line_no);

      next_is_unreachable = false;
    }

    boolean has_default_label = false;
    Statement st = null;
    for (int i = 0; i < size; i++) {
      st = comp_st.get (i);

      if (st instanceof SwitchLabel) {
	SwitchLabel sl = (SwitchLabel) st;

	if (sl.label != null) {
	  if (exp.type != null && !exp.type.isAssignable (sl.label))
	    OzcError.caseLabelMustBeAssignable (sl.label.line_no);
	} else {
	  has_default_label = true;
	}
	
	continue;
      } 

      if (i == 0) throw new Unreachable (st);

      try {
	st.check (null);
      } catch (Unreachable e) {
	/* containing a true unrechable statement */
	if (e.getStatement () != null) throw e;

	if (i + 1 < size) {
	  Statement next = comp_st.get (i + 1);
	  if (next instanceof SwitchLabel) continue;

	  /* next statement is not labeled one */
	  e.setStatement (next);
	  throw e;
	} 
      }
    }

    /* last statement is label */
    if (st instanceof SwitchLabel) return;

    /* contains default label but has no break */
    if (next_is_unreachable && has_default_label) throw new Unreachable ();
  }
  
  /**
    * override 
    * 
    * @see Statement
    */
  boolean hasBreak (Identifier lab) {  
    if (lab == null)
      return false;
    return comp_st.hasBreak (lab); 
  }

  /** 
    * override
    *
    * @see Statement
    */
  void emit () {
    if (Emitter.isEmitting ()) exp.preEmitForMethodInvocation ();

    Emitter.emitln (line_no);
    Emitter.emit ("switch (");
    Emitter.emit (exp);
    Emitter.emit (") ");
    comp_st.emit ();
  }
}

/* EOF */
