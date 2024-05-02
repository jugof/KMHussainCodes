namespace Banking;

sealed class SavingsAccount : Account, IProfitable
{
    const double MinBal = 5000;

    internal SavingsAccount()
    {
        Balance = MinBal;
    }

    public override void Deposit(double amount)
    {
        Balance += amount;
    }

    public override void Withdraw(double amount)
    {
        if(Balance - amount < MinBal)
            throw new InsufficientFundsException();
        Balance -= amount;
    }

    public double AddInterest(int months)
    {
        double rate = Balance < 5 * MinBal ? 3 : 4;
        double interest = Balance * rate * months / 1200;
        Balance += interest;
        return interest;
    }

}