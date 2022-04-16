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
    int sum;
    public TreeNode convertBST(TreeNode root) {
        //Input Validation
        if(root == null)
        {
            return root;
        }
        sum = 0;
        helper(root);
        return root;
    }
    
    private void helper(TreeNode root)
    {
        //Base Case
        if(root == null)
        {
            return;
        }
        //Logic
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }
}