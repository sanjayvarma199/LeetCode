// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Integer Next;
    Iterator<Integer> It;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    It = iterator;
        next();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return Next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer temp = Next;
        Next = null;
	    if(It.hasNext())
        {
            Next = It.next();
        }
        return temp;
	}
	
	@Override
	public boolean hasNext() {
	    return (Next != null);
	}
}