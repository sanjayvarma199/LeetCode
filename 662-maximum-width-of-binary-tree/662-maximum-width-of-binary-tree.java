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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null)
        {
            return 0;
        }
        Queue<Pair> Q = new LinkedList<>();
        Q.add(new Pair(root , 1));
        
        int max = 0;
        while(!Q.isEmpty())
        {
            int size = Q.size();
            int start = 0 , end = 0;
            for(int i = 0 ; i < size ; i++)
            {
                Pair p = Q.poll();
                if(i == 0) start = p.num;
                if(i == size-1) end = p.num;
                if(p.node.left != null) Q.add(new Pair(p.node.left , 2*p.num));
                if(p.node.right != null) Q.add(new Pair(p.node.right , 2*p.num+1));
            }
            max = Math.max(max , end-start+1);
        }
        return max;
    }
}
class Pair
{
    TreeNode node;
    int num;
    public Pair(TreeNode node , int num)
    {
        this.node = node;
        this.num = num;
    }
}