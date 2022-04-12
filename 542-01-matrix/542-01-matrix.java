class Solution {
    //Time O(M*N)
    //Space O(min(M,N))
    public int[][] updateMatrix(int[][] mat) {
        //Input Vaidation
        if(mat == null || mat.length == 0)
        {
            return mat;
        }
        Queue<int[]> Q = new LinkedList<>();
        
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                if(mat[i][j] == 0)
                {
                    Q.add(new int[] {i,j});
                }
            }
        }
        
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        int level = 1;
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
                    
                    if(new_row >= 0 && new_col >= 0 && new_row < mat.length && new_col < mat[0].length && mat[new_row][new_col] == 1)
                    {
                        if(level == 1)
                        {
                            mat[new_row][new_col] = -1;
                        }
                        else
                        {
                            mat[new_row][new_col] = level;
                        }
                        Q.add(new int[] {new_row , new_col});
                    }
                }
            }
            level++;
        }
        
        for(int i = 0 ; i < mat.length ; i++)
        {
            for(int j = 0 ; j < mat[0].length ; j++)
            {
                if(mat[i][j] == -1)
                {
                    mat[i][j] = 1;
                }
            }
        }
        return mat;
    }
}