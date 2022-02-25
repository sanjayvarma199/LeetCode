class Solution {
    //Time O(N)
    //Space O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        return Atmost(nums , k) - Atmost(nums , k-1);
    }
    
    private int Atmost(int[] nums , int k)
    {
        if(k < 0) return 0;
        
        int left = 0 , result = 0;
        for(int right = 0 ; right < nums.length ; right++)
        {
            if(nums[right] % 2 != 0)
            {
                k--;
            }
            while(k < 0)
            {
                if(nums[left] % 2 != 0)
                {
                    k++;
                }
                left++;
            }
            result += right - left + 1;
        }
        return result;
    }
}