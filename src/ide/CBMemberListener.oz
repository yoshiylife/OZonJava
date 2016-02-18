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

// OZ DEV: Class Browser


/**
 * CBMemberSelectListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBMemberListener
  : *MouseListener
{

  CBMemberListView  memberListView;
  EventDispatchingQueue  dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //------------------------------------------------------------------
  new newCBMemberListener(CBMemberListView mv, EventDispatchingQueue evtQue)
  {
    super => newMouseListener(evtQue);

    memberListView = mv;
    dialogQue => create();

    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBMemberListener#new: green");
    } else {
      system->debugPrintln("\tCBMemberListener#new: red");
    }
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void mouseReleased(MouseEvent evt)
  {
    CBMemberLabel  source;
    CIMember  member;

    source =| evt->getSource();
    member = source->getMember();
    memberListView->select(member);
  }

}

// EoF

