package io.github.brother_daniel.multiTF.socket;

import io.github.brother_daniel.multiTF.GUI.WaitingFrame;
import io.github.brother_daniel.multiTF.game.GameClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {

	Socket sock;
	BufferedReader br;
	PrintStream pr;
	Thread thread = new Thread(this);
	WaitingFrame wf;

	public void startClient(String host, int port) {
		try {
			sock = new Socket(host, port);
			pr = new PrintStream(sock.getOutputStream());
			br = new BufferedReader(
					new InputStreamReader(sock.getInputStream()));
			thread.start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendMsg(String msg) {
		pr.println(msg);
		// System.out.println("[Chat] " + msg);
	}

	private void checkMessages() throws IOException {
		// while (true) {

		String tm = br.readLine();
		// System.out.println(tm);
		GameClient.msgReceived(tm, this);
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

	public void showWaitingFrame() {
		wf = new WaitingFrame(this);
	}

	public void hideWaitingFrame() {
		wf.dispose();
		// System.out.println("Client closed a waiting frame.");
	}

	public boolean isWaitingFrameVisible() {
		if (wf != null)
			return false;
		else
			return true;
	}

}
