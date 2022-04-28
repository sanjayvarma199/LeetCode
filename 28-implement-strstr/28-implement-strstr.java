class Solution {
    //Time O(M*N)
    //Space O(1)
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
        {
            return 0;
        }
        if(needle.length() > haystack.length())
        {
            return -1;
        }
        for(int i = 0 ; i < haystack.length() ; i++)
        {
            int temp = i , j = 0;
            while(temp < haystack.length() && j < needle.length() && haystack.charAt(temp) == needle.charAt(j))
            {
                temp++;
                j++;
            }
            if(j == needle.length())
            {
                return i;
            }
        }
        return -1;
    }
}