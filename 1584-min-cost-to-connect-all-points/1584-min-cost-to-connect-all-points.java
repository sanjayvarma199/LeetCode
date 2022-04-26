class Solution {
    //Time O(N^2 * logN)
    //Space O(N^2)
    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0)
        {
            return 0;
        }
        int n = points.length , result = 0;
        boolean visited[] = new boolean[n];
        
        PriorityQueue<Pair> PQ = new PriorityQueue<>((a, b) -> (a.weight - b.weight));
        PQ.add(new Pair(0,0));
                
        while(!PQ.isEmpty())
        {
            Pair p = PQ.poll();
            if(visited[p.vertice])
            {
                continue;
            }
            
            visited[p.vertice] = true;
            result += p.weight;
            
            for(int i = 0 ; i < n ; i++)
            {
                if(!visited[i])
                {
                    int weight = Math.abs(points[p.vertice][0] - points[i][0]) + Math.abs(points[p.vertice][1] - points[i][1]);
                    
                    PQ.add(new Pair(weight , i));
                }
            }
        }
        return result;
    }
}

class Pair
{
    int weight , vertice;
    public Pair(int weight , int vertice)
    {
        this.weight = weight;
        this.vertice = vertice;
    }
    
}