//user-defined value type
struct Investment
{
    private double installment;
    private int duration;
    private bool risk;

    //parameterized constructor
    public Investment(double amount, int period)
    {
        installment = amount;
        duration = period;
        risk = false;
    }

    public void AllowRisk(bool yes)
    {
        risk = yes;
    }
    
    public double TotalPayment()
    {
        return installment * duration;
    }

    public double FutureValue()
    {
        double i = risk ? 0.08 : 0.06;
        return (installment / i) * (System.Math.Pow(1 + i, duration) - 1);
    }
}