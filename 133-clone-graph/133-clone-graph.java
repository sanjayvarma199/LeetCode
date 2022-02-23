/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    //Time O(N+M)
    //Space O(N)
    public Node cloneGraph(Node node) {
        if(node == null)
        {
            return node;
        }
        Queue<Node> Q = new LinkedList<>();
        Node CopyNode = new Node(node.val);
        
        //Create a One on One relation with deep copy
        HashMap<Node , Node> map = new HashMap<>();
        map.put(node , CopyNode);
        
        Q.add(node);
        while(!Q.isEmpty())
        {
            Node curr = Q.poll();
            if(curr.neighbors != null)
            {
                for(Node n : curr.neighbors)
                {
                    if(!map.containsKey(n))
                    {
                        Node curr_Copy = new Node(n.val);
                        map.put(n , curr_Copy);
                        //Add to queue only when there is no deep copy
                        Q.add(n);
                    }
                    map.get(curr).neighbors.add(map.get(n));
                }
            }
        }
        return CopyNode;
    }
}