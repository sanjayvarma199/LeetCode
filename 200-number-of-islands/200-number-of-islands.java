class Solution {
    //TC O(M*N)
    //SC O(Min(M,N))
    public int numIslands(char[][] grid) {
        //Inout Validation
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        
        int ans = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    BFS(grid , i , j);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    private void BFS(char[][] grid , int i, int j)
    {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        
        Queue<int[]> Q = new LinkedList<>();
        Q.add(new int[]{i,j});
        grid[i][j] = '0'; // Make it visited
        
        while(!Q.isEmpty())
        {
            int[] curr = Q.poll();
            for(int[] dir : dirs)
            {
                int new_i = curr[0] + dir[0];
                int new_j = curr[1] + dir[1];
                if(new_i >= 0 && new_j >= 0 && new_i < grid.length && new_j < grid[0].length && grid[new_i][new_j] == '1')
                {
                    grid[new_i][new_j] = '0';
                    Q.add(new int[]{new_i , new_j});
                }
            }
        }
        return;
    }
}