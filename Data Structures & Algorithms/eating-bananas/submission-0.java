class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int ub = -1;
        
        for (int i : piles) {
            ub = Math.max(ub, i);
        }

        int lb = 1;
        int res = -1;

        while(lb <= ub) {
            int m = lb + (ub - lb)/2;

            int count = getCount(m, piles);

            if (count <= h) {
                res = m;
                ub = m - 1;
            } else {
                lb = m + 1;
            }
        }

        return res;
    }

    private int getCount(int k, int[] piles) {
        int count = 0;

        for (int i : piles) {
            count += Math.ceil((double)i/(double)k);
        }

        return count;
    }
}
