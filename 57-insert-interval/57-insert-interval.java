class Solution {
    //Time O(N)
    //Space O(1)
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //Input Validation
        if(newInterval == null)
        {
            return intervals;
        }
        int i = 0 , n = intervals.length;
        List<int[]> result = new ArrayList<>();
        
        // Process the intervals which are before new interval
        while(i < n && intervals[i][1] < newInterval[0])
        {
            result.add(intervals[i]);
            i++;
        }
        
        //Merge the Overlapping modules
        while(i < n && intervals[i][0] <= newInterval[1])
        {
            newInterval[0] = Math.min(intervals[i][0] , newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1] , newInterval[1]);
            i++;
        }
        result.add(newInterval);
        //Process rest of the intervals as is
        while(i < n)
        {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }
}