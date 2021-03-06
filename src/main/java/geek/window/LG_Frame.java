package geek.window;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextPane;

import geek.main.NumberGuesser;

public class LG_Frame {

	public JFrame LG_Frame;
	public JRadioButtonMenuItem easy;
	public JRadioButtonMenuItem normal;
	public JRadioButtonMenuItem hard;
	public JRadioButtonMenuItem insane;
	private JMenuBar ToolBar;
	private static ButtonGroup Diffuctly;
	private BorderLayout manager;
	public static JTextPane InputT;
	public static JTextPane main;
	private static JMenu Settings;
	@SuppressWarnings("unused")
	private JMenuItem MenueItem;
	private int ScreenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	private int ScreenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	ActionHandler HANDY = new ActionHandler();
	private Difficulty diff;
	public boolean onUpdate = false;

	public LG_Frame() {
		LG_Frame = new JFrame("LegendaryGeek's Number Guessing Game | update 2.0");
		LG_Frame.setVisible(true);
		LG_Frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		LG_Frame.setSize(ScreenWidth / 2, ScreenHeight / 2);
		LG_Frame.setLocationRelativeTo(null);
		manager = new BorderLayout();
		LG_Frame.setLayout(manager);
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Frame Created");

		ToolBar = new JMenuBar();
		MenueItem = new JMenuItem("Have Fun!");
		Settings = new JMenu("Difficulty");
		ToolBar.add(Settings);
		Diffuctly = new ButtonGroup();
		LG_Frame.add(ToolBar, BorderLayout.NORTH);
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Toolbar made");

		easy = new JRadioButtonMenuItem("Easy");
		Diffuctly.add(easy);
		Settings.add(easy);
		easy.setSelected(true);

		normal = new JRadioButtonMenuItem("Normal");
		Diffuctly.add(normal);
		Settings.add(normal);

		hard = new JRadioButtonMenuItem("Hard");
		Diffuctly.add(hard);
		Settings.add(hard);

		insane = new JRadioButtonMenuItem("Insane");
		Diffuctly.add(insane);
		Settings.add(insane);

		diff = Difficulty.Easy;

		easy.addActionListener(HANDY);
		normal.addActionListener(HANDY);
		hard.addActionListener(HANDY);
		insane.addActionListener(HANDY);

		main = new JTextPane();
		main.setEditable(false);
		LG_Frame.add(main, BorderLayout.CENTER);
		main.setAutoscrolls(true);
		main.setText("Hello! In this this game you must guess the number that the computer has chosen.\n"
				+ "Choose your Difficulty from the ToolBar Above.\n"
				+ "When Ready type \"start\" in the yellow box and press Enter"
				+ "\n Easy = 10 \n Normal = 50 \n Hard = 100 \n Insane = 20000");

		InputT = new JTextPane();
		InputT.setEditable(true);
		InputT.setBackground(Color.yellow);
		LG_Frame.add(InputT, BorderLayout.SOUTH);
		InputT.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				int key = e.getKeyCode();
				if (key == KeyEvent.VK_ENTER){
				if (NumberGuesser.getState() == NumberGuesser.State.WAIT) {
					System.out.println(
							"[" + java.time.LocalDateTime.now() + "] " + "Current App State: " + NumberGuesser.getState());
					if(InputT.getText().trim().equals("start")) {
						
						NumberGuesser.setState(NumberGuesser.State.PLAYING);
						System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State: "
								+ NumberGuesser.getState());
						System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Starting... #1");
					}else {
						System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Input Field does not say \"start\"");
					}

					} else if(NumberGuesser.getState() != NumberGuesser.State.WAIT){
						onUpdate = true;
						System.out.println("[" + java.time.LocalDateTime.now() + "] " + "update fired!");
					}
				onUpdate = false;
				
				InputT.setText("");
				}
			}
		});
	}

	public enum Difficulty {
		Easy(10, "Easy"), Normal(50, "Normal"), Hard(100, "Hard"), Insane(20000, "Insane");

		private String Difficulty;
		private int num;

		Difficulty(int numIn, String nameIn) {
			this.num = numIn;
			this.Difficulty = nameIn;
		}

		public String GetDifficulty() {
			return this.Difficulty;
		}

		public int getNum() {
			return this.num;
		}
	}

	public Difficulty getDiff() {
		return diff;
	}

	public void setDiff(Difficulty diff1) {
		this.diff = diff1;
		NumberGuesser.setMaxNum(diff.getNum());
	}

	class ActionHandler implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current diffucility Action: " + e);
			if (e.getSource().equals(LG_Frame.this.easy)) {
				LG_Frame.this.setDiff(Difficulty.Easy);

			} else if (e.getSource().equals(LG_Frame.this.normal)) {
				LG_Frame.this.setDiff(Difficulty.Normal);

			} else if (e.getSource().equals(LG_Frame.this.hard)) {
				LG_Frame.this.setDiff(Difficulty.Hard);

			} else if (e.getSource().equals(LG_Frame.this.insane)) {
				LG_Frame.this.setDiff(Difficulty.Insane);

			}

		}
	}

}
