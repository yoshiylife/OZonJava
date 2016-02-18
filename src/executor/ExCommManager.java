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
 * $Id: ExCommManager.java,v 2.2 1997/12/04 04:55:19 yoshi Exp $
 */
/* Update history */
/* 2-Feb-1997: Modify connection management */

package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;

/***
 * communication management
 * @version		$Revision: 2.2 $ $Date: 1997/12/04 04:55:19 $
 * @author		Yoichi Hamazaki
 */ 
class ExCommManager{
  private static final String CN="ExCommManager";
  static ThreadGroup communicationThreads=new ThreadGroup("CommunicationSystemThreads");

  /***
   * ServerSocket for accept
   */
  static ServerSocket executorPort;


  /**
   * ExCommAddress of the executor.<br>
   * Executor's communication address is address of executorPort.
   */
  static public ExCommAddress executorAddress;


  /***
   * neme of OZHOME
   */
  static final String ozhomeName=System.getProperty("oz.home.name");

  /**
   * Manager of Communication Port
   */
  static ExCommPortManager portManager;

  /**
   * constructor and initializer of communication system.
   */
  ExCommManager(){
    int i=0,ii=0;
    try{
      executorPort = new ServerSocket(0,5);
    } catch (Exception ex) {
      Executor.debug("ServerSocket: creation failure :: "+ex.getMessage());
    }
    try {
      executorAddress = new ExCommAddress(InetAddress.getLocalHost(),executorPort.getLocalPort(),0);
    } catch (Exception ex) {
      Executor.debug("getLocalHostfailure :: "+ex.getMessage());
    }
    
    Executor.debug("executorAddress is "
		       +executorAddress.toString());

    /* initialize SessionId */
    ExSessionId.initialize(executorAddress.address.getAddress(),executorAddress.port);

    if(ozhomeName=="")
      {
	Executor.debug("ozhome name is not specified,so no intersite communication possible!");
	Executor.syslog(CN,"main","ozhome name is not specified!",null);
      }

    portManager = new ExCommPortManager(executorPort);
  }



  static synchronized final void deadExecutorFound(ExCommAddress addr)
    { 
      Executor.syslog(CN,"deadExecutorFound","dead executor's address is "+addr.toString(),null);
      return;
    }

  public static final void shutdown(){
    ExCommPortManager.shutdown();
    communicationThreads.stop();
  }


  /***
   * fork for remote global invocation.
   * @param addr          ExCommAddress of callee object.
   * @param callerChannel channel of caller.
   * @param proxy         proxy of global invocation.
   * @param callerGol     GOL of caller object.
   * @return ExRemoteCalleeChannel to be created.
   * @exception OzConnectionFailureException raised if addr is not valid.
   */
 final ExRemoteCalleeChannel forkOLD(ExCommAddress addr,
					     ExChannel callerChannel,
					     OzProxy proxy,String callerGol)
    throws ExException,ExCellNotActiveException
  {
    return forkInternal(addr,callerChannel,proxy,callerGol);
  }

  final ExRemoteCalleeChannel fork(ExChannel callerChannel,
				      OzProxy proxy,String callerGol)
    throws ExException,ExCellNotActiveException
      {
	ExCommAddress failedAddr = null;
	ExCommAddress addr;
	ExRemoteCalleeChannel callee=null;

	for (;;) {
	  addr = ExAddressManager.resolve(proxy.getGOL(),failedAddr);
	  try{
	    callee=forkInternal(addr,callerChannel,proxy,callerGol);
	    break;
	  } catch (ExCommConnectionFailureException cf){
	    Executor.debug(CN,"fork(","proxy="+proxy+")",cf);
	    failedAddr=addr;
	  }
	}
	return callee;
      }

  private final ExRemoteCalleeChannel forkInternal(ExCommAddress addr,
					     ExChannel callerChannel,
					     OzProxy proxy,String callerGol)
    throws ExException,ExCellNotActiveException
    {
      ExRemoteCalleeChannel channel = new ExRemoteCalleeChannel(addr,callerChannel,proxy,callerGol);
      
      ExCommSessionManager.registerClientTerminal(channel.getSessionId(),(ExSessionTerminal)channel);

      Thread t = new Thread(communicationThreads,channel);
      t.start();
      return channel;
    }
}
