class Solution {
    //Time O(logN + K)
    //Space O(1)
    int left = 0 , right = 0;
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Input Validation
        if(arr == null || arr.length == 0)
        {
            return new ArrayList<>();
        }
        
        BinarySearch(arr , x);
        
        left = left-1;
        right = left+1;
        
        while(right - left <= k)
        {
            //If it reaches the left Bound
            if(left < 0)
            {
                right++;
                continue;
            }
            
            if(right == arr.length || (Math.abs(arr[left] - x)  <= Math.abs(arr[right]-x)))
            {
                left--;
            }
            else
            {
                right++;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = left+1 ; i < right ; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
    
    private void BinarySearch(int[] arr , int x)
    {
        left = 0 ; right = arr.length-1;
        
        while(left < right)
        {
            int mid = left + (right-left)/2;
            
            if(arr[mid] >= x)
            {
                right = mid;
            }
            else
            {
                left = mid+1;
            }
        }
        return;
    }
}