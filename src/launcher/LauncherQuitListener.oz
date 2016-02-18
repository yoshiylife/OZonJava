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

