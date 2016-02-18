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

