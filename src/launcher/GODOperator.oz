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

// OZ Launcher


/**
 * GODOperator
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class GODOperator
{

  char        fileSepChar;
  String      topPath;
  System      system;


  ///////////////////////////////////////////////////////// constructors

  //--------------------------------------------------------------------
  new create()
  {
    init();
  }


  /////////////////////////////////////////////////////// public methods

  //--------------------------------------------------------------------
  public String toPath(String god)
  {
    String  path;

    if (god == null) {
      path = null;
    } else {
      path = god->replace('.', fileSepChar);
    }

    return path;
  }


  //--------------------------------------------------------------------
  public String toFullPath(String god)
  {
    String  path;
    StringBuffer  buf;

    if (god == null) {
      path = null;
    } else {
      buf => breed(topPath);
      buf->append(fileSepChar)->append(toPath(god));
      path = buf->asString();
    }

    return path;
  }


  //--------------------------------------------------------------------
  public String toGOD(String path)
  {
    String  absPath;
    String  god;

    if (path == null || path->length() == 0) {
      god = null;
    } else {
      if (path->startsWith(topPath)) {
        /* the path is full-path */
        absPath = path->substring(topPath->length());
        if (absPath->length() > 0 && absPath->charAt(0) == fileSepChar) {
          /* remove the top "." */
          absPath = absPath->substring(1);
        }
      } else {
        absPath => breed(path);
      }
      god = absPath->replace(fileSepChar, '.');
    }

    return god;
  }


  //--------------------------------------------------------------------
  public String toGOD(String path, String name)
  {
    String  god, pre;
    StringBuffer  buf;

    if (path == null) {
      return name;

    } else {
      pre = toGOD(path);
      if (pre == null || pre->length() == 0) {
        god => breed(name);
      } else {
        buf => breed(pre);
        buf->append(".")->append(name);
        god = buf->asString();
      }

      return god;
    }
  }


  ////////////////////////////////////////////////////// private methods

  //--------------------------------------------------------------------
  void init()
  {
    String  ozhome;
    StringBuffer  buf;

    system => create();
    ozhome = system->getOzHome();
    if (ozhome->startsWith("/")) {
      fileSepChar = '/';
    } else {
      fileSepChar = '\\';
    }

    buf => breed(ozhome);
    buf->append(fileSepChar)->append("objects");
    topPath = buf->asString();
  }

}


// EoF

