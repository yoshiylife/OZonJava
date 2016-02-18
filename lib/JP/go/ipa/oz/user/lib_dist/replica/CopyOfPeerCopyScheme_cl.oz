/**********************************************************
* CopyOfPeerCopyScheme.oz
*   ピアコピー方式（複製ライブラリ）
**********************************************************/
cell CopyOfPeerCopyScheme : *CopyScheme {

  /**********************************************************
  * 書式：  protected void initialize()
  * 引数：  なし
  * 戻り値：なし
  * 処理：  初期化処理
  **********************************************************/
  protected void initialize(){
    super->initialize();
  }

  protected void go(){;}                            //main処理
  protected void quiet(){flushCell();}   //終了処理

  /**********************************************************
  * 書式：  public void newCopyAt(CopyOfPeerCopyScheme newCopy, String gol, String mngGol)
  * 引数：  CopyOfPeerCopyScheme copy   登録する複製
  *         String gol                  複製の GOL
  *         String mngGol               コピーマネージャを作成する GOL
  * 戻り値：なし
  * 処理：  複製を登録する
  **********************************************************/
  public void newCopyAt(CopyOfPeerCopyScheme newCopy, String gol, String mngGol ){
    debug->write(debugFlag,"CopyOfPeerCopyScheme:newCopyAt() in");
    debug->write(debugFlag, gol);

    // コピーマネージャを作る
    if ( mgrFlag == false ) {
      super->setCpManeger();
    }
    newCopy->setCpmGol(mngGol);
    newCopy->setCpManeger();

    idnum++;
    if ( idnum > MAX_ID )
      idnum = 1;
    newCopy->setTid(idnum);

    // 新しいコピーに同じリストを作る
    CopyResource cpResource=>create(this, ownGOL);
    newCopy->makeList(otherCopies, cpResource);

    // otherCopiesリストにあるコピーを順次取り出し、golを通知する
    cpResource=>create(newCopy, gol);

    CopyOfPeerCopyScheme copy;
    CopyResource cpRes;
    Iterator iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpRes =| iterator->nextElement();
      copy =| cpRes->getCopy();
      copy->addOtherCopy(cpResource);
    }

    // 自分の otherCopiesリストに golを追加する。
    addOtherCopy(cpResource);

    debug->write(debugFlag, "CopyOfPeerCopyScheme:newCopyAt() out");
  }

  /**********************************************************
  * 書式：  public void makeList(Set list, CopyResource parent)
  * 引数：  Set list            元のリスト
  *         CopyResource parent 複製が追加された場所
  * 戻り値：なし
  * 処理：  リストを作成する
  **********************************************************/
  public void makeList(Set list, CopyResource parent){
    otherCopies = list;
    otherCopies->add(parent);
  }

  /**********************************************************
  * 書式：  public void addOtherCopy(CopyResource newRes)
  * 引数：  CopyResource newRes 追加する複製
  * 戻り値：なし
  * 処理：  otherCopiesリストに複製を追加する
  **********************************************************/
  public void addOtherCopy(CopyResource newRes){
    otherCopies->add(newRes);
  }

  /**********************************************************
  * 書式：  public bool propagateAll()
  * 引数：  なし
  * 戻り値：true    正常終了
  *         false   エラー発生
  * 処理：  変更を全ての複製に反映
  **********************************************************/
  public bool propagateAll(){
    debug->write(debugFlag, "CopyOfPeerCopyScheme:PropagateAll() in");
    bool rc = true;
    rc = super->propagateAllCP(4);
    debug->write(debugFlag, "CopyOfPeerCopyScheme:PropagateAll() out");
    return rc;
  }

  /**********************************************************
  * 書式：  public void update()
  * 処理：  何もしない。サブセルの update()に処理をパスする
  **********************************************************/
  public void update(){}

  /**********************************************************
  * 書式：  public CopyOfPeerCopyScheme getClientStub()
  * 引数：  なし
  * 戻り値：最も処理（isLive()呼び出し）の早いコピー
  * 処理：  クライアントスタブを得る
  **********************************************************/
  public CopyOfPeerCopyScheme getClientStub(){
    CopyOfPeerCopyScheme minCopy;
    minCopy =| super->getClientStubCP();
    return minCopy;
  }

  /**********************************************************
  * 書式：  public CopyOfPeerCopyScheme getCopy(String cpGol)
  * 引数：  String cpGol    検索する GOL
  * 戻り値：GOLに一致するコピーを返す
  *         存在しないときはnull
  * 処理：  otherCopysから指定の GOLに一致するコピーを返す
  **********************************************************/
  public CopyOfPeerCopyScheme getCopy(String cpGol){
    CopyOfPeerCopyScheme copy=null;
    CopyResource cpResource;
    String gol;
    Iterator iterator = otherCopies->iterator();
    for( int i=0; iterator->hasMoreElements(); i++) {
      cpResource =| iterator->nextElement();
      gol = cpResource->getGol();
      if( cpGol->compareTo(gol) == 0 ) {
        copy =| cpResource->getCopy();
      }
    }
    return copy;
  }
}
