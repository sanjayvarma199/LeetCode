class Solution {
    //TC O(N)
    //SC O(1)
    public int maximum69Number (int num) {
        //Input Validation
        if(num == 0)
        {
            return num;
        }
        String s = num + "";
        int i = 0;
        while(i < s.length() && s.charAt(i) != '6')
        {
            i++;
        }
        if(i >= s.length()) return num;
        s = s.substring(0,i) + '9' + s.substring(i+1);
        return Integer.parseInt(s);
    }
}