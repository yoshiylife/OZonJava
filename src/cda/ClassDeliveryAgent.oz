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

cell stopCDA {
  protected void initiallize() {}
  protected void quiet() { flushCell(); }
  protected void go() {
    CDAdebug debug=>create();
    debug->println("stopCDA go begin");
    ClassDeliveryAgent CDA => bind("cda");
    debug->println("stopCDA binded");
    CDA->stop();
    debug->println("stopCDA stopped");
    stopCell();
  }
}

cell ClassDeliveryAgent :* Stoppable{

  String host;
  int port;
  DeliveryFileCache cache;
  TargetCDAList targets;
  ServerSocketRunnable ssr;
  MillorTarget millors; /* as client */
  PollingRunnable polling;
  MillorTarget millorsS; /* as server */
  CopyOnRightRunnable copyOR;
  bool millorOn;
  String millorMode;

  public void stop(){
    CDAdebug debug=>create();
    debug->println("CDA stopCDA begin");
    ssr->close();
    debug->println("server socket closed");
    stopCell();
  }
  protected void initiallize() {}
  protected void quiet() {
    super->quiet();
    flushCell();
  }
  protected void go() {
    System system=>create();
    CDAdebug debug=>create();
    Array args=>create(16); args = system->getArguments();

    /* $B%-%c%C%7%e@8@.(B not in initialize */
    cache => create();

    /* $B8!:wJ}?K@8@.(B not in initialize */
    targets => create();

    /* $B%[%9%H$H%]!<%H$N@_Dj(B */
    host = CDAProperty->getHost();
    if(host==null){
      system->println("Error! -- host of oz.classloader.deliveryAgent.url in oz.properties. cda can not go.");
      stopCell();
    } else{
      port = CDAProperty->getPort();
      if(port==-1){
        system->println("Error! -- port of oz.classloader.deliveryAgent.url in oz.properties. cda can not go.");
        stopCell();
      } else{ 
//        debug->println(host);
//        Integer I => breed(port); debug->println(I->asString());

        /* url$B%U%!%$%k:n@.(B */
        /* executor095a$B$+$i(B oz.properties $B$N(B oz.classloader.deliveryAgent.url
        String ozHomeProperty => breed("/export/home0/gon/oz");
        String urlFileName =
          ozHomeProperty->concat("/objects/classDeliveryAgent/url");
        FileOutputStream fs; fs=>breed(urlFileName);
        String url => breed("ozclass://"); url = url->concat(host);
        url = url->concat(":"); url = url->concat(portString);
        url = url->concat("/");
        ByteArray urlByteArray = url->getBytes();
        fs->write(urlByteArray);
        fs->close(); */

        /* $B%5!<%P%=%1%C%H5/F0$7$F4F;k(B */
        ssr => create(port,cache,targets);
        Thread t => create(ssr);

        /* $B%_%i!<%/%i%$%"%s%H%5!<%P5/F0(B  */
        millors => create(true);
        millorsS => create(false);
        polling => create(millors, cache);
        Thread tMil => create(polling);
        debug->println("millor5");
        copyOR => create(millors, cache, false);
        debug->println("millor6");
        Thread tCop => create(copyOR);

        /* $B%W%m%Q%F%#%U%!%$%k$+$i=i4|@_Dj(B */
        setInitial();

        /* $B5/F0%a%C%;!<%8I=<((B */
        String mes;
        system->println("CDA start.");
        mes => breed("ozclass socket host is "); mes=mes->concat(host);
        system->println(mes);
        Integer Port => breed(port);
        mes => breed("ozclass socket port is ");
        mes=mes->concat(Port->asString());
        system->println(mes);

        /* $B%_%i!<%9%?!<%H(B */
        if(millorOn){
          if(millorMode->isequal("polling")){
            sleepThread(1000);
            millorsPollingStart();
            debug->println("polling milloring start");
	  } else {
            sleepThread(1000);
            millorsWriteStart();
            debug->println("WIV or COW milloring start");
          }
        }
      }
    }
  }

  /* cda$B$O(Bpolling$B$+(BCOW$B$+(BWIV$B$I$l$+$R$H$D$N%b!<%I(B */
  protected void setInitial(){
    millorOn = false;
    millorMode = "polling";
    String propVal;
    CDAdebug debug=>create();
    debug->println("setInitial start");

    propVal = CDAProperty->getProp("leaveTarget");
    if(propVal!=null){
      targetsSetLeaveTo(propVal);
      debug->println("leaveTarget---"); debug->println(propVal);
    }

    propVal = CDAProperty->getProp("target");
    if(propVal!=null){
      int delind; String carS, cdrS = propVal;
      while( (delind = cdrS->indexOf(",")) > 0){
        carS = cdrS->substring(0,delind);
        cdrS = cdrS->substring(delind+1);
        String nowTarget;
        nowTarget = carS->concat(":cda");
        targetsPut(nowTarget);
        debug->println("target---"); debug->println(carS);
      }
      String nowTarget;
      nowTarget = cdrS->concat(":cda");
      targetsPut(nowTarget);
      debug->println("target---"); debug->println(cdrS);
    }

    propVal = CDAProperty->getProp("millorMode");
    if(propVal!=null){
      debug->println("millorMode---"); debug->println(propVal);
      if(propVal->isequal("writeInValidate")){
	modeWriteInValid();
	millorMode = "WIV";
        debug->println("mode---WIV");
      } else if(propVal->isequal("copyOnWrite")){
        modeCopyOnWrite();
	millorMode = "COW";
        debug->println("mode---COW");
      }
    }

    propVal = CDAProperty->getProp("millorInterval");
    if(propVal!=null){
      int interval = AtoI->atoi(propVal);
      setInterval(interval);
      debug->println("millorInterval---"); debug->println(propVal);
    }

    propVal = CDAProperty->getProp("millorStart");
    if(propVal!=null){
      if(propVal->isequal("true")) millorOn = true;
      debug->println("millorStart---"); debug->println(propVal);
    }

    propVal = CDAProperty->getProp("millor");
    if(propVal!=null){
      int delind; String carS, cdrS = propVal;
      debug->println("millor---");
      while( (delind = cdrS->indexOf("&")) > 0){
        carS = cdrS->substring(0,delind);
        cdrS = cdrS->substring(delind+1);
	int delindIn; String caarS, cadrS; String nowMT;
        delindIn = carS->indexOf(",");
        caarS = carS->substring(0,delindIn);
        nowMT = caarS->concat(":cda");
        cadrS = carS->substring(delindIn+1);
        millorsAdd(nowMT);
        debug->println(nowMT);
        while( (delindIn = cadrS->indexOf(",")) > 0){
          caarS = cadrS->substring(0,delindIn);
          cadrS = cadrS->substring(delindIn+1);
          millorsAddTopPackageName(nowMT, caarS);
          debug->println(caarS);
	}
        caarS = cadrS;
        millorsAddTopPackageName(nowMT, caarS);
        debug->println(caarS);
      }
      carS = cdrS;
      int delindIn; String caarS, cadrS; String nowMT;
      delindIn = carS->indexOf(",");
      caarS = carS->substring(0,delindIn);
      nowMT = caarS->concat(":cda");
      cadrS = carS->substring(delindIn+1);
      millorsAdd(nowMT);
      debug->println(nowMT);
      while( (delindIn = cadrS->indexOf(",")) > 0){
        caarS = cadrS->substring(0,delindIn);
        cadrS = cadrS->substring(delindIn+1);
        millorsAddTopPackageName(nowMT, caarS);
        debug->println(caarS);
      }
      caarS = cadrS;
      millorsAddTopPackageName(nowMT, caarS);
      debug->println(caarS);
    }
  }

  /* 
    $BB>(BCDA$B$+$i(BcodePath$B$G<($5$l$?%/%i%9$N8!:wG[Aw$rA4LL0Q>y$5$l$F<B9T$9$k!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: codePath - $B8!:wG[Aw$9$k%/%i%9$N%3!<%I%Q%9(B
    Returns: $B$=$N%/%i%9$N%G%j%P%j%U%!%$%k(B
  */
  public DeliveryFile leaveToSearchAndDelivery(String codePath){
    DeliveryFile df = searchAndDelivery(codePath); /* first myself*/
    if( df != null ) return df;
    int RetryNum = 0;
    String targetCDAGOL;
    while( (targetCDAGOL = targets->next(RetryNum)) != null ){
      ClassDeliveryAgent targetCDA; targetCDA => bind(targetCDAGOL);
      df = targetCDA->searchAndDelivery(codePath); /* next others */
      if(df!=null) break;
      RetryNum++;
    }
    return df;
  }

  /* 
    $BB>(BCDA$B$+$iMW5a$5$l$?!"(BcodePath$B$G<($5$l$?%/%i%9$N8!:wG[Aw$r<B9T$9$k!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: codePath - $B8!:wG[Aw$9$k%/%i%9$N%3!<%I%Q%9(B
    Returns: $B$=$N%/%i%9$N%G%j%P%j%U%!%$%k(B
  */
  public DeliveryFile searchAndDelivery(String codePath){
    CDAdebug debug=>create();
    File f;
    try{
      f = LocalRepositoryManager->get(codePath);
/*
      if(f==null){
        debug->println("LocalRepositoryManager get return null");
        return null;
      }
*/
    } catch(ClassNotFoundException e){
        debug->println("LocalRepositoryManager can not find");
        return null;
    } catch(IOException e){
      debug->println("searchAndDelivery IO exception");
      return null;
    }
    int length; length =| f->length();
    Integer I => breed(length); debug->println(I->asString());
    FileInputStream fis => breed(f);
    ByteArray buffer => create(length);
    debug->println("begin buffer");
    if(fis->read(buffer) != length){
      debug->println("buffer fail");
      return null;
    }
    String fileName = f->getName();
    String topPackageName = getTopPackageName(codePath, fileName);
    if(topPackageName==null) return null;
    debug->println(topPackageName);
    DeliveryFile df => create(codePath,topPackageName,length,buffer);
    debug->println("end buffer");
    return df;
  }

  protected String getTopPackageName(String codePath, String fileName){
//    CDAdebug debug=>create();
    String name = fileName->substring(0,fileName->lastIndexOf("."));
//    debug->println(name);
    String topPackageName => breed(codePath);
    int ind;
    while( (ind = topPackageName->lastIndexOf(".")) > -1 ){
//      debug->println(topPackageName);
      String nameCand;
      nameCand = topPackageName->substring(1+ind);
//      debug->println(nameCand);
      if(nameCand->isequal(name)) return topPackageName;
      else topPackageName = topPackageName->substring(0,ind);
    }
    return null;
  }

  /* as server */
  /* 
    $B%]!<%j%s%0%_%i!<%b!<%I$K$*$$$F8F$P$l$k!#(B
    $B%_%i!<%5!<%P$H$7$F!"(BtopPackageName$B$G<($5$l$?%Q%C%1!<%8$,(Btime$B0J9_$KJQ99(B
    $B$r<u$1$F$$$k$N$J$i$=$l$r%G%j%P%j%U%!%$%k7A<0$GJV$9!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: topPackageName - $B%_%i!<BP>]$N%Q%C%1!<%8L>(B
                time - $B%_%i!<%/%i%$%"%s%HB&$G$N%_%i!<BP>]$N:G=*99?7;~9o(B
    Returns: $B%_%i!<BP>]$N%G%j%P%j%U%!%$%k(B
  */
  public DeliveryFile millor(String topPackageName, long time){
    CDAdebug debug => create();
    debug->println("millor server begin");
    debug->println(topPackageName);
    Long L => breed(time); debug->println(L->asString());
    File f = LocalRepositoryManager->get(topPackageName);
    if( (isSecurityOKasMillorClient()) && (isMillorOK(topPackageName)) ){
      long lastTime = f->lastModified();
      L => breed(lastTime); debug->println(L->asString());
      if(lastTime != time){
        DeliveryFile df = searchAndDelivery(topPackageName);
        if(df==null) return null;
        df->timeStamp(lastTime);
        debug->println("millor server end");
        return df;
      } else return null;
    } else return null;
  }


  /* as client */
  /* 
    $B%3%T!<%*%s%i%$%H%_%i!<%b!<%I$K$*$$$F8F$P$l$k!#(B
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"(Bdf$BCf$N%/%i%9%"!<%+%$%V%U%!%$%k$,:G?7$N$b$N(B
    $B$G$"$k$N$G$=$l$r%m!<%+%k$N(Bexecutor$B$XH?1G$5$;$k!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: df - $B%_%i!<BP>]$N%/%i%9%"!<%+%$%V%U%!%$%k$rCf?H$H$9$k(B
                     $B%G%j%P%j%U%!%$%k(B
    Returns: $BH?1G$,@.8y$7$?>l9g$O(Btrue$B!"$=$&$G$J$$>l9g$O(Bfalse
  */
  public bool thisCopyOnRight(DeliveryFile df){
    String topPackageName = df->getTopPackageName();
    if( (isSecurityOKasMillorServer()) && (isMillorOK(topPackageName)) ){
      try{
        LocalRepositoryManager->remove(topPackageName); /* crit */
        cache->put(topPackageName,df);
      }catch(IOException e){
        return false;
      }catch(SecurityException e){
        return false;
      }
      return true;
    } else{
      return false;
    }
  }

  /* 
    $B%i%$%H%$%s%P%j%G!<%H%_%i!<%b!<%I$K$*$$$F8F$P$l$k!#(B
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"(Bdf$BCf$N%/%i%9%"!<%+%$%V%U%!%$%k$,:G?7$N$b$N(B
    $B$G$"$k$N$G$=$N$3$H$r%m!<%+%k$N(Bexecutor$B$KDLCN$9$k(B($BB(:B$KH?1G$O$7$J$$(B)$B!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: df - $B%_%i!<BP>]$N%/%i%9%"!<%+%$%V%U%!%$%k$rCf?H$H$9$k(B
                     $B%G%j%P%j%U%!%$%k(B
    Returns: $BDLCN$,@.8y$7$?>l9g$O(Btrue$B!"$=$&$G$J$$>l9g$O(Bfalse
  */
  public bool thisWriteInValid(DeliveryFile df){
    String topPackageName = df->getTopPackageName();
    if( (isSecurityOKasMillorServer()) && (isMillorOK(topPackageName)) ){
      try{
        LocalRepositoryManager->remove(topPackageName); /* crit */
      }catch(IOException e){
        return false;
      }catch(SecurityException e){
        return false;
      }
      return true;
    } else{
      return false;
    }
  }

  /* for maintenunce */

  /* 
    $B%/%i%9G[Aw%/%i%$%"%s%H$H$7$F!"%/%i%9$N8!:wG[Aw$NB>$N(BCDA$B$X$NA4LL0Q>y>u67(B
    $B$rJV$9!#(B
    Returns: $BA4LL0Q>y$7$F$$$k$N$J$i0Q>yAj<j$N(BCDA$B$N(BGOL$B!"$7$F$$$J$$$N$J$i(Bnull
  */
  public String targetsLeaveToWhom(){
    return targets->leaveToWhom();
  }

  /* 
    $B%/%i%9G[Aw%/%i%$%"%s%H$H$7$F!"%/%i%9$N8!:wG[Aw$NB>$N(BCDA$B$X$NA4LL0Q>y(B
    $B$r@_Dj$9$k!#(B
    whom $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
    Parametors: whom - $B0Q>yAj<j$N(BCDA$B$N(BGOL
  */
  public void targetsSetLeaveTo(String whom){
    targets->setLeaveTo(whom);
  }

  /* 
    $B%/%i%9G[Aw%/%i%$%"%s%H$H$7$F!"8!:wJ}?K$rI=<($9$k!#(B
    Returns: $B8!:wJ}?K(B($B8!:w=g$K$J$i$Y$?(BCDA$B$N(BGOL)
  */
  public Array targetsTargets(){
    return targets->targets();
  }

  /* 
    $B%/%i%9G[Aw%/%i%$%"%s%H$H$7$F!"(BGOL$B$,(Btarget$B$N(BCDA$B$r8!:wJ}?K$NKvHx$KEPO?$9$k!#(B
    target $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
    Parametors: whom - CDA$B$N(BGOL
    Returns: $B8!:wJ}?K$N%5%$%:(B($B2?8D$N(BCDA$B$,8!:wJ}?K$H$7$FEPO?$5$l$F$$$k$+(B)
  */
  public int targetsPut(String target){
    return targets->put(target);
  }

  /* 
    $B%/%i%9G[Aw%/%i%$%"%s%H$H$7$F(BGOL$B$,(Btarget$B$N(BCDA$B$r8!:wJ}?K$N(Bat$BHVL\$KEPO?$9$k!#(B
    target $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
    at $B$,(B 0$B$h$j>.$5$$>l9g$O2?$b$7$J$$!#(B
    at$B$,8!:wJ}?K$N%5%$%:$h$jBg$-$$>l9g$O$=$NKvHx$KEPO?$9$k!#(B
    Parametors: whom - CDA$B$N(BGOL
                at - $B8!:wJ}?K$N2?HVL\$KEPO?$9$k$+(B
    Returns: $B8!:wJ}?K$N%5%$%:(B($B2?8D$N(BCDA$B$,8!:wJ}?K$H$7$FEPO?$5$l$F$$$k$+(B)
  */
  public int targetsPutAt(int at, String target){
    return targets->putAt(at,target);
  }


  /* 
    $B%/%i%9G[Aw%/%i%$%"%s%H$H$7$F!"(BGOL$B$,(Btarget$B$N(BCDA$B$r8!:wJ}?K$+$i:o=|$9$k!#(B
    target $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
  */
  public void targetsRemove(String target){
    targets->remove(target);
  }

  /* 
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"(BGOL$B$,(Btarget$B$N(BCDA$B$r%_%i!<%5!<%P$H$7$FEPO?$9$k!#(B
    $B$^$?$O!"%_%i!<%5!<%P$H$7$F!"(BGOL$B$,(Btarget$B$N(BCDA$B$r%_%i!<%/%i%$%"%s%H$H$7$F(B
    $BEPO?$9$k!#(B
    target $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
    Parametors: target - CDA$B$N(BGOL
  */
  public void millorsAdd(String target){
    millors->add(target);
  }

  /* 
    $B%]!<%j%s%0%_%i!<%b!<%I$K$*$$$F8F$P$l$k>l9g$O!"(B
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"(BGOL$B$,(Btarget$B$N%_%i!<%5!<%P$KBP$7$F!"(B
    $B%H%C%W%Q%C%1!<%8%M!<%`$,(Bname$B$N%/%i%9%"!<%+%$%V%U%!%$%k$N%_%i!<%5!<%S%9(B
    $B$rMW5a$9$k!#(B
    $B%3%T!<%*%s%i%$%H%_%i!<%b!<%I$d%i%$%H%$%s%P%j%G!<%H%_%i!<%b!<%I$K$*$$$F(B
    $B8F$P$l$k>l9g$O!"%_%i!<%5!<%P$H$7$F!"(BGOL$B$,(Btarget$B$N%_%i!<%/%i%$%"%s%H$K(B
    $BBP$7$F!"%H%C%W%Q%C%1!<%8%M!<%`$,(Bname$B$N%/%i%9%"!<%+%$%V%U%!%$%k$N%_%i!<(B
    $B%5!<%S%9$r9T$&!#(B
    target $B$+(B name $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
    target $B$,(BmillorsAdd$B%a%=%C%I$K$h$C$FEPO?$5$l$F$$$k$b$N$G$J$$;~$O2?$b$7$J$$!#(B
    Parametors: target - $B%_%i!<Aj<j$N(BGOL
                name - $B%_%i!<%5!<%S%9BP>]$H$J$k%/%i%9%"!<%+%$%V%U%!%$%k$N(B
                       $B%H%C%W%Q%C%1!<%8%M!<%`(B
  */
  public void millorsAddTopPackageName(String target, String name){
    millors->addTopPackageName(target, name);
  }

  /* 
    $B%]!<%j%s%0%_%i!<%b!<%I$K$*$$$F8F$P$l$k>l9g$O!"(B
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"(BGOL$B$,(Btarget$B$N%_%i!<%5!<%P$KBP$7$F!"(B
    $B%H%C%W%Q%C%1!<%8%M!<%`$,(Bname$B$N%/%i%9%"!<%+%$%V%U%!%$%k$N%_%i!<%5!<%S%9(B
    $B$NMW5a$r<h$j>C$9!#(B
    $B%3%T!<%*%s%i%$%H%_%i!<%b!<%I$d%i%$%H%$%s%P%j%G!<%H%_%i!<%b!<%I$K$*$$$F(B
    $B8F$P$l$k>l9g$O!"%_%i!<%5!<%P$H$7$F!"(BGOL$B$,(Btarget$B$N%_%i!<%/%i%$%"%s%H$K(B
    $BBP$7$F!"%H%C%W%Q%C%1!<%8%M!<%`$,(Bname$B$N%/%i%9%"!<%+%$%V%U%!%$%k$N%_%i!<(B
    $B%5!<%S%9$r9T$o$J$$$h$&$K$9$k!#(B
    target $B$+(B name $B$,(B null $B$N>l9g$O2?$b$7$J$$!#(B
    target $B$,(BmillorsAdd$B%a%=%C%I$K$h$C$FEPO?$5$l$F$$$k$b$N$G$J$$;~$O2?$b$7$J$$!#(B
    Parametors: target - $B%_%i!<Aj<j$N(BGOL
                name - $B%_%i!<%5!<%S%9BP>]$H$J$k%/%i%9%"!<%+%$%V%U%!%$%k$N(B
                       $B%H%C%W%Q%C%1!<%8%M!<%`(B
  */
  public void millorsRemoveTopPackageName(String target, String name){
    millors->removeTopPackageName(target, name);
  }

  /* 
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"(BGOL$B$,(Btarget$B$N%_%i!<%5!<%P$KBP$7$F(B
    $B%_%i!<%5!<%S%9$rMW5a$7$F$$$k%/%i%9%"!<%+%$%V%U%!%$%k$,$"$k$,!"(B
    $B$=$N%H%C%W%Q%C%1!<%8%M!<%`$H%_%i!<%/%i%$%"%s%HB&$K$*$1$k:G=*99?7;~9o$N(B
    $BBP$rJV$9!#(B
    $B$^$?$O!"%_%i!<%5!<%P$H$7$F!"(BGOL$B$,(Btarget$B$N%_%i!<%/%i%$%"%s%H$KBP$7$F(B
    $B%_%i!<%5!<%S%9$r9T$C$F$$$k%/%i%9%"!<%+%$%V%U%!%$%k$,$"$k$,!"(B
    $B$=$N%H%C%W%Q%C%1!<%8%M!<%`$H%_%i!<%5!<%PB&$K$*$1$k:G=*99?7;~9o$N(B
    $BBP$r(BDictionary$B7A<0$GJV$9!#(B
    Parametors: target - CDA$B$N(BGOL
    Returns: $B$=$N%H%C%W%Q%C%1!<%8%M!<%`$H%_%i!<%/%i%$%"%s%HB&$K$*$1$k(B
             $B:G=*99?7;~9o$NBP$r(Bassociation$B$H$9$k(BDeictionary
  */
  public Dictionary millorsGet(String target){
    return millors->get(target);
  }

  /* 
    $B%]!<%j%s%0%_%i!<%b!<%I$N;~$K8F$P$l$k%a%=%C%I$G$"$k!#(B
    $B%_%i!<%/%i%$%"%s%H$H$7$F!"%]!<%j%s%0$r%9%?!<%H$9$k!#(B
  */
  public void millorsPollingStart(){
//    CDAdebug debug=>create(); debug->println("millorsPollingStart()");
    polling->pollingStart();
  }

  /*
    $B%_%i!<%5!<%P$H$7$F!"%_%i!<%b!<%I$r%i%$%H%$%s%P%j%G!<%H$K$9$k!#(B
  */
  public void modeWriteInValid(){
    copyOR->modeWIV();
  }

  /*
    $B%_%i!<%5!<%P$H$7$F!"%_%i!<%b!<%I$r%3%T!<%*%s%i%$%H$K$9$k!#(B
  */
  public void modeCopyOnWrite(){
    copyOR->modeCOW();
  }

  /* 
    $B%3%T!<%*%s%i%$%H%_%i!<%b!<%I$N;~$K8F$P$l$k%a%=%C%I$G$"$k!#(B
    $B%_%i!<%5!<%P$H$7$F!"%3%T!<%*%s%i%$%H$K$h$k%_%i!<%j%s%0$r%9%?!<%H$9$k!#(B
    $B$"$k$$$O!"%i%$%H%$%s%P%j%G!<%H%_%i!<%b!<%I$N;~$K8F$P$l$k%a%=%C%I$G$"$k!#(B
    $B%_%i!<%5!<%P$H$7$F!"%i%$%H%$%s%P%j%G!<%H$K$h$k%_%i!<%j%s%0$r%9%?!<%H$9$k!#(B
  */
  public void millorsWriteStart(){
    copyOR->copyStart();
  }

  /*
    $B%_%i!<%j%s%0$N4V3V$r;XDj$9$k!#(B
    paramator: interval -  $B%_%i!<%j%s%0$N4V3V(B(msec)
  */
  public void setInterval(int interval){
    copyOR->setInterval(interval);
    polling->setInterval(interval);
  }

  /* after security manager */

  protected bool isSecurityOKasMillorClient(){ return true; }
  protected bool isSecurityOKasMillorServer(){ return true; }
  protected bool isMillorOK(String topPackageName){ return true; }

  /* for ClassProperty/ClassFile */
  /* 
    codePath $B$G<($5$l$?%/%i%9$N(B name $B$G<($5$l$?%/%i%9%W%m%Q%F%#$r(B
    $B%m!<%+%k$KC5:w$7$FJV$9!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: codePath - $B%/%i%9$N%3!<%I%Q%9(B
                name - $B%/%i%9%W%m%Q%F%#$NAjBP%U%!%$%kL>(B
    Returns: $B%/%i%9%W%m%Q%F%#%U%!%$%k(B
  */
  public ClassProperty getClassProperty(String codePath,String name){
//    CDAdebug debug => create();
//    debug->println("getClassProperty begin");
    ClassProperty cp => create(codePath,name);
//    debug->println("getClassProperty end");
    return cp;
  }

  /* 
    codePath $B$G<($5$l$?%/%i%9%U%!%$%k$r%m!<%+%k$KC5:w$7$FJV$9!#(B
    $B$3$N%a%=%C%I$r%f!<%6$,8F$V$3$H$O$J$$!#(B
    Parametors: codePath - $B%/%i%9%U%!%$%k$N%3!<%I%Q%9(B
    Returns: $B%/%i%9%U%!%$%k(B
  */
  public ClassFile getClassFile(String codePath){
//    CDAdebug debug => create();
//    debug->println("getClassFile begin");
    ClassFile cf => create(codePath);
//    debug->println("getClassFile end");
    return cf;
  }

}

class DeliveryFileCache {

  Dictionary defi; /* topPackageName -- deliveryFile */

  new create(){
    StringComparator sc => create();
    defi => create(sc);
  }

/*
  public bool already(String codePath){
    return defi->containsKey(codePath);
  }

  public DeliveryFile get(String codePath){
    DeliveryFile df; df =| defi->get(codePath);
    return df;
  }

  public locked void put(String codePath, DeliveryFile df){
    defi = defi->put(codePath,df);
  }
*/

  public locked DeliveryFile get(String codePath){
    DeliveryFile df = null;
    Iterator ite = defi->keyIterator();
    int size = defi->size();
    String topPackageName;
    for(int i=0; i<size; i++){
      topPackageName =| ite->nextElement();
      if(below(topPackageName,codePath)){
        df =| defi->get(topPackageName);
        break;
      }
    }
    return df;
  }

  protected bool below(String topPackageName, String codePath){
//    CDAdebug debug => create();
//    debug->println("in below");
//    debug->println(topPackageName);
//    debug->println(codePath);
//    if(topPackageName->lastIndexOf(codePath) > -1) return true;
    if(codePath->lastIndexOf(topPackageName) > -1) return true;
    else{
//      debug->println("below false");
      return false;
    }
  }

  public locked void put(String topPackageName, DeliveryFile df){
    defi = defi->put(topPackageName,df);
  }
}

class TargetCDAList {

  Array targetList;
  int targetListSize;
  String leaveTo;

  new create(){
    StringComparator sc => create();
    targetList => create(256,sc);
    targetListSize = 0;
    leaveTo = null;
    setDefaults();
  }

  public locked void setDefaults(){}

  public locked String leaveToWhom(){
    return leaveTo;
  }

  public locked void setLeaveTo(String s){
    if(s!=null){
      leaveTo = s;
    }
  }

  public locked Array targets(){
    return targetList;
  }

  public locked int targetsSize(){
    return targetListSize;
  }

  public locked String next(int RetryNum){
//    CDAdebug debug=>create(); debug->println("target next");
//    Integer I => breed(targetListSize); debug->println(I->asString());
//    I => breed(RetryNum); debug->println(I->asString());
    if(leaveTo!=null) return null;
    if(RetryNum>=targetListSize){
//      debug->println("RetryNum>=targetListSize");
      return null;
    } else{ String s; s =| targetList->at(RetryNum); return s;}
  }

  public int put(String target){
    return putAt(targetListSize, target);
  }

  public locked int putAt(int at, String target){
    if(target == null) return targetListSize;
    if(at>=targetListSize) {
      targetList = targetList->putAt(targetListSize,target);
      targetListSize = targetListSize+1;
    } else if(at>=0){
      targetList = targetList->putAt(at,target);
    }
    return targetListSize;
    /* else targetList = targetList->putAt(0,target); */
  }

  public locked void remove(String target){
    if(target != null){
      int ind = targetList->indexOf(target);
      if(ind>-1){
        for(int i=ind; i< targetListSize-1; i++){
          String s;
          s =| targetList->at(i+1);
          targetList = targetList->putAt(i,s);
        }
        targetList = targetList->putAt(targetListSize-1,null);
        targetListSize = targetListSize-1;
      }
    }
  }

}

class MillorTarget{/* millorServer/ClientCDAGOL -- (topPackageName -- time) */

  Dictionary GOLtoTimes;
  bool isClient;

  new create(bool isC){
    StringComparator sc => create();
    GOLtoTimes => create(sc);
    isClient = isC;
    setDefaults();
  }

  public locked void setDefaults(){}

  public locked bool isClient(){ return isClient; }

  public locked void add(String millorCDAGOL){
    if(millorCDAGOL != null){
      StringComparator sc => create();
      Dictionary times => create(sc);
      GOLtoTimes = GOLtoTimes->put(millorCDAGOL,times);
    }
  }

  public locked void addTopPackageName(String GOL, String Name){
    if( (GOL != null) && (Name != null) ){
      Dictionary times; times =| GOLtoTimes->get(GOL);
      Long L => breed(-1);
      if(times != null){
        times = times->put(Name,L);
        GOLtoTimes = GOLtoTimes->put(GOL,times);
     }
    }
  }

  public locked void removeTopPackageName(String GOL, String Name){
    if( (GOL != null) && (Name != null) ){
      Dictionary times; times =| GOLtoTimes->get(GOL);
      Long L => breed(-1);
      if(times != null){
        times = times->remove(Name);
        GOLtoTimes = GOLtoTimes->put(GOL,times);
      }
    }
  }

  public locked void setTime(String GOL, String Name, long time){
    Dictionary times; times =| GOLtoTimes->get(GOL);
    Long L => breed(time);
    times = times->put(Name,L);
    GOLtoTimes = GOLtoTimes->put(GOL,times);
  }

  public locked void versionupTopPackage(String GOL, String Name, long time){
    Dictionary times; times =| GOLtoTimes->get(GOL);
    Long L => breed(time);
    times = times->put(Name,L);
    GOLtoTimes = GOLtoTimes->put(GOL,times);
  }

  public locked Dictionary get(String GOL){
    Dictionary times; times =| GOLtoTimes->get(GOL); 
    return times;
  }

  public locked Set getTargetGOLs(){
    return GOLtoTimes->keys();
  }

}