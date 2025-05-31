package tp.design;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import app.design_panel.login_create_account_design;
import tp.data.login_data;
import tp.module.module;
import tp.module.ToDoDAO;

public class di_login_create_account {
    @SuppressWarnings({ "static-access" })
    public void load(JFrame frame) {

        // 로그인 및 계정 생성 디자인을 담당하는 객체 생성
        login_create_account_design loginPanel = new login_create_account_design();
        frame.add(loginPanel);
        frame.setVisible(true);

        // 각 입력 필드와 버튼을 가져옴
        JTextField idField = loginPanel.get_id();
        JPasswordField passwordField = loginPanel.get_password();
        JTextField nameField = loginPanel.get_name();

        JButton createAccountButton = loginPanel.get_btn();

        // 계정 생성 버튼에 대한 이벤트 리스너 등록
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 계정 생성 처리 메서드 호출
                handleAccountCreation(idField, passwordField, nameField, frame);
            }
        });
    }

    private void handleAccountCreation(JTextField idField, JPasswordField passwordField, JTextField nameField, JFrame frame) {
        // 회원가입 로직 수행
        String enteredId = idField.getText();
        char[] enteredPw = passwordField.getPassword();
        String enteredName = nameField.getText();

        // 필드 중 하나라도 비어 있는지 확인
        if (enteredId.trim().isEmpty() || enteredPw.length == 0 || enteredName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "모든 칸을 입력하세요.");
        } else {
            // 이미 등록된 ID인지 확인
            ToDoDAO dao = ToDoDAO.getInstance();
            if (dao.isUserRegistered(enteredId)) {
                JOptionPane.showMessageDialog(null, "이미 존재하는 사용자 ID입니다.");
            } else {
                // 회원가입 처리를 위한 데이터 설정
                login_data registrationData = new login_data(null, passwordField, null);
                registrationData.setId(enteredId);
                registrationData.setPw(passwordField);
                registrationData.setName(enteredName);

                String enteredPwString = new String(enteredPw);

                // 사용자 등록 시도
                if (dao.registerUser(login_data.getId(), enteredPwString, registrationData.getName())) {
                    JOptionPane.showMessageDialog(null, "회원 가입 성공!");
                } else {
                    JOptionPane.showMessageDialog(null, "회원 가입 실패. 다시 시도해주세요.");
                }

                // 로그인 페이지로 이동
                module m = new module();
                m.select(frame, 0);
            }
        }
    }
}
