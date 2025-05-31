package tp.module;

import javax.swing.JFrame;
import tp.design.di_select;
import tp.setting.ScreenSize;
import tp.setting.App_Information;

public class module {
	static ScreenSize ss = new ScreenSize();	// Screen Size Setting
	static di_select di = new di_select();		// Design Select
	
	public void select(JFrame j, int n) {
		// Before Frame Clear
		j.getContentPane().removeAll();
		j.repaint();
		
		load(j);

		if (n == -2) call_create_account(j,n);
		else if (n == -1) call_intro(j,n);
		else if (n == 0) call_login(j, n);
		else if(n == 1) call_main(j, n);
		else if(n == 2) call_calendar(j, n);
		else if(n == 3) call_option(j, n);
	}

	public void call_create_account(JFrame j, int n) {
		ss.call_create_account(j);
		di.select(j, n);
	}
	
	public void call_intro(JFrame j, int n) {
		ss.call_intro(j);
		di.select(j, n);
	}
	
	public void call_login(JFrame j, int n) {
		ss.call_login(j);
		di.select(j, n);
	}
	
	public void call_main(JFrame j, int n) {
		ss.call_main(j);
		di.select(j, n);
	}
	
	public void call_calendar(JFrame j, int n) {
		ss.call_calendar(j);
		di.select(j, n);
	}
	
	public void call_option(JFrame j, int n) {
		ss.call_option(j);
		di.select(j, n);
	}
	
	public void load(JFrame j) {
		App_Information info = new App_Information();
		info.information(j);
	}
}
