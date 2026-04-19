class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> (i1[0] - i2[0]));

        int s = intervals[0][0];
        int e = intervals[0][1];


        System.out.println(Arrays.deepToString(intervals));

        for (int i = 1; i < intervals.length; i++) {
            int cs = intervals[i][0];
            int ce = intervals[i][1];

            if (cs <= e && ce >= e) {
                e = ce;
            } else if (cs > e) {
                res.add(new int[]{s, e});
                s = cs;
                e = ce;
            }
        }

        res.add(new int[]{s, e});

        int[][] result = new int[res.size()][2];

        for (int i = 0; i < res.size(); i++) {
            result[i][0] = res.get(i)[0];
            result[i][1] = res.get(i)[1];
        }

        return result;
    }
}
