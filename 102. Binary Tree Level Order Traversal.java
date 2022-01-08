// https://leetcode.com/problems/binary-tree-level-order-traversal/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(root == null)
            return ans;
        
        Queue <TreeNode> q = new LinkedList<>(); 
        
        List<Integer> lvlList = new ArrayList<>();
        q.add(root);
        q.add(null);
        while( !q.isEmpty() )
        {
            TreeNode cur = q.remove();
            if(cur == null)
            {
                if(!q.isEmpty())
                {
                    q.add(null);
                }
                ans.add(lvlList);
                lvlList =  new ArrayList<>(); 
            }
            else 
            {
                lvlList.add(cur.val);
                if(cur.left!=null)
                    q.add(cur.left);
                if(cur.right!=null)
                    q.add(cur.right);
            }
        }
        return ans;
    }
}
