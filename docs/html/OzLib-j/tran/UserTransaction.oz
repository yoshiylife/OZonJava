/*
 Sample of UserTransaction
 使用上の注意：
  Array resouceのcreate size
  GOLの指定は正確に行うこと。
*/
cell UserTransaction : *Transaction{
 String T,R,T2,R2;//GOL of Transaction and Resource
 protected void initialize(){
   T="t";R="r";T2="t2";R2="r2";
   d=>create();x=1;d->setP(" t:");//for debug
   super->initialize(T);//このセルのGOLを指定
 }
 protected void quiet(){flushCell();}
 protected void go(){}

//------------TEST-------------------------------
 public  void testBasic0(){//tr
  begin();
   Array res=>create(1);res->putAt(0,R);//set TransactionResource
  lock(res,5000);update(res); commit();d->write(x,"end");
 }
 public  void testBasic(){//tr
  begin();
   Array res=>create(1);res->putAt(0,R);//set TransactionResource
  lock(res);update(res); commit();d->write(x,"end");
 }
 public void testBasic2(){//t2r2
  begin();
  Array res=>create(1);res->putAt(0,R);
  lock(res);
  UserTransaction2 t2;t2=>bind(T2);t2->testBasic();
  update(res);commit();d->write(x,":end");
 }
 public  void testAbort(){//tr
  begin();
   Array res=>create(1);res->putAt(0,R);//set TransactionResource
  lock(res);update(res); commit();d->write(x,"end");
 }
 public void testDist(){//tr2
  begin();
  Array res=>create(2);res->putAt(0,R); res->putAt(1,R2);
  lock(res);
  update(res);commit();d->write(x,":end");
 }
 public void testDist2(){//t2r2
  begin();
  Array res=>create(2);res->putAt(0,R); res->putAt(1,R2);
  lock(res);
  UserTransaction2 t2;t2=>bind(T2);t2->testBasic();
  update(res);commit();d->write(x,":end");
 }
 public void testDeadLock(){//for checkDeadLock
    Array res=>create(1);res->putAt(0,R);
    lock(res,0);//ロックできずタイムアウトならデッドロック
    UserTransaction2 t2;t2=>bind(T2);t2->testDeadLock();
    res->putAt(0,R2);
    lock(res,0);
    if(checkDeadLock())d->write("Dead locked.");
    d->write(x,"Transaction end");
 }
//------------UPDATE/READ-------------------------------
 public void update(Array res){ //for example
  d->write(x,":update");
  UserTransactionResource r;
  String rg;rg=|res->at(0);
  r=>bind(rg);
  r->update(getTID(),7,"WINNER");
 }
}
class child : *Runnable{
 Debug d;
 int i;
 new create(){d=>create();}
 public void set(int j){i=j;}
 public void run(){
  String T2="t2";
  d->write("child run");
  UserTransaction2 t2;t2=>bind(T2);t2->testBasic();
  d->write("child end");
 }
}




