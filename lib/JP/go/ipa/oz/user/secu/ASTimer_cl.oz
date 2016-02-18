class ASTimer{
 protected bool isDone;
 protected condition end;
 new create(){}
 protected locked void endWait(int time){if(!isDone)wait(end,time);}
 public locked void MethodDone(){isDone=true;signal(end);}
 public void invoke(Connection mr,int time){
  isDone=false;
  Thread t=>create(mr);
  endWait(time);
  if(!isDone){TimeOutException e=>init();throw e;}
 }
}
