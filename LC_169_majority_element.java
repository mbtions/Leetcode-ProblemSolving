import java.util.HashMap;
import java.util.Map;

class LC_169_majority_element {

    public static int majorityElement(int[] nums) {
        int majority = -1;

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], 1);
            } else {
                hmap.put(nums[i], hmap.get(nums[i]) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                majority = entry.getKey();
                break;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        int element = majorityElement(nums);
        System.out.println("Majority element: " + element);
    }
}