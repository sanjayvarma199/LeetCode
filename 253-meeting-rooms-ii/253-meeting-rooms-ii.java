class Solution {
    //TC O(NlogN)
    //SC O(1)
    public int minMeetingRooms(int[][] intervals) {
        //Input Validation
        if(intervals == null || intervals.length == 0)
        {
            return 0;
        }
        
        int count = 0 , ans = 0, n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        
        for(int k = 0 ; k < n ; k++)
        {
            start[k] = intervals[k][0];
            end[k] = intervals[k][1];
        }
        
        //Sort both the arrays
        Arrays.sort(start);
        Arrays.sort(end);
        
        int i = 0 , j = 0;
        while(i < n && j < n)
        {
            if(start[i] < end[j])
            {
                count++;
                i++;
            }
            else
            {
                count--;
                j++;
            }
            ans = Math.max(ans , count);
        }
        return ans;
    }
}