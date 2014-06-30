package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;
import io.github.brother_daniel.multiTF.game.GameClient;
import io.github.brother_daniel.multiTF.socket.Client;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ClientJoinFrame extends JFrame {

	private static final long serialVersionUID = -8437057452250832791L;

	// components
	JLabel lbAddress = new JLabel("Enter IP Address of host:");
	JTextField txtAddress = new JTextField();

	JLabel lbPort = new JLabel("Enter Port Number:");
	JTextField txtPort = new JTextField();

	JButton btnConnect = new JButton("Connect");

	Client client = new Client();

	public ClientJoinFrame() {
		this.setTitle(Main.gameTitle);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 200);
		setResizable(false);
		setLocationRelativeTo(null);
		this.setResizable(false);

		setUpComponents();
		this.setVisible(true);
	}

	private void setUpComponents() {
		GridLayout gl = new GridLayout(5, 1, 10, 1); // to position components
		this.setLayout(gl);

		this.add(lbAddress);
		this.add(txtAddress);
		this.add(lbPort);
		this.add(txtPort);

		this.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				EnterNameFrame enterNameFrame = new EnterNameFrame();
//				enterNameFrame.getName(true);

				int port = Integer.parseInt(txtPort.getText());
				client.startClient(txtAddress.getText(), port);
				GameClient.joinGame(client);
//				listenWhoGoesFirst();

				close();
			}
		});
	}

	private void close() {
		this.dispose();
	}

//	private void listenWhoGoesFirst() {
//		boolean contWhile = false;
//		while (contWhile) {
//			
//		}
//	}

}
