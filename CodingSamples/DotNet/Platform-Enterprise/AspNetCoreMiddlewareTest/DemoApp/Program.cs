using DemoApp.Endpoints;
using DemoApp.Middlewares;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddDistributedMemoryCache();
builder.Services.AddSession(options => 
{
    options.IdleTimeout = TimeSpan.FromMinutes(5);
});
var app = builder.Build();
app.UseStaticFiles();
app.UseSession();
app.UseRouting();
app.UseMiddleware<Pausing>();
app.MapGet("/", Greeting.Welcome);
app.MapPost("/Greet", Greeting.Hello);
app.Run();
