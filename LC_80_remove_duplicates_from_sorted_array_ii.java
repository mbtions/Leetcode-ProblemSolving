class LC_80_remove_duplicates_from_sorted_array_ii {
    public static int removeDuplicates(int[] nums) {
        int count = 0, count2 = 1;

        if (nums.length == 0) {
            return 0;
        }

        nums[count] = nums[count];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count2 = 1;
                count++;
                nums[count] = nums[i];
            } else {
                count2++;
                if (count2 <= 2) {
                    count++;
                    nums[count] = nums[i];
                }
            }
        }

        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        int k = removeDuplicates(nums);
        System.out.println("Unique elements (with at least twice of duplicated elements) are: " + k);
    }
}