import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private DiningRoom diningRoom;
    private Guest guest;
    private Guest guest2;

    @Before
    public void before(){
        diningRoom = new DiningRoom(22, "The Bar and Grill");
        guest= new Guest("Ewan");
        guest2 = new Guest ("Harv");
    }

    @Test
    public void hasName(){
        assertEquals("The Bar and Grill", diningRoom.getName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(22, diningRoom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        diningRoom.addGuest(guest);
        assertEquals(1, diningRoom.getGuests().size());
    }

    @Test
    public void canRemoveGuest(){
        diningRoom.addGuest(guest);
        diningRoom.removeGuest(guest);
        assertEquals(0, diningRoom.getGuests().size());
    }

    @Test
    public void canClearRoom(){
        diningRoom.addGuest(guest);
        diningRoom.addGuest(guest2);
        diningRoom.emptyRoom();
        assertEquals(0, diningRoom.getGuests().size());
    }
}
