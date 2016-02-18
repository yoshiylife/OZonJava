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

/*カレント設定*/

    //カレントのネームサーバをnameservergolに変える
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

    //カレントパスをpathに変える
    // currentPath path
    else if(command->isequal("currentPath")){
      String s; s =| args->at(1);
      String top = s->substring(0,1);
      if(top->isequal(delimitor)) currentPath => breed(s);
      else currentPath = currentPath->makeLowerPath(delimitor,s);
      system->println(currentPath->asString());
    }

/* debug print */

    // カレントネームサーバの内部状態を表示する。
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

    // ネームサービスの内部状態を表示する。
    // debugPrintSM
    else if(command->isequal("debugPrintSM")){
      SystemMapTransactionResource smtr => bind("smtr");
      smtr->debugPrint();
    }

    // 故障管理のポーリングスタート
    else if(command->isequal("troubleControlStart")){
      SystemMapTransactionResource smtr => bind("smtr");
      smtr->troubleControlPollingStart();
    }

/*ブランチ*/

    //pathで指定されたディレクトリ階層以下の管理を
    //toGOL(NameServerTransactionResourceセルで示されたネームサーバに
    //移転する。
    //pathはカレントネームサーバの管理名称空間内でなければいけない
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

    // putDirectoryAsBranch/2はなし

    // 名前 dirname の新規ルートディレクトリを作り、
    // ブランチとしてカレントネームサーバに登録する。
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

    // カレントネームサーバ管理下にある、pathで示されたブランチ
    // ディレクトリをブランチでなくする。
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

/*マッピング*/

    // serverGOLは他ネームサービスに属するネームサーバ(NameServer
    // Transactionセル)のGOLである。
    // pathに、そのネームサービスの名称空間のパスtoをマッピングする。
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

/*ネームサーバ管理*/

    // カレントネームサーバをネームサービスに登録する
    // addNameServer
    else if(command->isequal("addNameServer")){
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        currentNST->addNameServer();
      }
    }

    // カレントネームサーバをネームサービスから削除する
    // removeNameServer
    else if(command->isequal("removeNameServer")){
      if(single){
        system->println("MaintenunceTool Error. now single name server mode");
      } else{
        currentNST->removeNameServer();
      }
    }

/*ディレクトリの名称管理 というよりエントリ管理*/

    // カレントパスのディレクトリに String オブジェクトを名前nameの
    // エントリとして登録する。
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

    // 指定した名称(カレントパスからの相対パス)が
    // エントリとして名称空間に含まれるか調べる。
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

    // getEntry はメンテナンスツールからは使わない
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

    // カレントパスからの相対パスで指定されたオブジェクトの登録を抹消する
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

    // source(カレントパスからの相対パス)で指定された
    // オブジェクトの名称をtarget(カレントパスからの相対パス)に
    // リネームする
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

    // カレントディレクトリの登録エントリ数を求める
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

    // EntrySetはなし

/*サブディレクトリの名称管理*/

    // putDirectory/2 はなし
    // this is for debug

    // 名前dirnameの新規サブディレクトリをカレントディレクトリに追加する。
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

    // 指定した名称(カレントパスからの相対パス)がディレクトリとして
    // 名称空間に含まれるか調べる。
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

    // getDirectory はなし

    // カレントパスからの相対パスで指定されたディレクトリを削除する。
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

    // カレントディレクトリ下の名前がsourceディレクトリに対して
    // 名前をtargetに変更する。
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

    // カレントディレクトリの登録ディレクトリ数を求める。
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

    // DirectorySetはなし

  }
  protected void quiet(){flushCell();}
}

