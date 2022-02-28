class Solution {
    //Time O(N)
    //Space O(1)
    public List<String> summaryRanges(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        
        List<String> list = new ArrayList<>();
        
        int low = 0 , high = 0;
        while(high < nums.length)
        {
            int num = nums[high];
            while(high < nums.length && num == nums[high])
            {
                num++;
                high++;
            }
            String s = "";
            if(low != high-1) s = nums[low] + "->" + nums[high-1];
            else s = s+nums[low];
            list.add(s);
            low = high;
        }
        return list;
    }
}