using DemoApp.Services;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddControllers(); //enable MVC
//configure CORS policy (see Controllers/BackController.cs)
builder.Services.AddCors(options => options
    .AddPolicy("forPreview", permission => permission
        //.AllowAnyOrigin()
        .WithOrigins("http://127.0.0.1:3000")
        //.AllowAnyMethod()
        .WithMethods("GET", "PUT")
        .AllowAnyHeader()));
builder.Services.AddTransient<ICounter, NamedCounter>();
var app = builder.Build();
app.UseStaticFiles();
app.UseCors(); //include required headers for CORS enabled endpoints 
app.MapControllers(); //map endpoint handlers from controllers
app.Run();
