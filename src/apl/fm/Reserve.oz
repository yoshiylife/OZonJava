/*
 Copyright(c) 1996-1998
 IPA, ETL, AT21, FSIABC, FXIS, InArc, MRI, NUL, SBC, Sharp, TEC, TIS

 All rights reserved.  No guarantee.
 This technology is a result of the Advanced Software  Enrichment 
 Project of Information-technology Promotion Agency, Japan (IPA).

 Permissions  to  use,  copy, modify and distribute this software
 are governed by the terms and conditions set forth in  the  file 
 COPYRIGHT, located on the top directory of this software.
 */

/*
 * $Id: Reserve.oz,v 1.1 1997/11/28 07:17:52 hgoto Exp $
 */

class Reserve : *Relation {
	/*
	 * ���������24����ɽ���ǰ�����
	 */
	int	day;
	int	startHour;
	int	endHour;
	int	startMinute;
	int	endMinute;
	int	state;	// 0 - prereserve, 1 - reserve, 2 - cancel, 3 - void
	
	new create() {
		super=>create();
		setName("Unknown Reserve");
		setState("prereserve");
	}

	new create(String nam) {
		super=>create();
		setName(nam);
		setState("prereserve");
	}
	
	/*
	 * ͽ���������ꤹ��
	 *
	 * @param	date		ͽ����
	 *		sh		���ϻ����
	 *		sm		���ϻ��ʬ
	 *		eh		��λ�����
	 *		em		��λ���ʬ
	 */
	public void setReserve(int date, int sh, int sm, int eh, int em) {
		day = date;
		startHour = sh;
		startMinute = sm;
		endHour = eh;
		endMinute = em;
	}

	public void init(int date, int sh, int sm, int eh, int em) {
		setReserve(date, sh, sm, eh, em);
	}

	/*
	 * ͽ����������
	 *
	 * @param	date		ͽ����
	 */
	public void setDay(int date) {
		day = date;
	}

	/*
	 * ���ϻ���(��)������
	 *
	 * @param	st		���ϻ���(��)
	 */
	public void setStartHour(int st) {
		startHour = st;
	}

	/*
	 * ��λ����(��)������
	 *
	 * @param	ed		��λ����(��)
	 */
	public void setEndHour(int ed) {
		endHour = ed;
	}

	/*
	 * ���ϻ���(ʬ)������
	 *
	 * @param	st		���ϻ���(ʬ)
	 */
	public void setStartMinute(int st) {
		startMinute = st;
	}

	/*
	 * ��λ����(ʬ)������
	 *
	 * @param	ed		��λ����(ʬ)
	 */
	public void setEndMinute(int ed) {
		endMinute = ed;
	}

	/*
	 * ͽ�����μ���
	 *
	 * @return	ͽ����
	 */
	public int getDay() {
		return day;
	}

	/*
	 * ���ϻ���(��)�μ���
	 *
	 * @return	���ϻ���(��)
	 */
	public int getStartHour() {
		return startHour;
	}

	/*
	 * ��λ����(��)�μ���
	 *
	 * @return	��λ����(��)
	 */
	public int getEndHour() {
		return endHour;
	}

	/*
	 * ���ϻ���(ʬ)�μ���
	 *
	 * @return	���ϻ���(ʬ)
	 */
	public int getStartMinute() {
		return startMinute;
	}

	/*
	 * ��λ����(ʬ)�μ���
	 *
	 * @return	��λ����(ʬ)
	 */
	public int getEndMinute() {
		return endMinute;
	}

	/*
	 * ���ߤ�ͽ��Υ���󥻥�
	 */
	public void cancel() {
		Scheduler sch;
		
		sch =| dst->stuff();
		sch->cancel(this);
	}

	/*
	 * ���֤�����
	 *
	 * @param	stat		���֤�ɽ���ѥ�᡼��
	 */
	public void setState(int stat) {
		state = stat;
	}

	/*
	 * ���֤�����
	 *
	 * @param	stat		���֤�ɽ��ʸ����
	 *				prereserve	��ͽ��
	 *				reserve		ͽ����
	 *				cancel		����󥻥��
	 *				����ʳ�	void
	 */
	public void setState(String stat) {
		if (stat->equalsIgnoreCase("prereserve")) {
			setState(0);
		} else if (stat->equalsIgnoreCase("reserve")) {
			setState(1);
		} else if (stat->equalsIgnoreCase("cancel")) {
			setState(2);
		} else {
			setState(3);
		}
	}

	public void trace(int mark) {
		System system=>create();
		system->println("Reserve#trace("
			->concat(""->valueOf(mark))->concat(")")
			->concat(" day:")->concat(""->valueOf(day))
			->concat(" start:")->concat(""->valueOf(startHour))
			->concat(":")->concat(""->valueOf(startMinute))
			->concat(" end:")->concat(""->valueOf(endHour))
			->concat(":")->concat(""->valueOf(endMinute)));
		system->println("---- super ----");
		super->trace(mark);
	}
}
