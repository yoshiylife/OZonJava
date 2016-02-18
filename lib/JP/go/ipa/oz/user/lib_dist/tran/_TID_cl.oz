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

class TID{//Transaction ID
 new create(){id=0;GOL="";}
 new create(int i,String s){id=i;GOL=s;}
 int id;
 String GOL;
 int lockMode;//lockMode for resource

 public void set(int i,String s){id=i;GOL=s;}
 public void setID(int i){id=i;}
 public int  getID(){return id;}
 public String getTidGOL(){return GOL;}
 public bool equal(TID tid){
  if((id==tid->getID())&&(tid->getTidGOL()->compareTo(GOL)==0))return true;
  else return false;
 }
 public void init(){id=0;GOL="";}
 public void setLockMode(int i){lockMode=i;}
 public int  getLockMode(){return lockMode;}
}
class TIDComparator : Comparator{
 new create(){}
 public boolean compare(Root t1,Root t2){
  TID a1,a2;a1=|t1;a2=|t2;
  if(a1->equal(a2))return true;
  else return false;
 }
 public Comparator duplicate (){return this;}
 public int hash (Root t){return 0;}
}