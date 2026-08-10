class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int[] l2r = new int[n];
        l2r[0] = height[0];

        for (int i = 1; i < n; i++) {
            l2r[i] = Math.max(l2r[i - 1], height[i]);
        }
        
        int[] r2l = new int[n];
        r2l[n-1] = height[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            r2l[i] = Math.max(r2l[i + 1], height[i]);
        }

        int total = 0;

        for (int i = 1; i < n-1; i++) {
            total += Math.abs(Math.min(r2l[i], l2r[i]) - height[i]);
        }

        return total;
    }
}
