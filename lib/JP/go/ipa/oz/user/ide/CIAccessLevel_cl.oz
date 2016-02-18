// DEV: Class Browser


/**
 * CIAccessLevel
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIAccessLevel
{

  boolean  iAmPublic;       // 0x0001
  boolean  iAmProtected;    // 0x0004
  int  UPPER;               // 0x4000


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIAccessLevel(int mods)
  {
    initParams(mods);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    if (iAmPublic) {
      return "public";
    } else if (iAmProtected) {
      return "protected";
    } else {
      return "";
    }
  }


  //--------------------------------------------------------------------
  public boolean isPublic()
  {
    return iAmPublic;
  }


  //--------------------------------------------------------------------
  public boolean isProtected()
  {
    return iAmProtected;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initParams(int mods)
  {
    int  quot, remain;

    UPPER = 0x4000;
    quot = mods % UPPER;

    remain = quot % 2;                       // 0x0001
    if (remain == 1) { iAmPublic = true; }
    quot = quot / 2;
    quot = quot / 2;
    remain = quot % 2;                       // 0x0004
    if (remain == 1) { iAmProtected = true; }
  }

}

// EoF

