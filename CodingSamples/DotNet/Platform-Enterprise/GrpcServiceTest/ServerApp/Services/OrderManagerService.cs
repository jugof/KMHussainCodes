using Grpc.Core;
using Microsoft.EntityFrameworkCore;
using Sales;
using ServerApp.Data;

namespace ServerApp.Services;

public class OrderManagerService : OrderManager.OrderManagerBase
{
    public override async Task<OrderStatus> PlaceOrder(OrderInput request, ServerCallContext context)
    {
        using var db = new ShopDbContext();
        var ctr = await db.Counters.FindAsync("order");
        var entity = new Order 
        {
            Id = ++ctr!.CurrentValue + ctr.SeedValue,
            OrderDate = DateTime.Today,
            CustomerId = request.CustomerCode,
            ProductNo = request.ItemCode,
            Quantity = request.ItemCount
        };
        db.Orders.Add(entity);
        var reply = new OrderStatus();
        try
        {
            await db.SaveChangesAsync();
            reply.ConfirmationCode = entity.Id;
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            context.Status = new Status(StatusCode.Internal, "Order Failed");
        }
        return reply;
    }

    public override async Task FetchOrders(CustomerInput request, IServerStreamWriter<CustomerOrder> responseStream, ServerCallContext context)
    {
        using var db = new ShopDbContext();
        var selection = from entity in db.Orders
                        where entity.CustomerId == request.CustomerCode
                        select new CustomerOrder 
                        {
                            ItemCode = entity.ProductNo,
                            ItemCount = entity.Quantity,
                            ConfirmationDate = entity.OrderDate.ToString("yyyy-MM-dd")
                        };
        foreach(var message in selection)
            await responseStream.WriteAsync(message);
    }
}
