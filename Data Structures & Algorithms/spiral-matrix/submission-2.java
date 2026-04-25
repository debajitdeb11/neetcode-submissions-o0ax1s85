class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rEnd = matrix.length - 1;
        int cEnd = matrix[0].length - 1;

        int rStart = 0;
        int cStart = 0;

        List<Integer> res = new ArrayList<>();

        while(rStart <= rEnd && cStart <= cEnd) {
            
            //left -> right
            for (int i = cStart; i <= cEnd; i++) {
                res.add(matrix[rStart][i]);
            }
            rStart++;
            
            // top -> down
            for (int i = rStart; i <= rEnd; i++) {
                res.add(matrix[i][cEnd]);
            }
            cEnd--;

            if (rStart > rEnd || cStart > cEnd ) {
                break;
            }

            // right -> left
            for (int i = cEnd; i >= cStart; i--) {
                res.add(matrix[rEnd][i]);
            }
            rEnd--;
            
            // down -> top
            for (int i = rEnd; i >= rStart; i--) {
                res.add(matrix[i][cStart]);
            }
            cStart++;
        }

        return res;
    }
}
