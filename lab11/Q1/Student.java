import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    int id;
    String name;
    transient String sessionToken;

    Student(int id, String name, String sessionToken) {
        this.id = id;
        this.name = name;
        this.sessionToken = sessionToken;
    }

    public String toString() {
        return "Student{id=" + id + ", name='" + name
            + "', sessionToken='" + sessionToken + "'}";
    }
}