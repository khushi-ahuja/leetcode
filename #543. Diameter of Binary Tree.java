// https://leetcode.com/problems/diameter-of-binary-tree/
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
    public int diameterOfBinaryTree(TreeNode root) {
        Pair res = diameterOpt(root);
        return res.dia;
    }
    private class Pair{
        int dia, ht;
        Pair(int dia, int ht){
            this.dia=dia;
            this.ht=ht;
        }
    }
    private Pair diameterOpt(TreeNode root){
        if(root==null)
            return new Pair(0,0);
        
        Pair leftP = diameterOpt(root.left);
        Pair rightP = diameterOpt(root.right);
        
        int leftHt = leftP.ht;
        int rightHt = rightP.ht;
        int rootHt = Math.max(leftHt, rightHt) +1;
        
        int rootDia = leftHt + rightHt;
        int finalDia = Math.max(rootDia, Math.max(leftP.dia, rightP.dia));
        return new Pair(finalDia, rootHt);
    }
}
