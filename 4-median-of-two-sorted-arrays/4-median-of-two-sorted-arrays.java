class Solution {
    //Time O(M+N)
    //Spaec O(M+N)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Input Validation
        if(nums1 == null || nums2 == null)
        {
            return 0;
        }
        
        int m = nums1.length , n = nums2.length , i = 0 , j = 0 , k = 0;
        int ar[] = new int[m + n];
        
        while(i < m || j < n)
        {
            if(i >= m)
            {
                ar[k] = nums2[j];
                j++;k++;
                continue;
            }
            else if(j >= n)
            {
                ar[k] = nums1[i];
                i++;k++;
                continue;
            }
            else
            {
                if(nums1[i] >= nums2[j])
                {
                    ar[k] = nums2[j];
                    j++;
                }
                else
                {
                    ar[k] = nums1[i];
                    i++;
                }
                k++;
            }
        }
        
        int mid = (m+n)/2;
        if((m+n) % 2 != 0)
        {
            return ar[mid];
        }
        double ans =  (ar[mid] + ar[mid-1]);
        return ans/2;
    }
}