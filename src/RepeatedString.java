public class RepeatedString {
    public static void main(String[] args) {
        String s = "aba";
        long n = 10;
        System.out.println(repeatedString(s, n));
    }

    static long repeatedString(String s, long n) {
        int[] occurrences = new int[s.length() + 1];
        int currentOccurrence = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                currentOccurrence++;
            }
            occurrences[i + 1] = currentOccurrence;
        }
        return (n / s.length()) * currentOccurrence + occurrences[(int)(n % s.length())];
    }
}
