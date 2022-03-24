class Solution {
    //Time O(NlogN)
    //Space O(1)
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
        {
            return intervals;
        }
        //Sort the intervals based on start time
        Arrays.sort(intervals , new Comparator<>()
                    {
                        public int compare(int[] a , int[] b)
                        {
                            return a[0]-b[0];
                        }
                    });
        LinkedList<int[]> list = new LinkedList<>();
        
        for(int i = 0 ; i < intervals.length ; i++)
        {
            if(!list.isEmpty() && list.getLast()[1] >= intervals[i][0])
            {
                list.getLast()[1] = Math.max(list.getLast()[1] , intervals[i][1]);
            }
            else
            {
                list.add(intervals[i]);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}