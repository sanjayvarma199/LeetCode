class Solution {
    //Time O(log(N-k) + K)
    //Space O(K)
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        //Null Case
        if(arr == null || arr.length == 0)
        {
            return new ArrayList<>();
        }
        
        int low = 0 , high = arr.length-k;
        
        while(low < high)
        {
            int mid = low + (high - low)/2;
            int Dist_L = x - arr[mid];
            int Dist_R = arr[mid+k] - x;
            
            if(Dist_L > Dist_R)
            {
                low = mid+1;
            }
            else
            {
                high = mid;
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i = low ; i < low+k ; i++)
        {
            result.add(arr[i]);
        }
        return result;
    }
}