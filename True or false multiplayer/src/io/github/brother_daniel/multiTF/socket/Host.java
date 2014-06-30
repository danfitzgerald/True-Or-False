package io.github.brother_daniel.multiTF.socket;

import io.github.brother_daniel.multiTF.GUI.WaitingFrame;
import io.github.brother_daniel.multiTF.game.GameHost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Host implements Runnable {

	static Socket sock;
	static ServerSocket servSock;
	static BufferedReader br;
	static PrintStream pr;
	Thread thread = new Thread(this);
	WaitingFrame wf;
	
	// public variables
	public boolean answer;

	public void startHost(int port) {
		try {
			servSock = new ServerSocket(port);
			sock = servSock.accept();
			pr = new PrintStream(sock.getOutputStream());
			br = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			thread.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void checkMessages() throws IOException {
		// while (true) {

		String tm = br.readLine();
		sendMsg(tm);
		System.out.print(tm);
		GameHost.msgReceived(tm, this);
		// }
	}

	@Override
	public void run() {
		Boolean running = true;
		while (running) {
			try {
				checkMessages();
			} catch (IOException e) {
				System.out
						.println("There was an error so I'll stop the thread");
				e.printStackTrace();
				running = false;
			}
		}
	}

	public void sendMsg(String msg) {
		pr.println(msg);
		// System.out.println("[Chat] " + msg);
	}
	
	public void showWaitingFrame() {
		wf = new WaitingFrame(this);
	}
	
	public void hideWaitingFrame(){
		wf.dispose();
	}
	
	public boolean isWaitingFrameVisible(){
		if(wf != null)
			return false;
		else
			return true;
	}

}
