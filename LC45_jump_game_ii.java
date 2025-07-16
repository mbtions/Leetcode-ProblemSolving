class LC45_jump_game_ii {
    public static int jump(int[] nums) {
        if (nums.length == 1 || nums.length == 0) {
            return 0;
        }
        // Initially the user starts from first index
        // i.e. i=0, therefore the current end & farthest
        // are first index only and jumps count is zero.
        int jumps = 0;
        int currentEnd = 0;
        int currentFarthest = 0;

        for (int i = 0; // from first index
                i < nums.length - 1; // since jump to last index will already be incremented on reaching currentEnd
                i++) {
            // calculate the farthest position possible for current index
            currentFarthest = Math.max(currentFarthest, i + nums[i]);

            // On reaching currentEnd, if found better option, in-between [i, currentEnd],
            // with jump to the more farther position than currentEnd then update currentEnd
            // to the currentFarthest
            if (i == currentEnd) {
                jumps++;
                currentEnd = currentFarthest;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 1, 3, 6, 2 };
        int minJumps = jump(nums);
        System.out.println("Minimum Jumps: " + minJumps);
    }
}