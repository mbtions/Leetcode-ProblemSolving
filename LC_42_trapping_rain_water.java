import java.util.Arrays;

class LC_42_trapping_rain_water {
    // method 1: brute force approach
    public static int trap1(int[] height) {
        int n = height.length;
        int[] lmax = new int[n];
        Arrays.fill(lmax, 0);
        int[] rmax = new int[n];
        Arrays.fill(rmax, 0);
        lmax[0] = height[0];
        rmax[n - 1] = height[n - 1];
        int totalWater = 0;

        for (int i = 1; i < n; i++)
            lmax[i] = Math.max(lmax[i - 1], height[i]);

        for (int i = n - 2; i >= 0; i--)
            rmax[i] = Math.max(rmax[i + 1], height[i]);

        for (int i = 0; i < n; i++) {
            int water = Math.min(lmax[i], rmax[i]) - height[i];
            totalWater = totalWater + water;
        }

        return totalWater;
    }

    // method 2: optimal approach
    public static int trap2(int[] height) {
        int ans = 0;
        int l = 0, r = height.length - 1;
        int lmax = 0, rmax = 0;

        while (l < r) {
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                ans += lmax - height[l];
                l++;
            } else {
                ans += rmax - height[r];
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        // int waterTrapped = trap1(height);
        int waterTrapped = trap2(height);
        System.out.println("Amount of Water Trapped: " + waterTrapped);
    }
}