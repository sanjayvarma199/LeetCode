class Solution {
    //TC O(NlogN)
    //SC O(N)
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0)
        {
            return logs;
        }
        
        Comparator<String> cmp = new Comparator<>()
        {
            @Override
            public int compare(String log1 , String log2)
            {
                String split1[] = log1.split(" ",2);
                String split2[] = log2.split(" ",2);
                
                boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
                
                if(!isDigit1 && !isDigit2)
                {
                    int cm = split1[1].compareTo(split2[1]);
                    if(cm != 0)
                    {
                        return cm;
                    }
                    return split1[0].compareTo(split2[0]);
                }
                if(isDigit1 && !isDigit2)
                {
                    return 1; //Letter Digit2 log come fist
                }
                else if(!isDigit1 && isDigit2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        };
        Arrays.sort(logs , cmp);
        return logs;
    }
}