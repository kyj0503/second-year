package app.design_panel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import tp.data.login_data;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class login_design extends JPanel {
	private static JPasswordField pw;
	private static JButton login;
	private static JButton create_account;
	private static JTextField id;

	public login_design() {
		setLayout(null);

		setPreferredSize(new Dimension(400, 570));
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 387, 166, 52);
		add(panel);
		
		login = new JButton("로그인");
		login.setBounds(0, 0, 166, 52);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		login.setFont(new Font("굴림", Font.PLAIN, 30));
		panel.add(login);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(101, 242, 271, 46);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		id = new JTextField();
		id.setText("");
		id.setFont(new Font("굴림", Font.PLAIN, 23));
		id.setColumns(13);
		panel_1.add(id);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(101, 298, 271, 46);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		pw = new JPasswordField();
		pw.setFont(new Font("굴림", Font.PLAIN, 23));
		panel_2.add(pw);
		pw.setColumns(15);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(24, 242, 77, 46);
		add(panel_3);
		
		JLabel txtID = new JLabel("ID");
		txtID.setFont(new Font("굴림", Font.PLAIN, 30));
		panel_3.add(txtID);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(24, 298, 77, 46);
		add(panel_4);
		
		JLabel txtPW = new JLabel("PW");
		txtPW.setFont(new Font("굴림", Font.PLAIN, 30));
		panel_4.add(txtPW);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(24, 103, 348, 65);
		add(panel_5);
		
		JLabel lblNewLabel = new JLabel("To-Do-List");
		lblNewLabel.setFont(new Font("나눔바른고딕OTF", Font.PLAIN, 33));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_5.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(24, 387, 166, 52);
		add(panel_6);
		
		create_account = new JButton("회원가입");
		create_account.setBounds(0, 0, 166, 52);
		create_account.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_6.setLayout(null);
		create_account.setFont(new Font("굴림", Font.PLAIN, 30));
		panel_6.add(create_account);
	}
	
	public static login_data login() {
		login_data data = new login_data(id.getText(), pw, null);
		return data;
	}
	
	public static JButton getcreateaccount() {
		return create_account;
	}
	
	public static JButton getlogin() {
		return login;
	}
	
	public JPasswordField getPasswordField() {
		return pw;
	}
}
