/* $Id: GenusCategory.oz,v 1.3 1998/01/30 07:32:04 hgoto Exp $ */
cell GenusCategory : *FedRoot
{
    protected String categoryName;	// カテゴリ名
    protected String type;		// カテゴリタイプ

    public void quiet()
    {
	flushCell();
    }

    public void init()
    {
	super->init();
	categoryName = null;
	type = null;
    }

    public void setCategoryName(String s)
    {
	if (s->isRed()) auth->authorize(s);
	if (debug) system->println("GenusCategory#setCategoryName() enter");
	categoryName = s;
	if (debug) system->println("GenusCategory#setCategoryName() leave");
    }

    public String getCategoryName()
    {
	if (debug) system->println("GenusCategory#getCategoryName() enter & leave");
	return categoryName;
    }

    public void setType(String s)
    {
	if (s->isRed()) auth->authorize(s);
	if (debug) system->println("GenusCategory#setType() enter");
 	type = s;
	if (debug) system->println("GenusCategory#setType() leave");
    }

    public String getType()
    {
	if (debug) system->println("GenusCategory#getType() enter & leave");
	return type;
    }

    /**
     * 引数のカテゴリタイプで表されるリソースが、当該GenusCategoryの対象と
     * するものかを調べる。
     */
    public boolean isMemberOf(String s)
    {
	boolean result;
	if (s->isRed()) auth->authorize(s);
	if (debug) system->println("GenusCategory#isMemberOf() enter");
	if (type == null) {
		return false;
	} else {
		result = type->isequal(s);
	}
	if (debug) system->println("GenusCategory#isMemberOf() leave");
	return result;
    }
}
