// DEV: Class Browser


/**
 * CBWindowClosingListener
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBWindowClosingListener
  : *WindowListener
{

  Window  targetWindow;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBWindowClosingListener(Window win, EventDispatchingQueue evtQue)
  {
    super => newWindowListener(evtQue);
    targetWindow = win;
    system => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void windowClosing(WindowEvent evt)
  {
    system->debugPrintln("\tCBWindowClosingListener#windowClosing");

    targetWindow->dispose();
  }

}

// EoF

