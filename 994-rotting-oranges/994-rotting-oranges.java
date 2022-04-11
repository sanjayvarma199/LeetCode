class Solution {
    //Time O(M*N)
    //Space O(min(m,n))
    public int orangesRotting(int[][] grid) {
        //Input Validation
        if(grid == null || grid.length == 0)
        {
            return 0;
        }
        
        int fresh_orange = 0;
        
        Queue<int[]> Q = new LinkedList<>();
        
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length ; j++)
            {
                //Insert all rotten oranges
                if(grid[i][j] == 2)
                {
                    Q.add(new int[]{i,j});
                }
                else if(grid[i][j] == 1)
                {
                    fresh_orange++;
                }
            }
        }
        
        int time = -1;
        
        //Edge Case
        if(fresh_orange == 0) return 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!Q.isEmpty())
        {
            int size = Q.size();
            
            for(int i = 0 ; i < size ; i++)
            {
                int[] curr = Q.poll();
                
                for(int[] dir : dirs)
                {
                    int new_row = dir[0] + curr[0];
                    int new_col = dir[1] + curr[1];
                    
                    if(new_row >= 0 && new_col >= 0 && new_row < grid.length && new_col < grid[0].length && grid[new_row][new_col] == 1)
                    {
                        grid[new_row][new_col] = 2;
                        fresh_orange--;
                        Q.add(new int[] {new_row , new_col});
                    }
                }
            }
            time++;
        }
        if(fresh_orange != 0) return -1;
        return time;
    }
}