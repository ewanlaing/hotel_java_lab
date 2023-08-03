public class Bedroom extends Room{

    private int roomNumber;

    private RoomType roomType;

    private int nightlyRate;
    public Bedroom(int roomNumber, RoomType roomType, int nightlyRate) {
        super(roomType.getCapacity());
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.nightlyRate = nightlyRate;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public boolean isAvailable(){
        return this.getGuests().isEmpty();
    }

    public int getNightlyRate() {
        return this.nightlyRate;
    }
}
