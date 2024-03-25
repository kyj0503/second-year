package tp.design;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import app.design_panel.login_design;
import tp.data.login_data;
import tp.module.ToDoDAO;
import tp.module.module;

@SuppressWarnings("serial")
public class di_login extends JFrame{
	
    @SuppressWarnings("static-access")
    public void load(JFrame i) {
    	
        login_design ds = new login_design();
        i.add(ds);
        i.setVisible(true);
        JButton create_account = ds.getcreateaccount();
        JButton login = ds.getlogin();
        JOptionPane alert = new JOptionPane();
        ToDoDAO dao = ToDoDAO.getInstance();

        //로그인 버튼에 대한 액션 리스너
        login.addActionListener(e -> {
            login_data d = ds.login();
            char[] pwc = d.getPw().getPassword();
            String pw = new String(pwc);

            if (dao.checkLoginCredentials(d.getId(), pw)) {
                alert.showMessageDialog(null, "로그인 성공!");
                               
                // 로그인 성공 후의 동작 구현
                module m = new module();
    			m.select(i, 1);
    			
            } else {
                alert.showMessageDialog(null, "로그인 실패. 유효하지 않은 자격 증명입니다.");
            }
        });

        //계정 선택 버튼에 대한 액션 리스너
        create_account.addActionListener(e -> {
			module m = new module();
			m.select(i, -2);
        });

        //비밀번호 입력 필드에 대한 키 리스너
        JPasswordField j = ds.getPasswordField();

        j.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login_data d = ds.login();
                    char[] pwc = d.getPw().getPassword();
                    String pw = new String(pwc);
                    
                    if (dao.checkLoginCredentials(d.getId(), pw)) {
                        alert.showMessageDialog(null, "로그인 성공!");
                                       
                        // 로그인 성공 후의 동작 구현
                        module m = new module();
            			m.select(i, 1);
            			
                    } else {
                        alert.showMessageDialog(null, "로그인 실패. 유효하지 않은 자격 증명입니다.");
                    }
                }
            }
        });
        
    }
}
