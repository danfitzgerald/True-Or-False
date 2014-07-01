package io.github.brother_daniel.multiTF.game;

import io.github.brother_daniel.multiTF.GUI.CorrectDialog;
import io.github.brother_daniel.multiTF.GUI.GuessFrame;
import io.github.brother_daniel.multiTF.GUI.NewQuestionFrame;
import io.github.brother_daniel.multiTF.socket.Host;

import java.util.Random;

/**
 * 
 * @author Brother_Daniel <daniel.fitzgerald@hotmail.ca>
 *
 */

public class GameHost {

	static boolean questionAns;
	static String thequestion = null;
	boolean myturn;
	static Host thishost;

	@SuppressWarnings("unused")
	public static void newGame(Host host) {
		thishost = host;
		host.sendMsg(ChatCodes.NEW_GAME);
		try {
			host.hideWaitingFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Random r = new Random(); // create random number to decide who goes 1st.
		int ranInt = r.nextInt(1);
		if (ranInt == 0) {// random value from 0 - 1. 0 equals host
			System.out.println("The host will guess first.");
			host.showWaitingFrame();
			host.sendMsg(ChatCodes.HOST_GUESS);
			// Thread thread = new Thread(new Runnable() {
			//
			// @Override
			// public void run() {
			// boolean questionNotReceived = true;
			// while (questionNotReceived) {
			// if (thequestion.equals(null)) {
			//
			// } else {
			// questionNotReceived = false;
			// GuessFrame guessFrame = new GuessFrame(thishost,
			// thequestion);
			// System.out.println("received the question");
			// }
			// }
			// }
			// });

		} else {
			System.out.println("The host will guess second.");
			host.sendMsg(ChatCodes.CLIENT_GUESS);
			NewQuestionFrame newQuestionFrame = new NewQuestionFrame(host);
		}
		thishost = null;
	}

	// @SuppressWarnings("unused")
	public static void msgReceived(String msg, Host host) {
		if (msg.equals(ChatCodes.ANSWER_FALSE)) { // && questionAns == false){
			System.out.println("Received false answer!");
			host.hideWaitingFrame();
			newGame(host);
		} else if (msg.equals(ChatCodes.ANSWER_TRUE)) { // && questionAns ==
														// true){
			System.out.println("Received true answer!");
			host.hideWaitingFrame();
			newGame(host);
		} else if (msg.equals(ChatCodes.NEW_GAME)) {
			System.out.println("Received new game!");
		} else if (msg.contains(ChatCodes.QUESTION_ANSWER)) {
			String[] questionAnswer = msg.split(ChatCodes.QUESTION_ANSWER);
			String question = questionAnswer[0];
			boolean answer = Boolean.parseBoolean(questionAnswer[1]);

			System.out.println("question: " + question + " Answer: " + answer);
			host.hideWaitingFrame();
			@SuppressWarnings("unused")
			GuessFrame guessFrame = new GuessFrame(host, question);
			// thequestion = question;
			host.answer = answer;
		}

		// if (host.isWaitingFrameVisible()) {
		// host.hideWaitingFrame();
		// } else {
		// host.showWaitingFrame();
		// }

		// else if (msg.equals(ChatCodes.HOST_GUESS)) {
		// GuessFrame guessFrame = new GuessFrame(host);
		// } else if (msg.equals(ChatCodes.CLIENT_GUESS)) {
		// NewQuestionFrame newQuestionFrame = new NewQuestionFrame(host);
		// }
	}

	@SuppressWarnings("unused")
	public static void answerTrue(Host host) {
		// host.sendMsg(ChatCodes.ANSWER_TRUE);
		CorrectDialog cd = new CorrectDialog(host, host.answer);
		if (host.answer) {
			System.out.println("Correct answer true");
		} else {
			System.out.println("True is the wrong answer");
		}
		newGame(host);
	}

	@SuppressWarnings("unused")
	public static void answerFalse(Host host) {
		// host.sendMsg(ChatCodes.ANSWER_FALSE);

		if (host.answer) {
			CorrectDialog cd = new CorrectDialog(host, false);
			System.out.println("False is the wrong answer");
		} else {
			CorrectDialog cd = new CorrectDialog(host, true);
			System.out.println("Correct answer false");
		}
		newGame(host);

	}

	public static void submitQuestion(Host host, String question, boolean answer) {
		host.sendMsg(question + ChatCodes.QUESTION_ANSWER + answer);
		host.showWaitingFrame();
		thequestion = question;
	}
}
