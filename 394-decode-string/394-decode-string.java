class Solution {
    //Time O(N*K) k -> Max num
    //Space O(Depth)
    public String decodeString(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        
        Stack<Integer> num_stack = new Stack<>();
        Stack<StringBuilder> string_stack = new Stack<>();
        
        int num = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                num = num*10 + (c-'0');
            }
            else if(c == '[')
            {
                num_stack.push(num);
                string_stack.push(sb);
                
                sb = new StringBuilder();
                num = 0;
            }
            else if(c == ']')
            {
                StringBuilder curr = new StringBuilder();
                int curr_num = num_stack.pop();
                for(int j = 0 ; j < curr_num ; j++)
                {
                    curr.append(sb);
                }
                sb = new StringBuilder(string_stack.pop().append(curr));
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}