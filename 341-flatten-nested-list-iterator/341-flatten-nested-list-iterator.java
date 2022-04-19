/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

//Time O(N)
//Space O(N)
public class NestedIterator implements Iterator<Integer> {
    
    List<Integer> result;
    public NestedIterator(List<NestedInteger> nestedList) {
        result = new ArrayList<>();
        DFS(nestedList);
    }
    
    private void DFS(List<NestedInteger> nestedList)
    {
        for(NestedInteger list : nestedList)
        {
            if(list.isInteger())
            {
                result.add(list.getInteger());
            }
            else
            {
                DFS(list.getList());
            }
        }
    }

    int i = -1;
    @Override
    public Integer next() {
        i++;
        return result.get(i);
    }

    @Override
    public boolean hasNext() {
        if(i < result.size()-1)
        {
            return true;
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */