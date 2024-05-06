namespace DemoApp;

static class Printable
{
    //a fluent method returns a result to which other such method can be applied
    public static IEnumerable<string> Prepare<V>(this IEnumerable<V> source, string pattern)
    {
        foreach(V entry in source)
        {
            yield return string.Format(pattern, entry);
        }
    }

    public static void PrintEach(this IEnumerable<string> source)
    {
        foreach(string entry in source)
            Console.WriteLine(entry);
    }
}