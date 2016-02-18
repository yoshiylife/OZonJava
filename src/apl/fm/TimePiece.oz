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
 * $Id: TimePiece.oz,v 1.1 1997/11/28 07:17:52 hgoto Exp $
 */

class TimePiece {
	/*
	 * 予約表の時間単位
	 */

	String	name;
	bool reservable;
	
	new create() {
		reservable = true;
		name=>breed("NoTime");
	}
	
	public void setName(String nam) {
		name = nam;
	}

	public String getName() {
		return name;
	}

	/*
	 * この枠を予約する(予約不可能状態にする)
	 */
	public void reserve() {
		reservable = false;
	}
	
	/*
	 * この枠の予約をキャンセルする(予約可能状態にする)
	 */
	public void cancel() {
		reservable = true;
	}

	/*
	 * この枠が予約可能であるかを返す
	 *
	 * @return	true		予約可能
	 *		false		予約不可能
	 */
	public bool isReservable() {
		return reservable;
	}
	
	public bool isEqualTimePiece(TimePiece t) {
		if (t == null) return false;
		if (reservable != t->isReservable()) return false;

		String tname = t->getName();
		if (name == null || tname == null) {
			return (name == null && tname == null);
		}	
		return name->isequal(tname);
	}

	public void toGreen() {
		Overseer overseer=>create();
		overseer->permit(name);
	}
}
