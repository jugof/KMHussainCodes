namespace DemoApp.Data;

public class Booking
{
    public int Id { get; set; }

    public DateTime Arrival { get; set; } = DateTime.Now;

    public Guest Guest { get; set; }
}
