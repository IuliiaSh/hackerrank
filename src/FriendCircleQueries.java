import java.util.ArrayList;
import java.util.HashMap;

public class FriendCircleQueries {
    private static ArrayList<Integer> rootIdByStorageId = new ArrayList();
    private static HashMap<Integer, Integer> inputIdToStorageIdMap = new HashMap();
    private static HashMap<Integer, Integer> rootIdToTreeSizeMap = new HashMap();

    public static void main(String[] args) {
        int[][] queries = {{1, 2}, {3, 4}, {1, 3}, {5, 7}, {5, 6}, {7, 4}};
        int[] result = maxCircle(queries);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static int[] maxCircle(int[][] queries) {
        int[] result = new int[queries.length];
        int firstInputId;
        int secondInputId;
        int firstStorageId;
        int secondStorageId;
        int firstRootId;
        int secondRootId;
        int newRootId;
        for (int i = 0; i < queries.length; i++) {
            firstInputId = queries[i][0];
            secondInputId = queries[i][1];
            firstStorageId = getOrStore(firstInputId);
            secondStorageId = getOrStore(secondInputId);
            firstRootId = getRoot(firstStorageId);
            secondRootId = getRoot(secondStorageId);
            newRootId = unite(firstRootId, secondRootId);
            result[i] = (i == 0) ? 2 : Math.max(result[i - 1], rootIdToTreeSizeMap.get(newRootId));
        }
        return result;
    }

    private static int getOrStore(int inputId) {
        int storageId = inputIdToStorageIdMap.getOrDefault(inputId, -1);
        if (storageId == -1) {
            storageId = store(inputId);
        }
        return storageId;
    }

    private static int store(int inputId) {
        int storageId = rootIdByStorageId.size();
        rootIdByStorageId.add(storageId);
        inputIdToStorageIdMap.put(inputId, storageId);
        rootIdToTreeSizeMap.put(storageId, 1);
        return storageId;
    }

    private static int getRoot(int storageId) {
        int result = storageId;
        ArrayList<Integer> path = new ArrayList<Integer>();
        while (rootIdByStorageId.get(result) != result) {
            path.add(result);
            result = rootIdByStorageId.get(result);
        }
        updateRoot(path, result);
        return result;
    }

    private static void updateRoot(ArrayList<Integer> path, int result) {
        for (Integer node : path) {
            rootIdByStorageId.set(node, result);
        }
    }

    private static int unite(int firstRootId, int secondRootId) {
        int result = firstRootId;
        if (firstRootId != secondRootId) {
            if (rootIdToTreeSizeMap.get(firstRootId) < rootIdToTreeSizeMap.get(secondRootId)) {
                addParentRoot(firstRootId, secondRootId);
                result = secondRootId;
            } else {
                addParentRoot(secondRootId, firstRootId);
            }
        }
        return result;
    }

    private static void addParentRoot(int firstRootId, int secondRootId) {
        rootIdByStorageId.set(firstRootId, secondRootId);
        rootIdToTreeSizeMap.put(secondRootId, rootIdToTreeSizeMap.get(secondRootId) + rootIdToTreeSizeMap.get(firstRootId));
        rootIdToTreeSizeMap.remove(firstRootId);
    }
}