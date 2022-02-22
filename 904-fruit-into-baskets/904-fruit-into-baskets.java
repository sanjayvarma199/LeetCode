class Solution {
    //Time O(N)
    //Space O(N)
    public int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0)
        {
            return 0;
        }
        
        int left = 0 , result = 0;
        Map<Integer , Integer> map = new HashMap<>(); // {Type , freq}
        
        for(int right = 0 ; right < fruits.length ; right++)
        {
            int type = fruits[right];
            map.put(type , map.getOrDefault(type , 0) + 1);
            
            while(map.size() > 2)
            {
                int Left_Type = fruits[left];
                map.put(Left_Type , map.get(Left_Type)-1);
                map.remove(Left_Type , 0);
                left++;
            }
            
            result = Math.max(result , right-left+1);
        }
        return result;
    }
}