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

class Timer extends Thread{
 protected long time;//[milli sec]
 boolean end;

public synchronized boolean isEnd(){return end;}
public synchronized void setEnd(){end=true;}

public Timer(long time){
 end=false;
 this.time=time;
 this.start();
}

public void cancel() throws Exception{
  this.stop();
  if(isEnd())throw new Exception("Timed Out");
}

public synchronized void end() throws Exception{
 setEnd();
 throw new Exception("timed out");
}
public synchronized void run(){
 try{
   wait(time); setEnd();
  }catch(Exception e){System.out.println(e);}
}
}

/*
class test extends Thread{
 int time;
test(int t){time=t;this.start();}

public static void main(String[] args){
 new test(Integer.parseInt(args[0]));
}
public synchronized void run(){
 try{
   Timer t=new Timer(time);
   wait(100);
   System.out.print("METHOD");
   t.cancel();
 }catch(Exception e){System.out.println("Exception!"+e);}
 finally{
 }
}
}
*/
