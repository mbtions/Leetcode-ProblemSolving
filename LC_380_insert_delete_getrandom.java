import java.util.*;

public class LC_380_insert_delete_getrandom {
    public static void main(String[] args) {
        RandomizedSet obj = null;

        String[] operations = { "RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert",
                "getRandom" };
        Integer[][] numbers = { {}, { 1 }, { 2 }, { 2 }, {}, { 1 }, { 2 }, {} };
        String[] outputs = new String[operations.length];
        int i = 0;

        for (String operation : operations) {
            if (operation.equals("RandomizedSet")) {
                obj = new RandomizedSet();
                outputs[i] = "null";
            } else if (operation.equals("insert")) {
                int val = numbers[i][0];
                boolean output = obj.insert(val);
                outputs[i] = output ? "true" : "false";
            } else if (operation.equals("remove")) {
                int val = numbers[i][0];
                boolean output = obj.remove(val);
                outputs[i] = output ? "true" : "false";
            } else if (operation.equals("getRandom")) {
                int randomNum = obj.getRandom();
                outputs[i] = randomNum + "";
            }
            i++;
        }

        System.out.print("output: [");
        for (int j = 0; j < outputs.length; j++) {
            System.out.print(outputs[j]);
            if (j < outputs.length - 1) {
                System.out.print(", ");
            } else {
                System.out.print("");
            }
        }
        System.out.print("]");
    }
}

class RandomizedSet {
    Set<Integer> randomSet;

    public RandomizedSet() {
        randomSet = new HashSet<Integer>();
    }

    public boolean insert(int val) {
        if (randomSet.contains(val))
            return false;
        randomSet.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!randomSet.contains(val))
            return false;
        randomSet.remove(val);
        return true;
    }

    public int getRandom() {
        Integer[] arr = randomSet.toArray(new Integer[randomSet.size()]);
        int idx = new Random().nextInt(arr.length);
        return arr[idx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
