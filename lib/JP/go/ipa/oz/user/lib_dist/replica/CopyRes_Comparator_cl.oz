/**********************************************************
* CopyScheme.oz
*   ʣ���饤�֥�궦�̽���
**********************************************************/
cell CopyScheme : *TransactionResource {

  protected OtherCopyManeger cpManeger; // ���ԡ� �ޥ͡�����
  protected bool mgrFlag;       // ���ԡ� �ޥ͡����� �ե饰
  protected String cpmGol;      // ���ԡ� �ޥ͡����� GOL
  protected bool status;        //���ԡ�����¸����ǧ�Ǥ��ʤ����false
  protected Set otherCopies;    //ʣ���Υꥹ��
  protected Set crushedCopies;  //�ξ㤷��ʣ���Υꥹ��
  protected int idnum;	        // �ɣĥ�����
  protected int MAX_ID;         // �ɣĺ�����
  protected String ownGOL;
  int timeOut;                  //RMI�Υ����ॢ����
  TID tid;
  protected Debug debug;
  protected int debugFlag;      //if 1 debug on

  /**********************************************************
  * �񼰡�  protected void initialize()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  ���������
  **********************************************************/
  protected void initialize(){

    // TransactionResource:initialize()��Ƥ�
    d=>create();x=0;d->setP(" p:"); //for debug
    ownGOL=>breed("");
    ownGOL = ownGOL->getGOL();      // ������GOL
    super->initialize("tmp0", "tmp1", "tmp2", ownGOL);

    // TID �򥻥å�
    idnum = 1;
    tid=>create();
    tid->set(idnum, ownGOL);

    // ɬ�פ��ѿ�������
    CopyRes_Comparator pc=>create();
    otherCopies=>create(pc);
    crushedCopies=>create();
    cpmGol=>breed("");      // ��������ꥳ�ԡ� �ޥ͡����� GOL
    mgrFlag = false;
    status = true;
    timeOut = 10000;        // �����ॢ���ȤΥǥե������
    MAX_ID = 10000;         // ID�κ�����
  }

  protected void go(){;}                            //main����
  protected void quiet(){flushCell();}   //��λ����

  /**********************************************************
  * �񼰡�  public final void setCpmGol(String gol)
  * ������  String gol  ���ԡ��ޥ͡������������� GOL
  * ����͡��ʤ�
  * ������  ���ԡ��ޥ͡������������� GOL������
  **********************************************************/
  public final void setCpmGol(String gol){
    cpmGol = gol;
  }

  /**********************************************************
  * �񼰡�  public final void setCpManeger()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  ���ԡ��ޥ͡��������
  **********************************************************/
  public final void setCpManeger(){
    mgrFlag = true;
    cpManeger=>create(cpmGol);
    cpManeger=>bind(cpmGol);
    cpManeger->setResourceTimeOut(timeOut);
  }

  /**********************************************************
  * �񼰡�  public final bool removeCopyOf(String delGol)
  * ������  String delGol	�������ʣ���� GOL
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  GOL�ǻ��ꤵ���ʣ����������
  **********************************************************/
  public final bool removeCopyOf(String delGol){

    // otherCopies�ꥹ�Ȥ��� gol��ʣ���������롣
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
  * �񼰡�  public final void setTimeOut(int time)
  * ������  int time    �����ॢ������
  * ����͡��ʤ�
  * ������  �����ॢ���Ȥ�����
  **********************************************************/
  public final void setTimeOut(int time){
    timeOut = time;

    // Transaction Timeout�򥻥åȤ���
    cpManeger->setResourceTimeOut(timeOut);
  }

  /**********************************************************
  * �񼰡�  public final int getTimeOut()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  �����ॢ�����ͤμ���
  **********************************************************/
  public final int getTimeOut(){
    return timeOut;
  }

  /**********************************************************
  * �񼰡�  public final void setResourceTimeLimit(int time)
  * ������  int time    �����ॢ������
  * ����͡��ʤ�
  * ������  TransactionResource �� LockingTimeLimit�򥻥å�
  **********************************************************/
  public final void setResourceTimeLimit(int time){
    super->setLockingTimeLimit(time);
  }

  /**********************************************************
  * �񼰡�  public final bool lock()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  ʣ���оݥ�����å�
  **********************************************************/
  public final bool lock(){
    bool rc = true;

    // TransactionResource�� lock(TID)��Ƥ�
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
  * �񼰡�  public bool lockAll()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  ���Ƥ�ʣ���оݥ�����å�
  **********************************************************/
  public bool lockAll(){
    Array golArray;
    CopyResource cpResource;
    String gol;
    Iterator iterator;
    int i;
    bool rc = true;

    // lock()���Ϥ�������������
    golArray=>create(otherCopies->size());
    iterator = otherCopies->iterator();
    for( i=0; iterator->hasMoreElements(); i++) {
      cpResource =| iterator->nextElement();
      gol = cpResource->getGol();
      golArray->putAt(i, gol);
    }

    try {
      // Transaction�� lock()��Ƥ�
      cpManeger->lock(golArray);
    }
    catch (Exception e){
      debug->write(debugFlag, "Error in lockAll()");
      rc = false;
    }
    return rc;
  }

  /**********************************************************
  * �񼰡�  public final bool propagate()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  �ѹ���ʣ����ȿ��
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
  * �񼰡�  public bool propagateAllCP(int type)
  * ������  int type	3:�ץ饤�ޥꥳ�ԡ��� update()
  *			4:�ԥ����ԡ��� update()
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  �ѹ������Ƥ�ʣ����ȿ��
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
      // �����ޤ򤫤��ơ�lockAll()��Ƥ�
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
          // �����ޤ򤫤��ơ�update()��Ƥ�
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
      // �����ޤ򤫤��ơ�commitAll()��Ƥ�
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
      // ���顼���Ф��飱�Ĥ��Ľ���
      crushFlag = false;
      iterator = otherCopies->iterator();
      while( iterator->hasMoreElements() ) {
        cpResource =| iterator->nextElement();
        copy = cpResource->getCopy();
        rc = true;
        try {
          // �����ޤ򤫤��ơ�lock()��Ƥ�
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
            // �����ޤ򤫤��ơ�update()��Ƥ�
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
            // �����ޤ򤫤��ơ�commit()��Ƥ�
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
          // �ξ���ǧ��������򥻥å�
          cpResource->setDate();
          // �ξ㤷��ʣ���Υꥹ�Ȥ��ɲ�
          crushedCopies->add(cpResource);
          crushFlag = true;
          // �ξ㤷��ʣ����ɽ��
          printCrushedCopy(cpResource->getGol());
        }
      }
      // otherCopies����ä�
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
  * �񼰡�  public final bool commit()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  �ѹ������
  **********************************************************/
  public final bool commit(){
    bool rc = true;

    // TransactionResource�� commit(TID)��Ƥ�
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
  * �񼰡�  public bool commitAll()
  * ������  �ʤ�
  * ����͡�true    ���ｪλ
  *         false   ���顼ȯ��
  * ������  ���Ƥ��ѹ������
  **********************************************************/
  public bool commitAll(){
    // Transaction�� commit()��Ƥ�
    cpManeger->commit();
    return true;
  }

  /**********************************************************
  * �񼰡�  public void update()
  * ������  ���⤷�ʤ������֥���� update()�˽�����ѥ�����
  **********************************************************/
  public void update(){}
  public void update(String gol){}

  /**********************************************************
  * �񼰡�  public final CopyScheme getClientStubCP()
  * ������  �ʤ�
  * ����͡��Ǥ������isLive()�ƤӽФ��ˤ�®��ʣ��
  * ������  ���饤����ȥ����֤�����
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

    // ���ƤΥ��ԡ�����Ф�
    iterator = otherCopies->iterator();
    while( iterator->hasMoreElements() ) {
      cpResource =| iterator->nextElement();
      copy = cpResource->getCopy();
      debug->write(debugFlag, cpResource->getGol());

      // �����ޤ򤫤��ơ�isLive()��Ƥ�
      mmr->set(obj,copy, 7, null);
      try{
        lTime =| t->invoke(mmr, timeOut);
        cTime = lTime->longValue();
        stime = lTime->asString();
        debug->write(debugFlag, "isLive() time is ", stime);
        // ���ֽ������֤�û����Τ�ȤäƤ���
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
  * �񼰡�  public final bool isLive()
  * ������  �ʤ�
  * ����͡���� true
  * ������  ��¸��ǧ
  **********************************************************/
  public final bool isLive(){
    return true;
  }

  /**********************************************************
  * �񼰡�  public final void printCrushList()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  �ξ�ꥹ�Ȱ���
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
  * �񼰡�  public final void printCopyList()
  * ������  �ʤ�
  * ����͡��ʤ�
  * ������  ʣ���ꥹ�Ȱ���
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
  * �񼰡�  public final void setTid(int id)
  * ������  int id      ID��
  * ����͡��ʤ�
  * ������  tid�򥻥å�
  **********************************************************/
  public final void setTid(int id){
    tid->setID(id);
  }

  /**********************************************************
  * �񼰡�  protected final void printCrushedCopy(String gol)
  * ������  String gol  �ξ㤷��ʣ���� GOL
  * ����͡��ʤ�
  * ������  �ξ㤷��ʣ���� GOL��ɽ��
  **********************************************************/
  protected final void printCrushedCopy(String gol){
    String tmp=>breed("Crushed copy is ");
    tmp = tmp->concat(gol);
    println(tmp);
  }

  /**********************************************************
  * �񼰡�  protected void println(String str)
  * ������  String str      ɽ������ʸ����
  * ����͡��ʤ�
  * ������  ʸ�����ɽ������
  **********************************************************/
  protected void println(String str){
    System s;s=>create();
    PrintWriter o=s->getStdout();
    o->println(str);o->flush();
  }
  /**********************************************************
  * �񼰡�  protected void println(int i)
  * ������  int i           ɽ����������
  * ����͡��ʤ�
  * ������  ������ɽ������
  **********************************************************/
  protected void println(int i){
    Integer st=>breed(i);
    System s;s=>create();
    PrintWriter o=s->getStdout();
    o->println(st);o->flush();
  }
}


/**********************************************************
* ʣ���ꥹ�ȡ��ξ�ꥹ�Ȥδ����оݥ��饹
**********************************************************/
class CopyResource {
  CopyScheme copy;      // ʣ��
  String gol;           // ʣ����GOL
  Date date;            // �ξ�����

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
* ʣ���ꥹ�ȡ��ξ�ꥹ�Ȥ���ӥ��饹
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
      case 1:               // ��å�
        copy->lock();
        break;
      case 2:               // ���Ƥ�ʣ�����å�
        copy->lockAll();
        break;
      case 3:               // ���� (for primary copy)
        copy->update(gol);
        break;
      case 4:               // ���� (for peer copy)
        copy->update();
        break;
      case 5:               // �ѹ�����
        copy->commit();
        break;
      case 6:               // ���Ƥ�ʣ�����ѹ�����
        copy->commitAll();
        break;
      case 7:               // ��¸��ǧ
        date1=>breed();         // ��¸��ǧ��ľ���λ���
        copy->isLive();         // ��¸��ǧ
        date2=>breed();         // ��¸��ǧ��ľ��λ���
        bTime = date1->getTime();
        aTime = date2->getTime();
        ret = aTime - bTime;
        break;
    }
    return ret;
  }
}


/**********************************************************
* ���ԡ��ޥ͡�����
**********************************************************/
cell OtherCopyManeger : *Transaction {
  protected void initialize(){
    d=>create();x=0;d->setP(" T:");     //for debug
    String gol=>breed("");
    gol = gol->getGOL();
    super->initialize(gol);
  }
  protected void go(){;}                            //main����
  protected void quiet(){flushCell();stopCell();}   //��λ����
}
