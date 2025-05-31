package tp.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * ToDo 데이터베이스에 접근하는 DAO 클래스
 */
public class ToDoDAO {
    private Connection conn;           // 데이터베이스 연결을 담당하는 Connection 객체
    private ResultSet rs;              // SQL 쿼리의 결과를 담을 ResultSet 객체
    private PreparedStatement pstmt;   // SQL 쿼리를 실행하기 위한 PreparedStatement 객체

    // 싱글톤 패턴을 사용하기 위한 ToDoDAO 인스턴스
    private static ToDoDAO dao = new ToDoDAO();

    // 생성자를 private 선언하여 외부에서 직접 객체를 생성하지 못하도록 함
    private ToDoDAO() {}

    // ToDoDAO 인스턴스를 얻기 위한 정적 메서드
    public static ToDoDAO getInstance() {
        return dao;
    }

    /**
     * 데이터베이스 연결을 얻기 위한 메서드
     * 
     * @param databaseName 데이터베이스 이름
     * @return Connection 객체
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getCon(String databaseName) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            // 데이터베이스 서버에 연결
            String url = "jdbc:mysql://bitemap.crkywica6qbw.ap-northeast-2.rds.amazonaws.com:3306/" + databaseName;
            String user = "kyj0503";
            String password = "wara0503";
            conn = DriverManager.getConnection(url, user, password);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    } // end getCon()

    /**
     * 데이터베이스 연결 및 객체 종료를 처리하는 메서드
     */
    private void exit() {
        try {
            // 연결 종료
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } // end exit()

    /**
     * 새로운 ToDo 아이템을 데이터베이스에 삽입하는 메서드
     * 
     * @param userId 사용자 ID
     * @param data   ToDo 데이터
     * @param year   연도
     * @param month  월
     * @param day    일
     */
    public void insertToDoItem(String userId, String data, int year, int month, int day) {
        try {
            conn = getCon("todolist");
            String sql = "INSERT INTO ToDoList (user_Id, data, year, month, day) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setString(2, data);
            pstmt.setInt(3, year);
            pstmt.setInt(4, month);
            pstmt.setInt(5, day);
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            exit();
        }
    }

    /**
     * ToDo 아이템을 데이터베이스에서 삭제하는 메서드
     * 
     * @param userId 사용자 ID
     * @param itemId ToDo 아이템 ID
     */
    public void deleteToDoItem(String userId, int itemId) {
        try {
            conn = getCon("todolist");
            String sql = "DELETE FROM ToDoList WHERE user_Id = ? AND id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            pstmt.setInt(2, itemId);
            pstmt.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            exit();
        }
    }

    /**
     * 데이터베이스에서 특정 날짜의 ToDo 아이템을 가져오는 메서드
     * 
     * @param year  연도
     * @param month 월
     * @param day   일
     * @return 해당 날짜의 ToDo 아이템 목록
     */
    public List<ToDoDTO> getToDoItemsForDate(int year, int month, int day) {
        List<ToDoDTO> toDoList = new ArrayList<>();
        try {
            conn = getCon("todolist");
            String sql = "SELECT * FROM ToDoList WHERE (year, month, day) = (?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, year);
            pstmt.setInt(2, month);
            pstmt.setInt(3, day);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String data = rs.getString("data");
                ToDoDTO toDoItem = new ToDoDTO(id, data);
                toDoList.add(toDoItem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            exit();
        }
        return toDoList;
    }

    /**
     * 데이터베이스에서 특정 사용자의 ToDo 아이템을 가져오는 메서드
     * 
     * @param userId 사용자 ID
     * @return 해당 사용자의 ToDo 아이템 목록
     */
    public List<ToDoDTO> getToDoItemsForUser(String userId) {
        List<ToDoDTO> toDoList = new ArrayList<>();
        try {
            conn = getCon("todolist");
            String sql = "SELECT * FROM ToDoList WHERE user_Id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String data = rs.getString("data");
                ToDoDTO toDoItem = new ToDoDTO(id, data);
                toDoList.add(toDoItem);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            exit();
        }
        return toDoList;
    }

    /**
     * 사용자 회원 가입 메서드
     * 
     * @param userId   사용자 ID
     * @param password 사용자 비밀번호
     * @param userName 사용자 이름
     * @return 회원 가입 성공 여부
     */
    public boolean registerUser(String userId, String password, String userName) {
        try (Connection conn = getCon("userlist");
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO userlist (user_id, password, name) VALUES (?, ?, ?)")) {
            pstmt.setString(1, userId);
            pstmt.setString(2, password);
            pstmt.setString(3, userName);
            pstmt.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 사용자 로그인 자격 확인 메서드
     * 
     * @param userId   사용자 ID
     * @param password 사용자 비밀번호
     * @return 로그인 성공 여부
     */
    public boolean checkLoginCredentials(String userId, String password) {
        try (Connection conn = getCon("userlist");
             PreparedStatement pstmt = conn.prepareStatement("SELECT password FROM userlist WHERE user_id = ?")) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next() && rs.getString("password").equals(password);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 사용자 ID 중복 체크 메소드
     * 
     * @param userId 사용자 ID
     * @return 사용자 ID 중복 여부
     */
    public boolean isUserRegistered(String userId) {
        try (Connection conn = getCon("userlist");
             PreparedStatement pstmt = conn.prepareStatement("SELECT COUNT(*) FROM userlist WHERE user_id = ?")) {
            pstmt.setString(1, userId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    int count = rs.getInt(1);
                    return count > 0; // 0보다 크면 이미 회원가입된 회원
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false; // Error or user not registered
    }

    /**
     * 현재 유저의 ID를 받아오는 메서드
     * 
     * @param userId 사용자 ID
     * @return 현재 유저의 ID
     */
    public String getUserId(String userId) {
        String retrievedUserId = null;
        try {
            conn = getCon("userlist");
            String sql = "SELECT user_id FROM userlist WHERE user_Id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retrievedUserId = rs.getString("user_id");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            exit();
        }
        return retrievedUserId;
    }

    /**
     * 현재 유저의 이름을 받아오는 메서드
     * 
     * @param userId 사용자 ID
     * @return 현재 유저의 이름
     */
    public String getUserName(String userId) {
        String retrievedUserName = null;
        try {
            conn = getCon("userlist");
            String sql = "SELECT name FROM userlist WHERE user_Id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                retrievedUserName = rs.getString("name");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            exit();
        }
        return retrievedUserName;
    }

} // end class