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
 * $Id: OzSecure.java,v 2.4 1997/11/20 05:18:25 hamazaki Exp $
 */

package JP.go.ipa.oz.system;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;

/**
 * OzSecure �����ƤΣϣڤΥ��֥������Ȥˤ�äƷѾ�����륯�饹�Ǥ��롣
 * �ĤޤꡢOzSecure ��Ѿ����ʤ����饹�����������줿���֥������Ȥ�
 * �ϣڤΥ��֥������ȤȤϸƤФʤ���
 * �ޤ���OzSecure �ϣϣڤΥΥ�ꥨ��ȥ��Ȥʥ�˥���ǽ�����OzMonitor
 * ��Ѿ����Ƥ��롣
 * OzSecure �ϣϣڤΥ������ƥ���¸����뤿��ε�ǽ����äƤ���(̾����ͳ��)��
 * ¨�����ϣڤΥ��֥������Ȥ��ɤο����֡��СˤʤΤ���ɽ������
 * ���ο����ѹ����䤤��碌�˴ؤ��뵡ǽ���äƤ��롣
 *
 * @see	OzCondition
 * @see OzMonito
 * @see	ExThread
 * @see	ExCalleeChannel
 *
 * @version		$Revision: 2.4 $, $Date: 1997/11/20 05:18:25 $
 * @author		Yoichi Hamazaki (revised for OzObject by Yasumitsu Yoshida)
 * @author		Toshihiro Nishioka
 */
public
class OzSecure
extends OzMonitor
implements Serializable
{
  /**
   * ���������塼�������ΥǥХå���
   */
  static String CN = "OzSecure";

  /**
   * �ϣڤΥ��֥������Ȥο����п��Ǥ��뤳�Ȥ�ɽ����
   * �п��Σϣڥ��֥������Ȥϰ����ʥ��֥������ȤǤ���Ȥ���롣
   */
  public final static boolean GREEN = true;

  /**
   * �ϣڤΥ��֥������Ȥο����ֿ��Ǥ��뤳�Ȥ�ɽ����
   * �ֿ��Σϣڥ��֥������Ȥϴ��ʥ��֥������ȤǤ���Ȥ���롣
   */
  public final static boolean RED = false;

  /**
   * �ϣڤΥ��֥������Ȥ�ɬ�� OzSecure.GREEN �ޤ��ϡ�
   * OzSecure.RED �ο��Ǥ��롣���ο����ݻ����롣
   */
  boolean color;

  /**
   * �������ϣڤΥ��֥������Ȥ�������롣�ϣڤΥ��֥������Ȥ�
   * ɬ��������ĤΤǡ���������������ϣڤΥ��֥������Ȥο���
   * ���ꤹ�롣�ϣڤΥ��֥������Ȥ��������褦�Ȥ��Ƥ���
   * ����åɤ��ϣڤΥ���åɤλ��ϡ����ΣϣڤΥ���åɤο���
   * ��������������ϣڤΥ��֥������Ȥο���Ʊ���ˤʤ롣
   * �ϣڤΥ��֥������Ȥ��������褦�Ȥ��Ƥ��륹��åɤ�
   * �ϣڤΥ���åɤǤʤ����ϡ���������������ϣڤ�
   * ���֥������Ȥο����ֿ��ˤʤ롣
   *
   * @return	���������󥹥���
   */
  protected
    OzSecure()
      {
	Thread t = Thread.currentThread();
	if (t instanceof ExThread) {
	  color = ((ExThread)t).color;
	} else {
	  color = RED;
	}
      }

  /*
   * Cell related services
   */

      
  /** 
   * Save object image of the cell which the object belong to and
   * objects which belong to that cell to the object image file.<br>
   * The object image file is persistent image of the cell and
   * be used to load the image of cell into memory.<br>
   *
   * @exception ExException
   * @exception ExCellException 
   */
  protected final void flushCell() throws ExException,ExCellException
    {
      OzProcess p;
      Object[] args= new Object[2];

      args[0] = new Integer(Executor.FLUSH);
      args[1] = new ExProxy();

      p = Executor.syscall(args);

      try{
	p.join();
      } catch(ExProcessException pex){
	Exception ex=pex.getException();
	if(ex instanceof ExException)
	  {
	    throw (ExException)ex;
	  }
	else
	  {
	    Executor.syslog("OzSecure","flushCell","Exception raised",ex);
	    throw new ExException("OzSecure#flushCell raised Unexpected exception "+ex.getClass().getName());
	  }
      } catch(ExNoSuchProcessException nspex){
	Executor.syslog("OzSecure","flushCell","Exception raised",nspex);
	throw new ExException("OzSecure#flushCell raised ExNoSuchProcessException");
      }
    }

  /** 
   * !!! NOT IMPLEMENTED YET !!!<br>
   *
   * Save object image of the cell which the object belong to and
   * objects which belong to that cell to the temporaty object image file.<br>
   * The temporary object image file may become a real object image file
   * by commitFlushedImage method.<br>
   * flushCellTemporary and commitFlushedImage methods may be used to implement
   * two-phase commit transaction.
   *
   * @exception ExException
   * @exception ExCellException 
   *
   * @see commitFlushedImage
   */
  protected final 
    void flushCellTemporary() 
      throws ExException,ExCellException
	{
	  Executor.syslog(CN,"flushCellTemporary","Not implemented yet",null);
	  throw new ExException("flushCellTemporaty is not implemented yet");
	}

  /** 
   * !!! NOT IMPLEMENTED YET !!!<br>
   *
   * Make the The temporary object image file to the real object image file.<br>
   * flushCellTemporary and commitFlushedImage methods may be used to implement
   * two-phase commit transaction.
   *
   * @exception ExException
   * @exception ExCellException 
   *
   * @see flushCellTemporary
   */
  protected final 
    void commitFlushedImage() 
      throws ExException
	{
	  Executor.syslog(CN,"commitFlushedImage","Not implemented yet",null);
	  throw new ExException("commitFlushedImage is not implemented yet");
	}

  /**
   * Stop cell which self belongs to.
   * @exception ExCellException : May be one of follows<br>
   ExCellNotFoundException : Cell is not existed(may be stopped by other.)<br> 
   ExIllegalCellStateException : Cell is not in 'active' state.<br>
   ExCellHookException : quiet method of the cell raised an exception.<br>
   * @exception ExException : Unrecoverable exception occured inside of executor.
   */
  protected final void stopCell() throws ExException,ExCellException
    {
      final ExCell currentCell = ExCell.currentCell();
      final ExGOD currentCellGod = new ExGOD(currentCell);
      final long gracePeriod=60000;

      if (Executor.securityManager != null) {
           Executor.securityManager.tryStopGlobalObject(new OzProxy());
      }

      new OzThread(
		   new OzRunnable() {
		     public
		       void run() {
			 try {
			   Executor.debug(CN,"stopCell","try to stop self");
			   Executor.debug(CN,"stopCell","quit own cell");
			   ExCellManager.quit(currentCellGod,gracePeriod);
			   Executor.debug(CN,"stopCell","cell stopped");
			 } catch (ExException e) {
			   Executor.debug(CN,"stopCell"," exception occured in ExCellManager#quit",e);
			 }
		       }
		   }
		   );

    }
  
  /* current color of thread and object */
  /**
   * Check color of running thread.
   * @return true if current running thread is Red otherwise false.
   *
   * @see #runningIsGreen
   */
  protected final boolean runningIsRed()
    {
      Thread t = Thread.currentThread();
      if (t instanceof ExThread) {
	return !(((ExThread)t).color);
      }
      return true;
    }

  /**
   * Check color of running thread.
   * @return true if current running thread is Green otherwise false.
   *
   * @see #runningIsRed
   */
  protected final boolean runningIsGreen()
    {
      Thread t = Thread.currentThread();
      if (t instanceof ExThread) {
	return ((ExThread)t).color;
      }
      return false;
    }

  /**
   * Check color of object.
   * @return true if object(self) is Red otherwize false.
   *
   * @see #isGreen
   */
  public final boolean isRed()
    {
      return !(color);
    }

  /**
   * Check color of object.
   * @return true if object(self) is Green otherwize false.
   *
   * @see #isRed
   */
  public final boolean isGreen()
    {
      return color;
    }

  /* Change color */
  /**
   * Change color of an OzSecureObject.
   * @exception SecurityException when Red thread invokes this method.
   *
   * @see #changeObjectToGreen
   */
  protected final void changeObjectToRed( OzSecure obj )
    throws SecurityException
      {
	Thread t = Thread.currentThread();
	if (t instanceof ExThread) {
	  if (((ExThread)t).color && color) {
	    obj.color = RED;
	  } else {
	    throw new SecurityException("Red thread/object can't change object color.");
	  }
	} else {
	  throw new SecurityException("non-ExThread can't change object color.");
	}
      }

  /**
   * Change color of an OzSecureObject.
   * @exception SecurityException when Red thread invokes this method.
   *
   * @see #changeObjectToRed
   */
  protected final void changeObjectToGreen( OzSecure obj ) 
    throws SecurityException
      {
	Thread t = Thread.currentThread();
	if (t instanceof ExThread) {
	  if (((ExThread)t).color && color) {
	    obj.color = GREEN;
	  } else {
	    throw new SecurityException("Red thread/object can't change object color.");
	  }
	} else {
	  throw new SecurityException("non-ExThread can't change object color.");
	}
      }
  
  /**
   * Change color of current running thread.
   * @exception SecurityException when Red thread invokes this method.
   *
   * @see #changeRinningToRed
   */
  protected final void changeRunningToGreen()
    throws SecurityException
      {
	if (color) {
	  Thread t = Thread.currentThread();
	  if (t instanceof ExThread) {
	    ((ExThread)t).color=GREEN;
	  } else {
	    throw new SecurityException("Can't change color of Java's thread.");
	  }
	} else {
	  throw new SecurityException("Red object can't change process color.");
	}
      }

  /**
   * Change color of current running thread.
   * @exception SecurityException when Red thread invokes this method.
   *
   * @see #changeRinningToGreen
   */
  protected final void changeRunningToRed() 
    throws SecurityException
      {
	if (color) {
	  Thread t = Thread.currentThread();
	  if (t instanceof ExThread) {
	    ((ExThread)t).color=RED;
	  } else {
	    throw new SecurityException("Red object can't change process color.");
	  }
	}
      }

  /**
   * �ƤӽФ��줿�᥽�å�¦�Ǥ��Υ᥽�åɤ�ƤӽФ���
   * �������ƥ��ο������ʤ�����Ĵ�٤롣����åɤ�
   * ���饹 ExThread �Υ��֥������ȤǤʤ�����֥ץ���
   * �Ȥ��ư�����
   *
   * @exception	SecurityException
   *					�֥ץ������Х��֥������ȤΥ᥽�åɤ�ƤӽФ���
   *
   * @see	ExThread#color
   * @see	OzSecure#color
   */
  protected final
    void checkSecureInvocation()
      throws SecurityException
	{
	  Thread t = Thread.currentThread();
	  if (t instanceof ExThread) {
	    if (! ((ExThread)t).color && color) {
	      throw new SecurityException("Can't invoke to green object from red process.");
	    }
	  } else if (color) {
	      throw new SecurityException("Can't invoke to green object from no ExThread.");
	  }
	}
  
  /**
   * �ƤӽФ��줿�᥽�å�¦�Ǥ��Υ᥽�åɤ�ƤӽФ���
   * ɬ�פʤ�ץ����ο����֤��ѹ����롣
   *
   * @return			�ץ����ο����ѹ��������ɤ���
   *
   * @see	ExThread#color
   * @see	OzSecure#color
   */
  protected final
    boolean changeThreadRedIfNecessary(Object callee)
      {
	Thread t = Thread.currentThread();
	
	if ((t instanceof ExThread)&&(((ExThread)t).color==GREEN)) {
	  if((callee instanceof OzSecure)&&(((OzSecure)callee).color==GREEN)){
	    return false;
	  } else {
	    ((ExThread)t).color=RED;
	    return true;
	  }
	} else {
	  return false;
	}
      }

  private static boolean isGreenThread(Thread t) {
      if (t instanceof ExThread) {
	  return ((ExThread)t).color == GREEN;
      }
      return false;
  }

  /**
   * static �᥽�åɤ���¾�Υ��֥������Ȥ��� static �᥽�åɤ�ư����ݤ�
   * �ƤӽФ��ơ�ɬ�פʤ饹��åɤο����ѹ����롣
   */
  public static Object delegate(OzSecure target, Method method,
				Object[] arguments) throws Exception {
      if (target.isRed() && isGreenThread(Thread.currentThread())) {
	  ExThread t = (ExThread)Thread.currentThread();
	  t.color = RED;
	  try {
	      return method.invoke(target, arguments);
	  } finally {
	      t.color = GREEN;
	  }
      } else {
	  return method.invoke(target, arguments);
      }
  }

  /**
   * ���Υ᥽�åɤ�¹Ԥ��Ƥ��륹��åɤμ¹Ԥ����Ǥ��롣
   *
   * @see	OzSecure#abort
   * @see	ExCallerChannel#abort
   */
  void abort()
    {
      Thread t = Thread.currentThread();
      if(t instanceof ExThread){
	try {
	  ExCalleeChannel callee = ((ExThread)t).channel;
	  callee.abort();
	} catch (Exception e) { /* unexpect exception */
	  Executor.error(CN,"abort",e);
	}
      } else {  /* for non OZ-thread */
	t.interrupt();
      }
    }

    /**
     * The current thread yields the CPU to the other thread.
     */
    protected final
    void yieldThread()
    {
	Thread t = Thread.currentThread();
	// if(t instanceof ExThread) {
	t.yield();
	// } else {???}
    }

    /**
     * The current thread sleeps for specified duration.
     *
     * @param	time	Number of milliseconds to sleep.
     * @exception	ExInterruptedException
     *			The thread is interrupted while sleeping.
     */
    protected final
    void sleepThread(int time)
    throws ExInterruptedException
    {
	Thread t = Thread.currentThread();
	// if(t instanceof ExThread) {
	try {
	    t.sleep((long)time);
	} catch (InterruptedException e) {
	    throw new ExInterruptedException("Interrupted while sleeping");
	}
	// } else {???}
    }
  
  /**
   * Get GOD of current cell
   *
   * @return  A string represents GOD of current cell
   */
  protected final 
  String _getGOD()
  {
    return ExCell.currentCell().getName();
  }

  /**
   * Get GOL of current cell
   *
   * @return  A string represents GOL of current cell
   */
  protected final 
  String _getGOL()
  {
    try {
      return  new ExGOL(ExCell.currentCell().getName()).getName();      
    } catch (ExGOLFormatException never) { // never occure
      return "";
    }
  }
  

  /**
   * �ϣڤΥ��֥������Ȥϡ����󥳡��ɤ�Ԥ��᥽�åɤ�
   * ��������뤳�ȤϤǤ��ʤ���
   *
   */
  private final
    void writeObject(ObjectOutputStream out)
      throws IOException
	{
	  // Executor.debug(CN,"writeObject","()");
	  checkSecureInvocation();
	  Thread t = Thread.currentThread();
	  if ((t instanceof ExThread) && ((ExThread)t).color) {
	    out.writeBoolean(color);
	  } else {
	    out.writeBoolean(false);
	  }
	}
  
  /**
   * �ϣڤΥ��֥������Ȥϡ��ǥ����ɤ�Ԥ��᥽�åɤ�
   * ��������뤳�ȤϤǤ��ʤ���
   *
   * @exception	IOException
   */
  private final
    void readObject(ObjectInputStream in)
      throws IOException
	{
	  // Executor.debug(CN,"readObject","()");
	  Thread t = Thread.currentThread();
	  if (t instanceof ExThread && ((ExThread)t).color == ExThread.GREEN) {
	    color = in.readBoolean();
	  } else {
	    in.readBoolean(); // skip
	      color = RED;
	  }
	}
  
  /**
   * �ǥե���Ȥ�ɽ�����Ƥ˥��֥������Ȥο���ä���ɽ�����롣
   *
   * @see	OzSecure#GREEN
   * @see	OzSecure#RED
   * @see	OzSecure#color
   */
  public
    String toString()
      {
	return super.toString()+"["+(color==GREEN?"GREEN":"RED")+"]";
      }
    
}
