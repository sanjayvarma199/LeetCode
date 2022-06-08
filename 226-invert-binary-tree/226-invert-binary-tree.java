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
    //Space O(N)
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
        {
            return root;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        
        Q.add(root);
        while(!Q.isEmpty())
        {
            TreeNode curr = Q.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            
            if(curr.left != null) Q.add(curr.left);
            if(curr.right != null) Q.add(curr.right);
        }
        return root;
    }
}