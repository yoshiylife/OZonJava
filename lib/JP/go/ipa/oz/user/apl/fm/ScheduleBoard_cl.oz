/*
 * $Id: ScheduleBoard.oz,v 1.2 1998/02/02 03:40:09 hgoto Exp $
 */

class ScheduleBoard {
	/*
	 * ͽ�󤵤����Τ�ͽ��ɽ�˴ؤ��������Ԥ�
	 */
	int	initTime;
	int	span;
	int	pieceNum;
	int	days;
	int	grid;
	SList	table;
	

	new create(int date, int gd) {
		table=>create(); // ��Ӥ��ʤ��Τǥǥե����Comparator
		initTime = 8;
		span = 12;
		grid = gd;
		days = date;
		
		setTable();
	}
	
	/*
	 * ͽ��ɽ����ľ��
	 */
	public void reset() {
		table=>create();
		setTable();
	}
	
	/*
	 * ͽ��ɽ���������
	 */
	protected void setTable() {
		setPieceNum();
		for(int i=0;i<days;i++) {
			SList aDay;
			aDay = makeADay();
			table->pushBack(aDay);
		}
	}

	/*
	 * �����Ȥ������׻�����
	 */
	protected void setPieceNum() {
		pieceNum = span * 60 / grid;
	}

	/*
	 * ����ʬ�λ����Ȥ���
	 *
	 * @return	����ʬ��TimePiece���¤�
	 */
	protected SList makeADay() {
		SList aDay;
		aDay=>create();	// ��Ӥ��ʤ��Τǥǥե����Comparator
		for(int j=0;j<pieceNum;j++) {
			TimePiece aPiece;
			aPiece = makeATimePiece(j);
			aDay->pushBack(aPiece);
		}
		return aDay;
	}

	/*
	 * 1�Ĥλ����Ȥ���
	 *
	 * @param	number		���ֹ�
	 * @return	1��ʬ�λ�����
	 */
	protected TimePiece makeATimePiece(int number) {
		TimePiece aPiece;
		aPiece => create();

		aPiece->setName(makePieceLabel(number));
		return aPiece;
	}

	/*
	 * �����ȤΥ�٥����
	 *
	 * @param	number		���ֹ�
	 * @return	��٥��ʸ����
	 */
	protected String makePieceLabel(int number) {
		int now;
		int currentHour;
		int currentMinute;
		Integer Hour;
		Integer Minute;
		String label;

		now = number * grid;
		currentHour = now / 60;
		currentMinute = now % 60;

		Hour => breed(currentHour+initTime);
		Minute => breed(currentMinute);

		label = Hour->asString()->concat(":")
				->concat(Minute->asString());
		return label;
	}

	/*
	 * ͽ���Ԥ�
	 *
	 * @param	res		ͽ�󤷤���������
	 * @return	true		ͽ������
	 *		false		ͽ����
	 */
	public bool reserve(Reserve res) {
		int start;
		int end;
		bool result;
//res->trace(1);
		start = timeToPiece(res->getStartHour(), res->getStartMinute());
		int eh = res->getEndHour();
		int em = res->getEndMinute();
		if (em > 0) {
			em--;
		} else {
			if (eh > 0) {
				eh--;
				em = 60 - 1;
			} else {
				// 0��0ʬ��λ�ΤȤ�
				;
			}
		}
		end = timeToPiece(eh, em);

		result = reserve(res->getDay(), start, end);
// trace(1);
		return result;
	}

	/*
	 * ͽ���Ԥ�
	 * @param	date		ͽ����
	 *		start		ͽ�󳫻ϻ�����б�����TimePiece���ֹ�
	 *		end		ͽ��λ������б�����TimePiece���ֹ�
	 * @return	true		ͽ������
	 *		false		ͽ����
	 */
	public bool reserve(int date, int start, int end) {
//System system=>create();
		bool result;
		SList selected;
		Iterator iter;
//system->println("ScheduleBoard#reserve date:"
//->concat(""->valueOf(date))
//->concat(" start:")->concat(""->valueOf(start))
//->concat(" end:")->concat(""->valueOf(end)));

		selected = getSelectedSchedule(date, start, end);
		iter = selected->iterator();

		result = true;
		while(iter->hasMoreElements()) {
			TimePiece aPiece;
			aPiece =| iter->nextElement();
			result = aPiece->isReservable();
			if (!result) break;
		}

		if (!result) {
			return false;
		} else {
			iter = selected->iterator();
			while(iter->hasMoreElements()) {
				TimePiece aPiece;
				aPiece =| iter->nextElement();
				aPiece->reserve();
			}
		}

		return true;
		
	}
	
	/*
	 * ͽ������γ�ǧ
	 *
	 * @param	res		��ǧ������������
	 * @return	���ꤵ�줿�����Ӥ�Koma�ꥹ��
	 */
	public SList confirm(Reserve res) {
		return getSelectedSchedule(res);
	}
	
	/*
	 * ���ꤵ�줿�����Ӥ�TimePiece�ꥹ�Ȥ��������
	 *
	 * @param	res		TimePiece�ꥹ�Ȥ����������������
	 * @return	���ꤵ�줿�����Ӥ�TimePiece�ꥹ��
	 */
	public SList getSelectedSchedule(Reserve res) {
		int start;
		int end;
		SList result;

		start = timeToPiece(res->getStartHour(), res->getStartMinute());
		end = timeToPiece(res->getEndHour(), res->getEndMinute());
		int eh = res->getEndHour();
		int em = res->getEndMinute();
		if (em > 0) {
			em--;
		} else {
			if (eh > 0) {
				eh--;
				em = 60 - 1;
			} else {
				// 0��0ʬ��λ�ΤȤ�
				;
			}
		}
		end = timeToPiece(eh, em);

		result = getSelectedSchedule(res->getDay(), start, end);

		return result;
		
	}

	/*
	 * ���ꤵ�줿�����Ӥ�TimePiece�ꥹ�Ȥ��������
	 *
	 * @param	date		���ꤹ������
	 *		start		���ϻ�����б�����TimePiece���ֹ�
	 *		end		��λ������б�����TimePiece���ֹ�
	 * @return	���ꤵ�줿�����Ӥ�TimePiece�ꥹ��
	 */
	public SList getSelectedSchedule(int date, int start, int end) {
//System system=>create();
//system->println("ScheduleBoard#getSelectedSchedule() date:"->concat(""->valueOf(date)));
//system->println("ScheduleBoard#getSelectedSchedule() start:"->concat(""->valueOf(start)));
//system->println("ScheduleBoard#getSelectedSchedule() end:"->concat(""->valueOf(end)));
		SList days;
		SList result;
		
//system->println("ScheduleBoard#getSelectedSchedule() table:"->concat(table->asString()));
		days =| table->infix(date-1,date)->first();  // ���ꤵ�줿���Υꥹ�ȼ���
//system->println("ScheduleBoard#getSelectedSchedule() days:"->concat(days->asString()));
		result =| days->infix(start-1,end); // �����ϰϤΥ��ޤ��֤�


//Iterator sliter = result->iterator();
//while (sliter->hasMoreElements()) {
// TimePiece tp;tp =| sliter->nextElement();
// system->println("ScheduleBoard#getSelectedSchedule() result:"
// ->concat(tp->getName())->concat(" ")
// ->concat(""->valueOf(tp->isReservable())));
//}



		return result;
	}
	
	/*
	 * ���ꤵ�줿ͽ��Υ���󥻥��Ԥ�
	 *
	 * @param	res		����󥻥뤹��ͽ��
	 */
	public void cancel(Reserve res) {
//System system=>create();
//system->println("ScheduleBoard#cancel");
//res->trace(100);
		SList sch;
		Iterator iter;
		
		sch = getSelectedSchedule(res);
		iter = sch->iterator();

		while(iter->hasMoreElements()) {
			TimePiece aPiece;
			aPiece =| iter->nextElement();
//system->println("cancel:"->concat(aPiece->getName()));			
			aPiece->cancel();
		}
	}

	/*
	 * ����ʬ���Ѱդ��뤫������
	 *
	 * @param	date		�ơ��֥���Ѱդ�������
	 */
	public void setDays(int date) {
		days = date;
	}

	/*
	 * ����å��������ꤹ��
	 *
	 * @param	gd		���ꤹ�륰��å���(ʬñ��)
	 */	
	public void setGrid(int gd) {
		grid = gd;
		setPieceNum();
	}

	/*
	 * ����ʬ�򲿻��֤Ȥ��뤫�����
	 *
	 * @param	sp		���ꤹ�����
	 *				(�ǥե���Ȥ�12����)
	 */	
	public void setSpan(int sp) {
		span = sp;
		setPieceNum();
	}
	
	/*
	 * �������塼��󥰳��ϻ��������
	 *
	 * @param	time		�������塼��󥰳��ϻ���
	 *				(�ǥե���Ȥ�8:00)
	 */
	public void setInitTime(int time) {
		initTime = time;
	}

	/*
	 * ����ʬ�Υ������塼��ɽ�����뤫�����
	 *
	 * @return	����
	 */	
	public int getDays() {
		return days;
	}
	
	/*
	 * ����å����μ���
	 *
	 * @return	����å���
	 */	
	public int getGrid() {
		return grid;
	}
	
	/*
	 * �������塼��󥰤������֤μ���
	 *
	 * @return	�������塼��󥰤�������
	 */	
	public int getSpan() {
		return span;
	}
	
	/*
	 * �����Υ������塼��󥰳��ϻ���
	 *
	 * @return	���ϻ���
	 */	
	public int getInitTime() {
		return initTime;
	}
	
	/*
	 * ����ʬ�Υ��޿��μ���
	 *
	 * @return	����ʬ���ȿ�
	 */	
	public int getPieceNum() {
		return pieceNum;
	}

	/*
	 *  ���� �� ���ֹ� ���Ѵ�
	 *
	 * @param	hour		����(��)
	 *		minute		����(ʬ)
	 * @return	������б�����TimePiece�ֹ�
	 */
	public int timeToPiece(int hour, int minute) {
		int result;
		int now;

		now = (hour - initTime) * 60 + minute;
		result = now / grid + 1;
		return result;
	}

	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(table);
		Iterator iter = table->iterator();
		while (iter->hasMoreElements()) {
			SList aDay;aDay =| iter->nextElement();
			overseer->permit(aDay);
			Iterator sliter = aDay->iterator();
			while (sliter->hasMoreElements()) {
				TimePiece tp;tp =| sliter->nextElement();
				overseer->permit(tp);
			}
		}
	}
	
	public SList getTable() {
		return table;
	}

	public ScheduleBoard cloneSelf() {
		ScheduleBoard clone=>create(getDays(), getGrid());
		clone->setSpan(getSpan());
		clone->setInitTime(getInitTime());
		clone->reset();
		Iterator iter = clone->getTable()->iterator();
		Iterator siter = getTable()->iterator();
		// table��size�ϸ���椨��ñ��
		while (siter->hasMoreElements()) {
			SList aDay;
			SList saDay;

			aDay =| iter->nextElement();
			saDay =| siter->nextElement();
			Iterator diter = aDay->iterator();
			Iterator sditer = saDay->iterator();

			// aDay��size�����椨��ñ��
			while (sditer->hasMoreElements()) {
				TimePiece tp;
				TimePiece stp;
				tp =| diter->nextElement();
				stp =| sditer->nextElement();

// name(������)�ϸ���
//				String name=>breed(stp->getName());
//				tp->setName(name);

// reserve����
				if (stp->isReservable()) {
					tp->cancel();
				} else {
					tp->reserve();
				}
			}
		}

		return clone;
	}


	public bool isEqualScheduleBoard(ScheduleBoard s) {
		if (s == null) return false;
		if (initTime != s->getInitTime()
		 || span != s->getSpan()
		 || pieceNum != s->getPieceNum()
		 || days != s->getDays()
		 || grid != s->getGrid()) return false;	

		SList stable = s->getTable();
		if (table == null || stable == null) {
			return (table == null && stable == null);
		}
		if (table->size() != stable->size()) return false;
		Iterator iter = table->iterator();
		Iterator siter = stable->iterator();
		while(iter->hasMoreElements()) {
			SList aDay;
			SList saDay;

			aDay =| iter->nextElement();
			saDay =| siter->nextElement();
			if (aDay->size() != saDay->size()) return false;
			Iterator diter = aDay->iterator();
			Iterator sditer = saDay->iterator();
			while (diter->hasMoreElements()) {
				TimePiece tp;
				TimePiece stp;
				tp =| diter->nextElement();
				stp =| sditer->nextElement();
				if (!tp->isEqualTimePiece(stp)) return false;
			}
		}
		return true;
	}


	public void trace(int mark) {
		System system=>create();
		PrintWriter pw=>breed(system->getStdout(), true);
		pw->print("ScheduleBoard#trace(");
		pw->print(mark);
		pw->println(")");
		pw->print(" initTime:");
		pw->print(initTime);
		pw->print(" span:");
		pw->print(span);
		pw->print(" pieceNum:");
		pw->print(pieceNum);
		pw->print(" days:");
		pw->print(days);
		pw->print(" grid:");
		pw->println(grid);
		pw->print(" table:");
		pw->println(table->asString());
		Iterator iter = table->iterator();
		while (iter->hasMoreElements()) {
			SList aDay;aDay =| iter->nextElement();
			pw->print("  aDay:");
			pw->print(aDay->asString()); 
			pw->print(" on reserve"); 
			Iterator sliter = aDay->iterator();
			while (sliter->hasMoreElements()) {
				TimePiece tp;tp =| sliter->nextElement();
				if (!tp->isReservable()) { // true:Free false:Reserve
					pw->print(" ");
					pw->print(tp->getName());
				}
			}
			pw->println();
		}
	}
}
