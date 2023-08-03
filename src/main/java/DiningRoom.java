public class DiningRoom extends Room{

    private String name;

    public DiningRoom(int capacity, String name) {
        super(capacity);
        this.name = name;
    }

    public boolean isAvailable(){
        return this.getCapacity() > this.getGuests().size();
    }

    public String getName() {
        return name;
    }
}
