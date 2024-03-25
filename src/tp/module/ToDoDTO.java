package tp.module;

public class ToDoDTO {
    private int id;
    private String data;

    // 기본 생성자
    public ToDoDTO() {}

    // 매개변수를 받는 생성자
    public ToDoDTO(int id, String data) {
        this.id = id;
        this.data = data;
    }

    // Getter 메서드
    public int getId() {
        return id;
    }

    // Setter 메서드
    public void setId(int id) {
        this.id = id;
    }

    // Getter 메서드
    public String getData() {
        return data;
    }

    // Setter 메서드
    public void setData(String data) {
        this.data = data;
    }

    // 객체를 문자열로 표현하는 메서드
    @Override
    public String toString() {
        return data;
    }
}
