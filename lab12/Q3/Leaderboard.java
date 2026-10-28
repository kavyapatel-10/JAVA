import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Kavya", 920);
        scores.put("Aanya", 980);
        scores.put("Dev", 920);
        scores.put("Rohan", 870);
        scores.put("Meera", 895);

        int topN = 3;

        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort(
            Comparator
                .comparing(
                    Map.Entry<String, Integer>::getValue
                )
                .reversed()
                .thenComparing(Map.Entry::getKey)
        );

        System.out.println("Top " + topN + " players:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {

            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                (i + 1) + ". " + player.getKey()
                + " - " + player.getValue()
            );
        }

        System.out.println(
            "Tie-break: player name in ascending alphabetical order"
        );
    }
}