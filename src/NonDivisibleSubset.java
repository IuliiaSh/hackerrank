public class NonDivisibleSubset {
    static int nonDivisibleSubset(int k, int[] S) {
        int[] reminders = new int[k];
        for (int i = 0; i < S.length; i++) {
            reminders[S[i] % k]++;
        }

        int result = 0;
        if (reminders[0] > 0) {
            result++;
        }
        for (int i = 1, j = reminders.length - i; i < j; i++, j--) {
            result += Math.max(reminders[i], reminders[j]);
        }
        if (reminders.length % 2 == 0 && reminders[reminders.length % 2 + 1] > 0) {
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        int k = 7;
        int[] S = {278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436};
        System.out.println(nonDivisibleSubset(k, S));
    }
}
