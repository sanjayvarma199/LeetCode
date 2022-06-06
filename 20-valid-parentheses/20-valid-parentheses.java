class Solution {
    //Time O(N)
    //Space O(1)
    public boolean isValid(String s) {
        if(s == null || s.length() == 0)
        {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character , Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                char pop = stack.isEmpty() ? '#' : stack.pop();
                if(map.get(c) != pop)
                {
                    return false;
                }
            }
            else
            {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}