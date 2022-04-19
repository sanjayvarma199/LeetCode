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
    TreeNode X , Y , prev;
    boolean X_Found;
    public void recoverTree(TreeNode root) {
        if(root == null)
        {
            return;
        }
        prev = null;
        helper(root);
        int temp = X.val;
        X.val = Y.val;
        Y.val = temp;
        return;
    }
    
    private void helper(TreeNode root)
    {
        //Base Case
        if(root == null)
        {
            return;
        }
        helper(root.left);
        
        if(prev != null && (root.val < prev.val))
        {
            if(!X_Found)
            {
                X_Found = true;
                X = prev ; Y = root;
            }
            else
            {
                Y = root;
            }
        }
        prev = root;
        helper(root.right);
    }
}