package tp.main;

import javax.swing.JFrame;
import tp.module.module;

public class Main {
	public static void main(String[] args) {
		
		// Start JFrame
		JFrame j = new JFrame();
		module m = new module();
		
		// 로딩 화면
		
		// 로그인 창 불러오기
		m.select(j, 0);

	}
}
