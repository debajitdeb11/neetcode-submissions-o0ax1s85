class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        backtrack(0, res, new ArrayList<>(), nums);

        return res;
    }


    public void backtrack(int idx, List<List<Integer>> res, List<Integer> temp, int[] nums) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // Include
        temp.add(nums[idx]);
        backtrack(idx + 1, res, temp, nums);

        // Don't include
        temp.remove(temp.size() - 1);
        backtrack(idx + 1, res, temp, nums);
    }
}
