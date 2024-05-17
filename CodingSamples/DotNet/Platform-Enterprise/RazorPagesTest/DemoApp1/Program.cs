using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddRazorPages(); //enable razor pages
builder.Services.AddSingleton<ICounter, CommonCounter>();
var app = builder.Build();
//map handler for ~/Pages/X.cshtml to the path specified
//by @page in X.cshtml or to /X with X=Index by default
app.MapRazorPages();
app.Run();
