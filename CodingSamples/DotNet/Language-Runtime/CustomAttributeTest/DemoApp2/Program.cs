using DemoApp.Hosting;
using DemoApp.Services;

IGreeter fg = ServiceContainer.GetService<IGreeter, FormalGreeter>();
Console.WriteLine(fg.Greet("Jack"));
Console.WriteLine(fg.Greet("Jill"));
//Console.WriteLine("Using {0}", fg.GetType().Name);
Console.WriteLine("----------------------------------------------");
IGreeter cg = ServiceContainer.GetService<IGreeter, CasualGreeter>();
Console.WriteLine(cg.Greet("John"));
Console.WriteLine(cg.Greet("Jane"));
//Console.WriteLine("Using {0}", cg.GetType().Name);
