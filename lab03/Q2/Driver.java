public class Driver {
    public static void main(String[] args) {
        
        Card[] cardsToAdd = {
            new Card("Ace", "Spades"),
            new Card("King", "Diamonds"),
            new Card("Queen", "Hearts"),
            new Card("Ace", "Spades"), // Duplicate card
            new Card("Jack", "Clubs")
        };

        
        Card[] cardStorage = new Card[cardsToAdd.length];
        int currentCount = 0;

        
        for (Card nextCard : cardsToAdd) {
            boolean isDuplicate = false;

            
            for (int i = 0; i < currentCount; i++) {
                if (cardStorage[i].equals(nextCard)) {
                    System.out.println("Duplicate found: " + nextCard);
                    isDuplicate = true;
                    break; // Stop checking once a duplicate is found
                }
            }

            
            if (!isDuplicate) {
                cardStorage[currentCount] = nextCard;
                currentCount++;
            }
        }
    }
}
