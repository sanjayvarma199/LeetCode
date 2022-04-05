class Solution {
    //Time O(N)
    //Space O(1)
    public int maxArea(int[] height) {
        //Input Validation
        if(height == null || height.length < 2)
        {
            return 0;
        }
        int max_area = 0;
        int low = 0 , high = height.length-1;
        
        //logic
        while(low < high)
        {
            int min_height = Math.min(height[low] , height[high]);
            max_area = Math.max(max_area , min_height*(high - low));
            
            if(height[low] < height[high]) // Shift towards the greater height
            {
                low++;
            }
            else
            {
                high--;
            }
        }
        return max_area;
    }
}