package app.design_panel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class calendar_design extends JPanel {

	@SuppressWarnings("unused")
	private final JPanel panel = new JPanel();
	private static JPanel title;
	private static JPanel cal;
	private static JLabel year;
	private static JLabel month;

	private static JButton right;
	private static JButton left;
	private static JButton back;

	/**
	 * 
	 * Create the panel.
	 */
	public calendar_design() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 570));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(67, 10, 321, 50);
		add(panel_1);

		JLabel lblNewLabel = new JLabel("Calendar");
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

		year = new JLabel("Year");
		year.setFont(new Font("굴림", Font.PLAIN, 17));
		year.setHorizontalAlignment(SwingConstants.CENTER);
		year.setBounds(110, 70, 87, 38);
		add(year);

		month = new JLabel("Month");
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setFont(new Font("굴림", Font.PLAIN, 17));
		month.setBounds(209, 70, 87, 38);
		add(month);

		left = new JButton("<");
		left.setBounds(33, 70, 40, 38);
		add(left);

		right = new JButton("<");
		right.setBounds(326, 70, 40, 38);
		add(right);

		cal = new JPanel(new GridLayout(0, 7));
		cal.setBounds(10, 141, 378, 387);
		add(cal);

		title = new JPanel(new GridLayout(1, 7));
		title.setBounds(10, 118, 378, 22);

		add(title);
	}

	public static JButton getback() {
		return back;
	}

	public static JButton getleft() {
		return left;
	}

	public static JButton getright() {
		return right;
	}

	public static JPanel getCal() {
		return cal;
	}

	public static JPanel getTitle() {
		return title;
	}

	public static JLabel getYear() {
		return year;
	}

	public static JLabel getMonth() {
		return month;
	}
}
