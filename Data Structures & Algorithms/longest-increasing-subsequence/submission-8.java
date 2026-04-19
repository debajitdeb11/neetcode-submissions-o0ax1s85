class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int lts = (int)-1e9;

        for (int i = nums.length - 1; i >= 0; i--) {
            int val = dfs(i - 1, nums, i, dp);
            System.out.println(val);
            lts = Math.max(lts, val);
        }

        return lts;
    }

    private int dfs(int idx, int[] nums, int prevIdx, int[][] dp) {
        if (idx == -1) {
            return 1;
        }

        if(dp[idx][prevIdx] != -1) {
            return dp[idx][prevIdx];
        }

        if (nums[idx] < nums[prevIdx]) {
            int include = dfs(idx - 1, nums, idx, dp) + 1;
            int notInclude = dfs(idx - 1, nums, prevIdx, dp);

            dp[idx][prevIdx] = Math.max(include, notInclude);
        } else {
            dp[idx][prevIdx] = dfs(idx - 1, nums, prevIdx, dp);
        }

        return dp[idx][prevIdx];
    }
}
