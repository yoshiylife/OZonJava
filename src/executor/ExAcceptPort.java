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

package JP.go.ipa.oz.system;

import java.io.*;
import java.net.*;
import java.util.*;

/***
 * port to accept connection<br>
 * @see ExReceivePort
 *
 * @author Yoichi Hamazaki
 */
final class ExAcceptPort implements Runnable{
  ServerSocket serverPort;
  private static String CN="ExAcceptPort";
  
  /***
   * construct ExAcceptPort using a ServerSocket
   * @param s ServerSocket where connections are accept from
   */
  ExAcceptPort(ServerSocket s){
    Executor.debug(CN+" created");
    serverPort=s;
  }
  
  
  /**
   * Method for deamon process of ExAcceptPort<br>
   */
  public final void run(){
    Socket s;
    ExReceivePort p;

    Executor.debug(CN+"#run : Executor can accept connection now!");
    for(;;){
      try{
	s = serverPort.accept();
	/* Executor.message("ExAcceptPort#run: accept"); */ /* debug print */
      } catch (IOException ex) {
	Executor.debug(CN+"#run Exception occured"+ex.getClass()+ex.getMessage());
	return;
      }
      p = ExCommPortManager.AddNewReceivePort(new ExReceivePort(s));
      new Thread(p).start();
    }
  }
  
  /***
   * shutdown ExAcceptPort<br>
   * shutdown will cause deamon process an exception because shutdown closes
   * serverPort.
   */
  final void shutdown(){
    try{
      serverPort.close();
    }catch (Exception ex){ /* ignore any exception */
    }
  }
}
