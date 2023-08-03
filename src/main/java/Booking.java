import java.util.ArrayList;

public class Booking {

    private Bedroom bedroom;
    private int numberOfNights;
    private Guest guest;

    public Booking(Bedroom bedroom, int numberOfNights, Guest guest) {
        this.bedroom = bedroom;
        this.numberOfNights = numberOfNights;
        this.guest = guest;
    }

    public Bedroom getBedroom() {
        return bedroom;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public int getTotalBill(){
        return bedroom.getNightlyRate() * numberOfNights;
    }

    public Guest getGuest() {
        return guest;
    }
}
