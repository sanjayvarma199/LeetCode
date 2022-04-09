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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
        {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
        
        while(!Q.isEmpty())
        {
            int size = Q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0 ; i < size ; i++)
            {
                TreeNode curr = Q.poll();
                list.add(curr.val);
                
                if(curr.left != null) Q.add(curr.left);
                if(curr.right != null) Q.add(curr.right);
            }
            result.add(list);
        }
        return result;
    }
}