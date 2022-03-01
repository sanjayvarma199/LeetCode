class Solution {
    //Time O(NlogK)
    //Space O(K)
    public int[][] kClosest(int[][] points, int k) {
        if(points == null || points.length == 0)
        {
            return points;
        }
        PriorityQueue<Pair> PQ = new PriorityQueue<>((a,b) -> (b.distance - a.distance));
        for(int i = 0 ; i < points.length ; i++)
        {
            Pair p = new Pair(points[i][0] , points[i][1]);
            PQ.add(p);
            if(PQ.size() > k)
            {
                PQ.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = 0;
        while(!PQ.isEmpty())
        {
            Pair p = PQ.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;
    }
}
class Pair
{
    int x , y;
    int distance;
    public Pair(int x , int y)
    {
        this.x = x;
        this.y = y;
        this.distance = (x*x+ y*y);
    }
}