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

// OZ


/**
 * GOLInputListenerForApplication
 *
 * @version  1.0
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class GOLInputListenerForApplication
  : *StringInputListener
{

  ApplicationGarageBrowser    agBrowser;
  Frame                       parentFrame;
  EventDispatchingQueue       dialogQue;



  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(ApplicationGarageBrowser agb, EventDispatchingQueue eq)
  {
    super => create(eq);
    agBrowser = agb;
    parentFrame = agBrowser->getGUI();

    dialogQue => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void actionPerformed(ActionEvent evt)
  {
    StringInputDialog  dialog;
    String  cmd;
    String  gol;
    boolean  needToClose = true;

    cmd = evt->getActionCommand();

    dialog = getDialog();
    if (cmd->isequal("OK")) {
      gol = dialog->getInputString();
      if (gol->length() > 0) {
        try {
          if (agBrowser != null) {
            agBrowser->bindServer(gol);
          }
        } catch (GarageException ex) {
          needToClose = false;
          handleException();
        } catch (CellNotFoundException ex) {
          needToClose = false;
          handleException();
        } catch (Root o) {
          needToClose = false;

          handleException();
        }

      } else {
        needToClose = false;
        handleException();
      }
    }

    if (needToClose) {
      dialog->dispose();
    }
  }


  //--------------------------------------------------------------------
  void handleException()
  {
    ExceptionDialog  exDialog;

    exDialog => create(parentFrame, "Invalid GOL", dialogQue);
  }

}

// EoF

