//https://leetcode.com/problems/path-sum/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int cSum =0;
        return pathSum(root, targetSum, cSum);
    }
    public boolean pathSum(TreeNode root, int targetSum, int cSum) {
        if(root==null)
            return false;
        if(root.left==null && root.right==null )
            if(cSum+root.val == targetSum)
                return true;
        return pathSum(root.left, targetSum, cSum+root.val) || pathSum(root.right, targetSum,cSum+root.val);
    }
}
