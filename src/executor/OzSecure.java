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
 * OzSecure は全てのＯＺのオブジェクトによって継承されるクラスである。
 * つまり、OzSecure を継承しないクラスから生成されたオブジェクトは
 * ＯＺのオブジェクトとは呼ばない。
 * また、OzSecure はＯＺのノンリエントラントなモニタ機能を持つOzMonitor
 * を継承している。
 * OzSecure はＯＺのセキュリティを実現するための機能を持っている(名前の由来)。
 * 即ち、ＯＺのオブジェクトがどの色（赤／緑）なのかを表現し、
 * その色の変更や問い合わせに関する機能をもっている。
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
   * エグゼキュータ実装のデバッグ用
   */
  static String CN = "OzSecure";

  /**
   * ＯＺのオブジェクトの色が緑色であることを表す。
   * 緑色のＯＺオブジェクトは安全なオブジェクトであるとされる。
   */
  public final static boolean GREEN = true;

  /**
   * ＯＺのオブジェクトの色が赤色であることを表す。
   * 赤色のＯＺオブジェクトは危険なオブジェクトであるとされる。
   */
  public final static boolean RED = false;

  /**
   * ＯＺのオブジェクトは必ず OzSecure.GREEN または、
   * OzSecure.RED の色である。その色を保持する。
   */
  boolean color;

  /**
   * 新しいＯＺのオブジェクトを作成する。ＯＺのオブジェクトは
   * 必ず色を持つので、新しく作成するＯＺのオブジェクトの色を
   * 設定する。ＯＺのオブジェクトを生成しようとしている
   * スレッドがＯＺのスレッドの時は、そのＯＺのスレッドの色と
   * 新しく作成するＯＺのオブジェクトの色は同じになる。
   * ＯＺのオブジェクトを生成しようとしているスレッドが
   * ＯＺのスレッドでない時は、新しく作成するＯＺの
   * オブジェクトの色は赤色になる。
   *
   * @return	新しいインスタンス
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
   * 呼び出されたメソッド側でこのメソッドを呼び出し、
   * セキュリティの侵害がないかを調べる。スレッドが
   * クラス ExThread のオブジェクトでなければ赤プロセス
   * として扱う。
   *
   * @exception	SecurityException
   *					赤プロセスが緑オブジェクトのメソッドを呼び出した
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
   * 呼び出されたメソッド側でこのメソッドを呼び出し、
   * 必要ならプロセスの色を赤に変更する。
   *
   * @return			プロセスの色を変更したかどうか
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
   * static メソッドが、他のオブジェクトの非 static メソッドを起動する際に
   * 呼び出して、必要ならスレッドの色を変更する。
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
   * このメソッドを実行しているスレッドの実行を中断する。
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
   * ＯＺのオブジェクトは、エンコードを行うメソッドを
   * 再定義することはできない。
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
   * ＯＺのオブジェクトは、デコードを行うメソッドを
   * 再定義することはできない。
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
   * デフォルトの表示内容にオブジェクトの色を加えて表示する。
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
