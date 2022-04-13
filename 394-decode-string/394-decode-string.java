class Solution {
    //Time O(N*k) k is max num
    //Space O(Depth of nested braces)
    public String decodeString(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return s;
        }
        
        Stack<StringBuilder> string_stack = new Stack<>();
        Stack<Integer> num_stack = new Stack<>();
        
        int num = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            
            if(c == '[')
            {
                num_stack.push(num);
                string_stack.push(sb);
                
                num = 0;
                sb = new StringBuilder();
            }
            else if(c == ']')
            {
                int curr = num_stack.pop();
                StringBuilder curr_string = new StringBuilder(sb.toString());
                sb = new StringBuilder();
                for(int j = 0 ; j < curr ; j++)
                {
                    sb.append(curr_string);
                }
                sb = string_stack.pop().append(sb);
            }
            else if(Character.isDigit(c))
            {
                num = num*10 + (c-'0');
            }
            else 
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}