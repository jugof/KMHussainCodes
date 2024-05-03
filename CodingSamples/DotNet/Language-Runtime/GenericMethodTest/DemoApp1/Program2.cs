namespace DemoApp;

class Program
{
    static T Select<T>(int index, T first, T second) 
    {
        
        if((index % 2) == 1)
            return first;
        return second;
    }

    static void Main(string[] args)
    {
        if(args.Length > 0 && int.TryParse(args[0], out int s))
        {
            string ss = Select(s, "Monday", "Tuesday");
            Console.WriteLine($"Selected string = {ss}");
            double sd = Select(s, 47.8, 54.3);
            Console.WriteLine($"Selected double = {sd}");
            //double ssd = (double)Select(s, 9.8, "Gravity");
        }
    }
}
