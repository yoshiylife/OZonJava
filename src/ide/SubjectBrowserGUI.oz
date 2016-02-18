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

// OZ DEV


/**
 * SubjectBrowserGUI
 *
 * @version  0.2
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class SubjectBrowserGUI
: *Frame
{

  SubjectGarageBrowser            browserCore;
  String                          serverGOL;
  TextField                       serverGOLView;
  List                            listView;  // subject name list
  Array                           summaryList;
  BinaryPredicate                 sortPredicate;


  ///////////////////////////////////////////////////////// constructors

  new create(SubjectGarageBrowser core)
  {
    super => newFrame("SubjectCatalog Browser");
    init(core);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void add(Summary sm)
  {
  }


  //--------------------------------------------------------------------
  public void clear()
  {
    listView->removeAll();
  }


  //--------------------------------------------------------------------
  public SubjectSummary getSelectedSummary()
  {
    int  index;
    SubjectSummary  ss = null;

    index = listView->getSelectedIndex();
    if (index != -1) {
      ss =| summaryList->at(index);
    }

    return ss;
  }


  //--------------------------------------------------------------------
  public void inputSubjectSummary(Subject sbj)
  {
    SubjectSummaryBrowser  ssBrowser;

    ssBrowser => createEditor(sbj, browserCore);
  }


  //--------------------------------------------------------------------
  public void list(Collection smSet)
  {
    int  size, index;
    Iterator  itr;
    SubjectSummary  ss;
    String  name;

    clear();
    size = smSet->size();
    summaryList => create(size);
    itr = smSet->iterator();
    for (index = 0; itr->hasMoreElements(); index++) {
      ss =| itr->nextElement();
      summaryList->putAt(index, ss);
      name = ss->getName();
      listView->add(name);
    }
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
  }


  //--------------------------------------------------------------------
  public void setServerGOL(String gol)
  {
    refreshServerGOL(gol);
  }


  //--------------------------------------------------------------------
  public void sort()
  {
  }


  //--------------------------------------------------------------------
  public void sort(BinaryPredicate prd)
  {
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void refreshServerGOL(String gol)
  {
    if (gol != null) {
      serverGOL = gol;
      serverGOLView->setText(serverGOL);
    }
  }
  

  //--------------------------------------------------------------------
  void init(SubjectGarageBrowser core)
  {
    LessSubjectSummary  less;

    browserCore = core;
    serverGOL = core->getServerGOL();
    if (serverGOL == null) {
      serverGOL => breed("");
    }
    less => create();
    sortPredicate = less;

    initGUI();
  }


  //--------------------------------------------------------------------
  void initGUI()
  {
    Panel  serverPanel, listPanel;
    Label  serverLabel, listLabel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    SubjectSummarySelectListener  ssListener;
    EventDispatchingQueue  eq;

    // layout manager
    layout => newGridBagLayout();
    setLayout(layout);
    constraints=>newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    /*
    insets=>newInsets(4, 4, 4, 4);
    constraints->setInsets(insets);
    */

    // server' GOL panel
    serverPanel => newPanel();
    serverLabel => newLabel("server GOL:");
    serverGOLView => newTextField(serverGOL);
    serverPanel->add(serverLabel);
    serverPanel->add(serverGOLView);
    layout->setConstraints(serverPanel, constraints);

    // subject name list panel
    listPanel => newPanel();
    listView => newList(10);
    listLabel => newLabel("subject list:");
    listPanel->add(listView);
    layout->setConstraints(listPanel, constraints);
    eq => create();
    ssListener => create(browserCore, eq);
    listView->addActionListener(ssListener);

    add(serverPanel);
    add(listPanel);
    pack();
  }

}


// EoF

