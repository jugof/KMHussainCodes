using Microsoft.EntityFrameworkCore;

namespace DemoApp.Data;

public class ShopDbContext(DbContextOptions options) : DbContext(options)
{
    public DbSet<Customer> Customers { get; set; }
}
