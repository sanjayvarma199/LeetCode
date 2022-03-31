class Solution {
    //Time O(N)
    //Space O(1)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            //If the indexed num is greater than 0 then it is not visited till now
            if(nums[Math.abs(nums[i])-1] > 0)
            {
               nums[Math.abs(nums[i])-1] *= -1; 
            }
        }
        
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] > 0)
            {
                result.add(i+1);
            }
        }
        return result;
    }
}