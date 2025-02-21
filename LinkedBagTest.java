import org.junit.*;
import org.junit.Before;
import static org.junit.Assert.*;

public class LinkedBagTest {
    private LinkedBag<String> bag;
    private LinkedBag<String> anotherBag;

    @Before
    public void setUp() {
        bag = new LinkedBag<>();
        anotherBag = new LinkedBag<>();
    }

    @Test
    public void testAdd() {
        assertTrue(bag.add("apple"));
        assertTrue(bag.add("banana"));
    }

    @Test
    public void testIsEmpty() {
        assertTrue(bag.isEmpty());
        bag.add("item");
        assertFalse(bag.isEmpty());
    }

    @Test
    public void testGetCurrentSize() {
        assertEquals(0, bag.size());
        bag.add("apple");
        assertEquals(1, bag.size());
    }

    @Test
    public void testRemove() {
        bag.add("apple");
        assertTrue(bag.remove("apple"));
        assertFalse(bag.remove("banana"));
    }

    @Test
    public void testClear() {
        bag.add("apple");
        bag.add("banana");
        bag.clear();
        assertTrue(bag.isEmpty());
    }

    @Test
    public void testContains() {
        bag.add("apple");
        assertTrue(bag.contains("apple"));
        assertFalse(bag.contains("banana"));
    }

    @Test
    public void testUnion() {
        bag.add("apple");
        anotherBag.add("banana");
        LinkedBag<String> unionBag = (LinkedBag<String>) bag.union(anotherBag);
        assertTrue(unionBag.contains("apple"));
        assertTrue(unionBag.contains("banana"));
        assertEquals(2, unionBag.size());
    }

    @Test
    public void testIntersection() {
        bag.add("apple");
        bag.add("banana");
        anotherBag.add("banana");
        LinkedBag<String> intersectionBag = (LinkedBag<String>) bag.intersection(anotherBag);
        assertTrue(intersectionBag.contains("banana"));
        assertFalse(intersectionBag.contains("apple"));
        assertEquals(1, intersectionBag.size());
    }

    @Test
    public void testDifference() {
        bag.add("apple");
        bag.add("banana");
        anotherBag.add("banana");
        LinkedBag<String> differenceBag = (LinkedBag<String>) bag.difference(anotherBag);
        assertTrue(differenceBag.contains("apple"));
        assertFalse(differenceBag.contains("banana"));
        assertEquals(1, differenceBag.size());
    }
}
