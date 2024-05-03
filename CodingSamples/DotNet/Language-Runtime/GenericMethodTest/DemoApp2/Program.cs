using System.Numerics;

namespace DemoApp;

class Program
{
    static T Select<T>(T first, T second) where T: IComparable<T>
    {
        if(first.CompareTo(second) > 0)
            return first;
        return second;
    }

    //the last array-type parameter declared with 'params' keyword
    //can accept variable number arguments (variadic method)
    static V Summation<V>(V first, params V[] remaining) where V: IAdditionOperators<V, V, V>
    {
        V total = first;
        foreach(V value in remaining)
            total += value;
        return total;
    }

    static void Main(string[] args)
    {
        Console.WriteLine("Selected string = {0}", Select("Monday", "Tuesday"));
        Console.WriteLine("Selected double = {0}", Select(45.6, 32.1));
        Console.WriteLine("Selected Interval = {0}", Select(new Interval(3, 45), new Interval(4, 30)));
        Console.WriteLine("Sum of double values = {0}", Summation(45.6, 32.1, 54.3, 19.7, 68.5));
        Console.WriteLine("Sum of Intervals = {0}", Summation(new Interval(3, 45), new Interval(4, 30), new Interval(2, 15)));
    }   
}
