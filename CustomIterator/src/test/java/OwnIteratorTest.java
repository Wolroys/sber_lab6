import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class OwnIteratorTest {

    @Test
    void testHasNext() {
        Integer[] arr = {1, 2, 3};
        OwnIterator iterator = new OwnIterator(arr);

        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        assertTrue(iterator.hasNext());
        assertEquals(3, iterator.next());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testNextThrowsExceptionIfNoElements() {
        String[] array = {};
        OwnIterator iterator = new OwnIterator(array);
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testRemove() {
        Integer[] array = {1, 2, 3};
        OwnIterator iterator = new OwnIterator(array);

        iterator.next();
        iterator.remove();
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());

        iterator.next();
        iterator.remove();
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testRemoveThrowsExceptionIfNoElements() {
        String[] array = {};
        OwnIterator iterator = new OwnIterator(array);
        assertThrows(IllegalStateException.class, iterator::remove);
    }
}