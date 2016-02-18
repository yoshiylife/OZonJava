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
 * ApplicationGarageBrowserGUI
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class ApplicationGarageBrowserGUI
: *Frame
{

  ApplicationGarageBrowser        gBrowser;
  String                          serverGOL;
  TextField                       serverGOLView;
  List                            listView;  // subject name list
  Array                           summaryList;
  BinaryPredicate                 sortPredicate;


  ///////////////////////////////////////////////////////// constructors

  new create(ApplicationGarageBrowser agb)
  {
    super => newFrame("Application Catalog Browser");
    init(agb);
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void add(ApplicationSummary summary)
  {
    int  size;

    if (summaryList == null) {
      size = 1;
      summaryList => create(size);
    } else {
      size = summaryList->size() + 1;
      summaryList->resize(size);
    }
    summaryList->putAt(size - 1, summary);
    listView->add(summary->getName());
  }


  //--------------------------------------------------------------------
  public void clear()
  {
    listView->removeAll();
    summaryList = null;
  }


  //--------------------------------------------------------------------
  public ApplicationSummary getSelectedSummary()
  {
    int  index;
    ApplicationSummary  summary = null;

    index = listView->getSelectedIndex();
    if (index != -1) {
      summary =| summaryList->at(index);
    }

    return summary;
  }


  //--------------------------------------------------------------------
  public void inputSummary(Application app)
  {
    ApplicationSummaryBrowser  summaryBrowser;

    summaryBrowser => createEditor(app, gBrowser);
  }


  //--------------------------------------------------------------------
  public void list(Collection summarySet)
  {
    int  size, index;
    Iterator  itr;
    ApplicationSummary  summary;

    if (summarySet != null) {
      clear();
      size = summarySet->size();
      summaryList => create(size);
      itr = summarySet->iterator();
      for (index = 0; itr->hasMoreElements(); index++) {
        summary =| itr->nextElement();
        summaryList->putAt(index, summary);
        listView->add(summary->getName());
      }
    }
  }


  //--------------------------------------------------------------------
  public void remove(Key key)
  {
    int  size, idx, rmidx;
    Key  key2;
    KeyComparator  cmp;
    ApplicationSummary  summary;

    if (summaryList != null) {
      size = summaryList->size();
      cmp => create();
      rmidx = -1;
      for (idx = 0; idx < size; idx++) {
        summary =| summaryList->at(idx);
        key2 = summary->getKey();
        if (cmp->compare(key, key2)) {
          rmidx = idx;
          break;
        }
      }

      if (rmidx != -1) {
        listView->remove(rmidx);
        for (idx = rmidx + 1; idx < size; idx++) {
          summaryList->putAt(idx - 1, summaryList->at(idx));
        }
        summaryList->resize(size - 1);
      }
    }
  }


  //--------------------------------------------------------------------
  public void setServerGOL(String gol)
  {
    refreshServerGOL(gol);
  }


  //--------------------------------------------------------------------
  public void setVisible(boolean v)
  {
    super->setVisible(v);
    if (v) {
      if (serverGOL == null || serverGOL->length() == 0) {
        requestGOL();
      }
    }
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
  void init(ApplicationGarageBrowser gb)
  {
    LessApplicationSummary  less;

    gBrowser = gb;
    serverGOL = gBrowser->getServerGOL();
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
    Insets  insets;
    ApplicationSummarySelectListener  selectListener;
    EventDispatchingQueue  eq;
    ApplicationGarageBrowserMenuBar  menubar;

    layout => newGridBagLayout();
    setLayout(layout);

    // layout constraints
    constraints => newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(1.0);
    insets => newInsets(0, 0, 0, 0);
    constraints->setInsets(insets);

    // server' GOL panel
    serverPanel => newPanel(layout);
    insets->set(10, 10, 5, 10);
    layout->setConstraints(serverPanel, constraints);
    insets->set(0, 0, 0, 0);

    serverLabel => newLabel("server GOL:");
    serverGOLView => newTextField(serverGOL, 50);
    layout->setConstraints(serverLabel, constraints);
    layout->setConstraints(serverGOLView, constraints);
    serverPanel->add(serverLabel);
    serverPanel->add(serverGOLView);

    // application name list panel
    listPanel => newPanel(layout);
    constraints->setWeighty(1.0);
    insets->set(10, 10, 5, 10);
    layout->setConstraints(listPanel, constraints);
    constraints->setWeighty(0.0);
    insets->set(0, 0, 0, 0);

    listLabel => newLabel("application list:");
    listView => newList(10);
    layout->setConstraints(listLabel, constraints);
    constraints->setWeighty(1.0);
    layout->setConstraints(listView, constraints);
    listPanel->add(listLabel);
    listPanel->add(listView);

    selectListener => create(gBrowser);
    listView->addActionListener(selectListener);

    add(serverPanel);
    add(listPanel);
    pack();

    // menu
    menubar => create(gBrowser);
    setMenuBar(menubar);
  }


  //--------------------------------------------------------------------
  void refreshServerGOL(String gol)
  {
    if (gol != null) {
      serverGOL = gol;
    } else {
      serverGOL => breed("");
    }
    serverGOLView->setText(serverGOL);
  }
  

  //--------------------------------------------------------------------
  void requestGOL()
  {
    StringInputDialog  dialog;
    GOLInputListenerForApplication  listener;
    EventDispatchingQueue  eq;

    eq => create();
    listener => create(gBrowser, eq);
    dialog => create(this, "GOL Input Dialog", "catalog GOL:", 50, true);
    dialog->addStringInputListener(listener);
    dialog->show();
  }

}


// EoF

