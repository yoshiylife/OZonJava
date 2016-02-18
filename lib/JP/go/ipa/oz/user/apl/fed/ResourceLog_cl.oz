/* $Id: ResourceLog.oz,v 1.3 1998/01/30 07:32:05 hgoto Exp $ */
class ResourceLog : *Root
{
    Date incoming;
    Date outgoing;

    protected System system;

    new create()
    {
	system => create();
	incoming = null;
	outgoing = null;
    }

    public void in()
    {
	// system->println("ResourceLog#in() enter");
	incoming => breed();
	// system->println("ResourceLog#in() leave");
    }

    public void out()
    {
	// system->println("ResourceLog#out() enter");
	outgoing => breed();
	// system->println("ResourceLog#out() leave");
    }

    public Date getInTime()
    {
	// system->println("ResourceLog#getInTime() enter & leave");
	return incoming;
    }

    public Date getOutTime()
    {
	// system->println("ResourceLog#getOutTime() enter & leave");
	return outgoing;
    }

    public void toGreen()
    {
	if (incoming != null && incoming->isRed()) turnGreen(incoming);
	if (outgoing != null && outgoing->isRed()) turnGreen(outgoing);
    }
}
