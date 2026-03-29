class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int island = 0;

        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    island++;
                    bfs(grid, visited, n, m, i, j);
                }
            }
        }

        return island;
    }

    private void bfs(char[][] grid, boolean[][] visited, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return;
        }

        if (grid[i][j] == '0' || visited[i][j]) {
            return;
        }

        visited[i][j] = true;

        // bfs all direction
        bfs(grid, visited, n, m, i - 1, j);
        bfs(grid, visited, n, m, i + 1, j);
        bfs(grid, visited, n, m, i, j - 1);
        bfs(grid, visited, n, m, i, j + 1);
    }
}
