import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        List<String> loginNames = Arrays.asList(
            "riya", "aman", "riya", "kavya",
            "aman", "dev", "zoya"
        );

        Set<String> uniqueUsers =
                new HashSet<>(loginNames);

        Set<String> firstSeenOrder =
                new LinkedHashSet<>(loginNames);

        System.out.println("Login names: " + loginNames);

        System.out.println(
            "Unique visitor count: " + uniqueUsers.size()
        );

        List<String> firstThree = new ArrayList<>();

        for (String name : firstSeenOrder) {
            if (firstThree.size() == 3) {
                break;
            }

            firstThree.add(name);
        }

        System.out.println(
            "First three distinct visitors: " + firstThree
        );
    }
}