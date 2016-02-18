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
	 * 時刻は全て24時間表記で扱う。
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
	 * 予約情報を設定する
	 *
	 * @param	date		予約日
	 *		sh		開始時刻：時
	 *		sm		開始時刻：分
	 *		eh		終了時刻：時
	 *		em		終了時刻：分
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
	 * 予約日の設定
	 *
	 * @param	date		予約日
	 */
	public void setDay(int date) {
		day = date;
	}

	/*
	 * 開始時刻(時)の設定
	 *
	 * @param	st		開始時刻(時)
	 */
	public void setStartHour(int st) {
		startHour = st;
	}

	/*
	 * 終了時刻(時)の設定
	 *
	 * @param	ed		終了時刻(時)
	 */
	public void setEndHour(int ed) {
		endHour = ed;
	}

	/*
	 * 開始時刻(分)の設定
	 *
	 * @param	st		開始時刻(分)
	 */
	public void setStartMinute(int st) {
		startMinute = st;
	}

	/*
	 * 終了時刻(分)の設定
	 *
	 * @param	ed		終了時刻(分)
	 */
	public void setEndMinute(int ed) {
		endMinute = ed;
	}

	/*
	 * 予約日の取得
	 *
	 * @return	予約日
	 */
	public int getDay() {
		return day;
	}

	/*
	 * 開始時刻(時)の取得
	 *
	 * @return	開始時刻(時)
	 */
	public int getStartHour() {
		return startHour;
	}

	/*
	 * 終了時刻(時)の取得
	 *
	 * @return	終了時刻(時)
	 */
	public int getEndHour() {
		return endHour;
	}

	/*
	 * 開始時刻(分)の取得
	 *
	 * @return	開始時刻(分)
	 */
	public int getStartMinute() {
		return startMinute;
	}

	/*
	 * 終了時刻(分)の取得
	 *
	 * @return	終了時刻(分)
	 */
	public int getEndMinute() {
		return endMinute;
	}

	/*
	 * 現在の予約のキャンセル
	 */
	public void cancel() {
		Scheduler sch;
		
		sch =| dst->stuff();
		sch->cancel(this);
	}

	/*
	 * 状態の設定
	 *
	 * @param	stat		状態を表すパラメータ
	 */
	public void setState(int stat) {
		state = stat;
	}

	/*
	 * 状態の設定
	 *
	 * @param	stat		状態を表す文字列
	 *				prereserve	仮予約
	 *				reserve		予約中
	 *				cancel		キャンセル済
	 *				それ以外	void
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
