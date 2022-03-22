class Solution {
    //Time O(N)
    //Space O(N)
    public int[] productExceptSelf(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return nums;
        }
        
        int n = nums.length;
        int[] Left = new int[n];
        int[] Right = new int[n];
        
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
        
        //Right side
        for(int i = n-1 ; i >= 0 ; i--)
        {
            if(i == n-1)
            {
                Right[i] = 1;
                continue;
            }
            Right[i] = Right[i+1] * nums[i+1];
        }
        
        for(int i = 0 ; i < n ; i++)
        {
            Left[i] = Left[i] * Right[i];
        }
        
        return Left;
    }
}