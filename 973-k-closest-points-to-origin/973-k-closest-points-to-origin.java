class Solution {
    //TC O(NlogN)
    //SC O(K)
    public int[][] kClosest(int[][] points, int k) {
        //Input Validation
        if(points == null || points.length == 0)
        {
            return points;
        }
        
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a,b) -> (-(a[0]*a[0] + a[1]*a[1]) + (b[0]*b[0] + b[1]*b[1])));
        
        for(int i = 0 ; i < points.length ; i++)
        {
            PQ.add(points[i]);
            if(PQ.size() > k)
            {
                PQ.poll();
            }
        }
        int[][] ans = new int[k][2];
        int i = k-1;
        while(!PQ.isEmpty())
        {
            ans[i] = PQ.poll();
            i--;
        }
        return ans;
    }
}