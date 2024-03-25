package tp.setting;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ScreenSize extends JFrame{
	static int width = 410;
	static int height = 600;
	
	public void call_intro(JFrame i) {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		i.setSize(width, height);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setResizable(false);
		i.setVisible(true);
		
		i.setLocation(res.width - width, 0);
	}
	
	public void call_login(JFrame i) {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		i.setSize(width, height);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setResizable(false);
		i.setVisible(true);
		
		i.setLocation(res.width - width, 0);
	}
	
	public void call_main(JFrame i) {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		i.setSize(width, height);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setResizable(false);
		i.setVisible(true);
		
		i.setLocation(res.width - width, 0);
	}
	
	public void call_calendar(JFrame i) {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		i.setSize(width, height);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setResizable(false);
		i.setVisible(true);
		
		i.setLocation(res.width - width, 0);
	}
	
	public void call_option(JFrame i) {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		i.setSize(width, height);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setResizable(false);
		i.setVisible(true);
		
		i.setLocation(res.width - width, 0);
	}
	
	public void call_create_account(JFrame i) {
		Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
		i.setSize(width, height);
		i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		i.setResizable(false);
		i.setVisible(true);
		
		i.setLocation(res.width - width, 0);
	}
}
