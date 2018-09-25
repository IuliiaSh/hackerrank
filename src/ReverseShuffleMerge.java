import java.util.HashMap;
import java.util.Map;

public class ReverseShuffleMerge {
    private static HashMap<Character, Integer> leftChars;
    private static HashMap<Character, Integer> neededChars;
    private static HashMap<Character, Integer> skippedChars;

    public static void main(String[] args) {
        String s = "jjcddjggcdjd";
        System.out.println(reverseShuffleMerge(s));
    }

    static String reverseShuffleMerge(String s) {
        // forget about reverse - now merge is done on original string and its shuffle
        s = new StringBuilder(s).reverse().toString();

        StringBuilder sb = new StringBuilder();
        createLeftChars(s);
        createNeededChars();
        int lastIndex = -1;
        int currentIndex;
        char currentChar;
        int bestIndex;
        char bestChar;
        while (sb.length() < s.length() / 2) {
            skippedChars = new HashMap();
            currentIndex = lastIndex + 1;
            bestIndex = lastIndex;
            bestChar = '{';
            do {
                currentChar = s.charAt(currentIndex);
                if (neededChars.get(currentChar) > 0 && currentChar < bestChar) {
                    bestChar = currentChar;
                    bestIndex = currentIndex;
                }
                skipChar(currentChar);
                currentIndex++;
            } while(canBeSkipped(currentChar));

            sb.append(bestChar);
            for (int i = lastIndex + 1; i <= bestIndex; i++) {
                leftChars.compute(s.charAt(i), (key, value) -> value - 1);
            }
            neededChars.compute(bestChar, (key, value) -> value - 1);
            lastIndex = bestIndex;
        }
        return sb.toString();
    }

    private static void createLeftChars(String s) {
        leftChars = new HashMap();
        char currentChar;
        for (int i = 0; i < s.length(); i++) {
            currentChar = s.charAt(i);
            leftChars.putIfAbsent(currentChar, 0);
            leftChars.compute(currentChar, (key, value) -> value + 1);
        }
    }

    private static void createNeededChars() {
        neededChars = new HashMap();
        for (Map.Entry<Character, Integer> e : leftChars.entrySet()) {
            neededChars.put(e.getKey(), e.getValue() / 2);
        }
    }

    private static void skipChar(char currentChar) {
        skippedChars.putIfAbsent(currentChar, 0);
        skippedChars.compute(currentChar, (key, value) -> value + 1);
    }

    private static boolean canBeSkipped(char currentChar) {
        return (leftChars.get(currentChar) - skippedChars.getOrDefault(currentChar, 0) - neededChars.get(currentChar)) >= 0;
    }
}