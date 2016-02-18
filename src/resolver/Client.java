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
//Resolver Test Client

package JP.go.ipa.oz.user.res;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

public class Client {
 Socket socket;
 Thread writer,reader;

public static void main(String[] args) {
 int port=Integer.parseInt(args[0]);
 System.out.println("Client start");
 new Client(port);
}
public Client(int port){
 try{ 
  socket=new Socket(InetAddress.getLocalHost().getHostAddress(),port);
  reader = new Reader(this);
  reader.setPriority(6);
  writer=new Writer(this);//to send
  writer.setPriority(5);
  reader.start();
  writer.start();
 }
 catch (IOException e) {System.err.println(e);}
}
}
//バッファをサーバへ送信する
class Writer extends Thread{
 ByteArrayOutputStream bo;
 Client client;

public Writer(Client c){
  super("Client Writer");client = c;
}
public void run(){
   DataInputStream in = null;
   PrintStream out = null;
   try{
    DataOutputStream so=new DataOutputStream(client.socket.getOutputStream());
    so.writeUTF("REQ");
    so.writeUTF("oz.ipa.go.jp:myasuda:t");//GOL
    so.writeUTF("0.0.0.0");//前回失敗したIP
    so.writeInt(0);//前回失敗したport
    so.flush();
    so.writeUTF("REQ");
    so.writeUTF("oz.ipa.go.jp:myasuda:t");//GOL
    so.writeUTF("0.0.0.0");//前回失敗したIP
    so.writeInt(0);//前回失敗したport
    so.flush();
//    while(true){}
   }
   catch(IOException e){System.err.println("Writer: " + e);}
   finally{if (out != null) out.close();}
//   System.exit(0);
}
}

//サーバからバッファを読み、表示する。
class Reader extends Thread{
    Client client;
    public Reader(Client c){
        super("Client Reader");
        this.client = c;
    }
    public void run(){
        DataInputStream in = null;
        String line,req;
        try{
            in = new DataInputStream(client.socket.getInputStream());
            String gol,addr;int port;
            while(true){
		req=in.readUTF();System.out.println(req);
                if(req== null)break;
		else if(req.equals("RES")){
  		 if((gol=in.readUTF())!=null)
	         if((addr=in.readUTF())!=null)
                 if((port=in.readInt())!=0)
                  System.out.println(req+":"+gol+","+addr+","+port);
                }
		else if(req.equals("NA")){
  		 if((gol=in.readUTF())!=null)
                  System.out.println(req+":"+gol);
                }
            }
            in.close();
        }
        catch (IOException e){ System.out.println("Reader: " + e); }
        finally{ try{if (in != null) in.close();} catch (IOException e){;} }
        System.exit(0);
    }
}





