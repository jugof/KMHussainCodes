using DemoApp;
using DemoApp.Services;

var builder = Host.CreateApplicationBuilder(args);
builder.Services.AddHostedService<Worker>();
builder.Services.AddSingleton<ShopKeeper>();
var host = builder.Build();
host.Run();
