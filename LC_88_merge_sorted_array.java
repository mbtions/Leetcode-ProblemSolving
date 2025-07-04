// import java.util.*;

class LC_88_merge_sorted_array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int A = m - 1, B = n - 1, C = m + n - 1;
        while (B >= 0) {
            if (A >= 0 && nums1[A] > nums2[B]) {
                nums1[C] = nums1[A];
                A--;
            } else {
                nums1[C] = nums2[B];
                B--;
            }
            C--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 0, 0, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3, 5, 6 };

        int m = 1, n = 5;

        merge(nums1, m, nums2, n);

        for (int i = 0; i < m + n; i++) {
            System.out.print(nums1[i] + ", ");
        }
    }

}