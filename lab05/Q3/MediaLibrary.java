abstract class Media {
    protected String title;
    protected int lateDays;

    Media(String title, int lateDays) {
        this.title = title;
        this.lateDays = lateDays;
    }

    abstract double lateFee();
}

class Book extends Media {
    Book(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double lateFee() {
        return lateDays * 2;
    }
}

class Movie extends Media {
    Movie(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double lateFee() {
        return lateDays * 5;
    }
}

class Game extends Media {
    Game(String title, int lateDays) {
        super(title, lateDays);
    }

    @Override
    double lateFee() {
        return lateDays * 8;
    }
}

public class MediaLibrary {
    public static void main(String[] args) {
        Media[] items = {
            new Book("Java Basics", 4),
            new Movie("Inception", 3),
            new Game("Minecraft", 5),
            new Book("Data Structures", 2)
        };

        double total = 0;

        for (Media item : items) {
            double fee = item.lateFee();
            System.out.println(item.title + " Late Fee: " + fee);
            total += fee;
        }

        System.out.println("Total Late Fees: ₹" + total);
    }
}