import java.util.HashMap;

public class DivisibleSumPairs {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        int[] ar = {1, 3, 2, 6, 1, 2};
        System.out.println(divisibleSumPairs(n, k, ar));
    }

    static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;
        HashMap<Integer, Integer> divisorCountMap = new HashMap();
        for (int i = 0; i < ar.length; i++) {
            if (divisorCountMap.containsKey(ar[i] % k)) {
                result += divisorCountMap.get(ar[i] % k);
            }
            int newKey = (ar[i] % k == 0) ? 0 : k - ar[i] % k;
            divisorCountMap.putIfAbsent(newKey, 0);
            divisorCountMap.compute(newKey, (key, value) -> value + 1);
        }
        return result;
    }
}
