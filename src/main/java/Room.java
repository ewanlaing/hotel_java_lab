import java.util.ArrayList;

public abstract class Room {

    private int capacity;
    private ArrayList<Guest> guests;

    public double length, width;

    public Room(int capacity) {
        this.capacity = capacity;
        this.length = 10;
        this.width = 15;
        this.guests = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Guest> getGuests() {
        return guests;
    }

    public void addGuest(Guest guest) {
        this.guests.add(guest);
    }

    public void removeGuest(Guest guest){
        this.guests.remove(guest);
    }

    public void emptyRoom(){
        this.guests.clear();
    }

    public abstract boolean isAvailable();

    public static double getSize(double length, double width){
        return length * width;
    }


}
