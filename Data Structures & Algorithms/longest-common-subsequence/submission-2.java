class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        char[] word = m < n ? text1.toCharArray() : text2.toCharArray();
        char[] seq = m < n ? text2.toCharArray() : text1.toCharArray();

        int[][] dp = new int[word.length][seq.length];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        return dfs(0, 0, dp, word, seq);
    }

    private int dfs(int wIdx, int sIdx, int[][] dp, char[] word, char[] seq) {
        if (wIdx == word.length || sIdx == seq.length) {
            return 0;
        }

        if (dp[wIdx][sIdx] != -1) {
            return dp[wIdx][sIdx];
        }

        if (word[wIdx] == seq[sIdx]) {
            int match = dfs(wIdx + 1, sIdx + 1, dp, word, seq) + 1;
            dp[wIdx][sIdx] = match;
        } else {
            int incSeq = dfs(wIdx, sIdx + 1, dp, word, seq);
            int incWord = dfs(wIdx + 1, sIdx, dp, word, seq);
            int incBoth = dfs(wIdx + 1, sIdx + 1, dp, word, seq);

            dp[wIdx][sIdx] = Math.max(incSeq, Math.max(incWord, incBoth));
        }

        return dp[wIdx][sIdx];
    }
}
