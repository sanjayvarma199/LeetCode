class Solution {
    //Time O(N*3^L)
    //Space O(L)
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0)
        {
            return false;
        }
        
        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ; j++)
            {
                if(isValid(board , i , j , word , 0))
                {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board , int i , int j , String word , int index)
    {
        //Base Case
        if(word.length() == index)
        {
            return true;
        }
        //Logic
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        if(word.charAt(index) == board[i][j])
        {
            if(index+1 == word.length())
            {
                return true;
            }
            char temp = board[i][j];
            board[i][j] = '#';
            for(int[] dir : dirs)
            {
                int new_row = i + dir[0];
                int new_col = j + dir[1];

                if(new_row >= 0 && new_col >= 0 && new_row < board.length && new_col < board[0].length && isValid(board , new_row , new_col , word , index+1))
                {
                        return true;
                }
            }
            //Backtrack
            board[i][j] = temp;
        }
        return false;
        
    }
}