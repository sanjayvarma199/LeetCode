/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    //Time O(N)
    //Space O(N)
    int importance;
    Map<Integer , Employee> map;
    public int getImportance(List<Employee> employees, int id) {
        if(employees == null || employees.size() == 0)
        {
            return 0;
        }
        importance = 0;
        map = new HashMap<>();
        for(Employee e : employees)
        {
            map.put(e.id , e);
        }
        helper(id);
        return importance;
    }
    
    private void helper(int id)
    {
        importance += map.get(id).importance;
        for(int i : map.get(id).subordinates)
        {
            helper(i);
        }
    }
}