class LC_26_remove_duplicates_from_sorted_array {
    public static int removeDuplicates(int[] nums) {
        int count = 0;

        if (nums.length == 0) {
            return count;
        }

        nums[count] = nums[count];

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] != nums[i - 1]) {
                count++;
                nums[count] = nums[i];
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 1, 2, 2, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 10 }; // 10 unique elements =>
                                                                             // 0,1,2,3,4,5,6,7,8,10
        int k = removeDuplicates(nums);
        System.out.println("Unique Elements are: " + k);
    }
}