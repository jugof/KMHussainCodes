namespace DemoApp.Endpoints;

using Grpc.Core;
using Grpc.Core.Utils;
using Sales;
using OrderManagerStub = Sales.OrderManager.OrderManagerClient;

public static class SalesAgentApi
{
    private static async Task<IResult> ReadOrders(string customerId, OrderManagerStub remote)
    {
        var request = new CustomerInput { CustomerCode = customerId };
        using var reply = remote.FetchOrders(request);
        var resources = from message in await reply.ResponseStream.ToListAsync()
                        select new OrderResource 
                        {
                            ProductNo = message.ItemCode,
                            Quantity = message.ItemCount,
                            OrderDate = message.ConfirmationDate
                        };
        return resources.Any() ? Results.Ok(resources) : Results.NotFound();
    }

    private static async Task<IResult> CreateOrder(OrderResource resource, OrderManagerStub remote)
    {
        var request = new OrderInput 
        {
            CustomerCode = resource.CustomerId,
            ItemCode = resource.ProductNo,
            ItemCount = resource.Quantity
        };
        try
        {
            var reply = await remote.PlaceOrderAsync(request);
            resource.OrderNo = reply.ConfirmationCode;
            return Results.Ok(resource);
        }
        catch(RpcException ex)
        {
            return Results.Problem(ex.Status.Detail, "/api/sales", StatusCodes.Status500InternalServerError);
        }
    }

    public static void AddSalesAgentApi(this IServiceCollection services)
    {
        services.AddGrpcClient<OrderManagerStub>(channel => channel
            .Address = new Uri("http://localhost:4030"));
    }

    public static void MapSalesAgentApi(this IEndpointRouteBuilder endpoints)
    {
        endpoints.MapGet("/api/sales/{customerId}", ReadOrders)
            .RequireCors(permissions => permissions.AllowAnyOrigin());
        endpoints.MapPost("/api/sales", CreateOrder);
    }
}