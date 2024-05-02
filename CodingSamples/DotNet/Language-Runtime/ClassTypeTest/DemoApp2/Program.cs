class Program
{
    private static void Print(string label, object info)
    {
        Console.WriteLine("{0} = {1}", label, info.ToString());
    }

    static void Main(string[] args)
    {
        Interval a = new Interval(6, 45); //loc.0
        /*
            ldstr      "Interval a"
            ldloc.0     
            call       void Program::Print(string, object)
        */
        Print("Interval a", a);
        Interval b = new Interval(4, 5);
        Print("Interval b", b);
        Print("Sum", a + b);
        Interval c = new Interval(5, 105);
        Print("Interval c", c);
        Interval d = b;
        Print("Interval d", d);
        Console.WriteLine("--------------------------------");
        Console.WriteLine("a is identical to b: {0}", ReferenceEquals(a, b));
        Console.WriteLine("a is identical to c: {0}", ReferenceEquals(a, c));
        Console.WriteLine("d is identical to b: {0}", ReferenceEquals(d, b));
        Console.WriteLine("--------------------------------");
        Console.WriteLine("a is equal to b: {0}", Equals(a, b));
        Console.WriteLine("a is equal to c: {0}", Equals(a, c));
        Console.WriteLine("d is equal to b: {0}", Equals(d, b));
        Console.WriteLine("--------------------------------");
        Rectangle e = new Rectangle { Length = 12.25f, Breadth = 8.75f }; //using initializer
        /*
            ldstr      "Rectangle e"
            ldloc.s    V_4  //e
            box        Rectangle
            call       void Program::Print(string, object)
        */
        Print("Rectangle e", e); //auto-boxing of value type (Rectangle) to reference type (object)

    }
}