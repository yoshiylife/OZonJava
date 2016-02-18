class CDAdebug {

  System system;

  bool on;

  new create(){
    system=>create();
    on = false;
  }

  public void println(String s){
    if(on) system->println(s);
  }

  public void println(String s,String ss){
    if(on){
      String mes = s->concat(" "); mes = mes->concat(ss);
      if(on) system->println(mes);
    }
  }

  public void println(String s,int i){
    if(on){
      Integer I => breed(i);
      String mes = s->concat(" "); mes = mes->concat(I->asString());
      if(on) system->println(mes);
    }
  }

  public void println(String s,long l){
    if(on){
      Long L => breed(l);
      String mes = s->concat(" "); mes = mes->concat(L->asString());
      if(on) system->println(mes);
    }
  }

}
