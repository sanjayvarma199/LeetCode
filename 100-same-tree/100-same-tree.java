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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
        {
            return true;
        }
        Stack<Pair> stack = new Stack<>();
        if((p == null && q != null) || (p != null && q == null)) return false;
        stack.add(new Pair(p , q));
        while(!stack.isEmpty())
        {
            Pair curr = stack.pop();
            if(curr.P == null && curr.Q == null) continue;
            if((curr.P == null && curr.Q != null) || (curr.P != null && curr.Q == null)) return false;
            
            if(curr.P.val != curr.Q.val)
            {
                return false;
            }
            
            stack.push(new Pair(curr.P.left , curr.Q.left));
            
            stack.push(new Pair(curr.P.right , curr.Q.right));
        }
        
        return true;
    }
}
class Pair
{
    TreeNode P , Q;
    public Pair(TreeNode p , TreeNode q)
    {
        P = p;
        Q = q;
    }
}