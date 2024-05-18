using Microsoft.AspNetCore.Server.Kestrel.Core;
using ServerApp.Services;

var builder = WebApplication.CreateBuilder(args);
//configure Kestrel to listen on HTTP/2 endpoint
//required by gRPC
builder.WebHost.ConfigureKestrel(options => options
    .ListenAnyIP(4030, listener => listener.Protocols = HttpProtocols.Http2));
builder.Services.AddGrpc(); //enable gRPC
var app = builder.Build();
app.MapGrpcService<OrderManagerService>();
app.Run();
