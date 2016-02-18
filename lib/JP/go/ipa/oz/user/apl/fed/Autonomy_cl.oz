/* $Id: Autonomy.oz,v 1.3 1998/01/30 07:32:04 hgoto Exp $ */
cell Autonomy : *GenusCategory
{
    protected Dictionary resources;	 //リソース集合
    protected Set federates;		 //Federation集合
    protected Set cache;		 //ResourceProxyのキャッシュテーブル
    protected Set surrogates;
    protected Set surrogatePivots;
    protected Set adapters;
    protected Set adapterPivots;
    protected Set proxies;

    public void init()
    {
	super->init();
	setClassName("Autonomy");
	StringComparator comp=>create();
	ResourceProxyComparator rpcomp => create();
	resources=>create(comp);
	federates=>create(comp);
	cache=>create(rpcomp);
	surrogates=>create(rpcomp);
	surrogatePivots=>create(comp);
	adapters=>create(rpcomp);
	adapterPivots=>create(comp);
	proxies=>create(rpcomp);
    }

    public Dictionary getResources() {
        return resources;
    }

    public Set getFederations() {
        return federates;
    }

    public Set getCache() {
        return cache;
    }

    public Set getSurrogates() {
        return surrogates;
    }

    public Set getSurrogatePivots() {
        return surrogatePivots;
    }

    public Set getAdapters() {
        return adapters;
    }

    public Set getAdapterPivots() {
        return adapterPivots;
    }

    public Set getResourceProxies() {
        return proxies;
    }

    //**************************************************************
    // for Resource
    //**************************************************************
 
    public void addResource(String resource)
    {
	if (resource->isRed()) auth->authorize(resource);
	if (debug) system->println("Autonomy#addResource() enter");
	ResourceLog log => create();
	log->in();
	resources->put(resource, log);
	if (debug) system->println("Autonomy#addResource() leave");
    }

    public void removeResource(String resource)
    {
	if (resource->isRed()) auth->authorize(resource);
	if (debug) system->println("Autonomy#removeResource() enter");
	ResourceLog log;
	log =| resources->get(resource);
	log->out();
	if (debug) system->println("Autonomy#removeResource() leave");
    }

    public boolean containsResource(String resource)
    {
	if (resource->isRed()) auth->authorize(resource);
	if (debug) system->println("Autonomy#containsResource() enter");
	boolean result = false;
	ResourceLog log;
	log =| resources->get(resource);
	if ((log != null) && (log->getOutTime() == null))
	    result = true;
	if (debug) system->println("Autonomy#containsResource() leave");
	return result;
    }

    //**************************************************************
    // for Federation
    //**************************************************************
    public void attachToFederation(String gol)
    {
	if (gol->isRed()) auth->authorize(gol);
	if (debug) system->println("Autonomy#attachToFederation() enter");
	if (federates->contains(gol) == false) { // avoid deadlock
	    federates->add(gol);	// bi-dir
	    Federation fed;
	    fed=>bind(gol);
	    if (debug) system->println(this->gol());
	    fed->addAutonomy(this->gol());
	}
	if (debug) system->println("Autonomy#attachToFederation() leave");
    }

    public void detachFromFederation(String gol)
    {
	if (gol->isRed()) auth->authorize(gol);
	if (debug) system->println("Autonomy#detachFromFederation() enter");
	if (federates->contains(gol)) { // avoid deadlock
	    federates->remove(gol);	// bi-dir
	    Federation fed => bind(gol);
	    if (debug) system->println(this->gol());
	    fed->removeAutonomy(this->gol());
	}
	if (debug) system->println("Autonomy#detachFromFederation() leave");
    }

    //**************************************************************
    // for ResourceProxy
    //
    //              | Destination   | Source
    //  ------------+---------------+---------
    //  Surrogate   |o              |x
    //  Adapter     |x              |o
    //  Relay       |x              |x
    //**************************************************************

    /**
     * ResourceProxyをAutonomyへ登録する。
     *  自Autonomy型 == proxyのAutonomy型であればSurrogateの追加
     *  自Autonomy型 == proxyのResource型であればAdapterの追加
     * さらに、扱い可能なPivotの集合へも登録する。
     */
    public void addResourceProxy(ResourceProxy proxy)
    {
	proxies->add(proxy);
	if (proxy->isRed()) auth->authorize(proxy);
	if (debug) system->println("Autonomy#addResourceProxy() enter");
	String autoType = proxy->getAutonomyType();
	String resType = proxy->getResourceType();
	if (isMemberOf(autoType)) {
            if (debug) system->println("autoType is member of this autonomy");
	    surrogates->add(proxy);
	    surrogatePivots->add(resType);
	} else {
	    adapters->add(proxy);
	    adapterPivots->add(autoType);
	}
	if (debug) system->println("Autonomy#addResourceProxy() leave");
    }

    /**
     * ResourceProxyをAutonomyから削除する。
     *  自Autonomy型 == proxyのAutonomy型であればSurrogateの削除
     *  自Autonomy型 == proxyのResource型であればAdapterの削除
     * さらに、扱い可能なPivotの集合からも削除する。
     */
    public void removeResourceProxy(ResourceProxy proxy)
    {
	proxies->remove(proxy);
	if (proxy->isRed()) auth->authorize(proxy);
	if (debug) system->println("Autonomy#removeResourceProxy() enter");
	String autoType = proxy->getAutonomyType();
	String resType = proxy->getResourceType();
	if (isMemberOf(autoType)) {
	    surrogates->remove(proxy);
	    surrogatePivots->remove(resType);
	} else {
	    adapters->remove(proxy);
	    adapterPivots->remove(autoType);
	}
	if (debug) system->println("Autonomy#removeResourceProxy() leave");
    }

    //**************************************************************
    // for Converter
    //**************************************************************

    /**
     * リソースを自Autonomyで扱う型へ変換する。
     * 1) 最初に変換を行うResourceProxyをキャッシュの中で探す。
     * 2) もし、キャッシュの中にない場合には、新たにResourceProxyを生成する。
     *  a)直接変換できない場合には、リソースを中間データ型(pivot)に
     *    変換したものを変換する。
     *  b)生成したResourceProxyをキャッシングする
     */
    public ResourceProxy importResource(String resGol, String pivot)
    {
	if (resGol->isRed()) auth->authorize(resGol);
	if (pivot != null) {
		if (pivot->isRed()) auth->authorize(pivot);
	}
	if (debug) system->println("Autonomy#importResource() enter");
	ResourceProxy proxy = getResourceProxyByCache(resGol);
	if (proxy == null) {
	    FedRoot res => bind(resGol);
	    String resType = res->getClassName();
	    proxy = getResourceProxy(resType, pivot, getType());
	    if (proxy != null) {
		proxy->setResource(resGol);
		setResourceProxyToCache(proxy);
	    }
	}
	if (debug) system->println("Autonomy#importResource() leave");
	return proxy;
    }

    /**
     * リソースを自Autonomyで扱う型へ変換する。(中間データ型未指定)
     */
    public ResourceProxy importResource(String gol)
    {
	if (gol->isRed()) auth->authorize(gol);
	if (debug) system->println("Autonomy#importResource() enter & leave");
	return importResource(gol, null);
    }

    /**
     * 自Autonomyで扱う型のリソースを、指定された中間データ型のいずれかに
     * 変換するためのResourceProxyを提供する。
     * 提供するResourceProxyはオリジナルを複製したものである。
     */
    public ResourceProxy exportResource(Set pivots)
    {
	Iterator it;
	String str;
	String pivot;
	it = pivots->iterator();
	pivot =| it->nextElement();

	if (pivots->isRed()) auth->authorize(pivots);
	if (debug) system->println("Autonomy#exportResource() enter");

	if (debug) {
	    system->println("----- Autonomy#exportResource()");
	    Iterator it = pivots->iterator();
	    Root element;
	    while (it->hasMoreElements()) {
		element = it->nextElement();
		system->println(element);
	    }
	    system->println("-----");
	    it = adapterPivots->iterator();
	    while (it->hasMoreElements()) {
		element = it->nextElement();
		system->println(element);
	    }
	    system->println("-----");
	}

	//Set list = adapterPivots->intersect(pivots);
	Set list;
	list=>create();
	if (adapterPivots->contains(pivot)) {
		list->add(pivot);
	}

	if ( list->size() >0 ) {
		it = list->iterator();
		str =| it->nextElement();
	} 

	if (0 < list->size()) {

	    if (debug) system->println("Autonomy#exportResource() found");
	    Iterator iter = list->iterator();
	    String pivot;
	    pivot =| iter->nextElement();
	    ResourceProxy adapter = findAdapter(getType(), pivot);
	    if (adapter != null) {
		adapter = adapter->instanciate();
		if (debug) system->println("Autonomy#exportResource() leave");
		return adapter;
	    } 
	}
	if (debug) system->println("Autonomy#exportResource() leave with null");
	return null;
    }

   /**
    * 1) リソースを、一度中間データ型に変換後、目的の型(autoType)に
    *    変換するオブジェクトを取得する。
    *   a)最初に自Autonomyで登録されているResourceProxyのみで対応できるものを
    *     調べる。
    *   b)自Autonomy内で対応できない場合には、Federationを仲介させ、
    *     対応可能な中間データ型のリストをの中のいずれかに変換可能な
    *     ResourceProxyを他のAutonomyより取得する。
    * 2) 取得したResourceProxyを対象とするリソース専用にインスタンス化する。
    */
    public ResourceProxy getResourceProxy(String resType, String pivot, String autoType)
    {
	if (resType->isRed()) auth->authorize(resType);
	if (pivot !=null) {
		if (pivot->isRed()) auth->authorize(pivot);
	}
	if (autoType->isRed()) auth->authorize(autoType);
	if (debug) system->println("Autonomy#getResourceProxy() enter");
	ResourceProxy proxy = findSurrogate(resType, autoType);
	ResourceProxy adapter = null;
	if (proxy == null) {
	    if (pivot != null) { // pivot 指定
		StringComparator sc;
		sc=>create();
		Set pivots=>create(sc);
		pivots->add(pivot);
		adapter = getAdapter(resType, pivots);
	    } else { // pivot 無指定
		String str;
		Iterator iter;
		iter = surrogatePivots->iterator();
		str =| iter->nextElement();
		adapter = getAdapter(resType, surrogatePivots);
	    }
	    if (adapter != null) {
		resType = adapter->getResourceType();
		proxy = findSurrogate(resType, autoType);
		if (proxy == null) {
			proxy=>create();
			proxy->setResourceType(resType);
			proxy->setAutonomyType(autoType);
			// addResourceProxy(proxy);
		}
	    }
	}
	if (proxy == null) {
	    if (debug) system->println("Autonomy#getResourceProxy() leave with null");
	    return null;
	}
	if (debug) system->println("Autonomy#getResourceProxy() leave");
	return proxy->instanciate(adapter); // chain
    }


    /**
     * resType型のリソースをautoType型のリソースとして扱うためのResourceProxyを
     * 引数(proxies)で指定されたResourceProxyのテーブルより求める。
     */
    public ResourceProxy findResourceProxy(Set proxs, String resType, String autoType)
    {
	if (proxies->isRed()) auth->authorize(proxies);
	if (resType->isRed()) auth->authorize(resType);
	if (autoType->isRed()) auth->authorize(autoType);
	if (debug) system->println("Autonomy#findResourceProxy() enter");
	Iterator iter = proxs->iterator();
	while (iter->hasMoreElements()) {
	    ResourceProxy proxy;
	    proxy =| iter->nextElement();
	    if (proxy->isAcceptable(autoType, resType)) {
		if (debug) system->println("Autonomy#findResourceProxy() leave");
		return proxy;
	    }
	}
	if (debug) system->println("Autonomy#findResourceProxy() leave with null");
	return null;
    }

    /**
     * 他Autonomyで扱われる型(resType)を、自Autonomyで扱う型(autoType)と
     * みなすためのResourceProxyを取得する。
     */
    public ResourceProxy findSurrogate(String resType, String autoType)
    {
	if (resType->isRed()) auth->authorize(resType);
	if (autoType->isRed()) auth->authorize(autoType);
	if (debug) system->println("Autonomy#findSurrogate() enter");
	ResourceProxy proxy = findResourceProxy(surrogates, resType, autoType);
	if (debug) system->println("Autonomy#findSurrogate() leave");
	return proxy;
    }

    /**
     * 自Autonomyで扱う型(autoType)を、他Autonomyで扱う型(resType)と
     * みなすためのResourceProxyを取得する。
     */
    public ResourceProxy findAdapter(String autoType, String resType)
    {
	if (resType->isRed()) auth->authorize(resType);
	if (autoType->isRed()) auth->authorize(autoType);
	if (debug) system->println("Autonomy#findAdapter() enter");
	ResourceProxy proxy = findResourceProxy(adapters, autoType, resType);
	if (debug) system->println("Autonomy#findAdapter() leave");
	return proxy;
    }

    /**
     * 他Autonomyで扱われる型(resType)を、自Autonomyで変換可能な型(pivots)の
     * いずれかにみなすことができるResourceProxyを、Federationを仲介させて
     * 取得する。
     */
    public ResourceProxy getAdapter(String resType, Set pivots)
    {
	if (resType->isRed()) auth->authorize(resType);
	if (pivots != null) {
		if (pivots->isRed()) auth->authorize(pivots);
	}
	if (debug) system->println("Autonomy#getAdapter() enter");
	Iterator iter = federates->iterator();
	ResourceProxy adapter;
	while (iter->hasMoreElements()) {
	    String gol;
	    gol =| iter->nextElement();
	    Federation fed => bind(gol);
	    adapter = fed->getAdapter(resType, pivots);
	    if (adapter != null) {
		if (debug) system->println("Autonomy#getAdapter() leave");
		return adapter;
	    }
	}
	if (debug) system->println("Autonomy#getAdapter() leave with null");
	return null;
    }

    //**************************************************************
    // cache of ResourceProxy
    //**************************************************************
    public ResourceProxy getResourceProxyByCache(String resGol)
    {
	if (resGol->isRed()) auth->authorize(resGol);
	if (debug) system->println("Autonomy#getResourceProxyByCache() enter");
	if (debug) {
	    if (resGol != null)
		system->println( "resGol = "->concat(resGol));
	    else
		system->println( "resGol = null");
	}
	Iterator iter = cache->iterator();
	while (iter->hasMoreElements()) {
	    ResourceProxy proxy;
	    proxy =| iter->nextElement();
	    if (debug) {
		if (proxy->getResource() != null)
		    system->println("cache = "->concat(proxy->getResource()));
		else
		    system->println("cache = null");
	    }
	    if (resGol->isequal(proxy->getResource())) {
		if (debug) system->println("Autonomy#getResourceProxyByCache() leave");
		return proxy;
	    }
	}
	if (debug) {
	    system->println("----- Autonomy#getResourceProxyByCache()");
	    Iterator it = cache->iterator();
	    while (it->hasMoreElements()) {
		Root element = it->nextElement();
		system->println(element->asString());
	    }
	    system->println("-----");
	}

	if (debug) system->println("Autonomy#getResourceProxyByCache() leave with null");
	return null;
    }

    public void setResourceProxyToCache(ResourceProxy proxy)
    {
	if (proxy->isRed()) auth->authorize(proxy);
	if (debug) system->println("Autonomy#setResourceProxyToCache() enter");
	cache->add(proxy);
	if (debug) {
	    system->println("----- Autonomy#setResourceProxyToCache()");
	    Iterator it = cache->iterator();
	    while (it->hasMoreElements()) {
		Root element = it->nextElement();
		system->println(element->asString());
	    }
	    system->println("-----");
	}

	if (debug) system->println("Autonomy#setResourceProxyToCache() leave");
    }

    /**
     * Flush ResourceProxy Cache
     */
    public void flushCache()
    {
	if (debug) system->println("Autonomy#flushCache() enter");
	ResourceProxyComparator rpcomp => create();
	cache => create(rpcomp);
	if (debug) {
	    system->println("----- Autonomy#flushCache()");
	    Iterator it = cache->iterator();
	    while (it->hasMoreElements()) {
		Root element = it->nextElement();
		system->println(element->asString());
	    }
	    system->println("-----");
	}

	if (debug) system->println("Autonomy#flushCache() leave");
    }

    /**
     * 引数で指定されたリソースのResourceProxyキャッシュをフラッシュする。
     */
    public void flushCache(String resGol)
    {
	if (resGol->isRed()) auth->authorize(resGol);
	if (debug) system->println("Autonomy#flushCache(String) enter");
	ResourceProxy proxy = getResourceProxyByCache(resGol);
	if (proxy != null)
	    cache->remove(proxy);
	if (debug) {
	    system->println("----- Autonomy#flushCache(String)");
	    Iterator it = cache->iterator();
	    while (it->hasMoreElements()) {
		Root element = it->nextElement();
		system->println(element->asString());
	    }
	    system->println("-----");
	}

	if (debug) system->println("Autonomy#flushCache(String) leave");
    }

	public String asString() {
		return "["->concat(className)->concat("]")
			->concat("Category : ")->concat(categoryName)
			->concat("Type : ")->concat(type);
	}

}
