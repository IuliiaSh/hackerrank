public class JumpingOnTheClouds {
    public static void main(String[] args) {
        int[] c = {0, 0, 1, 0, 0, 1, 0};
        System.out.println(jumpingOnClouds(c));
    }

    static int jumpingOnClouds(int[] c) {
        int result = 0;
        int i = 0;
        while (i < c.length - 2) {
            if (c[i + 2] != 1) {
                i += 2;
            } else {
                i += 1;
            }
            result++;
        }
        if (i < c.length - 1) {
            result++;
        }
        return result;
    }
}
