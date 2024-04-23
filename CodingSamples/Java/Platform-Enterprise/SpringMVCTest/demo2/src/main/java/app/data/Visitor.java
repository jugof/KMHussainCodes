package app.data;

import java.util.Date;

public record Visitor(String givenName, int visitCount, Date lastVisit, String starRating) {
    
    public static Visitor fromGuest(Guest guest) {
        var bookings = guest.getBookings();
        return new Visitor(
            guest.getName(), 
            bookings.size(), 
            bookings.stream().map(Booking::getArrival).max(Date::compareTo).get(), 
            "*".repeat(guest.getRating())
        );
    }
}
