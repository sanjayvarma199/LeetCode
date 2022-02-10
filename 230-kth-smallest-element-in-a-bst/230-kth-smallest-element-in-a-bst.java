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
    //Time O(NlogK)
    //Space O(N)
    public int kthSmallest(TreeNode root, int k) {
        if(root == null)
        {
            return 0;
        }
        PriorityQueue<Integer> PQ = new PriorityQueue<>((a,b) -> (b-a));
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty())
        {
            TreeNode temp = Q.poll();
            if(temp == null) continue;
            PQ.add(temp.val);
            if(PQ.size() > k) PQ.poll();
            Q.add(temp.left);
            Q.add(temp.right);
        }
        return PQ.poll();
    }
}