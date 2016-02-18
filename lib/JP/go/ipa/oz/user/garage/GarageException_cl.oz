// OZ garage


/**
 * GarageException
 *
 * @version  0.9
 * @author   A.Nakamura <akihito@etl.go.jp>
 */

class GarageException
: *RuntimeException
{

  new create(String msg)
  {
    super->init(msg);
  }

}


// EoF


