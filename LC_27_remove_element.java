class LC_27_remove_element {
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[count] = nums[j];
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 1, 8, 1 };
        int val = 1;
        int k = removeElement(nums, val);
        System.out.println(k + " elements are there other than val=" + val + " in the nums array.");
    }
}