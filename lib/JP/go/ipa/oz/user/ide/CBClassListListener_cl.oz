// OZ DEV: Class Browser


/**
 * CBClassListListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBClassListListener
  : *ActionListener
{

  CBPartView  partView;
  CBClassList  classList;
  EventDispatchingQueue  dialogQue;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //------------------------------------------------------------------
  new newCBClassListListener(CBClassList list, CBPartView pv,
                             EventDispatchingQueue evtQue)
  {
    super => newActionListener(evtQue);
    initParam(list, pv);
    system => create();
  }


  /////////////////////////////////////////////////////// public methods

  //------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    int  index;
    String  cid;
    CBExceptionDialog  exDialog;

    index = classList->getSelectedIndex();
    if (index != -1) {
      cid = classList->getCID(index);
      system->debugPrintln("\tCBClassListListener#actionPerformed: "->concat(cid->asString()));
      classList->deselect(index);
      try {
        partView->getClassBrowser()->show(cid);
      } catch (CIException ex) {
        exDialog => newCBExceptionDialog(partView, ex->asString(), dialogQue);
      }
    }
  }



  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initParam(CBClassList list, CBPartView pv)
  {
    classList = list;
    partView = pv;
    dialogQue => create();
  }

}

// EoF

