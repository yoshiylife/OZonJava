// OZ DEV: Class Browser


/**
 * CBMemberLabel
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBMemberLabel
  : *Label
{

  CIMember  targetMember;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBMemberLabel(String label)
  {
    if (label == null) {
      super=>newLabel("");
    } else {
      super=>newLabel(label);
    }
    system => create();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public CIMember getMember()
  {
    return targetMember;
  }


  //--------------------------------------------------------------------
  public void setMember(CIMember m)
  {
    targetMember = m;
  }

}

// EoF

