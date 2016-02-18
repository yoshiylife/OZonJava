/**********************************************************
* CopyOfPeerCopyScheme.oz
*   �ԥ����ԡ�������ʣ���饤�֥���
**********************************************************/
cell CopyOfPeerCopyScheme : *CopyScheme {

  /**********************************************************
  * �񼰡�  protected void initialize()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  ���������
  **********************************************************/
  protected void initialize(){
    super->initialize();
  }

  protected void go(){;}                            //main����
  protected void quiet(){flushCell();}   //��λ����

  /**********************************************************
  * �񼰡�  public void newCopyAt(CopyOfPeerCopyScheme newCopy, String gol, String mngGol)
  * ������  CopyOfPeerCopyScheme copy   ��Ͽ����ʣ��
  *         String gol                  ʣ���� GOL
  *         String mngGol               ���ԡ��ޥ͡������������� GOL
  * ����͡��ʤ�
  * ������  ʣ������Ͽ����
  **********************************************************/
  public void newCopyAt(CopyOfPeerCopyScheme newCopy, String gol, String mngGol ){
    debug->write(debugFlag,"CopyOfPeerCopyScheme:newCopyAt() in");
    debug->write(debugFlag, gol);

    // ���ԡ��ޥ͡��������
    if ( mgrFlag == false ) {
      super->setCpManeger();
    }
    newCopy->setCpmGol(mngGol);
    newCopy->setCpManeger();

    idnum++;
    if ( idnum > MAX_ID )
      idnum = 1;
    newCopy->setTid(idnum);

    // ���������ԡ���Ʊ���ꥹ�Ȥ���
    CopyResource cpResource=>create(this, ownGOL);
    newCopy->makeList(otherCopies, cpResource);

    // otherCopies�ꥹ�Ȥˤ��륳�ԡ���缡���Ф���gol�����Τ���
    cpResource=>create(newCopy, gol);

    CopyOfPeerCopyScheme copy;
    CopyResource cpRes;
    Iterator iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpRes =| iterator->nextElement();
      copy =| cpRes->getCopy();
      copy->addOtherCopy(cpResource);
    }

    // ��ʬ�� otherCopies�ꥹ�Ȥ� gol���ɲä��롣
    addOtherCopy(cpResource);

    debug->write(debugFlag, "CopyOfPeerCopyScheme:newCopyAt() out");
  }

  /**********************************************************
  * �񼰡�  public void makeList(Set list, CopyResource parent)
  * ������  Set list            ���Υꥹ��
  *         CopyResource parent ʣ�����ɲä��줿���
  * ����͡��ʤ�
  * ������  �ꥹ�Ȥ��������
  **********************************************************/
  public void makeList(Set list, CopyResource parent){
    otherCopies = list;
    otherCopies->add(parent);
  }

  /**********************************************************
  * �񼰡�  public void addOtherCopy(CopyResource newRes)
  * ������  CopyResource newRes �ɲä���ʣ��
  * ����͡��ʤ�
  * ������  otherCopies�ꥹ�Ȥ�ʣ�����ɲä���
  **********************************************************/
  public void addOtherCopy(CopyResource newRes){
    otherCopies->add(newRes);
  }

  /**********************************************************
  * �񼰡�  public bool propagateAll()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  �ѹ������Ƥ�ʣ����ȿ��
  **********************************************************/
  public bool propagateAll(){
    debug->write(debugFlag, "CopyOfPeerCopyScheme:PropagateAll() in");
    bool rc = true;
    rc = super->propagateAllCP(4);
    debug->write(debugFlag, "CopyOfPeerCopyScheme:PropagateAll() out");
    return rc;
  }

  /**********************************************************
  * �񼰡�  public void update()
  * ������  ���⤷�ʤ������֥���� update()�˽�����ѥ�����
  **********************************************************/
  public void update(){}

  /**********************************************************
  * �񼰡�  public CopyOfPeerCopyScheme getClientStub()
  * ������  �ʤ�
  * ����͡��Ǥ������isLive()�ƤӽФ��ˤ��ᤤ���ԡ�
  * ������  ���饤����ȥ����֤�����
  **********************************************************/
  public CopyOfPeerCopyScheme getClientStub(){
    CopyOfPeerCopyScheme minCopy;
    minCopy =| super->getClientStubCP();
    return minCopy;
  }

  /**********************************************************
  * �񼰡�  public CopyOfPeerCopyScheme getCopy(String cpGol)
  * ������  String cpGol    �������� GOL
  * ����͡�GOL�˰��פ��륳�ԡ����֤�
  *         ¸�ߤ��ʤ��Ȥ���null
  * ������  otherCopys�������� GOL�˰��פ��륳�ԡ����֤�
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
