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
 * $Id: OzLocalRepositoryManager.java,v 1.2 1997/11/20 05:22:28 yoshi Exp $
 */

package	JP.go.ipa.oz.system;

import	java.io.File;
import	java.io.FileInputStream;
import	java.io.FileNotFoundException;
import	java.io.FileOutputStream;
import	java.io.FilenameFilter;
import	java.io.IOException;
import	java.io.InputStream;
import	java.io.OutputStream;
import	java.util.Dictionary;
import	java.util.Enumeration ;
import	java.util.Hashtable;
import	java.util.zip.ZipEntry;
import	java.util.zip.ZipException;
import	java.util.zip.ZipFile;

/**
 * ���饹 OzLocalRepositoryManager �ϡ��������ݥ��ȥ����ǽ��
 * �󶡤��� Java API �Ǥ��롣���Υ��饹�ϡ����������塼����ư�������Ȥ��ʤ���
 * ���Υ��饹�ˤϡ�static �᥽�åɤΤߤ��������롣
 * ���Υ��饹�ϥ��������塼�����ظ��������Τǡ�
 * �������ƥ��˽�ʬ��դ��Ƽ�����Ԥ�ɬ�פ����롣
 *
 * <DL><DT>
 * ����ա�<DD>
 * ���Υ��饹�μ����ǻ��Ѥ��륯�饹���ޤ��ϡ� �᥽�å����ϥ��������塼����
 * ư�������Ȥ����ˡ�ñ�Ȥ�ư����ΤǤʤ���Фʤ�ʤ���
 * ������������Υץ�ѥƥ�����Ŭ�ڤ����ꤵ��Ƥ��뤳�Ȥ�����Ȥ��롣
 * </DL>
 *
 * @see OzClassFile
 *
 * @version		$Revision: 1.2 $, $Date: 1997/11/20 05:22:28 $
 * @author		Yasumitsu Yoshida
 */
public final
class OzLocalRepositoryManager
{

    /**
     * ���������塼�������ΥǥХå���
     */
    static final String CN = "OzLocalRepositoryManager";

    /**
     * ����Ͽ��򼨤��ե�����̾�Υ١���̾
     *
     * <DL><DT>
     * ����ա�<DD>
     * �����ʥ��饹���������֥ե����뤬¸�ߤ�����ϡ�
     * ����Ͽ��򼨤��ե������̵�뤵��롣
     * </DL>
     */
    private static final String triedFilenameKeyword = ".trial";

    /**
     * �ǥХå��ѥե饰
     */
    private static boolean debug
	= (System.getProperty(OzLocalRepositoryManager.class.getName()+".debug") != null) ? true : false;

    /**
     * �������ݥ��ȥ�Υ롼�ȤΥѥå�����̾
     */
    static final String repositoryPackageName = ExCodePath.ReleasedUserClassPackage;

    /**
     * �������ݥ��ȥ�Υ롼�ȤΥѥå�����̾���б�����ѥ�̾
     */
    static final String repositoryPackagePath
	= repositoryPackageName.replace('.', File.separatorChar);

    /**
     * �������ݥ��ȥ�Υ롼�ȤΥե�ѥ�̾
     */
    static final String repositoryPath
	= OzClassFile.ozHomeClassStoragePath+File.separator+repositoryPackagePath;

    /**
     * ���饹���������֥ե�����ȥȥåץѥå�����̾�Υơ��֥�
     */
    static private final Dictionary zipFiles = new Hashtable();

    /**
     * ����Ͽ�椫��Ĵ�٤뤿��Υե��륿��
     */
    static
    class TriedFilenameFilter
    implements FilenameFilter
    {
    	String key;

	TriedFilenameFilter(String key)
	{
	    this.key = key;
	}

	public
	boolean accept(File dir, String name)
	{
	    return name.startsWith(key);
	}
    }

    /**
     * ����Ͽ�Τ���Υ�å���������Ϥ��롣
     * â�������������塼����ư�������ˤǤ��ʤ��Τǡ�
     * ��å�������ɸ�२�顼���Ϥ˽��Ϥ��롣
     *
     * @param	methodName	��å��������ղä����᥽�å�̾
     * @param	message		���Ϥ����å�����
     */
    private static
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
    private static
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
     * ���ꤵ�줿�ѥå�������ޤ९�饹���������֥ե�����򸡺�����
     * ���Υ��饹���������֥ե�����̾���֤���
     *
     * @param	packagePath
     *		��������ѥå�����̾���б��������Хѥ�̾
     * @param	trial
     *		true �λ������������ǲ���Ͽ���θ���롣
     * @return	���ꤵ�줿�ѥå�������ޤ९�饹���������֥ե�����Υե�����̾���֤���
     *		���Ĥ���ʤ����ϡ�null ���֤�������Ͽ��Τ�Τ������������ϡ�
     *		���Υե�����Υ١���̾���֤���
     *
     */
    private static
    File findPackage(String packagePath, boolean trial)
    throws IOException
    {
	debug("findPackage", "("+packagePath+","+trial+")");
	File base = new File(OzClassFile.ozHomeClassStoragePath, packagePath);
	String parent = base.getParent();
	String packageEntryName = packagePath.replace(File.separatorChar, '/')+"/";
	boolean first = true;
	for (;;) {
	    File directory = new File(parent);
	    File file = new File(directory, base.getName()+".zip");
	    if (!file.getPath().startsWith(repositoryPath)) break;
	    debug("findPackage", "Test "+file.getPath());
	    if (file.exists()) {
		ZipFile zipFile = null;
		try {
		    zipFile = new ZipFile(file);
		    if (zipFile.getEntry(packageEntryName) != null) {
			debug("findPackage", packagePath+" is found in "+file.getPath());
			return file;
		    }
		} catch (IOException e) {
		    e.printStackTrace(System.err);
		    throw e;
		} finally {
		    if (zipFile != null) zipFile.close();
		}
	    }
	    if (trial) {
		if (!first) {
		    String triedBaseFilename = base.getName()+triedFilenameKeyword;
		    FilenameFilter filter = new TriedFilenameFilter(triedBaseFilename);
		    String lists[] = directory.list(filter);
		    if (lists != null && lists.length != 0) {
			file = new File(directory, triedBaseFilename);
			debug("findPackage", packagePath+" is found in "+file.getPath());
			return file;
		    }
		} else {
		    first = false;
		}
	    }
	    base = directory;
	    parent = base.getParent();
	}
	debug("findPackage", packagePath+" is not found.");
	return null;
    }

    /**
     * ���� topPackageName �ǻ��ꤵ�줿�ȥåץѥå�������
     * ���饹���������֥ե����뤬�ޤߡ�
     * ���Υ��饹���������֥ե�����˴ޤޤ��ե������
     * �ѥ�̾�����ʤ��Ȥ�ȥåץѥå��������б�����ѥ���ޤߡ�
     * �ޤ������ꤵ�줿���饹���������֥ե�����˴ޤޤ��ѥå�������
     * ���˥ȥåץѥå������Ȥ�����Ͽ����Ƥ��ʤ����Ȥ�Ĵ�٤롣
     *
     * @param	topPackagePath	��Ͽ����ȥåץѥå�����̾���б��������Хѥ�̾
     * @param	trial	��Ͽ���륯�饹���������֥ե�����̾
     * @return	���饹���������֤����Ƥ�Ŭ�ڤǤ���� true ���֤���
     */
    private static
    boolean checkPackage(String topPackagePath, File trial)
    throws IOException
    {
	debug("checkPackage", "("+topPackagePath+","+trial.getPath()+")");
	boolean ok = false;
	String topPackageEntry = topPackagePath.replace(File.separatorChar, '/')+"/";
	int topPackageEntryLength = topPackageEntry.length();
	ZipFile zipFile = null;
	try {
	    zipFile = new ZipFile(trial);
	    Enumeration handle = zipFile.entries(); 
	    while (handle.hasMoreElements()) {
		ZipEntry entry = (ZipEntry)handle.nextElement();
		String path = entry.getName();
		if (path.startsWith(topPackageEntry)) {
		    if (entry.isDirectory()) {
			if (path.length() == topPackageEntryLength) {
			    debug("checkPackage", topPackagePath+" is found in "+zipFile.getName());
			    ok = true;
			}
			File child = new File(OzClassFile.ozHomeClassStoragePath, path);
			File target = new File(child.getParent());
			File directory = new File(target.getParent());
			File file = new File(directory, target.getName()+".zip");
			if (file.exists()) {
			    debug("checkPackage", topPackagePath+" is found in "+file.getPath());
			    return false;
			}
			FilenameFilter filter = new TriedFilenameFilter(target.getName()+triedFilenameKeyword);
			String lists[] = directory.list(filter);
			if (lists != null && lists.length != 0) {
			    for (int i = 0; i < lists.length; i ++) {
				File a = new File(directory, lists[i]);
				if (!trial.equals(a)) {
				    debug("checkPackage", topPackagePath+" is found in "+a.getPath());
				    return false;
				}
			    }
			}
		    }
		} else {
		    debug("checkPackage", path+" is found in "+ zipFile.getName());
		    return false;
		}
	    }
	} catch (IOException e) {
	    e.printStackTrace(System.err);
	    throw e;
	} finally {
	    if (zipFile != null) zipFile.close();
	}
	debug("checkPackage", trial.getPath()+" is "+(ok?"OK":"NG")+".");
	return ok;
    }

    /**
     * ���˥������ݥ��ȥ�˥��饹���������֥ե������������롣
     *
     * @param	topPackagePath	��Ͽ���륯�饹���������֥ե�����Υȥåץѥå�����̾
     * @param	delivery	���饹���������֥ե�������������ݤ��ɤ߹����������
     * @return	�����˥��饹���������֥ե����������������ϡ�true ���֤���
     */
    private static
    boolean download(String topPackagePath, ExClassDelivery delivery)
    throws IOException
    {
	File base = new File(OzClassFile.ozHomeClassStoragePath, topPackagePath);
	File directory = new File(base.getParent());
	File file = new File(directory, base.getName()+".zip");
	File trial = new File(directory, base.getName()+triedFilenameKeyword+"."+Executor.getID());
	try {
	    // ����Ͽ�ˤƥե��������������
	    if (directory.exists()) {
		if (directory.isDirectory()) {
		    if (file.exists()) {
			if (file.isFile()) {
			    if (file.length() == delivery.length()) {
				debug("download", "Already downloaded: "+file.getPath());
				return false;
			    } else {
				syslog("download", "Incorrect length of downloaded file: "+file.getPath());
			    }
			} else {
			    String message = "Already none file exists: "+file.getPath();
			    syslog("download", message);
			    throw new IOException(message);
			}
		    }
		} else {
		    String message = "Already file exists: "+directory.getPath();
		    syslog("download", message);
		    throw new IOException(message);
		}
	    } else {
		debug("download", "mkdirs "+directory.getPath());
		directory.mkdirs();
	    }
	    delivery.download(trial);
	    if (file.exists()) {
	    	if (file.isFile()) {
		    debug("download", "Already downloaded by other executor: "+file.getPath());
		    return false;
		} else {
		    String message = "Already none file exists: "+file.getPath();
		    syslog("download", message);
		    throw new IOException(message);
		}
	    } else {
		// ���� topPackagePath �ǻ��ꤵ�줿�ȥåץѥå�������������Ͽ����Ƥ��뤫��
		File zipFile = findPackage(topPackagePath, true);
		if (zipFile != null) {
		    trial.delete();
		    String message = topPackagePath+" is found in "+zipFile.getPath();
		    syslog("download", message);
		    throw new SecurityException(message);
		}
		// ���饹���������֥ե���������Ƥ�Ŭ�ڤ���
		if (!checkPackage(topPackagePath, trial)) {
		    trial.delete();
		    String message = "Illegal entry is found by "+topPackagePath;
		    syslog("download", message);
		    throw new SecurityException(message);
		}
		// ������Ͽ
		if (! trial.renameTo(file)) {
		    /* Never fail to rename if the file exists. */
		    String message = "Can't rename "+trial.getPath()+" to "+file.getPath();
		    syslog("download", message);
		    throw new IOException(message);
		}
		debug("download", "complete "+topPackagePath+" with "+file.getPath());
		return true;
	    }
	} finally {
	    if (trial.exists() && ! trial.delete()) {
		syslog("download", "Can't delete "+trial.getPath());
	    }
	}
    }

    /**
     * �ȥåץѥå�����̾���б����륯�饹���������֥ե���������뤿���
     * ���֥������Ȥ��֤����б�����ե����뤬̵����硢���� in ����ǡ�����
     * �ɤߤ����ơ����饹���������֥ե�����κ������ߤ롣
     *
     * @param	topPackageName	�ȥåץѥå�����̾
     * @param	delivery	���饹���������֥ե�������������ݤ��ɤ߹����������
     * @param	onlyNew	true �λ������������������Τߥ��֥������Ȥ��֤���
     * @return	���ɤ������饹���������֥ե���������뤿��Υ��֥������Ȥ��֤���
     */
    private static
    ExZipFile load(String topPackageName, ExClassDelivery delivery, boolean onlyNew)
    throws IOException
    {
	debug("load", "("+topPackageName+",,"+onlyNew+")");
	ExZipFile zipFile = null;
	boolean transfered = false;
	for (;;) {
	    Object o = zipFiles.get(topPackageName);
	    if (o == null) {
		ExFakeObject current = new ExFakeObject();
		o = zipFiles.put(topPackageName, current);
		if (o == null) {
		    try {
			String topPackagePath = topPackageName.replace('.', File.separatorChar);
			File file = new File(OzClassFile.ozHomeClassStoragePath, topPackagePath+".zip");
			if (! file.exists() && delivery != null) {
			    debug("load", "***** READING "+topPackageName);
			    transfered = download(topPackagePath, delivery);
			}
			zipFile = new ExZipFile(file);
		    } catch (SecurityException e) {
			zipFiles.remove(topPackageName);
			current.abort();
			throw e;
		    } catch (IOException e) {
			zipFiles.remove(topPackageName);
			current.abort();
			throw e;
		    }
		    zipFiles.put(topPackageName, zipFile);
		    current.ready();
		    debug("load", "***** LOADED "+topPackageName+" from "+zipFile.getName());
		    break;
		} else {
		    if (o instanceof ExFakeObject) {
			debug("load","***** wait "+topPackageName);
			ExFakeObject fake = (ExFakeObject)o;
			if (fake.await()) {
			    current.ready();
			} else {
			    current.abort();
			    throw new IOException(topPackageName);
			}
		    } else {
			debug("load","***** reset "+topPackageName);
			zipFiles.put(topPackageName, o);
			current.ready();
			zipFile = (ExZipFile)o;
			break;
		    }
		}
	    } else {
		if (o instanceof ExFakeObject) {
		    debug("load","***** WAIT "+topPackageName);
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			throw new IOException(topPackageName);
		    }
		} else {
		    zipFile = (ExZipFile)o;
		    break;
		}
	    }
	    debug("load","***** RETRY "+topPackageName);
	}
	return onlyNew ? (transfered ? zipFile : null) : zipFile;
    }

    /**
     * @see	load(java.lang.String,java.io.InputStream,boolean)
     */
    static
    ExZipFile load(ExClassDelivery delivery)
    throws IOException
    {
	return load(delivery.getName(), delivery, false);
    }

    /**
     * @see	load(java.lang.String,java.io.InputStream,boolean)
     */
    static
    ExZipFile load(ExClassDelivery delivery, boolean onlyNew)
    throws IOException
    {
	return load(delivery.getName(), delivery, onlyNew);
    }

    /**
     * @see	load(java.lang.String,java.io.InputStream,boolean)
     */
    static
    ExZipFile load(String topPackageName)
    throws IOException
    {
	return load(topPackageName, null, false);
    }

    /**
     * ������ޥ�������¸�ߤ��륯�饹���������֥ե������
     * �������ݥ��ȥ����Ͽ�������ԡ����롣������Ͽ����Ƥ���
     * ���饹���������֥ե������Ʊ���ȥåץѥå�������
     * ���饹���������֥ե��������Ͽ���뤳�ȤϤǤ��ʤ���
     * �ޤ���������Ͽ����Ƥ��륯�饹���������֥ե������
     * �ޤޤ�Ƥ���ѥå�������ȥåץѥå������Ȥ���
     * ���饹���������֥ե��������Ͽ���뤳�Ȥ�Ǥ��ʤ���
     * ��Ͽ���ߤ���硢�ѥå�����̾����˵�Ͽ���롣
     * �ޤ�����Ͽ�����������Ԥ���˵�Ͽ���롣
     *
     * @param	file		��Ͽ����zip�ե����롣
     * @param	topPackageName	�ȥåץѥå�����̾��
     * @exception	IOException
     *			�ե������������㳰��ȯ��������
     * @exception	SecurityException
     *			������Ͽ����Ƥ��륯�饹���������֥ե������Ʊ��
     *			�ȥåץѥå������Υ��饹���������֥ե��������Ͽ
     *			���褦�Ȥ��������ޤ��ϡ�¾�Υ��饹���������֥ե������
     *			�ޤޤ�Ƥ���ѥå�������ȥåץѥå������Ȥ���褦��
     *			���饹���������֥ե��������Ͽ���褦�Ȥ�����
     *			���뤤�ϡ�OZ �Υ������ƥ��ޥ͡����㤬¸�ߤ���Ȥ���
     *			�֥���åɤˤ�äƵ�ư���줿��
     */
    public static
    void add(File file, String topPackageName)
    throws IOException
    {
	syslog("add", file.getPath()+"("+topPackageName+")");

	SecurityManager sm = System.getSecurityManager();
	if (sm instanceof ExSecurityManager) {
	    ((ExSecurityManager)sm).tryLocalRepositoryAdd(topPackageName);
	}
	// ��Ͽ���θ����ϥ������ƥ��ޥ͡������¸�ߤ˴ط��ʤ���˹Ԥ���

	// ���� topPackageName �� JP.go.ipa.oz.user.released �ǻϤޤäƤ��뤫��
	if (!topPackageName.startsWith(repositoryPackageName)) {
	    String message = topPackageName+" start without "+repositoryPackageName;
	    syslog("add", message);
	    throw new SecurityException(message);
	}

	try {
	    ExClassDelivery delivery =new ExClassDelivery(topPackageName, file);
	    try {
		ExZipFile zipFile = load(delivery, true); // Don't close zipFile
		if (zipFile == null) {
		    String message = topPackageName+" already exists.";
		    syslog("add", message);
		    throw new SecurityException(message);
		}
		syslog("add", file.getPath()+"("+topPackageName+") is stored as "+zipFile.getName());
	    } finally {
		delivery.close();
	    }
	} catch (IOException e) {
	    syslog("add", file.getPath()+"("+topPackageName+") is not stored.");
	    throw e;
	}
    }

    /**
     * �������ݥ��ȥ꤫�顢���ꤵ�줿�ѥå�������ޤ�
     * ZIP���֥������ȡʥ��饹���������֥ե�����ˤ򸡺����롣
     *
     * @param	packageName	�����оݤΥѥå�����̾��
     * @return	���ꤵ�줿�ѥå�������ޤ�ZIP���֥�������
     * @exception	IOException
     *			�ե������������㳰��ȯ��������
     */
    static
    ExZipFile find(String packageName)
    {
	ExZipFile zipFile = null;
	String packageEntryName = packageName.replace('.', '/')+"/";
	while (packageName.startsWith(repositoryPackageName)) {
	    try {
		zipFile = load(packageName);
	    } catch (IOException e) {
		zipFile = null;
	    }
	    if (zipFile != null) {
		if (zipFile.getEntry(packageEntryName) != null) {
		    return zipFile;
		}
	    }
	    packageName = packageName.substring(0, packageName.lastIndexOf((int)'.'));
	}
	return null;
    }

    /**
     * �������ݥ��ȥ꤫�顢���ꤵ�줿�ѥå�������ޤ�
     * ���饹���������֥ե�����򸡺����롣
     *
     * @param	packageName	�����оݤΥѥå�����̾��
     * @return	���ꤵ�줿�ѥå�������ޤ९�饹���������֥ե����롣
     * @exception	IOException
     *			�ե������������㳰��ȯ��������
     *
     * @see	find(String)
     */
    public static
    File get(String packageName)
    throws IOException
    {
	ZipFile zipFile = find(packageName);
	return (zipFile != null) ? new File(zipFile.getName()) : null;
    }

    /**
     * �ѥå�����̾�ν������ꤷ�ơ������Υѥå��������ޤޤ��
     * ���饹���������֥ե�����򸡺���������ѥ������ɬ�פ�
     * CLASSPATH ��׻����롣���� CLASSPATH �ˤϼ��Τ�Τ���˴ޤޤ�롣
     * <UL>
     * <LI>�����ƥ�ץ�ѥƥ� java.class.path ������
     * <LI>���ꤵ�줿�ѥå�������ޤ९�饹���������֥ե�����Υѥ�̾���¤�
     * </UL>
     * �ѥå������θ����ϡ������른�ݥ��ȥ�Τߤ��оݤ���
     * ���Υ᥽�åɤθƤӽФ��ˤ�äƥ��饹���������֥ե���������
     * ���饹�����ϹԤ��ʤ���
     *
     * @param	packageNames	 �����оݤΥѥå�����̾�ν��硣
     * @return	�ץ�åȥե�����˰�¸���� CLASSPATH ��ʸ����
     * @exception	ClassNotFoundException
     *			�������ݥ��ȥ��Ŭ�ڤʥ��饹���������֥ե����뤬
     *			���Ĥ���ʤ������Ĥ���ʤ��ѥå����������ĤǤ⤢��С�
     *			�����㳰��ȯ�����롣
     * @exception	IOException
     *			�ե������������㳰��ȯ��������
     */
    public static
    String classPath(String[] packageNames)
    throws ClassNotFoundException, IOException
    {
	String classPath = System.getProperty("java.class.path");
	Dictionary works = new Hashtable();
	for (int i = 0; i < packageNames.length ; i ++) {
	    String packagePath = packageNames[i].replace('.', File.separatorChar);
	    File file = findPackage(packagePath, false);
	    if (file == null) {
		throw new ClassNotFoundException(packageNames[i]);
	    }
	    if (works.get(file.getPath()) == null) {
		classPath = classPath + File.pathSeparator + file.getPath();
		works.put(file.getPath(), file);
	    }
	}
	return classPath;
    }

    /**
     * ���ꤵ�줿�ѥå�������ȥåץѥå������Ȥ��륯�饹���������֥ե������
     * �������ݥ��ȥ꤫�������롣
     * <DL><DT>
     * ����ա�<DD>
     * �������ݥ��ȥ���Υե������ʪ��Ū�˺�����롣
     * �������ˤ�ꡢ���ˤ��Υ��饹���������֥ե������
     * ���Ȥ��Ƥ����������������塼����ޤ᤿���������塼���ؤ�
     * ��θ�������ʤ����ޤ��������ƥ�������塢���Υ᥽�åɤ�
     * �㳰�ʤ��˽�λ�������Ǥ��äƤ⡢���饹���������֥ե����뤬
     * �������Ƥ���Ȥϸ¤�ʤ���¾�Υ��������塼���ˤ�ꡢ
     * ���Υ��饹���������֥ե����뤬�����������뤫��Ǥ��롣
     * </DL>
     *
     * @param	topPackageName	������륯�饹���������֥ե������
     *				�ȥåץѥå�����̾��
     * @exception	ClassNotFoundException
     *			���ꤵ�줿�ѥå�������ȥåץѥå������Ȥ���
     *			���饹���������֥ե����뤬�������ݥ��ȥ��
     *			���Ĥ���ʤ���
     * @exception	IOException
     *			�ե������������㳰��ȯ��������
     * @exception	SecurityException
     *			OZ �Υ������ƥ��ޥ͡����㤬¸�ߤ���Ȥ���
     *			�֥���åɤˤ�äƵ�ư���줿��
     */
    public static
    void remove(String topPackageName)
    throws ClassNotFoundException, IOException
    {
	SecurityManager sm = System.getSecurityManager();
	if (sm instanceof ExSecurityManager) {
	    ((ExSecurityManager)sm).tryLocalRepositoryRemove(topPackageName);
	}

	String path = topPackageName.replace('.', File.separatorChar);
	File target = new File(OzClassFile.ozHomeClassStoragePath,path+".zip");
	if (!target.exists()) {
	    throw new ClassNotFoundException("top package: "+topPackageName);
	}
	for (;;) {
	    Object o = zipFiles.remove(topPackageName);
	    if (o != null) {
		if (o instanceof ExFakeObject) {
		    // ��Ͽ������ʤΤǽ����ν�λ���Ԥäơ����٤��ľ����
		    ExFakeObject fake = (ExFakeObject)o;
		    if (! fake.await()) {
			break;
		    }
		} else {
		    ZipFile zipFile = (ZipFile)o;
		    zipFile.close();
		}
	    } else {
		break;
	    }
	}
	target.delete();
    }

    /**
     * ���Υ��饹�� static �᥽�åɡʥ��饹�᥽�åɡˤΤߤ���ġ�
     * �ޤ������Υ��饹�Υ��֥������Ȥ��������ƻ��Ѥ��ʤ���
     * ���Υ��饹�� public �Ǥ��ꡢ�ޤ������������塼���μ����˰�¸����
     * ��ʬ���ޤޤ��Τǡ����Υ��饹�Υ��֥������Ȥ������˻����Ф���
     * �ʤ��褦�ˤ���ɬ�פ����롣
     */
    private
    OzLocalRepositoryManager()
    {
	/* Nothing */
    }

}
