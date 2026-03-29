class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        // Map to store (target - nums[i], idx)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int firstIdx = map.get(nums[i]);

                if (i < firstIdx) {
                    res[0] = i;
                    res[1] = firstIdx;
                } else {
                    res[0] = firstIdx;
                    res[1] = i;
                }
            }

            map.put(target - nums[i], i);
        }

        return res;
    }
}