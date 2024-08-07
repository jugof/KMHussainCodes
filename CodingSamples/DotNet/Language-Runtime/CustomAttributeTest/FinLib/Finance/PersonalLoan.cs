namespace Finance;

public class PersonalLoan 
{
	[MaxDuration(Limit = 6)]
	public double Common(double amount, int period) => 11 + 0.5 * (period / 3);

	public double Employee(double amount, int period) => Common(amount, period) - 5;
}

