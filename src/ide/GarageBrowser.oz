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
 * GarageBrowser
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class GarageBrowser
{

  String       serverGOL;
  SGarage      server;

  
  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create()
  {
  }


  //--------------------------------------------------------------------
  new create(String gol)
  {
    bindServer(gol);
  }


  /////////////////////////////////////////////////////// public methods


  //--------------------------------------------------------------------
  public void bindServer(String gol) 
  {
    IllegalArgumentException  argEx;

    if (isValidGOL(gol)) {
      serverGOL = gol;
      server => bind(serverGOL);
    } else {
      argEx => init("Invalid GOL");
      throw argEx;
    }
  }


  //--------------------------------------------------------------------
  public Summarizable get(Key key)
  {
    checkKey(key);
    return server->get(key);
  }


  //--------------------------------------------------------------------
  public String getServerGOL()
  {
    return serverGOL;
  }


  //--------------------------------------------------------------------
  public SGarage getServer()
  {
    return server;
  }


  //--------------------------------------------------------------------
  public void launch()
  {
  }


  //--------------------------------------------------------------------
  public Key put(Summarizable sbl)
  {
    return server->put(sbl);
  }


  //--------------------------------------------------------------------
  public Key put(Summarizable sbl, Summary sm)
  {
    Key  key;

    sbl->setSummary(sm);
    key = server->put(sbl);

    return key;
  }


  //--------------------------------------------------------------------
  public void quit()
  {
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
    checkKey(key);
    server->remove(key);
  }


  //--------------------------------------------------------------------
  public void replace(Key key, Summarizable sbl)
  {
    checkKey(key);
    server->replace(key, sbl);
  }


  //--------------------------------------------------------------------
  public void replaceSummary(Key key, Summary sm)
  {
    checkKey(key);
    server->replaceSummary(key, sm);
  }


  //--------------------------------------------------------------------
  public void setVisible(boolean v)
  {
  }


  //--------------------------------------------------------------------
  public void sync()
  {
  }


  //////////////////////////////////////////////////// protected methods

  //--------------------------------------------------------------------
  protected boolean isValidGOL(String gol)
  {
    if (gol == null || gol->length() == 0) {
      return false;
    } else {
      return true;
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void checkKey(Key key)
  {
    IllegalArgumentException  argEx;

    if (key == null) {
      argEx => init("Null key");
      throw argEx;
    }
  }


}


// EoF

