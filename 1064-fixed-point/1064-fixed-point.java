class Solution {
    //Time O(logN)
    //Space O(1)
    public int fixedPoint(int[] arr) {
        if(arr == null || arr.length == 0)
        {
            return -1;
        }
        int low = 0 , high = arr.length-1 , ans = -1;
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            if(arr[mid] == mid)
            {
                ans = mid;
                high = mid-1;
            }
            else if(arr[mid] < mid)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return ans;
    }
}