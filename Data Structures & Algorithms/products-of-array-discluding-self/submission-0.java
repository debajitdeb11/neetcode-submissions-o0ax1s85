class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // compute left
        int product = 1;
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            left[i] = product;
        }

        // compute right;
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            right[i] = product;
        }

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = right[i + 1];
            } else if (i == n - 1) {
                result[i] = left[i - 1];
            } else {
                result[i] = left[i - 1] * right[i + 1]; 
            }
        }

        return result;
    }
}  
