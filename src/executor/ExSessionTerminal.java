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

/***
* Interface for Terminal of communication session of OZ.<br>
*
* @author: Yoichi Hamazaki
*/
interface ExSessionTerminal{
  /***
   * Notify error of communication session.<br>
   * This method is invoked by ExSendPort's thread 
   * and KeepAlive daemon thread.<br>
   *
   * @param  code  Error code (detail definition is not completed)
   */
  void notifyError(int code);

  /***
   * Pass buffer received from ExReceivePort to the ExSessionTerminal.<br>
   *
   * @param rbuf buffer received from ExRecevePort.
   */
  void putReceiveBuffer(ExReceiveBuffer rbuf);

  /***
   * Get session-id of the ExSessionTerminal.
   *
   * @return Value of ExSessionId.
   */
  ExSessionId getSessionId();
}

