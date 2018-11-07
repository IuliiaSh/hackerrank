import java.util.ArrayList;

public class FormingMagicSquare {
    private static final int[][] magicSquares = {
            {4,9,2,3,5,7,8,1,6},
            {4,3,8,9,5,1,2,7,6},
            {2,9,4,7,5,3,6,1,8},
            {2,7,6,9,5,1,4,3,8},
            {8,1,6,3,5,7,4,9,2},
            {8,3,4,1,5,9,6,7,2},
            {6,7,2,1,5,9,8,3,4},
            {6,1,8,7,5,3,2,9,4}};

    public static int formingMagicSquare(int[][] s) {
        int[] input = convertMatrixToArray(s);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < magicSquares.length; i++) {
            result = Math.min(result, calculateCost(input, magicSquares[i]));
        }
        return result;
    }

    private static int[] convertMatrixToArray(int[][] matrix) {
        int[] result = new int[9];
        int index = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++) {
                result[index] = matrix[i][j];
                index++;
            }
        }
        return result;
    }

    private static int calculateCost(int[] input, int[] current) {
        int result = 0;
        for (int i = 0; i < input.length; i++) {
            result += Math.abs(input[i] - current[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] s = {{5, 3, 4}, {1, 5, 8}, {6, 4, 2}};
        System.out.println(formingMagicSquare(s));
    }
}
