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
 * $Id: ExGOD.java,v 2.1.1.1 1997/07/15 06:20:46 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.util.Enumeration;

/**
 * ���Υ��饹��GOD�ʥ����Х륪�֥������ȥǥ��쥯�ȥ�ˤ�
 * ��¾�����դ��Υե�����(java.io.File)�Ȥ�����ݲ����롣
 * ���Υ��饹�ˤ�ä���������GOD���֥������Ȥ�Ȥäơ�
 * ���������塼����GOD������Ԥ���
 * GOD���å����֤ˤ���GOD���֥������ȤΤߤ�GOD��
 * ���å����֤ˤ��뤳�Ȥ��Ǥ��롣
 * �ޤ���GOD���å����֤ˤ���GOD���֥������Ȥ�
 * ���ꥢ�饤�����оݤȤ��ƤϤʤ�ʤ���
 * GOD���֥������Ȥ��������줿�������������塼����
 * �ǤΤ�ͭ���Ǥ��ꡢGOD���֥������Ȥ�¸�ߤ�ɬ������
 * GOD��¸�ߤ��̣���ʤ���
 *
 * <DL><DT>
 * ����ա�<DD>
 * GOD̾�η�����'.'���ڤ��ʸ����Ǥ��ꡢ����ΣϣӤΥѥ���
 * ���ڤ�ˤʤ��ǽ���Τ���ʸ����OZ�ۡ���̾�ζ��ڤ�ʸ����ޤ�ǤϤ����ʤ���
 * �ޤ���ʸ�����ξü�����ڤ��ʸ���Ǥ��äƤϤʤ�ʤ���
 * <DT>
 * ����ա�<DD>
 * java.io.File �� implements java.io.Serializable ��
 * �ʤäƤ��뤿�ᡢ���饹�Σɡ��ƤȤ��Ƥϥ��ꥢ�饤����
 * �Ǥ��뤳�Ȥˤʤ뤬��GOD���֥������Ȥϥ��饹 FileInputStream
 * �η����ѿ�����ĤΤǡ����ʤ��Ȥ��å����ݻ������ޤޤ�
 * ���ꥢ�饤�����뤳�ȤϤǤ��ʤȻפ��롣
 * <DT>
 * �ڥ���<DD>
 * ��GOD̾�פϡ�GOD��ʸ����Ǥ�ɽ�����̣���롣
 * </DL>
 *
 * @see	ExGOL
 *
 * @version		$Revision: 2.1.1.1 $, $Date: 1997/07/15 06:20:46 $
 * @author		Yasumitsu Yoshida
 */
final
class ExGOD
extends File
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExGOD";

	/**
	 * OZ�ۡ��಼��GOD�Υ롼�ȤؤΥѥ����ݻ����롣
	 * â�����ص���Τ���˥ե����륻�ѥ졼��
	 * (file.separator)ʸ���ǽ�ü���Ƥ��롣
	 */
	private static final
	String objectsPath = System.getProperty("oz.home")
							+separator+"objects"+separator;

	/**
	 * �����Х륪�֥������ȥǥ��쥯�ȥ��GOD��̾�ζ��ڤ�ʸ����
	 */
	static final String godSeparator = ".";

	/**
	 * �����Х륪�֥������ȥǥ��쥯�ȥ��GOD��̾�ζ��ڤ�ʸ��
	 */
	static final char godSeparatorChar = godSeparator.charAt(0);

	/**
	 * ���å����֤Ǥ��뤳�Ȥ򼨤��ե�����̾
	 */
	private static final String unlockFilename = ".inactive";

	/**
	 * ��å����֤Ǥ��뤳�Ȥ򼨤��ե�����̾�Υ١���̾
	 */
	private static final String lockedBaseFilename = ".lock.";

	/**
	 * ��å����֤Ǥ��뤳�Ȥ򼨤��ե�����̾
	 */
	private static final
	String lockedFilename = lockedBaseFilename +Executor.getID();

	/**
	 * GOD̾���ݻ����롣
	 */
	private String god;

	/**
	 * ���å����֤Ǥ��뤳�Ȥ򼨤��ե�������ݻ�����
	 */
	private File unlock;

	/**
	 * ��å����֤Ǥ��뤳�Ȥ򼨤��ե�������ݻ�����
	 */
	private File locked;

	/**
	 * ��¾����ե�����ؤν��Ϥ��ݻ����롣
	 * ����GOD���֥������Ȥ���å���������Ƥ����Ȥ򼨤���
	 *
	 * <DL><DT>
	 * �ڥ���<DD>
	 * GOD�ؤΥǥХå�������Ȥ��ƻȤ����ǽ�������롣
	 * <DT>
	 * ����ա�<DD>
	 * Windows NT �ǤǤϥ����ץ���Υե������̾����
	 * �᥽�å� renameTo ��Ȥä��ѹ����뤳�ȤϤǤ��ʤ���
	 * ���餯�ϡ��᥽�å� delete ��Ȥäƺ����Ǥ��ʤ��Ȼפ��롣
	 * </DL>
	 */
	private FileOutputStream lock = null;

	/**
	 * GOD̾��Ŭ�ڤʷ����Ǥ��뤫��Ĵ�٤롣
	 * â��������GOD̾��GOL�ΰ����Ȥ���Ŭ�ڤʷ����Ǥ��뤫��Ĵ�٤ʤ���
	 *
	 * <DL><DT>
	 * �ڥ���<DD>
	 * �̾�ϥ��饹 ExGOL ��Ȥäƺ����������֥������Ȥ��ͳ����
	 * GOD���֥������Ȥ�����Τǡ����λ�����GOD̾��GOL�ΰ����Ȥ���
	 * Ŭ�ڤʷ����Ǥ��뤳�Ȥϳ�ǧ����Ƥ��롣
	 * </DL>
	 *
	 * @param	god		GOD̾
	 * @exception	ExGOLFormatException
	 *					GOD̾�η������������ʤ���
	 */
	static void check(String god)
	throws ExGOLFormatException
	{
		if (god.startsWith(godSeparator)) {
			throw new ExGOLFormatException(
				"GOD start with separator '"+godSeparator+"'");
		}
		if (god.endsWith(godSeparator)) {
			throw new ExGOLFormatException(
				"GOD end with seprator '"+godSeparator+"'");
		}
		if (0 <= god.indexOf(pathSeparator)) {
			throw new ExGOLFormatException(
				"GOD include path separator '"+pathSeparator+"'");
		}
		if (0 <= god.indexOf(separator)) {
			throw new ExGOLFormatException(
				"GOD include file separator '"+separator+"'");
		}
	}

	/**
	 * ��������Ԥ�
	 *
	 * @param	god		GOD̾
	 */
	private
	void init0(String god)
	{
		this.god = god;
		unlock = new File(this,unlockFilename);
		locked = new File(this,lockedFilename);
	}

	/**
	 * GOD̾��Ŭ�ڤǤ��뤳�Ȥ��ǧ������ǽ�������Ԥ�
	 *
	 * @param	god		GOD̾
	 * @exception	ExGOLFormatException
	 *					GOD̾�η������������ʤ���
	 */
	private
	void init(String god)
	throws ExGOLFormatException
	{
		check(god);
		init0(god);
	}

	/**
	 * GOD̾����ꤷ��GOD���֥������Ȥ�������롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * GOL�ΰ����Ȥ�����Ŭ�ڤʷ�����GOD̾����ꤷ��GOD���֥������Ȥ�
	 * �������뤳�Ȥ��Ǥ���Τ���դ��뤳�ȡ�
	 * </DL>
	 *
	 * @param	god		GOD̾
	 * @exception	ExGOLFormatException
	 *					GOD�η������������ʤ���
	 */
	public ExGOD(String god)
	throws ExGOLFormatException
	{
		super(objectsPath+god.replace(godSeparatorChar,separatorChar));
		init(god);
	}

	/**
	 * �Ƥ�GOD̾����ꤷ��GOD���֥������Ȥ�������롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * GOL�ΰ����Ȥ�����Ŭ�ڤʷ�����GOD̾����ꤷ��GOD���֥������Ȥ�
	 * �������뤳�Ȥ��Ǥ���Τ���դ��뤳�ȡ�
	 * </DL>
	 *
	 * @param	god		GOD̾
	 * @param	name	GOD̾�ζ��ڤ�ʸ����ޤޤʤ��Ҥ�GOD̾
	 * @exception	ExGOLFormatException
	 *					GOD̾�η������������ʤ���
	 */
	public ExGOD(String god, String name)
	throws ExGOLFormatException
	{
		super(objectsPath+god.replace(godSeparatorChar,separatorChar),name);
		init(god+godSeparator+name);
	}

	/**
	 * �Ƥ�GOD���֥������Ȥ���ꤷ��GOD���֥������Ȥ�������롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * GOL�ΰ����Ȥ�����Ŭ�ڤʷ�����GOD̾����ꤷ��GOD���֥������Ȥ�
	 * �������뤳�Ȥ��Ǥ���Τ���դ��뤳�ȡ�
	 * </DL>
	 *
	 * @param	god		GOD���֥�������
	 * @param	name	GOD̾�ζ��ڤ�ʸ����ޤޤʤ��Ҥ�GOD̾
	 * @exception	ExGOLFormatException
	 *					GOD̾�η������������ʤ���
	 */
	public ExGOD(ExGOD god, String name)
	throws ExGOLFormatException
	{
		super(god,name);
		init(god.getName()+godSeparator+name);
	}

	/**
	 * GOL���֥������Ȥ���ꤷ��GOD���֥������Ȥ�������롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * GOL���֥������ȤϾ�˷����Ȥ���������GOD̾��
	 * ���äƤ���Τǡ������ǤϺ��٥����å��Ϥ��ʤ���
	 * </DL>
	 *
	 * @param	gol		GOL�Υ��֥�������
	 * @exception	ExCellIllegalOzHomeException
	 *					OZ�ۡ���̾���ۤʤ�Τǰ�̣���ʤ���
	 */
	public ExGOD(ExGOL gol)
	throws ExCellIllegalOzHomeException
	{
		super(objectsPath+gol.getGOD().replace(godSeparatorChar,separatorChar));
		init0(gol.getGOD());
	}

	/**
	 * �ץ�������ꤷ��GOD���֥������Ȥ�������롣
	 *
	 * @param	proxy	�ץ����Υ��֥�������
	 * @exception	ExCellIllegalOzHomeException
	 *					OZ�ۡ���̾���ۤʤ�Τǰ�̣���ʤ���
	 */
	public ExGOD(OzProxy proxy)
	throws ExCellIllegalOzHomeException
	{
		this(proxy.getGOL());
	}

	/**
	 * ����ʥ���åɥ��롼�סˤ���ꤷ��GOD���֥������Ȥ�������롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ����ʥ���åɥ��롼�סˤϾ�˷����Ȥ���������GOD̾��
	 * ���äƤ���Τǡ������ǤϺ��٥����å��Ϥ��ʤ���
	 * </DL>
	 *
	 * @param	cell	����ʥ���åɥ��롼�ס�
	 */
	public ExGOD(ExCell cell)
	{
		super(objectsPath+cell.getName().replace(godSeparatorChar,separatorChar));
		init0(cell.getName());
	}

	/**
	 * GOD���֥������Ȥ�GOD̾���֤���
	 *
	 * @return	GOD̾
	 */
	public
	String getName()
	{
		return god;
	}

	/**
	 * ���Υ��֥������Ȥ�ɽ�����뤿���ʸ������֤���
	 * ɸ������Ƥ�GOD̾���ղä��롣
	 *
	 * return		���Υ��֥������Ȥ�ɽ���Τ����ʸ����
	 */
	public
	String toString()
	{
		String cn = getClass().getName();
		if (cn.startsWith(Executor.IPAoz)) {
			cn = cn.substring(Executor.IPAoz.length(),cn.length());
		}
		return cn+"@"+Integer.toHexString(hashCode())
				+"[god="+god+","+(lock==null?"unlock":"locked")+"]";
	}

	/**
	 * GOD���å����֤ˤ��롣
	 *
	 * @exception	ExGODInvalidPathException
	 *					GOD����ʤ������뤤�ϡ�����Ʊ��̾���Υե����뤬
	 *					¸�ߤ��롣
	 * @exception	ExGODInvalidStateException
	 *					����GOD�ϥ�å����֤Ǥ��롢���뤤�ϡ����ꤷ�����֤ǤϤʤ���
	 *					��̤Ȥ��ơ�����GOD���֥������Ȥϥ�å�������Ǥ��Ƥ��ʤ���
	 * @exception	ExException
	 *					�̾�ϵ���ʤ��㳰��ȯ������GOD�ξ��֤�����Ǥ��롣
	 */
	synchronized
	void acquire()
	throws ExException, ExGODInvalidPathException, ExGODInvalidStateException
	{
		if (lock != null) {
			throw new ExGODInvalidStateException("Already acquired with "+this);
		}
		if (exists()) {
			if (isDirectory()) {
				if (unlock.exists()) {
					if (unlock.renameTo(locked)) {
						Executor.debug(CN,"acquire",getPath()+" is reused for "+this);
					} else {
						String message = "Not renamed unlock("+unlock+") to locked("+locked+")";
						throw new ExGODInvalidStateException(message);
					}
				} else {
					throw new ExGODInvalidStateException("Not found unlock("+unlock+")");
				}
			} else {
				throw new ExGODInvalidPathException("Already same name file("+getPath()+") exists");
			}
		} else {
			if (mkdirs()) {
				Executor.debug(CN,"acquire",getPath()+" is made for "+this);
			} else {
				if (exists()) {
					throw new ExGODInvalidStateException("Already directory("+getPath()+") exists");
				} else {
					throw new ExGODInvalidPathException("Not made direcotry("+getPath()+")");
				}
			}
		}
		try {
			lock = new FileOutputStream(locked);
		} catch (Exception e) {
			lock = null;
			Executor.error(CN,"acquire","Can't open FileOutputStream("+locked+")",e);
			Executor.error(CN,"acquire","Try to rename locked("+locked+") to unlock("+unlock+")");
			if (locked.renameTo(unlock)) {
				Executor.error(CN,"acquire",getPath()+"is released");
			} else {
				Executor.error(CN,"acquire",getPath()+"isn't released");
			}
			throw new ExException(e.getMessage());
		}
	}

	/**
	 * GOD�����å����֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * Windows NT �ǤǤϥ����ץ���Υե������̾����
	 * �᥽�å� renameTo ��Ȥä��ѹ����뤳�ȤϤǤ��ʤ���
	 * </DL>
	 *
	 * @exception	ExGODInvalidStateException
	 *					̤��GOD�Υ�å���������Ƥ��ʤ������뤤�ϡ����ꤷ�����֤ǤϤʤ���
	 *					��̤Ȥ��ơ�����GOD���֥������Ȥϥ�å��γ���������λ���Ƥ��ʤ���
	 * @exception	ExException
	 *					�̾�ϵ���ʤ��㳰��ȯ������GOD�ξ��֤�����Ǥ��롣
	 */
	synchronized
	void release()
	throws ExException, ExGODInvalidStateException
	{
		if (lock == null) {
			throw new ExGODInvalidStateException("Not yet acquired with "+this);
		}
		try {
			lock.close();
		} catch (Exception e) {
			Executor.error(CN,"release","Can't close lock("+lock+")",e);
		}
		lock = null;
		if (locked.exists()) {
			if (locked.renameTo(unlock)) {
				Executor.debug(CN,"release",getPath()+" is released");
			} else {
				Executor.error(CN,"release","Not renamed locked("+locked+") to unlock("+unlock+")");
				Executor.error(CN,"release",getPath()+" isn't released");
				throw new ExGODInvalidStateException("Maybe locked("+locked+") is referred by other");
			}
		} else {
			throw new ExGODInvalidStateException("Not found locked("+locked+")");
		}
	}

	/**
	 * GOD����Ū�����å����֤ˤ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * Windows NT �ǤǤϥ����ץ���Υե���������Ǥ��ʤ���
	 * </DL>
	 *
	 * @exception	ExGODInvalidPathException
	 *					GOD��¸�ߤ��ʤ������뤤�ϡ�����Ʊ��̾���Υե����뤬¸�ߤ��롣
	 * @exception	ExGODInvalidStateException
	 *					GOD�򻲾���Υ��������塼��������Ȼפ���(Windows NT��)��
	 * @exception	ExException
	 *					�̾�ϵ���ʤ��㳰��ȯ������GOD�ξ��֤�����Ǥ��롣
	 */
	synchronized
	void recover()
	throws ExException, ExGODInvalidPathException, ExGODInvalidStateException
	{
		// ��å����֤򼨤��ե�������Ĥ��롣
		if (lock != null) {
			try {
				lock.close();
			} catch (Exception e) {
				Executor.error(CN,"recover","Can't close "+lock+", but continue",e);
			}
			lock = null;
		}

		// GOD�ؤΥѥ�������������Τ���롣
		if (exists()) {
			if (!isDirectory()) {
				throw new ExGODInvalidPathException("Not directory path("+getPath()+")");
			}
		} else {
			throw new ExGODInvalidPathException("Not found directory("+getPath()+")");
		}

		// ���å����֤򼨤��ե����뤬¸�ߤ���ʤ�С���å����֤ˤ��뤳�Ȥ��ߤ롣
		if (unlock.exists()) {
			Executor.error(CN,"recover","Try to renamed unlock("+unlock+") to locked("+locked+")");
			if (unlock.renameTo(locked)) {
				Executor.error(CN,"recover","Renamed unlock("+unlock+") to locked("+locked+")");
			} else {
				Executor.error(CN,"recover","Try to delete unlock("+unlock+")");
				if (unlock.delete()) {
					Executor.error(CN,"recover","Deleted unlock("+unlock+")");
				} else {
					Executor.error(CN,"recover","GIVE UP RECOVERY OF DIRECTORY("+getPath()+")");
					throw new ExGODInvalidStateException("Maybe unlock("+unlock+") is referred by other");
				}
			}
		}

		/**
		 * GOD�Υ�å����֤򼨤��ե�����Υꥹ�Ȥ����뤿��Υե��륿��
		 */
		class PrefixFilenameFilter
		implements FilenameFilter
		{
			String prefix;

			PrefixFilenameFilter(String prefix)
			{
				this.prefix = prefix;
			}

			public
			boolean accept(File dir, String name)
			{
				return name.startsWith(prefix);
			}
		}

		// ��å����֤򼨤��ե�����λĳ��������롣
		String[] list = list(new PrefixFilenameFilter(lockedBaseFilename));
		for (int i = 0; i < list.length; i ++) {
			File file = new File(this,list[i]);
			if (!file.delete()) {
				Executor.error(CN,"recover","ABORTED RECOVERY OF DIRECTORY("+getPath()+")");
				throw new ExGODInvalidStateException("Maybe locked("+locked+") is referred by other");
			}
		}

		// ��å����֤򼨤��ե������������롣
		FileOutputStream file = null;
		try {
			file = new FileOutputStream(locked);
			file.close();
		} catch (Exception e) {
			Executor.error(CN,"recover","Can't open FileOutputStream("+locked+")",e);
			throw new ExException(e.getMessage());
		}

		// ���Υե���������å����֤򼨤��ե�����̾���Ѥ��롣
		if (locked.renameTo(unlock)) {
			Executor.error(CN,"recover",getPath()+" is recovered");
		} else {
			Executor.error(CN,"recover","Not renamed locked("+locked+") to unlock("+unlock+")");
			Executor.error(CN,"recover","ABORTED RECOVERY OF DIRECTORY("+getPath()+")");
			throw new ExGODInvalidStateException("Maybe unlcok("+unlock+") exists");
		}
	}

	/**
	 * GOD ����å����֤Ǥ��뤫��Ĵ�٤롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * OS�ˤ�äƤϡ��ե�����Υѥ�̾���¸�ߤ��ʤ�����
	 * ���Ρʥ����ץ󤷤Ƥ���ˤ�¸�ߤ����礬�ͤ����롣
	 * ���ξ�硢��������ϡָ����ʤ��פΤ� false ���֤���
	 * ���äơ�lock �� null ���ɤ�����Ĵ�٤ʤ���
	 * </DL>
	 *
	 * @return	GOD����å����֤ʤ�С�true ���֤���GOD����Ŭ�ڤʾ���ޤ�ơ�
	 *			GOD����å����֤Ǥ��뤳�Ȥ��ǧ�Ǥ��ʤ���� false ���֤���
	 *
	 */
	synchronized
	boolean knock()
	{
		if (exists()) {
			if (isDirectory()) {
				if (! unlock.exists()) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * ����ʹߤϥǥХå��ȥ�����Τ���Υץ����Ǥ��롣
	 * �ʾܺ٤Ͼ�ά��
	 */
	private static final java.util.Dictionary gods = new java.util.Hashtable();
	static {

		/*
		 * GOD�γ������ޥ��
		 */
		class Acquire
		extends ExShellCommand
		{
			Acquire()
			{
				usage = " <god>";
				comment = "acquire GOD";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExGOD god = new ExGOD(args[1]);
				god.acquire();
				gods.put(args[1],god);
				return null;
			}
		}

		/*
		 * GOD�γ������ޥ��
		 */
		class Release
		extends ExShellCommand
		{
			Release()
			{
				usage = " [<god>]";
				comment = "release GOD or, list acquired gods";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (2 < args.length) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				if (args.length == 2) {
					ExGOD god = (ExGOD)gods.get(args[1]);
					if (god == null) {
						throw new IllegalArgumentException("Not found "+args[1]);
					}
					god.release();
					gods.remove(args[1]);
				} else {
					shell.stdout.println("-- Acquired god list --");
					Enumeration keys = gods.keys();
					while (keys.hasMoreElements()) {
						String key = (String)keys.nextElement();
						ExGOD god = (ExGOD)gods.get(key);
						if (god != null) shell.stdout.println(god.toString());
					}
				}

				return null;
			}
		}

		/*
		 * GOD�ν������ޥ��
		 */
		class Recover
		extends ExShellCommand
		{
			Recover()
			{
				usage = " <god>";
				comment = "recover GOD";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				ExGOD god = new ExGOD(args[1]);
				if (god == null) {
					throw new IllegalArgumentException("Not found "+args[1]);
				}
				god.recover();
				return null;
			}
		}

		ExShell.append("acquire",new Acquire());
		ExShell.append("release",new Release());
		ExShell.append("recover",new Recover());
	}
}
