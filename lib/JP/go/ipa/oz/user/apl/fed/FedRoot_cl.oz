/* $Id: FedRoot.oz,v 1.3 1998/01/30 07:32:04 hgoto Exp $ */
/*
 * �ե��ǥ졼�����ط��Υ롼�ȥ��饹
 *
 *	FedRoot <|-- GenusCategory <|-- Autonomy <|-- Federation
 *	FedRoot <|-- �ե��ǥ졼�����Υ꥽����
 */
cell FedRoot
{
    protected System system;
    protected Authenticator auth;
    protected boolean debug;

    protected String className;	// ���饹̾
	
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
    ////// �ǥХ��� //////
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
