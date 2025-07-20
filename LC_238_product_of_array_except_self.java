import java.util.Arrays;

class LC_238_product_of_array_except_self {
    public static int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, 1);

        // Step 1: Calculate Prefix products
        for (int i = 0, curr = 1; i < nums.length; i++) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        // Step 2: Calculate and Multiply Suffix products in Prefix products stored in
        // ans array
        for (int i = nums.length - 1, curr = 1; i >= 0; i--) {
            ans[i] *= curr;
            curr *= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        int[] products = productExceptSelf(nums);
        for (int product : products) {
            System.out.print(product + " ");
        }
    }
}