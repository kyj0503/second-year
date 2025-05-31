package tp.module;

import java.util.prefs.Preferences;

public class RegCheck {
	private static String regKey = "Font";
	private static final String KeyPath
	= "Software\\ToDoList\\SetReg";
	private static String link = KeyPath + "\\" + regKey;
	
	public static int get_Reg() throws Exception {
		Preferences prefs = Preferences.userRoot();
		int value = prefs.getInt(link, 0);
		
		if (value == 0) {
			prefs.putInt(link, 20);
			value = 20;
		}
		
		return value;
	}
	
	public static void set_Reg(int n) {
		Preferences prefs = Preferences.userRoot();
		
		prefs.putInt(link, n);
	}
}
