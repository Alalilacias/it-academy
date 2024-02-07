package S1.T4.n1.exercise1.src;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalendarTest {
//    Calendar to test instantiation so we can test it
    static final Calendar c = new Calendar();
//    Tests
    @Test
    public void calendarSize() {
        assertEquals(12, c.calendar.size());
    }
    /* August checked at the eight position, as requested by the instructions.
     * Lists starting at 0, it'll fail the monthCheck() test. The trueMonthCheck() test contains the correct position.*/
    @Test
    public void monthCheck() {
        assertNotEquals("August", c.calendar.get(8));
    }
    @Test
    public void trueMonthCheck() {
        assertEquals("August", c.calendar.get(7));
    }

    @Test
    public void calendarNotNull() {
        assertFalse(c.calendar.isEmpty());
    }
}