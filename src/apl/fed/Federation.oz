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

/* $Id: Federation.oz,v 1.3 1998/01/30 07:32:04 hgoto Exp $ */
cell Federation : *Autonomy
{
    Dictionary autos;	// ����: Autonomy GOL, ��: Autonomy ���ƥ��꥿����

    public void init()
    {
	super->init();
	setClassName("Federation");
	StringComparator comp=>create();
	autos => create(comp, comp);
    }

    public Dictionary getAutonomies() {
        return autos;
    }
    //**************************************************************
    // for Autonomy
    //**************************************************************

    /**
     * Federation��Autonomy����Ͽ���롣
     * ����ˡ�bi-dir���׵ᤵ��뤿��ˡ�Autonomy��Federation����Ͽ���롣
     * ���λ���deadlock���򤱤뤿��ˡ��ǽ�˼�Federation���Autonomy��
     * ��Ͽ����Ƥ��ʤ�����Ĵ�٤롣
     */
    public void addAutonomy(String autonomy)
    {
	if (autonomy->isRed()) auth->authorize(autonomy);
	if (debug) system->println("Federation#addAutonomy() enter");
	if ( ! autos->containsKey(autonomy)) {
	    Autonomy auto => bind(autonomy);
	    autos->put(autonomy, auto->getType());
	    if (debug) system->println(this->gol());
	    auto->attachToFederation(this->gol());
	}
	if (debug) system->println("Federation#addAutonomy() leave");
    }

    /**
     * Federation����Autonomy�������롣
     * addRemove()��Ʊ�ͤ�deadlock���θ����Autonomy����Federation�������롣
     */
    public void removeAutonomy(String autonomy)
    {
	if (autonomy->isRed()) auth->authorize(autonomy);
	if (debug) system->println("Federation#removeAutonomy() enter");
	if (autos->containsKey(autonomy)) {
	    autos->remove(autonomy);
	    Autonomy auto => bind(autonomy);
	    if (debug) system->println(this->gol());
	    auto->detachFromFederation(this->gol());
	}
	if (debug) system->println("Federation#removeAutonomy() leave");
    }

    //**************************************************************
    // for Adapter
    //**************************************************************

    /**
     * resType���Υ��֥������Ȥ���֥ǡ����� pivots �Τ����줫���Ѵ��Ǥ���
     * ResourceProxy��������롣
     *
     * 1)   �ǽ�ˡ�Federation����Ͽ����Ƥ���Autonomy�Τ�����
     *      resType���򰷤����Ȥ��Ǥ���Autonomy���Ф��� pivots���Ϥ���
     *      ������Ф��륢���ץ�(ResourceProxy)��������롣
     * 2)   �������Autonomy�ˤ⡢��Ū�Υ����ץ����ʤ��ä����ˤϡ�
     *      Federation�ν�ͭ��������Ѥ�ResourceProxy���������
     *      �����𤷤ƺ���Autonomy�Υ����ץ���������롣
     *      ����Ѥ�ResourceProxy�����Ѥ�����ˤϡ�Federation�ˤ����ơ�
     *      ����ʣ������������Autonomy����᤿�����ץ�����³���롣
     */
    public ResourceProxy getAdapter(String resType, Set pivots)
    {
	if (resType->isRed()) auth->authorize(resType);
	if (pivots->isRed()) auth->authorize(pivots);
	if (debug) system->println("FedRoot#getAdapter() enter");
	ResourceProxy adapter;
	Iterator it;
	String str;
	it = pivots->iterator();
	str =| it->nextElement();

	Iterator iter = autos->assocIterator();
	while (iter->hasMoreElements()) {
	    Association assoc;
	    assoc =| iter->nextElement();
	    String type;
	    type =| assoc->value();
	    if (resType->isequal(type)) {
		String resGol;
		resGol =| assoc->key();
		Autonomy auto => bind(resGol);
		adapter = auto->exportResource(pivots); // instanciated
		if (adapter != null) {
		    if (debug) system->println("Federation#getAdapter() leave 1");
		    return adapter;         
		}
	    }
	}
    
	// ��� 
	Set list = getRelayPivots(pivots);
	it = list->iterator();
	str =| it->nextElement();
	if (0 < list->size()) {
	    adapter = getAdapter(resType, list); // recursive
	    if (adapter != null) {
		ResourceProxy proxy = findRelayProxy(pivots, adapter);
		if (proxy != null) {
		    if (debug) system->println("Federation#getAdapter() leave 2");
		    proxy = proxy->instanciate(adapter);
		    proxy->setResourceType(adapter->getResourceType());
		    return proxy;
		}
	    }
	}
	if (debug) system->println("Federation#getAdapter() leave with null");
	return null;
    }

    /**
     * Surrogate�������֥ǡ��������б����� Federation �������ResourceProxy��
     * ������ǽ�ʷ��Υꥹ�Ȥ��������롣
     */
    Set getRelayPivots(Set pivots)
    {
	if (pivots->isRed()) auth->authorize(pivots);
	if (debug) system->println("FedRoot#getRelayPivots() enter");
	Iterator it;
	String pivot;
	Set list;
	StringComparator sc;

	it = pivots->iterator();
	pivot =| it->nextElement();
	sc=>create();
	list=>create(sc);
	if (adapterPivots->contains(pivot)) {
		list->add(pivot);
	}

	pivots => create();
	Iterator iter = adapters->iterator();
	while (iter->hasMoreElements()) {
	    ResourceProxy adapter;
	    adapter =| iter->nextElement();
	    String autoType = adapter->getAutonomyType();
	    if (list->contains(autoType))
		pivots->add(adapter->getResourceType());
	}
	if (debug) system->println("Federation#getRelayPivots() leave");
	return pivots;
    }

    /**
     * Surrogate�������֥ǡ������ȡ������ץ������򤹤�
     * Federation �� ResourceProxy ����롣
     */
    public ResourceProxy findRelayProxy(Set pivots, ResourceProxy adapter)
    {
	if (pivots->isRed()) auth->authorize(pivots);
	if (adapter->isRed()) auth->authorize(adapter);
	if (debug) system->println("FedRoot#findRelayProxy() enter");
	String autoType = adapter->getAutonomyType();
	Iterator iter = adapters->iterator();
	while (iter->hasMoreElements()) {
	    ResourceProxy proxy;
	    proxy =| iter->nextElement();
	    if (autoType->isequal(proxy->getResourceType()) &&
		pivots->contains(proxy->getAutonomyType())) {
		if (debug) system->println("Federation#findRelayProxy() leave");
		return proxy;
	    }
	}
	if (debug) system->println("Federation#findRelayProxy() leave with null");
	return null;
    }
}
