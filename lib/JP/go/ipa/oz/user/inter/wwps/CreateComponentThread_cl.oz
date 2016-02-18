/*
 * $Id: ComponentServer.oz,v 0.10 1998-01-30 11:04:17+09 otokawa Exp $
 */

/**
  * a class of component server
  */

class ComponentServer {
  /**
    * statring service
    *
    * @param c OZCGI Server
    */
  public void start (OzCGI c) {
    ComponentReceiver cr=>create (c, "WWPS_COMPONENT");
    Thread th=>create (cr);
  }

  /**
    * statring service for testing (one operation)
    *
    * @param c OZCGI Server
    */
  public void startForTest (OzCGI c) {
    ComponentReceiver cr=>createForTest (c, "WWPS_COMPONENT", 1);
    Thread th=>create (cr);
    th->join ();
  }

  /**
    * statring service for testing (some operation)
    *
    * @param c OZCGI Server
    * @param count operation count
    */
  public void startForTest (OzCGI c, int count) {
    ComponentReceiver cr=>createForTest (c, "WWPS_COMPONENT", count);
    Thread th=>create (cr);
    th->join ();
  }

  /**
    * create new one
    */
  new create () {
  }
}

/**
  * a class for receiving request for component
  */
class ComponentReceiver : *ReceiveThread {
  /**
    * override 
    */
  protected void dispatch () {
    String command;
    command =| html->getValue ("command");

    if (command == null) {
      sendResult ("your request is illegal.");
      return;
    }    
    
    if (command->isequal ("create")) {
      /* create component */
      CreateComponentThread runnable=>create (cgi, html);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

     } else if (command->isequal ("create_test")) {
      /* create component */
      CreateComponentThread runnable=>createForTest (cgi, html);
      Thread th = createThread (runnable);
      th->join ();

    } else if (command->isequal ("browse")) {
      /* browse component */
      BrowseComponentThread runnable=>create (cgi, html);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

    } else if (command->isequal ("browse_subject")) {
      /* browse component */
      BrowseComponentThread runnable=>create (cgi, html);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

    } else if (command->isequal ("search")) {
      /* search component */
      SearchComponentThread runnable=>create (cgi, html);
      Thread th = createThread (runnable);
      if (test_mode) th->join ();

    } else {
      sendResult ("your request is illegal.");
      return;
    }
  }

  /**
    * create new one
    *
    * @param c OZCGI Server
    * @param sel selector string
    */
  new create (OzCGI c, String sel) { 
    super=>create (c, sel); 
  }

  /**
    * create new one for testing
    *
    * @param c OZCGI Server
    * @param sel selector string
    * @param count operation count
    */
  new createForTest (OzCGI c, String sel, int count) { 
    super=>create (c, sel); 
    test_mode = true;
    operation_count = count;
  }
}

/**
  * a class for creating component
  */
class CreateComponentThread : *WWPSExecuteThread {
  /**
    * override 
    */
  public void run () {
    String catalog_name;
    catalog_name =| html->getValue ("catalog");
    SubjectGarage catalog;
    if (catalog_name != null) 
      catalog=>bind (catalog_name);

    String subject_name;
    subject_name =| html->getValue ("subject");
    School sc = extractSchool (subject_name, "release_school");
    Subject subject = sc->getSubject (subject_name);

    String sum;
    sum =| html->getValue ("summary");
    SubjectSummary summary=>create (subject_name, sum);
    subject->setSummary (summary);

    if (!release_compile (sc, subject, subject_name)) {
      return;
    }

    if (test_mode) {
      send_subject_contents (subject);
      return;
    }

    try {
      catalog->put (subject);
      sendResult ("registered");
    } catch (CellNotFoundException e) {
      sendResult ("cannot found catalog");
    }
  }

  /**
    * compilation for release
    *
    * @param sc school
    * @param subject subject
    * @param sbj_name subject_name
    * @return if fail false, otherwise true
    */
  boolean release_compile (School sc, Subject subject,
			   String sbj_name) {
    Set sources=>create ();
    String source;
    try {
       source = extractSource (sources);
    } catch (String src) {
      sendResult ("illegal file: "->concat (src));
      return false;
    }

    if (source == null) {
      Iterator it = sources->iterator ();
      if (!it->hasMoreElements ()) {
	sendResult ("no source was specified");
	return false;
      }
      
      source =| it->nextElement ();
    }

    String dir;
    CompilerAgent ozc;

    try {
      File src=>breed (source);
      dir = src->getParent ()->concat (src->getSeparator ());

      ozc=>create (extractSchool (sbj_name, "school"));
      StringWriter log=>breed ();
      if (!ozc->compileSubjectForRelease (dir, log)) {
	sendResult ("compilation for release was failed");
	return false;
      }

      sc->toReleasState (sbj_name);
      ozc->setSchool (sc);

      String package_name = subject->getPackageName (); 

      if (!ozc->release (dir, 3, "wwps-release"))
	return false;
      File file=>breed (ozc->getReleaseDir ()->concat ("wwps-release.zip"));
      try {
	LocalRepositoryManager localMgr=>create ();
	localMgr->add (file, package_name);
      } catch (SecurityException e) {
	sendResult ("Local repository already has this subject");
	return false;
      }
    } finally {
      ozc->deleteAllFiles ();
      File f=>breed (dir);
      f->delete ();
    }

    return true;
  }

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new create (OzCGI c, HTMLData h) {
    super=>create (c, h);
  }

  /**
    * create new one for testing
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new createForTest (OzCGI c, HTMLData h) {
    super=>create (c, h);
    test_mode = true;
  }

  /**
    * send subjet contents for test
    */
  void send_subject_contents (Subject sbj) {
    String subject_name = sbj->getSubjectName ();

    html->startOutput ("text/html");
    html->beginTag ("html");
    html->beginTag ("head");
    html->beginTag ("title");
    html->addOutput (subject_name);
    html->endTag ();
    html->endTag ();

    html->beginTag ("body");

    html->beginTag ("h1");
    html->addOutput (subject_name);
    html->endTag ();

    String pakage = sbj->getPackageName ();
    html->beginTag ("h3");
    html->addOutput (pakage);
    html->endTag ();

    html->beginTag ("pre");

    Dictionary labels = sbj->getOzLabels ();
    Iterator it = labels->iterator ();
    StringBuffer buf=>breed ();
    while (it->hasMoreElements ()) {
      OzLabel ozlabel;
      ozlabel =| it->nextElement ();
      String label = ozlabel->getOzLabelName ();
      String if_id = ozlabel->getInterfaceID ();
      String impl_id = ozlabel->getImplementationID ();
	
      buf->append ('\"');
      buf->append (label);
      buf->append ("\",\"");
      buf->append (if_id);
      buf->append ("\",\"");
      buf->append (impl_id);
      buf->append ("\"\n");

      html->addOutput (buf->asString ());

      buf->setLength (0);
    }
      
    html->endOutput ();
    cgi->sendResult (html);
  }
}

/**
  * a class for browsing component
  */
class BrowseComponentThread : *ExecuteThread {
  /**
    * override 
    */
  public void run () {
    String catalog_name;
    catalog_name =| html->getValue ("catalog");
    SubjectGarage catalog=>bind (catalog_name);

    String subject_name;
    subject_name =| html->getValue ("subject");
    if (subject_name == null)
      create_list (catalog, catalog_name);
    else
      create_list (catalog, catalog_name, subject_name);
  }

  /**
    * create output list of subject contents
    * 
    * @param catalog catalog cell
    * @param catalog_name catalog name
    * @param subject_name subject name 
    */
  void create_list (SubjectGarage catalog, String catalog_name,
		    String subject_name) {
    String sbj_key;
    sbj_key =| html->getValue ("key");
    Key key=>create (sbj_key->parseInt ());

    Subject sbj;

    try {
      sbj = catalog->getSubject (key);
    } catch (CellNotFoundException e) {
      sendResult ("cannot found catalog: "->concat (catalog_name));
      return;
    }

    String mode;
    mode =| html->getValue ("mode");

    boolean send_file = false;
    if (mode->isequal ("get"))
      send_file = true;

    String file_name, school_file;
    FileWriter file;
    if (send_file) {
      file_name = subject_name->concat (".s");
      school_file = createPath (file_name);
      file=>breed (school_file);
    } else {
      html->startOutput ("text/html");
      html->beginTag ("html");
      html->beginTag ("head");
      html->beginTag ("title");
      html->addOutput (subject_name);
      html->endTag ();
      html->endTag ();

      html->beginTag ("body");

      html->beginTag ("h1");
      html->addOutput (subject_name);
      html->endTag ();

      String pakage = sbj->getPackageName ();
      html->beginTag ("h3");
      html->addOutput (pakage);
      html->endTag ();

      html->beginTag ("pre");
    }

    Dictionary labels = sbj->getOzLabels ();
    Iterator it = labels->iterator ();
    StringBuffer buf=>breed ();
    while (it->hasMoreElements ()) {
      OzLabel ozlabel;
      ozlabel =| it->nextElement ();
      String label = ozlabel->getOzLabelName ();
      String if_id = ozlabel->getInterfaceID ();
      String impl_id = ozlabel->getImplementationID ();
	
      buf->append ('\"');
      buf->append (label);
      buf->append ("\",\"");
      buf->append (if_id);
      buf->append ("\",\"");
      buf->append (impl_id);
      buf->append ("\"\n");

      if (send_file) 
	file->write (buf->asString (), 0, buf->length ());
      else
	html->addOutput (buf->asString ());

      buf->setLength (0);
    }
      
    if (send_file) {
      file->close ();

      File f=>breed (school_file);
      FileInputStream in=>breed (f);
      int size;
      size =| f->length ();
      sendFile (in, file_name, size);
      
      f->delete ();
      f=>breed (f->getParent ())->delete ();
    } else {
      html->endTag (); 
      html->endTag (); 
      html->endOutput ();
      cgi->sendResult (html);
    }
  }
    
  /**
    * create output list of subjects
    * 
    * @param catalog catalog cell
    * @param catalog_name catalog name
    */
  void create_list (SubjectGarage catalog, String catalog_name) {
    Iterator it;
    try {
      it = catalog->summaryIterator ();
    } catch (CellNotFoundException e) {
      sendResult ("cannot found catalog: "->concat (catalog_name));
      return;
    }

    html->startOutput ("text/html");
    html->beginTag ("html");
    html->beginTag ("head");
    html->beginTag ("title");
    html->addOutput (catalog_name);
    html->endTag ();
    html->endTag ();

    html->beginTag ("body");

    html->beginTag ("h1");
    html->addOutput (catalog_name);
    html->endTag ();

    html->beginTag ("dl");

    while (it->hasMoreElements ()) {
      SubjectSummary summary;
      summary =| it->nextElement ();

      String name = summary->getName ();
      if (name == null) continue;

      html->addTag ("dt");

      html->addOutput (name);
      html->addOutput (" ");
      StringBuffer buf=>breed ("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=look&subject=");
      buf->append (name);
      buf->append ("&key=");
      buf->append (summary->getKey ()->asString ());
      buf->append ("&catalog=");
      buf->append (catalog_name);
      buf->append ('\"');
      html->beginTag (buf->asString ());
      html->addOutput ("Look");
      html->endTag ();
      html->addOutput (" ");
      buf->setLength (0);
      buf=>breed ("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=get&subject=");
      buf->append (name);
      buf->append ("&key=");
      buf->append (summary->getKey ()->asString ());
      buf->append ("&catalog=");
      buf->append (catalog_name);
      buf->append ('\"');
      html->beginTag (buf->asString ());
      html->addOutput ("Get");
      html->endTag ();

      html->addTag ("dd");
      html->addOutput (summary->getDescription ());
    }

    html->endTag (); 
    html->endTag (); 
    html->endOutput ();

    cgi->sendResult (html);
  }

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new create (OzCGI c, HTMLData h) {
    super=>create (c, h);
  }
}

/**
  * a class for searching component
  */
class SearchComponentThread : *ExecuteThread {
  /**
    * override 
    */
  public void run () {
    String catalog_name;
    catalog_name =| html->getValue ("catalog");
    SubjectGarage catalog=>bind (catalog_name);

    String keyword;
    keyword =| html->getValue ("keyword");

    create_list (catalog, keyword, catalog_name);
  }

  /**
    * create output list
    *
    * @param catalog catalog cell
    * @param key key word
    * @param catalog_name catalog name
    */
  void create_list (SubjectGarage catalog, String key, String catalog_name) {
    Iterator it;
    try {
      it = catalog->summaryIterator ();
    } catch (CellNotFoundException e) {
      sendResult ("cannot found catalog: "->concat (catalog_name));
      return;
    }

    html->startOutput ("text/html");
    html->beginTag ("html");
    html->beginTag ("head");
    html->beginTag ("title");
    html->addOutput (catalog_name);
    html->endTag ();
    html->endTag ();

    html->beginTag ("body");

    html->beginTag ("h1");
    html->addOutput (catalog_name);
    html->endTag ();

    html->beginTag ("dl");

    int found = 0;
    while (it->hasMoreElements ()) {
      SubjectSummary summary;
      summary =| it->nextElement ();

      if (summary->getName ()->indexOf (key) > -1 ||
	  summary->getDescription ()->indexOf (key) > -1) {
	String name = summary->getName ();
	if (name == null) continue;

	html->addTag ("dt");

	html->addOutput (name);
	html->addOutput (" ");
	StringBuffer buf=>breed ("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=look&subject=");
	buf->append (name);
	buf->append ("&key=");
	buf->append (summary->getKey ()->asString ());
	buf->append ("&catalog=");
	buf->append (catalog_name);
	buf->append ('\"');
	html->beginTag (buf->asString ());
	html->addOutput ("Look");
	html->endTag ();
	html->addOutput (" ");
	buf->setLength (0);
	buf=>breed ("a href=\"oz.cgi?.formId=WWPS_COMPONENT&command=browse_subject&mode=get&subject=");
	buf->append (name);
	buf->append ("&key=");
	buf->append (summary->getKey ()->asString ());
	buf->append ("&catalog=");
	buf->append (catalog_name);
	buf->append ('\"');
	html->beginTag (buf->asString ());
	html->addOutput ("Get");
	html->endTag ();

	html->addTag ("dd");
	html->addOutput (summary->getDescription ());
	found++;
      }
    }

    html->endTag (); 
    if (found == 0) 
      html->addOutput ("cannot found");
    html->endTag (); 
    html->endOutput ();

    cgi->sendResult (html);
  }

  /**
    * create new one
    * 
    * @param c OZCGI Server
    * @param h reuest data
    */
  new create (OzCGI c, HTMLData h) {
    super=>create (c, h);
  }
}

/* EOF */
