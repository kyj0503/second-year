package app.design_panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class option_design extends JPanel {

	@SuppressWarnings("unused")
	private final JPanel panel = new JPanel();

	private static JButton back;
	private static JButton user_data;
	private static JButton font_size;
	private static JButton logout;

	/**
	 * Create the panel.
	 */
	public option_design() {

		setLayout(null);

		setPreferredSize(new Dimension(400, 570));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(65, 10, 321, 50);
		add(panel_1);

		JLabel lblNewLabel = new JLabel("설정");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 30));
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 10, 50, 50);
		add(panel_2);
		panel_2.setLayout(null);

		back = new JButton("X");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		back.setBounds(0, 0, 50, 50);
		panel_2.add(back);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(65, 128, 321, 212);
		add(panel_3);
		panel_3.setLayout(null);

		user_data = new JButton("사용자 정보");
		user_data.setFont(new Font("굴림", Font.PLAIN, 21));
		user_data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		user_data.setBounds(12, 10, 297, 53);
		panel_3.add(user_data);

		font_size = new JButton("폰트 크기");
		font_size.setFont(new Font("굴림", Font.PLAIN, 21));
		font_size.setBounds(12, 73, 297, 53);
		panel_3.add(font_size);

		logout = new JButton("로그아웃");
		logout.setFont(new Font("굴림", Font.PLAIN, 21));
		logout.setBounds(12, 136, 297, 53);
		panel_3.add(logout);
	}

	public static JButton get_back() {
		return back;
	}

	public static JButton get_user_data() {
		return user_data;
	}

	public static JButton get_font_size() {
		return font_size;
	}

	public static JButton get_logout() {
		return logout;
	}
}
