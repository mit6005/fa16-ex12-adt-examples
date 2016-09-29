package charset;

import org.junit.Test;
import static org.junit.Assert.*;

public class CharSetTest {

    // Testing strategy
    //
    // CharSet()
    //   only one test case
    // size()
    //   size: 0, 1, n
    // contains(e)
    //   size: 0, 1, n
    //   e present or not
    // add(e):
    //   size before: 0, 1, n
    //   size after: 0, 1, n
    //   e present or not
    //   set made by add(), made by remove()
    // remove(e):
    //   size before: 0, 1, n
    //   size after: 0, 1, n
    //   e present or not
    //   set made by add(), made by remove()
    //
    
    private static Set<Character> empty() {
        return new CharSet3();
    }
    
    @Test
    public void testEmpty() {
        Set<Character> cs = empty();
        assertEquals(0, cs.size());
        assertEquals(false, cs.contains('z'));
    }

    @Test
    public void testAddSingleton() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        assertEquals(1, cs.size());
        assertEquals(true, cs.contains('b'));
        assertEquals(false, cs.contains('z'));
    }

    @Test
    public void testAddRedundant() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('b'); // cs is still {b}
        assertEquals(1, cs.size());
        assertEquals(true, cs.contains('b'));
        assertEquals(false, cs.contains('z'));
    }

    @Test
    public void testAddPair() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('c'); // cs is now {b, c}
        assertEquals(2, cs.size());
        assertEquals(true, cs.contains('b'));
        assertEquals(true, cs.contains('c'));
        assertEquals(false, cs.contains('y'));
    }

    @Test
    public void testAddTriple() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.add('c'); // cs is now {b, c}
        cs.add('d'); // cs is now {b, c, d}
        assertEquals(3, cs.size());
        assertEquals(true, cs.contains('b'));
        assertEquals(true, cs.contains('c'));
        assertEquals(true, cs.contains('d'));
        assertEquals(false, cs.contains('x'));
    }
    
    @Test
    public void testSingletonRemove() {
        Set<Character> cs = empty();
        cs.add('b'); // cs is now {b}
        cs.remove('b'); // cs is now {}
        assertEquals(0, cs.size());
        assertEquals(false, cs.contains('b'));
        assertEquals(false, cs.contains('z'));
    }
    
    // TODO additional tests to cover all partitions of add() and remove()
    
}
