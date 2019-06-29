package geek.main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import geek.window.LG_Frame;

public class NumberGuesser {

	public static LG_Frame game;
	private static State CurrentState = State.START;
	private static int maxNum;
	private static int number;
	private static Random rand;
	private static String Tguess;
	private static String Tnumber;
	private static String winState;
	private static String defaultMessage;
	private static long startTime;

	public static void main(String[] args) throws InterruptedException {
		while (NumberGuesser.getState() != State.EXIT) {
			if (NumberGuesser.getState() == State.START) {
				// prints time and state. time is printed for future lag issues if it ever gets
				// any. =)
				System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State: "
						+ NumberGuesser.getState().toString());
				game = new LG_Frame();
				setRand(new Random());
				// temp target number to suffice java
				setNumber(1);
				setMaxNum(5);
				NumberGuesser.setState(State.WAIT);
				// if this is not here the game automagically goes into win mode
				System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State before loop: "
						+ NumberGuesser.getState().toString());

			}
			// if this is not here the game automagically goes into win mode
			if (NumberGuesser.getState() == State.WAIT) {
				TimeUnit.SECONDS.sleep(1);
			}
			if (NumberGuesser.getState() == State.SETUP) {
				setNumber(getRand().nextInt(getMaxNum()));
				System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: "
						+ NumberGuesser.getMaxNum());
				System.out.println(
						"[" + java.time.LocalDateTime.now() + "] " + "Current number: " + NumberGuesser.getNumber());
				Tnumber = Integer.toString(getNumber());
				startTime = System.currentTimeMillis();
				defaultMessage = "Guess a number between 1 and " + getMaxNum() + " in the Yellow Box";
				winState = "This Is not supposed to happen";

			}

			if (NumberGuesser.getState() == State.PLAYING) {
				System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Starting... #2");
				LG_Frame.main.setText(defaultMessage);
				while (NumberGuesser.getState() != State.WON) {
					if (game.onUpdate) {

						setTguess(LG_Frame.InputT.getText());

						if (getTguess() == null ? Tnumber == null : getTguess().equals(Tnumber)) {
							setState(NumberGuesser.State.WON);

						} else {
							LG_Frame.main.setText(defaultMessage + "\n Number is incorrect. Please try again.");

						}
					}
				}
			}

			if (NumberGuesser.getState() == State.WON) {
				long elapsedTime = System.currentTimeMillis() - startTime;
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
	}

	// Getters and setters section
	public static int getMaxNum() {
		return maxNum;
	}

	public static void setMaxNum(int maxNum) {
		NumberGuesser.maxNum = maxNum;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		NumberGuesser.number = number;
	}

	public static Random getRand() {
		return rand;
	}

	public static void setRand(Random rand) {
		NumberGuesser.rand = rand;
	}

	public static State getState() {
		return CurrentState;
	}

	public static void setState(State state) {
		NumberGuesser.CurrentState = state;
	}

	public static String getTguess() {
		return Tguess;
	}

	public static void setTguess(String tguess) {
		Tguess = tguess;
	}

	public enum State {
		WAIT("wait"), SETUP("setup"), LOST("Lost Game"), PLAYING("Playing"), WON("Won Game"), EXIT("Exiting Game"),
		START("Starting Game");

		private String state;

		State(String stateIn) {
			this.state = stateIn;
		}

		@Override
		public String toString() {
			return this.state;
		}

	}
}