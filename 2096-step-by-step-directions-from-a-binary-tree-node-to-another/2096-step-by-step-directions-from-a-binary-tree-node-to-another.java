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
    StringBuilder sb1 , sb2;
    int target1 , target2;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        if(root == null)
        {
            return "";
        }
        target1 = startValue ; target2 = destValue;
        
        helper(root , new StringBuilder());
        int i = 0;
        while(i < sb1.length() && i < sb2.length())
        {
            if(sb1.charAt(i) != sb2.charAt(i))
            {
                break;
            }
            i++;
        }
        StringBuilder result = new StringBuilder();
        for(int j = i ; j < sb1.length() ; j++)
        {
            result.append('U');
        }
        while(i < sb2.length())
        {
            result.append(sb2.charAt(i));
            i++;
        }
        
        return result.toString();
    }
    
    private void helper(TreeNode root , StringBuilder path)
    {
        //Base Case
        if(root == null)
        {
            return;
        }
        if(root.val == target1)
        {
            sb1 = new StringBuilder(path);
        }
        if(root.val == target2)
        {
            sb2 = new StringBuilder(path);
        }
        //Logic
        path.append('L');
        helper(root.left , path);
        path.setLength(path.length()-1);
        
        path.append('R');
        helper(root.right , path);
        path.setLength(path.length()-1);
    }
}