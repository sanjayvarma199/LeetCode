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
    public int sumNumbers(TreeNode root) {
        //Base case
        if(root == null)
        {
            return 0;
        }
        sum = 0;
        helper(root , 0);
        return sum;
    }
    
    private void helper(TreeNode root , int curr_sum)
    {
        //base case
        if(root == null)
        {
            return;
        }
        //logic
        
        curr_sum = curr_sum * 10 + root.val;
        if(root.left == null && root.right == null)
        {
            sum += curr_sum;
            return;
        }
        
        
        helper(root.left , curr_sum);
        helper(root.right , curr_sum);
        return;
    }
}