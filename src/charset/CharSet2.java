package charset;

/**
 * A mutable set of characters.
 */
public class CharSet2 implements Set<Character> {

    private String s = "";
    
    // Rep Invariant:
    //   true (i.e., s is a non-null String, but no more assumptions are made)
    // Abstraction Function:
    //   represents the set of characters found in s
    // Safety from rep exposure:
    //   All fields are private and immutable.
    
    private void checkRep() {
        assert s != null;
    }
    
    /**
     * Make a new empty character set.
     */
    public CharSet2() {
        checkRep();
    }
    
    @Override
    public int size() {
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (s.indexOf(c, i+1) == -1) {
                // This is the last time c occurs in s, so
                // count it now.  This avoid double-counting
                // characters that occur more than once.
                ++n;
            }
        }
        checkRep();
        return n;
    }

    @Override
    public boolean contains(Character e) {
        checkRep();
        return s.indexOf(e) != -1;
    }

    @Override
    public void add(Character e) {
        s += e;
        checkRep();
    }

    @Override
    public void remove(Character e) {
        // find and delete ALL occurrences of e
        while (true) {
            int i = s.indexOf(e); 
            if (i == -1) break;
            s = s.substring(0, i) + s.substring(i+1, s.length());
        }
        checkRep();
    }
    
    // TODO: toString()

}
