namespace DemoApp.Services;

public class FormalGreeter : IGreeter
{
    public FormalGreeter()
    {
        Console.WriteLine("FormalGreeter activated");
    }

    public string Greet(string person)
    {
        return $"Hello {person}";
    }
}