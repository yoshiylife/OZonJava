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
	 * ͽ�󤵤����Τλ�������ͽ������˴ؤ���
	 * ��������򤹤�
	 */

	new create() {
		super=>create();
	}

	/*
	 * ���Τ����η�ӤĤ�
	 *
	 * @param	entity		����
	 */
	public void bindEntity(Schedulable entity) {
		Overseer over=>create();
		over->permit(entity);
		createRelation("Scheduling",entity);
	}

	/*
	 * ���Τ��Ф���ͽ����׵᤹��
	 *
	 * @param	res		ͽ�󤷤���������
	 * @return	true		ͽ������
	 *		false		ͽ����
	 */
	public bool reserve(Reserve res) {
		bool result;
		Schedulable entity;entity =| getRelatedObject("Scheduling");
		result = entity->reserve(res);

		if (!result) return false;

		res->setState("reserve");	// ͽ�����������Ⱦ��֤��Ѥ�
		res->attach(getIdentifier());
		entity->commit();
		commit();
		
		return true;
	}

	/*
	 * ͽ������γ�ǧ��Ԥ�
	 *
	 * @param	res		��ǧ������������
	 * @return	���ꤷ�������Ӥ�Koma�ꥹ��
	 */
	public SList confirm(Reserve res) {
		Schedulable entity;entity =| getRelatedObject("Scheduling");
		return entity->confirm(res);
	}

	/*
	 * ���ꤵ�줿ͽ��β����Ԥ�
	 *
	 * @param	res		����󥻥뤹��ͽ��
	 */
	public void cancel(Reserve res) {
		Schedulable entity;entity =| getRelatedObject("Scheduling");
		entity->cancel(res);
		res->setState("cancel");
		entity->commit();
		commit();
	}

	public FMObject cloneSelf() {
		// ����FMObject�ʤΤϡ������Х饤�ɤ��뤿��
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
