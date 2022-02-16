class Solution {
    //Time O(N^2)
    //Space O(1)
    public int numKLenSubstrNoRepeats(String s, int k) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++)
        {
            int  j = i;
            Set<Character> set = new HashSet<>();
            while(j < s.length() && j - i < k)
            {
                char c = s.charAt(j);
                if(set.contains(c))
                {
                    break;
                }
                set.add(c);
                j++;
            }
            if(j - i == k) count++;
        }
        return count;
    }
}