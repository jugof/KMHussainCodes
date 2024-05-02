namespace Taxation;

public struct Worker(int jobs) : ITaxPayer
{
    public decimal AnnualIncome()
    {
        return 180000 + 500 * jobs;
    }
}