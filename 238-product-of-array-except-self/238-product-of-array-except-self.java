class Solution {
    //Time O(N)
    //Space O(1)
    public int[] productExceptSelf(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return nums;
        }
        
        int n = nums.length;
        int[] Left = new int[n];
        
        //Left side
        for(int i = 0 ; i < n ; i++)
        {
            if(i == 0)
            {
                Left[i] = 1;
                continue;
            }
            Left[i] = Left[i-1] * nums[i-1];
        }
        
        int Right = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--)
        {
            
            Left[i] = Left[i] * Right;
            Right = Right*nums[i];
        }
        
        return Left;
    }
}