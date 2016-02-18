// OZ Launcher


/**
 * LauncherException
 *
 * @version  0.8
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class LauncherException
: *RuntimeException
{

  new create(String msg)
  {
    super->init(msg);
  }

}


// EoF


