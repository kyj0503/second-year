package tp.data;

import javax.swing.JPasswordField;

public class login_data {
	private static String id;
	private JPasswordField pw;
	private String name;
	
	public login_data(String id, JPasswordField pw, String name) {
		login_data.id = id;
		this.pw = pw;
		this.name = name;
	}
	
	public static String getId() {
		return id;
	}
	public void setId(String id) {
		login_data.id = id;
	}
	public JPasswordField getPw() {
		return pw;
	}
	public void setPw(JPasswordField pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}