class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);

        int prevEnd = intervals[0][1];

        int count = 0;

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if (currStart >= prevEnd) {
                prevEnd = currEnd;
            } else {
                count++;
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }

        return count;
    }
}
