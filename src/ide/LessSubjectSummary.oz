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

// OZ DEV


/**
 * LessSubjectSummary
 *
 * @version  0.8
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class LessSubjectSummary
 : BinaryPredicate
{

  
  ///////////////////////////////////////////////////////// constructors

  new create()
  {
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public boolean execute(Root obj1, Root obj2)
  {
    SubjectSummary  sm1, sm2;
    String  name1, name2;

    sm1 =| obj1;
    sm2 =| obj2;
    name1 = sm1->getName();
    name2 = sm2->getName();
    return (name1->compareTo(name2) < 0);
  }

}


// EoF

