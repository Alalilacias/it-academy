package S1.T4.n1.exercise1.src;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calendar size and positions test.")
class CalendarTest {
    private final static Calendar c = new Calendar();

    @Test
    void calendarSize() {
        assertEquals(12, c.calendar.size());
    }
    /* August checked at the eight position, as requested by the instructions.
     * Lists starting at 0, it'll fail the monthCheck() test. The trueMonthCheck() test contains the correct position.*/
    @Test
    void monthCheck() {
        assertEquals("August", c.calendar.get(8));
    }
    @Test
    void trueMonthCheck() {
        assertEquals("August", c.calendar.get(7));
    }

    @Test
    void calendarNotNull() {
        assertFalse(c.calendar.isEmpty());
    }
}