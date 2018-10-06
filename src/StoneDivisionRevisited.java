import java.util.HashMap;

public class StoneDivisionRevisited {
    private static HashMap<Long, Long> memo;
    private static long[] divisors;

    public static void main(String[] args) {
        long n = 12;
        long[] s = {2, 3, 4};
        System.out.println(stoneDivision(n, s));
    }

    static long stoneDivision(long n, long[] s) {
        memo = new HashMap();
        divisors = s;
        return divideStones(n);
    }

    private static long divideStones(long stones) {
        if (memo.containsKey(stones)) {
            return memo.get(stones);
        }

        long result = 0L;
        long currentResult;
        long currentDivisor;
        for (int i = 0; i < divisors.length; i++) {
            currentDivisor = divisors[i];
            if (stones > currentDivisor && stones % currentDivisor == 0) {
                currentResult = 1 + currentDivisor * divideStones(stones / currentDivisor);
                result = Math.max(result, currentResult);
            }
        }
        memo.put(stones, result);
        return result;
    }
}
