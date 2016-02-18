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
 * $Id: Scheduler.oz,v 1.2 1998/02/02 03:40:09 hgoto Exp $
 */

class Scheduler : *FMObject {
	/*
	 * 予約される実体の持つ役割と予約処理に関する
	 * 窓口の役割をする
	 */

	new create() {
		super=>create();
	}

	/*
	 * 実体と役割の結びつけ
	 *
	 * @param	entity		実体
	 */
	public void bindEntity(Schedulable entity) {
		Overseer over=>create();
		over->permit(entity);
		createRelation("Scheduling",entity);
	}

	/*
	 * 実体に対する予約を要求する
	 *
	 * @param	res		予約したい時間帯
	 * @return	true		予約成功
	 *		false		予約失敗
	 */
	public bool reserve(Reserve res) {
		bool result;
		Schedulable entity;entity =| getRelatedObject("Scheduling");
		result = entity->reserve(res);

		if (!result) return false;

		res->setState("reserve");	// 予約に成功すると状態が変る
		res->attach(getIdentifier());
		entity->commit();
		commit();
		
		return true;
	}

	/*
	 * 予約状況の確認を行う
	 *
	 * @param	res		確認したい時間帯
	 * @return	指定した時間帯のKomaリスト
	 */
	public SList confirm(Reserve res) {
		Schedulable entity;entity =| getRelatedObject("Scheduling");
		return entity->confirm(res);
	}

	/*
	 * 指定された予約の解除を行う
	 *
	 * @param	res		キャンセルする予約
	 */
	public void cancel(Reserve res) {
		Schedulable entity;entity =| getRelatedObject("Scheduling");
		entity->cancel(res);
		res->setState("cancel");
		entity->commit();
		commit();
	}

	public FMObject cloneSelf() {
		// 型がFMObjectなのは、オーバライドするため
		Scheduler clone=>create(this);
		return clone;
	}

	new create(Scheduler s) {
		super=>create(s->getName(), s->getAllRelations(), s->getIdentifier());
	}

	public void trace(int mark) {
		System system=>create();
		PrintWriter pw=>breed(system->getStdout(), true);
		pw->print("Scheduler#trace(");
		pw->print(mark);
		pw->println(")");
		pw->println("---- super ----");
		super->trace(mark);
	}
}
