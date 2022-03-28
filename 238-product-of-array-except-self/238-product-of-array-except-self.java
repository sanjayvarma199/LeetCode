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
        int Left[] = new int[n];
        int Right[] = new int[n];
        
        Left[0] = 1;
        //For Left Sum
        for(int i = 1 ; i < nums.length ; i++)
        {
             Left[i] = Left[i-1]*nums[i-1];   
        }
        
        Right[n-1] = 1;
        //For Left Sum
        for(int i = n-2 ; i >= 0 ; i--)
        {
             Right[i] = Right[i+1]*nums[i+1];   
        }
        
        //Total Product
        for(int i = 0 ; i < n ; i++)
        {
            Left[i] = Left[i] * Right[i];
        }
        return Left;
    }
}