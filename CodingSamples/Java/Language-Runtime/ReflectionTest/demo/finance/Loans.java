package finance;

public class Loans {

	public static double monthlyInstallment(double amount, int duration, double rate) {
		double i = rate / 1200;
		int m = 12 * duration;
		return amount * i / (1 - Math.pow(1 + i, -m));
	}
}

