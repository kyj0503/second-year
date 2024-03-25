package app.design_panel;

import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

@SuppressWarnings("serial")
public class login_intro_design extends JPanel {

	/**
	 * Create the panel.
	 */
	public login_intro_design() {

		setPreferredSize(new Dimension(400, 570));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TO Do List");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 43));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 160, 388, 100);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Team Project - JAVA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(92, 270, 230, 36);
		add(lblNewLabel_1);
	}
}
