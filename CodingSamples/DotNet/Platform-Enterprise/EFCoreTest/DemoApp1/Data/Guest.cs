namespace DemoApp.Data;

public class Guest
{
    public string Id { get; set; }

    public int Rating { get; set; } = 5;

    public List<Booking> Bookings { get; set; } = [];
}
