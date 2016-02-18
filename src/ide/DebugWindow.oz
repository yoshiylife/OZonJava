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

cell DebugWindow {

	/**************
	 * ATTRIBUTES *
	 **************/
	Frame frame;
	TextArea txtInfo;
	Button btnOK;
	DebugActionListener debugCtrl;
	EventDispatchingQueue queue;

	/****************
	 * CONSTRUCTORS *
	 ****************/
	// Constructor of the class "DebugWindow"
	public void initialize() {

		//INIT CONTROLS
		frame => newFrame();
		frame->setLocation(300,100);
		BorderLayout border=>newBorderLayout();
		frame->setLayout(border);
		frame->addNotify();
		frame->setSize(500, 500);
		txtInfo=>newTextArea(30, 120);
		frame->add("Center", txtInfo);
		btnOK=>newButton("OK");
		FlowLayout flow=>newFlowLayout();
		Panel panel=>newPanel(flow);
		frame->add("South", panel);
		panel->addNotify();
		panel->add(btnOK);
		frame->setTitle("Debug Print Message");

		//Resister Listeners
		queue => create();
		debugCtrl=>create(frame, queue);
		btnOK->addActionListener(debugCtrl);

		frame->setVisible(true);
	}

	public void go() {
		queue => create();
		debugCtrl=>create(frame, queue);
		btnOK->addActionListener(debugCtrl);
		frame->setVisible(true);
	}

	public void quiet() {
		if (! queue->isDestroyed()) queue->destroy();
		queue = null;
		btnOK->removeActionListener(debugCtrl); debugCtrl = null;
		frame->setVisible(false);
		flushCell();
	}

	public locked void println(String message) {
		txtInfo->append(message);
		txtInfo->append("\n");
	}
}
