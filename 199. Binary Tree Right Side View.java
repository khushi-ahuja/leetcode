// https://leetcode.com/problems/binary-tree-right-side-view/
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue <TreeNode> q = new LinkedList<>();
        if(root!=null)
        {
            TreeNode cur, prev=root;
            q.add(root);
            q.add(null);
            // ans.add(root.val);
            while(!q.isEmpty())
            {
                cur = q.remove();
                if(cur==null)
                {
                    if(!q.isEmpty())
                    {
                        q.add(null);
                    }
                    ans.add(prev.val);
                }
                else
                {
                    if(cur.left!=null)
                        q.add(cur.left);
                    if(cur.right!=null)
                        q.add(cur.right);
                }
                prev=cur;
            }
        }
        return ans;
    }
}
