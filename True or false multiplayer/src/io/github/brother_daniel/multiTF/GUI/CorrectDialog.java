package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;
import io.github.brother_daniel.multiTF.socket.Client;
import io.github.brother_daniel.multiTF.socket.Host;

import javax.swing.JDialog;
import javax.swing.JLabel;


// TODO Work on this class!
public class CorrectDialog extends JDialog implements Runnable {
	private static final long serialVersionUID = 2102045214879430223L;

	JLabel lbWrongCorrect;
	
	Thread thread = new Thread(this);
	
	public CorrectDialog(Client client, boolean isCorrect) {
		setUpFrame();
		setUpComponents(isCorrect);
		setVisible(true);
		thread.start();
	}
	
	public CorrectDialog(Host host, boolean isCorrect) {
		setUpFrame();
		setUpComponents(isCorrect);
		setVisible(true);
		thread.start();
	}
	
	private void setUpFrame() {
		setTitle(Main.gameTitle);
		setSize(250, 100);
		setResizable(false);
		setLocationRelativeTo(null);
	}
	
	private void setUpComponents(boolean isCorrect) {
		if(isCorrect){
			lbWrongCorrect = new JLabel("CORRECT!", JLabel.CENTER);
//			lbWrongCorrect.setText("CORRECT!");
//			lbWrongCorrect.setAlignmentX(CENTER_ALIGNMENT);
//			lbWrongCorrect.setAlignmentY(CENTER_ALIGNMENT);
		} else {
			lbWrongCorrect = new JLabel("INCORRECT!", JLabel.CENTER);
//			lbWrongCorrect.setText("INCORRECT!");
//			lbWrongCorrect.setAlignmentX(CENTER_ALIGNMENT);
//			lbWrongCorrect.setAlignmentY(CENTER_ALIGNMENT);
		}
		add(lbWrongCorrect);
	}

	@SuppressWarnings("static-access")
	@Override
	public void run() {
		try {
			thread.sleep(2500);// stop thread for 2.5 seconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		dispose();
	}
	
}
