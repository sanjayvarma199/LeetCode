class Solution {
    //Time O(NlogN)
    //Space O(N)
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
        {
            return intervals;
        }
        
        Arrays.sort(intervals , new Comparator<>()
                    {
                       public int compare(int[] a , int[] b)
                       {
                           return a[0]-b[0];
                       }
                    });
        LinkedList<int[]> List = new LinkedList<>();
        for(int i = 0 ; i < intervals.length ; i++)
        {
            if(!List.isEmpty() && List.getLast()[1] >= intervals[i][0])
            {
                List.getLast()[1] = Math.max(List.getLast()[1] , intervals[i][1]);
            }
            else
            {
                List.add(intervals[i]);
            }
        }
        return List.toArray(new int[List.size()][2]);
    }
}