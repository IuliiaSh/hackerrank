import java.util.ArrayList;
import java.util.Stack;

public class JourneyToTheMoon {
    public static void main(String[] args) {
        int n = 5;
        int[][] astronaut = {{0, 1}, {2, 3}, {0, 4}};
        System.out.println(journeyToMoon(n, astronaut));
    }

    static long journeyToMoon(int n, int[][] astronaut) {
        ArrayList<Integer>[] adjacencyList = getAdjacencyList(n, astronaut);
        ArrayList<Integer> countrySize = getCountrySize(adjacencyList);
        return getCombinations(countrySize);
    }

    private static ArrayList<Integer>[] getAdjacencyList(int n, int[][] astronaut) {
        ArrayList<Integer>[] result = (ArrayList<Integer>[]) new ArrayList[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = new ArrayList();
        }

        for (int i = 0; i < astronaut.length; i++) {
            result[astronaut[i][0]].add(astronaut[i][1]);
            result[astronaut[i][1]].add(astronaut[i][0]);
        }
        return result;
    }

    private static ArrayList<Integer> getCountrySize(ArrayList<Integer>[] adjacencyList) {
        ArrayList<Integer> result = new ArrayList();
        int currentNode;
        int nextNode;
        int currentSize = 0;
        boolean[] isVisited = new boolean[adjacencyList.length];
        Stack<Integer> toBeVisited = new Stack();
        for (int i = 0; i < adjacencyList.length; i++) {
            if (!isVisited[i]) {
                currentSize = 0;
                toBeVisited.push(i);
                isVisited[i] = true;
                while (!toBeVisited.empty()) {
                    currentNode = toBeVisited.pop();
                    currentSize++;
                    for (int j = 0; j < adjacencyList[currentNode].size(); j++) {
                        nextNode = adjacencyList[currentNode].get(j);
                        if (!isVisited[nextNode]) {
                            toBeVisited.push(nextNode);
                            isVisited[nextNode] = true;
                        }
                    }
                }
                result.add(currentSize);
            }
        }
        return result;
    }

    private static long getCombinations(ArrayList<Integer> countrySize) {
        long result = 0;
        long currentSize = 0;
        for (int i = 0; i < countrySize.size(); i++) {
            result += countrySize.get(i) * currentSize;
            currentSize += countrySize.get(i);
        }
        return result;
    }
}
