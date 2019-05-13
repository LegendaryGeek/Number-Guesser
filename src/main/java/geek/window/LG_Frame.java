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

import geek.main.Geeks_Main;

public class LG_Frame {
	
	public JFrame LGF;
	public static JRadioButtonMenuItem easy;
	public static JRadioButtonMenuItem normal;
	public static JRadioButtonMenuItem hard;
	public static JRadioButtonMenuItem insane;
	public JMenuBar ToolBar;
	public static ButtonGroup Diffuctly;
	public BorderLayout manager;
	public static JTextPane InputT;
	public static JTextPane main;
	public static JMenu Settings;
	@SuppressWarnings("unused")
	private JMenuItem MenueItem;
    private int ScreenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private int ScreenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    ActionHandler HANDY = new ActionHandler();
	
	public LG_Frame() {
		LGF = new JFrame("LegendaryGeek's Number Guessing Game | update 2.0");
		LGF.setVisible(true);
		LGF.setDefaultCloseOperation(EXIT_ON_CLOSE);
		LGF.setSize(ScreenWidth / 2, ScreenHeight / 2);
		LGF.setLocationRelativeTo(null);
		manager = new BorderLayout();
		LGF.setLayout(manager);
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Frame Created");
		
	    ToolBar = new JMenuBar();
	    MenueItem = new JMenuItem("Have Fun!");
	    Settings = new JMenu("Difficulty");
	    ToolBar.add(Settings);
	    Diffuctly = new ButtonGroup();
	    LGF.add(ToolBar, BorderLayout.NORTH);
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
	   
	    easy.addActionListener(HANDY);
	    normal.addActionListener(HANDY);
	    hard.addActionListener(HANDY);
	    insane.addActionListener(HANDY);
	    
	    main = new JTextPane();
	    main.setEditable(false);
	    LGF.add(main, BorderLayout.CENTER);
	    main.setAutoscrolls(true);
	    main.setText("Hello! In this this game you must guess the number that the computer has chosen.\n"
	            + "Choose your Difficulty from the ToolBar Above.\n"
	            + "When Ready type \"start\" in the yellow box and press Enter"
	            + "\n Easy = 10 \n Normal = 50 \n Hard = 100 \n Insane = 20000");

	    InputT = new JTextPane();
	    InputT.setEditable(true);
	    InputT.setBackground(Color.yellow);
	    LGF.add(InputT, BorderLayout.SOUTH);
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
				if(Geeks_Main.getState() == Geeks_Main.State.WAIT) {
					System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State: " + Geeks_Main.getState());
					if (key == KeyEvent.VK_ENTER && InputT.getText().trim().equals("start")) {
						Geeks_Main.setState(Geeks_Main.State.PLAYING);
						System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current App State: " + Geeks_Main.getState());
						System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Starting... #1");
						
					}
				}
			}
		});
	}
	

}

class ActionHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current diffucility Action: " + e);
		switch(e.getSource().toString()) {
		case "easy": 
		 	Geeks_Main.setMaxNum(10);
		 	Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			break;
		case "normal":
			Geeks_Main.setMaxNum(50);
		 	Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			break;
		case "hard":
			Geeks_Main.setMaxNum(100);
		 	Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			break;
		case "insane":
			Geeks_Main.setMaxNum(20000);
		 	Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			break;
		default:
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Failed to set Diffuclty. setting to easy. got: " + e.getSource().toString());
			Geeks_Main.setMaxNum(10);
		 	Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			break;
		}
		/*
		  if (e.getSource().equals(LG_Frame.easy)) {
		 
		 	Geeks_Main.setMaxNum(10);
		 	Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			
		} else if (e.getSource().equals(LG_Frame.normal)) {
			Geeks_Main.setMaxNum(50);
			Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			
		} else if (e.getSource().equals(LG_Frame.hard)) {
			Geeks_Main.setMaxNum(100);
			Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			
		} else if (e.getSource().equals(LG_Frame.insane)) {
			Geeks_Main.setMaxNum(20000);
			Geeks_Main.setNumber(Geeks_Main.getRand().nextInt(Geeks_Main.getMaxNum()));
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current Maximum number guessable: " + Geeks_Main.getMaxNum());
			System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Current number: " + Geeks_Main.getNumber());
			
		}
		*/
	}
}