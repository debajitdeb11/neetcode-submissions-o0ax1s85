class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];

        Arrays.fill(memo, -1);

        int res = dfs(coins, amount, memo);

        return res == (int)1e9 ? -1 : res;
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        if (memo[amount] != -1) {
            return memo[amount];
        }

        if (amount == 0) {
            return 0;
        }

        int res = (int)1e9;

        for (int coin : coins) {
            if (amount - coin >= 0) {
                int take = dfs(coins, amount - coin, memo) + 1;

                res = Math.min(take, res);
            }
        }

        memo[amount] = res;
        return res;
    }
}
