/*
 * $Id: Person.oz,v 1.1 1997/11/28 07:17:51 hgoto Exp $
 */

/*
 * Personは特定の個人をあらわすオブジェクトである。
 */
class  Person : *Actor {
	String bloodType;
	Date birthDay;

	new create() {
		super=>create();
	}

	new create(String nam) {
		super=>create(nam);
	}

	public void init(String btype,Date birth) {
		bloodType = btype;
		birthDay = birth;
	}

	/*
	 * 血液型の取得
	 */
	public String getBloodType() {
		return bloodType;
	}

	/*
	 * 誕生日の取得
	 */
	public Date getBirthDay() {
		return birthDay;
	}

        public bool isEqualFMObject(FMObject obj) {
		// 引数がFMObjectなのは、オーバライドするため
		if (obj == null) return false;
		Person p;p =| obj;
		if (!super->isEqualFMObject(p)) {
			return false;
		}
		String obloodType = p->getBloodType();
		if (bloodType == null) {
			if (obloodType != null) return false;
		} else if (!bloodType->isequal(obloodType)) {
			return false;
		}
		Date obirthDay = p->getBirthDay();
		if (birthDay == null) {
			if (obirthDay != null) return false;
		} else if (!birthDay->isEqualDate(obirthDay)) {
			return false;
		}
		return true;
	}

	public locked int update(FMObject obj) {
		// 引数がFMObjectなのは、オーバライドするため
		Person p;p =| obj;
		int counter = updateWithoutLock(p);
		String obloodType = p->getBloodType();
		if (bloodType == null) {
			if (obloodType != null) {
				bloodType = obloodType;	
				counter++;
			}
		} else if (!bloodType->isequal(obloodType)) {
			bloodType = obloodType;	
			counter++;
		}
		Date obirthDay = p->getBirthDay();
		if (birthDay == null) {
			if (obirthDay != null) {
				birthDay = obirthDay;	
				counter++;
			}
		} else if (!birthDay->isEqualDate(obirthDay)) {
			birthDay = obirthDay;	
			counter++;
		}
		return counter;
	}

	public FMObject cloneSelf() {
		// 型がFMObjectなのは、オーバライドするため
		Person clone=>create(this);
		return clone;
	}

	new create(Person p) {
		super=>create(p);
		String pbloodType = p->getBloodType();
		if (pbloodType != null) {
			bloodType=>breed(getBloodType());
		}
		Date pbirthDay = p->getBirthDay();
		if (pbirthDay != null) {
			birthDay=>breed(pbirthDay->getTime());
		}
	}

	public void trace(int mark) {
		System system=>create();
		PrintWriter pw=>breed(system->getStdout(), true);
		pw->print("Person#trace(");
		pw->print(mark);
		pw->println(")");
		pw->print("bloodType:");
		pw->println(bloodType == null ? "null" : bloodType);
		pw->print("birthDay:");
		pw->println(birthDay == null ? "null" : birthDay->asString());
		pw->println("---- super ----");
		super->trace(mark);
	}
}
