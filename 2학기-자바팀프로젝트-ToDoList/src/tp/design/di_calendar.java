package tp.design;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.AbstractBorder;
import javax.swing.border.LineBorder;

import app.design_panel.calendar_design;
import tp.module.module;

public class di_calendar {

	Calendar cal; // 케린다
	int year, month, date;
	String titleStr[] = { "일", "월", "화", "수", "목", "금", "토" };
	JPanel title, datePane;
	JFrame i;
	JLabel now_year, now_month;

	JButton left, right, back;

	private static calendar_design ds;

	@SuppressWarnings("static-access")
	public void load(JFrame i) {
		ds = new calendar_design();
		this.i = i;
		i.add(ds);
		i.setVisible(true);

		title = ds.getTitle();
		datePane = ds.getCal();
		now_year = ds.getYear();
		now_month = ds.getMonth();

		left = ds.getleft();
		right = ds.getright();
		back = ds.getback();

		cal = Calendar.getInstance(); // 현재날짜
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		date = cal.get(Calendar.DATE);

		cal_get();
		clickbtn();
	}

	public void clickbtn() {
		left.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				month--;
				if (month == 0) {
					month = 12;
					year -= 1;
				}
				cal_get();
			}
		});

		right.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				month++;
				if (month == 13) {
					month = 1;
					year += 1;
				}
				cal_get();
			}
		});

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				module m = new module();
				m.select(i, 1);
			}
		});
	}

	public void cal_get() {
		title.removeAll();
		datePane.removeAll();
		
		now_year.setText(year + "년");
		now_month.setText(month + "월");

		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();

		// 년
		for (int i = year - 100; i <= year + 50; i++) {
			yearModel.addElement(i);
		}

		yearCombo.setModel(yearModel);
		yearCombo.setSelectedItem(year);

		// 월
		for (int i = 1; i <= 12; i++) {
			monthModel.addElement(i);
		}
		monthCombo.setModel(monthModel);
		monthCombo.setSelectedItem(month);

		// 월 화 수 목 금 토 일
		for (int i = 0; i < titleStr.length; i++) {
			JLabel lbl = new JLabel(titleStr[i], JLabel.CENTER);
			if (i == 0) {
				lbl.setForeground(Color.red);
			} else if (i == 6) {
				lbl.setForeground(Color.blue);
			}
			title.add(lbl);
		}

		day(year, month);
		i.setVisible(true);
	}

	// 날짜출력
	public void day(int year, int month) {
		Calendar date = Calendar.getInstance();// 오늘날짜 + 시간
		date.set(year, month - 1, 1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);

		// 공백 출력
		for (int space = 1; space < week; space++) {
			datePane.add(new JLabel("\t"));
		}

		// 날짜 출력
		for (int day = 1; day <= lastDay; day++) {
			JLabel lbl = new JLabel("<html><center>" + String.valueOf(day) + "<br>" + 
					"" + "</html>", JLabel.CENTER);
			
			// Check To List = Show List
			
			lbl.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					// 클릭 시 목록 보여줄꺼임
					AbstractBorder b = new LineBorder(Color.black, 2);
					lbl.setBorder(b);
				}
			});
			cal.set(year, month - 1, day);
			int Week = cal.get(Calendar.DAY_OF_WEEK);

			if (Week == 1) {
				lbl.setForeground(Color.red);
			} else if (Week == 7) {
				lbl.setForeground(Color.BLUE);
			}
			datePane.add(lbl);
		}
		
		for (int rem = 0; rem <= 35 - lastDay - week; rem++) {
			datePane.add(new JLabel("\t"));
		}
	}
}
