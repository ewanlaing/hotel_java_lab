import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom;
    private Guest guest;
    private Guest guest2;

    @Before
    public void before(){
        conferenceRoom = new ConferenceRoom(12, "The Sunshine Room");
        guest= new Guest("Ewan");
        guest2 = new Guest ("Harv");
    }

    @Test
    public void hasName(){
        assertEquals("The Sunshine Room", conferenceRoom.getName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(12, conferenceRoom.getCapacity());
    }

    @Test
    public void canAddGuest(){
        conferenceRoom.addGuest(guest);
        assertEquals(1, conferenceRoom.getGuests().size());
    }

    @Test
    public void canRemoveGuest(){
        conferenceRoom.addGuest(guest);
        conferenceRoom.removeGuest(guest);
        assertEquals(0, conferenceRoom.getGuests().size());
    }

    @Test
    public void canClearRoom(){
        conferenceRoom.addGuest(guest);
        conferenceRoom.addGuest(guest2);
        conferenceRoom.emptyRoom();
        assertEquals(0, conferenceRoom.getGuests().size());
    }
}
