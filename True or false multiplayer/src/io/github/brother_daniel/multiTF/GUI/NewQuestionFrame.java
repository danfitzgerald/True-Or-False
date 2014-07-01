package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;
import io.github.brother_daniel.multiTF.game.GameClient;
import io.github.brother_daniel.multiTF.game.GameHost;
import io.github.brother_daniel.multiTF.socket.Client;
import io.github.brother_daniel.multiTF.socket.Host;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewQuestionFrame extends JFrame {

	private static final long serialVersionUID = 9095639910189137161L;

	JLabel lbQuestion = new JLabel("Enter question:");
	JTextField txtQuestion = new JTextField();
	JLabel lbTrueFalse = new JLabel("What is the answer?");
	JPanel trueFalsePanel = new JPanel();
	JRadioButton radioTrue = new JRadioButton("True");
	JRadioButton radioFalse = new JRadioButton("False");
	JButton btnDone = new JButton("Done");

	private void setUpFrame() {
		setTitle(Main.gameTitle);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 150);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public NewQuestionFrame(final Client client) {
		try {
			client.hideWaitingFrame();
		} catch (Exception e) {
			// System.out.println("Unable to close waiting frame!");
		}
		setUpFrame();
		setUpComponents();
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean answer;
				if (radioTrue.isSelected()) {
					answer = true;
				} else {
					answer = false;
				}
				GameClient.sendQuestion(client, txtQuestion.getText(), answer);
				// @SuppressWarnings("unused")
				// WaitingFrame wf = new WaitingFrame(client);
				dispose();
			}
		});
		setVisible(true);
	}

	public NewQuestionFrame(final Host host) {
		setUpFrame();
		setUpComponents();
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean answer;
				if (radioTrue.isSelected()) {
					answer = true;
				} else {
					answer = false;
				}
				GameHost.submitQuestion(host, txtQuestion.getText(), answer);
				// @SuppressWarnings("unused")
				// WaitingFrame wf = new WaitingFrame(host);
				dispose();
			}
		});
		setVisible(true);
	}

	private void setUpComponents() {
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(4);
		setLayout(gl);
		add(lbQuestion);
		add(txtQuestion);
		trueFalsePanel.add(radioTrue, BorderLayout.EAST);
		trueFalsePanel.add(radioFalse, BorderLayout.WEST);
		add(trueFalsePanel);
		add(btnDone);

		radioTrue.setSelected(true);
		radioTrue.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				radioTrue.setSelected(true);
				radioFalse.setSelected(false);
			}
		});
		radioFalse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				radioFalse.setSelected(true);
				radioTrue.setSelected(false);
			}
		});
	}

}
