class Authenticator
{
 String myOzHome;

 new create(String myHome){myOzHome=myHome;}

public void authorize(Root obj){
  if(obj!=null && obj->isRed()){
        turnGreen(obj);
        obj->toGreen();
  }
}
public void authenticate(){
 if(!myOzHome->isequal(OzCipher->getCallerOzHome())){
  UnknownUserException e=>init();throw e;
 }
}
}
