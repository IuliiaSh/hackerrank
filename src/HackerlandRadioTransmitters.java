import java.util.Arrays;

public class HackerlandRadioTransmitters {
    public static void main(String[] args) {
        int k = 2;
        int[] x = {7, 2, 4, 6, 5, 9, 12, 11};
        System.out.println(hackerlandRadioTransmitters(x, k));
    }

    static int hackerlandRadioTransmitters(int[] x, int k) {
        int result = 0;
        Arrays.sort(x);
        int i = 0;
        int lastUncoveredHouse;
        int lastTransmitter;
        while (i < x.length) {
            lastUncoveredHouse = x[i];

            while (i < x.length - 1 && lastUncoveredHouse + k >= x[i + 1]) {
                i++;
            }
            lastTransmitter = x[i];
            result++;

            while (i < x.length - 1 && lastTransmitter + k >= x[i + 1]) {
                i++;
            }
            i++;
        }
        return result;
    }
}
