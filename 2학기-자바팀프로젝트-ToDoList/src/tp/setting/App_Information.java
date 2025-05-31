package tp.setting;

import java.awt.Toolkit;

import javax.swing.JFrame;
import tp.data.app_data;

public class App_Information {
	
	public void information(JFrame i) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		
		// APP Icon
		i.setIconImage(kit.getImage(app_data.APPICON.getValue()));
		// APP Name
		i.setTitle(app_data.APPNAME.getValue());
	}
}
