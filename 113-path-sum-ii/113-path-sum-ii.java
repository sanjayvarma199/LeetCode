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
    List<List<Integer>> ans;
    int target;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //Input Validation
        if(root == null)
        {
            return new ArrayList<>();
        }
        this.target = targetSum;
        ans = new ArrayList<>();
        helper(root , new ArrayList<>() , 0);
        return ans;
    }
    
    private void helper(TreeNode root , List<Integer> path , int curr_sum)
    {
        //base case
        if(root == null)
        {
            return;
        }
        //logic
        curr_sum += root.val;
        path.add(root.val);
        
        if(root.left == null && root.right == null && curr_sum == target)
        {
            ans.add(new ArrayList<>(path));
        }
        helper(root.left , path , curr_sum);
        helper(root.right , path , curr_sum);
        //backtrack
        path.remove(path.size()-1);
    }
}