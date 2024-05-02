namespace Taxation;

public struct Supervisor(int subordinates) : ITaxPayer
{
    public decimal AnnualIncome()
    {
        return 480000 + 3000 * subordinates;
    }
}