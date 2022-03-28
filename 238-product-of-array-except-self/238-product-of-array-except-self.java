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
        int Left[] = new int[n];
        
        Left[0] = 1;
        //For Left Sum
        for(int i = 1 ; i < nums.length ; i++)
        {
             Left[i] = Left[i-1]*nums[i-1];   
        }
        
        int Right = 1;
        //For Left Sum
        for(int i = n-1 ; i >= 0 ; i--)
        {
             Left[i] = Right*Left[i]; 
             Right = Right * nums[i];
        }
        
        return Left;
    }
}