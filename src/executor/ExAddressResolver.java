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

/*
 * $Id: ExAddressResolver.java,v 2.1 1997/12/04 04:55:19 yoshi Exp $
 *
 */

package	JP.go.ipa.oz.system;

import	java.io.DataInputStream;
import	java.io.DataOutputStream;
import	java.io.IOException;
import	java.io.InterruptedIOException;
import	java.lang.InterruptedException;
import	java.net.InetAddress;
import	java.net.Socket;
import	java.net.URL;
import	java.net.UnknownHostException;
import	java.util.Dictionary;
import	java.util.Enumeration;
import	java.util.Hashtable;

/**
 * OzHomeResolver ���̿���Ԥ��ۤʤ�OZ�ۡ���֤Ǥ��̿����ɥ쥹����Ԥ���
 * ���Υ��饹��Ȥäƺ������줿���֥������Ȥϡ�OzHomeResolver�ȣ��У���
 * �ط��������OzHomeResolver �ؤ��̿����ɥ쥹����׵��OzHomeResolver
 * ����α����δƻ��Ԥ������Υ��֥������Ȥϡ�OzHomeResolver �����
 * ������ƻ뤹�룱�ĤΥ���åɤ�������Ե��ơ��֥��ȤäƱ������б�����
 * ����åɤ����Ρʥǥ����ѥå��ˤ��롣OzHomeResolver �Ȥ��̿��˥��顼��
 * ȯ��������硢�Ե��ơ��֥��Ȥä��Ե���Υ���åɤ��̿����顼�����Τ��롣
 *
 * @version	$Revision: 2.1 $, $Date: 1997/12/04 04:55:19 $
 * @author	Yasumitsu Yoshida
 */
final
class ExAddressResolver
extends Thread
{
    /**
     * ���������塼�������ΥǥХå���
     */
    static final String CN = "ExAddressResolver";

    /**
     * ���Υ��饹�ΥǥХå��ѥե饰
     */
    protected static boolean debug
	= (System.getProperty(ExAddressResolver.class.getName()+".debug") != null) ? true : false;

    /**
     * OzHomeResolver ����α����Υ����ॢ���Ȼ��֡��áˤ�ɽ��ʸ����
     */
    static final String timeoutProperty
	= System.getProperty("oz.resolve.timeout");

    /**
     * OzHomeResolver ����α����Υ����ॢ���Ȼ��֡ʥߥ��á�
     */
    static final long resolveTIMEOUT
	= ((timeoutProperty != null) ? Long.parseLong(timeoutProperty) : 30 ) * 1000; /* default */

    /**
     * �̿����ɥ쥹���Υ�ȥ饤�����ɽ��ʸ����
     */
    static final String retryProperty
	= System.getProperty("oz.resolve.retry");

    /**
     * �̿����ɥ쥹���Υ�ȥ饤�����ɽ��ʸ����
     */
    static final int resolveRETRY
	= (retryProperty != null) ? Integer.parseInt(retryProperty) : 5; /* default */

    /**
     * OzHomeResolver ���̿����ɥ쥹�ʥ����Хݡ��ȡˤ�ɽ��ʸ����
     */
    static final String resolverProperty
	= System.getProperty("oz.home.resolver");

    /**
     * OzHomeResolver �Σգң̷������̿����ɥ쥹�ʥ����Хݡ��ȡ�
     * <DL><DT>
     * ����ա�<DD>
     * ���ꤵ��ʤ����ͤ� null�ˤ��Ȥ⤢�롣
     * </DL>
     */
    static final String resolverURL
	= (resolverProperty != null) ? "http://"+resolverProperty+"/" : null;

    /**
     * �̿����ɥ쥹����׵���Υ���
     */
    static final String requestTag = "REQ";

    /**
     * �̿����ɥ쥹��������������Υ���
     */
    static final String successResponseTag = "RES";

    /**
     * �̿����ɥ쥹��輺�Ա������Υ���
     */
    static final String failureResponseTag = "NA";

    /**
     * ̵�����Ȥ򼨤�IP���ɥ쥹
     */
    static final String  nothingHostAddress = "0.0.0.0";

    /**
     * �꥾��С����ݻ������ѿ�(resolver)����¾����˻��Ѥ��롣
     */
    private static final Object lock = new Object();

    /**
     * OzHomeResolver���б�����꥾��С����ݻ�����
     */
    private static ExAddressResolver resolver = null;

    /**
     * ���餫�����꤬ȯ���������Ȥ򼨤��ե饰
     */
    private boolean trouble = false;

    /**
     * OzHomeResolver ����α����Υ����ॢ���Ȼ��֡ʥߥ��á�
     */
    private final long timeout;

     /**
      * OzHomeResolver �Ȥ�TCP���ͥ������Υ����å�
      */
     private final Socket socket;

     /**
      * OzHomeResolver �ؤΥǡ��������ѥ��ȥ꡼��
      */
     private final DataInputStream in;

     /**
      * OzHomeResolver ����Υǡ��������ѥ��ȥ꡼��
      */
     private final DataOutputStream out;

    /**
     * OzHomeResolver ����α������Ԥĥơ��֥���Ե��ơ��֥��
     */
    private Dictionary standbys = new Hashtable();

    protected static
    void debug(String methodName, String message)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message);
	    } else {
		Executor.syslog(CN, methodName, message);
	    }
	}
    }

    protected static
    void debug(String methodName, Throwable ball)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, ball);
	    } else {
		Executor.syslog(CN, methodName, ball);
	    }
	}
    }

    protected static
    void debug(String methodName, String message, Throwable ball)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message, ball);
	    } else {
		Executor.syslog(CN, methodName, message, ball);
	    }
	}
    }

    /**
     * OzHomeResolver ���̿���Ԥ��ۤʤ�OZ�ۡ���֤Ǥ��̿����ɥ쥹����Ԥ���
     *
     * @param	gol	�̿����ɥ쥹����Ԥ��оݤ�GOL
     * @param	failed	������̿��ʥ����Х륢�������ˤǼ��Ԥ����̿����ɥ쥹
     *			â�����������ʤ���� null ����ꤹ�롣
     * @return	�̿����ɥ쥹���֤���
     * @exception	ExCellNotFoundException
     *			���ꤵ�줿GOL���б�����ʥ���˥����Х륪�֥������Ȥ�
     *			�̿����ɥ쥹���褹�뤳�Ȥ��Ǥ��ʤ���
     */
    static
    ExCommAddress resolve(String gol, ExCommAddress failed)
    throws ExCellNotFoundException
    {
	ExAddressResolver agent = null;
	for (int retry = 1; retry <= resolveRETRY; retry ++) {
	    try {
		synchronized (lock) {
		    if (resolver == null) {
			if (resolverURL == null) {
			    Executor.syslog(CN, "resolve", "oz.home.resolver is null");
			    throw new ExCellNotFoundException(gol);
			} else {
			    resolver = new ExAddressResolver(resolverURL, resolveTIMEOUT);
			    debug("resolve", "Created "+resolver);
			}
		    }
		    agent = resolver;
		}
		return agent.lookup(gol, failed);
	    } catch (ExCellNotFoundException e) {
		throw e;
	    } catch (Exception e) {
		debug("resolve", e);
		synchronized (lock) {
		    if (agent != null) {
			agent.close();
			debug("resolve", "Closed "+agent);
			if (agent == resolver) resolver = null;
			agent = null;
		    }
		}
	    }
	    Executor.syslog(CN, "resolve", "Retry["+retry+"/"+resolveRETRY+"] "+gol);
	    try {
		debug("resolve", "Sleep "+resolveTIMEOUT+" milliseconds");
		Thread.sleep(resolveTIMEOUT);
	    } catch (Exception e) {
		debug("resolve", e);
		/* Nothing to do */
	    }
	}
	debug("resolve", "Over retry max("+resolveRETRY+") "+gol);
	throw new ExCellNotFoundException(gol);
    }

    /**
     * OzHomeResolver ��TCP���ͥ��������Ω���������ǡ�����ƻ뤹�륹��åɤ�
     * �¹Ԥ򳫻Ϥ��롣
     *
     * @param	resolver	OzHomeResolver ��URL
     * @param	timeout		OzHomeResolver ����α����Υ����ॢ���Ȼ��֡ʥߥ��á�
     * @exception		IOException
     *				TCP���ͥ������γ�Ω���˼��Ԥ�����
     */
    private
    ExAddressResolver(String url, long timeout)
    throws IOException
    {
	super("Watch response from resolver");
	URL resolver = new URL(url);
	socket = new Socket(resolver.getHost(), resolver.getPort());
	in = new DataInputStream(socket.getInputStream());
	out = new DataOutputStream(socket.getOutputStream());
	this.timeout = timeout;
	setDaemon(true);
	setPriority(Thread.MAX_PRIORITY);
	start();
	debug("ExAddressResolver","(url="+url+",timeout="+timeout+")");
    }

    /**
     * OzHomeResolver ���̿����ɥ쥹����׵�Υѥ��åȤ���������
     * �Ԥ���碌�Τ���Υ��֥������Ȥ��֤���
     * â���������̿����ɥ쥹����׵᤬�Ԥ��Ƥ���GOL�ξ��ϡ�
     * �ѥ��åȤ�������Ԥ�ʤ���
     *
     * @param	gol	�̿����ɥ쥹����Ԥ��о�GOL
     * @param	failed	������̿��ʥ����Х륢�������ˤǼ��Ԥ����̿����ɥ쥹
     *			â�����������ʤ���� null ����ꤹ�롣
     * @param	current	�Ե��ơ��֥����Ͽ�����Ԥ���碌�ѥ��֥�������
     * @return	�����Ե��ơ��֥����Ͽ����Ƥ����Ԥ���碌�褦���֥�������
     * @exception	IOException
     *			�ѥ��åȤ�������Ԥ��Ȥ����������Ԥ�����
     *
     */
    private synchronized
    ExFakeObject request(String gol, ExCommAddress failed, ExFakeObject current)
    throws IOException
    {
	if (trouble) {
	    throw new IOException("Trouble");
	}
	String ip = (failed == null) ? nothingHostAddress : failed.address.getHostAddress();
	int port = (failed == null) ? 0 : failed.port;
    	ExFakeObject before = (ExFakeObject)standbys.put(gol, current);
	if (before == null) {
	    try {
		debug("request", "Send "+gol+" "+ip+":"+port);
		out.writeUTF(requestTag);
		out.writeUTF(gol);
		out.writeUTF(ip);
		out.writeInt(port);
		out.flush();
	    } catch (IOException e) {
		trouble = true;
		throw e;
	    }
	} else {
	    debug("request", "Wait "+gol+" "+ip+":"+port);
	}
	return before;
    }

    /**
     * Ʊ��GOL���Ф����̿����ɥ쥹����׵���Ф���������Ԥ���碌��Ԥ���
     * 
     * <DL><DT>
     * ����ա�<DD>
     * �����ॢ���Ȼ���ExCellNotFoundException��ȯ�����롣
     * �ʤ��������ॢ���Ȥ�Ƚ�ǤϤ��Υ᥽�åɤǹԤ��롣
     * </DL>
     * @param	gol	�̿����ɥ쥹����Ԥ��оݤ�GOL
     * @param	failed	������̿��ʥ����Х륢�������ˤǼ��Ԥ����̿����ɥ쥹
     * @return	�̿����ɥ쥹���֤���
     * @exception	Exception
     *			���餫�ξ㳲��ȯ�������̿����ɥ쥹���ν���������˹Ԥ��ʤ��ä���
     * @exception	ExCellNotFoundException
     *			���ꤵ�줿GOL���б�����ʥ���˥����Х륪�֥������Ȥ�
     *			�̿����ɥ쥹���褹�뤳�Ȥ��Ǥ��ʤ���
     */
    private
    ExCommAddress lookup(String gol, ExCommAddress failed)
    throws Exception, ExCellNotFoundException
    {
	debug("lookup", "(go="+gol+",failed="+failed+")");
	ExCommAddress result = null;
	ExFakeObject current = new ExFakeObject();
	ExFakeObject before = null;
	before = request(gol, failed, current);
	if (before == null) {
	    if (current.await(timeout)) {
		result = (ExCommAddress)current.get();
	    } else {
		Exception e = (Exception)current.get();
		if (e == null) {
		    debug("lookup", "(go="+gol+",failed="+failed+") Timeout");
		} else {
		    throw e;
		}
	    }
	} else {
	    if (current.await(timeout)) {
		result = (ExCommAddress)current.get();
		before.ready(result);
	    } else {
		before.abort();
		Exception e = (Exception)current.get();
		if (e == null) {
		    debug("lookup", "(go="+gol+",failed="+failed+") Timeout");
		} else {
		    throw e;
		}
	    }
	}
	if (result == null) {
	    debug("lookup", "(go="+gol+",failed="+failed+") Not found");
	    throw new ExCellNotFoundException(gol);
	} else {
	    debug("lookup", "(go="+gol+",failed="+failed+") = "+result);
	}
	return result;
    }

    /**
     * OzHomeResolver ����Υѥå��Ȥ�ƻ뤷�Ƥ��륹��åɤ�λ������
     * TCP���ͥ�������������ǡʥ������ˤ��롣
     */
    private synchronized
    void close()
    {
	try {
	    interrupt();
	    in.close();
	    out.close();
	    socket.close();
	    join();
	} catch (Exception e) {
	    debug("close", e);
	}
    }

    /**
     * �������֥������Ȥ����꤬ȯ�������ʹߤ��̿����ɥ쥹���ν�����
     * �Ԥ��ʤ����֤Ǥ���Ȥ��������Ԥä���ǡ��Ե���Υ���åɤ�
     * �̿����ɥ쥹���ν�������ߤ��줿���Ȥ����Τ��롣
     *
     * @param	e	�̿����ɥ쥹���ν�������ߤ��줿ľ�ܤθ����Ȥʤä��㳰
     */
    private synchronized
    void abort(Exception e)
    {
	debug("abort", "Start");
	trouble = true;
	Enumeration keys = standbys.keys();
	while (keys.hasMoreElements()) {
	    String gol = (String)keys.nextElement();
	    ExFakeObject fake = (ExFakeObject)standbys.get(gol);
	    if (fake == null) {
		debug("abort", "? "+gol);
	    } else {
		fake.abort(e);
		debug("abort", gol);
	    }
	}
	debug("abort", "Finish");
    }

    /**
     * OzHomeResolver ����α����ѥ��åȤ�ƻ뤷���Ե��ơ��֥��Ȥä�
     * �б����륹��åɤ����Τ��롣
     */
    public
    void run()
    {
	try {
	    debug("run", "Start to watch response from resolver");
	    while (!isInterrupted()) {
		debug("run", "Wait to receive protocol tag");
		String tag = in.readUTF();
		if (tag.equals(successResponseTag)) {
		    String gol = in.readUTF();
		    String ip = in.readUTF();
		    int port = in.readInt();
		    debug("run", "Recv "+gol+" "+ip+":"+port);
		    ExFakeObject fake = (ExFakeObject)standbys.remove(gol);
		    if (fake != null) {
			try {
			    fake.ready(new ExCommAddress(InetAddress.getByName(ip), port, 0));
			} catch (UnknownHostException e) {
			    Executor.syslog(CN, "run", e);
			}
		    }
		} else if (tag.equals(failureResponseTag)) {
		    String gol = in.readUTF();
		    debug("run", "Recv "+gol+" not available");
		    ExFakeObject fake = (ExFakeObject)standbys.remove(gol);
		    if (fake != null) {
			fake.ready();
		    }
		} else {
		    Executor.syslog(CN, "run", "Illegal tag in response from resolver");
		    throw new IOException("Resolver protocol error");
		}
	    }
	    abort(null);
	    debug("run", "Finish to watch response from resolver");
	} catch (InterruptedIOException e) {
	    abort(e);
	    debug("run", "Finish to watch response from resolver", e);
	} catch (Exception e) {
	    abort(e);
	    Executor.syslog(CN, "run", "Aborted to watch response from resolver", e);
	}
    }
}
