/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int k = 0;
        for (Interval i : intervals) {
            start[k] = i.start;
            end[k] = i.end;
            k++;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0;
        int e = 0;

        int maxCount = 0;
        int count = 0;

        while(s < start.length && e < end.length) {
            if (start[s] < end[e]) {
                count++;
                s++;
            } else {
                count--;
                e++;
            }

            maxCount = Math.max(count, maxCount);
        }

        return maxCount;
    }
}
