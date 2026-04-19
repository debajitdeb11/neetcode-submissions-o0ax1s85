class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0;

        for (int i : nums) {
            xor ^= i;
        }

        int n = nums.length;

        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }

        return xor;
    }
}
