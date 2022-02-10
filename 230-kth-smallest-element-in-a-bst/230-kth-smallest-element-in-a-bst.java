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
    //Space O(N)
    PriorityQueue<Integer> PQ;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return -1;
        }
        this.k = k;
        PQ = new PriorityQueue<>((a,b) -> (b-a));
        helper(root);
        return PQ.poll();
    }
    
    private void helper(TreeNode root)
    {
        //base
        if(root == null)
        {
            return;
        }
        PQ.add(root.val);
        if(PQ.size() > k)
        {
            PQ.poll();
        }
        helper(root.left);
        helper(root.right);
    }
}