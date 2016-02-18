// OZ launcher


/**
 * LauncherCore
 *
 * @version  1.1
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class LauncherCore
{

  LauncherGUI            gui;
  String                 currentPath;  // absolute path from OZHOME
  System                 system;
  GODOperator            godOp;
  char                   fileSepChar;  // system dependent file separator
  String                 ozHomePathName;
  String                 GODPathName;  // absolute pathname of launcher's GOD 
  String                 createScriptName, startScriptName;
  String                 createScriptPathName, startScriptPathName;

  String                 catalogGOL;



  ///////////////////////////////////////////////////////// constructors

  new create()
  {
    system => create();
    init();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public void changeDirectory(String dirName)
  {
    gui->changeDirectory(dirName);
  }


  //--------------------------------------------------------------------
  public void createCell()
  {
    gui->createCell();
  }


  //--------------------------------------------------------------------
  public void createCell(String cid)
  {
  }


  /**-------------------------------------------------------------------
   * creates a cell instance.
   */
  public void createCell(String god, String cid)
  {
    Process  oz;
    StringBuffer  cmd;
    String  godPath;
    File  scriptFile;
    LauncherException  lEx;

    if (god != null && cid != null) {
      system->debugPrintln("\tLauncherCore#createCell: GOD="->concat(god));
      system->debugPrintln("\tLauncherCore#createCell: CID="->concat(cid));

      godPath = GOD2PathName(god);
      system->debugPrintln("\tLauncherCore#createCell: dir="->concat(godPath));

      if (fileSepChar == '/') {
        //cmd => breed("oz -n -f ");
        cmd => breed("oz -f ");
      } else {
        //cmd => breed("oz.bat -n -f ");
        cmd => breed("oz.bat -f ");
      }
      cmd->append(createScriptPathName)->append(" ")->append(god)
        ->append(" ")->append(cid);
      system->debugPrintln("\tLauncherCore#createCell: cmd="->concat(cmd->asString()));
      oz => create(cmd->asString());
      gui->sync();

    } else {
      system->debugPrintln("\tLauncherCore#createCell: null GOD or CID");
    }

  }


  //--------------------------------------------------------------------
  public String getCatalogGOL()
  {
    return catalogGOL;
  }


  //--------------------------------------------------------------------
  public Frame getGUI()
  {
    return gui;
  }


  //--------------------------------------------------------------------
  public String getPath()
  {
    return currentPath;
  }


  //--------------------------------------------------------------------
  public void installScriptFiles()
  {
    mkScriptFiles();
  }


  //--------------------------------------------------------------------
  public void launch()
  {
    resetPath();
    if (gui == null) {
      gui => create(this);
    }
    gui->show();
  }


  //--------------------------------------------------------------------
  public void quit()
  {
    if (gui != null) {
      gui->dispose();
      gui = null;
    }
  }


  //--------------------------------------------------------------------
  public void setCatalogGOL(String gol)
  {
    catalogGOL = gol;
  }


  //--------------------------------------------------------------------
  public void setPath(String path)
  {
    if (path != null) {
      currentPath = path;
    }
  }


  //--------------------------------------------------------------------
  public void startCell()
  {
    String  name, path, god;

    name = gui->getSelectedCell();
    if (name != null) {
      path = gui->getPath();
      god = godOp->toGOD(path, name);
      startCell(god);
    }
  }


  //--------------------------------------------------------------------
  public void startCell(String god)
  {
    Process  oz;
    StringBuffer  cmd;
    String  dirPath;
    LauncherException  lEx;

    if (god != null) {
      system->debugPrintln("\tLauncherCore#startCell: GOD="->concat(god));
      dirPath = GOD2PathName(god);
      if (fileSepChar == '/') {
        cmd => breed("oz -f ");
      } else {
        cmd => breed("oz.bat -f ");
      }
      cmd->append(startScriptPathName)->append(" ")->append(god);
      system->debugPrintln("\tLauncherCore#activateCell: cmd="->concat(cmd->asString()));
      oz => create(cmd->asString());
      gui->sync();

    } else {
      system->debugPrintln("\tLauncherCore#startCell: null GOD");
    }

  }


  /**-------------------------------------------------------------------
   * stops this launcher.
   */
  public void stop()
  {
    currentPath = gui->getPath();
    stopCell();
  }


  /**-------------------------------------------------------------------
   * synchronizes the view with current GODs.
   */
  public void sync()
  {
    if (gui != null) {
      gui->sync();
    }
  }


  ////////////////////////////////////////////////////// private methods

  /**-------------------------------------------------------------------
   * converts a GOD to a pathname.
   */
  String GOD2PathName(String god)
  {
    StringBuffer  path;
    String  godAsPath;

    if (god != null) {
      godAsPath = god->replace('.', fileSepChar);
      path => breed(ozHomePathName);
      path->append(fileSepChar)->append("objects")
        ->append(fileSepChar)->append(godAsPath);

      system->debugPrintln("\tLauncherCore#GOD2PathName: path="->concat(path->asString()));

      return path->asString();

    } else {
      return null;
    }
  }


  /**-------------------------------------------------------------------
   * initalizes instance variables.
   * This method should be invoked exactly onec at the start time.
   */
  void init()
  {
    godOp => create();
    startScriptName => breed("startrc");
    createScriptName => breed("createrc");
    resetPath();
    mkScriptFiles();
  }


  /**-------------------------------------------------------------------
   * installs a file.
   */
  void installFile(String pathname, String content)
  {
    File  file;
    FileOutputStream  fout;
    OutputStreamWriter  osw;
    BufferedWriter  bw;
    StringBuffer  filePath;

    file => breed(pathname);
    if (file->exists()) {
      file->delete();
    }
    try {
      fout => breed(file);
      osw => breed(fout);
      bw => breed(osw);
      bw->write(content, 0, content->length());
      bw->close();
      osw->close();
      fout->close();
    } catch (IOException ex) {
      system->debugPrintln("\tLauncherCore#installFile: IOException");
      throw ex;
    }
  }


  /**-------------------------------------------------------------------
   * creates script files to create and start cells.
   */
  void mkScriptFiles()
  {
    StringBuffer  scriptDirPath;
    String  scriptFilePath;
    StringBuffer  script;

    scriptDirPath => breed(GODPathName);
    scriptDirPath->append(fileSepChar);

    // create script
    scriptFilePath = (scriptDirPath->asString())->concat(createScriptName);
    script => breed("create $1 $2;\n");
    script->append("watch $1;\n");
    script->append("shutdown;\n");
    installFile(scriptFilePath, script->asString());

    // start script
    scriptFilePath = (scriptDirPath->asString())->concat(startScriptName);
    script => breed("go $1;\n");
    script->append("watch $1;\n");
    installFile(scriptFilePath, script->asString());

  }


  /**-------------------------------------------------------------------
   * resets the pathname of own GOD and the file separater character.
   * This method is invoked everytime when this launcher is started.
   */
  void resetPath()
  {
    String  god, godAsPath;
    StringBuffer  buf;

    ozHomePathName = system->getOzHome();
    if (ozHomePathName->startsWith("/")) {
      fileSepChar = '/';
    } else {
      fileSepChar = '\\';
    }
    god = getGOD();
    godAsPath = god->replace('.', fileSepChar);

    buf => breed(ozHomePathName);
    buf->append(fileSepChar)->append("objects")
      ->append(fileSepChar)->append(godAsPath);
    GODPathName = buf->asString();

    // script pathnames
    buf => breed(GODPathName);
    buf->append(fileSepChar)->append(createScriptName);
    createScriptPathName = buf->asString();
    buf => breed(GODPathName);
    buf->append(fileSepChar)->append(startScriptName);
    startScriptPathName = buf->asString();
  }

}


// EoF

