import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Hotel {

    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    private ArrayList<Booking> bookings;

    private HashMap<String, DiningRoom> diningRooms;

    public Hotel() {
        bedrooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        bookings = new ArrayList<>();
        diningRooms = new HashMap<>();
    }

    public ArrayList<Bedroom> getBedrooms() {
        return bedrooms;
    }

    public ArrayList<ConferenceRoom> getConferenceRooms() {
        return conferenceRooms;
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRooms.add(conferenceRoom);
    }

//    public boolean checkInBedroom(Guest guest, RoomType roomType){
//        for (Bedroom bedroom : bedrooms){
//            if (bedroom.getRoomType() == roomType){
//                if(bedroom.isAvailable()){
//                    bedroom.addGuest(guest);
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public void checkInBedroom(Guest guest, Bedroom bedroom) {
        bedroom.addGuest(guest);
    }

    public void checkOutBedroom(Booking booking) {
        Bedroom bedroom = booking.getBedroom();
        bedroom.emptyRoom();
    }

    public Bedroom findEmptyBedroom(RoomType roomtype) {
        for (Bedroom bedroom : bedrooms) {
            if (bedroom.isAvailable() && bedroom.getRoomType() == roomtype) {
                return bedroom;
            }
        }
        return null;
    }

    public Booking bookRoom(Guest guest, int numberOfNights, RoomType roomType) {
        Bedroom bedroom = findEmptyBedroom(roomType);
        if (bedroom != null) {
            checkInBedroom(guest, bedroom);
            Booking booking = new Booking(bedroom, numberOfNights, guest);
            this.bookings.add(booking);
            return booking;
        }
        return null;
    }

    public ConferenceRoom getConferenceRoomByName(String name) {
        for (ConferenceRoom conferenceRoom : conferenceRooms) {
            if (conferenceRoom.getName() == name) {
                return conferenceRoom;
            }
        }
        return null;
    }

    public boolean checkInConferenceRoom(Guest guest, String name) {
        ConferenceRoom conferenceRoom = getConferenceRoomByName(name);
        if (conferenceRoom != null && conferenceRoom.isAvailable()) {
            conferenceRoom.addGuest(guest);
            return true;
        }
        return false;
    }

    public void checkOutConferenceRoom(Guest guest,String name) {
        ConferenceRoom conferenceRoom = getConferenceRoomByName(name);
        if (conferenceRoom != null) {
            conferenceRoom.removeGuest(guest);
        }
    }

    public ArrayList<Booking> getBookings(){
        return this.bookings;
    }

    public void addDiningRoom(DiningRoom diningRoom){
        diningRooms.put(diningRoom.getName(), diningRoom);
    }

    public HashMap<String, DiningRoom> getDiningRooms() {
        return diningRooms;
    }
}
