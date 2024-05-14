using DemoApp.Endpoints;

var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();
app.MapGet("/", Greeting.Welcome);
app.MapPost("/Greet", Greeting.Hello);
app.Run();
