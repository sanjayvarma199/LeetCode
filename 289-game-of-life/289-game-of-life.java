class Solution {
    //Time O(M*N)
    //Space O(1)
    public void gameOfLife(int[][] board) {
        //Input Validation
        if(board == null || board.length == 0)
        {
            return;
        }
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                int ones = count(board , i , j);
                if(board[i][j] == 1 && (ones < 2 || ones > 3))
                {
                    board[i][j] = -2;
                }
                else if(board[i][j] == 0 && (ones == 3))
                {
                    board[i][j] = 2;
                }
            }
        }
        
        //Retain the state
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(board[i][j] == 2)
                {
                    board[i][j] = 1;
                }
                else if(board[i][j] == -2)
                {
                    board[i][j] = 0;
                }
            }
        }
        return;
    }
    private int count(int[][] board , int i , int j)
    {
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        int count = 0;
        for(int[] dir : dirs)
        {
            int new_i = i + dir[0];
            int new_j = j + dir[1];
            if(new_i >=0 && new_i < board.length && new_j >= 0 && new_j < board[0].length && (board[new_i][new_j] == 1 || board[new_i][new_j] == -2))
            {
                count++;
            }
        }
        return count;
    }
}