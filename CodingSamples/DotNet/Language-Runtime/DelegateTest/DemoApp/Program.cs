namespace DemoApp;

class Program
{
    static double SafeScheme(int y)
    {
        return y < 3 ? 6 : 7.5;
    }

    static void Main(string[] args)
    {
        double p = double.Parse(args[0]);
        int n = int.Parse(args[1]);
        var myinv = new Investment(p, n);
        Console.WriteLine("Future value of risk-free investment: {0:0.00}", myinv.FutureValue(SafeScheme));
        int m = 8;
        //substituting delegate by lambda-expression - an anonymous method that
        //captures local variables of outer method by reference
        Console.WriteLine("Future value of high-risk investment: {0:0.00}", myinv.FutureValue(y => ++m + 0.25 * y));
    }
}
