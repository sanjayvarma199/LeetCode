class Solution {
    //TC O(M*N)
    //SC O(M*N)
    public int smallestCommonElement(int[][] mat) {
        //Input Validation
        if(mat == null || mat.length == 0)
        {
            return 0;
        }
        Map<Integer , Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                map.put(mat[i][j] , map.getOrDefault(mat[i][j] , 0)+1);
            }
        }
        int ans = Integer.MAX_VALUE;
        for(Map.Entry<Integer,Integer> entry : map.entrySet())
        {
            if(entry.getValue() == mat.length)
            {
                ans = Math.min(ans , entry.getKey());
            }
        }
        if(ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}