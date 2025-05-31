import java.util.*;

public class SimpleRecommendationSystem {

    public static void main(String[] args) {
        int[][] ratings = {
            {1, 1, 5},
            {1, 2, 3},
            {2, 1, 4},
            {2, 3, 2},
            {3, 1, 2},
            {3, 4, 4},
            {4, 2, 4},
            {4, 3, 5}
        };

        int targetUser = 1;

        Map<Integer, Double> itemScores = new HashMap<>();
        Map<Integer, Integer> itemCount = new HashMap<>();

        for (int[] r : ratings) {
            int user = r[0];
            int item = r[1];
            int rating = r[2];

            if (user != targetUser) {
                itemScores.put(item, itemScores.getOrDefault(item, 0.0) + rating);
                itemCount.put(item, itemCount.getOrDefault(item, 0) + 1);
            }
        }
      
        Set<Integer> ratedByUser = new HashSet<>();
        for (int[] r : ratings) {
            if (r[0] == targetUser) {
                ratedByUser.add(r[1]);
            }
        }

        System.out.println("Recommendations for User " + targetUser + ":");

        for (int item : itemScores.keySet()) {
            if (!ratedByUser.contains(item)) {
                double avg = itemScores.get(item) / itemCount.get(item);
                System.out.println("Item " + item + " - Estimated rating: " + avg);
            }
        }
    }
}
