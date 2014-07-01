package io.github.brother_daniel.multiTF.GUI;

import io.github.brother_daniel.multiTF.Main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author Brother_Daniel <daniel.fitzgerald@hotmail.ca>
 *
 */

public class StartUpFrame extends JFrame {
	// have no idea what this is but apparently I need it for something?
	private static final long serialVersionUID = -762683396660723682L;

	// components
	JButton btnHost = new JButton("Host", null);
	JButton btnJoin = new JButton("Join", null);

	public StartUpFrame() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle(Main.gameTitle);
		this.setSize(280, 100);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		setUpComponents();
		this.setVisible(true);
	}

	private void setUpComponents() {
		GridLayout gbl = new GridLayout(0, 1, 2, 2);

		btnHost.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				NewHostFrame newHost = new NewHostFrame();
				close();
			}
		});
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				ClientJoinFrame joinFrame = new ClientJoinFrame();
				close();
			}
		});
		
		this.setLayout(gbl);
		this.add(btnHost);
		this.add(btnJoin);
	}
	
	private void close() {
		this.dispose();
	}

}
