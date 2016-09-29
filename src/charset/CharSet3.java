package charset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A mutable set of characters.
 */
public class CharSet3 implements Set<Character> {

    private List<Character> chars = new ArrayList<>();
    
    // Rep Invariant:
    //   chars is sorted in increasing order with no repeated characters, so
    //       chars.get(i) < chars.get(i+1) for all 0<=i<chars.size()-2
    // Abstraction Function:
    //   represents the set of characters found in chars
    // Safety from rep exposure:
    //   All fields are private.  The rep contains only one mutable type,
    //   List<Character>, and none of the parameters or return values of the public
    //   methods have that type, so they can't expose any aliases to the rep.
    
    private void checkRep() {
        boolean first = true;
        char previousC = 0;
        for (Character c : chars) {
            if (!first) assert previousC < c;
            first = false;
        }
    }
    
    /**
     * Make a new empty character set.
     */
    public CharSet3() {
        checkRep();
    }
    
    @Override
    public int size() {
        checkRep();
        return chars.size();
    }

    @Override
    public boolean contains(Character e) {
        checkRep();
        return Collections.binarySearch(chars,  e) >= 0;
    }

    @Override
    public void add(Character e) {
        int i = Collections.binarySearch(chars,  e);
        if (i < 0) {
            // not yet in set
            chars.add(-i-1, e);
        }
        checkRep();
    }

    @Override
    public void remove(Character e) {
        // find and delete ALL occurrences of e
        for (int i = 0; i < chars.size(); ++i) {
            if (chars.get(i) == e) {
                chars.remove(i);
                break;
            }
        }
        checkRep();
    }
    
    // TODO: toString()

}
