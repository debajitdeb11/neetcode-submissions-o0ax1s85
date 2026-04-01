class Solution {
    public int rob(int[] nums) {
        int[] excludeFirst = new int[nums.length + 1];
        int[] excludeLast = new int[nums.length + 1];

        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        excludeFirst[1] = nums[1];
        excludeFirst[2] = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            excludeFirst[i] = Math.max(excludeFirst[i-2] + nums[i], excludeFirst[i-1]);
        }

        excludeLast[0] = nums[0];
        excludeLast[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            excludeLast[i] = Math.max(excludeLast[i - 2] + nums[i], excludeLast[i - 1]);
        }

        return Math.max(excludeFirst[nums.length - 1], excludeLast[nums.length - 2]);
    }
}
