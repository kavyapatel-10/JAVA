package lab02.Q1;

public class Thermostat {
    private String location;
    private int temperature;
    private static final int MIN = 16;
    private static final int MAX = 30;
    private static int activeCount = 0;

    
    public Thermostat(String location, int startTemp) {
        this.location = location;
        if (startTemp >= MIN && startTemp <= MAX) {
            this.temperature = startTemp;
        } else {
            this.temperature = 22;
        }
        activeCount++;
    }

    
    public Thermostat(String location) {
        this(location, 22);
    }

    
    public void raise() {
        if (this.temperature < MAX) {
            this.temperature++;
        } else {
            System.out.println("Already at maximum (" + MAX + ")");
        }
    }

    
    public void lower() {
        if (this.temperature > MIN) {
            this.temperature--;
        } else {
            System.out.println("Already at minimum (" + MIN + ")");
        }
    }

    
    public int getTemperature() {
        return this.temperature;
    }

    
    public static int getActiveCount() {
        return activeCount;
    }

    
    public static void main(String[] args) {
        
        Thermostat livingRoom = new Thermostat("Living Room", 20);
        Thermostat bedRoom = new Thermostat("Bedroom", 25);

        
        System.out.println("Testing Living Room: ");
        for (int i = 0; i < 10; i++) {
            livingRoom.raise();
            System.out.println("Current temp: " + livingRoom.getTemperature());
        }

        for (int i = 0; i < 20; i++) {
            livingRoom.lower();
            System.out.println("Current temp: " + livingRoom.getTemperature());
        }

        
        System.out.println("Active count: " + Thermostat.getActiveCount());
    }
}
