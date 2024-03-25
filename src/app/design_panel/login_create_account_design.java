package app.design_panel;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class login_create_account_design extends JPanel {
	private static JTextField id;
	private static JTextField name;
	private static JPasswordField pw;

	private static JButton create;
	
	/**
	 * Create the panel.
	 */
	public login_create_account_design() {
		setPreferredSize(new Dimension(400, 570));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("To-Do-List");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 17));
		lblNewLabel.setBounds(45, 70, 294, 59);
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 139, 376, 389);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 43, 121, 46);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 99, 121, 46);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 155, 121, 46);
		panel.add(lblNewLabel_3);
		
		create = new JButton("회원가입");
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		create.setBounds(64, 226, 246, 46);
		panel.add(create);
		
		id = new JTextField();
		id.setBounds(131, 50, 233, 33);
		panel.add(id);
		id.setColumns(10);
		
		name = new JTextField();
		name.setBounds(131, 162, 233, 33);
		panel.add(name);
		name.setColumns(10);
		
		pw = new JPasswordField();
		pw.setBounds(131, 106, 233, 33);
		panel.add(pw);
	}
	
	
	
	public static JTextField get_id() {
		return id;
	}

	public static JTextField get_name() {
		return name;
	}
	
	public static JPasswordField get_password() {
		return pw;
	}
	
	public static JButton get_btn() {
		return create;
	}
}
