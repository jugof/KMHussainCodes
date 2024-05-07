using DemoApp.Hosting;

namespace DemoApp.Services;

[OnePerCall]
public class CasualGreeter : IGreeter, IDisposable
{
    public CasualGreeter()
    {
        Console.WriteLine("CasualGreeter activated");
    }

    public void Dispose()
    {
        Console.WriteLine("CasualGreeter deactivated");
    }

    public string Greet(string person)
    {
        return $"Hi {person}";
    }

    
}
