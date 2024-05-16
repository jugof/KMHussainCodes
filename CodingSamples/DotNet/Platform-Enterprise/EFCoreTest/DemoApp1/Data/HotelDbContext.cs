using Microsoft.EntityFrameworkCore;

namespace DemoApp.Data;

public class HotelDbContext : DbContext
{
    public DbSet<Guest> Guests { get; set; }

    public HotelDbContext()
    {
        Database.EnsureCreated();
    }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlite("Data Source=hotel.db");
    }

}