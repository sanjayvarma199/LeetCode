class Solution {
    //Time O(M*N)
    //Space O(min(M,N))
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0)
        {
            return image;
        }
        int prev_color = image[sr][sc];
        if(prev_color == newColor)
        {
            return image;
        }
        
        int m = image.length , n = image[0].length;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[] {sr,sc});
        image[sr][sc] = newColor;
        while(!Q.isEmpty())
        {
            int[] curr = Q.poll();
            for(int[] dir : dirs)
            {
                int new_row = dir[0] + curr[0];
                int new_col = dir[1] + curr[1];
                
                if(new_row >= 0 && new_row < m && new_col >=0 && new_col < n && image[new_row][new_col] == prev_color)
                {
                    image[new_row][new_col] = newColor;
                    Q.add(new int[] {new_row , new_col});
                }
            }
        }
        return image;
    }
}