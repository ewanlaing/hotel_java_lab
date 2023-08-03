import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking;
    private Bedroom bedroom;

    private Guest guest;

    @Before
    public void before(){
        guest = new Guest ("Ewan");
        bedroom = new Bedroom (302, RoomType.DOUBLE, 100);
        booking = new Booking (bedroom, 3, guest);
    }

    @Test
    public void canCheckBill(){
        assertEquals(300, booking.getTotalBill());
    }
}
