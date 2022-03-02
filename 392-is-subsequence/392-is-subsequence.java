class Solution {
    //Time O(M+N)
    //Space O(1)
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.length() == 0)
        {
            return true;
        }
        int i = 0 , j = 0;
        while(i < s.length() && j < t.length())
        {
            char S_Char = s.charAt(i);
            char T_Char = t.charAt(j);
            if(S_Char == T_Char)
            {
                i++;
            }
            j++;
        }
        if(i == s.length()) return true;
        return false;
    }
}