class Solution {
    //Time O(N)
    //Space O(1)
    public int numKLenSubstrNoRepeats(String s, int k) {
        
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        int count = 0;
        Set<Character> set = new HashSet<>();
        //Two Pointers
        int left = 0 , right = 0;
        while(right < s.length())
        {
            char c = s.charAt(right);
            while(set.contains(c))
            {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            if(right - left + 1 == k)
            {
                count++;
                set.remove(s.charAt(left));
                left++;
            }
            right++;
        }
        return count;
    }
}