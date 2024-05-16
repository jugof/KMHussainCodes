using DemoApp.Endpoints;
using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
//builder.Services.AddSingleton<ICounter, CommonCounter>();
builder.Services.AddTransient<ICounter, NamedCounter>();
var app = builder.Build();
app.MapGet("/", Greeting.Welcome);
app.MapPost("/Greet", Greeting.Hello);
app.Run();
