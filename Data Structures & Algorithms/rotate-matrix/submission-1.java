class Solution {
    public void rotate(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;


        for (int i = 0; i < r/2; i++) {
            for (int j = 0; j < c; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[r - i - 1][j];
                matrix[r - i - 1][j] = t;
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = i; j < c; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }
}
