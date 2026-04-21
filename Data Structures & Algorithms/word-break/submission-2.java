class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Map<Integer, Boolean> memo = new HashMap<>();
        memo.put(s.length(), true);

        return dfs(s, wordDict, 0, memo);
    }

    private boolean dfs(String s, List<String> words, int idx, Map<Integer, Boolean> memo) {
        if (memo.containsKey(idx)) {
            return memo.get(idx);
        }

        if (idx == s.length()) {
            return true;
        }

        for (String w : words) {
            if (idx + w.length() <= s.length() && s.substring(idx, idx + w.length()).equals(w)) {
                if (dfs(s, words, idx + w.length(), memo)) {
                    memo.put(idx, true);
                    return true;
                }
            }
        }

        memo.put(idx, false);
        return false;
    }
}
