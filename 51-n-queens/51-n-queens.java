class Solution {
    //Time O(N!)
    //Space O(N^2) To maintain the board
    List<List<String>> result;
    int[][] board;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        if(n == 0) return result;
        board = new int[n][n];
        helper(0 , n);
        return result;
    }
    
    private void helper(int r , int n)
    {
        //Base Case
        if(r == n)
        {
            List<String> list = new ArrayList<>();
            for(int i = 0 ; i < n ; i++)
            {
                StringBuilder sb = new StringBuilder();
                for(int j = 0 ; j < n ; j++)
                {
                    if(board[i][j] == 1)
                    {
                        sb.append("Q");
                    }
                    else
                    {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        //Logic
        for(int c = 0 ; c < n ; c++)
        {
            if(isValid(r , c , n))
            {
                board[r][c] = 1;
                helper(r+1 , n);
                //Backtrack
                board[r][c] = 0;
            }
        }
    }
    
    private boolean isValid(int r , int c , int n)
    {
        //Upward search
        int row = r , col = c;
        while(row >= 0)
        {
            if(board[row][c] == 1)
            {
                return false;
            }
            row--;
        }
        
        //Diagonal right
        row = r ; col = c;
        while(row >= 0 && col < n)
        {
            if(board[row][col] == 1)
            {
                return false;
            }
            row--;
            col++;
        }
        
        //Diagonal left
        row = r ; col = c;
        while(row >= 0 && col >= 0)
        {
            if(board[row][col] == 1)
            {
                return false;
            }
            row--;
            col--;
        }
        return true;
    }
}