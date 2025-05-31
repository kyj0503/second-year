package app.design_panel;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class main_design extends JPanel {
	private static JButton calendar = new JButton("달력");
	private static JButton option = new JButton("설정");
	private static JScrollPane itemlist;
	private JPanel panel;
	private static JTextField textField;
	private static JComboBox<?> year;
	private static JComboBox<?> month;
	private static JComboBox<?> day;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private static JButton delete;
	private static JButton add;
	
	
	/**
	 * Create the panel.
	 */
	
	@SuppressWarnings("rawtypes")
	public main_design() {
		setLayout(null);
		setPreferredSize(new Dimension(400, 570));
		
		// Top Panel
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(77, 10, 311, 45);
		add(panel_1);
		
		JLabel name = new JLabel("To Do List");
		name.setFont(new Font("굴림", Font.PLAIN, 30));
		panel_1.add(name);
		
		// Side Panel
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 65, 70, 488);
		add(panel_2);
		panel_2.setLayout(null);
		
		calendar.setBounds(0, 0, 70, 58);
		panel_2.add(calendar);

		option.setBounds(0, 67, 70, 58);
		panel_2.add(option);
		
		// Main Panel
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(87, 65, 300, 385);
		add(panel_3);
		panel_3.setLayout(null);
		
		itemlist = new JScrollPane();
		itemlist.setBounds(5, 5, 290, 380);
		panel_3.add(itemlist);
		
		// Bottom Panel
		panel = new JPanel();
		panel.setBounds(88, 453, 300, 100);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 67, 300, 30);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("굴림", Font.PLAIN, 23));
		textField.setColumns(18);
		panel.add(textField);
		
		year = new JComboBox();
		year.setBounds(0, 38, 84, 29);
		panel.add(year);
		
		month = new JComboBox();
		month.setBounds(120, 38, 54, 29);
		panel.add(month);
		
		day = new JComboBox();
		day.setBounds(209, 38, 54, 29);
		panel.add(day);
		
		textField_1 = new JTextField();
		textField_1.setBounds(84, 38, 38, 29);
		textField_1.setText("년");
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(172, 38, 38, 29);
		textField_2.setText("월");
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setColumns(10);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(262, 38, 38, 29);
		textField_3.setText("일");
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setColumns(10);
		panel.add(textField_3);
		
		delete = new JButton("삭제");
		delete.setBounds(172, 5, 60, 30);
		panel.add(delete);
		
		add = new JButton("추가");
		add.setBounds(235, 5, 60, 30);
		panel.add(add);
	}
	
	
	
	public static JButton get_option() {
		return option;
	}
	
	public static JButton get_calendar() {
		return calendar;
	}
	
	public static JButton get_delete() {
		return delete;
	}
	
	public static JButton get_add() {
		return add;
	}
	
	public static JScrollPane get_jlist() {
		return itemlist;
	}
	
	public static JTextField get_jtext() {
		return textField;
	}
	
	@SuppressWarnings("rawtypes")
	public static JComboBox get_year() {
		return year;
	}
	@SuppressWarnings("rawtypes")
	public static JComboBox get_month() {
		return month;
	}
	@SuppressWarnings("rawtypes")
	public static JComboBox get_day() {
		return day;
	}
}
