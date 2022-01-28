// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
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
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(!pathSum(root,limit, 0))
            return null;
        return root;
    }
    public boolean pathSum(TreeNode root, int limit, int cSum)
    {
        if(root==null)
            return false;
        if(root.left==null && root.right == null)
        {
            if(root.val+cSum < limit){
                return false;
            }
            return true;
        }
        boolean left = pathSum(root.left, limit, cSum+root.val);
        boolean right = pathSum(root.right, limit, cSum+root.val);
        if(left == false && right == false) {
            return false;
        }
        if(left==false) {
            root.left=null;
        }
        if(right==false) {
            root.right=null;
        }
        return true;
        
    }
}
