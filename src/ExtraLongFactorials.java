import java.math.BigInteger;

public class ExtraLongFactorials {
    static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;
        int nextMultiplier = n;
        while (nextMultiplier > 1) {
            result = result.multiply(BigInteger.valueOf(nextMultiplier));
            nextMultiplier--;
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        extraLongFactorials(30);
    }
}
