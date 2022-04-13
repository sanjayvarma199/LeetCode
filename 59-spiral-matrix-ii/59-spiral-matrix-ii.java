class Solution {
    //Time O(M*N)
    //Space O(1)
    public int[][] generateMatrix(int n) {
        if(n == 0)
        {
            return null;
        }
        
        int[][] matrix = new int[n][n];
        
        int row_start = 0 , row_end = n-1 , col_start = 0 , col_end = n-1;
        int counter = 1;
        
        while(row_start <= row_end && col_start <= col_end)
        {
            //First row
            for(int i = col_start ; i <= col_end ; i++)
            {
                matrix[row_start][i] = counter++;
            }
            row_start++;
            
            //Last col
            for(int i = row_start ; i <= row_end ; i++)
            {
                matrix[i][col_end] = counter++;
            }
            col_end--;
            
            //Last row
            for(int i = col_end ; i >= col_start ; i--)
            {
                matrix[row_end][i] = counter++;
            }
            row_end--;
            
            //First row
            for(int i = row_end ; i >= row_start ; i--)
            {
                matrix[i][col_start] = counter++;
            }
            col_start++;
        }
        return matrix;
    }
}