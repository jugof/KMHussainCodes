namespace DemoApp;

class Program
{
    static void PrintStack(IStackReader<object> stack)
    {
        for(int i = 0; !stack.Empty(); ++i)
        {
            if(i > 0)
                Console.Write(", ");
            Console.Write(stack.Pop());
        }
        Console.WriteLine();
    }

    static void Main(string[] args)
    {
        SimpleStack<string> a = new SimpleStack<string>();
        a.Push("Monday");
        a.Push("Tuesday");
        a.Push("Wednesday");
        a.Push("Thursday");
        a.Push("Friday");
        PrintStack(a);
        Console.WriteLine();
        SimpleStack<Interval> b = new SimpleStack<Interval>();
        b.Push(new Interval(4, 31));
        b.Push(new Interval(6, 52));
        b.Push(new Interval(5, 13));
        b.Push(new (3, 24));
        PrintStack(b);
    }
}
