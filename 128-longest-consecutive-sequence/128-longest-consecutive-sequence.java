class Solution {
    //Time O(N)
    //Space O(N)
    public int longestConsecutive(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            set.add(nums[i]);
        }
        
        int ans = 0;
        for(int ele : set)
        {
            if(!set.contains(ele-1))
            {
                int count = 1;
                while(set.contains(++ele))
                {
                    count++;
                }
                ans = Math.max(count , ans);
            }
        }
        return ans;
    }
}