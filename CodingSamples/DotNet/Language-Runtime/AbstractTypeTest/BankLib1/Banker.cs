namespace Banking;

//a class defined with 'static' modifier can only
//contain static members and as such it does not
//support instance constructors
public static class Banker
{
    private static long nid = DateTime.Now.Ticks % 1000000;

    public static Account OpenCurrentAccount()
    {
        var acc = new CurrentAccount(); //var = CurrentAccount
        acc.Id = ++nid + 10000000;
        return acc;
    }

    public static Account OpenSavingsAccount()
    {
        SavingsAccount acc = new (); //new SavingsAccount()
        acc.Id = ++nid + 20000000;
        return acc;
    }

    public static void Transfer(Account source, Account target, double amount)
    {
        if(ReferenceEquals(source, target))
            throw new IllegalTransferException();
        source.Withdraw(amount);
        target.Deposit(amount);
    }
}