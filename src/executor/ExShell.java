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
 * $Id: ExShell.java,v 2.2 1997/12/04 04:55:20 yoshi Exp $
 *
 * ���: ���Υե������ vi �ǡ�hardtab=8, tabstop=4 �Ȥ����Խ�����Ƥ���
 */

package JP.go.ipa.oz.system;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

/**
 * ���ȥ꡼�फ�饳�ޥ�ɹԤ��ɤ߹���ǲ�ᤷ��
 * ���ޥ��̾���б����륳�ޥ�ɤ�¹Ԥ��롣
 *
 * ���ߡ����ʤ��Ȥ�Solaris(SPARC)�ǤǤ�ɸ�����Ϥ���������Ԥ��ˤʤ��
 * JavaVM �Υ������塼�餬��ߤ��롣���äơ�ɸ�����Ϥ���������Ԥ��ˤʤ�
 * ���֤Ǥϡ�¾�Υ���åɤϼ¹Ԥ���ʤ���
 *
 * @version		$Revision: 2.2 $, $Date: 1997/12/04 04:55:20 $
 * @author		Yasumitsu Yoshida
 */
class ExShell
extends OzSecure
implements Runnable
{
	/**
	 * ���������塼�������ΥǥХå���
	 */
	static final String CN = "ExShell";

	/**
	 * ���ޥ��̾�Ȥ�����б����������Ԥ����֥�������
	 * �ʥ��ޥ�ɡˤΥơ��֥�Ǥ��롣
	 */
	private static final Dictionary commands = new Hashtable();

	/**
	 * �ơ��֥�˻��ꤵ�줿���ޥ��̾�ǥ��ޥ�ɤ���Ͽ���롣
	 *
	 * @param	cmdName	���ޥ��̾
	 * @param	cmdObj	���ޥ��
	 * @return	������Ͽ����Ƥ��륳�ޥ�ɤ����ä����ϡ�
	 *			���Υ��ޥ�ɤ��֤�������ʳ��� null ���֤���
	 */
	static synchronized
	ExShellCommand append(String cmdName, ExShellCommand cmdObj)
	{
		ExShellCommand oldCmd;
		oldCmd = (ExShellCommand)commands.put(cmdName,cmdObj);
		if (oldCmd != null) {
			Executor.error(CN,"append","Replaced "+oldCmd+" with "+cmdObj+" for "+cmdName);
		}
		return oldCmd;
	}

	/**
	 * �ơ��֥����ꤵ�줿���ޥ��̾�Ǹ�������
	 * ���ޥ�ɤ���Ф���
	 *
	 * @param	cmdName	���ޥ��̾
	 * @return	���Ĥ��ä����ޥ�ɤ��֤�������ʳ��� null ���֤���
	 */
	static synchronized
	ExShellCommand search(String cmdName)
	{
		return (ExShellCommand)commands.get(cmdName);
	}

	/**
	 * �ơ��֥뤫�饳�ޥ��̾����Ͽ����Ƥ���
	 * ���ޥ�ɤ������롣
	 *
	 * @param	cmdName	���ޥ��̾
	 * @return	����������ޥ�ɤ��֤�������ʳ��� null ���֤���
	 */
	static synchronized
	ExShellCommand remove(String cmdName)
	{
		return (ExShellCommand)commands.remove(cmdName);
	}

	/**
	 * �Ǹ�˼¹Ԥ������ޥ�ɤ����ʸ������ݻ����롣
	 */
	String lastValue;

	/**
	 * ɸ������
	 */
	Reader stdin;

	/**
	 * ɸ�����
	 */
	PrintWriter stdout;

	/**
	 * ɸ�२�顼����
	 */
	PrintWriter stderr;

	/**
	 * ������Υ��ޥ�ɤȤ��ƥ����뤬
	 * ��ư���줿���Ȥ򼨤��ե饰
	 */
	boolean subShell = false;

	/**
	 * ���ޥ�ɥ롼�פ����Ǥ��롣
	 */
	boolean quit = false;

	/**
	 * ���ȥ꡼�फ�饳�ޥ�ɹԤ��ɤ߹���ǲ�ᤷ��
	 * ���ޥ��̾���б����륳�ޥ�ɤ�¹Ԥ���
	 * ���֥������Ȥ�������롣
	 *
	 * @param	stdin	ɸ������
	 * @param	stdout	ɸ�����
	 * @param	stderr	ɸ�२�顼����
	 */
	ExShell(Reader stdin, PrintWriter stdout, PrintWriter stderr)
	throws Exception
	{
		this.stdin = stdin;
		this.stdout = stdout;
		this.stderr = stderr;
		subShell = false;
	}

	/**
	 * ���ȥ꡼�फ�饳�ޥ�ɹԤ��ɤ߹���ǲ�ᤷ��
	 * ���ޥ��̾���б����륳�ޥ�ɤ�¹Ԥ���
	 * ���֥������Ȥ�������롣
	 * â����������Υ��ޥ�ɤȤ��ƥ����뤬
	 * ��ư���줿���Ȥ򼨤��ե饰��true�����ꤵ��롣
	 *
	 * @param	parent	��������Ԥä�������
	 * @param	stdin	ɸ������
	 */
	ExShell(ExShell parent, Reader stdin)
	throws Exception
	{
		this.stdin = stdin;
		this.stdout = parent.stdout;
		this.stderr = parent.stderr;
		subShell = true;
	}

	/**
	 * ���ȥ꡼�फ�饳�ޥ�ɹԤ��ɤ߹���ǲ�ᤷ��
	 * ���ޥ��̾���б����륳�ޥ�ɤ�¹Ԥ���
	 * �Ȥ���ư��򥹥ȥ꡼�ब��ü��ã����ޤǷ����֤���
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * Ʊ����ʣ������åɤǤ��Υ᥽�åɤ�¹Ԥ��ƤϤʤ�ʤ���
	 * </DL>
	 *
	 * @param	prompt		���ޥ�����Ϥ�¥���ץ��ץ�ʸ����
	 *						��null����ꤷ�Ƥ�褤��
	 * @param	parameters	���֥ѥ�᡼�������ꤵ�줿�����ִ�����
	 *						ʸ������������ġ�$0 ������κǽ�����Ǥ�
	 *						�б������̾�ϥ��������塼����ư���뤿���
	 *						������ץȤΥե�����̾�����롣
	 * @return	�Ǹ�˼¹Ԥ������ޥ�ɤ��֤���ʸ����
	 *
	 * @see	OzSystem#getArguments()
	 */
	synchronized
	String action(String prompt, String[] parameters)
	throws Exception
	{
		StreamTokenizer st = new StreamTokenizer(stdin);
		st.commentChar('#');
		st.ordinaryChar('$');
		st.ordinaryChar(';');
		st.ordinaryChar('&');
		st.quoteChar('"');
		st.ordinaryChar('-');
		st.wordChars('-','-');
		st.wordChars('_','_');
		st.wordChars(':',':');
		st.eolIsSignificant(true);
		st.slashSlashComments(false);
		st.slashStarComments(false);

		int status = st.TT_EOL;
		try {
			do {
				if (status == st.TT_EOL && prompt != null) {
					stdout.print(prompt);
				}
				if (stdout != null) {
					stdout.flush();
				}
				status = doLine(st,parameters);
			} while (! quit  && status != st.TT_EOF);
		} catch (Exception e) {
			Executor.error(CN,"action","(prompt="+prompt+",...)",e);
		}
		return lastValue;
	}

	synchronized
	String action(String[] args)
	throws Exception
	{
		return action(null,args);
	}

	/**
	 * ���ޥ�ɹԤ��ɤ߹���ǣ��ĤΥ��ޥ�ɤ�¹Ԥ��롣
	 *
	 * <DL><DT>
	 * ����ա�<DD>
	 * ���ޥ�ɹԤϡ����ޥ�ɶ��ڤ�ʸ�������뤤�ϡ�
	 * �Զ��ڤ�ʸ���ޤ�ʸ������̣���롣
	 * </DL>
	 *
	 * @param	st			���Υ��ȥ꡼�फ�饳�ޥ�ɹԤ��ɤ߹���
	 * @param	parameters	���֥ѥ�᡼����Ÿ���˻��Ѥ���ʸ���������
	 * @return	���ȥ꡼��ξ��֤��֤���
	 *
	 * @see	ExShell#action
	 */
	private int doLine(StreamTokenizer st, String[] parameters)
	throws Exception
	{
		int result = 0;
		int lineno = st.lineno();
		Stack stack = null;
		eol:
		for (stack = new Stack();;) {
			try {
				int ttype = st.nextToken();
				switch (ttype) {
				case st.TT_EOL:
					result = st.TT_EOL;
					break eol;
				case st.TT_EOF:
					result = st.TT_EOF;
					break eol;
				case st.TT_NUMBER:
					Integer inum = new Integer((int)st.nval);
					stack.push(inum.toString());
					break;
				case st.TT_WORD:
					stack.push(st.sval);
					break;
				case '$':
					switch (st.nextToken()) {
					case '?':
						stack.push(lastValue);
					case '*':
						for (int i = 1; i < parameters.length; ++ i) {
							stack.push(parameters[i]);
						}
						break;
					case st.TT_NUMBER:
						int position = (int)st.nval;
						stack.push(position < parameters.length ? parameters[position]: null);
						break;
					default:
						stderr.println(CN+": $ parameter error at "+lineno);
					}
					break;
				case ';':
					result = ';';
					break eol;
				case '"':
					stack.push(st.sval);
					break;
				case '\'':
					stack.push(st.sval);
					break;
				case '&':
					char c[] = new char[1];
					c[0] = '&';
					stack.push(new String(c));
					break;
				default: stderr.print(CN+": ? "+(char)st.ttype);
				}
			} catch (IOException e) {
				throw e;
			} catch (Exception e) {
				Executor.error(CN,"doline",e);
			}
		}
		if (!stack.empty()) {
			try {
				String s = (String)stack.peek();
				if (s.equals("&")) {
					stack.pop();
					String[] args;
					args = new String[stack.size()];
					for (int i = args.length-1; 0 <= i ; i --) {
						args[i] = (String)stack.pop();
					}
					new OzProcess(this, this, (Object[])args);
				} else {
					String[] args;
					args = new String[stack.size()];
					for (int i = args.length-1; 0 <= i ; i --) {
						args[i] = (String)stack.pop();
					}
					lastValue = call(args);
				}
			} catch (IllegalArgumentException e) {
				stderr.println(e.getMessage());
			} catch (ExCellHookException e) {
				stderr.println(e);
				e.getException().printStackTrace(stderr);
			} catch (Exception e) {
				// stderr.println(e);
				e.printStackTrace(stderr);
			}
		}
		return result;
	}

	/**
	 * ���ޥ��̾���б����륳�ޥ�ɤ򸡺������¹Ԥ��롣
	 *
	 * @param	args	���ޥ�ɹԤ˻��ꤵ�줿ʸ���������
	 * @return	���ޥ�ɤ�¹Ԥ�����̤Ȥ�������줿ʸ����
	 */
	private
	String call(String[] args)
	throws Exception
	{
		if (Executor.debug) {
			int n = args.length ;
			for (int i = 0; i < n; i ++) {
				Executor.debug(CN,"call","args["+i+"]="+args[i]);
			}
		}
		ExShellCommand cmd = search(args[0]);
		if (cmd == null) {
			throw new IllegalArgumentException("Unknown command: "+args[0]);
		}
		return cmd.action(this,args);
	}

	/**
	 * ����������åɤǥ��ޥ�ɤ�¹Ԥ��뤿��ˡ�
	 * ���Υ���åɤǺǽ�˼¹Ԥ���롣
	 */
	public final
	void run()
	{
		Object result;
		boolean status;

		try {
			ExThread t = (ExThread)Thread.currentThread();
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
	 * ����������åɤǥ��ޥ�ɤ�¹Ԥ��롣
	 *
	 * @param	object	���ޥ�ɸƽФ����о�
	 * @param	argv	���ޥ�ɸƽФ����ΰ���
	 */
	protected
	Object invoke(Object object, Object[] argv)
	throws Exception
	{
		ExShell shell = (ExShell)object;
		String[] args = (String[])argv;
		return shell.call(args);
	}

	/*
	 * ����ʹߤϥǥХå��ȥ�����Τ���Υץ����Ǥ��롣
	 * �ʾܺ٤Ͼ�ά��
	 */
	static {

		/**
		 * ���֥������¹Ԥ��롣
		 */
		class Shell
		extends ExShellCommand
		{
			Shell()
			{
				usage = " <file> [args...]";
				comment = "read command from file";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length < 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few arguments");
				}

				String fileSeparator = System.getProperty("file.separator");
				String ozHome = System.getProperty("oz.home");
				File file = new File(ozHome,args[1].replace('.',fileSeparator.charAt(0)));
				if (!file.exists()) {
					shell.stderr.println(args[0]+": "+file+" is not found.");
				} else if (!file.isDirectory()) {
					FileReader in = new FileReader(file);
					String[] newArgs;
					if (2 < args.length) {
						newArgs = new String[args.length-1];
						System.arraycopy(args, 1, newArgs, 0, args.length-1);
					} else {
						newArgs = new String[1];
						newArgs[0] = args[1];
					}
					new ExShell(shell,in).action(null,newArgs);
				} else {
					shell.stderr.println(args[0]+": "+file+" is not file.");
				}

				return null;
			}
		}

		/**
		 * ������������롣
		 */
		class Echo
		extends ExShellCommand
		{
			Echo()
			{
				usage = " [args...]";
				comment = "print arguments";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				int n = args.length;
				if (1 < n) {
					shell.stdout.print(args[1]);
					for (int i = 2; i < n; i ++) {
						shell.stdout.print(" "+args[i]);
					}
				}
				shell.stdout.println();
				return null;
			}
		}

		/**
		 * ������μ¹Ԥ�����ߤ��롣
		 */
		class Sleep
		extends ExShellCommand
		{
			Sleep()
			{
				usage = " <milli seconds>";
				comment = "shell to sleep";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too few or many arguments");
				}

				long millis = Long.parseLong(args[1]);
				Thread.sleep(millis);

				return null;
			}
		}

		/**
		 * �᥽�åɥȥ졼����on/off���롣
		 */
		class Trace
		extends ExShellCommand
		{
			Trace()
			{
				usage = " true|false";
				comment = "trace on/off";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length != 2) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				boolean flag;
				String arg = args[args.length-1].toLowerCase();
				if (arg.equals("true")||arg.equals("on")) flag = true;
				else if (arg.equals("false")||arg.equals("off")) flag = false;
				else throw new IllegalArgumentException("Invalid arguments");

				Runtime.getRuntime().traceMethodCalls(flag);

				return null;
			}
		}

		/**
		 * ���ޥ�ɰ�����������롣
		 */
		class Help
		extends ExShellCommand
		{
			Help()
			{
				usage = " ";
				comment = "print commands";
			}

			String action(ExShell shell, String[] args)
			throws Exception
			{
				if (args.length > 1) {
					shell.stderr.println("Usage: "+args[0]+usage);
					throw new IllegalArgumentException("Too many arguments");
				}

				Enumeration keys = commands.keys();
				while (keys.hasMoreElements()) {
					String key = (String)keys.nextElement();
					ExShellCommand cmd = (ExShellCommand)commands.get(key);
					if (cmd != null) {
						String str = key+cmd.usage;
						if (str.length()< 32) {
							StringBuffer buffer = new StringBuffer(str);
							for (int i = 32-buffer.length(); 0 < i; i --) buffer.append(' ');
							str = buffer.toString();
						}
						shell.stdout.println(str+";# "+cmd.comment);
					}
				}
				return null;
			}
		}

		ExShell.append("shell", new Shell());
		ExShell.append("echo", new Echo());
		ExShell.append("sleep", new Sleep());
		ExShell.append("trace", new Trace());
		ExShell.append("help", new Help());
	}
}
