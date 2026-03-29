class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        
        // Fill left
        int[] left = new int[n];
        left[0] = heights[0];

        for (int i = 1; i < n; i++) {
            left[i] = Math.max(heights[i], left[i-1]);
        }

        // Fill right
        int[] right = new int[n];
        right[n-1] = heights[n-1];

        for (int i = n-2; i >= 0; i--) {
            right[i] = Math.max(heights[i], right[i + 1]);
        }

        int l = 0;
        int r = n - 1;

        int maxCapacity = 0;

        while (l < r) {
            int capacity = Math.min(left[l], right[r]) * (r - l);

            maxCapacity = Math.max(maxCapacity, capacity);

            if (left[l] <= right[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxCapacity;
    }
}

// L -> R [1,7,7,7,7,7,7,7]
// R -> L [7,7,7,7,7,7,6,6]
