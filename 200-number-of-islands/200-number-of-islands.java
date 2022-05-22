class Solution {
    //Time O(M*N)
    //Space O(Max(M,N))
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        
        int islands = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                if(grid[i][j] == '1')
                {
                    BFS(grid , i , j);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void BFS(char[][] grid , int i , int j)
    {
        int dirs[][] = {{0,1},{0,-1},{1,0},{-1,0}};
        Queue<int[]> Q = new LinkedList<>();
        
        Q.add(new int[] {i,j});
        grid[i][j] = '0';
        
        while(!Q.isEmpty())
        {
            int[] curr = Q.poll();
            for(int[] dir : dirs)
            {
                int new_i = dir[0] + curr[0];
                int new_j = dir[1] + curr[1];
                if(new_i >= 0 && new_j >= 0 && new_i < grid.length && new_j < grid[0].length && grid[new_i][new_j] == '1')
                {
                    grid[new_i][new_j] = '0';
                    Q.add(new int[] {new_i , new_j});
                }
            }
        }
    }
}