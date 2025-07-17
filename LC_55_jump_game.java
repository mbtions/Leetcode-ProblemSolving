class LC_55_jump_game {
    public static boolean canJump(int[] nums) {
        // goal index
        int g = nums.length - 1;
        // if you are able to reach from
        // goal = last index to goal = first index
        // then you will found a solution
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= g) {
                g = i;
            }
        }
        return g == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 0, 4 };
        boolean didJump = canJump(nums);
        System.out.println("You can Jump? => " + didJump);
    }
}