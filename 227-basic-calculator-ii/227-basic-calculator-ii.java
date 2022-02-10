class Solution {
    //Time O(N)
    //Space O(N)
    public int calculate(String s) {
         if(s == null || s.length() == 0)
        {
            return 0;
        }
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        char LastSign = '+';
        int curr = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(Character.isDigit(c))
            {
                curr = curr * 10 + (c - '0');
            }
            if(c != ' ' && (!Character.isDigit(c) || i == s.length()-1))
            {
                if(LastSign == '*')
                {
                    curr = curr * stack.pop();
                }
                else if(LastSign == '-')
                {
                    curr = -curr;
                }
                else if(LastSign == '/')
                {
                    curr = stack.pop()/curr;
                }
                stack.push(curr);
                LastSign = c;
                curr = 0;
            }
        }
        int result = 0;
        while(!stack.isEmpty())
        {
            result += stack.pop();
        }
        return result;
    }
}