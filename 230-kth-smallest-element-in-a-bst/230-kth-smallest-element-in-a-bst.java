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
    //Time O(Nlogk)
    //Space O(H+k)
    PriorityQueue<TreeNode> PQ;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return 0;
        }
        this.k = k;
        PQ = new PriorityQueue<>((a,b) -> (b.val - a.val));
        helper(root);
        return PQ.poll().val;
    }
    
    private void helper(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        PQ.add(root);
        if(PQ.size() > k) PQ.poll();
        
        //Recurse
        helper(root.left);
        helper(root.right);
    }
}