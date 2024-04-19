package app.data;

import java.util.Date;

public class Booking {
 
    private int id;

    private Date arrival = new Date();

    private Guest guest;

    public Booking(Guest guest) {
        this.guest = guest;
    }

    public Booking() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    

}
