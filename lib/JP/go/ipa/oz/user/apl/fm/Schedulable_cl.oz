/*
 * $Id: Schedulable.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */

class Schedulable : *FMObject {
	/* 
	 * ͽ���оݤȤʤ����(�㡧����)
	 * ���μ��Τλ������(�㡧��ļ�)��
	 * Scheduler��ô��
	 */

	ScheduleBoard	board;

	new create() {
		super=>create();
		board=>create(30,15);	// 30����15ʬ���
	}

	/*
	 * ���Τ��Ф���ͽ���Ԥ�
	 *
	 * @param	res		ͽ��������ĥ��֥�������
	 * @return	true		ͽ������
	 *		false		ͽ����
	 */
	public locked bool reserve(Reserve res) {
		return board->reserve(res);
	}

	/*
	 * ���Τ�ͽ������γ�ǧ��Ԥ�
	 *
	 * @param	res		��ǧ������������
	 * @return	���ꤷ�������Ӥ�Koma�ꥹ��
	 */
	public locked SList confirm(Reserve res) {
		return board->confirm(res);
	}

	/*
	 * ���ꤵ�줿���Τ�ͽ���������
	 *
	 * @param	res		����󥻥뤹��ͽ��
	 */
	public locked void cancel(Reserve res) {
		board->cancel(res);
	}


	public ScheduleBoard getBoard() {
		return board;
	}

	protected int boardUpdate(Schedulable sch) {
		int counter = 0;
//system->println("Schedulable#update() board update");
			ScheduleBoard sboard =  sch->getBoard();
			SList table = board->getTable();
			SList stable = sboard->getTable();
			Iterator iter = table->iterator();
			Iterator siter = stable->iterator();

			// table��size�ϸ���椨��ñ��
			while (iter->hasMoreElements()) {
				SList aDay;
				SList saDay;

				aDay =| iter->nextElement();
				saDay =| siter->nextElement();
				Iterator diter = aDay->iterator();
				Iterator sditer = saDay->iterator();

				// aDay��size�����椨��ñ��
				while (diter->hasMoreElements()) {
					TimePiece tp;
					TimePiece stp;
					tp =| diter->nextElement();
					stp =| sditer->nextElement();
// name(������)�ϸ��������reserve����Τߤ���ӹ�������Ф褤��
					if (tp->isReservable() != stp->isReservable()) {
						if (stp->isReservable()) {
							tp->cancel();
//system->println(tp->getName()->concat(":cancel"));
						} else {
							tp->reserve();
//system->println(tp->getName()->concat(":reserve"));
						}
						counter++;
					}
				}
			}
		return counter;
	}

	public locked int update(FMObject obj) { 
		// ������FMObject�ʤΤϡ������Х饤�ɤ��뤿��
//System system=>create();
//system->println("Schedulable#update() START");
		Schedulable sch;sch =| obj;
		int counter = updateWithoutLock(sch);

// ������board�򹹿����롣����˰�̣������Τ�difference�ϻȤ��ʤ���
// ��������������顢���Ф�����ӹ����Ǥ��롣
// reserve����ʳ��ϡ����פ��Ƥ���Τ�reserve����Τߤ��оݤȤ��롣

		if (board != null) {
			counter += boardUpdate(sch);
		}
//system->println("Schedulable#update() END");

		return counter;
	}

	public FMObject cloneSelf() {
		// ����FMObject�ʤΤϡ������Х饤�ɤ��뤿��
		Schedulable clone=>create(this);
		return clone;
	}

	new create(Schedulable s) {
		super=>create(s->getName(), s->getAllRelations(), s->getIdentifier());
		board = s->getBoard()->cloneSelf();
	}

	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(board);
		super->toGreen();
	}

	public void trace(int mark) {
		System system=>create();
		PrintWriter pw=>breed(system->getStdout(), true);
		pw->print("Schedulable#trace(");
		pw->print(mark);
		pw->println(")");
		board->trace(mark); 
		pw->println("---- super ----");
		super->trace(mark);
	}
}
