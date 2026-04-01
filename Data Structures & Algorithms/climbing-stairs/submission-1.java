class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        
        return climb(n, dp);
    }

    private int climb(int n, int[] dp) {
        if (dp[n] != 0) {
            return dp[n];
        }

        // base case
        if (n == 1 || n == 2) {
            return dp[n];
        }

        dp[n] = climb(n-1, dp) + climb(n-2, dp);

        return dp[n];
    }
}
