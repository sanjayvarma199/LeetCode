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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty())
        {
            while(root != null)
            {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if(--k == 0) return root.val;
            root = root.right;
        }
        return -1;
    }
}