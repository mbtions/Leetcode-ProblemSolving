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

- <code>nums1.length == m + n</code>
- <code>nums2.length == n</code>
- <code>0 <= m, n <= 200</code>
- <code>1 <= m + n <= 200</code>
- <code>-10<sup>9</sup> <= nums1[i], nums2[j] <= 10<sup>9</sup></code>

**Follow up:** Can you come up with an algorithm that runs in O(m + n) time?

_Accepted 4,702,303/8.9M_  
_Acceptance Rate 53.0%_

After brainstorming and trying code for about an hour and a half, referred to this [Video](https://www.youtube.com/watch?v=TTWKBqG-6IU) for code intuition.

<u>**Solution 1:**</u>

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

- <code>0 <= nums.length <= 100</code>
- <code>0 <= nums[i] <= 50</code>
- <code>0 <= val <= 100</code>

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

- <code>1 <= nums.length <= 3 \* 10<sup>4</sup></code>
- <code>-100 <= nums[i] <= 100</code>
- <code>nums is sorted in non-decreasing order.</code>

<u>**Solution 3:**</u>

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

- <code>1 <= nums.length <= 3 \* 10<sup>4</sup></code>
- <code>-104 <= nums[i] <= 10<sup>4</sup></code>
- <code>nums is sorted in non-decreasing order.</code>

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

- <code>n == nums.length</code>
- <code>1 <= n <= 5 \* 10<sup>4</sup></code>
- <code>-10<sup>9</sup> <= nums[i] <= 10<sup>9</sup></code>

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

- <code>1 <= nums.length <= 10<sup>5</sup></code>
- <code>-2<sup>31</sup> <= nums[i] <= 2<sup>31</sup> - 1</code>
- <code>0 <= k <= 10<sup>5</sup></code>

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

- <code>1 <= prices.length <= 10<sup>5</sup></code>
- <code>0 <= prices[i] <= 10<sup>4</sup></code>

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

**July 12, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 8:**

<u>**122. Best Time to Buy and Sell Stock II**</u>

You are given an array `prices` where `prices[i]` is the price of a given stock on the <code>i<sup>th</sup></code> day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

<u>**Example 1:**</u>  
**Input:** prices = [7,1,5,3,6,4]  
**Output:** 7  
**Explanation:** Buy on day 2 (`price = 1`) and sell on day 3 (`price = 5`), profit = 5-1 = 4.  
Then buy on day 4 (`price = 3`) and sell on day 5 (`price = 6`), profit = 6-3 = 3.  
Total profit is `4 + 3 = 7`.

<u>**Example 2:**</u>
**Input:** prices = [1,2,3,4,5]  
**Output:** 4  
**Explanation:** Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.  
Total profit is 4.

<u>**Example 3:**</u>  
**Input:** prices = [7,6,4,3,1]  
**Output:** 0  
**Explanation:** There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of `0`.

**Constraints:**

- <code>1 <= prices.length <= 3 \* 10<sup>4</sup></code>
- <code>0 <= prices[i] <= 10<sup>4</sup></code>

<u>**Solution 8:**</u>

**1. Greedy Approach**

    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i=1; i<prices.length; i++) {
            int dailyProfit = Math.max(0, prices[i] - prices[i-1]);
            totalProfit += dailyProfit;
        }

        return totalProfit;
    }

**July 13, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 9**

<u>**55. Jump Game**</u>

You are given an integer array `nums`. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return `true` if you can reach the last index, or `false` otherwise.

<u>**Example 1:**</u>  
**Input:** nums = [2,3,1,1,4]  
**Output:** true  
**Explanation:** Jump 1 step from index 0 to 1, then 3 steps to the last index.

<u>**Example 2:**</u>  
**Input:** nums = [3,2,1,0,4]  
**Output:** false  
**Explanation:** You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

**Constraints:**

- <code>1 <= nums.length <= 10<sup>4</sup></code>
- <code>0 <= nums[i] <= 10<sup>5</sup></code>

<u>**Solution 9:**</u>

    public boolean canJump(int[] nums) {
        // goal index
        int g = nums.length - 1;
        // if you are able to reach from
        // goal = last index to goal = first index
        // then you will found a solution
        for (int i=nums.length-2; i>=0; i--) {
            if (i + nums[i] >= g) {
                g = i;
            }
        }
        return g == 0;
    }

It is a very simple approach where we have gone from goal = last index to the position first index.

If the first index is reachable from goal then `canJump()` returns `true`, otherwise returns `false`.

**July 15, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 10**

<u>**45. Jump Game II**</u>

You are given a 0-indexed array of integers `nums` of length `n`. You are initially positioned at `nums[0]`.

Each element `nums[i]` represents the maximum length of a forward jump from index `i`. In other words, if you are at `nums[i]`, you can jump to any `nums[i + j]` where:

- `0 <= j <= nums[i]` and
- `i + j < n`

Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].

<u>**Example 1:**</u>  
**Input:** nums = [2,3,1,1,4]  
**Output:** 2  
**Explanation:** The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

<u>**Example 2:**</u>  
**Input:** nums = [2,3,0,1,4]  
**Output:** 2

**Constraints:**

- <code>1 <= nums.length <= 10<sup>4</sup></code>
- <code>0 <= nums[i] <= 1000</code>
- It's guaranteed that you can reach <code>nums[n - 1].</code>

<u>**Solution 10:**</u>

    class Solution {
        public int jump(int[] nums) {
            if (nums.length == 1 || nums.length == 0) {
                return 0;
            }

            // Initially the user starts from first index
            // i.e. i=0, therefore the current end & farthest
            // are first index only and jumps count is zero.
            int jumps = 0;
            int currentEnd = 0;
            int currentFarthest = 0;

            for (int i=0; // from first index
                i < nums.length - 1;
                // we only need to access till second last index for counting jumps
                i++
            ) {
                // calculate the farthest position possible
                // for current index
                currentFarthest = Math.max(currentFarthest, i + nums[i]);

                // On reaching currentEnd,
                // if found better option, in-between [i, currentEnd],
                // with jump to the more farther position than currentEnd
                // then update currentEnd to the currentFarthest
                if (i == currentEnd) {
                    jumps++;
                    currentEnd = currentFarthest;
                }
            }
            return jumps;
        }
    }

The approach mentioned above is very simple.

1. Initially, the user assumes the end and farthest position to be the same first index only.

   `int currentEnd = 0;`  
   `int currentFarthest = 0`  
   `int jumps = 0;`

2. Loop iterates from `i = 0` to `i = nums.length - 2`.  
   **Note:** `nums[nums.length - 1]` is goal position and it is not required to be accessed hence it is not there in the iteration range.

3. Now, calculate the farthest position possible in single jump.

   **Example:**  
   For nums = [ 4, 2, 1, 3, 6, 1, 2 ]; nums.length = 7

   `nums.length - 1 = 6`

   For `i = 0 && i < 6, currentEnd = 0, currentFarthest = 0`,
   <pre> currentFarthest = max(0, 0 + 4) = 4
   
   i == currentEnd => true
   :.  currentEnd = 4    </pre>

   Iterate till `currentEnd = 4` and find more better jump option with farthest position as compared to `currentEnd`

   For `i = 1 and i < 6 => true, currentEnd = 4, currentFarthest = 0`,
   <pre>currentFarthest = max(4, 1 + 2) = 4
   
   i == currentEnd => false</pre>

   For `i = 2 and i < 6 => true, currentEnd = 4, currentFarthest = 4`,
   <pre>currentFarthest = max(4, 2 + 1) = 4
   
   i == currentEnd => false</pre>

   For `i = 3 and i < 6 => true, currentEnd = 4, currentFarthest = 4`,
   <pre>currentFarthest = max(4, 3 + 3) = 6
   
   i == currentEnd => false</pre>

   For `i = 4 and i < 6 => true, currentEnd = 4, currentFarthest = 6`,
   <pre>currentFarthest = max(6, 4 + 6) = 10
   
   i == currentEnd => true
   :. currentEnd = 10</pre>

   For `i = 5 and i < 6 => true, currentEnd = 10, currentFarthest = 10`,
   <pre>currentFarthest = max(10, 5 + 1) = 10
   
   i == currentEnd => false</pre>

   For `i = 6 and i < 6 => false`  
   `currentEnd = 10, currentFarthest = 10`  
   loop condition fails.

4. The loop checks for better options and updates the currentEnd if found at in the end and increments `jumps`.

5. The answer is found with minimum number of jumps.

**July 17, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 11**

<u>**274. H-Index**</u>

Given an array of integers `citations` where `citations[i]` is the number of citations a researcher received for their <code>i<sup>th<sup></code> paper, return the researcher's h-index.

According to the [definition of h-index on Wikipedia](https://en.wikipedia.org/wiki/H-index): The h-index is defined as the maximum value of `h` such that the given researcher has published at least `h` papers that have each been cited at least `h` times.

<u>**Example 1:**</u>  
**Input:** citations = [3,0,6,1,5]  
**Output:** 3  
**Explanation:** [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.  
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

<u>**Example 2:**</u>  
**Input:** citations = [1,3,1]  
**Output:** 1

**Constraints:**

- `n == citations.length`
- `1 <= n <= 5000`
- `0 <= citations[i] <= 1000`

<u>**Solution 11:**</u>

**1. Approach 1: Brute Force Approach [O(n)]**

    public int hIndex(int[] citations) {
        int h = 0;

        if (citations.length == 1 && citations[0] == 0)
            return 0;

        for (int i = 0; i < citations.length; i++) {
            int count = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[i] <= citations[j]) {
                    count++;
                }
            }

            if (count >= citations[i]) {
                h = Math.max(h, citations[i]);
            } else {
                h = Math.max(h, count);
            }
        }
        return h;
    }

- Comparing each paper's citations number with every other and counting.

- If count is greater or equal than the citations number then update `h` otherwise, update with maximum of `count` value and `h` value.

**2. Optimized Approach**

    public int hIndex(int[] citations) {
        // total number of papers
        int n = citations.length;

        // frequency of paper per number of citations
        // where freq[i] is the number of papers
        // with total "i" citations
        int[] freq = new int[n+1];
        // initially, freq = [0, 0, 0, ...]

        // counting number of papers with i citations
        for (int i = 0; i < n; i++) {
            // when number of citations is more
            // than the number of papers
            // increment last element of freq[]
            if (citations[i] >= n) {
                freq[n] += 1;
            }
            // otherwise increment the number of papers
            // for i'th citation
            else {
                freq[citations[i]] += 1;
            }
        }

        // last index of freq
        int idx = n;
        // frequency of papers with citations
        // equal to or greater than 'n'
        int s = freq[n];

        // traverse high to low citations until reach
        // the index where 'h' is found
        while (s < idx) {
            idx--;
            s += freq[idx];
        }

        return idx;
    }

- In this approach, first we have found out the frequencies of papers with `i` citations

- Then we have traversed the frequencies of papers from high citations to low citations (i.e., loop `freq` in reverse order).  
  when reached the break point where number of papers are found such that h-index is followed, it is returned.

- Go through the comments in the above solution to understand better.

**July 19, 2025**

**<span style="color:orange; background-color:rgb(244, 235, 219); border-radius: 8px; padding: 5px;">Medium</span><br/>**
**Question 12**

<u>**380. Insert Delete GetRandom O(1)**</u>

Implement the `RandomizedSet` class:

- `RandomizedSet()` Initializes the `RandomizedSet` object.

- `bool insert(int val)` Inserts an item `val` into the set if not present. Returns `true` if the item was not present, `false` otherwise.

- `bool remove(int val)` Removes an item `val` from the set if present. Returns `true` if the item was present, `false` otherwise.

- `int getRandom()` Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.

You must implement the functions of the class such that each function works in average `O(1)` time complexity.

<u>**Example 1:**</u>  
**Input**

<pre>["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]  
[[], [1], [2], [2], [], [1], [2], []]</pre>

**Output**

<pre>[null, true, false, true, 2, true, false, 2]</pre>

**Explanation**

<pre>RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.</pre>

**Constraints:**

- <code>-2<sup>31</sup> <= val <= 2<sup>31</sup> - 1</code>
- At most <code>2 \* 10<sup>5</sup></code> calls will be made to insert, remove, and getRandom.
- There will be at least one element in the data structure when getRandom is called.
