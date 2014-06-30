package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class EnterNameFrame extends JDialog {

	private static final long serialVersionUID = -776527655205816591L;

	JLabel lbName = new JLabel("Enter a name here:");
	JTextField txtName = new JTextField();
	JButton btnDone = new JButton("Done");

	Boolean isClient = null;

	public void getName(Boolean isClient) {
		this.isClient = isClient;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle(Main.gameTitle);
		setSize(250, 100);
		setResizable(false);
		setLocationRelativeTo(null);

		setUpComponents();
		setVisible(true);
	}

	private void setUpComponents() {
		GridLayout gl = new GridLayout();
		gl.setColumns(1);
		gl.setRows(3);
		gl.setVgap(2);

		setLayout(gl);

		add(lbName);
		add(txtName);
		add(btnDone);
//		btnDone.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (isClient) {
//					// TOD Add join code.
//					System.out.println("I am a client");
//				} else {
//					// TOD Add host code
//					System.out.println("I am a host");
//				}
////				newHostFrame.startHost(txtName.getText());
//			}
//		});
	}
	
//	private void setNkame(String name) {
//		NewHostFrame.settName(name);
//	}

}
