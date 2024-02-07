package S1.T4.n1.exercise1.src;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CalendarIT {
//    List filled with months of the calendar, the contents and order of which we'll test
    List<String> calendar = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December");

    @Test
    public void calendarSize() {
        assertEquals(12, calendar.size());
    }
    /* August checked at the eight position, as requested by the instructions.
     * Lists starting at 0, it'll fail the monthCheck() test. The trueMonthCheck() test contains the correct position.*/
    @Test
    public void monthCheck() {
        assertEquals("August", calendar.get(8));
    }
    @Test
    public void trueMonthCheck() {
        assertEquals("August", calendar.get(7));
    }

    @Test
    public void calendarNotNull() {
        assertFalse(calendar.isEmpty());
    }
}
