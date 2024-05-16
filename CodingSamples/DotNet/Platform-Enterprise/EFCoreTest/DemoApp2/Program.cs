using DemoApp.Data;
using Microsoft.EntityFrameworkCore;

var config = new DbContextOptionsBuilder<ShopDbContext>()
                .UseSqlServer("Data Source=iitdac.met.edu;Database=Shop;User Id=dac;Password=Dac@1234;Encrypt=False");
using var db = new ShopDbContext(config.Options);
if(args.Length == 0)
{
    foreach(var product in db.Products)
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", product.ProductId, product.Price, product.Stock);
}
else
{
    int pno = int.Parse(args[0]);
    var product = db.Products
                    .Where(e => e.ProductId == pno)
                    //.Include(e => e.Orders) //eager loading
                    .FirstOrDefault();
    if(product is not null)
    {
        db.Entry(product).Collection(e => e.Orders).Load(); //explicit loading
        foreach(var order in product.Orders)
            Console.WriteLine("{0}\t{1}\t{2:yyyy-MM-dd}", order.CustomerId, order.Quantity, order.OrderDate);
    }
    else
    {
        Console.WriteLine("No such product!");
    }
}
