import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GuestTest {

    private Guest guest;

    @Before
    public void before(){
        guest = new Guest("Ewan");
    }

    @Test
    public void guestHasName(){
        assertEquals("Ewan", guest.getName());
    }

}
