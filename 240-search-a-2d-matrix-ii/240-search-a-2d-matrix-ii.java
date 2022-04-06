class Solution {
    //Time O(M+N)
    //Space O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        //Input Validation
        if(matrix == null || matrix.length == 0)
        {
            return false;
        }
        int row = matrix.length-1 , col = 0;
        while(row >= 0 && col < matrix[0].length)
        {
            if(matrix[row][col] == target)
            {
                return true;
            }
            else if(matrix[row][col] < target)
            {
                col++;
            }
            else
            {
                row--;
            }
        }
        return false;
    }
}