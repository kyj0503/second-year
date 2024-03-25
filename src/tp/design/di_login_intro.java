package tp.design;

import javax.swing.JFrame;

import app.design_panel.login_intro_design;
import tp.module.module;

public class di_login_intro {
	public void load(JFrame i) {
		login_intro_design ds = new login_intro_design();
		i.add(ds);
		i.setVisible(true);
		
		try {
			Thread.sleep(1000);
			
			// Login Page Change
			module m = new module();
			m.select(i, 0);
			
			// 자동 로그인 구현 시 여기에 구현할 것
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
