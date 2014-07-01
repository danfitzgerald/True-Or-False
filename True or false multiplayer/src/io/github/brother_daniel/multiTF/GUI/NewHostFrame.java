package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;
import io.github.brother_daniel.multiTF.game.GameHost;
import io.github.brother_daniel.multiTF.socket.Host;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class NewHostFrame extends JFrame {

	private static final long serialVersionUID = -8551204262913015642L;

	public String name = "Annonymous";

	JLabel lbPort = new JLabel("Enter port number:");
	JTextField txtPort = new JTextField();
	JButton btnHost = new JButton("Host");
	Host host = new Host();

	public NewHostFrame() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle(Main.gameTitle);
		this.setSize(300, 150);
		setResizable(false);
		setLocationRelativeTo(null);

		setUpComponents();
		setVisible(true);
	}

	private void setUpComponents() {
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(3);
		gl.setHgap(10);
		gl.setVgap(10);
		setLayout(gl);

		add(lbPort);
		add(txtPort);
		add(btnHost);
		btnHost.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TOD Add code to start host here...

				// EnterNameFrame enterNameFrame = new EnterNameFrame();
				// enterNameFrame.getName(false);

				// GameHost.newGame(host);
				startHost(null);
				// dispose();
			}
		});
	}

	// public void settName(String name) {
	// this.name = name;
	// }

	public void startHost(String name) {
		this.name = name;

		// System.out.println("starting host");

		int port = Integer.parseInt(txtPort.getText());
		host.startHost(port);
		GameHost.newGame(host);

		dispose(); // this line must be last!
	}

}
