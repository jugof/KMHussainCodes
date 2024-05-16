namespace DemoApp.Services;

public class NamedCounter : ICounter
{
    private static Dictionary<string, int> store = [];

    public int CountNext(string name)
    {
        lock(store)
        {
            store.TryGetValue(name, out int current);
            store[name] = ++current;
            return current;
        }
    }
}