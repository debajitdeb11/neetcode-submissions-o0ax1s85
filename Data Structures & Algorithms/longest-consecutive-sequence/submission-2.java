class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int maxSequenceLength = 0;

        for (Integer i : set) {
            int sequenceLen = 1;
            if (set.contains(i - 1)) {
                continue;
            } else {
                int j = 1;
                while (set.contains(i + j)) {
                    sequenceLen++;
                    j++;
                }

                maxSequenceLength = Math.max(maxSequenceLength, sequenceLen);
            }
        }

        return maxSequenceLength;
    }
}