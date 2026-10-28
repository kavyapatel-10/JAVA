import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        String paragraph = "Java collections help us learn Java. "
                + "A map counts words, and Java code helps us learn.";

        Map<String, Integer> frequency = new HashMap<>();

        String[] words = paragraph.toLowerCase()
                .replaceAll("[^a-z0-9\\s]", "")
                .split("\\s+");

        for (String word : words) {
            if (!word.isBlank()) {
                frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
                );
            }
        }

        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort(
            Comparator
                .comparing(
                    Map.Entry<String, Integer>::getValue
                )
                .reversed()
                .thenComparing(Map.Entry::getKey)
        );

        System.out.println(
            "Paragraph word frequencies (highest first):"
        );

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(
                entry.getKey() + " : " + entry.getValue()
            );
        }
    }
}