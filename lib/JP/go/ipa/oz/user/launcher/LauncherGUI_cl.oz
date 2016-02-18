// OZ launcher


/**
 * LauncherGUI
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class LauncherGUI
: *Frame
{

  LauncherCore             lCore;
  File                     currentDir;
  String                   topPath;
  String                   fileSeparator;
  GODOperator              godOp;

  // view parts
  LauncherMenuBar          menubar;
  Choice                   directoryChoiceView;
  List                     directoryListView;
  List                     activeCellListView;
  List                     inactiveCellListView;
  String                   titlePrefix;

  System  system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create(LauncherCore lc)
  {
    system => create();
    super => newFrame("OZ Launcher");
    init(lc);
    sync();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void changeDirectory(String dirName)
  {
    File  dir;
    String  path, newPath;

    if (currentDir != null) {
      if (dirName->isequal("[up]")) {
        /* moving to the parent directory */
        path = currentDir->getPath();
        newPath = path->substring(0, path->lastIndexOf(fileSeparator));
        dir => breed(newPath);
      } else {
        dir => breed(currentDir, dirName);
      }

      if (checkDirectory(dir)) {
        currentDir = dir;
        resetTitle();
        sync();
      }
    }
  }


  //--------------------------------------------------------------------
  public void createCell()
  {
    LauncherCellInformationDialog  cellDialog;
    String  path, god;

    path = currentDir->getPath();
    god = godOp->toGOD(path);
    cellDialog => create(lCore, god);
    cellDialog->show();
  }


  //--------------------------------------------------------------------
  public String getPath()
  {
    String  currentPath, path;

    path = null;
    if (currentDir != null) {
      currentPath = currentDir->getPath();
      if (currentPath->startsWith(topPath)) {
        path = currentPath->substring(topPath->length());
        if (path->startsWith(fileSeparator)) {
          path = path->substring(fileSeparator->length());
        }
      }
    }

    return path;
  }


  //--------------------------------------------------------------------
  public String getSelectedCell()
  {
    return inactiveCellListView->getSelectedItem();
  }


  //--------------------------------------------------------------------
  public String getSelectedDirectory()
  {
    return directoryListView->getSelectedItem();
  }


  //--------------------------------------------------------------------
  public void setPath(String path)
  {
  }


  //--------------------------------------------------------------------
  public void sync()
  {
    String  path;

    if (checkDirectory(currentDir)) {
      list(currentDir);
      //setDirectoryChoice(currentDir);
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  boolean checkDirectory(File dir)
  {
    if (dir != null && dir->exists() && dir->isDirectory()) {
      return true;
    } else {
      return false;
    }
  }


  //--------------------------------------------------------------------
  boolean checkGODActivity(File file, String name1)
  {
    Collection  ls;
    Iterator  itr;
    String  name2;

    if (file->isDirectory()) {
      ls = file->list();
      itr = ls->iterator();
      while (itr->hasMoreElements()) {
        name2 =| itr->nextElement();
        if (name2->isequal(name1)) {
          return true;
        }
      }
    }

    return false;
  }


  //--------------------------------------------------------------------
  void clearList()
  {
    directoryListView->removeAll();
    activeCellListView->removeAll();
    inactiveCellListView->removeAll();
  }


  //--------------------------------------------------------------------
  boolean hasSubDirectory(File dir)
  {
    Array  fileList;
    Iterator  itr;
    File  subFile;
    String  fileName;

    if (dir->isDirectory()) {
      fileList = dir->list();
      itr = fileList->iterator();
      while (itr->hasMoreElements()) {
        fileName =| itr->nextElement();
        subFile => breed(dir, fileName);
        if (subFile->isDirectory()) {
          return true;
        }
      }
    }

    return false;
  }


  //--------------------------------------------------------------------
  void init(LauncherCore lc)
  {
    String  ozhomePath, currentPath;
    File  ozhomeDir, dir;

    lCore = lc;

    ozhomePath = system->getOzHome();
    ozhomeDir => breed(ozhomePath);
    fileSeparator = ozhomeDir->getSeparator();
    topPath = ozhomePath->concat(fileSeparator)->concat("objects");

    currentPath = lCore->getPath();
    if (currentPath == null) {
      currentDir => breed(topPath);
    } else {
      currentDir => breed(currentPath);
      if (!checkDirectory(currentDir)) {
        /* the last directory might be deleted */
        currentDir => breed(topPath);
      }
    }

    godOp => create();

    titlePrefix => breed("OZ Launcher - ");
    initGUI();
  }


  //--------------------------------------------------------------------
  void initGUI()
  {
    Label  dirLabel, activeLabel, inactiveLabel;
    GridBagLayout  layout;
    GridBagConstraints  constraints;
    Insets  insets;
    LauncherDirectorySelectListener  dirListener;
    LauncherCellSelectListener  cellListener;
    EventDispatchingQueue  eq;

    // make components
    dirLabel => newLabel(" directories:");
    //directoryChoiceView => newChoice();
    directoryListView => newList();
    eq => create();
    dirListener => create(lCore, eq);
    directoryListView->addActionListener(dirListener);
    inactiveLabel => newLabel(" inactive cells:");
    inactiveCellListView => newList();
    eq => create();
    cellListener => create(lCore, eq);
    inactiveCellListView->addActionListener(cellListener);
    activeLabel => newLabel(" active cells:");
    activeCellListView => newList();
    activeCellListView->setEnabled(false);

    // layout
    layout => newGridBagLayout();
    setLayout(layout);
    constraints=>newGridBagConstraints();
    constraints->setFill(constraints->getBOTH());
    insets=>newInsets(0, 2, 2, 2);
    constraints->setInsets(insets);

    // left column
    constraints->setWeightx(0.2);
    constraints->setWeighty(0.0);
    //layout->setConstraints(directoryChoiceView, constraints);
    layout->setConstraints(dirLabel, constraints);
    constraints->setWeighty(1.0);
    layout->setConstraints(directoryListView, constraints);

    // center column
    constraints->setWeightx(0.4);
    constraints->setWeighty(0.0);
    layout->setConstraints(inactiveLabel, constraints);
    constraints->setWeighty(1.0);
    layout->setConstraints(inactiveCellListView, constraints);

    // right column
    constraints->setGridwidth(constraints->getREMAINDER());
    constraints->setWeightx(0.4);
    constraints->setWeighty(0.0);
    layout->setConstraints(activeLabel, constraints);
    constraints->setWeighty(1.0);
    layout->setConstraints(activeCellListView, constraints);

    //add(directoryChoiceView);
    add(dirLabel);
    add(inactiveLabel);
    add(activeLabel);
    add(directoryListView);
    add(inactiveCellListView);
    add(activeCellListView);
    pack();

    // menu
    menubar => create(lCore);
    setMenuBar(menubar);
  }


  //--------------------------------------------------------------------
  boolean isActiveGOD(File file)
  {
    return checkGODActivity(file, ".location");
  }


  //--------------------------------------------------------------------
  boolean isInactiveGOD(File file)
  {
    return checkGODActivity(file, ".inactive");
  }


  //--------------------------------------------------------------------
  void list(File dir)
  {
    File  subFile;
    Array  fileList;
    String  fileName, path;
    Iterator  itr;

    if (checkDirectory(dir)) {
      clearList();

      // add parent directory
      path = dir->getPath();
      if (!(topPath->isequal(path))) {
        directoryListView->add("[up]");
      }

      fileList = dir->list();
      itr = fileList->iterator();
      while (itr->hasMoreElements()) {
        fileName =| itr->nextElement();
        subFile => breed(dir, fileName);
        if (subFile->isDirectory()) {
          if (isInactiveGOD(subFile)) {
            inactiveCellListView->add(fileName);
            if (hasSubDirectory(subFile)) {
              directoryListView->add(fileName);
            }
          } else if (isActiveGOD(subFile)) {
            activeCellListView->add(fileName);
            if (hasSubDirectory(subFile)) {
              directoryListView->add(fileName);
            }
          } else {
            directoryListView->add(fileName);
          }
        }

        /**
        if (isInactiveGOD(subFile)) {
          inactiveCellListView->add(fileName);
        } else if (isActiveGOD(subFile)) {
          activeCellListView->add(fileName);
        }
        if (hasSubDirectory(subFile)) {
          directoryListView->add(fileName);
        }
        **/
      }
    }
  }


  //--------------------------------------------------------------------
  void resetTitle()
  {
    String  path, god;

    path = currentDir->getPath();
    god = godOp->toGOD(path);
    setTitle(titlePrefix->concat(god));
  }


  //--------------------------------------------------------------------
  void setDirectoryChoice(File dir)
  {
    String  path, dirName;
    int  sepIndex;

    if (checkDirectory(dir)) {
      path = dir->getPath();
      //system->debugPrintln("\tLauncherGUI#setDirectoryChoice: dir path="->concat(path));

      if (path->startsWith(topPath)) {
        //directoryChoiceView->removeAll();
        while (directoryChoiceView->getItemCount() > 0) {
          directoryChoiceView->remove(0);
        }

        directoryChoiceView->add(": (top)");
        path = path->substring(topPath->length());
        //system->debugPrintln("\tLauncherGUI#setDirectoryChoice: start path="->concat(path));

        while (path->length() > 0) {
          //system->debugPrintln("\tLauncherGUI#setDirectoryChoice: path="->concat(path));
          if (path->startsWith(fileSeparator)) {
            path = path->substring(fileSeparator->length());
          }
          sepIndex = path->indexOf(fileSeparator);
          if (sepIndex == -1) {
            directoryChoiceView->add(dirName);
            //system->debugPrintln("\tLauncherGUI#setDirectoryChoice: dir="->concat(dirName));
            break;
          } else {
            dirName = path->substring(0, sepIndex);
            path = path->substring(sepIndex);
            directoryChoiceView->add(dirName);
            //system->debugPrintln("\tLauncherGUI#setDirectoryChoice: dir="->concat(dirName));
          }
        }
      }
    }
    //system->debugPrintln("\tLauncherGUI#setDirectoryChoice: end");
  }



}

// EoF

