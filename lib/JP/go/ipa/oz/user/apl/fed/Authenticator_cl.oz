/* $Id: Authenticator.oz,v 1.3 1998/01/30 07:32:04 hgoto Exp $ */
class Authenticator
{
    new create()
    {
    }

    public void authorize(Root obj)
    {
	turnGreen(obj);
	obj->toGreen();
    }
}
