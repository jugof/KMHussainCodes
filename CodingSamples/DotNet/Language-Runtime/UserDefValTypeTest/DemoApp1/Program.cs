using System;

class Program
{
	//a method parameter declared with 'ref' keyword accepts address
	//of argument instead of copy of its value
	private static void Adjust(ref Investment inv)
	{
		inv.AllowRisk(inv.TotalPayment() < 500000);
	}

	public static void Main(string[] args)
	{
		Console.WriteLine("Welcome Investor!");
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		Investment myinv = new Investment(p, n);
		Console.WriteLine("Future value for risk-free investment: {0:0.00}", myinv.FutureValue());
		myinv.AllowRisk(true);
		Console.WriteLine("Future value for low-risk investment : {0:0.00}", myinv.FutureValue());
		Adjust(ref myinv); //passing address of value type variable using ref operator
		Console.WriteLine("Future value for smart investment    : {0:0.00}", myinv.FutureValue());
	}
}

