package tp.designdi_main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import app.design_panel.main_design;
import tp.module.module;

public class page_change {
	@SuppressWarnings({ "static-access" })
	public static void set_page(main_design ds, JFrame j) {
		JButton calendar = ds.get_calendar();
		JButton option = ds.get_option();

		calendar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				module m = new module();
				m.select(j, 2);
			}
		});

		option.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				module m = new module();
				m.select(j, 3);
			}
		});
	}
}
