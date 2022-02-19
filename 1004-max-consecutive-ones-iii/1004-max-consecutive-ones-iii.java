class Solution {
    //Time O(2N)
    //Space O(1)
    public int longestOnes(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        
        int left = 0 , curr = 0 , result = 0;
        for(int right = 0 ; right < nums.length ; right++)
        {
            if(nums[right] == 0) curr++;
            while(curr > k)
            {
                if(nums[left] == 0) curr--;
                left++;
            }
            result = Math.max(result , right - left + 1);
        }
        return result;
    }
}