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
        int ans=0; 
        if (root == null) 
            return 0; 
        if (root.val < L) // left branch excluded.
            ans+= rangeSumBST(root.right, L, R); 
        else if (root.val > R) // right branch excluded. 
            ans+= rangeSumBST(root.left, L, R); 
        else 
            ans += root.val + rangeSumBST(root.right, L, R) + rangeSumBST(root.left, L, R); 
        return ans;
    }
}
