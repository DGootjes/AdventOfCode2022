import static org.junit.jupiter.api.Assertions.*;

class TopListTest {

    @org.junit.jupiter.api.Test
    void tryAdd() {
        TopList l = new TopList(5);
        assertEquals(l.list.size(), 5);
        l.TryAdd(1.0);
        assertTrue(l.list.get(2) - 1.0 < 1E-9);
    }

    @org.junit.jupiter.api.Test
    void tryInsert()
    {
        TopList l = new TopList(3);
        l.TryAdd(5.0);
        l.TryAdd(2.0);
        l.TryAdd(1.0);

        assertTrue(Math.abs(l.list.get(2) - 5.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(1) - 2.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(0) - 1.0) < 1E-9);

        // Insert 3.0
        l.TryAdd(3.0);
        assertTrue(Math.abs(l.list.get(2) - 5.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(1) - 3.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(0) - 2.0) < 1E-9);

        // Insert 6.0
        l.TryAdd(6.0);
        assertTrue(Math.abs(l.list.get(2) - 6.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(1) - 5.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(0) - 3.0) < 1E-9);

        // Insert 4.0
        l.TryAdd(4.0);
        assertTrue(Math.abs(l.list.get(2) - 6.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(1) - 5.0) < 1E-9);
        assertTrue(Math.abs(l.list.get(0) - 4.0) < 1E-9);
    }

    @org.junit.jupiter.api.Test
    void sum() {
        //assertTrue(false);
    }
}