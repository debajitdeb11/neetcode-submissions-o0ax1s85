class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();

        boolean isNewIntervalInserted = false;
        // merge these interval together
        for (int i = 0; i < intervals.length;) {
            int cs = intervals[i][0];

            if (!isNewIntervalInserted && newInterval[0] < cs) {
                temp.add(newInterval);
                isNewIntervalInserted = true;
            } else {
                temp.add(new int[] {intervals[i][0], intervals[i][1]});
                i++;
            }
        }

        if (!isNewIntervalInserted) {
            temp.add(newInterval);
        }

        // merge
        List<int[]> result = new ArrayList<>();
        int prevStart = temp.get(0)[0];
        int prevEnd = temp.get(0)[1];

        for (int i = 1; i < temp.size(); i++) {
            int cs = temp.get(i)[0]; 
            int ce = temp.get(i)[1];

            if (cs <= prevEnd && ce > prevEnd) {
                prevEnd = ce;
            } else if (cs > prevEnd) {
                result.add(new int[] {prevStart, prevEnd});
                prevStart = cs;
                prevEnd = ce;
            }
        }

        result.add(new int[]{prevStart, prevEnd});

        int[][] res = new int[result.size()][2];

        for (int i = 0; i < res.length; i++) {
            res[i][0] = result.get(i)[0];
            res[i][1] = result.get(i)[1];
        }

        return res;
    }
}
