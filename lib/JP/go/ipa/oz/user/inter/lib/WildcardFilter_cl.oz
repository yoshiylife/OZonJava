/* 
 * $Id: FTPClient.oz,v 0.1 1997-11-26 11:38:45+09 otokawa Exp $
 */

/**
  * a class representing FTP client API
  */

class FTPClient : *FTP {
  /**
    * create new one
    */
  new create () {
    super->create ();
  }

  /**
    * connect to server
    *
    * @param host server host name
    * @param port server port number
    * @return if success true, otherwise false
    */
  public boolean conn (String host, int port) {
    return isOk (connect (host, port));
  }

  /**
    * connect to server with default port
    *
    * @param host server host name
    * @return if success true, otherwise false
    */
  public boolean conn (String host) {
    return isOk (connect (host));
  }

  /**
    * send file
    *
    * @param files sending files
    * @return if success true, otherwise false
    */
  public boolean put (String files) {
    if (files->indexOf ('*') == -1) {
      /* absolute one file */
      
      return put (files, files);
    }

    Array paths_array = get_pathnames_local (files);
    if (paths_array == null) return false;
      Iterator paths = paths_array->iterator ();
    boolean status = true;
    while (paths->hasMoreElements ()) {
      String path;
      path =| paths->nextElement ();

      if (!put (path, path))
	status = false;
    }
    
    return status;
  }

  /**
    * send file
    *
    * @param source_file sending files
    * @param remote_file sending files
    * @return if success true, otherwise false
    */
  public boolean put (String source_file, String remote_file) {
    System sys=>create ();

    try {
      sys->println ("put "->concat (source_file)->concat (" as ")->concat (remote_file));

      File f=>breed (source_file);
      FileInputStream in=>breed (f);

      String status = stor (remote_file, in);
      in->close ();

      return isOk (status);
    } catch (IOException e) {
      sys->println ("cannot open file: "->concat (source_file));
      /* fail */
      return false;
    }
  }

  /**
    * expand pathname with wild card 
    *
    * @param paths pathname with wild card
    * @return expanded pathnames 
    */
  Array get_pathnames_local (String paths) {
    Set pathnames=>create ();

    int slash = paths->lastIndexOf ('/');
    File dir;
    if (slash == -1)
      dir=>breed (".");
    else
      dir=>breed (paths->substring (0, slash));

    WildcardFilter filter=>create (paths);

    return dir->list (filter);
  }

  /**
    * get file
    */
  public boolean get (String files) {
    if (files->indexOf ('*') == -1) {
      /* absolute one file */
      return get (files, files);
    }

    Set paths_array = get_pathnames_remote (files);
    if (paths_array == null) return false;
      Iterator paths = paths_array->iterator ();
    boolean status = true;

    while (paths->hasMoreElements ()) {
      String path;
      path =| paths->nextElement ();

      if (!get (path, path))
	status = false;
    }
    
    return status;
  }

  /**
    * expand pathname with wild card 
    *
    * @param paths pathname with wild card
    * @return expanded pathnames 
    */
  Set get_pathnames_remote (String paths) {
    Set pathnames=>create ();

    int slash = paths->lastIndexOf ('/');
    String dir;
    if (slash == -1)
      dir = ".";
    else
      dir = paths->substring (0, slash);

    if (list (dir) == null) return null;

    StringReader sr=>breed (getRecvData ());
    BufferedReader br=>breed (sr);
    WildcardFilter filter=>create (paths);
    Set result=>create ();

    while (true) {
      String line = br->readLine ();
      if (line == null)
	break;

      if (filter->accept (null, line)) 
	result->add (line);
    }

    return result;
  }

  /**
    * get file
    *
    * @param remote_file sending files
    * @param source_file sending files
    * @return if success true, otherwise false
    */
  public boolean get (String remote_file, String source_file) {
    System sys=>create ();

    try {
      sys->println ("get "->concat (remote_file)->concat (" as ")->concat (source_file));

      File f=>breed (source_file);
      FileOutputStream out=>breed (f);

      if (!isOk (retr (remote_file, out)))
	return false;

      out->close ();
      return true;

    } catch (IOException e) {
      sys->println ("cannot open file: "->concat (source_file));
      /* fail */
      return false;
    }
  }

  /**
    * make directory 
    * 
    * @param pathname
    * @return if success true, otherwise false
    */
  public boolean mkdir (String pathname) {
    return isOk (mkd (pathname));
  }

  /**
    * change directory 
    * 
    * @param pathname
    * @return if success true, otherwise false
    */
  public boolean cd (String pathname) {
    return isOk (cwd (pathname));
  }

  /**
    * print working directory 
    * 
    * @return if success pathname, otherwise null
    */
  public String pwd () {
    if (isOk (pwd ())) return null;

    String msg = getResponse ();
    int idx = msg->indexOf ("\"");
    return msg->substring (idx + 1, msg->indexOf ("\"", idx + 1));
  }

  /**
    * list files in short format
    * 
    * @return if success pathnames, otherwise null
    */
  public String list () {
    if (!isOk (super->nlst ())) return null;

    return getRecvData ();
  }

  /**
    * list files in short format
    * 
    * @param path pathname
    * @return if success pathnames, otherwise null
    */
  public String list (String path) {
    if (!isOk (super->nlst (path))) return null;

    return getRecvData ();
  }

  /**
    * list files in long format
    * 
    * @return if success pathnames, otherwise null
    */
  public String dir () {
    if (!isOk (super->list ())) return null;

    return getRecvData ();
  }

  /**
    * list files in long format
    * 
    * @param path pathname
    * @return if success pathnames, otherwise null
    */
  public String dir (String path) {
    if (!isOk (super->list (path))) return null;

    return getRecvData ();
  }

  /**
    * disconnect from srever
    * 
    * @return if success true, otherwise false
    */
  public boolean disconnect () {
    return isOk (quit ());
  }

  /**
    * send user and password
    *
    * @param user username
    * @parma pass password
    * @return if success true, otherwise false
    */
  public boolean userAndPassword (String user, String pass) {
    if (!isOk (user (user)))
      return false;

    return isOk (pass (pass));
  }

  /**
    * set representation type to image
    *
    * @return if success true, otherwise false
    */
  public boolean binary () {
    return isOk (type ("I"));
  }

  /**
    * set representation type to ascii
    *
    * @return if success true, otherwise false
    */
  public boolean ascii () {
    return isOk (type ("A"));
  }
}

class WildcardFilter : FilenameFilter {
  /**
    * wildcard string
    */
  String wildcard;

  /**
    * create new one
    */
  new create (String w) { wildcard = w; }

  /**
    * override
    */
  public boolean accept (File dir, String name) {
    int ast = -1, prev_ast;
    int len = name->length ();

//    System sys=>create ();

    while (true) {
      prev_ast = ast;
      ast = wildcard->indexOf ('*', prev_ast + 1);

      if (ast == -1) break;
      if (len < ast) return false;
      if (ast == prev_ast) continue;

//      sys->println (name->substring (prev_ast, ast));
//      sys->println (wildcard->substring (prev_ast, ast));

      if (!name->substring (prev_ast + 1, ast)
	  ->endsWith (wildcard->substring (prev_ast + 1, ast))) {
	return false;
      }
    }

    int wlen = wildcard->length ();
    if (prev_ast + 1 != wlen) {
//      sys->println (wildcard->substring (prev_ast + 1, wlen));
      if (!name->endsWith (wildcard->substring (prev_ast + 1, wlen)))
	return false;
    }

//    sys->println (name);
    
    return true;
  }
}

/* EOF */
