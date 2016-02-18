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
