class Solution {
    //TC O(N)
    //SC O(1)
    public String reverseVowels(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return s;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        
        int low = 0 , high = s.length()-1;
        char ar[] = s.toCharArray();
        while(low < high)
        {
            while(low < high && !set.contains(ar[low]))
            {
                low++;
            }
            while(low < high && !set.contains(ar[high]))
            {
                high--;
            }
            char temp = ar[low];
            ar[low] = ar[high];
            ar[high] = temp;
            low++;
            high--;
        }
        return String.valueOf(ar);
    }
}