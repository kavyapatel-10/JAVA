

public class Parkinglot {
    private int twoWheelers;
    private int fourWheelers;
    private final int twoCap;
    private final int fourCap;
    private static long revenue = 0;

    
    public Parkinglot(int twoCap, int fourCap) {
        this.twoCap = twoCap;
        this.fourCap = fourCap;
        this.twoWheelers = 0;
        this.fourWheelers = 0;
    }

    
    public void park(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers < twoCap) {
                twoWheelers++;
                revenue += 20;
                System.out.println("Parked two-wheeler successfully.");
            } else {
                System.out.println("Full");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers < fourCap) {
                fourWheelers++;
                revenue += 40;
                System.out.println("Parked four-wheeler successfully.");
            } else {
                System.out.println("Full");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    
    public void leave(String type) {
        if (type.equalsIgnoreCase("two")) {
            if (twoWheelers > 0) {
                twoWheelers--;
                System.out.println("Two-wheeler left.");
            } else {
                System.out.println("No two-wheelers currently parked.");
            }
        } else if (type.equalsIgnoreCase("four")) {
            if (fourWheelers > 0) {
                fourWheelers--;
                System.out.println("Four-wheeler left.");
            } else {
                System.out.println("No four-wheelers currently parked.");
            }
        } else {
            System.out.println("Invalid vehicle type.");
        }
    }

    
    public void displayStatus() {
        System.out.println("Final Occupancy - Two Wheelers: " + twoWheelers + "/" + twoCap);
        System.out.println("Final Occupancy - Four Wheelers: " + fourWheelers + "/" + fourCap);
        System.out.println("Total Revenue: " + revenue);
    }

    public static void main(String[] args) {
        
        Parkinglot lot = new Parkinglot(2, 1);

        System.out.println("--- Simulation Started ---");
        
        
        lot.park("two");  
        lot.park("two");  
        lot.park("two"); 
        
        lot.park("four"); 
        lot.park("four"); 

        
        lot.leave("two"); 
        lot.park("two");  
        
        lot.leave("four"); 
        lot.leave("four"); 

        System.out.println("\n--- Final Status ---");
        lot.displayStatus();
    }
}

