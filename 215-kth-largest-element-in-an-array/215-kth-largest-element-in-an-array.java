class Solution {
    //Time amortized O(N)
    //Space O(H)
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)
        {
            return 0;
        }
        k = nums.length - k;
        return QuickSelect(nums , 0 , nums.length-1 , k);
    }
    private int QuickSelect(int[] nums , int l , int r , int k)
    {
        int pivot = nums[r] , p = l;
        
        for(int i = l ; i < r ; i++)
        {
            if(nums[i] <= pivot)
            {
                swap(nums , i , p);
                p++;
            }
        }
        swap(nums , p , r);
        
        if(p < k)
        {
            return QuickSelect(nums , p+1 , r , k);
        }
        else if(p > k)
        {
            return QuickSelect(nums , l , p-1 , k);
        }
        return nums[p];
    }
    private void swap(int[] nums , int i , int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}