struct Investment
{
    private double installment;
    private int duration;
    private RiskLevel risk;

    public Investment(double amount, int period)
    {
        installment = amount;
        duration = period;
        risk = RiskLevel.None;
    }

    public void AllowRisk(bool yes)
    {
        risk = yes ? RiskLevel.Low : RiskLevel.None;
    }

    public void AllowRisk(RiskLevel level)
    {
        risk = level;
    }
    
    public double TotalPayment()
    {
        return installment * duration;
    }

    public double FutureValue()
    {
        double i;
        switch(risk)
        {
            case RiskLevel.Low:
                i = 0.08;
                break;
            case RiskLevel.High:
                i = 0.12;
                break;
            default:
                i = 0.06;
                break;
        }
        return (installment / i) * (Math.Pow(1 + i, duration) - 1);
    }
}