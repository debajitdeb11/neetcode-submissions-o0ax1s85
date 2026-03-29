/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) {
 *         this.val = val;
 *     }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return dfs(root, subRoot);
    }

    private boolean dfs(TreeNode main, TreeNode sub) {
        if (sub == null) {
            return true;
        }

        if (main == null) {
            return false;
        }

        if (isIdentical(main, sub)) {
            return true;
        }

        return (dfs(main.left, sub) || dfs(main.right, sub));
    }

    private boolean isIdentical(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }

        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        return isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right);
    }
}