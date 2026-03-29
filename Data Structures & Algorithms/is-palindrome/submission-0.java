class Solution {
    public boolean isPalindrome(String s) {
        // steps
        // 1. Put all the character of the original string consecutive to each other
        // after removing the character rather than A-Z, a-z, 1-9
        // 2. Start iteration using 2-pointer approach
        // 1st: L -> R
        // 2nd: R -> L
        // return false, if arr[i] != arr[n-i-1]
        // else true

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                sb.append(c);
            }
        }

        String newStr = sb.toString();

        // check the string
        int i = 0;
        int j = newStr.length() - 1;

        while(i < j) {
            if (Character.toLowerCase(newStr.charAt(i)) != Character.toLowerCase(newStr.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
