// https://leetcode.com/problems/path-sum-ii/
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSum(root, targetSum, path, ans);
        return ans;
    }
    public void pathSum(TreeNode root, int tSum, List<Integer> path, List<List<Integer>> ans)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            if(tSum==root.val)
            {
                path.add(root.val);
                ans.add(new ArrayList<>(path));
                path.remove(path.size()-1);
                return;
            }
        }
        path.add(root.val);
        pathSum(root.left, tSum-root.val, path, ans);
        pathSum(root.right, tSum-root.val, path, ans);
        path.remove(path.size()-1);
    }
}
