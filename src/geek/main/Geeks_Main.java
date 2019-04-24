package geek.main;

import java.util.Random;

import geek.window.LG_Frame;

public class Geeks_Main {
	
	static LG_Frame game;
	public static String state = "wait";
	public static int maxNum;
	public static int number;
	public static Random rand;

	//This is here to get the state variable
	public static String getState() {
		return state;
	}

	//This is here to set the state variable
	public static void setState(String state) {
		Geeks_Main.state = state;
	}

	public static void main(String[] args) {
		//prints time and state. time is printed for future lag issues if it ever gets any. =)
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State: " + state);
		game = new LG_Frame();
		rand = new Random();
		//temp target number to suffice java 
		number = 1;
		maxNum = 5;

		//if this is not here the game automagically goes into win mode
		while ("wait".equals(state)) {
		}

		String Tguess;
		String Tnumber = Integer.toString(number);
		//This is for the timer, so i don't need a time thread
		long StartTime = System.currentTimeMillis();
		String DefaultMessage = "Guess a number between 1 and " + maxNum + " in the Yellow Box";
		String winState = "This Is not supposed to happen";
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Starting...");
		while ("Not Won".equals(state) ) {

			LG_Frame.main.setText(DefaultMessage);
			Tguess = LG_Frame.InputT.getText();

			if (Tguess == null ? Tnumber == null : Tguess.equals(Tnumber)) {
				state = "Won";

			} else {
				LG_Frame.main.setText(DefaultMessage + "\n Number is incorrect. Please try again.");

			}
		}
		long elapsedTime = System.currentTimeMillis() - StartTime;
		long elapsedSeconds = elapsedTime / 1000;
		long secondsDisplay = elapsedSeconds % 60;
		long elapsedMinutes = elapsedSeconds / 60;
		if (elapsedMinutes >= 300000) {
			winState = "You lost. You took longer than 5 minutes. Better luck next time!";
		} else {
			winState = "You Won! You did it in under 5 Minutes! Try again for a higher score or up the Difficulty!";
		}
		LG_Frame.main.setText(
				winState + " \nIt took you " + elapsedMinutes + " Minutes and " + secondsDisplay + " Seconds!");
	}
}
