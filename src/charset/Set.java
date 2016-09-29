package charset;

public interface Set<E> {

    //////////////////////////////////////////////
    // for creators, see implementation classes
    
    //////////////////////////////////////////////
    // examples of observer methods

    /**
     * Get size of the set.
     * @return the number of elements in this set
     */
    public int size();

    /**
     * Test for membership.
     * @param e an element
     * @return true iff this set contains e
     */
    public boolean contains(E e);
    
    //////////////////////////////////////////////
    // examples of mutator methods
    
    /**
     * Modifies this set by adding e to the set.
     * @param e element to add
     */
    public void add(E e);

    /**
     * Modifies this set by removing e, if found.
     * If e is not found in the set, has no effect.  
     * @param e element to remove
     */
    public void remove(E e);
    
}
