class Solution {
    //TC O(N)
    //SC O(N)
    public int longestPalindrome(String[] words) {
        //Input Validation
        if(words == null || words.length == 0)
        {
            return 0;
        }
        Map<String , Integer> map = new HashMap<>();
        //Freq Map
        for(String word : words)
        {
            map.put(word , map.getOrDefault(word , 0)+1);
        }
        
        int ans = 0;
        boolean central = false;
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            String s = entry.getKey();
            if(s.charAt(0) == s.charAt(1))
            {
                int count = entry.getValue();
                if(count % 2 == 0)
                {
                    ans += count;
                }
                else
                {
                    ans += (count-1);
                    central = true;
                }
            }
            else if(s.charAt(0) < s.charAt(1))
            {
                String reverse = Reverse(s);
                if(map.containsKey(reverse))
                {
                    ans += (2 * Math.min(entry.getValue() , map.get(reverse)));
                }
            }
        }
        if(central) ans++;
        return ans*2;
    }
    
    private String Reverse(String s)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(1));
        sb.append(s.charAt(0));
        return sb.toString();
    }
}