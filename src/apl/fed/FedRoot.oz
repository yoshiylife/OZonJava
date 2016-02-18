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

/* $Id: FedRoot.oz,v 1.3 1998/01/30 07:32:04 hgoto Exp $ */
/*
 * フェデレーション関係のルートクラス
 *
 *	FedRoot <|-- GenusCategory <|-- Autonomy <|-- Federation
 *	FedRoot <|-- フェデレーションのリソース
 */
cell FedRoot
{
    protected System system;
    protected Authenticator auth;
    protected boolean debug;

    protected String className;	// クラス名
	
    public void initialize()
    {
	init();
    }
	
    public void init()
    {
	className = "FedRoot";
	auth => create();
	debugInit();
    }

    public void quiet() {
	flushCell();
    }

    public final void setClassName(String s)
    {
	if (s->isRed()) auth->authorize(s);
	if (debug) system->println("FedRoot#setClassName() enter with "->concat(s));
	className = s;
	if (debug) system->println("FedRoot#setClassName() leave");
    }

    public final String getClassName()
    {
	if (debug) system->println("FedRoot#getClassName() enter & leave");
	return className;
    }

    public final String gol()
    {
	if (debug) system->println("FedRoot#gol() enter & leave");
	return className->getGOL();
    }

    public final String god()
    {
	if (debug) system->println("FedRoot#god() enter & leave");
	return className->getGOD();
    }

    //////////////////////
    ////// デバグ用 //////
    //////////////////////
    public void debugInit()
    {
	system => create();
	debug = false;
    }

    public void debug(boolean flag)
    {
	debug = flag;
    }
}
