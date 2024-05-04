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
        else if(args[0] == "show")
        {
            //ICollection<Interval> store = new List<Interval>();
            //ICollection<Interval> store = new HashSet<Interval>();
            ICollection<Interval> store = new SortedSet<Interval>();
            store.Add(new Interval(4, 31));
            store.Add(new Interval(7, 42));
            store.Add(new Interval(5, 13));
            store.Add(new Interval(6, 54));
            store.Add(new Interval(3, 25));
            store.Add(new Interval(2, 85));
            foreach(var item in store)
                Console.WriteLine(item);
        }else if(args[0] == "find")
        {
            //IDictionary<string, Interval> store = new Dictionary<string, Interval>();
            //IDictionary<string, Interval> store = new SortedList<string, Interval>();
            IDictionary<string, Interval> store = new Dictionary<string, Interval>();
            store.Add("monday", new Interval(4, 31));
            store.Add("tuesday", new Interval(7, 42));
            store.Add("wednesday", new Interval(5, 13));
            store.Add("thursday", new Interval(6, 54));
            store["friday"] = new Interval(3, 25);
            store["monday"] = new Interval(8, 31);
            if(args.Length > 1)
            {
                if(store.TryGetValue(args[1], out var val))
                    Console.WriteLine("Value = {0}", val);
                else
                    Console.WriteLine("No such key!");
            } 
            else
            {
                foreach(var entry in store)
                    Console.WriteLine("{0, -12}{1, 8}", entry.Key, entry.Value);
            }         
        }
    }
}
