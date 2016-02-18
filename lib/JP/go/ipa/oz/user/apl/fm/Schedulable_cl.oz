/*
 * $Id: Schedulable.oz,v 1.2 1998/02/02 03:40:08 hgoto Exp $
 */

class Schedulable : *FMObject {
	/* 
	 * 予約対象となる実体(例：部屋)
	 * この実体の持つ役割(例：会議室)は
	 * Schedulerが担う
	 */

	ScheduleBoard	board;

	new create() {
		super=>create();
		board=>create(30,15);	// 30日、15分刻み
	}

	/*
	 * 実体に対する予約を行う
	 *
	 * @param	res		予約情報を持つオブジェクト
	 * @return	true		予約成功
	 *		false		予約失敗
	 */
	public locked bool reserve(Reserve res) {
		return board->reserve(res);
	}

	/*
	 * 実体の予約状況の確認を行う
	 *
	 * @param	res		確認したい時間帯
	 * @return	指定した時間帯のKomaリスト
	 */
	public locked SList confirm(Reserve res) {
		return board->confirm(res);
	}

	/*
	 * 指定された実体の予約を解除する
	 *
	 * @param	res		キャンセルする予約
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

			// tableのsizeは固定ゆえ簡単に
			while (iter->hasMoreElements()) {
				SList aDay;
				SList saDay;

				aDay =| iter->nextElement();
				saDay =| siter->nextElement();
				Iterator diter = aDay->iterator();
				Iterator sditer = saDay->iterator();

				// aDayのsizeも固定ゆえ簡単に
				while (diter->hasMoreElements()) {
					TimePiece tp;
					TimePiece stp;
					tp =| diter->nextElement();
					stp =| sditer->nextElement();
// name(時間帯)は固定だからreserve情報のみを比較更新すればよい。
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
		// 引数がFMObjectなのは、オーバライドするため
//System system=>create();
//system->println("Schedulable#update() START");
		Schedulable sch;sch =| obj;
		int counter = updateWithoutLock(sch);

// ここでboardを更新する。順序に意味があるのでdifferenceは使えない。
// サイズ固定だから、メンバを順に比較更新できる。
// reserve情報以外は、一致しているのでreserve情報のみを対象とする。

		if (board != null) {
			counter += boardUpdate(sch);
		}
//system->println("Schedulable#update() END");

		return counter;
	}

	public FMObject cloneSelf() {
		// 型がFMObjectなのは、オーバライドするため
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
