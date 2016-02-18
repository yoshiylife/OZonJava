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

class Server :* Runnable{
 OzAuthenticationServer as; 
 ServerSocket listen_socket;
 int port;
 System s;
 int time;
 Debug d;int x;//for debug

 new create(int port,OzAuthenticationServer as){
  s=>create();this->port=port;this->as=as; 
  d=>create();x=as->getDebug();
 }
 public void run(){
  Socket client;
  try{
   listen_socket=>breed(port);
   while(true){
    d->write(x,"listenning");
    if((client=listen_socket->accept())!=null){
     Connection c=>create(client,as);Thread t=>create(c);
    }
   }
  }catch(Exception e){s->println("Exception while listenning");}
 }
}






