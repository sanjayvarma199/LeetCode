class Solution {
    //Time O(M*N)
    //Space O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        //Input Validation
        if(matrix == null || matrix.length == 0)
        {
            return new ArrayList<>();
        }
        int row_start = 0 , row_end = matrix.length-1 , col_start = 0 , col_end = matrix[0].length-1;
        
        List<Integer> result = new ArrayList<>();
        //Logic
        while(row_start <= row_end && col_start <= col_end)
        {
            //Iterate through first row ele
            for(int i = col_start ; i <= col_end ; i++)
            {
                result.add(matrix[row_start][i]);
            }
            row_start++;
            
            //Iterate through last col ele
            for(int i = row_start ; i <= row_end ; i++)
            {
                result.add(matrix[i][col_end]);
            }
            col_end--;
            
            if(row_start <= row_end && col_start <= col_end)
            {
                 //Iterate through last row ele
                for(int i = col_end ; i >= col_start ; i--)
                {
                    result.add(matrix[row_end][i]);
                }
                row_end--;

                //Iterate through first col
                for(int i = row_end ; i >= row_start ; i--)
                {
                    result.add(matrix[i][col_start]);
                }
                col_start++;
            }
        }
        return result;
    }
}