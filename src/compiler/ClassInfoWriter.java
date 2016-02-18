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
 * $Id: ClassInfoWriter.java,v 0.1 1997-07-09 10:57:30+09 otokawa Exp $
 */

package JP.go.ipa.oz.compiler;

import java.io.*;

/**
  * generating class information for browser
  *
  * usage:
  *	java JP.go.ipa.oz.compiler.ClassInfoWriter [-i] school class_name
  *
  * option:
  * 	-i	for interface
  *
  */

class ClassInfoWriter {
  public static void main (String[] av) {
    boolean interfase = false;
    int i = 0;

    if (av[i].equals ("-i")) {
      interfase = true;
      i++;
    }

    try {
      ozc o = new ozc ();

      ozc.register (Thread.currentThread (), o);
      o.domain = "JP.go.ipa.oz";
      o.setupSchool (av[i++]);

      Emitter.reset ();

      ClassImplementation cls = ozc.getSchool ().search (av[i]);
      ClassInterface cif = cls.getInterface ();

      cif.initialize ();
      cls.initialize ();

      ClassType c;

      Emitter.emitter_obj.emitting = Emitter.EMITTING_INFO;

      if (interfase) 
	c = cif;
      else
	c = cls;

/*       if (Emitter.create_output_file_for_browser (c) == null) { */
/* 	Emitter.emitter_obj.output = new Output (new PrintWriter (System.out, true)); */
/*       } */
      OzcClassLoader.load (c, null);
      c.emitDefinitionForBrowser ();
    } catch (Exception e) {
      e.printStackTrace ();
    }
  }
}
