class LC_4_median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0;
        int i = 0, j = 0, k = 0;
        int[] merged = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            } else {
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i < nums1.length) {
            merged[k] = nums1[i];
            k++;
            i++;
        }
        while (j < nums2.length) {
            merged[k] = nums2[j];
            k++;
            j++;
        }
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) { // 0 1 2 3 4 5
            median = (double) (merged[length / 2 - 1] + merged[length / 2]) / 2;
        } else { // 0 1 2 3 4
            median = merged[length / 2];
        }
        return median;
    }

    public static void main(String[] args) {
        int[] arr1 = { 1, 3, 6 };
        int[] arr2 = { 2, 4, 5 }; // 1 2 3 4 5 6 => (3+4)/2 = 3.5
        System.out.printf("Median: %f", findMedianSortedArrays(arr1, arr2));
    }
}