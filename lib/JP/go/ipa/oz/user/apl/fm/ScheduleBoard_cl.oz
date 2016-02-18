/*
 * $Id: ScheduleBoard.oz,v 1.2 1998/02/02 03:40:09 hgoto Exp $
 */

class ScheduleBoard {
	/*
	 * 予約される実体の予約表に関する管理を行う
	 */
	int	initTime;
	int	span;
	int	pieceNum;
	int	days;
	int	grid;
	SList	table;
	

	new create(int date, int gd) {
		table=>create(); // 比較しないのでデフォルトComparator
		initTime = 8;
		span = 12;
		grid = gd;
		days = date;
		
		setTable();
	}
	
	/*
	 * 予約表を作り直す
	 */
	public void reset() {
		table=>create();
		setTable();
	}
	
	/*
	 * 予約表を作成する
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
	 * 時間枠の総数を計算する
	 */
	protected void setPieceNum() {
		pieceNum = span * 60 / grid;
	}

	/*
	 * 一日分の時間枠を作る
	 *
	 * @return	一日分のTimePieceの並び
	 */
	protected SList makeADay() {
		SList aDay;
		aDay=>create();	// 比較しないのでデフォルトComparator
		for(int j=0;j<pieceNum;j++) {
			TimePiece aPiece;
			aPiece = makeATimePiece(j);
			aDay->pushBack(aPiece);
		}
		return aDay;
	}

	/*
	 * 1つの時間枠を作る
	 *
	 * @param	number		枠番号
	 * @return	1つ分の時間枠
	 */
	protected TimePiece makeATimePiece(int number) {
		TimePiece aPiece;
		aPiece => create();

		aPiece->setName(makePieceLabel(number));
		return aPiece;
	}

	/*
	 * 時間枠のラベルを作る
	 *
	 * @param	number		枠番号
	 * @return	ラベルの文字列
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
	 * 予約を行う
	 *
	 * @param	res		予約したい時間帯
	 * @return	true		予約成功
	 *		false		予約失敗
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
				// 0時0分終了のとき
				;
			}
		}
		end = timeToPiece(eh, em);

		result = reserve(res->getDay(), start, end);
// trace(1);
		return result;
	}

	/*
	 * 予約を行う
	 * @param	date		予約日
	 *		start		予約開始時刻に対応するTimePieceの番号
	 *		end		予約終了時刻に対応するTimePieceの番号
	 * @return	true		予約成功
	 *		false		予約失敗
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
	 * 予約状況の確認
	 *
	 * @param	res		確認したい時間帯
	 * @return	指定された時間帯のKomaリスト
	 */
	public SList confirm(Reserve res) {
		return getSelectedSchedule(res);
	}
	
	/*
	 * 指定された時間帯のTimePieceリストを取得する
	 *
	 * @param	res		TimePieceリストを取得したい時間帯
	 * @return	指定された時間帯のTimePieceリスト
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
				// 0時0分終了のとき
				;
			}
		}
		end = timeToPiece(eh, em);

		result = getSelectedSchedule(res->getDay(), start, end);

		return result;
		
	}

	/*
	 * 指定された時間帯のTimePieceリストを取得する
	 *
	 * @param	date		指定する日付
	 *		start		開始時刻に対応するTimePieceの番号
	 *		end		終了時刻に対応するTimePieceの番号
	 * @return	指定された時間帯のTimePieceリスト
	 */
	public SList getSelectedSchedule(int date, int start, int end) {
//System system=>create();
//system->println("ScheduleBoard#getSelectedSchedule() date:"->concat(""->valueOf(date)));
//system->println("ScheduleBoard#getSelectedSchedule() start:"->concat(""->valueOf(start)));
//system->println("ScheduleBoard#getSelectedSchedule() end:"->concat(""->valueOf(end)));
		SList days;
		SList result;
		
//system->println("ScheduleBoard#getSelectedSchedule() table:"->concat(table->asString()));
		days =| table->infix(date-1,date)->first();  // 指定された日のリスト取得
//system->println("ScheduleBoard#getSelectedSchedule() days:"->concat(days->asString()));
		result =| days->infix(start-1,end); // 指定範囲のコマを返す


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
	 * 指定された予約のキャンセルを行う
	 *
	 * @param	res		キャンセルする予約
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
	 * 何日分を用意するかの設定
	 *
	 * @param	date		テーブルを用意する日数
	 */
	public void setDays(int date) {
		days = date;
	}

	/*
	 * グリッド幅を設定する
	 *
	 * @param	gd		指定するグリッド幅(分単位)
	 */	
	public void setGrid(int gd) {
		grid = gd;
		setPieceNum();
	}

	/*
	 * 一日分を何時間とするかを決定
	 *
	 * @param	sp		指定する時間
	 *				(デフォルトは12時間)
	 */	
	public void setSpan(int sp) {
		span = sp;
		setPieceNum();
	}
	
	/*
	 * スケジューリング開始時刻の設定
	 *
	 * @param	time		スケジューリング開始時刻
	 *				(デフォルトは8:00)
	 */
	public void setInitTime(int time) {
		initTime = time;
	}

	/*
	 * 何日分のスケジュール表があるかを取得
	 *
	 * @return	日数
	 */	
	public int getDays() {
		return days;
	}
	
	/*
	 * グリッド幅の取得
	 *
	 * @return	グリッド幅
	 */	
	public int getGrid() {
		return grid;
	}
	
	/*
	 * スケジューリングされる時間の取得
	 *
	 * @return	スケジューリングされる時間
	 */	
	public int getSpan() {
		return span;
	}
	
	/*
	 * 一日のスケジューリング開始時刻
	 *
	 * @return	開始時刻
	 */	
	public int getInitTime() {
		return initTime;
	}
	
	/*
	 * 一日分のコマ数の取得
	 *
	 * @return	一日分の枠数
	 */	
	public int getPieceNum() {
		return pieceNum;
	}

	/*
	 *  時刻 → 枠番号 の変換
	 *
	 * @param	hour		時刻(時)
	 *		minute		時刻(分)
	 * @return	時刻に対応するTimePiece番号
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
		// tableのsizeは固定ゆえ簡単に
		while (siter->hasMoreElements()) {
			SList aDay;
			SList saDay;

			aDay =| iter->nextElement();
			saDay =| siter->nextElement();
			Iterator diter = aDay->iterator();
			Iterator sditer = saDay->iterator();

			// aDayのsizeも固定ゆえ簡単に
			while (sditer->hasMoreElements()) {
				TimePiece tp;
				TimePiece stp;
				tp =| diter->nextElement();
				stp =| sditer->nextElement();

// name(時間帯)は固定
//				String name=>breed(stp->getName());
//				tp->setName(name);

// reserve情報
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
