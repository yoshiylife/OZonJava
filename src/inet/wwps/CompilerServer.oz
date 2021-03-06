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
 * $Id: CompilerServer.oz,v 0.1 1997-11-06 16:44:51+09 otokawa Exp $
 */

/**
  * a class of compile server
  */

class CompilerServer {
  /**
    * registered school table
    */
  Dictionary schools;

  /**
    * invoke compile
    *
    * @param file_name source file name
    * @param school school object
    * @param log logging output 
    */
  public void compile (String file_name, School school, Writer log) {
    CompilerAgent ca=>create (school);
    ca->compile (file_name, log);
  }

  /**
    * register school object
    *
    * @param subject school name
    * @param school school object
    */
  public void registerSchool (String subject, School school) {
    if (schools->containsKey (subject))
      schools->remove (subject);

    schools->put (subject, school);
  }

  /**
    * search school object
    *
    * @param subject school name
    * @return school object
    */
  public School searchSchool (String subject) {
    School s;
    s =| schools->get (subject);
    return s;
  }

  /**
    * create new one
    */
  new create () {
    StringComparator scomp=>create ();
    schools=>create (scomp);
  }
}

/* EOF */
