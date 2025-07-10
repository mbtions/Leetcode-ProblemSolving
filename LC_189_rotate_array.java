class LC_189_rotate_array {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // when number of rotations is greater than the array length
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        rotate(nums, 3);
        System.out.println("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}