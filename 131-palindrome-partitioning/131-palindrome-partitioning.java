class Solution {
    //Time O(N*2^N) N -> Length of the string
    //Space O(N)
    List<List<String>> result;
    public List<List<String>> partition(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(s , 0 , new ArrayList<>());
        return result;
    }
    
    private void helper(String s , int index , List<String> path)
    {
        //Base Case
        if(index == s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        for(int i = index ; i < s.length() ; i++)
        {
            String sub_str = s.substring(index , i+1);
            if(isPalindrome(sub_str))
            {
                path.add(sub_str);
                helper(s , i+1 , path);
                //Backtrack
                path.remove(path.size()-1);
            }
        }
    }
    
    private boolean isPalindrome(String s)
    {
        int i = 0 , j = s.length()-1;
        while(i <= j)
        {
            if(s.charAt(i) != s.charAt(j))
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}