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
 * $Id: ExAddressManager.java,v 2.2 1997/12/04 04:55:19 yoshi Exp $
 *
 */

package	JP.go.ipa.oz.system;

import	java.io.File;
import	java.io.FileInputStream;
import	java.io.FileOutputStream;
import	java.io.IOException;
import	java.io.PrintWriter;
import	java.util.Dictionary;
import	java.util.Enumeration;
import	java.util.Hashtable;

/**
 * �Ȥ�줿�̿����ɥ쥹�Υơ��֥�������
 * GOL�����̿����ɥ쥹�ؤ��Ѵ��䤽�Υơ��֥�Υ��ƥʥ󥹤�Ԥ���
 * �̿����ɥ쥹�ϥ��뤬�����Х륢������������դ��ʤ����֤Ǥ��äƤ�
 * ¾�Υ���ؤΥ����Х륢��������Ԥ��ΤǤ����ɬ�פǤ��롣
 * â����Ʊ�����������塼����Υ���ؤΥ����Х륢�������ξ���
 * �̿����ɥ쥹��ɬ�פȤ��ʤ���
 * GOD���Υե�����Υ��ƥʥ󥹤�Ʊ���˹Ԥ���
 *
 * <DL><DT>
 * �ڥ���<DD>
 * �桼���˸������륯�饹��𤷤ơ��꥾��ФȤΤ��Ȥ��
 * �Ԥ�����μ�����������Ĥ��⤷��ʤ���
 * </DL>
 *
 * @version	$Revision: 2.2 $, $Date: 1997/12/04 04:55:19 $
 * @author	Yasumitsu Yoshida
 */
final
class ExAddressManager
{
    /**
     * ���������塼�������ΥǥХå���
     */
    static final String CN = "ExAddressManager";

    /**
     * ���Υ��饹�ΥǥХå��ѥե饰
     */
    protected static boolean debug
	= (System.getProperty(ExAddressManager.class.getName()+".debug") != null) ? true : false;

    /**
     * �̿����ɥ쥹��񤭹���ե�����̾
     */
    private static final String addressFilename = ".location";

    /**
     * GOL �򥭡��Ȥ����̿����ɥ쥹�����뤿��Υơ��֥�Ǥ��롣
     *
     * <DL><DT>
     * ����ա�<DD>
     * �ۤʤ륨�������塼����Υ���ʥ����Х륪�֥������ȡˤ�
     * �����Х륢��������Ԥ��ݤˡ���������ͤ��֤������
     * �̿����ɥ쥹���Ȥ��롣���äơ������Х륢��������
     * �Ԥ������ˡ����Υơ��֥���̿����ɥ쥹����Ͽ����Ƥ���
     * ɬ�פ����롣
     * </DL>
     */
    private static Dictionary addressCache = new Hashtable();

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
     * ���饹 ExAddressManager �ϣ��ĤΥ��������塼����
     * ���ĤǤ��ꡢư����˼������ѹ�����뤳�Ȥ�ʤ���
     * ���äơ����饹 ExAddressManager ��Ȥä�
     * ���֥������Ȥ��������ʤ��褦�ˤ���
     * static�᥽�åɤΤߤ�������롣
     */
    private
    ExAddressManager()
    {
	/* Nothing */
    }

    /**
     * �̿����ɥ쥹��ե����뤫���ɤ߹��ࡣ
     *
     * <DL><DT>
     * ����ա�<DD>
     * �᥽�åɤ�����ͤȤ��� null ���֤��ƤϤʤ�ʤ���
     * </DL>
     *
     * @param	god	GOD���֥�������
     * @return		�ɤ߹�����̿����ɥ쥹
     * @exception	ExCellNotFoundException
     *				���ꤵ�줿 GOD �Υ���ʥ����Х륪�֥������ȡˤ����Ĥ���ʤ���
     * @exception	ExCellNotActiveException
     *				���ꤵ�줿 GOD �Υ���ʥ����Х륪�֥������ȡˤ�����������Ƥ��ʤ���
     * @exception	ExException
     *				�̿����ɥ쥹�Υե�������ɤ߹��ߤ˼��Ԥ�������
     */
    private static
    ExCommAddress read(ExGOD god)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("read","(god="+god+")");
	File location = new File(god,addressFilename);
/*
	File inactive = new File(god,ExGOD.unlockFilename);
	File objectImage = new File(god,ExCell.objectImageFilename);
*/
	debug("read","location="+location);
	if (ExCellManager.exists(god)) {
/*
	if (god.exists() && god.isDirectory() && (location.exists() || objectImage.exists())) {
	    if (! inactive.exists()) {
// for vi: }}
*/
	    if (god.knock()) {
		try {
		    ExCommAddress result;
		    ExObjectInputStream in = new ExObjectInputStream(new FileInputStream(location));
		    result = (ExCommAddress)in.readObject();
		    in.close();
		    debug("read","() = "+result+" from location="+location);
		    return result;
		} catch (Exception e) {
		    Executor.error(CN,"read","(god="+god+")",e);
		    throw new ExException(e.getClass().getName());
		}
	    } else {
		throw new ExCellNotActiveException(god.getName());
	    }
	}
	throw new ExCellNotFoundException(god.getName());
    }

    /**
     * �̿����ɥ쥹��ե�����˽񤭹���
     *
     * @param	god	GOD���֥�������
     * @param	address	�̿����ɥ쥹
     * @exception	ExCellNotFoundException
     *				���ꤵ�줿 GOD �Υ���ʥ����Х륪�֥������ȡˤ����Ĥ���ʤ���
     * @exception	ExCellNotActiveException
     *				���ꤵ�줿 GOD �Υ���ʥ����Х륪�֥������ȡˤ�����������Ƥ��ʤ���
     * @exception	ExException
     *				�̿����ɥ쥹�Υե�����ν񤭹��ߤ˼��Ԥ�������
     */
    private static
    void write(ExGOD god,ExCommAddress address)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("write","(god="+god+",address="+address+")");
	File location = new File(god,addressFilename);
	debug("write","location="+location);
	if (god.exists() && god.isDirectory()) {
	    if (god.knock()) {
		try {
		    ExObjectOutputStream out = new ExObjectOutputStream(new FileOutputStream(location));
		    out.writeObject(address);
		    out.close();
		    debug("write","(god="+god+",address="+address+") ok");
		    return;
		} catch (Exception e) {
		    Executor.error(CN,"write","(god="+god+",address="+address+")",e);
		    throw new ExException(e.getClass().getName());
		}
	    } else {
		throw new ExCellNotActiveException(god.getName());
	    }
	}
	throw new ExCellNotFoundException(god.getName());
    }

    /**
     * �̿����ɥ쥹�Υե�����������롣
     *
     * @param	god	GOD���֥�������
     * @exception	ExCellNotFoundException
     *				���ꤵ�줿 GOD �Υ���ʥ����Х륪�֥������ȡˤ����Ĥ���ʤ���
     */
    private static
    void delete(ExGOD god)
    throws ExCellNotFoundException
    {
	debug("delete","(god="+god+")");
	File location = new File(god,addressFilename);
	if (god.exists() && god.isDirectory()) {
	    if (location.delete()) {
		debug("delete","location="+location);
		debug("delete","(god="+god+") ok");
	    } else {
		Executor.error(CN,"delete","location="+location);
	    }
	    return;
	}
	throw new ExCellNotFoundException(god.getName());
    }

    /**
     * ���ꤵ�줿 GOL ���б������̿����ɥ쥹�β��򥭥�å���
     * ��ȤäƹԤ�������å����ˤʤ����ϡ��̿����ɥ쥹��
     * �Υե������ľ���ɤ߹��फ�����뤤�ϡ�OzHomeResolver ��
     * �䤤��碌�Ƥ���ǥ���å������Ͽ���롣
     *
     * @param	gol	GOL�ʥ����Х륪�֥������ȥ���������
     * @param	failed	�̿����Ԥ����Ȥ��Ǥ��ʤ��ä��̿����ɥ쥹
     * @return		�̿����ɥ쥹
     * @exception	ExCellNotFoundException
     *				�̿����ɥ쥹�β��η�̡����ꤵ�줿 GOL ��
     *				�б����륻��ʥ����Х륪�֥������ȡˤϸ��Ĥ���ʤ��ä���
     * @exception	ExCellNotActiveException
     *				�̿����ɥ쥹�β��η�̡����ꤵ�줿 GOL ��
     *				�б����륻��ʥ����Х륪�֥������ȡˤϳ���������Ƥ��ʤ��ä���
     * @exception	ExException
     *				���������塼�������ν�����ͽ�����Ƥ��ʤ��㳰��ȯ��������
     */
    private static
    ExCommAddress load(ExGOL gol, ExCommAddress failed)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("load", "(gol="+gol+",failed="+failed+")");
	ExCommAddress result = null;
	for (;;) {
	    Object o = addressCache.get(gol);
	    if (o == null) {
		ExFakeObject current = new ExFakeObject();
		o = addressCache.put(gol, current);
		if (o == null) {
		    try {
			if (gol.inside()) {
			    ExGOD god = new ExGOD(gol);
			    result = read(god);
			} else {
			    Object[] args = new Object[3];
			    args[0] = new Integer(Executor.RESOLVE);
			    args[1] = gol.getName();
			    args[2] = failed;
			    OzProcess p = Executor.syscall(args);
			    try {
				result = (ExCommAddress)p.join();
			    } catch (ExProcessException e) {
				    throw e.getException();
			    }
			}
			addressCache.put(gol, result);
			current.ready();
			debug("load", "***** LOADED "+gol.getName()+" = "+result);
		    } catch (Exception e) {
			addressCache.remove(gol);
			current.abort();
			if (e instanceof ExCellNotFoundException) {
			    Executor.debug(CN,"load","(gol="+gol+",failed="+failed+")",e);
			    throw (ExCellNotFoundException)e;
			} else if (e instanceof ExCellNotActiveException) {
			    Executor.debug(CN,"load","(gol="+gol+",failed="+failed+")",e);
			    throw (ExCellNotActiveException)e;
			}
			Executor.error(CN,"load","(gol="+gol+",failed="+failed+")",e);
			throw new ExException(e.getClass().getName());
		    }
		} else {
		    if (o instanceof ExFakeObject) {
			debug("load","***** wait "+gol.getName());
			ExFakeObject fake = (ExFakeObject)o;
			if (fake.await()) {
			    current.ready();
			    /* Retry */
			} else {
			    current.abort();
			    throw new ExCellNotFoundException(gol.getName());
			}
		    } else {
			debug("load","***** reset "+gol.getName());
			addressCache.put(gol, o);
			current.ready();
			result = (ExCommAddress)o;
			break;
		    }
		}
	    } else {
		if (o instanceof ExFakeObject) {
		    debug("load","***** WAIT "+gol.getName());
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			throw new ExCellNotFoundException(gol.getName());
		    }
		} else {
		    result = (ExCommAddress)o;
		    break;
		}
	    }
	}
	debug("load", "(gol="+gol+",failed="+failed+") = "+result);
	return result;
    }

    /**
     * ���ꤵ�줿 GOL ���̿����ɥ쥹�򥭥�å��夫�������롣
     *
     * @param	gol	GOL�ʥ����Х륪�֥������ȥ���������
     * @return		��Ͽ����Ƥ����̿����ɥ쥹����Ͽ����Ƥ��ʤ���� null ���֤���
     *
     * @see	ExAddressManager#addressCache
     */
    private static
    void remove(ExGOL gol)
    {
	debug("remove","(gol="+gol+")");
	for (;;) {
	    Object o = addressCache.remove(gol);
	    if (o != null) {
		if (o instanceof ExFakeObject) {
		    // ��Ͽ������ʤΤǽ����ν�λ���Ԥäơ����٤��ľ����
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			debug("remove","(gol="+gol+"): Aborted");
			break;
		    }
		} else {
		    break;
		}
	    } else {
		debug("remove","(gol="+gol+"): Not found");
		break;
	    }
	}
	debug("remove","(gol="+gol+") ok");
    }

    /**
     * ���ꤵ�줿 GOL ���б������̿����ɥ쥹�β���Ԥ���
     * �̿����ɥ쥹�β��˼��Ԥ��������㳰��ȯ�����롣
     * ���Υ᥽�åɤ��������������塼����Ʊ��OZ�ۡ������
     * ����ʥ����Х륪�֥������ȡˤ��̿����ɥ쥹�β���Ԥ���
     * �ޤ��������̿����ɥ쥹��̵���Ǥ��뤳�Ȥ�Ƚ������ȡ�
     * ���������ƤӽФ��ơ��б����� GOD �Υꥫ�Х꡼��Ԥ���
     *
     * @param	gol	GOL�ʥ����Х륪�֥������ȥ���������
     * @param	failed	�̿����Ԥ����Ȥ��Ǥ��ʤ��ä��̿����ɥ쥹
     * @return		�̿����ɥ쥹
     * @exception	ExCellNotFoundException
     *				�̿����ɥ쥹�β��η�̡����ꤵ�줿 GOL ��
     *				�б����륻��ʥ����Х륪�֥������ȡˤϸ��Ĥ���ʤ��ä���
     * @exception	ExCellNotActiveException
     *				�̿����ɥ쥹�β��η�̡����ꤵ�줿 GOL ��
     *				�б����륻��ʥ����Х륪�֥������ȡˤϳ���������Ƥ��ʤ��ä���
     * @exception	ExException
     *				���������塼�������ν�����ͽ�����Ƥ��ʤ��㳰��ȯ��������
     *
     * @see	addressCache
     */
    static
    ExCommAddress resolve(ExGOL gol, ExCommAddress failed)
    throws ExCellNotFoundException, ExCellNotActiveException, ExException
    {
	debug("resolve", "(gol="+gol+",failed="+failed+")");
	ExCommAddress result = null;
	result = load(gol, failed);

	if (failed != null && failed.equals(result)) {
	    remove(gol);
	    result = load(gol, failed);
	    if (failed.equals(result)) {
		String message = "New resolved address is the failed address.";
		Executor.syslog(CN, "resolve", "(gol="+gol+",failed="+failed+"): "+message);
		throw new ExCellNotFoundException(gol.getName());
	    }
	}
	debug("resolve", "(gol="+gol+",failed="+failed+") = "+result);
	return result;
    }

    /**
     * ���ꤵ�줿 GOD �Υե�������̿����ɥ쥹��
     * �񤭽Ф�����ǡ��б�����GOL���̿����ɥ쥹�򥭥�å������Ͽ���롣
     *
     * @param	god	GOD���֥�������
     * @param	address	�̿����ɥ쥹
     * @return		������Ͽ����Ƥ����̿����ɥ쥹����Ͽ����Ƥ��ʤ���� null ���֤���
     *
     * @see	ExAddressManager#addressCache
     */
    static
    ExCommAddress put(ExGOD god, ExCommAddress address)
    throws ExCellNotFoundException, ExCellNotActiveException, ExGOLFormatException, ExException
    {
	debug("put", "(god="+god+",address="+address+")");
	ExCommAddress result;
	write(god, address);
	result = load(new ExGOL(god), null);
	debug("put", "(god="+god+",address="+address+") = "+address);
	return result;
    }

    /**
     * ���ꤵ�줿 GOD ���̿����ɥ쥹�Υե������
     * ���������ǡ��б�����GOL���̿����ɥ쥹�򥭥�å��夫�������롣
     *
     * @param	god	GOD���֥�������
     * @return		������Ͽ����Ƥ����̿����ɥ쥹����Ͽ����Ƥ��ʤ���� null ���֤���
     *
     * @see	ExAddressManager#addressCache
     */
    static
    void remove(ExGOD god)
    throws ExCellNotFoundException, ExGOLFormatException
    {
	debug("remove", "(god="+god+")");
	delete(god);
	remove(new ExGOL(god));
    }

    /**
     * ���ꤵ�줿 GOD ��ͭ�����̿����ɥ쥹�Υե����뤬
     * ���뤫��Ĵ�٤롣
     */
    static
    boolean exists(ExGOD god)
    {
	if (god.knock()) {
	    File location = new File(god,addressFilename);
	    return location.exists();
	}
	return false;
    }

    /*
     * ����ʹߤϥǥХå��ȥ�����Τ���Υץ����Ǥ��롣
     * �ʾܺ٤Ͼ�ά��
     */
    static {

	/*
	 * �̿����ɥ쥹�ʥ���å���ˤ�ɽ�����ޥ��
	 */
	class List
	extends ExShellCommand
	{
	    List()
	    {
		usage = " [<gol>]";
		comment = "list of addresses in cache";
	    }

	    String action(ExShell shell, String[] args)
	    throws Exception
	    {
		if (2 < args.length) {
		    shell.stderr.println("Usage: "+args[0]+usage);
		    throw new IllegalArgumentException("Too many arguments");
		}
		if (args.length == 2) {
		    shell.stdout.println(resolve(new ExGOL(args[1]),null));
		} else {
		    Enumeration keys = addressCache.keys();
		    while (keys.hasMoreElements()) {
			ExGOL gol = (ExGOL)keys.nextElement();
			shell.stdout.println(resolve(gol,null)+" "+gol.getName());
		    }
		}

		return null;
	    }
	}

	ExShell.append("address",new List());
    }
}
