class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = -(int)1e9;

        int curr = 0;
        for (int i : nums) {
            curr = curr + i;
            maxSum = Math.max(maxSum, curr);

            if (curr < 0) {
                curr = 0;
            }
        }

        return maxSum;
    }
}
