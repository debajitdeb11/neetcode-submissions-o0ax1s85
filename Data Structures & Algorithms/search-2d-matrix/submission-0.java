class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][m-1]) {
                return bs(matrix[i], target);
            }
        }

        return false;
    }

    private boolean bs(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;

        while(l <= h) {
            int m = l + (h - l)/2;

            if (arr[m] == target) {
                return true;
            } else if (arr[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }

        return false;
    }
}
