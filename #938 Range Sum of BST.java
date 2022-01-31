// https://leetcode.com/problems/range-sum-of-bst/
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
    // int ans;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0; // base case.
        if (root.val < L) // left branch excluded.
            return rangeSumBST(root.right, L, R); 
        if (root.val > R) // right branch excluded. 
            return rangeSumBST(root.left, L, R); 
        return root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); 
    }
}
