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
        helper(root , 0);
        return isValid;
    }
    private int helper(TreeNode root , int level)
    {
        //base
        if((root == null))
        {
            return -1;
        }
        if(root.left == null && root.right == null) return 0;
        //logic
        int left = helper(root.left , level);
        int right = helper(root.right , level);
        if(Math.abs(left - right) > 1 )
        {
            isValid = false;
            return -1;
        }
        return Math.max(left , right)+1;
    }
}