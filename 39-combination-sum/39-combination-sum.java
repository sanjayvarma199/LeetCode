class Solution {
    //Time O(2^N)
    //Space O(H)
    List<List<Integer>> result;
    int target;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0)
        {
            return new ArrayList<>();
        }
        this.target = target;
        result = new ArrayList<>();
        helper(candidates , 0 , 0 , new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates , int index , int curr_target , List<Integer> path)
    {
        //Base Case
        if(index >= candidates.length || curr_target > target)
        {
            return;
        }
        
        if(curr_target == target)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        
        //Dont' Chose
        helper(candidates , index+1 , curr_target , path);
        
        path.add(candidates[index]);
        
        helper(candidates , index , curr_target+candidates[index] , path);
        
        //Backtrack
        path.remove(path.size()-1);
    }
}