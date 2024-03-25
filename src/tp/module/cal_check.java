package tp.module;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JComboBox;

public class cal_check {
    // Calendar 인스턴스와 현재 년도, 월, 요일을 저장하는 변수 선언
    static Calendar date;
    static int thisYear;
    static int thisMonth;
    static int thisday;
    
    // 콤보박스를 초기화하고 현재 날짜 정보를 설정하는 메서드
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void check(JComboBox year, JComboBox month, JComboBox day) {
        date = Calendar.getInstance();
        thisYear = date.get(Calendar.YEAR);
        thisMonth = date.get(Calendar.MONTH);
        thisday = date.get(Calendar.DAY_OF_WEEK);
        
        // 년도 콤보박스 초기화
        for (int i = thisYear; i < thisYear + 100; i++) {
            year.addItem(i);    
        }
        year.setSelectedIndex(0);
        
        // 월 콤보박스 초기화
        for (int i = 1; i < 13; i++) {
            month.addItem(i);
        }
        month.setSelectedIndex(thisMonth);
        
        // 일 콤보박스 초기화
        int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= lastDay; i++) {
            day.addItem(i);
        }
        day.setSelectedIndex(thisday + 1);
        
        // 년도와 월이 변경될 때마다 일 콤보박스 갱신하는 리스너 추가
        year.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(year.getSelectedItem().toString(), month.getSelectedItem().toString(), day);
            }
        });
        
        month.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDay(year.getSelectedItem().toString(), month.getSelectedItem().toString(), day);
            }
        });
    }
    
    // 선택된 년도와 월에 따라 일 콤보박스 갱신하는 메서드
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void setDay(String year, String month, JComboBox day) {
        date.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
        int lastDay = date.getActualMaximum(Calendar.DAY_OF_MONTH);
        day.setSelectedIndex(-1);
        day.removeAllItems();
        for (int i = 1; i <= lastDay; i++) {
            day.addItem(i);
        }
    }
}
