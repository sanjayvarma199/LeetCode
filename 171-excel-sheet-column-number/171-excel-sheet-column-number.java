class Solution {
    //Time O(N)
    //Space O(1)
    public int titleToNumber(String columnTitle) {
        if(columnTitle == null || columnTitle.length() == 0)
        {
            return 0;
        }
        int result = 0;
        for(int i = 0 ; i < columnTitle.length() ; i++)
        {
            result *= 26;
            result += (columnTitle.charAt(i) - 'A' + 1);
        }
        return result;
    }
}