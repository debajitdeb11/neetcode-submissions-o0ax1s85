class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int excludeFirstPrev = nums[1];
        int excludeFirstCurr = Math.max(nums[1], nums[2]);

        for (int i = 3; i < nums.length; i++) {
            int temp = excludeFirstPrev;
            excludeFirstPrev = excludeFirstCurr;
            excludeFirstCurr = Math.max(temp + nums[i], excludeFirstCurr);
        }

        int excludeLastPrev = nums[0];
        int excludeLastCurr = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length - 1; i++) {
            int temp = excludeLastPrev;
            excludeLastPrev = excludeLastCurr;
            excludeLastCurr = Math.max(nums[i] + temp, excludeLastCurr);
        }

        return Math.max(excludeFirstCurr, excludeLastCurr);
    }
}
