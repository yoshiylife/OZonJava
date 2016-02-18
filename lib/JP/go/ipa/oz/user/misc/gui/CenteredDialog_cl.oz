// OZ


/**
 * CenteredDialog
 *
 * A dialog which is located at the center in the screen.
 *
 * @version  0.12
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class CenteredDialog
  : *Dialog
{

  ///////////////////////////////////////////////////////// Constructors

  //--------------------------------------------------------------------
  new create(Frame parent, String title, boolean modal)
  {
    super => newDialog(parent, title, modal);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void pack()
  {
    Toolkit  tk;
    Dimension  dim;
    Dimension  mySize;

    super->pack();

    // locate the window at the center in the screen
    tk => newToolkit();
    dim = tk->getScreenSize();
    mySize = getSize();
    setLocation(dim->getWidth()  / 2 - mySize->getWidth()  / 2,
		dim->getHeight() / 2 - mySize->getHeight() / 2);
  }

}

// EoF

