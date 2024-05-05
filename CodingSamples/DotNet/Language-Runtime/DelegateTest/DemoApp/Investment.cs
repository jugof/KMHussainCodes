namespace DemoApp;

delegate double InterestRate(int period);

class Investment(double installment, int duration)
{
    public double FutureValue(InterestRate rate)
    {
        double i = rate(duration) / 100;
        return (installment / i) * (Math.Pow(1 + i, duration) - 1);
    }
}
