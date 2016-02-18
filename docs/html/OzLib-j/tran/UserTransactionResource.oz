/*
  Sample of TransactionResource
*/
cell UserTransactionResource : *TransactionResource{

 protected void initialize(){
  d=>create();x=1;d->setP(" r:");//for debug
  super->initialize("tmp0","tmp1","tmp2","r");
  //define fileName to save:status,resource,resource for recover and GOL of this
  createResource();
 }
 protected void go(){}
 protected void quiet(){flushCell();}
 protected void createResource(){
  UserResource ur=>create();r=>create(ur);
 }

//--------------------UPDATE/READ------------------
public final void update(TID t,int i,String s){
 try{
 auth->authorize(t);
 d->write(x,"update:",t->getGOL(),t->getID());
 if(st->isInLockingTransaction(t) && st->getLockMode()==2){
  UserResource ur; ur=|r->getUserResource();
  ur->update(i,s); r->setUserResource(ur);
 }else 
   d->write(1,"Resource wasn't exclsive-locked,cannot update",t->getGOL(),t->getID());
 }catch(Exception e){d->write(1,"Exception occured");}
}
public final String read(TID t){
 try{
 d->write(x," read:");
// if(st->isInLockingTransaction(t) && st->getLockMode()>0){
    UserResource ur; ur=|r->getUserResource();
    return ur->getName();//ur->getID();
//}
 }catch(Exception e){d->write(1,"Exception occured");return null;}
} 

//-------ユーザが定めるリカバリの方法----------------------
protected void userRecover(TID t){ //Must be over ride in UserResource
 try{
 auth->authorize(t);
 rollbackForRecover(t);d->write(1,"self rollbacked");
//condition c;wait(c,10000);//一定時間Transactionの指示を待つ
   }
   catch(OverTimeException e){
    st->init();
   }
  catch(Exception e){d->write(1,"Exception occured");}
}

}




