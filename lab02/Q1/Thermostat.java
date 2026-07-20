

import java.util.Scanner;

public class Thermostat{
   
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

    
    public boolean lower() {
        if (this.temperature > MIN) {
            this.temperature--;
            return true;
        } else {
            System.out.println("Already at minimum (" + MIN + ")");
            return false;
        }
    }

    
    public int getTemperature() {
        return this.temperature;
    }

    
    public static int getActiveCount() {
        return activeCount;
    }

    
    public static void main(String[] args) {
        
        Thermostat thermostat1 = new Thermostat("Living Room", 20);
        Thermostat thermostat2 = new Thermostat("Bedroom", 25);

        
        System.out.println("Testing Living Room: ");
        for (int i = 0; i < 10; i++) {
            thermostat1.raise();
            System.out.println("Current temp: " + thermostat1.getTemperature());
        }

        for (int i = 0; i < 20; i++) {
            if(!thermostat1.lower()) {
                break;
            }
            
            System.out.println("Current temp: " + thermostat1.getTemperature());
        }

        
        System.out.println("Active count: " + Thermostat.getActiveCount());
    }
}
