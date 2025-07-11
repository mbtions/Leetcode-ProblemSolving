# Enhancing Problem Solving Skills with Top Leetcode Questions

[Top 150 Leetcode Questions](https://leetcode.com/studyplan/top-interview-150/)

**July 04, 2025**

**<span style="color:green; background-color:#003300; border-radius: 8px; padding: 5px;">Easy</span><br/>**
**Question 1:**

<u>**88. Merge Sorted Array**</u>

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

**Example 1:**  
**Input:** nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3  
**Output:** [1,2,2,3,5,6]  
**Explanation:** The arrays we are merging are [1,2,3] and [2,5,6].  
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.

**Example 2:**  
**Input:** nums1 = [1], m = 1, nums2 = [], n = 0  
**Output:** [1]  
**Explanation:** The arrays we are merging are [1] and [].  
The result of the merge is [1].

**Example 3:**  
**Input:** nums1 = [0], m = 0, nums2 = [1], n = 1  
**Output:** [1]  
Explanation: The arrays we are merging are [] and [1].  
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

**Constraints:**

- nums1.length == m + n
- nums2.length == n
- 0 <= m, n <= 200
- 1 <= m + n <= 200
- -109 <= nums1[i], nums2[j] <= 109

**Follow up:** Can you come up with an algorithm that runs in O(m + n) time?

_Accepted 4,702,303/8.9M_  
_Acceptance Rate 53.0%_

After brainstorming and trying code for about an hour and a half, referred to this [Video](https://www.youtube.com/watch?v=TTWKBqG-6IU) for code intuition.

<u>**Solution:**</u>

    public void merge(int[] nums1, int m, int[] nums2, int n) {
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

**July 06, 2025**

**<span style="color:green; background-color:#003300; border-radius: 8px; padding: 5px;">Easy</span><br/>**
**Question 2:**

<u>**27. Remove Element**</u>

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.

**Custom Judge:**  
The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int val = ...; // Value to remove
    int[] expectedNums = [...]; // The expected answer with correct length.
                                // It is sorted with no values equaling val.

    int k = removeElement(nums, val); // Calls your implementation

    assert k == expectedNums.length;
    sort(nums, 0, k); // Sort the first k elements of nums
    for (int i = 0; i < actualLength; i++) {
        assert nums[i] == expectedNums[i];
    }

If all assertions pass, then your solution will be accepted.

<u>**Example 1:**</u>  
**Input:** nums = [3,2,2,3], val = 3  
**Output:** 2, nums = [2,2,_,_]  
**Explanation:** Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).

<u>**Example 2:**</u>  
**Input:** nums = [0,1,2,2,3,0,4,2], val = 2  
**Output:** 5, nums = [0,1,4,0,3,_,_,_]  
**Explanation:** Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.  
**Note** that the five elements can be returned in any order.  
It does not matter what you leave beyond the returned k (hence they are underscores).

**Constraints:**

- 0 <= nums.length <= 100
- 0 <= nums[i] <= 50
- 0 <= val <= 100

<u>**Solution 2:**</u>

    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[count] = nums[j];
                count++;
            }
        }

        return count;
    }

**July 07, 2025**

**<span style="color:green; background-color:#003300; border-radius: 8px; padding: 5px;">Easy</span><br/>**
**Question 3:**

<u>**26. Remove Duplicates from Sorted Array**</u>

Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
Return k.

**Custom Judge:**  
The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }

If all assertions pass, then your solution will be accepted.

<u>**Example 1:**</u>  
**Input:** nums = [1,1,2]  
**Output:** 2, nums = [1,2,_]
**Explanation:** Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

<u>**Example 2:**</u>  
**Input:** nums = [0,0,1,1,1,2,2,3,3,4]  
**Output:** 5, nums = [0,1,2,3,4,_,_,_,_,_]  
**Explanation:** Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

**Constraints:**

- 1 <= nums.length <= 3 \* 104
- -100 <= nums[i] <= 100
- nums is sorted in non-decreasing order.

**Solution 3:**

    public int removeDuplicates(int[] nums) {
        int count = 0;

        if (nums.length == 0) {
            return count;
        }

        nums[count] = nums[count];

        for (int i=0; i<nums.length; i++) {
            if (i>0 && nums[i] != nums[i-1]) {
                count++;
                nums[count] = nums[i];
            }
        }

        return count+1;
    }

**July 08, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 4:**

<u>**80. Remove Duplicates from Sorted Array II**</u>

Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

**Custom Judge:**  
The judge will test your solution with the following code:

    int[] nums = [...]; // Input array
    int[] expectedNums = [...]; // The expected answer with correct length

    int k = removeDuplicates(nums); // Calls your implementation

    assert k == expectedNums.length;
    for (int i = 0; i < k; i++) {
        assert nums[i] == expectedNums[i];
    }

If all assertions pass, then your solution will be accepted.

<u>**Example 1:**</u>  
**Input:** nums = [1,1,1,2,2,3]  
**Output:** 5, nums = [1,1,2,2,3,_]  
**Explanation:** Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

<u>**Example 2:**</u>  
**Input:** nums = [0,0,1,1,1,1,2,3,3]  
**Output:** 7, nums = [0,0,1,1,2,3,3,_,_]  
**Explanation:** Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

**Constraints:**

- 1 <= nums.length <= 3 \* 104
- -104 <= nums[i] <= 104
- nums is sorted in non-decreasing order.

<u>**Solution 4:**</u>

    public int removeDuplicates(int[] nums) {
        int count = 0, count2 = 1;

        if (nums.length == 0) {
            return 0;
        }

        nums[count] = nums[count];

        for (int i=1; i<nums.length; i++) {
            if (nums[i] != nums[i-1]) {
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

**July 09, 2025**

**<span style="color:green; background-color:#003300; border-radius: 8px; padding: 5px;">Easy</span><br/>**
**Question 5:**

<u>**169. Majority Element**</u>

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.  
You may assume that the majority element always exists in the array.

<u>**Example 1:**</u>  
**Input:** nums = [3,2,3]  
**Output:** 3

<u>**Example 2:**</u>  
**Input:** nums = [2,2,1,1,1,2,2]  
**Output:** 2

**Constraints:**

- n == nums.length
- 1 <= n <= 5 \* 104
- -109 <= nums[i] <= 109

**Follow-up:** Could you solve the problem in linear time and in O(1) space?

<u>**Solution 5:**</u>

    public int majorityElement(int[] nums) {
        int majority = -1;

        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        for (int i=0; i<nums.length; i++) {
            if (!hmap.containsKey(nums[i])) {
                hmap.put(nums[i], 1);
            } else {
                hmap.put(nums[i], hmap.get(nums[i])+1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (entry.getValue() > nums.length/2) {
                majority = entry.getKey();
                break;
            }
        }

        return majority;
    }

In this question, for the follow-up to be fulfilled, you need to look for the Boyer-Moore Voting algorithm.

**Algorithm**

1.  Initialize two variables: `count` and `candidate`. Set `count` to `0` and `candidate` to an arbitrary value.
2.  Iterate through the array `nums`:
    - If count is `0`, assign the current element as the new `candidate` and increment `count` by `1`.
    - If the current element is the same as the `candidate`, increment `count` by 1.
    - If the current element is different from the `candidate`, decrement `count` by `1`.
3.  After the iteration, the `candidate` variable will hold the majority element.

        public int majortyElement( int[] nums)
        {
            int count = 0;
            int candidate = 0;

            for (num: nums) {

                if (count == 0)
                {
                    candidate = num;
                }

                count += (num==candidate) ? 1 : -1;
            }
        }

**July 10, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 6:**

<u>**189. Rotate Array**</u>

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

**<u>Example 1:</u>**  
**Input:** nums = [1,2,3,4,5,6,7], k = 3  
**Output:** [5,6,7,1,2,3,4]  
**Explanation:**  
rotate 1 steps to the right: [7,1,2,3,4,5,6]  
rotate 2 steps to the right: [6,7,1,2,3,4,5]  
rotate 3 steps to the right: [5,6,7,1,2,3,4]

<u>**Example 2:**</u>  
**Input:** nums = [-1,-100,3,99], k = 2  
**Output:** [3,99,-1,-100]  
**Explanation:**  
rotate 1 steps to the right: [99,-1,-100,3]  
rotate 2 steps to the right: [3,99,-1,-100]

**Constraints:**

- 1 <= nums.length <= 105
- -231 <= nums[i] <= 231 - 1
- 0 <= k <= 105

**Follow up:**  
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

<u>**Solution 6:**</u>

**1. Approach I: Brute Force Approach**

Shift each element one by one to the right using loop. **Note** that this solution will work well but it **may exceed the time limit**.

    public void rotate(int[] nums, int k) {
        for (int i=0; i<k; i++) { // number of rotations
            int temp = nums[nums.length-1];
            int j=nums.length-1;
            for (; j>0; j--) {
                nums[j] = nums[j-1];
            }
            nums[0] = temp;
        }
    }

**2. Approach II**

**Step 1:** Reverse the entire array.  
Let's say, we have an array `nums` with values below  
`nums = [1,2,3,4,5,6,7]`  
Reversed nums array is  
`nums = [7,6,5,4,3,2,1]`  
we have `k = 3`  
=> from index `0` to index `2`, rotated elements will be there,  
i.e. we need to reverse (or sort) first part such that we get `nums = [5,6,7,_,_,_,_]`

**Step 2:** Reverse the array from index `0` to index `k-1`, since `k` elements are required to be rotated right i.e. `k` largest elements will be appearing in the first part of the array.

After reverse from index `0` to `k-1 = 2`, we get `nums = [5,6,7,4,3,2,1]`

**Step 3:** Reverse the remaining array that is rotated (or shifted to the right) i.e. from index `k` to index `nums.length-1`

Now after final reverse of the remaining part, we get `nums = [5,6,7,1,2,3,4]`. Hence required array is obtained and therefore rotated upto `k=3` rotations.

<u>**Code:**</u>

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len; // when number of rotations is greater than the array length
        reverse(nums, 0, len-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, len-1);
    }

    public void reverse (int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

**July 11, 2025**

**<span style="color:green; background-color:#003300; border-radius: 8px; padding: 5px;">Easy</span><br/>**
**Question 7:**

<u>**121. Best Time to Buy and Sell Stock**</u>

You are given an array `prices` where `prices[i]` is the price of a given stock on the <code>i<sup>th</sup></code> day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return `0`.

<u>**Example 1:**</u>  
**Input:** prices = [7,1,5,3,6,4]
**Output:** 5
**Explanation:** Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

<u>**Example 2:**</u>  
**Input:** prices = [7,6,4,3,1]  
**Output:** 0  
**Explanation:** In this case, no transactions are done and the max profit = 0.

**Constraints:**

- 1 <= prices.length <= 105
- 0 <= prices[i] <= 104

<u>**Solution 7:**</u>

**1. Approach I: Brute Force Approach**

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int bestBuy = prices[0], maxProfit = 0;

        for (int i=1; i<prices.length; i++) {
            if (bestBuy < prices[i]) {
                maxProfit = maxProfit > (prices[i] - bestBuy) ? maxProfit : prices[i] - bestBuy;
            }

            bestBuy = bestBuy < prices[i] ? bestBuy : prices[i] ;
        }

        return maxProfit;
    }

In this approach -

- We have assumed each day as a selling day, therefore <code>i<sup>th</sup></code> day is the selling day.

- For each selling day, computed the best buy day with minimum value in the array of range `0 to i-1` and updated the maximum profit and best buy price as well.

- For detailed understanding, refer to this [video](https://youtu.be/WBzZCm46mFo?t=840)

<br/>

There is another brute force approach where -

- We can calculate the profit for each day by looking at the array afterwards the <code>i<sup>th</sup></code> day and keep it in another array
- After completing the loop for profit calculation for each day, we can run another loop to find the maximum profit among all profits for each day.
- In this approach <code>(refer to this [video](https://youtu.be/E2-heUEnZKU?t=204) for complete understanding of approach discussed)</code>, we are going forward in the array for calulating the profit.
- But there is still space for optimization as in this solution, we are going with the loops with complexity `O(n)` for two times.

**2. Approach II: Optimized Approach**

We are looping for once and calculating `buyPrice`, `currentProfit` and `maxProfit` each time.

In the end, we will get the solution with effective code and lesser loops.

Refer to this [video](https://youtu.be/E2-heUEnZKU?t=347) for better understanding of the code solution below:

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0], maxProfit = 0, currentProfit = 0;

        for (int i=1; i<prices.length; i++) {
            // we are updating buy price when getting lesser one
            if (buyPrice > prices[i]) {
                buyPrice = prices[i];
            }
            // if buy price is updated the computations will not
            // take place as the buying and selling days cannot
            // be the same day.
            else {
                currentProfit = prices[i] - buyPrice;
                maxProfit = Math.max(currentProfit, maxProfit);
            }
        }

        return maxProfit;
    }
