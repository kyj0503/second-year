package tp.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import app.design_panel.option_design;
import tp.data.login_data;
import tp.module.ToDoDAO;
import tp.module.module;

public class di_option {
	
	JButton back, user_data, font_size, logout;
	JFrame i;
	JOptionPane joption;
	
	@SuppressWarnings("static-access")
	public void load(JFrame i) {

		this.i = i;
		option_design ds = new option_design();
		i.add(ds);
		i.setVisible(true);
		
		back = ds.get_back();
		user_data = ds.get_user_data();
		font_size = ds.get_font_size();
		logout = ds.get_logout();
		joption = new JOptionPane();
		
		clickEvent();
	}
	
	public void clickEvent() {
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				module m = new module();
				m.select(i, 1);
			}
		});
		
		user_data.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				ToDoDAO dao = ToDoDAO.getInstance();
				joption.showMessageDialog(i, "이름 : " + dao.getUserName(login_data.getId()) + "\n" + "계정 ID : " + dao.getUserId(login_data.getId()));
			}
		});
		
		font_size.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				tp.module.RegCheck ck = new tp.module.RegCheck();
				int font_size = 20;
				
				try {
					font_size = ck.get_Reg();
				} catch (Exception e1) {
				}
				
				try {
					String n = joption.showInputDialog(i, "폰트 크기 조절", font_size);
					if (n != null) {
						font_size = Integer.parseInt(n);	
					}
					ck.set_Reg(font_size);
				} catch (NumberFormatException e1) {
					joption.showMessageDialog(i, "정상적인 입력 범위가 아닙니다.");
				}
			}
		});
		
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				module m = new module();
				m.select(i, 0);
			}
		});
	}
}
