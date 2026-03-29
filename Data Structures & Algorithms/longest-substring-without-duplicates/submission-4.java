class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        if (n == 0 || n == 1) {
            return n;
        }

        Set<Character> set = new HashSet<>();
        int maxLen = 0;

        int j = 0;

        for (int i = 0; i < n; i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(s.charAt(i));

            maxLen = Math.max(maxLen, i - j + 1);
        }

        return maxLen;
    }
}
