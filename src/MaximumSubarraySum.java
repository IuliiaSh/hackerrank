import java.util.TreeSet;

public class MaximumSubarraySum {
    public static void main(String[] args) {
        long[] a = {3, 3, 9, 9, 5};
        long m = 7;
        System.out.println(maximumSum(a, m));
    }

    static long maximumSum(long[] a, long m) {
        long current;
        long previous = 0;
        long result = 0;
        TreeSet<Long> sums = new TreeSet();
        for (int i = 0; i < a.length; i++) {
            current = (previous + a[i] % m) % m;
            result = Math.max(result, current);
            if (sums.ceiling(current) != null) {
                result = Math.max(result, (current - sums.ceiling(current) + m) % m);
            }
            sums.add(current);
            previous = current;
        }
        return result;
    }
}
