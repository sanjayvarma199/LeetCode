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
                            return a[0] - b[0];
                        }
                    });
        
        LinkedList<int[]> list = new LinkedList<>();
        
        for(int[] ar : intervals)
        {
            if(!list.isEmpty() && list.getLast()[1] >= ar[0])
            {
                list.getLast()[1] = Math.max(list.getLast()[1] , ar[1]);
            }
            else
            {
                list.add(ar);
            }
        }
        return list.toArray(new int[list.size()][2]);
    }
}