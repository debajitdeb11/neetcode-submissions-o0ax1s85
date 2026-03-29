class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        int[][] visited = new int[row][col];

        Set<String> res = new HashSet<>();

        for (String word : words) {
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    dfs(row, col, r, c, res, board, word, visited, 0);
                }
            }
        }

        return new ArrayList<>(res);
    }

    private void dfs(
        int row, int col, int r, int c, Set<String> temp,
        char[][] board, String word, int[][] visited, int idx
    ) {
        if (idx == word.length()) {
            temp.add(word);
            return;
        }

        // base cases
        if (r < 0 || c < 0 || r >= row || c >= col) {
            return;
        }

        if (visited[r][c] == 1 || board[r][c] != word.charAt(idx)) {
            return;
        }

        // mark visited
        visited[r][c] = 1;
        
        // dfs on all 4 direction
        dfs(row, col, r + 1, c, temp, board, word, visited, idx + 1);
        dfs(row, col, r - 1, c, temp, board, word, visited, idx + 1);
        dfs(row, col, r, c - 1, temp, board, word, visited, idx + 1);
        dfs(row, col, r, c + 1, temp, board, word, visited, idx + 1);

        visited[r][c] = 0;
    }
}
