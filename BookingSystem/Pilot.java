package BookingSystem;
import Users.Name;

public class Pilot  {
    private Name name;

    public Pilot(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}