class Solution {
    public int uniquePaths(int m, int n) {
        int[][] cache = new int[m][n];

        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }

        return paths(0, 0, m, n, cache);  
    }

    private int paths(int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        int sum = paths(i + 1, j, m, n, cache) + paths(i, j + 1, m, n, cache);

        cache[i][j] = sum;
        return cache[i][j];
    }
}
