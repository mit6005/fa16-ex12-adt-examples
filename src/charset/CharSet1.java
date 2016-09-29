package charset;

/**
 * A mutable set of characters.
 */
public class CharSet1 implements Set<Character> {

    private String s = "";

    // Rep invariant:
    //   s contains no repeated characters
    // Abstraction Function:
    //   represents the set of characters found in s
    // Safety from rep exposure:
    //   All fields are private and immutable.

    // Check that the rep invariant is true
    // *** Warning: this does nothing unless you turn on assertion checking
    // by passing -enableassertions to Java
    private void checkRep() {
        for (int i = 0; i < s.length(); ++i) {
            assert s.indexOf(s.charAt(i), i+1) == -1; // c not found in rest of string
        }
    }
    
    /**
     * Make a new empty character set.
     */
    public CharSet1() {
        checkRep();
    }
    
    @Override
    public int size() {
        checkRep();
        return s.length();
    }

    @Override
    public boolean contains(Character e) {
        checkRep();
        return s.indexOf(e) != -1;
    }

    @Override
    public void add(Character e) {
        if (!contains(e)) s += e;
        checkRep();
    }

    @Override
    public void remove(Character e) {
        int i = s.indexOf(e);
        if (i != -1) s = s.substring(0, i) + s.substring(i+1, s.length());
        checkRep();
    }
    
    // TODO: toString()

}
