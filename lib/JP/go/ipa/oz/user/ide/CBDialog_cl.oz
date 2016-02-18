// DEV: Class Browser


/**
 * CBDialog
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

abstract class CBDialog
  : *Dialog
{

  ///////////////////////////////////////////////////////// Constructors

  //--------------------------------------------------------------------
  new newCBDialog(Frame parent, String title, boolean modal)
  {
    super => newDialog(parent, title, modal);

  }


  //--------------------------------------------------------------------
  public void pack()
  {
    Toolkit  tk;
    Dimension  dim;
    Dimension  mySize;

    super->pack();

    // locate the window at the center of screen
    tk => newToolkit();
    dim = tk->getScreenSize();
    mySize = getSize();
    setLocation(dim->getWidth() / 2 - mySize->getWidth() / 2,
		dim->getHeight() / 2 - mySize->getHeight() / 2);
  }

}

// EoF

