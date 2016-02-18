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
 * SubjectSummaryTextListener
 *
 * @version  0.3
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class SubjectSummaryTextListener
  : *TextListener
{

  SubjectSummaryBrowserMenuBar      ssbMenubar;
  EventDispatchingQueue             dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(SubjectSummaryBrowserMenuBar mb, EventDispatchingQueue eq)
  {
    system => create();
    system->println("\tSubjectSummaryTextListener#create");
    super => newTextListener(eq);
    ssbMenubar = mb;
    dialogQue => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void textValueChanged(TextEvent evt)
  {
    ssbMenubar->needSave(true);
  }

}

// EoF

