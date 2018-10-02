public class Kangaroo {
    public static void main(String[] args) {
        System.out.println(kangaroo(0, 3, 4, 2));
    }

    static String kangaroo(int x1, int v1, int x2, int v2) {
        if (x1 == x2) {
            return "YES";
        } else if (x1 < x2) {
            if (v1 <= v2) {
                return "NO";
            }
            return canMeet(x1, v1, x2, v2);
        } else {
            if (v1 >= v2) {
                return "NO";
            }
            return canMeet(x2, v2, x1, v1);
        }
    }

    private static String canMeet(int minX, int minV, int maxX, int maxV) {
        while (minX < maxX) {
            minX += minV;
            maxX += maxV;
        }

        if (minX == maxX) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
