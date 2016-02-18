class MyDialog : *Frame
{
	Button btnYes;
	Button btnNo;
	Label lblMessage;
	Quit	quit;
	EventDispatchingQueue queue;

	new create()
	{
		super=>newFrame();

		//INIT CONTROLS
		BorderLayout border=>newBorderLayout();
		setLayout(border);
		addNotify();
		setSize(210,140);
		Font font=>newFont("TimesRoman", 12);
		FlowLayout flow1=>newFlowLayout();
		Panel panel1=>newPanel(flow1);
		add("Center", panel1);
		lblMessage=>newLabel("Hello!");
		lblMessage->setFont(font);
		panel1->add(lblMessage);

		FlowLayout flow2=>newFlowLayout(1,20,20);	//1:CENTER
		Panel panel2=>newPanel(flow2);
		add("South", panel2);
		panel2->addNotify();
		btnYes=>newButton("OK");
		btnYes->setFont(font);
		panel2->add(btnYes);
		btnNo=>newButton("Cancel");
		btnNo->setFont(font);
		panel2->add(btnNo);

		setTitle("My Dialog");

		//Resister Listeners
		queue => create();
		activateListeners(queue);
	}

	public void setVisible(boolean b) {
    	setLocation(100, 100);
    	super->setVisible(b);
    }

	public void deleteListeners() {
		if (! queue->isDestroyed()) queue->destroy();
		queue = null;
		btnYes->removeActionListener(quit);
		btnNo->removeActionListener(quit);
		quit = null;
	}

	public void activateListeners(EventDispatchingQueue queue) {
		quit=>create(this, queue);
		btnYes->addActionListener(quit);
		btnNo->addActionListener(quit);
	}

}
