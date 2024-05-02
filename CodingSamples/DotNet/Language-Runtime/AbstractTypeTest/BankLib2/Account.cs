namespace Banking;

//a class defined with 'abstract' modifier does not support
//activation, it can only be used as a base class
public abstract class Account
{
    public long Id { get; internal set; }
    
    public double Balance { get; protected set; }

    //a method defined with 'abstract' modifier is a pure virtual instance
    //method and it must be overridden by a non-abstract derived class
    public abstract void Deposit(double amount);

    public abstract void Withdraw(double amount);
}