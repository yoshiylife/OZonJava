cell MaintenunceTool {

  String currentNSTGOL;

  NameServerTransaction currentNST;

  String singleNSTRGOL;

  NameServerTransactionResource singleNSTR;

  Path currentPath;

  String delimitor;

  bool single;

  protected void initialize(){
    System system=>create(); Array args=>create(16);
    args = system->getArguments();
    String s; s =| args->at(0);
    if(s->isequal("single")){
      singleNSTRGOL =| args->at(1);
      singleNSTR => bind(singleNSTRGOL);
      single = true;
    } else{
      currentNSTGOL =| args->at(1);
      currentNST => bind(currentNSTGOL);
      single = false;
    }
    currentPath => breed(":");
//    delimitor => breed(":");
    delimitor =| args->at(2);
  }

  protected void go(){
    System system=>create(); System debug=>create();
    Array args=>create(16); args = system->getArguments();
    String command; command =| args->at(0);
    system->println(command);

/*$B%+%l%s%H@_Dj(B*/

    //$B%+%l%s%H$N%M!<%`%5!<%P$r(Bnameservergol$B$KJQ$($k(B
    //currentNameServer nameservergol
    if(command->isequal("currentNameServer")){ 
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        currentNSTGOL =| args->at(1);
        currentNST => bind(currentNSTGOL);
        system->println(currentNSTGOL);
      }
    }

    //$B%+%l%s%H%Q%9$r(Bpath$B$KJQ$($k(B
    // currentPath path
    else if(command->isequal("currentPath")){
      String s; s =| args->at(1);
      String top = s->substring(0,1);
      if(top->isequal(delimitor)) currentPath => breed(s);
      else currentPath = currentPath->makeLowerPath(delimitor,s);
      system->println(currentPath->asString());
    }

/* debug print */

    // $B%+%l%s%H%M!<%`%5!<%P$NFbIt>uBV$rI=<($9$k!#(B
    // debugPrint
    else if(command->isequal("debugPrint")){
      if(single){
        singleNSTR->debugPrint();
      } else{
        currentNST->debugPrint();
      }
    }

    else if(command->isequal("debugPrintND")){
      NameDirectory nd;
      if(single){
        nd = singleNSTR->getDirectory(currentPath);
      } else{
        try{
          nd = currentNST->getDirectory(currentPath);
        } catch(Exception e){
          debug->println("here");
        }
      }
      bool tf = nd->debugPrint(currentPath);
      if( tf == false ){
        system->println("debugPrintND Security Exception.");
      }
    }

    // $B%M!<%`%5!<%S%9$NFbIt>uBV$rI=<($9$k!#(B
    // debugPrintSM
    else if(command->isequal("debugPrintSM")){
      SystemMapTransactionResource smtr => bind("smtr");
      smtr->debugPrint();
    }

    // $B8N>c4IM}$N%]!<%j%s%0%9%?!<%H(B
    else if(command->isequal("troubleControlStart")){
      SystemMapTransactionResource smtr => bind("smtr");
      smtr->troubleControlPollingStart();
    }

/*$B%V%i%s%A(B*/

    //path$B$G;XDj$5$l$?%G%#%l%/%H%j3,AX0J2<$N4IM}$r(B
    //toGOL(NameServerTransactionResource$B%;%k$G<($5$l$?%M!<%`%5!<%P$K(B
    //$B0\E>$9$k!#(B
    //path$B$O%+%l%s%H%M!<%`%5!<%P$N4IM}L>>N6u4VFb$G$J$1$l$P$$$1$J$$(B
    //moveBranch path toGOL
    else if(command->isequal("moveBranch")){
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        String s; s =| args->at(1); Path p => breed(s);
        String toGOL; toGOL =| args->at(2);
        try{
          currentNST->moveBranch(p,toGOL);
//        }catch(NameServiceSystemMapException ee){
//          system->println("  ERROR! nameserver not exist.");
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // putDirectoryAsBranch/2$B$O$J$7(B

    // $BL>A0(B dirname $B$N?75,%k!<%H%G%#%l%/%H%j$r:n$j!"(B
    // $B%V%i%s%A$H$7$F%+%l%s%H%M!<%`%5!<%P$KEPO?$9$k!#(B
    // putDirectoryAsRoot dirname
    else if(command->isequal("putDirectoryAsRoot")){
      String s; s =| args->at(1);
      s = delimitor->concat(s); Path p => breed(s);
      if(single){
//        debug->println(s);
        try{
          singleNSTR->putDirectoryAsBranch(p);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! not root path.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          currentNST->putDirectoryAsBranch(p);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! not root path.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // $B%+%l%s%H%M!<%`%5!<%P4IM}2<$K$"$k!"(Bpath$B$G<($5$l$?%V%i%s%A(B
    // $B%G%#%l%/%H%j$r%V%i%s%A$G$J$/$9$k!#(B
    // unBranched path
    else if(command->isequal("unBranched")){
      String s; s =| args->at(1); Path p => breed(s);
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        try{
          currentNST->unBranched(p);
        } catch(NameServerOwnerMapException ee){
          system->println("  ERROR! can not unbranched.");
        }
      }
    }

/*$B%^%C%T%s%0(B*/

    // serverGOL$B$OB>%M!<%`%5!<%S%9$KB0$9$k%M!<%`%5!<%P(B(NameServer
    // Transaction$B%;%k(B)$B$N(BGOL$B$G$"$k!#(B
    // path$B$K!"$=$N%M!<%`%5!<%S%9$NL>>N6u4V$N%Q%9(Bto$B$r%^%C%T%s%0$9$k!#(B
    // putDirectoryAsMapping path to serverGOL
    else if(command->isequal("putDirectoryAsMapping")){
      String s; s =| args->at(1); Path path => breed(s);
      s =| args->at(2); Path to => breed(s);
      String serverGOL; serverGOL =| args->at(3);
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        try{
          currentNST->putDirectoryAsMapping(path,to,serverGOL);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! mapping fail.");
        }
      }
    }

/*$B%M!<%`%5!<%P4IM}(B*/

    // $B%+%l%s%H%M!<%`%5!<%P$r%M!<%`%5!<%S%9$KEPO?$9$k(B
    // addNameServer
    else if(command->isequal("addNameServer")){
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        currentNST->addNameServer();
      }
    }

    // $B%+%l%s%H%M!<%`%5!<%P$r%M!<%`%5!<%S%9$+$i:o=|$9$k(B
    // removeNameServer
    else if(command->isequal("removeNameServer")){
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        currentNST->removeNameServer();
      }
    }

/*$B%G%#%l%/%H%j$NL>>N4IM}(B $B$H$$$&$h$j%(%s%H%j4IM}(B*/

    // $B%+%l%s%H%Q%9$N%G%#%l%/%H%j$K(B String $B%*%V%8%'%/%H$rL>A0(Bname$B$N(B
    // $B%(%s%H%j$H$7$FEPO?$9$k!#(B
    // putEntry name object
    else if(command->isequal("putEntry")){
      String s; s =| args->at(1); 
      Path p = currentPath->makeLowerPath(delimitor,s);
//      debug->println(p->asString());
      s =| args->at(2);
      if(single){
        try{
          singleNSTR->putEntry(p,s);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          currentNST->putEntry(p,s);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // $B;XDj$7$?L>>N(B($B%+%l%s%H%Q%9$+$i$NAjBP%Q%9(B)$B$,(B
    // $B%(%s%H%j$H$7$FL>>N6u4V$K4^$^$l$k$+D4$Y$k!#(B
    // containEntry path
    else if(command->isequal("containEntry")){
      String s; s =| args->at(1);
      Path p = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          bool tf = singleNSTR->containEntry(p);
          if(tf) system->println("  true");
          else system->println("  false");
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          bool tf = currentNST->containEntry(p);
          if(tf) system->println("  true");
          else system->println("  false");
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // getEntry $B$O%a%s%F%J%s%9%D!<%k$+$i$O;H$o$J$$(B
    // this is for debug. entry only string.
    else if(command->isequal("getEntry")){
      String s; s =| args->at(1);
      Path p = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          Root r = singleNSTR->getEntry(p);
          String s; s =| r; system->println(s);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          Root r = currentNST->getEntry(p);
          String s; s =| r; system->println(s);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // $B%+%l%s%H%Q%9$+$i$NAjBP%Q%9$G;XDj$5$l$?%*%V%8%'%/%H$NEPO?$rKu>C$9$k(B
    // removeEntry path
    else if(command->isequal("removeEntry")){
      String s; s =| args->at(1);
      Path p = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          Root r = singleNSTR->removeEntry(p);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          Root r = currentNST->removeEntry(p);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // source($B%+%l%s%H%Q%9$+$i$NAjBP%Q%9(B)$B$G;XDj$5$l$?(B
    // $B%*%V%8%'%/%H$NL>>N$r(Btarget($B%+%l%s%H%Q%9$+$i$NAjBP%Q%9(B)$B$K(B
    // $B%j%M!<%`$9$k(B
    // renameEntry source target
    else if(command->isequal("renameEntry")){
      String s; s =| args->at(1);
      Path source = currentPath->makeLowerPath(delimitor,s);
      s =| args->at(2);
      Path target = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          Root r = singleNSTR->renameEntry(source,target);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          Root r = currentNST->renameEntry(source,target);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // $B%+%l%s%H%G%#%l%/%H%j$NEPO?%(%s%H%j?t$r5a$a$k(B
    // EntrySize path
    else if(command->isequal("EntrySize")){
      if(single){
        try{
          int i = singleNSTR->EntrySize(currentPath);
          Integer I => breed(i); system->println(I->asString());
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          int i = currentNST->EntrySize(currentPath);
          Integer I => breed(i); system->println(I->asString());
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // EntrySet$B$O$J$7(B

/*$B%5%V%G%#%l%/%H%j$NL>>N4IM}(B*/

    // putDirectory/2 $B$O$J$7(B
    // this is for debug

    // $BL>A0(Bdirname$B$N?75,%5%V%G%#%l%/%H%j$r%+%l%s%H%G%#%l%/%H%j$KDI2C$9$k!#(B
    // putDirectory dirname
    else if(command->isequal("putDirectory")){
      String s; s =| args->at(1);
      Path p = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          singleNSTR->putDirectory(p);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          currentNST->putDirectory(p);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // $B;XDj$7$?L>>N(B($B%+%l%s%H%Q%9$+$i$NAjBP%Q%9(B)$B$,%G%#%l%/%H%j$H$7$F(B
    // $BL>>N6u4V$K4^$^$l$k$+D4$Y$k!#(B
    // containDirectory path
    else if(command->isequal("containDirectory")){
      String s; s =| args->at(1);
      Path p = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          bool tf = singleNSTR->containDirectory(p);
          if(tf) system->println("  true");
          else system->println("  false");
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      } else{
        try{
          bool tf = currentNST->containDirectory(p);
          if(tf) system->println("  true");
          else system->println("  false");
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }
      }
    }

    // getDirectory $B$O$J$7(B

    // $B%+%l%s%H%Q%9$+$i$NAjBP%Q%9$G;XDj$5$l$?%G%#%l%/%H%j$r:o=|$9$k!#(B
    // removeDirectory path
    else if(command->isequal("removeDirectory")){
      String s; s =| args->at(1);
      Path p = currentPath->makeLowerPath(delimitor,s);
      if(single){
        try{
          singleNSTR->removeDirectory(p);
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }catch(NameDirectoryNotEmptyException ee){
          system->println("  ERROR! directory not empty.");
        }catch(NameDirectoryBranchException ee){
          system->println("  ERROR! directory is branch.");
        }
      } else{
        try{
          currentNST->removeDirectory(p);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }catch(NameDirectoryNotEmptyException ee){
          system->println("  ERROR! directory not empty.");
        }catch(NameDirectoryBranchException ee){
          system->println("  ERROR! directory is branch.");
        }
      }
    }

    // $B%+%l%s%H%G%#%l%/%H%j2<$NL>A0$,(Bsource$B%G%#%l%/%H%j$KBP$7$F(B
    // $BL>A0$r(Btarget$B$KJQ99$9$k!#(B
    // renameDirectory sourcename targetname
    else if(command->isequal("renameDirectory")){
      String s; s =| args->at(1);
      Path source = currentPath->makeLowerPath(delimitor,s);
//      debug->println(source->asString());
      s =| args->at(2);
      Path target = currentPath->makeLowerPath(delimitor,s);
//      debug->println(target->asString());
      if(single){
        try{
          singleNSTR->renameDirectory(source,target);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }catch(NameDirectoryNotEmptyException ee){
          system->println("  ERROR! directory not empty.");
        }catch(NameDirectoryBranchException ee){
          system->println("  ERROR! directory is branch.");
        }
      } else{
        try{
          currentNST->renameDirectory(source,target);
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }catch(PathStringIllegularException ee){
          system->println("  ERROR! path String wrong.");
        }catch(NameDirectoryNotEmptyException ee){
          system->println("  ERROR! directory not empty.");
        }catch(NameDirectoryBranchException ee){
          system->println("  ERROR! directory is branch.");
        }
      }
    }

    // $B%+%l%s%H%G%#%l%/%H%j$NEPO?%G%#%l%/%H%j?t$r5a$a$k!#(B
    // DirectorySize
    else if(command->isequal("DirectorySize")){
      if(single){
        try{
          int i = singleNSTR->DirectorySize(currentPath);
          Integer I => breed(i); system->println(I->asString());
        }catch(NameServerOwnerMapException ee){
          system->println("  ERROR! out of name space.");
        }
      } else{
        try{
          int i = currentNST->DirectorySize(currentPath);
          Integer I => breed(i); system->println(I->asString());
        }catch(NameServiceSystemMapException ee){
          system->println("  ERROR! out of name space.");
        }
      }
    }

    else system->println("  ERROR! maintenunce tool not defined command");

    // DirectorySet$B$O$J$7(B

  }
  protected void quiet(){flushCell();}
}

