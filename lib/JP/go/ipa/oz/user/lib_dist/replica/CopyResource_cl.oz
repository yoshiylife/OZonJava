/**********************************************************
* CopyScheme.oz
*   複製ライブラリ共通処理
**********************************************************/
cell CopyScheme : *TransactionResource {

  protected OtherCopyManeger cpManeger; // コピー マネージャ
  protected bool mgrFlag;       // コピー マネージャ フラグ
  protected String cpmGol;      // コピー マネージャ GOL
  protected bool status;        //コピーの生存が確認できない場合false
  protected Set otherCopies;    //複製のリスト
  protected Set crushedCopies;  //故障した複製のリスト
  protected int idnum;	        // ＩＤカウンタ
  protected int MAX_ID;         // ＩＤ最大値
  protected String ownGOL;
  int timeOut;                  //RMIのタイムアウト
  TID tid;
  protected Debug debug;
  protected int debugFlag;      //if 1 debug on

  /**********************************************************
  * 書式：  protected void initialize()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  初期化処理
  **********************************************************/
  protected void initialize(){

    // TransactionResource:initialize()を呼ぶ
    d=>create();x=0;d->setP(" p:"); //for debug
    ownGOL=>breed("");
    ownGOL = ownGOL->getGOL();      // カレントGOL
    super->initialize("tmp0", "tmp1", "tmp2", ownGOL);

    // TID をセット
    idnum = 1;
    tid=>create();
    tid->set(idnum, ownGOL);

    // 必要な変数を初期化
    CopyRes_Comparator pc=>create();
    otherCopies=>create(pc);
    crushedCopies=>create();
    cpmGol=>breed("");      // セカンダリコピー マネージャ GOL
    mgrFlag = false;
    status = true;
    timeOut = 10000;        // タイムアウトのデフォルト値
    MAX_ID = 10000;         // IDの最大値
  }

  protected void go(){;}                            //main処理
  protected void quiet(){flushCell();}   //終了処理

  /**********************************************************
  * 書式：  public final void setCpmGol(String gol)
  * 引数：  String gol  コピーマネージャを作成する GOL
  * 戻り値：なし
  * 処理：  コピーマネージャを作成する GOLを設定
  **********************************************************/
  public final void setCpmGol(String gol){
    cpmGol = gol;
  }

  /**********************************************************
  * 書式：  public final void setCpManeger()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  コピーマネージャを作る
  **********************************************************/
  public final void setCpManeger(){
    mgrFlag = true;
    cpManeger=>create(cpmGol);
    cpManeger=>bind(cpmGol);
    cpManeger->setResourceTimeOut(timeOut);
  }

  /**********************************************************
  * 書式：  public final bool removeCopyOf(String delGol)
  * 引数：  String delGol	削除する複製の GOL
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  GOLで指定される複製を削除する
  **********************************************************/
  public final bool removeCopyOf(String delGol){

    // otherCopiesリストから golの複製を削除する。
    CopyResource cpResource;
    String gol;
    bool rc = false;

    Iterator iterator = otherCopies->iterator();
    for( int i=0; iterator->hasMoreElements(); i++) {
      cpResource =| iterator->nextElement();
      gol = cpResource->getGol();
      if( delGol->compareTo(gol) == 0 ) {
        otherCopies =| otherCopies->remove(cpResource);
        rc = true;
        break;
      }
    }
    return rc;
  }

  /**********************************************************
  * 書式：  public final void setTimeOut(int time)
  * 引数：  int time    タイムアウト値
  * 戻り値：なし
  * 処理：  タイムアウトの設定
  **********************************************************/
  public final void setTimeOut(int time){
    timeOut = time;

    // Transaction Timeoutをセットする
    cpManeger->setResourceTimeOut(timeOut);
  }

  /**********************************************************
  * 書式：  public final int getTimeOut()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  タイムアウト値の取得
  **********************************************************/
  public final int getTimeOut(){
    return timeOut;
  }

  /**********************************************************
  * 書式：  public final void setResourceTimeLimit(int time)
  * 引数：  int time    タイムアウト値
  * 戻り値：なし
  * 処理：  TransactionResource の LockingTimeLimitをセット
  **********************************************************/
  public final void setResourceTimeLimit(int time){
    super->setLockingTimeLimit(time);
  }

  /**********************************************************
  * 書式：  public final bool lock()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  複製対象セルをロック
  **********************************************************/
  public final bool lock(){
    bool rc = true;

    // TransactionResourceの lock(TID)を呼ぶ
    try {
      super->lock(tid);
    }
    catch (Exception e){
      debug->write(debugFlag, "Error in lock()");
      rc = false;
    }
    return rc;
  }

  /**********************************************************
  * 書式：  public bool lockAll()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  全ての複製対象セルをロック
  **********************************************************/
  public bool lockAll(){
    Array golArray;
    CopyResource cpResource;
    String gol;
    Iterator iterator;
    int i;
    bool rc = true;

    // lock()に渡す配列を作成する
    golArray=>create(otherCopies->size());
    iterator = otherCopies->iterator();
    for( i=0; iterator->hasMoreElements(); i++) {
      cpResource =| iterator->nextElement();
      gol = cpResource->getGol();
      golArray->putAt(i, gol);
    }

    try {
      // Transactionの lock()を呼ぶ
      cpManeger->lock(golArray);
    }
    catch (Exception e){
      debug->write(debugFlag, "Error in lockAll()");
      rc = false;
    }
    return rc;
  }

  /**********************************************************
  * 書式：  public final bool propagate()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  変更を複製に反映
  **********************************************************/
  public final bool propagate(){
    bool rc = true;

    try {
      super->lock(tid);
      update(ownGOL);
      if ( isReadyToCommit(tid) == true ) {
        super->commit(tid);
      }
      super->unlock(tid);
    }
    catch (Exception e){
      debug->write(debugFlag, "Error in propagete()");
      rc = false;
    }
    return rc;
  }

  /**********************************************************
  * 書式：  public bool propagateAllCP(int type)
  * 引数：  int type	3:プライマリコピーの update()
  *			4:ピアコピーの update()
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  変更を全ての複製に反映
  **********************************************************/
  public bool propagateAllCP(int type){
//    debug->write(debugFlag, "CopyScheme:PropagateAll() in");
    CopyResource cpResource;
    CopyScheme copy;
    Iterator iterator;
    bool errFlag, crushFlag;
    bool rc = true;

    errFlag = false;
    Timer t=>create();
    CopyFoo obj=>create();
    CopyMethodRunnable mmr=>create(t);
    try {
      // タイマをかけて、lockAll()を呼ぶ
      mmr->set(obj,this, 2, null);
      t->invoke(mmr, timeOut);
      debug->write(debugFlag, "lockAll() O.K.");
    }
    catch (TimeOutException e){
      debug->write(debugFlag, "lockAll() Time Out!");
      errFlag = true;
      status = false;
    }
    catch (Exception e){
      errFlag = true;
      status = false;
    }

    if ( errFlag == false ) {
      try {
        iterator = otherCopies->iterator();
        while( iterator->hasMoreElements() ) {
          cpResource =| iterator->nextElement();
          copy = cpResource->getCopy();
          // タイマをかけて、update()を呼ぶ
          if ( type == 3 )
            mmr->set(obj,copy, 3, ownGOL);  // for primary copy
          else
            mmr->set(obj,copy, 4, null);    // for peer copy
          t->invoke(mmr, timeOut);
          debug->write(debugFlag, "update() O.K.");
        }
      }
      catch (TimeOutException e){
        debug->write(debugFlag, "update() Time Out!");
        errFlag = true;
        status = false;
      }
      catch (Exception e){
        errFlag = true;
        status = false;
      }
    }

    try {
      // タイマをかけて、commitAll()を呼ぶ
      mmr->set(obj,this, 6, null);
      t->invoke(mmr, timeOut);
      debug->write(debugFlag, "commitAll() O.K.");
    }
    catch (TimeOutException e){
      debug->write(debugFlag, "commitAll() Time Out!");
    }
    catch (Exception e){
    }

    if ( errFlag ) {
      // エラーが出たら１つずつ処理
      crushFlag = false;
      iterator = otherCopies->iterator();
      while( iterator->hasMoreElements() ) {
        cpResource =| iterator->nextElement();
        copy = cpResource->getCopy();
        rc = true;
        try {
          // タイマをかけて、lock()を呼ぶ
          mmr->set(obj,copy, 1, null);
          t->invoke(mmr, timeOut);
          debug->write(debugFlag, "lock() O.K.");
        }
        catch (TimeOutException e){
          rc = false;
          debug->write(debugFlag, "lock() Time Out!");
        }
        catch (Exception e){
          rc = false;
        }
        if ( rc == true ) {
          try {
            // タイマをかけて、update()を呼ぶ
            if ( type == 3 )
              mmr->set(obj,copy, 3, ownGOL);    // for primary copy
            else
              mmr->set(obj,copy, 4, null);      // for peer copy
            t->invoke(mmr, timeOut);
            debug->write(debugFlag, "update() O.K.");
          }
          catch (TimeOutException e){
            rc = false;
            debug->write(debugFlag, "update() Time Out!");
          }
          catch (Exception e){
            rc = false;
          }
        }
        if ( rc == true ) {
          try {
            // タイマをかけて、commit()を呼ぶ
            mmr->set(obj,copy, 5, null);
            t->invoke(mmr, timeOut);
            debug->write(debugFlag, "commit() O.K.");
          }
          catch (TimeOutException e){
            debug->write(debugFlag, "commit() Time Out!");
            rc = false;
          }
          catch (Exception e){
            rc = false;
          }
        }
        if ( rc == false ){
          // 故障を確認した時刻をセット
          cpResource->setDate();
          // 故障した複製のリストに追加
          crushedCopies->add(cpResource);
          crushFlag = true;
          // 故障した複製を表示
          printCrushedCopy(cpResource->getGol());
        }
      }
      // otherCopiesから消す
      if ( crushFlag ){
        iterator = crushedCopies->iterator();
        while( iterator->hasMoreElements() ) {
          cpResource =| iterator->nextElement();
          otherCopies =| otherCopies->remove(cpResource);
        }
      }
    }
//    debug->write(debugFlag, "CopyScheme:PropagateAll() out");
    return rc;
  }

  /**********************************************************
  * 書式：  public final bool commit()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  変更を確定
  **********************************************************/
  public final bool commit(){
    bool rc = true;

    // TransactionResourceの commit(TID)を呼ぶ
    try {
      if ( isReadyToCommit(tid) == true )
        super->commit(tid);
      super->unlock(tid);
    }
    catch (Exception e){
      debug->write(debugFlag, "Error in commit()");
      rc = false;
    }
    return rc;
  }

  /**********************************************************
  * 書式：  public bool commitAll()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  全ての変更を確定
  **********************************************************/
  public bool commitAll(){
    // Transactionの commit()を呼ぶ
    cpManeger->commit();
    return true;
  }

  /**********************************************************
  * 書式：  public void update()
  * 処理：  何もしない。サブセルの update()に処理をパスする
  **********************************************************/
  public void update(){}
  public void update(String gol){}

  /**********************************************************
  * 書式：  public final CopyScheme getClientStubCP()
  * 引数：  なし
  * 戻り値：最も処理（isLive()呼び出し）の速い複製
  * 処理：  クライアントスタブを得る
  **********************************************************/
  public final CopyScheme getClientStubCP(){
    long cTime, minTime;
    Long lTime;
    CopyScheme copy, minCopy;
    CopyResource cpResource;
    Iterator iterator;
    String stime=>breed("");

    Timer t=>create();
    CopyFoo obj=>create();
    CopyMethodRunnable mmr=>create(t);
    minTime = timeOut;

    // 全てのコピーを取り出す
    iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpResource =| iterator->nextElement();
      copy = cpResource->getCopy();
      debug->write(debugFlag, cpResource->getGol());

      // タイマをかけて、isLive()を呼ぶ
      mmr->set(obj,copy, 7, null);
      try{
        lTime =| t->invoke(mmr, timeOut);
        cTime = lTime->longValue();
        stime = lTime->asString();
        debug->write(debugFlag, "isLive() time is ", stime);
        // 一番処理時間の短いものをとっておく
        if ( cTime < minTime ) {
          minTime = cTime;
          minCopy = copy;
        }
      }
      catch (TimeOutException e){
        debug->write(debugFlag, "isLive() Time Out!");
      }
      catch (Exception e){
      }
    }

    lTime=>breed(minTime);
    stime = lTime->asString();
    debug->write(debugFlag, "minimam time is ", stime);
    return minCopy;
  }

  /**********************************************************
  * 書式：  public final bool isLive()
  * 引数：  なし
  * 戻り値：常に true
  * 処理：  生存確認
  **********************************************************/
  public final bool isLive(){
    return true;
  }

  /**********************************************************
  * 書式：  public final void printCrushList()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  故障リスト一覧
  **********************************************************/
  public final void printCrushList(){
    CopyResource cpResource;
    Iterator iterator;

    iterator = crushedCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpResource =| iterator->nextElement();
      println(cpResource->getGol());
//      debug->write(debugFlag, cpResource->getDate());
    }
  }

  /**********************************************************
  * 書式：  public final void printCopyList()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  複製リスト一覧
  **********************************************************/
  public final void printCopyList(){
    CopyResource cpResource;
    Iterator iterator;

    iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpResource =| iterator->nextElement();
      println(cpResource->getGol());
    }
  }

  /**********************************************************
  * 書式：  public final void setTid(int id)
  * 引数：  int id      ID値
  * 戻り値：なし
  * 処理：  tidをセット
  **********************************************************/
  public final void setTid(int id){
    tid->setID(id);
  }

  /**********************************************************
  * 書式：  protected final void printCrushedCopy(String gol)
  * 引数：  String gol  故障した複製の GOL
  * 戻り値：なし
  * 処理：  故障した複製の GOLを表示
  **********************************************************/
  protected final void printCrushedCopy(String gol){
    String tmp=>breed("Crushed copy is ");
    tmp = tmp->concat(gol);
    println(tmp);
  }

  /**********************************************************
  * 書式：  protected void println(String str)
  * 引数：  String str      表示する文字列
  * 戻り値：なし
  * 処理：  文字列を表示する
  **********************************************************/
  protected void println(String str){
    System s;s=>create();
    PrintWriter o=s->getStdout();
    o->println(str);o->flush();
  }
  /**********************************************************
  * 書式：  protected void println(int i)
  * 引数：  int i           表示する整数
  * 戻り値：なし
  * 処理：  整数を表示する
  **********************************************************/
  protected void println(int i){
    Integer st=>breed(i);
    System s;s=>create();
    PrintWriter o=s->getStdout();
    o->println(st);o->flush();
  }
}


/**********************************************************
* 複製リスト／故障リストの管理対象クラス
**********************************************************/
class CopyResource {
  CopyScheme copy;      // 複製
  String gol;           // 複製のGOL
  Date date;            // 故障日時

  new create(){
    copy = null;
    gol = "INIT";
    date = null;
  }
  new create(CopyScheme c, String st){
    copy = c;
    gol = st;
    date = null;
  }
  public final bool equal(CopyResource pr){
    String gol2;
    if( gol->compareTo(pr->getGol()) == 0 )
      return true;
    else
      return false;
  }

  public final void setCopy(CopyScheme c, String st){
    copy = c;
    gol = st;
  }
  public final CopyScheme getCopy(){return copy;}
  public final String getGol(){return gol;}
  public final String getDate(){return date->asString();}
  public final void setDate(){date=>breed();}
}

/**********************************************************
* 複製リスト／故障リストの比較クラス
**********************************************************/
class CopyRes_Comparator : Comparator{
  new create(){}
  public final boolean compare(Root t1,Root t2){
    CopyResource a1,a2;
    a1=|t1;
    a2=|t2;
    if(a1->equal(a2))
      return true;
    else
      return false;
  }
  public final Comparator duplicate(){return this;}
  public final int hash (Root t){return 0;}
}


/**********************************************************
* 
**********************************************************/
class CopyMethodRunnable : *MethodRunnable {
  CopyFoo fooObj;
  CopyScheme copy;
  int flag;
  String primaryGOL;

  new create(Timer t){
    super=>create(t);
  }
  public final void set(CopyFoo object, CopyScheme cp, int fl, String gol){
    fooObj = object;
    copy = cp;
    flag = fl;
    primaryGOL = gol;
  }
  protected final Root MyMethod(){
    long ret = fooObj->foo(copy, flag, primaryGOL);
    Long L=>breed(ret);
    return L;
  }
}

/**********************************************************
* 
**********************************************************/
class CopyFoo {
  new create() {}

  public locked long foo(CopyScheme copy, int flag, String gol){
    System system => create();
    long aTime, bTime;
    Date date1, date2;
    long ret = 0;

    switch (flag) {
      case 1:               // ロック
        copy->lock();
        break;
      case 2:               // 全ての複製をロック
        copy->lockAll();
        break;
      case 3:               // 更新 (for primary copy)
        copy->update(gol);
        break;
      case 4:               // 更新 (for peer copy)
        copy->update();
        break;
      case 5:               // 変更確定
        copy->commit();
        break;
      case 6:               // 全ての複製の変更確定
        copy->commitAll();
        break;
      case 7:               // 生存確認
        date1=>breed();         // 生存確認の直前の時刻
        copy->isLive();         // 生存確認
        date2=>breed();         // 生存確認の直後の時刻
        bTime = date1->getTime();
        aTime = date2->getTime();
        ret = aTime - bTime;
        break;
    }
    return ret;
  }
}


/**********************************************************
* コピーマネージャ
**********************************************************/
cell OtherCopyManeger : *Transaction {
  protected void initialize(){
    d=>create();x=0;d->setP(" T:");     //for debug
    String gol=>breed("");
    gol = gol->getGOL();
    super->initialize(gol);
  }
  protected void go(){;}                            //main処理
  protected void quiet(){flushCell();stopCell();}   //終了処理
}
