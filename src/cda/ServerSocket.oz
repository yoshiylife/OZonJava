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

class ServerSocketRunnable :* Runnable{

  ServerSocket listen;

  new create(int port){
    try{
      listen => breed(port);
    } catch(IOException e){
      system->println("can not breed ServerSocket");
    }
  }

  protected void communicateWith(DataInputStream in, DataOutputStream out){
    String protocolTag = in->readUTF();
    if(protocolTag->isequal("REQ")){
      String codePath = in->readUTF();
      
  }

  public void run(){
    System system=>create();
    try{
      while(true){
        Socket cl = listen->accept();
        DataInputStream in => breed(cl->getInputStream());
        DataOutputStream out => breed(cl->getOutputStream());
        communicateThrough(in,out);
      }
    } catch(IOException){
      system->println("ServerSocket can not make DataInput/OutputStream");
    }
  }

}
