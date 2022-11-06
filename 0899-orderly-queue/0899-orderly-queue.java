class Solution {
    //TC O(N^2)
    //SC O(N)
    public String orderlyQueue(String s, int k) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return s;
        }
        if(k == 1)
        {
            String ans = s;
            for(int i = 1 ; i < s.length() ; i++)
            {
                String temp = s.substring(i) + s.substring(0,i);
                if(temp.compareTo(ans) < 0)
                {
                    ans = temp;
                }
            }
            return ans;
        }
        else
        {
            char ar[] = s.toCharArray();
            Arrays.sort(ar);
            return String.valueOf(ar);
        }
    }
}