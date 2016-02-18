// OZ DEV: Class Browser


/**
 * CBHierarchyMenuListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBHierarchyMenuListener
  : *ActionListener
{

  CBPartView               partView;
  EventDispatchingQueue    dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBHierarchyMenuListener(CBPartView pv, EventDispatchingQueue evtQue)
  {
    super => newActionListener(evtQue);
    partView = pv;
    dialogQue => create();

    system => create();
    if (isGreen()) {
      system->debugPrintln("\tCBhierarchyMenuListener#new: green");
    } else {
      system->debugPrintln("\tCBHierarchyMenuListener#new: red");
    }
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;
    ClassBrowser  cb;

    cmd = evt->getActionCommand();

    if (cmd->isequal("ancestors")) {
      try {
        partView->showLocalHierarchy();
      } catch (CIException ex) {
          // nothing
      }
    }
  }

}

// EoF

