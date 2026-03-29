class Solution {
    public boolean isAnagram(String s, String t) {
        int[] hashS = new int[26];
        int[] hashT = new int[26];

        // hash of s
        for (int i = 0; i < s.length(); i++) {
            hashS[(int)(s.charAt(i)) - (int)('a')]++;
        }

        // hash of t
        for (int i = 0; i < t.length(); i++) {
            hashT[(int)(t.charAt(i)) - (int)('a')]++;
        }

        for (int i = 0; i < 26; i++) {
            if (hashS[i] != hashT[i]) {
                return false;
            }
        }

        return true;
    }
}
