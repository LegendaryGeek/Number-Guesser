package geek.utilities;

import javax.swing.JRadioButtonMenuItem;

import geek.window.LG_Frame;

public class Diffucility {
	private Diffucility() {

	}

	public static void AddDiff(JRadioButtonMenuItem diff, String diffName, boolean selected) {
		
		LG_Frame.Diffuctly.add(diff);
		LG_Frame.Settings.add(diff);
		diff.setSelected(selected);
		System.out.println("[" + java.time.LocalDateTime.now() + "] " + "Diffuclty added: " + diffName);
	}
}
