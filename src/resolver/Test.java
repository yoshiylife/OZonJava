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

import java.io.*;
import java.net.*;
import java.awt.*;
import java.util.*;

public class Test{
 String cashFile="tmp";
 Vector cash; 

public static void main(String[] args){
 System.out.println("start");
 Test t=new Test();
 t.saveCash(t.cash);
 t.cash=(Vector)t.createCash();
 System.out.println("load cashe:"+t.cash.size());
 System.out.println("end");
}
Test(){
 cash=new Vector();
 cash.addElement("abc");cash.addElement("def");
}
public void saveCash(Object object){
 try{
  if(cash.size()>0){
   File fi=new File(cashFile);
   FileOutputStream ostream = new FileOutputStream(cashFile);
   ObjectOutputStream p = new ObjectOutputStream(ostream);
   p.writeObject(cash);
   p.flush();
   ostream.close();System.out.println(" cashe saved:"+cash.size());
  }else System.out.println(" needless to save cashe");
 }catch(Exception e){System.out.println(e);}
}
public Object createCash(){
 try{
  System.out.println("createCash:"+cashFile);
  cash=new Vector();
   File fi=new File(cashFile);
   FileInputStream istream = new FileInputStream(fi);
   ObjectInputStream pi = new ObjectInputStream(istream);
   return pi.readObject();
   //istream.close();
//   System.out.println("load cashe:"+cash.size());
 }catch(FileNotFoundException e){System.out.println(e);return null;}
  catch(Exception e2){System.out.println(e2);return null;}
}
}



