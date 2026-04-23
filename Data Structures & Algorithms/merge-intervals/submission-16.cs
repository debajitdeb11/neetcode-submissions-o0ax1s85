public class Solution {
    public int[][] Merge(int[][] intervals) {
        // sort the array
        Array.Sort(intervals, (a, b) => a[0] - b[0]);

        int ps = intervals[0][0];
        int pe = intervals[0][1];

        List<int[]> res = new List<int[]>();

        for (int i = 1; i < intervals.Length; i++)
        {
            //
            if (intervals[i][0] <= pe) {
                pe = Math.Max(pe, intervals[i][1]);
            } else {
                res.Add(new int[] {ps, pe});
                ps = intervals[i][0];
                pe = intervals[i][1];
            }
        }

        res.Add(new int[]{ps, pe});

        int[][] temp = new int[res.Count][];

        for (int i = 0; i < res.Count; i++)
        {
            temp[i] = new int[2];
            temp[i][0] = res[i][0];
            temp[i][1] = res[i][1];
        }


        return temp;
    }
}
