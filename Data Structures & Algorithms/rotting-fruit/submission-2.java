class Solution {
    static class Pair {
        int i;
        int j;
        
        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int orangesRotting(int[][] grid) {
        int[] rowDir = {-1, 0, +1, 0};
        int[] colDir = {0, -1, +0, +1};

        if (grid == null || grid.length == 0) {
            return -1;
        }

        int rotten = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int fresh = 0;
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j));
                    visited[i][j] = 1;
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(fresh > 0 && !q.isEmpty()) {
            int k = q.size();

            while(k > 0) {
                Pair p = q.remove();
                k--;
                for (int i = 0; i < 4; i++) {
                    int r = p.i + rowDir[i];
                    int c = p.j + colDir[i];

                    if (r < 0 || r >= n || c < 0 || c >= m) {
                        continue;
                    }

                    if (visited[r][c] == 0 && grid[r][c] == 1) {
                        visited[r][c] = 1;
                        grid[r][c] = 2;
                        q.add(new Pair(r, c));
                        fresh--;
                    }
                }
            }

            rotten++;
        }

        // verify

        if (fresh > 0) {
            return -1;
        }

        return rotten;
    }
}
