using DemoApp.Models;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllersWithViews();
builder.Services.AddTransient<HotelModel>();
var app = builder.Build();
//map action method Y of XController class as handler 
//for path /X/Y with X=Home and Y=Index by default
app.MapDefaultControllerRoute();
app.Run();
