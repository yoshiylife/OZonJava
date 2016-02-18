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

package JP.go.ipa.oz.user.res;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

abstract class Server extends Thread{
 protected ServerSocket listen_socket;
 public Vector cash;//GOのGOL+アドレスのキャッシュ=GolCom
 protected String cashFile;
 protected Debug d;

public Server(){
 super("Server");//Create server thread with a name.
 System.out.println(" OZ Resolver Ver.0.2.7");
}
protected Object getConnection(Socket client_socket){
 Connection c = new Connection(client_socket);
 return c;
}
protected void newListen(int port){
 d.println("---listening---");
 try{listen_socket=new ServerSocket(port);}
 catch(IOException e){fail(e, "Exception creating server socket"); }
}
public void run(){
 try{
  //System.out.println("Server thread start------");
  while(true){
   Socket client_socket = listen_socket.accept();
   Connection c =(Connection)getConnection(client_socket);
  }
 }catch(IOException e){
   fail(e, "Exception while listening for connections");
 }
}
public static void fail(Exception e, String msg) {
 System.err.println(msg + ": " +  e);System.exit(1);
}
protected void saveStatus(){;}
public void quit(){
 saveStatus();
 saveObject(cashFile,cash);
 try{this.stop();}catch(Exception e){;}
 System.out.println("OZ Resolver stoped");
}

//-----キャッシュに要素を追加----------

protected void loadCash(String cashFile){
 this.cashFile=cashFile;
 if((cash=(Vector)loadObject(cashFile))==null)cash=new Vector();
 d.println(cashFile+" loaded:"+cash.size());
}

public synchronized void addCash(GolCom g){
 if(!cash.contains(g)){
  GolCom gc=null;boolean b=false;
  for(int i=0;i<cash.size();i++){
   gc=(GolCom)cash.elementAt(i);
   if(gc.gol.equals(g.gol))
    if(!(gc.com.ip.equals(g.com.ip)&&gc.com.port==g.com.port)){
     cash.removeElement(gc);d.println("removed");break;}
    else{b=true;break;}
  }
  if(!b){cash.addElement(g);d.println(" added cash:"+cash.size());}
 }
}

//------キャッシュからアドレス取得--------------

public ComAddr getComAddrOf(String gol,String ip,int port){
 for(int i=0;i<cash.size();i++){
  GolCom g=(GolCom)cash.elementAt(i);
//  d.println(" cash="+g.gol+g.com.port);
  if(g.gol.equals(gol)){
   if(g.com.port==port && g.com.ip.equals(ip))
    cash.removeElement(g);//失敗アドレスをキャッシュから削除
   else{d.println(" cash hit!");return g.com;}
  }
 }
 return null;
}
//-------オブジェクトのSAVE/LOAD--------------------

public void saveObject(String fileName,Object object){
 try{
  if(cash.size()>0){
   File fi=new File(fileName);
   FileOutputStream ostream = new FileOutputStream(fileName);
   ObjectOutputStream p = new ObjectOutputStream(ostream);
   p.writeObject(object);p.flush();
   ostream.close();
   d.println(" object saved to "+fileName);
  }else d.println(" needless to save "+fileName);
 }catch(Exception e){System.out.println(e);}
}
public Object loadObject(String fileName){
 try{
  //d.println("load object from "+fileName);
  File fi=new File(fileName);
  FileInputStream istream = new FileInputStream(fi);
  ObjectInputStream pi = new ObjectInputStream(istream);
  return pi.readObject();//istream.close();
 }catch(FileNotFoundException e){
  //d.println("no file to load:"+fileName);
  return null;}
  catch(Exception e2){System.out.println(e2);return null;}
}
}








