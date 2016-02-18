/**********************************************************
* CopyOfPrimaryCopyScheme.oz
*   プライマリコピー方式（複製ライブラリ）
**********************************************************/
cell CopyOfPrimaryCopyScheme : *CopyScheme {

  protected bool primaryFlag;         // プライマリフラグ primary true: secondary false
  protected CopyOfPrimaryCopyScheme primaryCopy;  // セカンダリのときプライマリをセット
  protected String primaryGOL;

  /**********************************************************
  * 書式：  protected void initialize()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  初期化処理
  **********************************************************/
  protected void initialize(){
    primaryFlag = true;     // フラグを trueにセット
    primaryCopy = null;
    primaryGOL=>breed("");
    super->initialize();
  }

  protected void go(){;}                            //main処理
  protected void quiet(){flushCell();}   //終了処理

  /**********************************************************
  * 書式：  public bool newSecondaryCopyAt(CopyOfPrimaryCopyScheme copy, String gol)
  * 引数：  CopyOfPrimaryCopyScheme copy    登録する複製
  *         String gol                      複製の GOL
  * 戻り値：true    正常終了
  *         false   セカンダリコピーである
  * 処理：  複製を登録する
  **********************************************************/
  public bool newSecondaryCopyAt(CopyOfPrimaryCopyScheme copy, String gol){

    // セカンダリコピーのとき、何もしない
    if ( primaryFlag == false )
      return false;

    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:newSecondaryCopyAt() in");
    debug->write(debugFlag, gol);

    // 始めてセカンダリコピーが作られたときに、マネージャを作る
    if ( mgrFlag == false ) {
      mgrFlag = true;
      super->setCpManeger();
    }

    copy->setPrimaryFlag(false);    // フラグを falseにセット

    idnum++;
    if ( idnum > MAX_ID )
      idnum = 1;
    copy->setTid(idnum);

    // otherCopiesリストに golを追加する。
    CopyResource cpResource;
    cpResource=>create(copy, gol);
    otherCopies->add(cpResource);

    // 更新されたプライマリコピーを各セカンダリコピーに通知する
    setAllPrimaryCopy(this, ownGOL);

    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:newSecondaryCopyAt() out");
    return true;
  }

  /**********************************************************
  * 書式：  public bool removeCopyOf(String delGol)
  * 引数：  String delGol	削除する複製の GOL
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  GOLで指定される複製を削除する
  **********************************************************/
  public bool removeSecondaryCopyOf(String delGol){
    bool rc = true;
    // セカンダリコピーのとき、何もしない
    if ( primaryFlag == false )
      return false;
    rc = super->removeCopyOf(delGol);
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
    bool rc = true;
    // セカンダリコピーのとき、何もしない
    if ( primaryFlag == false )
      return false;
    else
      rc = super->lockAll();
    return rc;
  }

  /**********************************************************
  * 書式：  public bool propagateAll()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  変更を全ての複製に反映
  **********************************************************/
  public bool propagateAll(){
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:PropagateAll() in");
    bool rc = true;

    // セカンダリコピーのとき、何もしない
    if ( primaryFlag == false )
      return false;
    rc = super->propagateAllCP(3);
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:PropagateAll() out");
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
    bool rc = true;

    // セカンダリコピーのとき、何もしない
    if ( primaryFlag == false )
      return false;
    else
      rc = super->commitAll();
    return rc;
  }

  /**********************************************************
  * 書式：  public void update()
  * 処理：  何もしない。サブセルの update()に処理をパスする
  **********************************************************/
  public void update(String gol){}

  /**********************************************************
  * 書式：  public void primaryUpdate()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  プライマリコピーのupdate()を呼び出す
  **********************************************************/
  public void primaryUpdate(){
    // プライマリコピーのとき、呼ばれないはず
    if ( primaryFlag == true )
      return;
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:primaryUpdate() in");
    primaryCopy->update(primaryGOL);
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:primaryUpdate() out");
  }

  /**********************************************************
  * 書式：  public CopyOfPrimaryCopyScheme getClientStub()
  * 引数：  なし
  * 戻り値：最も処理（isLive()呼び出し）の早いコピー
  * 処理：  クライアントスタブを得る
  **********************************************************/
  public CopyOfPrimaryCopyScheme getClientStub(){
    // セカンダリコピーだったら何もしない
    if ( primaryFlag == false )
      return null;

    CopyOfPrimaryCopyScheme minCopy;
    minCopy =| super->getClientStubCP();
    return minCopy;
  }

  /**********************************************************
  * 書式：  public void setPrimaryFlag(bool flag)
  * 引数：  bool flag   true :プライマリコピー
  *                     false:セカンダリコピー
  * 戻り値：なし
  * 処理：  プライマリフラグをセットする
  **********************************************************/
  public void setPrimaryFlag(bool flag){
    primaryFlag = flag;
  }

  /**********************************************************
  * 書式：  public void setPrimaryCopy(CopyOfPrimaryCopyScheme cp)
  * 引数：  CopyOfPrimaryCopyScheme cp  プライマリコピー
  * 戻り値：なし
  * 処理：  プライマリコピーをセットする
  **********************************************************/
  public void setPrimaryCopy(CopyOfPrimaryCopyScheme cp){
    // プライマリコピーだったら何もしない
    if ( primaryFlag == true )
      return;
    primaryCopy = cp;
  }

  /**********************************************************
  * 書式：  public void setPrimaryGOL(String gol)
  * 引数：  String gol  プライマリコピーの GOL
  * 戻り値：なし
  * 処理：  プライマリコピーの GOLをセットする
  **********************************************************/
  public void setPrimaryGOL(String gol){
    // プライマリコピーだったら何もしない
    if ( primaryFlag == true )
      return;
    primaryGOL = gol;
  }

  /**********************************************************
  * 書式：  public CopyOfPrimaryCopyScheme getPrimaryCopy()
  * 引数：  なし
  * 戻り値：プライマリコピー
  * 処理：  プライマリコピーを返す
  **********************************************************/
  public CopyOfPrimaryCopyScheme getPrimaryCopy(){
    return primaryCopy;
  }

  /**********************************************************
  * 書式：  public void setAllPrimaryCopy(CopyOfPrimaryCopyScheme newprim, String gol)
  * 引数：  CopyOfPrimaryCopyScheme newprim プライマリコピー
  *         String gol          プライマリコピーの GOL
  * 戻り値：なし
  * 処理：  更新されたプライマリコピーを各セカンダリコピーに通知する
  **********************************************************/
  public void setAllPrimaryCopy(CopyOfPrimaryCopyScheme newprim, String gol){
    CopyResource cpResource;
    CopyOfPrimaryCopyScheme secondary;
    Iterator iterator;
    iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpResource =| iterator->nextElement();
      secondary =| cpResource->getCopy();
      secondary->setPrimaryCopy(newprim);
      secondary->setPrimaryGOL(gol);
    }
  }

  /**********************************************************
  * 書式：  public void setAllPrimaryCopy(CopyOfPrimaryCopyScheme newprim)
  * 引数：  CopyOfPrimaryCopyScheme newprim プライマリコピー
  * 戻り値：なし
  * 処理：  更新されたプライマリコピーを各セカンダリコピーに通知する
  **********************************************************/
  public void setAllPrimaryCopy(CopyOfPrimaryCopyScheme newprim){
    CopyResource cpResource;
    CopyOfPrimaryCopyScheme secondary;
    Iterator iterator;
    iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpResource =| iterator->nextElement();
      secondary =| cpResource->getCopy();
      secondary->setPrimaryCopy(newprim);
    }
  }
}

class InvalidCallofPrimaryException :* RuntimeException {
  new init() { super=>init(); }
}
