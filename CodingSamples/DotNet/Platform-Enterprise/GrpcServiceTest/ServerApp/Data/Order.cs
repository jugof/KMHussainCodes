namespace ServerApp.Data;

public class Order
{
    public int Id { get; set; }

    public DateTime OrderDate { get; set; }

    public required string CustomerId { get; set; }

    public int ProductNo { get; set; }

    public int Quantity { get; set; }
}