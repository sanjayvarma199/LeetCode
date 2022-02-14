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
    //Time O(N)
    //Space O(N)
    public int maxDepth(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty())
        {
            int size = Q.size();
            for(int i = 0 ; i < size ; i++)
            {
                TreeNode out = Q.poll();
                if(out.left != null) Q.add(out.left);
                if(out.right != null) Q.add(out.right);
            }
            depth++;
        }
        return depth;
    }
}