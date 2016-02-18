class Quit : *ActionListener
{
	MyDialog mydialog;

	// Constructor of the class "Quit"
	new create(MyDialog dlg, EventDispatchingQueue q) {
		super=>newActionListener(q);
		mydialog = dlg;
	}

	// Invoked when button click actions occur. 
	public void actionPerformed(ActionEvent event) {
		if ( event->getActionCommand()->compareTo("OK")==0 ) {
			mydialog->dispose();
			mydialog->setVisible(false);  // Hide this mydialog dialog
			stopCell();                   // Quit mydialog the application
		}
		else
		{
			mydialog->dispose();
			mydialog->setVisible(false);  // Hide this mydialog dialog
		}
	}
}
