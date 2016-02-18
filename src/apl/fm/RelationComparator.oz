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
 * $Id: RelationComparator.oz,v 1.1 1997/11/28 07:17:52 hgoto Exp $
 */

class RelationComparator : Comparator {
	new create() {
	}

	public bool compare(Root rel1, Root rel2) {
		Relation r1, r2;
		r1 =| rel1;
		r2 =| rel2;
		return r1->isEqualRelation(r2);
	}

	public int hash(Root rel) {

		StringComparator sc=>create();
		StringBuffer sb, sbsrc, sbdst;
		Relation r;

		r =| rel;
		sb=>breed(r->getName());
		sbsrc=>breed();
		sbdst=>breed();

		Pointer src = r->getSource();
		if (src != null) {
			sbsrc=>breed(src->getLocation());
			sbsrc->append(src->getName());
		}

		Pointer dst = r->destination();
		if (dst != null) {
			sbdst=>breed(dst->getLocation());
			sbdst->append(dst->getName());
		}

		if ((sc->hash(sbsrc->asString())) <= (sc->hash(sbdst->asString()))) {
		// メソッド呼び出しを括弧づけしないとboolにならないozcの制限
			sb->append(sbsrc);
			sb->append(sbdst);
			return sc->hash(sb->asString());
		} else {
			sb->append(sbdst);
			sb->append(sbsrc);
			return sc->hash(sb->asString());
		}
	}

	public Comparator duplicate() {
		RelationComparator rc=>create();
		return rc;
	}

}
