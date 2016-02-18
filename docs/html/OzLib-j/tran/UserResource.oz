// This is sample class of UserResource

class UserResource{
 int id;
 String name;

 new create(){id=1;name="INIT";}

 public final void update(int i,String s){id=i;name=s;}
 public final String getName(){return name;}
 public final int getID(){return id;}
}
