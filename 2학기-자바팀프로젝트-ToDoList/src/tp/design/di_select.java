package tp.design;

import javax.swing.JFrame;

public class di_select {
	public void select(JFrame i, int n) {
		
		// Check - tp.data.fixed_check
		if (n == -2) {
			di_login_create_account d = new di_login_create_account();
			d.load(i);
		}
		if (n == -1) {
			di_login_intro d = new di_login_intro();
			d.load(i);
		}
		else if (n == 0) {
			di_login d = new di_login();
			d.load(i);
		}
		else if(n == 1) {
			di_main d = new di_main();
			d.load(i);
		}
		else if(n == 2) {
			di_calendar d = new di_calendar();
			d.load(i);
		}
		else if(n == 3) {
			di_option d = new di_option();
			d.load(i);
		}
	}
}
