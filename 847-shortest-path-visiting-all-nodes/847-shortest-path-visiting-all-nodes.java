class Solution {
    //Time O(2^N * N^2)
    //Space O(2^N * N)
    public int shortestPathLength(int[][] graph) {
        //Input Validation
        if(graph == null || graph.length == 0)
        {
            return 0;
        }
        int n = graph.length;
        int fullMask = (1 << n) - 1; // Full mask which is used to validate if all nodes are visited
        
        Queue<Node> Q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        
        //Process all the nodes Initially
        for(int i = 0 ; i < graph.length ; i++)
        {
            Node node = new Node(i , 1 << i);
            Q.add(node);
            set.add(node.toString());
        }
        
        int level = 0;
        while(!Q.isEmpty())
        {
            int size = Q.size();
            for(int i = 0 ; i < size ; i++)
            {
                Node curr = Q.poll();
                if(curr.BitMask == fullMask) return level;
                for(int j : graph[curr.id])
                {
                    Node node = new Node(j , curr.BitMask | 1 << j);
                    if(!set.contains(node.toString()))
                    {
                        Q.add(node);
                        set.add(node.toString());
                    }
                }
            }
            level++;
        }
        return level;
    }
}
class Node
{
    int id;
    int BitMask;
    public Node(int id , int BitMask)
    {
        this.id = id;
        this.BitMask = BitMask;
    }
    
    public String toString()
    {
        return id + " " + BitMask;
    }
}