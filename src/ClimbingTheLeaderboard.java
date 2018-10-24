import java.util.ArrayList;

public class ClimbingTheLeaderboard {
    public static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int[] result = new int[alice.length];
        ArrayList<Integer> places = new ArrayList();
        places.add(0);
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != places.get(places.size() - 1)) {
                places.add(scores[i]);
            }
        }

        int currentIndex = places.size() - 1;
        for (int i = 0; i < alice.length; i++) {
            while (currentIndex > 1 && alice[i] > places.get(currentIndex)) {
                currentIndex--;
            }

            if (alice[i] > places.get(currentIndex)) {
                result[i] = 1;
            } else if (alice[i] == places.get(currentIndex)) {
                result[i] = currentIndex;
            } else {
                result[i] = currentIndex + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
        int[] result = climbingLeaderboard(scores, alice);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
