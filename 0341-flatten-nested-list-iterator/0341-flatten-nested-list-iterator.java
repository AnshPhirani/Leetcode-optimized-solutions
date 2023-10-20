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
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    Stack<NestedIterator> nestedIterators;
    int index;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.nestedIterators = new Stack<>();
        this.index = 0;
    }
    
    private void moveToNext(){
        while(!nestedIterators.isEmpty() && !nestedIterators.peek().hasNext()){
            nestedIterators.pop();
        }
        if(!nestedIterators.isEmpty() || index >= nestedList.size()) return;
        
        NestedInteger current = nestedList.get(index);
        if(!current.isInteger()){
            nestedIterators.push(new NestedIterator(current.getList()));
            index++;
            moveToNext();
        }
    }
    

    @Override
    public Integer next() {
        moveToNext();
        if(!nestedIterators.isEmpty()){
            int nextValue = nestedIterators.peek().next();
            return nextValue;
        }
        
        NestedInteger current = nestedList.get(index++);
        return current.getInteger();
    }

    @Override
    public boolean hasNext() {
        moveToNext();
        return this.index < this.nestedList.size() || !nestedIterators.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */