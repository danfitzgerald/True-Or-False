package io.github.brother_daniel.multiTF.game;

import io.github.brother_daniel.multiTF.GUI.CorrectDialog;
import io.github.brother_daniel.multiTF.GUI.GuessFrame;
import io.github.brother_daniel.multiTF.GUI.NewQuestionFrame;
import io.github.brother_daniel.multiTF.socket.Client;

public class GameClient {

	public static void joinGame(Client client) {
		client.sendMsg(ChatCodes.JOIN_GAME);

	}

	@SuppressWarnings("unused")
	public static void msgReceived(String msg, Client client) {
		if (msg.equals(ChatCodes.CLIENT_FIRST_GUESS)) {
			GuessFrame guessFrame = new GuessFrame(client, null);
		} else if (msg.equals(ChatCodes.HOST_FIRST_GUESS)) {
			NewQuestionFrame newQuestionFrame = new NewQuestionFrame(client);
		} else if (msg.equals(ChatCodes.CLIENT_GUESS)) {
			GuessFrame guessFrame = new GuessFrame(client, null);
		} else if (msg.equals(ChatCodes.HOST_GUESS)) {
			NewQuestionFrame newQuestionFrame = new NewQuestionFrame(client);
		} else if (msg.equals(ChatCodes.CORRECT_GUESS)) {
			CorrectDialog cd = new CorrectDialog(client, true);
		} else if (msg.equals(ChatCodes.INCORRECT_GUESS)) {
			CorrectDialog cd = new CorrectDialog(client, false);
		}
	}

	public static void sendTrue(Client client) {
		client.sendMsg(ChatCodes.ANSWER_TRUE);
	}

	public static void sendFalse(Client client) {
		client.sendMsg(ChatCodes.ANSWER_FALSE);
	}
	
	public static void sendQuestion(Client client, String question, boolean answer) {
		client.sendMsg(question + ChatCodes.QUESTION_ANSWER + answer);
	}
	
	public static void msgReceived(String msg) {
		if(msg.equals(ChatCodes.CORRECT_GUESS)){
			System.out.println("Received a correct answer!");
//			CorrectDialog cd = new CorrectDialog(client, true);
		}
	}

}
