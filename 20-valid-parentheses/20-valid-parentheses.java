class Solution {
    //Time O(N)
    //Space O(1)
    public boolean isValid(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character , Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(!map.containsKey(c))
            {
                stack.push(c);
            }
            else
            {
                char pop = stack.isEmpty() ? '#' : stack.pop();
                if(pop != map.get(c))
                {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}