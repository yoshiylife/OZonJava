// OZ Launcher


/**
 * LauncherQuitListener
 *
 * @version  0.9
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class LauncherQuitListener
  : *ActionListener
{

  LauncherCore              lCore;
  AnswerDialog              answerDialog;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lc, AnswerDialog dialog, EventDispatchingQueue eq)
  {
    super => newActionListener(eq);
    lCore = lc;
    answerDialog = dialog;
    answerDialog->addActionListener(this);

  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    String  cmd;

    cmd = evt->getActionCommand();

    answerDialog->dispose();
    if (cmd->isequal("OK")) {
      lCore->stop();
    }
  }

}

// EoF

