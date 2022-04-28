class Solution {
    //Time O(M+N)
    //Space O(N)
    public int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0)
        {
            return 0;
        }
        int m = needle.length() , n = haystack.length();
        int ar[] = LPS(needle);
        
        int i = 0 , j = 0;
        while(i < haystack.length())
        {
            char hay_char = haystack.charAt(i) , needle_char = needle.charAt(j);
            if(hay_char == needle_char)
            {
                j++;
                i++;
                if(j == m) return i-m;
            }
            else if(j > 0)
            {
                j = ar[j-1];
            }
            else
            {
                i++;
            }
            
        }
        return -1;
    }
    
    private int[] LPS(String s)
    {
        int[] ar = new int[s.length()];
        if(s.length() <= 1) 
        {
            return ar;
        }
        int i = 1 , j = 0;
        while(i < s.length())
        {
            char charAt_i = s.charAt(i) , charAt_j = s.charAt(j);
            if(charAt_i == charAt_j)
            {
                j++;
                ar[i] = j;
                i++;
            }
            else if(j > 0)
            {
                j = ar[j-1];
            }
            else
            {
                i++;
            }
        }
        return ar;
    }
}