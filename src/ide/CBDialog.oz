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

