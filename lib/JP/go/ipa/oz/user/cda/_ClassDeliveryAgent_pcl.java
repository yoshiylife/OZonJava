package JP.go.ipa.oz.user.cda;

public class _ClassDeliveryAgent_pcl extends JP.go.ipa.oz.user.misc.cell.Stoppable_pcl implements JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if {
  protected Object invoke (JP.go.ipa.oz.system.OzCell o) throws Exception {
    if (part != 2) return super.invoke (o);
    
    JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if g = (JP.go.ipa.oz.user.cda._ClassDeliveryAgent_if) o;
    Object result;
    
    switch (selector) {
    case 0:
      g.millorsAddTopPackageName(arg$0of0$target, arg$1of0$name);
      return null;
    case 1:
      return g.getClassProperty(arg$0of1$codePath, arg$1of1$name);
      
    case 2:
      return g.millor(arg$0of2$topPackageName, arg$1of2$time);
      
    case 3:
      int rval$3 = g.targetsPutAt(arg$0of3$at, arg$1of3$target);
      return new Integer(rval$3);
    case 4:
      return g.leaveToSearchAndDelivery(arg$0of4$codePath);
      
    case 5:
      boolean rval$5 = g.thisWriteInValid(arg$0of5$df);
      return new Boolean(rval$5);
    case 6:
      int rval$6 = g.targetsPut(arg$0of6$target);
      return new Integer(rval$6);
    case 7:
      return g.millorsGet(arg$0of7$target);
      
    case 8:
      g.targetsRemove(arg$0of8$target);
      return null;
    case 9:
      g.stop();
      return null;
    case 10:
      g.millorsRemoveTopPackageName(arg$0of10$target, arg$1of10$name);
      return null;
    case 11:
      return g.searchAndDelivery(arg$0of11$codePath);
      
    case 12:
      g.millorsAdd(arg$0of12$target);
      return null;
    case 13:
      g.millorsWriteStart();
      return null;
    case 14:
      return g.targetsTargets();
      
    case 15:
      g.modeWriteInValid();
      return null;
    case 16:
      g.setInterval(arg$0of16$interval);
      return null;
    case 17:
      g.modeCopyOnWrite();
      return null;
    case 18:
      return g.getClassFile(arg$0of18$codePath);
      
    case 19:
      g.targetsSetLeaveTo(arg$0of19$whom);
      return null;
    case 20:
      return g.targetsLeaveToWhom();
      
    case 21:
      boolean rval$21 = g.thisCopyOnRight(arg$0of21$df);
      return new Boolean(rval$21);
    case 22:
      g.millorsPollingStart();
      return null;
    default:
      throw new Exception ("_ClassDeliveryAgent_pcl: invalid selector = " + selector);
    }
  }
  
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of0$target;
  JP.go.ipa.oz.lib.standard._String_if arg$1of0$name;
  
  public void millorsAddTopPackageName (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 0;
      arg$0of0$target = target;
      arg$1of0$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of0$target = null;
      arg$1of0$name = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of1$codePath;
  JP.go.ipa.oz.lib.standard._String_if arg$1of1$name;
  
  public JP.go.ipa.oz.lib.standard._ClassProperty_if getClassProperty (JP.go.ipa.oz.lib.standard._String_if codePath, JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 1;
      arg$0of1$codePath = codePath;
      arg$1of1$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of1$codePath = null;
      arg$1of1$name = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._ClassProperty_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of2$topPackageName;
  long arg$1of2$time;
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if millor (JP.go.ipa.oz.lib.standard._String_if topPackageName, long time) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 2;
      arg$0of2$topPackageName = topPackageName;
      arg$1of2$time = time;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of2$topPackageName = null;
      arg$1of2$time = 0;
      leave ();
    }
    return (JP.go.ipa.oz.user.cda._DeliveryFile_if) join ();
  }
  
  int arg$0of3$at;
  JP.go.ipa.oz.lib.standard._String_if arg$1of3$target;
  
  public int targetsPutAt (int at, JP.go.ipa.oz.lib.standard._String_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 3;
      arg$0of3$at = at;
      arg$1of3$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of3$at = 0;
      arg$1of3$target = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of4$codePath;
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if leaveToSearchAndDelivery (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 4;
      arg$0of4$codePath = codePath;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of4$codePath = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.cda._DeliveryFile_if) join ();
  }
  
  JP.go.ipa.oz.user.cda._DeliveryFile_if arg$0of5$df;
  
  public boolean thisWriteInValid (JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 5;
      arg$0of5$df = df;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of5$df = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of6$target;
  
  public int targetsPut (JP.go.ipa.oz.lib.standard._String_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 6;
      arg$0of6$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of6$target = null;
      leave ();
    }
    Integer result = (Integer) join ();
    return result.intValue ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of7$target;
  
  public JP.go.ipa.oz.lib.standard._Dictionary_if millorsGet (JP.go.ipa.oz.lib.standard._String_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 7;
      arg$0of7$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of7$target = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Dictionary_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of8$target;
  
  public void targetsRemove (JP.go.ipa.oz.lib.standard._String_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 8;
      arg$0of8$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of8$target = null;
      leave ();
    }
    join ();
  }
  
  
  public void stop () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 9;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of10$target;
  JP.go.ipa.oz.lib.standard._String_if arg$1of10$name;
  
  public void millorsRemoveTopPackageName (JP.go.ipa.oz.lib.standard._String_if target, JP.go.ipa.oz.lib.standard._String_if name) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 10;
      arg$0of10$target = target;
      arg$1of10$name = name;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of10$target = null;
      arg$1of10$name = null;
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of11$codePath;
  
  public JP.go.ipa.oz.user.cda._DeliveryFile_if searchAndDelivery (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 11;
      arg$0of11$codePath = codePath;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of11$codePath = null;
      leave ();
    }
    return (JP.go.ipa.oz.user.cda._DeliveryFile_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of12$target;
  
  public void millorsAdd (JP.go.ipa.oz.lib.standard._String_if target) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 12;
      arg$0of12$target = target;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of12$target = null;
      leave ();
    }
    join ();
  }
  
  
  public void millorsWriteStart () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 13;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._Array_if targetsTargets () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 14;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._Array_if) join ();
  }
  
  
  public void modeWriteInValid () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 15;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  int arg$0of16$interval;
  
  public void setInterval (int interval) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 16;
      arg$0of16$interval = interval;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of16$interval = 0;
      leave ();
    }
    join ();
  }
  
  
  public void modeCopyOnWrite () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 17;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of18$codePath;
  
  public JP.go.ipa.oz.lib.standard._ClassFile_if getClassFile (JP.go.ipa.oz.lib.standard._String_if codePath) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 18;
      arg$0of18$codePath = codePath;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of18$codePath = null;
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._ClassFile_if) join ();
  }
  
  JP.go.ipa.oz.lib.standard._String_if arg$0of19$whom;
  
  public void targetsSetLeaveTo (JP.go.ipa.oz.lib.standard._String_if whom) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 19;
      arg$0of19$whom = whom;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of19$whom = null;
      leave ();
    }
    join ();
  }
  
  
  public JP.go.ipa.oz.lib.standard._String_if targetsLeaveToWhom () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 20;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    return (JP.go.ipa.oz.lib.standard._String_if) join ();
  }
  
  JP.go.ipa.oz.user.cda._DeliveryFile_if arg$0of21$df;
  
  public boolean thisCopyOnRight (JP.go.ipa.oz.user.cda._DeliveryFile_if df) throws Exception {
    enter ();
    try {
      part = 2;
      selector = 21;
      arg$0of21$df = df;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      arg$0of21$df = null;
      leave ();
    }
    Boolean result = (Boolean) join ();
    return result.booleanValue ();
  }
  
  
  public void millorsPollingStart () throws Exception {
    enter ();
    try {
      part = 2;
      selector = 22;
      fork ();
    } catch (Exception e) {
      throw e;
    } finally {
      leave ();
    }
    join ();
  }
  
  public _ClassDeliveryAgent_pcl (JP.go.ipa.oz.lib.standard._String_if g, String c) throws Exception { super (g, c); }
  
  public _ClassDeliveryAgent_pcl (JP.go.ipa.oz.lib.standard._String_if g) throws Exception { super (g); }
  
  public _ClassDeliveryAgent_pcl () throws Exception { super (); }
  
  
}

