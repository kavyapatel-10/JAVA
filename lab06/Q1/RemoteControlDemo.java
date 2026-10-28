
interface Switchable {
    void on();
    void off();
    
    
    default void toggle() {
        System.out.println("Toggling device...");
    }
}


class Fan implements Switchable {
    private boolean isRunning = false;

    @Override
    public void on() {
        isRunning = true;
        System.out.println("Fan is now spinning.");
    }

    @Override
    public void off() {
        isRunning = false;
        System.out.println("Fan has stopped.");
    }

    @Override
    public void toggle() {
        if (isRunning) off(); else on();
    }
}

class Light implements Switchable {
    private boolean isOn = false;

    @Override
    public void on() {
        isOn = true;
        System.out.println("Light is now shining.");
    }

    @Override
    public void off() {
        isOn = false;
        System.out.println("Light is now dark.");
    }

    @Override
    public void toggle() {
        if (isOn) off(); else on();
    }
}


@FunctionalInterface
interface PowerSchedule {
    boolean allowed(Switchable device, int hour);
}


public class RemoteControlDemo {
    public static void main(String[] args) {
        
        Switchable[] devices = { new Fan(), new Light(), new Fan() };

        System.out.println("--- Part 1: Toggling All Devices ---");
        for (Switchable device : devices) {
            device.toggle();
        }

        System.out.println("\n--- Part 2: Anonymous Class Restriction (No restrictions) ---");
        PowerSchedule unrestricted = new PowerSchedule() {
            @Override
            public boolean allowed(Switchable device, int hour) {
                return true; 
            }
        };
        trySwitchOn(devices[0], 23, unrestricted);

        System.out.println("\n--- Part 3: Lambda Restriction (No Lights allowed after 10 PM) ---");
        PowerSchedule ecoMode = (device, hour) -> {
            if (device instanceof Light && (hour >= 22 || hour < 6)) {
                return false;
            }
            return true;
        };

        System.out.println("Trying Light at 11 PM:");
        trySwitchOn(new Light(), 23, ecoMode);

        System.out.println("Trying Fan at 11 PM:");
        trySwitchOn(new Fan(), 23, ecoMode);
    }

    
    private static void trySwitchOn(Switchable device, int hour, PowerSchedule schedule) {
        if (schedule.allowed(device, hour)) {
            System.out.print("Allowed: ");
            device.on();
        } else {
            System.out.println("Denied: Device usage is restricted at " + hour + ":00.");
        }
    }
}
