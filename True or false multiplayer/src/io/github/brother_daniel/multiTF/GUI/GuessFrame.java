package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;
import io.github.brother_daniel.multiTF.game.GameClient;
import io.github.brother_daniel.multiTF.game.GameHost;
import io.github.brother_daniel.multiTF.socket.Client;
import io.github.brother_daniel.multiTF.socket.Host;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GuessFrame extends JFrame {

	private static final long serialVersionUID = -1808887732251865876L;

	JLabel emptyLabel = new JLabel();
	JLabel lbQuestion = new JLabel("quest to find a tion", JLabel.CENTER);
	JButton btnTrue = new JButton("True");
	JButton btnFalse = new JButton("False");

	boolean isClient;

	public void setupFrame() {
		setTitle(Main.gameTitle);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		this.setSize(600, 350);
		setResizable(false);
		setLocationRelativeTo(null);

	}

	public GuessFrame(final Client client, String question) {
		try {
			client.hideWaitingFrame();
		} catch (Exception e) {
			// System.out.println("Unable to close waiting frame!");
		}
		setupFrame();
		setUpComponents();
		lbQuestion.setText(question);
		btnTrue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				WaitingFrame wf = new WaitingFrame(client);
				GameClient.sendTrue(client);
				dispose();
			}
		});
		btnFalse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				WaitingFrame wf = new WaitingFrame(client);
				GameClient.sendFalse(client);
				dispose();
			}
		});
		this.setVisible(true);
	}

	public GuessFrame(final Host host, String question) {
		setupFrame();
		setUpComponents();
		lbQuestion.setText(question);
		btnTrue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// @SuppressWarnings("unused")
				// WaitingFrame wf = new WaitingFrame(host);
				GameHost.answerTrue(host);
				dispose();
			}
		});
		btnFalse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// @SuppressWarnings("unused")
				// WaitingFrame wf = new WaitingFrame(host);
				GameHost.answerFalse(host);
				dispose();
			}
		});
		this.setVisible(true);
	}

	private void setUpComponents() {
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(3);
		// gl.setHgap(100);
		gl.setVgap(5);
		this.setLayout(gl);

		this.add(lbQuestion);
		this.add(btnTrue);
		this.add(btnFalse);
	}

}
