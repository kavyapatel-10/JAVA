import java.lang.annotation.*;
import java.lang.reflect.Field;

// Custom Column annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

// Student class
class Student {

    @Column(name = "student_id")
    int id;

    @Column(name = "student_name")
    String name;

    @Column(name = "student_age")
    int age;

    public String toString() {
        return "Student ID: " + id +
                ", Name: " + name +
                ", Age: " + age;
    }
}

// Mapper class
class ObjectMapper {

    public static void mapObject(
            Object obj,
            String[] headers,
            String[] data) throws Exception {

        Class<?> cls = obj.getClass();

        Field[] fields = cls.getDeclaredFields();

        for (Field field : fields) {

            // Check Column annotation
            if (field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);

                String columnName = column.name();

                int index = -1;

                // Find matching header
                for (int i = 0; i < headers.length; i++) {

                    if (headers[i].equals(columnName)) {
                        index = i;
                        break;
                    }
                }

                // Handle missing column
                if (index == -1) {
                    System.out.println(
                            "Missing column: " + columnName);
                    continue;
                }

                if (index >= data.length) {
                    System.out.println(
                            "Missing data for column: " + columnName);
                    continue;
                }

                field.setAccessible(true);

                String value = data[index];

                // Convert value to appropriate type
                if (field.getType() == int.class) {
                    field.setInt(obj, Integer.parseInt(value));
                }
                else if (field.getType() == String.class) {
                    field.set(obj, value);
                }
            }
        }
    }
}

// Main class
public class ColumnMapping {

    public static void main(String[] args) throws Exception {

        // CSV header row
        String[] headers = {
                "student_id",
                "student_name",
                "student_age"
        };

        // CSV data row
        String[] data = {
                "101",
                "Rahul",
                "20"
        };

        Student student = new Student();

        ObjectMapper.mapObject(student, headers, data);

        System.out.println(student);
    }
}