/**********************************************************
* CopyOfPrimaryCopyScheme.oz
*   �ץ饤�ޥꥳ�ԡ�������ʣ���饤�֥���
**********************************************************/
cell CopyOfPrimaryCopyScheme : *CopyScheme {

  protected bool primaryFlag;         // �ץ饤�ޥ�ե饰 primary true: secondary false
  protected CopyOfPrimaryCopyScheme primaryCopy;  // ���������ΤȤ��ץ饤�ޥ�򥻥å�
  protected String primaryGOL;

  /**********************************************************
  * �񼰡�  protected void initialize()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  ���������
  **********************************************************/
  protected void initialize(){
    primaryFlag = true;     // �ե饰�� true�˥��å�
    primaryCopy = null;
    primaryGOL=>breed("");
    super->initialize();
  }

  protected void go(){;}                            //main����
  protected void quiet(){flushCell();}   //��λ����

  /**********************************************************
  * �񼰡�  public bool newSecondaryCopyAt(CopyOfPrimaryCopyScheme copy, String gol)
  * ������  CopyOfPrimaryCopyScheme copy    ��Ͽ����ʣ��
  *         String gol                      ʣ���� GOL
  * ����͡�true    ���ｪλ
  *         false   ��������ꥳ�ԡ��Ǥ���
  * ������  ʣ������Ͽ����
  **********************************************************/
  public bool newSecondaryCopyAt(CopyOfPrimaryCopyScheme copy, String gol){

    // ��������ꥳ�ԡ��ΤȤ������⤷�ʤ�
    if ( primaryFlag == false )
      return false;

    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:newSecondaryCopyAt() in");
    debug->write(debugFlag, gol);

    // �Ϥ�ƥ�������ꥳ�ԡ������줿�Ȥ��ˡ��ޥ͡��������
    if ( mgrFlag == false ) {
      mgrFlag = true;
      super->setCpManeger();
    }

    copy->setPrimaryFlag(false);    // �ե饰�� false�˥��å�

    idnum++;
    if ( idnum > MAX_ID )
      idnum = 1;
    copy->setTid(idnum);

    // otherCopies�ꥹ�Ȥ� gol���ɲä��롣
    CopyResource cpResource;
    cpResource=>create(copy, gol);
    otherCopies->add(cpResource);

    // �������줿�ץ饤�ޥꥳ�ԡ���ƥ�������ꥳ�ԡ������Τ���
    setAllPrimaryCopy(this, ownGOL);

    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:newSecondaryCopyAt() out");
    return true;
  }

  /**********************************************************
  * �񼰡�  public bool removeCopyOf(String delGol)
  * ������  String delGol	�������ʣ���� GOL
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  GOL�ǻ��ꤵ���ʣ����������
  **********************************************************/
  public bool removeSecondaryCopyOf(String delGol){
    bool rc = true;
    // ��������ꥳ�ԡ��ΤȤ������⤷�ʤ�
    if ( primaryFlag == false )
      return false;
    rc = super->removeCopyOf(delGol);
    return rc;
  }

  /**********************************************************
  * �񼰡�  public bool lockAll()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  ���Ƥ�ʣ���оݥ�����å�
  **********************************************************/
  public bool lockAll(){
    bool rc = true;
    // ��������ꥳ�ԡ��ΤȤ������⤷�ʤ�
    if ( primaryFlag == false )
      return false;
    else
      rc = super->lockAll();
    return rc;
  }

  /**********************************************************
  * �񼰡�  public bool propagateAll()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  �ѹ������Ƥ�ʣ����ȿ��
  **********************************************************/
  public bool propagateAll(){
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:PropagateAll() in");
    bool rc = true;

    // ��������ꥳ�ԡ��ΤȤ������⤷�ʤ�
    if ( primaryFlag == false )
      return false;
    rc = super->propagateAllCP(3);
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:PropagateAll() out");
    return rc;
  }

  /**********************************************************
  * �񼰡�  public bool commitAll()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  ���Ƥ��ѹ������
  **********************************************************/
  public bool commitAll(){
    bool rc = true;

    // ��������ꥳ�ԡ��ΤȤ������⤷�ʤ�
    if ( primaryFlag == false )
      return false;
    else
      rc = super->commitAll();
    return rc;
  }

  /**********************************************************
  * �񼰡�  public void update()
  * ������  ���⤷�ʤ������֥���� update()�˽�����ѥ�����
  **********************************************************/
  public void update(String gol){}

  /**********************************************************
  * �񼰡�  public void primaryUpdate()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  �ץ饤�ޥꥳ�ԡ���update()��ƤӽФ�
  **********************************************************/
  public void primaryUpdate(){
    // �ץ饤�ޥꥳ�ԡ��ΤȤ����ƤФ�ʤ��Ϥ�
    if ( primaryFlag == true )
      return;
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:primaryUpdate() in");
    primaryCopy->update(primaryGOL);
    debug->write(debugFlag, "CopyOfPrimaryCopyScheme:primaryUpdate() out");
  }

  /**********************************************************
  * �񼰡�  public CopyOfPrimaryCopyScheme getClientStub()
  * ������  �ʤ�
  * ����͡��Ǥ������isLive()�ƤӽФ��ˤ��ᤤ���ԡ�
  * ������  ���饤����ȥ����֤�����
  **********************************************************/
  public CopyOfPrimaryCopyScheme getClientStub(){
    // ��������ꥳ�ԡ����ä��鲿�⤷�ʤ�
    if ( primaryFlag == false )
      return null;

    CopyOfPrimaryCopyScheme minCopy;
    minCopy =| super->getClientStubCP();
    return minCopy;
  }

  /**********************************************************
  * �񼰡�  public void setPrimaryFlag(bool flag)
  * ������  bool flag   true :�ץ饤�ޥꥳ�ԡ�
  *                     false:��������ꥳ�ԡ�
  * ����͡��ʤ�
  * ������  �ץ饤�ޥ�ե饰�򥻥åȤ���
  **********************************************************/
  public void setPrimaryFlag(bool flag){
    primaryFlag = flag;
  }

  /**********************************************************
  * �񼰡�  public void setPrimaryCopy(CopyOfPrimaryCopyScheme cp)
  * ������  CopyOfPrimaryCopyScheme cp  �ץ饤�ޥꥳ�ԡ�
  * ����͡��ʤ�
  * ������  �ץ饤�ޥꥳ�ԡ��򥻥åȤ���
  **********************************************************/
  public void setPrimaryCopy(CopyOfPrimaryCopyScheme cp){
    // �ץ饤�ޥꥳ�ԡ����ä��鲿�⤷�ʤ�
    if ( primaryFlag == true )
      return;
    primaryCopy = cp;
  }

  /**********************************************************
  * �񼰡�  public void setPrimaryGOL(String gol)
  * ������  String gol  �ץ饤�ޥꥳ�ԡ��� GOL
  * ����͡��ʤ�
  * ������  �ץ饤�ޥꥳ�ԡ��� GOL�򥻥åȤ���
  **********************************************************/
  public void setPrimaryGOL(String gol){
    // �ץ饤�ޥꥳ�ԡ����ä��鲿�⤷�ʤ�
    if ( primaryFlag == true )
      return;
    primaryGOL = gol;
  }

  /**********************************************************
  * �񼰡�  public CopyOfPrimaryCopyScheme getPrimaryCopy()
  * ������  �ʤ�
  * ����͡��ץ饤�ޥꥳ�ԡ�
  * ������  �ץ饤�ޥꥳ�ԡ����֤�
  **********************************************************/
  public CopyOfPrimaryCopyScheme getPrimaryCopy(){
    return primaryCopy;
  }

  /**********************************************************
  * �񼰡�  public void setAllPrimaryCopy(CopyOfPrimaryCopyScheme newprim, String gol)
  * ������  CopyOfPrimaryCopyScheme newprim �ץ饤�ޥꥳ�ԡ�
  *         String gol          �ץ饤�ޥꥳ�ԡ��� GOL
  * ����͡��ʤ�
  * ������  �������줿�ץ饤�ޥꥳ�ԡ���ƥ�������ꥳ�ԡ������Τ���
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
  * �񼰡�  public void setAllPrimaryCopy(CopyOfPrimaryCopyScheme newprim)
  * ������  CopyOfPrimaryCopyScheme newprim �ץ饤�ޥꥳ�ԡ�
  * ����͡��ʤ�
  * ������  �������줿�ץ饤�ޥꥳ�ԡ���ƥ�������ꥳ�ԡ������Τ���
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
