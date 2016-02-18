// OZ Misc. GUI


/**
 * CenteredFrame
 *
 * A Frame which is located at the center in the screen.
 *
 * @version  1.0
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class CenteredFrame
  : *Frame
{

  ///////////////////////////////////////////////////////// Constructors

  //--------------------------------------------------------------------
  new create()
  {
    super => newFrame();
  }


  //--------------------------------------------------------------------
  new create(String title)
  {
    super => newFrame(title);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void pack()
  {
    Toolkit  tk;
    Dimension  scrDim;
    Dimension  myDim;

    super->pack();

    // locating this window at the center in the screen
    tk => newToolkit();
    scrDim = tk->getScreenSize();
    myDim = getSize();
    setLocation(scrDim->getWidth()  / 2 - myDim->getWidth()  / 2,
		scrDim->getHeight() / 2 - myDim->getHeight() / 2);
  }

}

// EoF

