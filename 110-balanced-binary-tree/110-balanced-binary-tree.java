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
    boolean isValid;
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }
        isValid = true;
        helper(root);
        return isValid;
    }
    
    private int helper(TreeNode root)
    {
        if(root == null)
        {
            return -1;
        }
        int Left = helper(root.left);
        int Right = helper(root.right);
        if(Math.abs(Left-Right) > 1)
        {
            isValid = false;
            return -1;
        }
        return Math.max(Left , Right)+1;
    }
}