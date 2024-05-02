namespace Taxation;

public interface ITaxPayer
{
    decimal AnnualIncome();

    decimal IncomeTax()
    {
        decimal i = AnnualIncome();
        return i > 120000 ? 0.15m * (i - 120000) : 0;
    }
}