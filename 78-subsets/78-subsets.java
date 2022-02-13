class Solution {
    //Time O(2^N)
    //Space O(H)
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0)
        {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        helper(nums , 0 , new ArrayList<>());
        return result;
    }
    
    private void helper(int[] nums , int index , List<Integer> path)
    {
        //base
        if(index > nums.length)
        {
            return;
        }
        if(index == nums.length)
        {
           result.add(new ArrayList<>(path));
            return;
        }
        //logic
        helper(nums , index+1 , path); // Don't Chose
        path.add(nums[index]);
        helper(nums , index+1 , path); // Chose
        path.remove(path.size()-1); // Backtrack
    }
}