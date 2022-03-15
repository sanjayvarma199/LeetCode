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
    //Space O(H)
    public boolean isSymmetric(TreeNode root) {
        return helper(root , root);
    }
    
    private boolean helper(TreeNode Left , TreeNode Right)
    {
        //base
        if(Left == null && Right == null)
        {
            return true;
        }
        //logic
        if((Left != null && Right == null) || (Left == null && Right != null))
        {
            return false;
        }
        if(Left.val != Right.val)
        {
            return false;
        }
        return helper(Left.left , Right.right) && helper(Left.right , Right.left);
    }
}