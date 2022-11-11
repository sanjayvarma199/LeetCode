class Solution {
    //TC O(N)
    //SC O(1)
    public int romanToInt(String s) {
        //Input Validation
        if(s == null || s.length() == 0)
        {
            return 0;
        }
        Map<String , Integer> map = new HashMap<>();
        map.put("I" , 1);
        map.put("V" , 5);
        map.put("X" , 10);
        map.put("L" , 50);
        map.put("C" , 100);
        map.put("D" , 500);
        map.put("M" , 1000);
        
        int curr = 0 , prev = 0 , i = 0;
        int total = 0;
        while(i < s.length())
        {
            String roman = s.substring(i,i+1);
            curr = map.get(roman);
            if(curr > prev)
            {
                total -= prev;
            }
            else
            {
                total += prev;
            }
            prev = curr;
            i++;
        }
        total += prev;
        return total;
    }
}