// https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    int res;
    public int sumNumbers(TreeNode root) {
        res = 0;
        sumNumbers(root, 0);
        return res;
    }
    public void sumNumbers(TreeNode root, int ans)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null )
        {
            ans=ans*10 + root.val;
            res+=ans;
            return;
        }
        sumNumbers(root.left, ans*10+root.val);
        sumNumbers(root.right, ans*10+root.val);
    }
}
