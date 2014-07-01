package io.github.brother_daniel.multiTF;

import io.github.brother_daniel.multiTF.GUI.StartUpFrame;

/**
 * 
 * @author Brother_Daniel <daniel.fitzgerald@hotmail.ca>
 *
 */

public class Main {

	public static String gameTitle = "True & False Multiplayer";
	static StartUpFrame startUp;

	public static void main(String[] args) {
		startUp = new StartUpFrame();
//		Client client = new Client();
//		@SuppressWarnings("unused")
//		CorrectDialog cd = new CorrectDialog(client, true);
//		cd = new CorrectDialog(new Client(), false);
		
//		startChat();
	}

	
//	static Client client = new Client();
//	static Host host = new Host();
//	private static void startChat() {
//		Scanner sc = new Scanner(System.in);
//		if (sc.nextLine().equals("a")) {
//			System.out.println("Starting client");
//			client.startClient("localhost", 8888);
//			client.sendMsg("hi");
//			client.sendMsg("hi");
//			client.sendMsg("hi");
//			client.sendMsg("hi");
//		} else {
//			System.out.println("Starting server");
//			host.startHost(8888);
//		}
//		sc.close();
//	}

}
