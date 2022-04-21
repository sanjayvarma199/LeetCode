class Solution {
    //Time O(Max(nums1 , nums2))
    //Space O(1)
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
        {
            return nums1;
        }
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<>();
        
        int m = nums1.length , n = nums2.length , i = 0 , j = 0;
        
        while(i < m && j < n)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                result.add(nums1[i]);
                i++;j++;
            }
        }
        return result.stream().mapToInt(k -> k).toArray();
    }
}