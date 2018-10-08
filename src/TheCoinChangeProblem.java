import java.util.ArrayList;
import java.util.TreeSet;

public class TheCoinChangeProblem {
    public static void main(String[] args) {
        int n = 4;
        long[] c = {1, 2, 3};
        System.out.println(getWays(n, c));
    }

    static long getWays(int n, long[] c) {
        long[] solution = new long[n + 1];
        solution[0] = 1;
        for (int i = 0; i < c.length; i++) {
            for (int j = (int)c[i]; j < solution.length; j++) {
                solution[j] += solution[j - (int)c[i]];
            }
        }
        return solution[n];
    }
}
