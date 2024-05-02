class Investment
{
    //a method can declare optional parameters at the end of its parameter-list
    //along with their default argument values
    public static double FutureValue(double installment, int duration, bool risk = false)
    {
        double i = risk ? 0.08 : 0.06;
        return (installment / i) * (System.Math.Pow(1 + i, duration) - 1);
    }
}
