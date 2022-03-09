class Solution {
    //Time O(N)
    //Space O(1)
    public String reorganizeString(String s) {
        if(s == null || s.length() == 0)
        {
            return s;
        }
        int max = 0 ; char max_c = 'a';
        int freq_ar[] = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++)
        {
            char c = s.charAt(i);
            freq_ar[c-'a']++;
            if(max <= freq_ar[c-'a'])
            {
                max = freq_ar[c-'a'];
                max_c = c; 
            }
        }
        
        //Edge Case if char exceeds half of the len(s)
        if(max > (s.length()+1)/2) return "";
        
        char ar[] = new char[s.length()];
        int index = 0;
        while(freq_ar[max_c - 'a'] > 0)
        {
            ar[index] = max_c;
            index += 2;
            freq_ar[max_c - 'a']--;
        }
        
        for(int i = 0 ; i < 26 ; i++)
        {
            while(freq_ar[i] > 0)
            {
                if(index >= s.length())
                {
                    index = 1;
                }
                ar[index] = (char)(i+'a');
                index += 2;
                freq_ar[i]--;
            }
        }
        return String.valueOf(ar);
    }
}