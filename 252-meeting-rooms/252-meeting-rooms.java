class Solution {
    //Time O(NlogN)
    //Space O(1)
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
        {
            return true;
        }
        Arrays.sort(intervals , new Comparator<>()
                    {
                        public int compare(int[] a , int[] b)
                        {
                            return a[0]-b[0];
                        }
                    });
        for(int i = 0; i < intervals.length -1; i++)
        {
            if(intervals[i][1] > intervals[i+1][0])
            {
                return false;
            }
        }
        return true;
    }
}