class Solution {
    // N - words.length ;  l - word.length()
    //Time O(S*N*L - (N*L)^2)
    //Space O(N)
    int subString_len , word_len , size;
    Map<String , Integer> map;
    public List<Integer> findSubstring(String s, String[] words) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        size = words.length;
        word_len = words[0].length();
        subString_len = size*word_len;
        
        //Create an HashMap for freq count
        map = new HashMap<>();
        
        //Process all the words
        for(int i = 0; i < words.length ; i++)
        {
            map.put(words[i] , map.getOrDefault(words[i] , 0) + 1);
        }
        
        
        //Process the string to find the indexes of a substring
        for(int i = 0; i <= s.length()-subString_len ; i++)
        {
            if(Valid(s , i))
            {
                list.add(i);
            }
        }
        return list;
    }
    
    private boolean Valid(String s , int i)
    {
        int count = 0;
        HashMap<String , Integer> map1 = new HashMap<>(map);
        for(int j = i; j < i + subString_len ; j += word_len)
        {
            String sub_String = s.substring(j , j + word_len);
            if(map1.containsKey(sub_String))
            {
                map1.put(sub_String , map1.get(sub_String)-1);
                map1.remove(sub_String , 0);
                count++;
            }
            else
            {
                break;
            }
        }
        return count == size;
    }
}