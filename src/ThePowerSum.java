import java.util.ArrayList;

public class ThePowerSum {
    private static ArrayList<Integer> powers;
    private static int sum;

    public static void main(String[] args) {
        System.out.println(powerSum(10, 2));
    }

    static int powerSum(int X, int N) {
        powers = new ArrayList();
        for (int i = 1; i < (int)Math.pow(X, (double)1 / N) + 1; i++) {
            powers.add((int)Math.pow(i, N));
        }
        sum = X;
        int currentSum = 0;
        int currentIndex = 0;
        return findPowers(currentSum, currentIndex);
    }

    private static int findPowers(int currentSum, int currentIndex) {
        if (currentSum == sum) {
            return 1;
        }

        if (currentIndex == powers.size()) {
            return 0;
        }

        return findPowers(currentSum, currentIndex + 1) +
                findPowers(currentSum + powers.get(currentIndex), currentIndex + 1);
    }
}
