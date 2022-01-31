// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum =0;
        bstToGstr(root);
        return root;
    }
    private void bstToGstr(TreeNode root) {
        if(root == null)
            return;
        bstToGstr(root.right);
        root.val+=sum;
        sum=root.val;
        bstToGstr(root.left);
    }
}
