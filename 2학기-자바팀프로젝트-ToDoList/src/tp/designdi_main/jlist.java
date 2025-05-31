package tp.designdi_main;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import app.design_panel.main_design;
import tp.data.login_data;
import tp.module.ToDoDAO;
import tp.module.ToDoDTO;

/**
 * JList 관련 동작을 담당하는 클래스
 */
public class jlist {

    /**
     * JList를 설정하고 데이터를 로드하는 메서드
     * 
     * @param mainDesign 메인 디자인 패널
     */
    @SuppressWarnings({ "static-access" })
    public static void set_jlist(main_design mainDesign) {
        // JList에 표시될 데이터를 담을 Vector 객체 생성
        Vector<Object> dataList = new Vector<>();
        JList<Object> toDoList = new JList<>();

        // main_design 객체에서 JScrollPane를 가져와서 JList를 설정
        JScrollPane scrollPane = mainDesign.get_jlist();
        scrollPane.setViewportView(toDoList);

        // 데이터베이스에서 데이터를 불러와 JList에 설정
        loadDataFromDatabase(dataList, toDoList);

        // JList의 선택 모드를 다중 선택으로 설정
        toDoList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // 커스텀 폰트를 사용할 DefaultListCellRenderer 생성
        @SuppressWarnings("serial")
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (component instanceof JLabel) {
                    // 텍스트의 폰트 크기를 조절
                    tp.module.RegCheck regCheck = new tp.module.RegCheck();
                    try {
                        ((JLabel) component).setFont(new Font("굴림", Font.PLAIN, regCheck.get_Reg()));
                    } catch (Exception e) {
                        ((JLabel) component).setFont(new Font("굴림", Font.PLAIN, 20));
                    }
                }
                return component;
            }
        };

        // JList의 셀 렌더러를 설정
        toDoList.setCellRenderer(renderer);

        // main_design 객체에서 JTextField를 가져와 KeyListener 추가
        JTextField textField = mainDesign.get_jtext();
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER && !textField.getText().equals("")) {
                    addTextToVectorAndDatabase(mainDesign, toDoList, dataList, textField);
                }
            }
        });

        // Delete button action
        JButton deleteButton = mainDesign.get_delete();
        deleteButton.addActionListener(e -> {
            deleteSelectedItems(mainDesign, toDoList);
        });

        // Add button action
        JButton addButton = mainDesign.get_add();
        addButton.addActionListener(e -> {
            addTextToVectorAndDatabase(mainDesign, toDoList, dataList, textField);
        });

        // JList에 ListSelectionListener 추가
        toDoList.addListSelectionListener(new ListSelectionListener() {
            @SuppressWarnings("unused")
            @Override
            public void valueChanged(ListSelectionEvent e) {
                // JList에서 선택된 항목의 인덱스를 얻어옴
                int index = toDoList.getSelectedIndex();
            }
        });
    }

    /**
     * 텍스트를 Vector에 추가하고 데이터베이스에 삽입하는 메서드
     * 
     * @param mainDesign 메인 디자인 패널
     * @param toDoList   할 일 목록을 표시하는 JList
     * @param dataList   JList에 표시될 데이터를 담은 Vector
     * @param textField  텍스트를 입력하는 JTextField
     */
    private static void addTextToVectorAndDatabase(main_design mainDesign, JList<Object> toDoList, Vector<Object> dataList, JTextField textField) {
        // 텍스트 필드의 내용을 얻어와서 Vector 추가
        String toDoData = textField.getText();
        dataList.add(toDoData);

        // ToDoDAO를 사용하여 새로운 to-do 아이템을 데이터베이스에 삽입
        ToDoDAO.getInstance().insertToDoItem(login_data.getId(), toDoData,
                (int) main_design.get_year().getSelectedItem(), (int) main_design.get_month().getSelectedItem(),
                (int) main_design.get_day().getSelectedItem());
        toDoList.setListData(dataList);
        textField.setText("");
    }

    /**
     * 데이터베이스에서 데이터를 불러와 Vector에 추가하고 JList에 설정하는 메서드
     * 
     * @param dataList JList에 표시될 데이터를 담은 Vector
     * @param toDoList 할 일 목록을 표시하는 JList
     */
    public static void loadDataFromDatabase(Vector<Object> dataList, JList<Object> toDoList) {
        // 데이터베이스에서 userId가 동일한 ToDoList 아이템을 가져옴
        List<ToDoDTO> dataFromDatabase = ToDoDAO.getInstance().getToDoItemsForUser(login_data.getId());
        // 가져온 데이터를 Vector에 추가
        for (ToDoDTO item : dataFromDatabase) {
            dataList.add(item);
        }
        // JList에 Vector 데이터를 설정
        toDoList.setListData(dataList);
    }

    /**
     * 선택된 항목을 삭제하는 메서드
     * 
     * @param mainDesign 메인 디자인 패널
     * @param toDoList   할 일 목록을 표시하는 JList
     */
    public static void deleteSelectedItems(main_design mainDesign, JList<Object> toDoList) {
        // 선택된 인덱스를 가져옴
        int[] selectedIndices = toDoList.getSelectedIndices();

        // 선택된 항목이 있을 경우
        if (selectedIndices.length > 0) {
            // JList 모델에서 선택된 항목을 가져옴
            List<Object> selectedItems = toDoList.getSelectedValuesList();

            // Vector에서 선택된 항목을 제거
            Vector<Object> dataList = new Vector<>(toDoList.getModel().getSize());
            for (int i = 0; i < toDoList.getModel().getSize(); i++) {
                if (!selectedItems.contains(toDoList.getModel().getElementAt(i))) {
                    dataList.add(toDoList.getModel().getElementAt(i));
                }
            }

            // 데이터베이스에서 선택된 항목을 삭제
            removeSelectedItemsFromDatabase(mainDesign, selectedItems);

            // 수정된 Vector를 JList에 설정
            toDoList.setListData(dataList);
        }
    }

    /**
     * 데이터베이스에서 선택된 항목을 삭제하는 메서드
     * 
     * @param mainDesign   메인 디자인 패널
     * @param selectedItems 삭제할 항목의 목록
     */
    private static void removeSelectedItemsFromDatabase(main_design mainDesign, List<Object> selectedItems) {
        for (Object selectedItem : selectedItems) {
            // 선택된 항목이 ToDoDTO 객체라고 가정
            if (selectedItem instanceof ToDoDTO) {
                ToDoDTO todoItem = (ToDoDTO) selectedItem;
                ToDoDAO.getInstance().deleteToDoItem(login_data.getId(), todoItem.getId());
            }
        }
    }
}
