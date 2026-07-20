

import java.util.Scanner;

public class CinemaShow {
    private String title;
    private int seatsAvailable;
    private final int capacity;
    private static int totalBooked = 0;


    public CinemaShow(String title, int capacity) {
        this.title = title;
        this.capacity = capacity;
        this.seatsAvailable = capacity;
    }

    
    public CinemaShow(String title) {
        this(title, 100);
    }

    
    public boolean book(int n) {
        if (n <= seatsAvailable) {
            seatsAvailable -= n;
            totalBooked += n;
            return true;
        }
        return false;
    }

    
    public void cancel(int n) {
        seatsAvailable += n;
        if (seatsAvailable > capacity) {
            seatsAvailable = capacity;
        }
    }

    
    public int getSeatsAvailable() {
        return seatsAvailable;
    }

    
    public static int getTotalBooked() {
        return totalBooked;
    }

    
    public static void main(String[] args) {
        
        CinemaShow show = new CinemaShow("Interstellar", 50);
        System.out.println("Movie: Interstellar | Capacity: 50");
        System.out.println("Initial seats available: " + show.getSeatsAvailable());

        
        boolean book1 = show.book(30);
        System.out.println("\nBooking 30 seats: " + book1);
        System.out.println("Seats remaining: " + show.getSeatsAvailable());

        
        boolean book2 = show.book(25);
        System.out.println("\nBooking 25 seats: " + book2);
        System.out.println("Seats remaining (unchanged): " + show.getSeatsAvailable());

        
        show.cancel(10);
        System.out.println("\nCancelled 10 seats.");
        System.out.println("Seats remaining: " + show.getSeatsAvailable());

        
        boolean book3 = show.book(15);
        System.out.println("\nBooking 15 seats: " + book3);
        System.out.println("Seats remaining: " + show.getSeatsAvailable());

        
        System.out.println("\nTotal historical booked seats (successful actions): " + CinemaShow.getTotalBooked());
    }
}

