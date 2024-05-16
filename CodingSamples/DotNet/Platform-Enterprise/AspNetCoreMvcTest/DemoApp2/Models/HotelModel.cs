using DemoApp.Data;

namespace DemoApp.Models;

public class HotelModel
{
    public List<VisitorInfo> ReadVisitors()
    {
        using var db = new HotelDbContext();
        var selection = from g in db.Guests
                        where g.Id.Length > 3
                        select new VisitorInfo 
                        {
                            GivenName = g.Id,
                            StarRating = new string('*', g.Rating),
                            VisitCount = g.Bookings.Count,
                            LastVisit = g.Bookings.Max(b => b.Arrival)
                        };
        return [.. selection]; //selection.ToList();
    }

    public void WriteVisitor(Guest entry)
    {
        using var db = new HotelDbContext();
        var guest = db.Guests.Find(entry.Id);
        if(guest is null)
        {
            guest = new Guest { Id = entry.Id };
            db.Guests.Add(guest);
        }
        guest.Rating = entry.Rating;
        guest.Bookings.Add(new Booking());
        db.SaveChanges();
    }
}