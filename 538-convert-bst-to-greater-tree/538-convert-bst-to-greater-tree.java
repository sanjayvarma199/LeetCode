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
        
        TreeNode result = root;
        
        LinkedList<TreeNode> Q = new LinkedList<>();
        
        //Q.add(root);
        
        while(root != null || !Q.isEmpty())
        {
            while(root != null)
            {
                Q.addFirst(root);
                root = root.right;
            }
            root = Q.poll();
            root.val = root.val + sum;
            sum = root.val;
            root = root.left;
        }
        
        return result;
    }
}