class Solution {
    //Time O(N)
    //Space O(1)
    public void sortColors(int[] nums) {
        //Input Validation
        if(nums == null || nums.length == 0)
        {
            return;
        }
        int start = 0 , mid = 0 , end = nums.length-1;
        while(mid <= end)
        {
            if(nums[mid] == 0)
            {
                swap(nums , mid , start);
                mid++;
                start++;
            }
            else if(nums[mid] == 2)
            {
                swap(nums , end , mid);
                end--;
            }
            else
            {
                mid++;
            }
        }
        return;
    }
    private void swap(int[] nums , int i ,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}