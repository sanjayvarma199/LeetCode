class Solution {
    //Time O(N)
    //Space O(N)
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0)
        {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        int index = -1;
        
        for(int i = 0 ; i < ops.length ; i++)
        {
            String s = ops[i];
            
            if(s.equals("+"))
            {
                int sum = list.get(index) + list.get(index-1);
                list.add(sum);
            }
            else if(s.equals("D"))
            {
                list.add(2*list.get(index));
            }
            else if(s.equals("C"))
            {
                list.remove(index);
                index = index-2;
            }
            else
            {
                list.add(Integer.parseInt(s));
            }
            index++;
        }
        
        int ans = 0;
        for(int j : list)
        {
            ans += j;
        }
        
        return ans;
    }
}