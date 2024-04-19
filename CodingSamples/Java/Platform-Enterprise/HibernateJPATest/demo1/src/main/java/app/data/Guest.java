package app.data;

import java.util.ArrayList;
import java.util.List;

public class Guest {
    
    private String name;

    private int rating = 5;

    private List<Booking> bookings = new ArrayList<>();

    public Guest(String name) {
        this.name = name;
    }

    public Guest() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    
}
