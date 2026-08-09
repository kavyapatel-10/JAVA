import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        String[] logs = {
            "10:05 alice Hello there",
            "10:06 bob How are you?",
            "10:07 malformed",
            "10:08 charlie Good morning"
        };
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter keyword: ");
        String keyword = sc.nextLine();

        ChatFilter.filterLogs(logs, keyword);

        sc.close();
    }
}
