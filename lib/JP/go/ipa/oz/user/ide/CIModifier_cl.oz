// DEV: Class Browser


/**
 * CIModifier
 * 
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CIModifier
{

  boolean  iAmStatic;       // 0x0008
  boolean  iAmFinal;        // 0x0010
  boolean  iAmLocked;       // 0x0020
  boolean  iAmTransient;    // 0x0080
  boolean  iAmAbstract;     // 0x0400
  boolean  iAmOnce;         // 0x1000
  boolean  iAmCell;         // 0x2000
  int  UPPER;               // 0x4000


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCIModifier(int mods)
  {
    initParams(mods);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String asString()
  {
    StringBuffer  sb;
    int  length;

    sb => breed();
    if (iAmAbstract) {
      sb->append("abstract ");
    }
    if (iAmStatic) {
      sb->append("static ");
    }
    if (iAmFinal) {
      sb->append("final ");
    }
    if (iAmLocked) {
      sb->append("locked ");
    }
    if (iAmTransient) {
      sb->append("transient ");
    }
    if (iAmOnce) {
      sb->append("once ");
    }
    if (iAmCell) {
      sb->append("cell ");
    }

    length = sb->length();
    if (length != 0 && sb->charAt(length - 1) == ' ') {
      sb->setLength(length - 1);
    }

    return sb->asString();
  }


  //--------------------------------------------------------------------
  public boolean isStatic()
  {
    return iAmStatic;
  }


  //--------------------------------------------------------------------
  public boolean isFinal()
  {
    return iAmFinal;
  }


  //--------------------------------------------------------------------
  public boolean isLocked()
  {
    return iAmLocked;
  }


  //--------------------------------------------------------------------
  public boolean isTransient()
  {
    return iAmTransient;
  }


  //--------------------------------------------------------------------
  public boolean isAbstract()
  {
    return iAmAbstract;
  }


  //--------------------------------------------------------------------
  public boolean isOnce()
  {
    return iAmOnce;
  }


  //--------------------------------------------------------------------
  public boolean isCell()
  {
    return iAmCell;
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initParams(int mods)
  {
    int  quot, remain;

    UPPER = 0x4000;
    quot = mods % UPPER;

    quot = quot / 2;
    quot = quot / 2;
    quot = quot / 2;
    remain = quot % 2;                       // 0x0008
    if (remain == 1) { iAmStatic = true; }
    quot = quot / 2;
    remain = quot % 2;                       // 0x0010
    if (remain == 1) { iAmFinal = true; }
    quot = quot / 2;
    remain = quot % 2;                       // 0x0020
    if (remain == 1) { iAmLocked = true; }
    quot = quot / 2;
    quot = quot / 2;
    remain = quot % 2;                       // 0x0080
    if (remain == 1) { iAmTransient = true; }
    quot = quot / 2;
    quot = quot / 2;
    quot = quot / 2;
    remain = quot % 2;                       // 0x0400
    if (remain == 1) { iAmAbstract = true; }
    quot = quot / 2;
    quot = quot / 2;
    remain = quot % 2;                       // 0x1000
    if (remain == 1) { iAmOnce = true; }
    quot = quot / 2;
    remain = quot % 2;                       // 0x2000
    if (remain == 1) { iAmCell = true; }
  }

}

// EoF

