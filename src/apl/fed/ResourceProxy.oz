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

/* $Id: ResourceProxy.oz,v 1.3 1998/01/30 07:32:05 hgoto Exp $ */
/**
 * Resource型変換オブジェクト
 */
class ResourceProxy : *Root
{
    protected String resource;
    protected ResourceProxy previous;
    protected String autoType;
    protected String resType;

    protected System system;

    new create()
    {
	system => create();
	resource = "Null";
	previous = null;
	autoType = "Null";
	resType = "Null";
    }

    public void setPrevious(ResourceProxy prev)
    {
	// system->println("ResourceProxy#setPrevious() enter");
	if (prev->isRed()) turnGreen(prev);
	previous = prev;
	// system->println("ResourceProxy#setPrevious() leave");
    }

    public ResourceProxy getPrevious()
    {
	// system->println("ResourceProxy#getPrevious() enter & leave");
	return previous;
    }

    public void setResource(String resGol)
    {
	// system->println("ResourceProxy#setResource(gol) enter");
	if (resGol->isRed()) turnGreen(resGol);
	resource = resGol;
	if (previous != null)
	    previous->setResource(resource);
	// system->println("ResourceProxy#setResource(gol) leave");
    }

    public String getResource()
    {
	// system->println("ResourceProxy#setResource() enter");
	if (resource != null) {
	    // system->println("ResourceProxy#setResource() leave");
	    return resource;
	} else if (previous != null) {
	    // system->println("ResourceProxy#setResource() leave with previous");
	    return previous->getResource();
	}
	// system->println("ResourceProxy#setResource() leave with null");
	return null;
    }

    public void setAutonomyType(String type)
    {
	// system->println("ResourceProxy#setAutonomyType() enter");
	if (type->isRed()) turnGreen(type);
	autoType = type;
	// system->println("ResourceProxy#setAutonomyType() leave");
    }

    public String getAutonomyType()
    {
	// system->println("ResourceProxy#getAutonomyType() enter & leave");
	return autoType;
    }

    public void setResourceType(String type)
    {
	// system->println("ResourceProxy#setResourceType() enter");
	if (type->isRed()) turnGreen(type);
	resType= type;
	// system->println("ResourceProxy#setResourceType() leave");
    }

    public String getResourceType()
    {
	// system->println("ResourceProxy#getResourceType() enter & leave");
	return resType;
    }

    public boolean isAcceptable(String aType, String rType)
    {
	// system->println("ResourceProxy#isAcceptable() enter");
	if (aType->isRed()) turnGreen(aType);
	if (rType->isRed()) turnGreen(rType);
	if (autoType != null && aType != null && resType != null && rType != null) {
	    if (autoType->isequal(aType) && resType->isequal(rType)) {
		// system->println("ResourceProxy#isAcceptable() leave");
		return true;
	    }
	}
	// system->println("ResourceProxy#isAcceptable() leave");
	return false;
    }

    public ResourceProxy instanciate()
    {
	// system->println("ResourceProxy#instanciate() enter");
	ResourceProxy proxy;
	proxy=>create();
	if (resource != null) proxy->setResource(resource);
	if (autoType != null) proxy->setAutonomyType(autoType);
	if (resType != null)  proxy->setResourceType(resType);
	// system->println("ResourceProxy#instanciate() leave");
	return proxy;
    }

    public ResourceProxy instanciate(ResourceProxy prev)
    {
	// system->println("ResourceProxy#instanciate(proxy) enter");
	ResourceProxy proxy = instanciate();
	if (prev != null)
	    proxy->setPrevious(prev);
	// system->println("ResourceProxy#instanciate(proxy) leave");
	return proxy;
    }

    public String asString()
    {
	return "ResourceProxy[autoType = "->
		concat(autoType)->
		concat(", resType = ")->
		concat(resType)->
		concat("]");
    }

    public void toGreen()
    {
	if (resource != null && resource->isRed()) turnGreen(resource);
	if (previous != null && previous->isRed()) turnGreen(previous);
	if (previous != null) previous->toGreen();
	if (autoType != null && autoType->isRed()) turnGreen(autoType);
	if (resType != null && resType->isRed()) turnGreen(resType);
	if (system != null && system->isRed()) turnGreen(system);
    }

    public boolean isEqual(ResourceProxy rp) {
	if ( autoType->isequal(rp->getAutonomyType())
	  && resType->isequal(rp->getResourceType())
	  && resource->isequal(rp->getResource()))
	    return true;
	return false;
    }
}
