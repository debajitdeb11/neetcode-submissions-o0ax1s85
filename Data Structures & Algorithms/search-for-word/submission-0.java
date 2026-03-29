class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (dfs(r, c, 0, board, visited, words, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(int r, int c, int idx, char[][] board,
        int[][] visited, char[] words, int row, int col) {
        // If visited every word
        if (idx == words.length) {
            return true;
        }
        
        // exceeds limit
        if (r < 0 || c < 0 || r >= row || c >= col) {
            return false;
        }

        // if next char is not the expected one or it's already visited
        if (board[r][c] != words[idx] || visited[r][c] == 1) {
            return false;
        }

        // else marked it visited
        visited[r][c] = 1;

        boolean res = dfs(r - 1, c, idx + 1, board, visited, words, row, col) ||
                      dfs(r + 1, c, idx + 1, board, visited, words, row, col) ||
                      dfs(r, c - 1, idx + 1, board, visited, words, row, col) ||
                      dfs(r, c + 1, idx + 1, board, visited, words, row, col);

        visited[r][c] = 0;
        return res;
    }
}
