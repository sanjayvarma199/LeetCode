class Solution {
    //Time O(N)
    //Space O(N)
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        int open = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(c == '(')
            {
                open++;
            }
            else if(c == ')')
            {
                if(open <= 0) continue;
                open--;
            }
            sb.append(c);
        }
        
        StringBuilder sb1 = new StringBuilder();
        for(int i = sb.length()-1 ; i >= 0 ; i--)
        {
            char c = sb.charAt(i);
            if(c == '(' && open-- > 0)
            {
                continue;
            }
            sb1.append(c);
        }
        return sb1.reverse().toString();
    }
}