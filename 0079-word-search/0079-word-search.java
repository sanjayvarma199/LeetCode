class Solution {
    //TC O(N*3^L)
    //SC O(L)
    public boolean exist(char[][] board, String word) {
        //Input Validation
        if(board == null || board.length == 0)
        {
            return false;
        }
        int m = board.length , n = board[0].length;
        for(int i = 0 ; i < m ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                if(helper(board , word , i , j, 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    private boolean helper(char[][] board , String word , int i , int j , int index)
    {
        //Base Case
        if(index == word.length())
        {
            return true;
        }
        //Logic
        if(word.charAt(index) == board[i][j])
        {
            //Edge Case
            if(index+1 == word.length()) return true;
            
            char temp = board[i][j];
            board[i][j] = '#'; //Visited
            
            for(int[] dir : dirs)
            {
                int row = dir[0] + i;
                int col = dir[1] + j;
                if(row >= 0 && col >= 0 && row < board.length && col < board[0].length && helper(board , word, row , col , index+1))
                {
                    return true;
                }
            }
            board[i][j] = temp; // Backtrack
        }
        return false;
    }
}