import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelTest {

    private Hotel hotel;
    private Bedroom bedroom;
    private Bedroom bedroom2;
    private ConferenceRoom conferenceRoom;
    private ConferenceRoom conferenceRoom2;

    private DiningRoom diningRoom;
    private DiningRoom diningRoom2;

    private Guest guest;
    private Guest guest2;

    @Before
    public void before(){
        hotel = new Hotel();
        bedroom = new Bedroom(302, RoomType.TRIPLE, 100);
        bedroom2 = new Bedroom(120, RoomType.DOUBLE, 75);
        conferenceRoom = new ConferenceRoom(12, "The Sunshine Room");
        conferenceRoom2 = new ConferenceRoom(66, "The Room of Doom");
        guest = new Guest("Ewan");
        guest2 = new Guest("Harv");
        diningRoom = new DiningRoom(20, "Bar and Grill");
        diningRoom2 = new DiningRoom(30, "Grillin' Bar");
        hotel.addBedroom(bedroom);
        hotel.addBedroom(bedroom2);
        hotel.addConferenceRoom(conferenceRoom);
        hotel.addConferenceRoom(conferenceRoom2);


    }

    @Test
    public void canBookRoom(){
        Booking booking = hotel.bookRoom(guest, 2, RoomType.DOUBLE);
        assertEquals(2, booking.getNumberOfNights());
        assertEquals("Ewan", booking.getGuest().getName());
        assertEquals(1, hotel.getBookings().size());
    }

    @Test public void canCheckOutBedroom(){
        Booking booking = hotel.bookRoom(guest, 2, RoomType.DOUBLE);
        hotel.checkOutBedroom(booking);
        Bedroom bedroom = booking.getBedroom();
        assertEquals(true, bedroom.isAvailable());
    }

    @Test public void canCheckInConferenceRoom(){
        hotel.checkInConferenceRoom(guest, "The Sunshine Room");
        assertEquals(1, conferenceRoom.getGuests().size());
    }

    @Test public void canCheckOutConferenceRoom(){
        hotel.checkInConferenceRoom(guest, "The Sunshine Room");
        hotel.checkOutConferenceRoom(guest, "The Sunshine Room");
        assertEquals(0, conferenceRoom.getGuests().size());
    }

    @Test public void preventsBookingWhenHotelFull(){
        Booking booking = hotel.bookRoom(guest, 2, RoomType.DOUBLE);
        Booking booking2 = hotel.bookRoom(guest, 2, RoomType.TRIPLE);
        Booking booking3 = hotel.bookRoom(guest, 2, RoomType.TRIPLE);
        assertEquals(Booking.class, booking.getClass());
        assertEquals(Booking.class, booking2.getClass());
        assertEquals(null, booking3);
    }

    @Test
    public void canAddDiningRoom(){
        hotel.addDiningRoom(diningRoom);
        hotel.addDiningRoom(diningRoom2);
        assertEquals(2, hotel.getDiningRooms().size());
    }
}
