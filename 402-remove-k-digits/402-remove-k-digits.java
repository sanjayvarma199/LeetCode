class Solution {
    //Time O(N)
    //Space O(N)
    public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0)
        {
            return num;
        }
        
        LinkedList<Character> stack = new LinkedList<>();
        for(int i = 0 ; i < num.length() ; i++)
        {
            char c = num.charAt(i);
            while(!stack.isEmpty() && k > 0 && stack.peekLast() > c)
            {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        while(k > 0)
        {
            stack.removeLast();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean zero = true;
        for(char c : stack)
        {
            if(zero && c == '0') continue;
            zero = false;
            sb.append(c);
        }
        
        if(sb.toString().length() == 0) return "0";
        return sb.toString();
    }
}