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
 * $Id: Executor.java,v 2.3 1997/12/04 04:55:20 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package	JP.go.ipa.oz.system;

import	java.io.BufferedInputStream;
import	java.io.BufferedOutputStream;
import	java.io.ByteArrayInputStream;
import	java.io.ByteArrayOutputStream;
import	java.io.DataInputStream;
import	java.io.DataOutputStream;
import	java.io.File;
import	java.io.FileDescriptor;
import	java.io.FileInputStream;
import	java.io.FileOutputStream;
import	java.io.InputStream;
import	java.io.InputStreamReader; // Now, replace with ExInputStreamReader for the problem
import	java.io.OutputStream;
import	java.io.PrintStream;
import	java.io.PrintWriter;
import	java.io.Reader;
import	java.io.StringBufferInputStream;
import	java.io.StringReader;
import	java.io.StringReader;
import	java.lang.Runtime;
import	java.net.InetAddress;
import	java.net.ServerSocket;
import	java.net.Socket;
import	java.util.Date;
import	java.util.Properties;

/**
 * ���������塼�����ΤǤ��롣JavaVM �ˤ�äƺǽ�ˤ��Υ��饹�Υ᥽�å� main() ��
 * ��ư����롣���������塼�����Τϡ�����åɥ��롼�פ�������ɬ�פ����뤳�ȡ�
 * ���������塼�����Ȥν����Τ���˥ץ������������ʤ���Фʤ�ʤ�����
 * �ʤɤ���ͳ���饯�饹 OzCell ��Ѿ��������ĤΥ���Ȥ��ư�����
 * ���������塼�����ΤؤΥ��������ϡ��̾�Υ����Х륢�������ǤϤʤ���
 * �ץ����������ȼ¹Ԥε�ǽ��Ȥä����̤���ˡ�ǹԤ���Τǡ�
 * ����������ͤΥ��ԡ��ϹԤ��ʤ����ޤ����桼���ϡ����������塼������
 * �Ǥ��륰���Х륪�֥������Ȥ�¸�ߤ�ץ������ǧ���Ǥ��ʤ���
 *
 * <DL><DT>
 * ����ա�<DD>
 * ���ߡ����ʤ��Ȥ�Solaris(SPARC)�ǤǤ�ɸ�����Ϥ���������Ԥ��ˤʤ��
 * JavaVM �Υ������塼�餬��ߤ��롣���äơ�ɸ�����Ϥ���������Ԥ��ˤʤ�
 * ���֤Ǥϡ�¾�Υ���åɤϼ¹Ԥ���ʤ���
 * </DL>
 *
 * @see	ExCell
 * @see OzCell
 *
 * @version		$Revision: 2.3 $, $Date: 1997/12/04 04:55:20 $
 * @author		Yasumitsu Yoshida
 */
final
class Executor
extends OzCell
implements Runnable
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "Executor";

	static final String IPA = "JP.go.ipa.";
	static final String IPAoz = IPA+"oz.";
	static final String IPAozSystem = IPAoz+"system.";
	static final String IPAozUser = IPAoz+"user.";

	/**
	 * ��󥿥��ॵ���ӥ��ֹ�
	 */
	// ���饹 Executor �Ǽ�������Ƥ�����
	static final int BOOT		= 0x00;	// ���������塼���ε�ư
	static final int EXIT		= 0x01; // ���������塼���ν�λ
	static final int SYSLOG		= 0x02;	// ���������塼���Υ��ؤν���
	static final int HALT		= 0x03; // ���������塼������ߡʽ�λ�ǤϤʤ���
	static final int ECHO		= 0x0f; // �������Хå��ʼ¸���

	// ���饹 ExCellManager �Ǽ�������Ƥ�����
	static final int CREATE		= 0x10;	// ����ʥ����Х륪�֥������ȡˤ�����
	static final int GO			= 0x11;	// ����ʥ����Х륪�֥������ȡˤγ�����
	static final int STOP		= 0x12;	// ����ʥ����Х륪�֥������ȡˤ��Գ�����
	static final int REMOVE		= 0x13;	// ����ʥ����Х륪�֥������ȡˤκ��
	static final int FLUSH		= 0x14;	// ����ʥ����Х륪�֥������ȡˤΥ��᡼������¸
	static final int QUIT		= 0x15;	// ����ʥ����Х륪�֥������ȡˤ��������

	// ���饹 ExClassLoader �Ǽ�������Ƥ�����
	static final int LOADCLASS	= 0x20; // ���饹�Υ���
	static final int LOADPACKAGE	= 0x21; // ���������֤�����

	// ���饹 ExAddressResolver �Ǽ�������Ƥ�����
	static final int RESOLVE	= 0x30; // �ۤʤ�OZ�ۡ�����̿����ɥ쥹���

	/**
	 * ���ޥ�ɤμ¹Ի����㳰��ȯ����������ľ���˥��������塼����λ����Ȥ����ե饰�Ǥ��롣
	 * ��̤������
	 */
	static boolean quitOnException = false;

	/**
	 * ľ���˥��������塼����λ�����硢�����Х륪�֥������Ȥ��Գ����������̾�ν�����
	 * �Ԥ�ʤ��Ȥ����ե饰�Ǥ��롣
	 * ��̤������
	 */
	static boolean exitImmediately = false;

	/**
	 * �¸��Τ���
	 */
	static boolean remote = false;

	/**
	 * ��Ĺɽ��
	 * ��̤������
	 */
	static boolean verbose = false;

	/**
	 * �ǥХå�
	 */
	static boolean debug = false;

	/**
	 * ɸ������
	 */
	static InputStream in;
	static InputStream stdin;

	/**
	 * ɸ�����
	 */
	static PrintStream out;
	static PrintStream stdout;

	/**
	 * ɸ�२�顼����
	 */
	static PrintStream err;
	static PrintStream stderr;

	/**
	 * ������
	 */
	static PrintStream stdlog;

	/**
	 * �̿������ƥ�
	 */
	static ExCommManager commManager;

	/**
	 * ���饹����
	 */
	static ExClassLoader classLoader;

	/**
	 * �������ƥ��ޥ͡�����
	 */
	static ExSecurityManager securityManager;

	/**
	 * �Ź沽�̿�
	 */
//	static ExCipherTable cipherTable;

	/**
	 * ���������塼���˸�ͭ��ʸ�����������뤿���
	 * �ۥ���̾�ȥݡ����ֹ��Ȥ���
	 */
	static private ServerSocket serverport;
	static private InetAddress localhost;
	static private String hostName;
	static private String portName;

	static {
	    /*
	     * �ץ�����ͭ�Υե�����̾���������뤿���
	     * �����Х����åȤ򳫤��ƥݡ����ֹ�ȥۥ���̾��������롣
	     * ���Υ����Х����åȤϡ����衢���������塼���֤�
	     * ���ƥʥ󥹤˻��Ѥ���뤫�⤷��ʤ���
	     */
	    try {
		serverport = new ServerSocket(0,5);
		localhost = InetAddress.getLocalHost();
		hostName = localhost.getHostName();
		if (hostName == null) hostName = localhost.getHostAddress();
		StringBuffer buffer = new StringBuffer();
		buffer.append(serverport.getLocalPort());
		buffer.reverse();
		for (int i = buffer.length(); i < 5; i ++) {
			buffer.append('0');
		}
		buffer.reverse();
		portName = buffer.toString();
	    } catch(Exception e) {
		e.printStackTrace(System.err);
		System.exit(1);
	    }
	}

	/**
	 * ���������塼���˸�ͭ��ʸ������֤���
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���������塼����ư�������Ȥ��ʤ����饹����⡢
	 * �ƤӽФ�����礬���롣
	 * </DL>
	 *
	 * @return		���������塼���˸�ͭ��ʸ����
	 */
	static
	String getID()
	{
		return hostName+"."+portName;
	}

	/**
	 * public �Υ᥽�å� main �����ٸƤӽФ���ʤ��褦�ˤ��뤿��Υե饰�Ǥ��롣
	 */
	static private boolean started = false;

	/**
	 * ���ޥ�ɹԤ����Ϥ�¥���ץ��ץȤ���Ϥ��롣
	 */
	static private boolean printPrompt = true;

	/**
	 * ���������塼���Υ����ƥ���Ư�����뤿���ɬ�פʥ���åɤ�
	 * °���륹��åɥ��롼�פǤ��롣���̤ʥ���Ǥ��뤿�ᡢ
	 * �̿����ɥ쥹�Υơ��֥�䥰���Х륪�֥������ȤΥơ��֥��
	 * ��Ͽ����ʤ���
	 */
	static private ExCell exCell;

	/**
	 * �ץ����κ������ưפˤ��뤿��ȡ������Х륪�֥�������
	 * �Ȥ��ư�������˥��󥹥��󥹤�������롣
	 * ���������塼�����ΤǤ��롣
	 */
	static private Executor executor;

	/**
	 * ��ư���˻��ꤵ�줿�ǽ�˳���������
	 * �����GOD���ݻ����롣
	 */
	static private ExGOD initCellGOD = null;

	/**
	 * �̾�μ�³���ˤ�ꥻ�����������ξ��֤ˤ����ߤ��顢
	 * ����Ū�˥������������ξ��֤ˤ��������Ԥ��ޤǤ�
	 * �Ԥ����֡�ñ�̤ϥߥ��á��ǥե���Ȥ�60�áˤǤ��롣 
	 */
	static private long userGracePeriod = 60000;

	/**
	 * �����ƥब����Ū�˥������������ξ��֤�
	 * ��������β����ǡ��ǽ�Ū�ʽ����򳫻Ϥ���ޤǤ�
	 * �Ԥ����֡�ñ�̤ϥߥ��á��ǥե���Ȥ�10�áˤǤ��롣 
	 */
	static private long systemGracePeriod = 10000;

	/**
	 * OZ�Υ������ƥ��ޥ͡���������ꤷ�ʤ��Ȥ����ե饰�Ǥ��롣
	 * �ʼ¸��Τ����
	 */
	static private boolean noSecurity = false;

	/**
	 * ���������塼����ư���뤿��Υ᥽�åɤǤ��롣
	 * JavaVM �ˤ�äƺǽ�ˤ��Υ��饹�Υ᥽�å� main() ����ư����롣
	 *
	 * ��static �ΰ�������javaVM�ε�ư���˻��ꤵ�줿ʸ����
	 * ���ʥ��ץ�������ˤβ��Ϥ�Ԥ���
	 * �����������塼�����ΤΥ���ʥ����Х륪�֥������ȡˤ��������롣
	 * �����Υ����Х륪�֥������Ȥ���������롣
	 *
	 * @param	args	javaVM�ε�ư���˻��ꤵ�줿ʸ����ʥ��饹 String��
	 *					�������Ϥ���롣
	 * @exception	Exception
	 *					���������塼���ε�ư�������ͽ�����ʤ��㳰��ȯ��������
	 */
	public static
	void main(String args[])
	throws Exception
	{
		/*
		 * ���饹 Executor �� public �ǤϤʤ�����
		 * �᥽�å� main �� public �᥽�åɤʤΤ�
		 * ǰ�Τ��ᣲ�ŵ�ư����ʤ��褦�ˤ��롣
		 */
		if (started) {
			error(CN,"main","*CAUTION* Illegal called");
			return;
		} else started = true;

		/*
		 * �ץ�ѥƥ����ɤ߹���
		 */
		String ozHome = System.getProperty("oz.home");
		if (ozHome == null) {
			System.err.println("Not found property 'oz.home'");
			System.exit(2);
		} else {
			File libdir = new File(ozHome,"lib");
			File file = new File(libdir,"oz.properties");
			try {
				loadProperties(file);
			} catch (Exception e) {
				System.err.println("Can't load properties from "+file);
				System.exit(3);
			}
		}

		/*
		 * GC�ǡ�ɸ�����ϡ�ɸ����ϡ�ɸ�२�顼���Ϥ�
		 * ����������ʤ��褦�˻��Ȥ���¸�����ʸ��
		 * ���饹 System �� in, out, err ���ѹ��������롣
		 */
		in = System.in;
		out = new ExPrintStream(System.out);
		err = new ExPrintStream(System.err);

		/*
		 * ���ν�����Ȥʤ�ե�����򳫤���
		 * ���Υե�����˵�ư��å���������Ϥ��롣
		 */
		File log = ozFile("logs",getID(),".log");
		out.println("Logging file is "+log);
		stdlog = new ExSyslogStream(new ExPrintStream(new FileOutputStream(log)));
		stdlog.print("OZ Executor start");
		stdlog.println(" on Java "+System.getProperty("java.version"));

		/*
		 * ɸ�����Ϥ����ɤ߹��ޤ��ȡ�JavaVM�Υ������塼�餬��ߤ���Τ�
		 * System.in ��Ȥ��ʤ��褦�ˤ��롣
		 */
		System.setIn(null);

		/*
		 * �����ƥ��ɸ����ϡ�ɸ�२�顼���Ϥ�����Ϥ��ѹ����롣
		 */
		System.setOut(stdlog);
		System.setErr(stdlog);

		/*
		 * ���������塼����ɸ�����ϡ�ɸ����ϡ�ɸ�२�顼���Ϥ����ꤹ�롣
		 */
		stdin = null; // ���ץ����β��������ꤵ��롣
		stdout = out;
		stderr = err;

		/*
		 * ���ޥ�ɥ饤��˻��ꤵ�줿�����β���
		 */

		// ���ʤ��Ȥ⥳�ޥ��̾�����ꤵ��ʤ���Фʤ�ʤ���
		int argc = (args == null) ? 0 : args.length;
		if (argc < 1) usage(1);

		// �����ܤΰ�������ʸ�� - �ǻϤޤ륪�ץ����ʰ�����ޤ�ˤβ���Ԥ���
		int i;
		for (i = 0; i < argc; i ++) {
			String token = args[i];
			if (!token.startsWith("-")) {
				// ʸ�� - �ǻϤޤ�ʤ��Τǥ��ץ����Ͻ����Ǥ��롣
				break;
			} else if (token.equals("-i")) {
				// ���÷�ư��λ���
				// �¤Ϥ���ư��ϥǥե���ȤʤΤǤ�����ʬ�Ǥϲ��⤷�ʤ���
			} else if (token.equals("-s")) {
				// �ץ��ץȤν��Ϥ�Ԥ�ʤ�����
				printPrompt = printPrompt ? false : true;
			} else if (token.equals("-q")) {
				// ���ޥ�ɼ¹�����㳰��ȯ���������̾�ν�λ��³���򳫻Ϥ��롣
				quitOnException = true;
			} else if (token.equals("-e")) {
				// ���������塼����λ������ˡ��̾�ν�λ��³�����餺�˽�λ���롣
				exitImmediately = true;
			} else if (token.equals("-f")) {
				// ������-f <file name>
				// <filename>���饳�ޥ�ɹԤ��ɤ߹��ࡣ
				i ++;
				if (argc <= i) {
					err.println("option "+token+": need <file name>.");
					error(CN,"main","option "+token+" need <file name>.");
					usage(1);
				}
				if (stdin != null) {
					err.println("Ignore option: "+token+" "+args[i]);
					error(CN,"main","Already specified input to read command.");
					error(CN,"main","Ignore option "+token+" "+args[i]);
				} else {
					File file = new File(args[i]);
					try {
						if (!file.isDirectory()) {
							stdin = new FileInputStream(file);
						} else {
							err.println(file.toString()+" is directory.");
							error(CN,"main",file.toString()+" is directory.");
							error(CN,"main","in progress option "+token);
							System.exit(8);
						}
					} catch (Exception e) {
						err.println("Not Found file: "+file);
						error(CN,"main","Not Found file "+file);
						error(CN,"main","in progress option "+token,e);
						System.exit(9);
					}
				}
				printPrompt = false;
			} else if (token.equals("-o")) {
				i ++;
				if (argc <= i) {
					err.println("option "+token+": need <god>.");
					error(CN,"main","option "+token+" need <god>.");
					usage(1);
				}
				try {
					initCellGOD = new ExGOD(args[i]);
					if (!initCellGOD.exists() || !initCellGOD.isDirectory()) {
						err.println("Not found GOD: "+initCellGOD);
						error(CN,"main","Not found GOD "+initCellGOD);
						error(CN,"main","in progress option "+token);
						System.exit(10);
					}
				} catch (Exception e) {
					err.println("Invalid god: "+args[i]);
					error(CN,"main","Invalid god "+args[i]);
					error(CN,"main","in progress option "+token,e);
					System.exit(11);
				}
				printPrompt = false;
			} else if (token.equals("-g")) {
				// �ǥХå��ѥե饰��Ω�Ƥ롣
				debug = true;
			} else if (token.equals("-v")) {
				// ��Ĺɽ���ѥե饰��Ω�Ƥ롣
				verbose = true;
			} else if (token.equals("-h")) {
				// JavaVM����ľ�ˤ��Υ᥽�åɤ�ư������λ�����ˡ��ɽ��������λ���֣��ǽ�λ���롣
				usage(0);
			} else if (token.equals("-t")) {
				printPrompt = true;
				remote = true;
			} else if (token.equals("-n")) {
				noSecurity = true;
				stdlog.println("***** NO SECURITY MANAGER *****");
			} else {
				// �櫓��ʬ����ʤ����ץ�����̵�뤹�롣
				err.println("Ignore option: "+token);
				error(CN,"main","Ignore option "+token);
			}
		}

		// ���������塼�����Τ˰����Ϥ������ʰ��֥ѥ�᡼���ˤ����ꤹ�롣
		// ���ʤ��Ȥ⥳�ޥ��̾���б����������$0 ���б��ˤ�ɬ�פǤ��롣
		if (argc <= i) usage(1); // �����Ϥ⤦�ʤ��Τǡ���λ���֣��ǽ�λ���롣
		String[] arguments = new String[argc-i];
		for (int j = 0; i < argc; i ++, j ++) {
			arguments[j] = args[i];
			// Executor.debug(CN,"main","$"+j+"="+args[i]);
		}

		/*
		 * ���������塼���Υѥ�᡼��������
		 */
		String param;
		param = System.getProperty("oz.user.grace.period");
		if (param != null) {
			try {
				userGracePeriod = Long.parseLong(param);
			} catch (Exception e) {
				error(CN,"main","Warning property oz.user.grace.period",e);
			}
		}
		param = System.getProperty("oz.system.grace.period");
		if (param != null) {
			try {
				systemGracePeriod = Long.parseLong(param);
			} catch (Exception e) {
				error(CN,"main","Warning property oz.system.grace.period",e);
			}
		}

		/*
		 * ���饹�������������롣
		 */
		classLoader = new ExClassLoader();

		/*
		 * �������ƥ��ޥ͡���������ꤹ�롣
		 */
		if (! noSecurity) {
			String value = System.getProperty("oz.security.executionConfirmer");
			if (value == null || value.length() == 0) {
			    securityManager = new ExSecurityManager();
			} else {
			    securityManager = new ExSecurityManager(value);
			}
			System.setSecurityManager(securityManager);
		}

		/*
		 * �̿��Ϥ�ư���롣
		 */
		try {
	  		commManager = new ExCommManager();
		} catch (Exception e) {
			error(CN,"main","in progress for communication system",e);
			System.exit(4);
		}

		/*
		 * �Ź沽�ơ��֥���������롣
		 */
/*
		try {
	  		cipherTable = new ExCipherTable();
		} catch (Exception e) {
			error(CN,"main","in progress for Cipher system",e);
			System.exit(5);
		}
*/

		/*
		 * �������ͽ�ᥳ�ޥ�ɤ���Ͽ����ɬ�פΤ��륯�饹�ǡ�
		 * ���λ�����̤���ɤΥ��饹�ˤĤ��ơ����Υ��饹��
		 * ���Ȥ��뤳�Ȥˤ�ꡢ������˥��ޥ�ɤ���Ͽ�����롣
		 */
		Executor.debug(CN, "main", "load "+ExGOD.class.getName());
		Executor.debug(CN, "main", "load "+ExCellManager.class.getName());

		/*
		 * ���������塼�����ΤǤ��륰���Х륪�֥������Ȥ�
		 * ���������塼���ν�����Ԥ�����åɤ�°���륻���
		 * ����������Τ�������̤ʽ�����Ԥ���
		 */
		try {
			Class c = Executor.loadClass(IPAozSystem+"Executor");
			executor = (Executor)c.newInstance();
			exCell = new ExCell(executor,"Executor");
			Object[] argv = new Object[2];
			argv[0] = new Integer(BOOT);
			argv[1] = arguments;
			String pid = ExProcessManager.fork(exCell, executor, argv);
			OzProcess p = new OzProcess(pid);
			p.join();
		} catch (Exception e) {
			error(CN,"main","in activating Executor",e);
			if (e instanceof ExProcessException) {
				Exception ex = ((ExProcessException)e).getException();
				error(CN,"main","boot process",ex);
			}
			System.exit(6);
		}
		/*
		 * �̾�֡��ȥץ�������λ���뤳�ȤϤʤ���
		 */
		error(CN,"main","Warning: BOOT PROCESS EXITED");
	}

	/**
	 * Usage��ɽ�����ơ�JavaVm��λ���롣
	 *
	 * @param	status	��λ���֡����̤ˡ�����������̣���롣
	 */
	static
	void usage(int status)
	{
		err.println("Usage: java [<java options>...] -Doz.home=<oz home directory>");
		err.println("            "+IPAozSystem+"Executor [<executor options>...]");
		err.println("            <command name> [<position parameters>...]");
		err.println("");
		err.println("executor options:");
		err.println("-i          read commands from stdin(default)");
		err.println("-s          no prompt");
		err.println("-f <file>   read commands from <file>");
		err.println("-g          all debug message on");
		err.println("-h          print this message");
		err.println("-o <god>    activate cell with <god>");
		err.println("-t          remote console(for test)");
		err.println("-n          no security(for test)");
		System.exit(status);
	}

	/**
	 * �ץ�ѥƥ�����ɤ��롣
	 */
	static private
	void loadProperties(File file)
	throws Exception
	{
		FileInputStream in = new FileInputStream(file);
		Properties props = new Properties(System.getProperties());
		props.load(in);
		in.close();
		System.setProperties(props);
	}

	/**
	 * ���˥ե����뤬¸�ߤ�����ϡ��Хå����åץե������������롣
	 *
	 * @param	dirName		�ե�������������ǥ��쥯�ȥ�̾
	 * @param	fileName	��ĥ�Ҥ�����ե�����̾
	 * @param	suffix		��ĥ��̾
	 * @return				�ե�����򼨤����֥�������
	 * @exception		ExException
	 *						���������塼���������㳰��ȯ��������
	 */
	static
	File ozFile(String dirName, String fileName, String suffix)
	throws ExException
	{
		File dir = new File(System.getProperty("oz.home"),dirName);
		File file = new File(dir,fileName+suffix);
		if (dir.exists()) {
			if (!dir.isDirectory()) {
				ExException e = new ExException(dir.toString()+" is not directory.");
				Executor.error(CN,"ozFile","(dirName="+dirName+",fileName="+fileName+",suffix="+suffix+")",e);
				throw e;
			}
		} else {
			if (!dir.mkdirs()) {
				ExException e = new ExException("Can't make directory "+dir);
				Executor.error(CN,"ozFile","(dirName="+dirName+",fileName="+fileName+",suffix="+suffix+")",e);
				throw e;
			}
		}
		if (file.exists()) {
			File backup = new File(dir,fileName+".bak");
			if (backup.exists()) backup.delete();
			file.renameTo(backup);
			file = new File(dir,fileName+suffix);
		}
		return file;
	}

	/**
	 * ���������줿��å��������Ϥ�Ԥ���
	 * ���̷�����header className#methodName: message
	 *					stack trace...
	 * message �� ( �ǻϤޤ���ϡ�: �Ͻ��Ϥ���ʤ���
	 * message �� null �ξ��ϡ�()�����Ϥ���롣
	 *
	 * @param	out			��å������ν�����
	 * @param	header		��å���������Ϥ������Ω�äƽ��Ϥ���ʸ����
	 * @param	className	��å���������Ϥ��褦�Ȥ��Ƥ��륯�饹̾
	 * @param	methodName	��å���������Ϥ��褦�Ȥ��Ƥ���᥽�å�̾
	 * @param	message		���Ϥ����å�������ʸ����
	 * @param	exception	��å���������Ϥ��븶���ˤʤä��㳰
	 */
	private static
	void message(PrintStream out, String header, String className, String methodName, String message, Throwable exception)
	{
		try {
			if (className == null) {
				out.println((header==null)?message:header+message);
			} else {
				StringBuffer buffer = new StringBuffer();
				if (header != null) buffer.append(header);
				buffer.append(className);
				if (methodName == null) {
					buffer.append(": ");
				} else {
					buffer.append("#"+methodName);
					if (message == null) {
						buffer.append("()");
					} else if (!message.startsWith("(")) {
						buffer.append(": ");
					}
				}
				if (message != null) buffer.append(message);
				out.println(buffer);
			}
			if (exception != null) {
				exception.printStackTrace(out);
			}
		} catch (Throwable e) {
			e.printStackTrace(stderr);
		}
	}

	/**
	 * ���������줿��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String methodName, String message, Throwable exception)
	{
		Executor.message(stdout, null, className, methodName, message, exception);
	}

	/**
	 * ���������줿��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String methodName, Throwable exception)
	{
		Executor.message(className, methodName, null, exception);
	}

	/**
	 * ���������줿��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String methodName, String message)
	{
		Executor.message(className, methodName, message, null);
	}

	/**
	 * ���������줿��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String className, String message)
	{
		Executor.message(className, null, message, null);
	}

	/**
	 * ���������줿��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void message(String message)
	{
		Executor.message(null, null, message, null);
	}

	/**
	 * ���������줿�ǥХå��ѥ�å��������Ϥ�Ԥ���
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String methodName, String message, Throwable exception)
	{
		if (!debug) return;
		Executor.message(stdout, null, className, methodName, message, exception);
	}

	/**
	 * ���������줿�ǥХå��ѥ�å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String methodName, Throwable exception)
	{
		Executor.debug(className, methodName, null, exception);
	}

	/**
	 * ���������줿�ǥХå��ѥ�å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String methodName, String message)
	{
		debug(className, methodName, message, null);
	}

	/**
	 * ���������줿�ǥХå��ѥ�å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String className, String message)
	{
		debug(className, null, message, null);
	}

	/**
	 * ���������줿�ǥХå��ѥ�å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#debug(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void debug(String message)
	{
		debug(null, null, message, null);
	}

	/**
	 * ���������줿���顼��å��������Ϥ�Ԥ���
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#message(java.io.PrintStream,java.lang.String,java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String methodName, String message, Throwable exception)
	{
		// Executor.message(stderr, null, className, methodName, message, exception);
		synchronized (stdlog) {
			Executor.message(stdlog, null, className, methodName, message, exception);
		}
	}

	/**
	 * ���������줿���顼��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String methodName, Throwable exception)
	{
		error(className, methodName, null, exception);
	}

	/**
	 * ���������줿���顼��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String methodName, String message)
	{
		error(className, methodName, message, null);
	}

	/**
	 * ���������줿���顼��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String className, String message)
	{
		error(className, null, message, null);
	}

	/**
	 * ���������줿���顼��å��������Ϥ�Ԥ�����Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * @see	Executor#error(java.lang.String,java.lang.String,java.lang.String,java.lang.Throwable);
	 */
	static
	void error(String message)
	{
		error(null, null, message, null);
	}

	/**
	 * ���������줿��å���������˽��Ϥ��롣
	 * �ܺ٤Ͼ�ά���롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ��������ʥ��饹�Υ������ˤϡ����������塼�����Ȥ�
	 * ��ư����Ƥ��ʤ��Τǡ���å���������˽��Ϥ��뤿���
	 * ����åɤ������Ǥ��ʤ���
	 * </DL>
	 *
	 * @see	Executor#message(PrintStream, String, String, String, String, Throwable)
	 */
	static
	void syslog(String className, String methodName, String message, Throwable exception)
	{
		if (exCell == null) {
			synchronized (stdlog) {
				message(stdlog, null, className, methodName, message, exception);
			}
		} else {
			Object[] params = new Object[5];
			params[0] = new Integer(Executor.SYSLOG);
			params[1] = className;
			params[2] = methodName;
			params[3] = message;
			params[4] = exception;
			try {
				syscall(params).join();
			} catch (ExProcessException e) {
				Executor.error(CN,"syslog","From "+className, e.getException());
			} catch (Exception e) {
				Executor.error(CN,"syslog","From "+className, e);
			}
		}
	}

	/**
	 * ���������줿��å���������˽��Ϥ��뤿��Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 */
	static
	void syslog(String className, String methodName, Throwable exception)
	{
		syslog(className, methodName, null, exception);
	}

	/**
	 * ���������줿��å���������˽��Ϥ��뤿��Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 */
	static
	void syslog(String className, String methodName, String message)
	{
		syslog(className, methodName, message, null);
	}

	/**
	 * ���������줿��å���������˽��Ϥ��뤿��Ρ���ά�����Υ᥽�åɤǤ��롣
	 * �ܺ٤Ͼ�ά���롣
	 */
	static
	void syslog(String className, String message)
	{
		syslog(className, null, message, null);
	}

	/**
	 * ���֥������Ȥ򤽤λ��Ȥ�ޤ��ʣ�����롣�Хץ����Τߤ�
	 * �Х��֥������Ȥ��Х��֥������ȤȤ���ʣ�����뤳�Ȥ���ǽ�Ǥ��롣
	 *
	 * @param	srcObj	ʣ�����륪�֥�������
	 * @param	secure	�Хץ����λ��˰�̣�����ꡢtrue �ʤ�С�
	 *					�Х��֥������Ȥ��֥��֥������ȤȤ���ʣ�����롣
	 * @exception	ExException
	 *					���������塼���������㳰��ȯ��������
	 */
	static
	Object duplicate(Object srcObj,boolean secure)
	throws ExException
	{
		Object newObj = null;
		boolean action = true;

		// Executor.debug(CN,"duplicate","("+srcObj+")");
		if (srcObj == null) return newObj;
		ByteArrayOutputStream byteOutputs = new ByteArrayOutputStream(128);
		ExObjectInputStream objectInputs;
		try {
			ExObjectOutputStream objectOutputs = new ExObjectOutputStream(byteOutputs);
			objectOutputs.writeObject(srcObj);
			// Executor.debug(CN,"duplicate","buffer length = "+byteOutputs.toByteArray().length);
			ByteArrayInputStream byteInputs = new ByteArrayInputStream(byteOutputs.toByteArray());
			objectInputs = new ExObjectInputStream(byteInputs);
		} catch (Exception e) {
			/*
			 * �����㳰�����ꤵ��뤬��������Ʊ�����Ҥˤʤ뤿�� Exception �Ȥ��ƤޤȤ�Ƥ��롣
			 * IOException, StreamCorruptedException
			 */
			Executor.error(CN,"duplicate(","srcObj="+srcObj+",secure="+secure,e);
			throw new ExException(e.getClass().getName());
		}
		if (secure) {
			Thread current = Thread.currentThread();
			if (current instanceof ExThread) {
				ExThread t = (ExThread)current;
				if (t.color == ExThread.GREEN) {
					try {
						t.color = ExThread.RED;
						action = false;
						newObj = objectInputs.readObject();
					} catch (Exception e) {
						/*
						 * �����㳰�����ꤵ��뤬��������Ʊ�����Ҥˤʤ뤿�� Exception �Ȥ��ƤޤȤ�Ƥ��롣
						 * OptionalDataException IOException ClassNotFoundException
						 */
						Executor.error(CN,"duplicate(","srcObj="+srcObj+",secure="+secure,e);
						throw new ExException(e.getClass().getName());
					} finally {
						t.color = ExThread.GREEN;
					}
				}
			}
		}
		try {
			if (action) newObj = objectInputs.readObject();
			// Executor.debug(CN,"duplicate","() = "+newObj);
		} catch (Exception e) {
			/*
			 * �����㳰�����ꤵ��뤬��������Ʊ�����Ҥˤʤ뤿�� Exception �Ȥ��ƤޤȤ�Ƥ��롣
			 * OptionalDataException ClassNotFoundException
			 */
			Executor.error(CN,"duplicate(","srcObj="+srcObj+",secure="+secure,e);
			throw new ExException(e.getClass().getName());
		}

		return (Object)newObj;
	}

	/**
	 * ��󥿥��ॵ���ӥ���������뤿��Υץ������������롣
	 *
	 * @param	params	��󥿥��ॵ���ӥ��Υѥ�᡼��
	 */
	static
	OzProcess syscall(Object[] params)
	{
		String pid = ExProcessManager.fork(exCell,executor,params);
		return new OzProcess(pid);
	}

	/**
	 * ���饹�Υ��ɤ��®�˹Ԥ������
	 * ���饹������ľ�ܸƤӽФ���
	 *
	 * @param	codePath	���饹��full qualified class name
	 * @return				class���֥�������
	 */
	static
	Class loadClass(String codePath)
	throws ClassNotFoundException
	{
		Executor.debug(CN,"loadClass","("+codePath+")");
		Class c = null;
		try {
			c = classLoader.loadClass(codePath);
		} catch (ClassNotFoundException e) {
			Executor.debug(CN,"loadClass","codePath="+codePath,e);
			throw e;
		}
		return c;
	}


/*
 * ����ʹߤϥ��󥹥��󥹤Ȥ��Ƥ�ư��򵭽Ҥ��롣
 */



	/**
	 * ���������塼�������̤ʥ����Х륪�֥������ȤǤ��ꡢ
	 * �ץ����Ϥʤ���
	 */
	Executor()
	throws Exception
	{
		super(""); // �㳰��ȯ�������ʤ�����ˡ���ʸ�������ꡣ
	}

	/**
	 * OZ�κǽ�Υץ����Ȥ��Ƶ�ư�����᥽�åɤǤ��롣
	 * ���������塼���ε�ư�ϡ����Υ᥽�åɤθƽФ��Ǵ�λ���롣
	 * �̾���Υ᥽�åɤ���λ���뤳�ȤϤʤ���
	 *
	 * @param	args	JavaVM��ư�������˻��ꤵ�줿���ޥ��̾��
	 *					���֥ѥ�᡼�����������ꤹ�롣
	 * @exception	Exception
	 *					�㳰��ȯ���ϡ����餫�ΥХ����㳲���̣���롣
	 *					
	 */
	private
	void boot(String[] args)
	throws Exception
	{
		/*
		 * ɸ�����Ϥ���ꤹ�롣
		 */
		if (remote) {
			 // ��⡼�ȤΥ��󥽡����������롣â�����¸��Τ���μ����Ǥ��롣
			out.println("Wait to accept for "+getID());
			Socket socket = serverport.accept();
			message(CN,"Remote console is "+socket);
			syslog(CN,"Remote console is "+socket);
			socket.setTcpNoDelay(true);
			stdin = new BufferedInputStream(socket.getInputStream());
			stdout = new ExPrintStream(socket.getOutputStream());
			stderr = new ExPrintStream(socket.getOutputStream());
		} else if (stdin == null) {
			// �ǥե����ư��������Ԥ���
			if (stdin == null) {
				// ���ޥ�ɤ��ɤ߹�����λؼ����ʤ��Τǥǥե����ư�������򤹤롣
				stdin = Executor.in;
			}
		}

		/*
		 * ���������塼����ư��Ƥ��뤳�Ȥ��ǧ���뤿���
		 * �������Хå��Ǥ��롣â�����¸��Τ���μ����Ǥ��롣
		 */
		if (! remote) {
			Object[] params = new Object[2];
			params[0] = new Integer(Executor.ECHO);
			params[1] = null;
			new OzProcess(this, this, params);
		}

		/*
		 * ���������塼���Υ������ư���롣
		 */
		Reader in;
		if (initCellGOD == null) in = new ExInputStreamReader(stdin);
		else in = new StringReader("go "+initCellGOD.getName()+" $0 $*;"+"watch "+initCellGOD.getName()+";");
		ExShell shell = new ExShell(in, new PrintWriter(stdout,true), new PrintWriter(stderr,true));
		if (printPrompt) {
			shell.action(CN+">", args);
		} else {
			shell.action(args);
		}
		exit(0);
	}

	/**
	 * ���ꤵ�줿���֤��вᤷ���塢����Ū�˥��������塼������ߤ�����
	 * ���������塼���ν�λ���Ԥ�����֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ε�ư�ʥ���γ������ˤ˻پ㤬�ʤ��褦�ˡ�
	 * ����¤ν�����Ԥ��褦�˺���¤�ư��뤬��
	 * ���������塼���ν�λ�ϹԤ�ʤ���
	 * <DT>
	 * �ڥ���<DD>
	 * �㳰��throw���ʤ����ȡ�
	 * </DL>
	 *
	 * @param	gracePeriod		�����򳫻Ϥ���ޤǤ��Ԥ����֡ʥߥ��á�
	 */
	private
	void halt(long gracePeriod)
	{
		Executor.debug(CN,"halt","("+gracePeriod+")"); // for debug

		/*
		 * ̵�������ƤΥ������������ξ��֤ˤ��롣
		 */
		try {
			if (gracePeriod != 0) Thread.sleep(gracePeriod);
			ExCellManager.halt(systemGracePeriod);
		} catch (Exception e) {
			error(CN,"halt","halt ExCellManager in progress",e);
		}

		return;
	}

	/**
	 * ���������塼����λ���롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ��λ�����򳫻Ϥ����顢�㳰��ȯ�����Ƥ�
	 * ��λ��������ߤ��Ƥʤ�ʤ���
	 * <DT>
	 * ����ա�<DD>
	 * �֡��ȥ��å׸�Υ��������塼���ϡ�ɬ�����Υ᥽�åɤ�
	 * ��λ�����ʤ���Фʤ�ʤ���
	 * <DT>
	 * �ڥ���<DD>
	 * �㳰��throw���ʤ����ȡ�
	 * </DL>
	 *
	 * @param	status	��λ���ơ�����
	 */
	private
	void exit(int status)
	{
		Executor.debug(CN,"exit","("+status+")"); // for debug

		/*
		 * ��������Ϥ���ߤ��롣
		 */
		stdlog.println("***** SHUTDOWN: CellManager *****");
		try {
			ExCellManager.shutdown(userGracePeriod);
		} catch (Exception e) {
			error(CN,"exit","shutdown cell manager in progress",e);
		}

		/*
		 * �̿������Ϥ���ߤ��롣
		 */
		nice(2);
		stdlog.println("***** SHUTDOWN: CommManager *****");
		try {
			commManager.shutdown();
		} catch (Exception e) {
			error(CN,"exit","shutdown communication manager in progress",e);
		}

		nice(-2);
		stdlog.println("OZ Executor exit("+status+")");
		System.exit(status);
		return;
	}

	/**
	 * ���������塼����ư��Ƥ��뤳�Ȥ��ǧ���뤿���
	 * �������Хå��Ǥ��롣â�����¸��Τ���μ����Ǥ��롣
	 */
	private
	void echo(Socket socket)
	throws Exception
	{
		if (socket == null) {
			while (true) {
				socket = serverport.accept();
				Object[] args = new Object[2];
				args[0] = new Integer(Executor.ECHO);
				args[1] = socket;
				new OzProcess(this, this, args);
			}
		} else {
			InputStream in = new BufferedInputStream(socket.getInputStream());
			OutputStream out = new BufferedOutputStream(socket.getOutputStream());
			try {
				while (true) {
					int data = in.read();
					out.write(data);
				}
			} catch (Exception e) {
			}
		}
	}

	/**
	 * ���Υ᥽�åɤ�¹Ԥ��Ƥ��륹��åɤ�ͥ���̤򲼤��롣
	 *
	 * @param	decrement	ͥ���̤򲼤����ٹ礤����
	 */
	private
	void nice(int decrement)
	{
		ExThread t = (ExThread)Thread.currentThread();
		t.setPriority(t.getPriority()-decrement);
	}

	/**
	 * ���������塼����¿���Υ����ॵ���ӥ���
	 * �̥���åɤǼ¹Ԥ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���Υ᥽�åɤμ¹ԤϺ����ͥ���̤ǹԤ���
	 * �᥽�å� invoke �Ǥ�ɬ�פ�ͥ���̤��ѹ���
	 * �Ԥ��뤳�Ȥ��ꤹ�롣
	 * <DT>
	 * �ڥ���<DD>
	 * ɬ������ɬ�פǤʤ���ʬ���ޤޤ�Ƥ��뤬��
	 * ����ͥ�μ����λ��Ȥߤ˹�碌��
	 * �ǥХå����ưפˤ��뤿��Ǥ��롣
	 * </DL>
	 */
	public
	void run()
	{
		Object result;
		boolean status;

		try {
			ExThread t = (ExThread)Thread.currentThread();
			t.setPriority(Thread.MAX_PRIORITY);
			ExCalleeChannel callee = t.channel;
			Object object = callee.object();
			Object[] arguments = callee.arguments();
			try {
				result = invoke(object, arguments);
				status = true;
			} catch (Exception e) {
				Executor.debug(CN,"run",e);
				result = e;
				status = false;
			}
			callee.exit(status, result);
		} catch (Exception e) { // unexpect exception
			Executor.error(CN,"run",e);
		}
	}

	/**
	 * �������ץ������������ƽ�����¹Ԥ��뤿��˸ƤӽФ���롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����å�ͥ���̤Ϻ�������ꤵ��Ƥ��뤳�Ȥ�����ˤ��Ƥ��롣
	 * <DT>
	 * �ڥ���<DD>
	 * ɬ������ɬ�פǤʤ���ʬ���ޤޤ�Ƥ��뤬��
	 * ����ͥ�μ����λ��Ȥߤ˹�碌��
	 * �ǥХå����ưפˤ��뤿��Ǥ��롣
	 * </DL>
	 *
	 * @param	object	�᥽�åɤ�ƤӽФ��о�
	 * @param	args	�᥽�åɤ�ƤӽФ��ݤ�ɬ�פȤʤ����
	 * @return			�᥽�åɤμ¹Է��
	 *
	 */
	protected
	Object invoke(Object object,Object[] args)
	throws Exception
	{
		Object result = null;
		int selector = ((Integer)args[0]).intValue();
		Executor.debug(CN,"invoke","RUNTIME SERVICE No."+selector);
		switch (selector) {

		// ���饹 Executor �Ǽ�������Ƥ�����
		case BOOT:
			/* Maximum priprity */
			boot((String[])args[1]);
			break;
		case EXIT:
			/* Maximum priprity */
			exit(((Integer)args[1]).intValue());
			break;
		case SYSLOG:
			/* Maximum priprity */
			synchronized (stdlog) {
				message(stdlog, null, (String)args[1], (String)args[2], (String)args[3], (Throwable)args[4]);
			}
			break;
		case HALT:
			nice(1);
			halt(((Long)args[1]).longValue());
			break;
		case ECHO:
			/* Maximum priprity */
			echo((Socket)args[1]);
			break;

		// ���饹 ExCellManager �Ǽ�������Ƥ�����
		case CREATE:
			nice(3);
			ExCellManager.create((String)args[1], (ExProxy)args[2]);
			break;
		case GO:
			nice(3);
			ExCellManager.activate((ExProxy)args[1]);
			break;
		case STOP:
			nice(2);
			ExCellManager.deactivate((ExProxy)args[1]);
			break;
		case REMOVE:
			nice(2);
			ExCellManager.remove((ExProxy)args[1]);
			break;
		case FLUSH:
			/* Maximum priprity */
			ExCellManager.flush((ExProxy)args[1]);
			break;
		case QUIT:
			/* Maximum priprity */
			if (args.length == 3 && args[2] != null) {
				long gracePeriod = Long.parseLong((String)args[2]);
				ExCellManager.quit((ExGOD)args[1],gracePeriod);
			} else {
				ExCellManager.quit((ExGOD)args[1],userGracePeriod);
			}
			break;

		// ���饹 ExClassLoader �Ǽ�������Ƥ�����
		case LOADCLASS:
			nice(3);
			result = classLoader.loadClass((String)args[1]);
			break;
		case LOADPACKAGE:
			nice(3);
			classLoader.loadPackage((String)args[1]);
			break;

		// ���饹 ExAddressResolver �Ǽ�������Ƥ�����
		case RESOLVE:
			/* Maximum priprity */
			result = ExAddressResolver.resolve((String)args[1], (ExCommAddress)args[2]);
			break;

		default:
			throw new Exception(CN+": invalid fork selector = "+selector);
		}
		return result;
	}

	public
	String toString()
	{
		return CN;
	}


	/*
	 * ����ʹߤϥǥХå��ȥ�����Τ���Υץ����Ǥ��롣
	 * �ʾܺ٤Ͼ�ά��
	 */
	static {

		/**
		 * ���饹����ɤ��롣
		 * ������ʤ顢ExClassLoader ����Ͽ�����ߤ�����
		 */
		class Load
		extends ExShellCommand
		{
			Load()
			{
				usage = " <codePath>|<package name>. [...]";
				comment = "load class or package";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				for (int i = 1; i < args.length; i ++ ) {
					String codePath = (String)args[i];
					if (codePath.startsWith("released.")) {
						codePath = Executor.IPAozUser+codePath;
					} else if (codePath.startsWith("user.")) {
						codePath = Executor.IPAoz+codePath;
					} else if (codePath.startsWith("system.")) {
						codePath = Executor.IPAoz+codePath;
					} else if (codePath.startsWith("tools.")) {
						codePath = Executor.IPA+codePath;
					} else if (codePath.startsWith("tests.")) {
						codePath = Executor.IPA+codePath;
					}
					if (codePath.endsWith(".")) {
					    codePath = codePath.substring(0,codePath.length()-1);
					    OzClassLoader.loadPackage(codePath);
					} else {
					    OzClassLoader.loadClass(codePath);
					}
				}

				return null;
			}
		}

		/**
		 * ���꤬�������ʤ��ʤ�ޤ�GC��¹Ԥ��롣
		 */
		class GarbageCollect
		extends ExShellCommand
		{
			GarbageCollect()
			{
				usage = " ";
				comment = "do GC";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				/*
				 * ����β�����Ǥ��ʤ��ʤ�ޤ�GC��Ԥ���
				 */
				Runtime runtime = Runtime.getRuntime();
				long size = 0;
				long a;
				long b = runtime.freeMemory();
				do {
					a = b;
					shell.stdout.print(".");
					shell.stdout.flush();
					runtime.gc();
					runtime.runFinalization();
					b = runtime.freeMemory();
					size += (b - a);
				} while( a != b );
				shell.stdout.println("\nGC size: "+size);

				return null;
			}
		}

		/**
		 * �ǥХå��Τ���Υե饰��on/off���롣
		 */
		class Debug
		extends ExShellCommand
		{
			Debug()
			{
				usage = " [<god>] [true|false]";
				comment = "debug flag on/off";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length > 3) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				String gol = Executor.CN;
				boolean debug = true;
				if (args.length == 1) {
					debug = Executor.debug;
				} else {
					String arg = args[args.length-1].toLowerCase();
					if (arg.equals("true")||arg.equals("on")) {
						if (args.length == 2) {
							debug = Executor.debug = true;
						} else {
							ExCell cell = ExCellManager.get(new ExGOD(args[1]));
							if (cell == null) {
								throw new IllegalArgumentException(args[0]+": Not found cell("+args[1]+")");
							}
							gol = cell.getName();
							debug = cell.debug = true;
						}
					} else if (arg.equals("false")||arg.equals("off")) {
						if (args.length == 2) {
							debug = Executor.debug = false;
						} else {
							ExCell cell = ExCellManager.get(new ExGOD(args[1]));
							if (cell == null) {
								throw new IllegalArgumentException(args[0]+": Not found cell("+args[1]+")");
							}
							gol = cell.getName();
							debug = cell.debug = false;
						}
					} else {
						if (args.length == 3) {
							throw new IllegalArgumentException(args[0]+": Unknown keyword '"+args[2]+"'");
						}
						ExCell cell = ExCellManager.get(new ExGOD(args[1]));
						if (cell == null) {
							throw new IllegalArgumentException(args[0]+": Not found cell("+args[1]+")");
						}
						gol = cell.getName();
						debug = cell.debug;
					}
				}

				shell.stdout.println(gol+" debug is "+debug);
				return null;
			}
		}

		/**
		 * ���������塼����λ���롣
		 */
		class Exit
		extends ExShellCommand
		{
			Exit()
			{
				usage = " [<status>]";
				comment = "exit executor";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (shell.subShell) {
					Executor.debug(CN,"Exit","subshell don't exit executor");
					return null;
				}

				if (args.length > 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				int status = 0;
				if (args.length == 2) {
					status = Integer.parseInt(args[1]);
				}

				if (ExCellManager.isEmpty()) {
					/*
					 * ��λ���������Ϥ�������ˡ������ʥ��뤬������������ǽ�����롣
					 * �����������Υ��ޥ�ɤǤϱʱ�˽�λ�Ǥ��ʤ��Τ�̵�뤹�롣
					 */
					Object[] params;
					params = new Object[2];
					params[0] = new Integer(Executor.EXIT);
					params[1] = new Integer(status);
					syscall(params).join();
				} else {
					shell.stderr.println("Found "+ExCellManager.size()+" active cell(s)");
				}

				return null;
			}
		}

		/**
		 * ���������塼��������λ���롣
		 */
		class Quit
		extends ExShellCommand
		{
			Quit()
			{
				usage = " ";
				comment = "quit executor";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (shell.subShell) {
					Executor.debug(CN,"Quit","subshell don't quit executor");
					return null;
				}

				if (args.length != 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				Object[] params;

				/*
				 * �������Ū����������ξ��֤ˤ��롣
				 */
				params = new Object[2];
				params[0] = new Integer(HALT);
				params[1] = new Long(0);
				try {
					Executor.syscall(params).join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				/*
				 * ���������塼����λ���롣
				 */
				params = new Object[2];
				params[0] = new Integer(EXIT);
				params[1] = new Integer(0);
				try {
					Executor.syscall(params).join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				/*
				 * ����ʹߤ��¹Ԥ���뤳�ȤϤʤ���
				 */

				return null;
			}
		}

		/**
		 * ���������塼�����̾ｪλ���롣
		 */
		class Shutdown
		extends ExShellCommand
		{
			Shutdown()
			{
				usage = " ";
				comment = "shutdown executor";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (shell.subShell) {
					Executor.debug(CN,"Shutdown","subshell don't shutdown executor");
					return null;
				}

				if (args.length != 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				/*
				 * ���������塼����λ���롣
				 */
				Object[] params;
				params = new Object[2];
				params[0] = new Integer(EXIT);
				params[1] = new Integer(0);
				try {
					Executor.syscall(params).join();
				} catch (ExProcessException e) {
					throw e.getException();
				}

				/*
				 * ����ʹߤ��¹Ԥ���뤳�ȤϤʤ���
				 */

				return null;
			}
		}

		/**
		 * �ץ�ѥƥ�������������롣
		 */
		class Prop
		extends ExShellCommand
		{
			Prop()
			{
				usage = " [<key>]";
				comment = "print system properties";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length == 1) {
					Properties props = System.getProperties();
					props.list(shell.stdout);
				} else {
					for (int i = 1; i < args.length; i ++) {
						String value = System.getProperty(args[i]);
						if (value != null) {
							shell.stdout.println(args[i]+"="+value);
						} else {
							shell.stdout.println(args[i]+" is not found");
						}
					}
				}

				return null;
			}
		}

		ExShell.append("exit",new Exit());
		ExShell.append("load",new Load());
		ExShell.append("gc",new GarbageCollect());
		ExShell.append("debug",new Debug());
		ExShell.append("quit",new Quit());
		ExShell.append("shutdown",new Shutdown());
		ExShell.append("prop",new Prop());
	}
}
