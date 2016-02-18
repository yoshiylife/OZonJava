// OZ Launcher


/**
 * LauncherDirectorySelectListener
 *
 * @version  0.9
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

class LauncherDirectorySelectListener
  : *ActionListener
{

  LauncherCore             lCore;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lchr, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
    lCore = lchr;
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  dirName;

    dirName = evt->getActionCommand();
    lCore->changeDirectory(dirName);
  }

}

// EoF

