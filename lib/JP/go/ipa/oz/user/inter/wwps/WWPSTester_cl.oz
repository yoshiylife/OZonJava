/*
 * $Id: WWPSTester.oz,v 0.4 1997-12-05 17:33:40+09 otokawa Exp $
 */


/*
 * for testing of WWPServer 
 */
cell WWPSTester {
  /**
    * log 
    */
  String log_file;

  /**
    * override
    */
  protected void initialize () {
    System sys=>create ();
    Array args = sys->getArguments ();
    log_file =| args->at (0);
    FileWriter fw=>breed (log_file);
    PrintWriter log=>breed (fw);

    log->println ("initialize");

    int size = args->size ();
    if (size > 1) {
      log->println ("arguments");
      for (int i = 1; i  < size; i++) {
	String buf;
	buf =| args->at (i);
	log->println (buf);
      }
    }

    log->close ();
  }

  /**
    * override
    */
  public void go () {
    FileWriter fw=>breed (log_file, true);
    PrintWriter log=>breed (fw);

    log->println ("go");

    for (int i = 0; i < 100; i++)
      log->println ("dummy"->valueOf (i));

    log->close ();

    stopCell ();
  }

  /**
    * override
    */
  public void quiet () {
    flushCell ();
  }
}
