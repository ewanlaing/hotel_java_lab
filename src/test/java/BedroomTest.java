import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    public Bedroom bedroom;
    public Guest guest;
    public Guest guest2;

    @Before
    public void before(){
        bedroom = new Bedroom(302, RoomType.TRIPLE, 100);
        guest= new Guest("Ewan");
        guest2 = new Guest ("Harv");
    }

    @Test
    public void hasNumber(){
        assertEquals(302, bedroom.getRoomNumber());
    }

    @Test
    public void hasRoomType(){
        assertEquals(RoomType.TRIPLE, bedroom.getRoomType());
    }

    @Test
    public void hasCapacity(){
        assertEquals(3, bedroom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        bedroom.addGuest(guest);
        assertEquals(1, bedroom.getGuests().size());
    }

    @Test
    public void canRemoveGuest(){
        bedroom.addGuest(guest);
        bedroom.removeGuest(guest);
        assertEquals(0, bedroom.getGuests().size());
    }

    @Test
    public void canClearRoom(){
        bedroom.addGuest(guest);
        bedroom.addGuest(guest2);
        bedroom.emptyRoom();
        assertEquals(0, bedroom.getGuests().size());
    }

    @Test
    public void canGetSize(){
        assertEquals(150, Bedroom.getSize(bedroom.length, bedroom.width), 0.01);
    }
}
