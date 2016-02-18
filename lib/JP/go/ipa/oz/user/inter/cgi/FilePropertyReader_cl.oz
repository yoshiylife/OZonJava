/*
 * $Id: FilePropertyReader.oz,v 0.1 1998-01-22 16:59:03+09 otokawa Exp $
 */

/**
  * a class for reader and evaluator of property file
  */

abstract class FilePropertyReader {
  /**
    * evaluator read value pairs
    *
    * @param label label string
    * @param value value string
    */
  public abstract void eval (String label, String value);
}

/* EOF */
