using Microsoft.EntityFrameworkCore;

namespace DemoApp.Data;

public class ShopDbContext(DbContextOptions options) : DbContext(options)
{
    public DbSet<Product> Products { get; set; }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Product>()
            .ToTable("ProductInfo")
            .Property(e => e.ProductId)
            .HasColumnName("ProductNo");
    }
}