global using System;

class Program
{
	//a method parameter declared with 'out' keyword is like
	//a ref parameter but it can accept an uninitialized
	//argument which must be initialized before the method returns
	private static bool Invest(double amount, int count, out Investment inv)
	{
		inv = new Investment(amount, count);
		double pmt = inv.TotalPayment();
		if(pmt < 500000)
			inv.AllowRisk(RiskLevel.High);
		else if(pmt < 1000000)
			inv.AllowRisk(RiskLevel.Low);
		return pmt >= 200000;
	}

	public static void Main(string[] args)
	{
		Console.WriteLine("Welcome Investor!");
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		if(Invest(p, n, out Investment myinv))
			Console.WriteLine("Future value for investment: {0:0.00}", myinv.FutureValue());
	}
}

