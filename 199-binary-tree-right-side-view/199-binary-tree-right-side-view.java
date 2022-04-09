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
    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        //Input Validation
        if(root == null)
        {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(root , 0);
        return result;
    }
    
    private void helper(TreeNode root , int level)
    {
        //base case
        if(root == null)
        {
            return;
        }
        
        if(level == result.size())
        {
            result.add(root.val);
        }
        //logic
        helper(root.right , level+1);
        helper(root.left , level+1);
    }
}