class Solution {
    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];
        int[][] cache = new int[m][n];

        for (int[] c : cache) {
            Arrays.fill(c, -1);
        }

        return paths(visited, 0, 0, m, n, cache);  
    }

    private int paths(boolean[][] visited, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (cache[i][j] != -1) {
            return cache[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }


        if (visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        int sum = paths(visited, i + 1, j, m, n, cache) + paths(visited, i, j + 1, m, n, cache);

        visited[i][j] = false;
        cache[i][j] = sum;
        return cache[i][j];
    }
}
