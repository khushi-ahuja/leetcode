// https://leetcode.com/problems/balanced-binary-tree/
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
    public boolean isBalanced(TreeNode root) {
        Pair res = isBalancedOpt(root);
        return res.isBal;
    }
    private class Pair {
        int ht;
        boolean isBal;
        public Pair(boolean isBal, int ht){
            this.ht = ht;
            this.isBal = isBal;
        }
    }
    private Pair isBalancedOpt(TreeNode root) {
        if(root==null)
            return new Pair(true, 0);
        
        Pair leftP = isBalancedOpt(root.left);
        Pair rightP = isBalancedOpt(root.right);
        
        int rootHt = Math.max(leftP.ht, rightP.ht) + 1;
        boolean rootBal = (Math.abs(leftP.ht - rightP.ht) <=1 );
        boolean finalBal = rootBal && leftP.isBal && rightP.isBal ;
        return new Pair(finalBal, rootHt);
    }
}
