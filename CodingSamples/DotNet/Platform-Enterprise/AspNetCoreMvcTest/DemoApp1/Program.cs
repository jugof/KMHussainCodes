using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllers(); //enable MVC
builder.Services.AddTransient<ICounter, NamedCounter>();
var app = builder.Build();
app.UseStaticFiles();
app.MapControllers(); //map endpoint handlers from controllers
app.Run();
