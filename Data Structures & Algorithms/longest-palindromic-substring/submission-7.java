class Solution {
    public String longestPalindrome(String s) {
        // brute force approach
        int maxCount = 0;
        String ans = "";

        for(int i = 0; i < s.length(); i++) {
            int j = s.length() - 1;

            while(i < j && s.charAt(i) != s.charAt(j)) {
                j--;
            }

            boolean isPalindrome = true;
            int l = i;
            int h = j;

            while(l < h) {
                if (s.charAt(l) == s.charAt(h)) {
                    l++;
                    h--;
                } else {
                    isPalindrome = false;
                }
            }

            if (isPalindrome) {
                int length = j - i + 1;

                if (length > maxCount) {
                    maxCount = length;
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }
}
