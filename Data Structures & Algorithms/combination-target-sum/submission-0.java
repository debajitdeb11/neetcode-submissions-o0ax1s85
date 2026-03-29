class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();


        dfs(nums, temp, result, 0, 0, target);

        return result;
    }

    private void dfs(int[] nums, List<Integer> temp, List<List<Integer>> res, int sum, int idx, int target) {
        if (sum == target) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if (idx == nums.length || sum > target) {
            return;
        }

        // take element
        temp.add(nums[idx]);
        dfs(nums, temp, res, sum + nums[idx], idx, target);

        // don't take take that element
        temp.remove(temp.size() - 1);
        dfs(nums, temp, res, sum, idx + 1, target);
    }
}
