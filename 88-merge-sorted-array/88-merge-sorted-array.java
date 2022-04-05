class Solution {
    //Time O(m+n)
    //Space O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //Input Validation
        if(nums1 == null || nums1.length == 0)
        {
            return;
        }
        int i = m-1 , j = m+n-1 , k = n-1;
        while(j >= 0 && k >= 0)
        {
            if(i >= 0 && nums1[i] >= nums2[k])
            {
                nums1[j] = nums1[i];
                i--;
            }
            else
            {
                nums1[j] = nums2[k];
                k--;
            }
            j--;
        }
        return;
    }
}