package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;
import io.github.brother_daniel.multiTF.socket.Client;
import io.github.brother_daniel.multiTF.socket.Host;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WaitingFrame extends JFrame {

	private static final long serialVersionUID = 2517542711341067860L;
	
	JLabel lbWating = new JLabel("Wating...", JLabel.CENTER);

	public WaitingFrame(Client client) {
		setUpFrame();
		setUpComponents();
		setVisible(true);
		System.out.println("client opened a waiting frame");
	}
	
	public WaitingFrame(Host host) {
		setUpFrame();
		setUpComponents();
		setVisible(true);
		System.out.println("host opened a waiting frame");
	}
	
	private void setUpFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 100);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle(Main.gameTitle);
	}
	
	private void setUpComponents() {
		add(lbWating);
	}
	
}
