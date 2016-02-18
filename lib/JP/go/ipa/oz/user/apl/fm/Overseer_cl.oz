/*
 * $Id: Overseer.oz,v 1.1 1997/11/28 07:17:51 hgoto Exp $
 */

class Overseer {
	new create() {
	}

	public void permit(Root r) {
		if (r != null && r->isRed()) {
			turnGreen(r);
			r->toGreen();
// System system=>create();system->println("Overseer#permit "->concat(r->asString()));
		}
	}	
}
