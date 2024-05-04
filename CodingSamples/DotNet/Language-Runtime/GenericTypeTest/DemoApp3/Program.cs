namespace DemoApp;

class Program
{
    static IEnumerable<Interval> GenerateIntervals(int count)
    {
        for(int i = 1; i <= count; ++i)
        {
            //a method whose return type is IEnumerable<T> uses yield return
            //statement to make the returned value of type T available through
            //standard enumerator exposed by the compiler generated implementation
            //of IEnumerable<T> interface
            yield return new Interval(0, 71 * i);
        }
    }

    static void Main(string[] args)
    {
        if(args.Length == 0)
        {
            foreach(var i in GenerateIntervals(5))
                Console.WriteLine(i);
        }
    }
}
