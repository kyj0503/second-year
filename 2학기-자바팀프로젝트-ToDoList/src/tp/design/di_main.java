package tp.design;

import javax.swing.JFrame;
import app.design_panel.main_design;
import tp.designdi_main.jlist;
import tp.designdi_main.page_change;
import tp.module.cal_check;

public class di_main {
	@SuppressWarnings({ "static-access" })
	public void load(JFrame i) {

		main_design ds = new main_design();
		i.add(ds);
		i.setVisible(true);
		
		jlist.set_jlist(ds);
		
		cal_check.check(ds.get_year(), ds.get_month(), ds.get_day());
		// ds.get_year(), ds.get_month(), ds.get_day() 달력값 가져올때 쓸 것
		
		page_change pc = new page_change();
		pc.set_page(ds, i);
	}
}
