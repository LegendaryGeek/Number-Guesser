package geek.main;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import geek.window.LG_Frame;

public class Geeks_Main {
	
	static LG_Frame game;
	private static State CurrentState = State.WAIT;
	private static int maxNum;
	private static int number;
	private static Random rand;
	private static String Tguess;
	private static String Tnumber;

	public static void main(String[] args) throws InterruptedException {
		//prints time and state. time is printed for future lag issues if it ever gets any. =)
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State: " + Geeks_Main.getState().toString());
		game = new LG_Frame();
		setRand(new Random());
		//temp target number to suffice java 
		setNumber(1);
		setMaxNum(5);
		//if this is not here the game automagically goes into win mode
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State before loop: " + Geeks_Main.getState().toString());
		while (Geeks_Main.getState() == State.WAIT) {
			TimeUnit.SECONDS.sleep(1);
		}

		Tnumber = Integer.toString(getNumber());
		//This is for the timer, so i don't need a time thread
		long StartTime = System.currentTimeMillis();
		String DefaultMessage = "Guess a number between 1 and " + getMaxNum() + " in the Yellow Box";
		String winState = "This Is not supposed to happen";
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Starting... #2");
		while (Geeks_Main.getState() == State.PLAYING) {

			LG_Frame.main.setText(DefaultMessage);
			setTguess(LG_Frame.InputT.getText());

			if (getTguess() == null ? Tnumber == null : getTguess().equals(Tnumber)) {
				setState(Geeks_Main.State.WON);

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

	// Getters and setters section... i think its obvious what they do 
	// so i wont explain
	public static int getMaxNum() {
		return maxNum;
	}

	public static void setMaxNum(int maxNum) {
		Geeks_Main.maxNum = maxNum;
	}

	public static int getNumber() {
		return number;
	}
	
	public static void setNumber(int number) {
		Geeks_Main.number = number;
	}

	public static Random getRand() {
		return rand;
	}

	public static void setRand(Random rand) {
		Geeks_Main.rand = rand;
	}
	
	public static State getState() {
		return CurrentState;
	}

	public static void setState(State state) {
		Geeks_Main.CurrentState = state;
	}
	public static String getTguess() {
		return Tguess;
	}

	public static void setTguess(String tguess) {
		Tguess = tguess;
	}

	public enum State {
		   WAIT("wait"), LOST("Lost Game"), PLAYING("Playing"), WON("Won Game"), EXIT("Exiting Game"), START("Starting Game");

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