cell Test
{
	MyDialog myDlg;

	// initialize the global object.
	public void initialize() {
		super->initialize();
		myDlg=>create();
		myDlg->setVisible(true);
	}

	// go the global object.
	public void go() {
		EventDispatchingQueue queue => create();
		myDlg->activateListeners(queue);
		myDlg->setVisible(true);
	}

	// quiet the global object.
	public void quiet() {
		myDlg->deleteListeners();
		flushCell();
	}
}
