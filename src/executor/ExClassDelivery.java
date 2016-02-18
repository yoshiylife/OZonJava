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
 * $Id: ExClassDelivery.java,v 1.1 1997/11/07 05:07:55 yoshi Exp $
 */

package	JP.go.ipa.oz.system;

import	java.io.File;
import	java.io.FileInputStream;
import	java.io.FileOutputStream;
import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;

/**
 * �������ݥ��ȥ�˥��饹���������֥ե��������Ͽ���뤿���
 * ���饹�����򥯥饹 OzLocalRepositoryManager ��������Ū��
 * ������褦�ˤ��롣���饹���������֥ե�����˴ؤ���ɬ�פʾ����
 * �ե���������Ƥ򥹥ȥ꡼��Ȥ����󶡤��륯�饹�Ǥ��롣
 *
 * <DL><DT>
 * ����ա�<DD>
 * ���Υ��饹�ϡ����饹 OzLocalRepositoryManager ����ƤӽФ���뤿�ᡢ
 * ���������塼����ư�������Ȥ�����ñ�Ȥ�ư���ǽ�Ǥʤ���Фʤ�ʤ���
 * ������������Υץ�ѥƥ�����Ŭ�ڤ����ꤵ��Ƥ��뤳�Ȥ�����Ȥ��롣
 * <DT>
 * �ڥ����ȡ�<DD>
 * �����Ǥϡ����Υ��饹��Ѿ����륯�饹�Ϥʤ���������Ū�ˤ�
 * ���Υ��饹��Ѿ����ƥ��饹�����Υץ�ȥ�����˥��饹��
 * �������������褤���⤷��ʤ���
 * </DL>
 *
 * @see OzLocalRepositoryManager
 * @see ExClassLoader
 *
 * @version		$Revision: 1.1 $, $Date: 1997/11/07 05:07:55 $
 * @author		Yasumitsu Yoshida
 */
class	ExClassDelivery
{

    /**
     * ���������塼�������ΥǥХå���
     */
    protected static String CN = "ExClassDelivery";

    /**
     * �ǥХå��ѥե饰
     */
    protected static boolean debug
	= (System.getProperty(ExClassDelivery.class.getName()+".debug") != null) ? true : false;

    /**
     * string representing size of buffer to copy class archive file
     */
    static private String bufferSizeProperty
	= System.getProperty("oz.classDelivery.download.bufferSize");

    /**
     * Size of buffer to copy class archive file
     */
    static final int bufferSize
	= (bufferSizeProperty != null) ? Integer.parseInt(bufferSizeProperty) : 1024;

    /**
     * The length of the content
     */
    protected final long length;

    /**
     * Input stream to delivery class archive file.
     */
    protected final InputStream in;

    /**
     * Top package name of class archive file to delivery.
     */
    protected final String topPackageName;

    /**
     * The flag is true if the zip file is transfered.
     */
    protected boolean transfered;

    /**
     * ����Ͽ�Τ���Υ�å���������Ϥ��롣
     * â�������������塼����ư�������ˤǤ��ʤ��Τǡ�
     * ��å�������ɸ�२�顼���Ϥ˽��Ϥ��롣
     *
     * @param	methodName	��å��������ղä����᥽�å�̾
     * @param	message		���Ϥ����å�����
     */
    protected
    void syslog(String methodName, String message)
    {
	System.err.println(CN+"#"+methodName+": "+message);
    }

    /**
     * ���Υ��饹��°�� debug ��true�ʤ�С��ǥХå��Τ����
     * ��å���������Ϥ��롣
     * â�������������塼����ư�������ˤǤ��ʤ��Τǡ�
     * ��å�������ɸ�२�顼���Ϥ˽��Ϥ��롣
     * <DL><DT>
     * ����ա�<DD>
     * ���饹 Executor ��°�� debug �򻲾Ȥ��Ƥ��뤬��
     * ���������塼����ư��ʤ��ˤ���°����true�Ȥʤ뤳�ȤϤʤ���
     * ���������塼����ư��Ƥ����硢ɸ�२�顼���Ϥ�
     * ����Ͽ���оݤȤʤ뤿��ˤ��Τ褦�ʼ����ȤʤäƤ��롣
     * </DL>
     *
     * @param	methodName	��å��������ղä����᥽�å�̾
     * @param	message		���Ϥ����å�����
     */
    protected
    void debug(String methodName, String message)
    {
	if (debug) {
	    if (Executor.debug) {
		Executor.debug(CN, methodName, message);
	    } else {
		System.err.println(CN+"#"+methodName+": "+message);
	    }
	}
    }

    /**
     * ���饹���������֥ե������������뤿���ɬ�פʾ����
     * �ե���������Ƥ���Ф����ȥ꡼����󶡤��뤿���
     * ���֥������Ȥ��������롣
     *
     * @param	topPackageName	���饹���������֥ե�����Υȥåץѥå�����̾
     * @param	in		���饹���������֥ե���������Ƥ��ɤ߽Ф�����Υ��ȥ꡼��
     * @param	length		���饹���������֥ե������Ĺ��
     * @exception
     *		IOException	�ե�����������������Ϥ��㳰��ȯ��������
     */
    protected
    ExClassDelivery(String topPackageName, InputStream in, long length)
    throws IOException
    {
	this.topPackageName = topPackageName;
	this.length = length;
	this.in = in;
    }

    /**
     * ���饹���������֥ե������������뤿���ɬ�פʾ����
     * �ե���������Ƥ���Ф����ȥ꡼����󶡤��뤿���
     * ���֥������Ȥ��������롣
     *
     * @param	topPackageName	���饹���������֥ե�����Υȥåץѥå�����̾
     * @param	file		������ˤ��륯�饹���������֥ե�����
     * @exception
     *		IOException	�ե�����������������Ϥ��㳰��ȯ��������
     */
    protected
    ExClassDelivery(String topPackageName, File file)
    throws IOException
    {
	this.topPackageName = topPackageName;
	this.length = file.length();
	this.in = new FileInputStream(file);
    }

    /**
     * ���饹���������֥ե�������������ɤ���
     * ���ꤵ�줿�ե��������¸���롣
     *
     * @param	file		���饹���������֥ե��������¸����ե�����
     * @exception
     *		IOException	�ե�����������������Ϥ��㳰��ȯ��������
     *				���뤤�ϡ����饹���������֥ե���������Ƥ���Ŭ�ڤǤ��롣
     */
    void download(File file)
    throws IOException
    {
	OutputStream out = new FileOutputStream(file);
	byte[] buffer = new byte[bufferSize];
	int total = 0;
	int n;
	debug("download", "transfer "+file.getPath());
	while ((n = in.read(buffer)) != -1) {
	    out.write(buffer, 0, n);
	    total += n;
	}
	debug("download", "finished "+file.getPath());
	out.close(); out = null;
	debug("download", "total "+total+" bytes saved to "+file.getPath());
	if (total != length) {
	    String message = "Incorrect file length: "+file.getPath();
	    syslog("download", message);
	    throw new IOException(message);
	}
	transfered = true;
    }

    /**
     * ��������륯�饹���������֥ե����뤬��Ͽ�����٤�
     * �ȥåץѥå�����̾���֤���
     *
     * @return	�ȥåץѥå�����̾
     */
    String getName()
    {
	return topPackageName;
    }

    /**
     * ��������륯�饹���������֥ե������Ĺ�����֤���
     *
     * @return	���饹���������֥ե������Ĺ��
     */
    long length()
    {
	return length;
    }

    /**
     * ���饹���������֥ե�����������ʥ�������ɡ˽�����
     * �Ԥ�줿�ɤ������֤���
     *
     * @return	�����ʥ�������ɡ˽������Ԥ�줿���ϡ�true ���֤���
     */
    boolean isTransfered()
    {
	return transfered;
    }

    /**
     * ���饹�����˻��Ѥ������ȥ꡼������λ�������롣
     * @exception
     *		IOException	�ե�����������ν�λ�������㳰��ȯ��������
     */
    void close()
    throws IOException
    {
	in.close();
    }

    /**
     * ���Υ��饹��Ȥäƺ������줿���֥������Ȥ�ʸ����ɽ���Ȥ���
     * �ȥåץѥå�����̾����Ѥ��롣
     *
     * @return	�ȥåץѥå�����̾
     */
    public
    String toString()
    {
	return getName();
    }
}
