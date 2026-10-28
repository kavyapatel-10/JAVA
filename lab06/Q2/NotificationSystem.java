import java.util.Arrays;


@FunctionalInterface
interface Notifier {
    void send(String message);
}


interface Urgent {}


public class NotificationSystem {

    public static void main(String[] args) {
        
        Notifier emailNotifier = message -> 
            System.out.println("Email sent: " + message);

        
        Notifier smsNotifier = (Notifier & Urgent) message -> 
            System.out.println("SMS sent (URGENT): " + message);

        
        Notifier[] notifiers = { emailNotifier, smsNotifier };

        
        String alertMessage = "System update scheduled for midnight.";
        System.out.println("--- Broadcasting Message ---");
        broadcast(notifiers, alertMessage);
    }

    
    public static void broadcast(Notifier[] notifiers, String message) {
        for (Notifier notifier : notifiers) {
            
            if (notifier instanceof Urgent) {
                notifier.send(message);
                notifier.send(message); 
            } else {
                notifier.send(message);
            }
        }
    }
}
