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

class Debug{
 String p;//for pre-message
 new create(){p="";}

 public void setP(String s){
  p=s;
 }
 public String itoa(int a1){
  Integer iway1=>breed(a1);
  String  ans1 = iway1->asString();
  return ans1;
 }
 public void write(String str){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->println(str);o->flush();
 }
 public void write(int j,String str){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->println(str);o->flush();}
 }
 public void write(int j,String str,int i){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->print(str); o->println(i);o->flush();}
 }
 public void write(int j,String str,int i,String str2){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->print(str); o->print(i);o->println(str2);o->flush();}
 }
 public void write(int j,String str,int i,String str2,int i2){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->print(str); o->print(i);o->print(str2);o->println(i2);o->flush();}
 }
 public void write(int j,String str,String str2){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->print(str); o->println(str2);o->flush();}
 }
 public void write(int j,String str,String str2,int i){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->print(str);o->print(str2);o->print(",");o->println(i);o->flush();}
 }
 public void write(int j,String str,int i,int k){
  if(j==1){
   System ss;ss=>create();
   PrintWriter o = ss->getStdout();
   o->print(p);o->print(str);o->print(i);o->print(",");o->println(k);o->flush();}
 }
}
