/*
 * $Id: Person.oz,v 1.1 1997/11/28 07:17:51 hgoto Exp $
 */

/*
 * Person������θĿͤ򤢤�魯���֥������ȤǤ��롣
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
	 * ��շ��μ���
	 */
	public String getBloodType() {
		return bloodType;
	}

	/*
	 * �������μ���
	 */
	public Date getBirthDay() {
		return birthDay;
	}

        public bool isEqualFMObject(FMObject obj) {
		// ������FMObject�ʤΤϡ������Х饤�ɤ��뤿��
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
		// ������FMObject�ʤΤϡ������Х饤�ɤ��뤿��
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
		// ����FMObject�ʤΤϡ������Х饤�ɤ��뤿��
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
