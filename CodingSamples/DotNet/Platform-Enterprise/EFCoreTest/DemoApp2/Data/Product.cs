namespace DemoApp.Data;

public class Product
{
    public int ProductId { get; set; }

    public decimal Price { get; set; }

    public int Stock { get; set; }

    public List<Order> Orders { get; set; } = [];
}
