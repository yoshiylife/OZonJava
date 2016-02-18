/* $Id: ResourceProxyComparator.oz,v 1.3 1998/01/30 07:32:05 hgoto Exp $ */
class ResourceProxyComparator : Comparator
{
    System system;

    new create()
    {
	system=>create();
    }

    public boolean compare(Root obja, Root objb)
    {
	if ((obja == null) || (objb == null)) {
		//system->println("Null Object");
		return false;
	}

	ResourceProxy proxya; proxya =| obja;
	ResourceProxy proxyb; proxyb =| objb;

	// system->println("proxya.AutonomyType:"->concat(proxya->getAutonomyType()));
	// system->println("proxya.ResourceType:"->concat(proxya->getResourceType()));
	// system->println("proxyb.AutonomyType:"->concat(proxyb->getAutonomyType()));
	// system->println("proxyb.ResourceType:"->concat(proxyb->getResourceType()));

	if (((proxya->getAutonomyType())->isequal(proxyb->getAutonomyType()))
	  && ((proxya->getResourceType())->isequal(proxyb->getResourceType()))
	  && ((proxya->getResource())->isequal(proxyb->getResource())))
	    return true;
	return false;
    }

    public int hash(Root obj)
    {
	StringComparator stc;
	ResourceProxy rp;
	String str;

        rp =| obj;
	stc=>create();

	str=rp->asString();
	return stc->hash(str);
    }

    public Comparator duplicate()
    {
	ResourceProxyComparator comp => create();
	return comp;
    }
}
