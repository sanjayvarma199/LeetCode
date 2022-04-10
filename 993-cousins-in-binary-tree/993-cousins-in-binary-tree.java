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
    public boolean isCousins(TreeNode root, int x, int y) {
        //Input Validation
        if(root == null)
        {
            return false;
        }
        
        Queue<pair> Q = new LinkedList<>();
        Q.add(new pair(root , null));
        
        while(!Q.isEmpty())
        {
            int size = Q.size();
            TreeNode x_parent = null , y_parent = null;
            for(int i = 0 ; i < size ; i++)
            {
                pair curr = Q.poll();
                if(x == curr.root.val)
                {
                    x_parent = curr.parent;
                }
                if(y == curr.root.val)
                {
                    y_parent = curr.parent;
                }
                
                if(x_parent != null && y_parent != null && x_parent != y_parent)
                {
                    return true;
                }
                if(curr.root.left != null) Q.add(new pair(curr.root.left , curr.root));
                if(curr.root.right != null) Q.add(new pair(curr.root.right , curr.root));
            }
        }
        return false;
    }
}

class pair
{
    TreeNode root , parent;
    public pair(TreeNode root , TreeNode parent)
    {
        this.root = root;
        this.parent = parent;
    }
}