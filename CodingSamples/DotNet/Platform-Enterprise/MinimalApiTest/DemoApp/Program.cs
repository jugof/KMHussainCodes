using DemoApp.Endpoints;

var builder = WebApplication.CreateBuilder(args);
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddCors();
builder.Services.AddSalesAgentApi();
var app = builder.Build();
app.UseFileServer();
app.UseSwagger();
if(app.Environment.IsDevelopment())
    app.UseSwaggerUI();
app.UseCors();
app.MapSalesAgentApi();
app.Run();
