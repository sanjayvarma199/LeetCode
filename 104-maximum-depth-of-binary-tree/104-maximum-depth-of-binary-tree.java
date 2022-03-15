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
    public int maxDepth(TreeNode root) {
        return helper(root , 0);
    }
    
    private int helper(TreeNode root , int level)
    {
        //base case
        if(root == null)
        {
            return 0;
        }
        return Math.max(helper(root.left , level) , helper(root.right , level))+1;
    }
}