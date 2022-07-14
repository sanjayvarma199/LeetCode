class Solution {
    //Time O(N)
    //Space O(N)
    public boolean containsDuplicate(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(set.contains(nums[i]))
            {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}