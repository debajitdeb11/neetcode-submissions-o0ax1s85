public class Solution {
    public bool hasDuplicate(int[] nums) {
        HashSet<int> set = new();

        foreach (var item in nums)
        {
            if (set.Contains(item))
            {
                return true;
            }

            set.Add(item);
        }

        return false;
    }
}