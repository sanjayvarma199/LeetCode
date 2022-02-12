/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    //Time O(N)
    //Space O(H)
    List<List<TreeNode>> Paths;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
        {
            return null;
        }
        Paths = new ArrayList<>();
        helper(root , p , q, new ArrayList<>());
        int i = 0;
        while(Paths.get(0).get(i) == Paths.get(1).get(i))
        {
            i++;
        }
        return Paths.get(0).get(i-1);
    }
    
    private void helper(TreeNode root , TreeNode p , TreeNode q , List<TreeNode> path)
    {
        //base
        if(root == null)
        {
            return;
        }
        //Action
        path.add(root);
        if(root.val == p.val)
        {
            path.add(root);
            Paths.add(new ArrayList<>(path));
            path.remove(root);
        }
        if(root.val == q.val)
        {
            path.add(root);
            Paths.add(new ArrayList<>(path));
            path.remove(root);
        }
        //Recurse
        helper(root.left , p , q, path);
        helper(root.right , p , q, path);
        
        //BackTrack
        path.remove(root);
    }
}