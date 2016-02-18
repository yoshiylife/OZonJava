// OZ DEV: Class Browser


/**
 * CBClassList
 *
 * @version  $Id$
 * @author   Akihito Nakamura <akihito@etl.go.jp>
 */

final class CBClassList
  : *List
{

  Array  cidList;  // Array<ClassID>
  CBPartView  partView;
  EventDispatchingQueue  eventQue;
  boolean  forLabel;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new newCBClassList(int size, CBPartView pv)
  {
    super=>newList(size);
    initParams(pv);
    initGUI();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String getCID(int index)
  {
    String  cid;

    cid =| cidList->at(index);

    return cid;
  }


  //--------------------------------------------------------------------
  public void setList(Array cids)
  {
    setList(cids, null, false);
  }


  //--------------------------------------------------------------------
  public void setInterfaceList(Array cids, School school)
  {
    setList(cids, school, true);
  }


  //--------------------------------------------------------------------
  public void setImplementationList(Array cids, School school)
  {
    setList(cids, school, false);
  }


  /////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void initGUI()
  {
    CBClassListListener  listener;

    listener => newCBClassListListener(this, partView, eventQue);
    addActionListener(listener);
  }


  //--------------------------------------------------------------------
  void initParams(CBPartView pv)
  {
    partView = pv;
    eventQue => create();
  }


  //--------------------------------------------------------------------
  void setList(Array cids, School school, boolean isInterface)
  {
    String  cid, label;
    int  length;
    int  i;

    removeAll();
    forLabel = true;
    cidList = cids;
    if (cidList != null) {
      length = cidList->size();
      for (i = 0; i < length; i++) {
        cid =| cidList->at(i);
        if (school == null) {
          add(cid);
        } else {
          if (isInterface) {
            label = school->getNameOfInterface(cid);
          } else {
            label = school->getNameOfImplementation(cid);
          }
          add(label);
        }
      }
    }
  }

}

// EoF


