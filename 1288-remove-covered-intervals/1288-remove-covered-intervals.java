class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
        {
            return 0;
        }
        Arrays.sort(intervals , new Comparator<>(){
            public int compare(int a[] , int b[])
            {
                if(a[0] == b[0])
                {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a , b) -> (b[0] - a[0]));
        for(int[] a : intervals)
        {
            if(!PQ.isEmpty() && (PQ.peek()[0] <= a[0] && PQ.peek()[1] >= a[1]))
            {
               continue;
            }
            System.out.println(a[0] + " " + a[1]);
            PQ.add(a);
        }
        return PQ.size();
    }
}