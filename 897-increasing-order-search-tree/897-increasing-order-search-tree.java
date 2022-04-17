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
    TreeNode curr;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null)
        {
            return root;
        }
        TreeNode ans = new TreeNode(0);
        curr = ans;
        helper(root);
        return ans.right;
    }
    private void helper(TreeNode root)
    {
        //Base Case
        if(root == null)
        {
            return;
        }
        //Logic
        helper(root.left);
        root.left = null;
        curr.right = root;
        curr = curr.right;
        helper(root.right);
    }
}