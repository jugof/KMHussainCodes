package banking;

//a class declared with 'abstract' modofier does not
//support instantiation, it can only be used as a super-class
//for other classes
public abstract class Account {
    
    long id;
    protected double balance;

    public long id() {
        return id;
    }

    public double balance() {
        return balance;
    }

    //a method declared with 'abstract' modifier is pure
    //(defined without implementation) and it must be
    //overridden by a non-abstract subclass
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount) throws InsufficientFundsException;

    //a method declared with 'final' modifier cannot be overridden
    //in the subclass, JVM is allowed to use static-binding in call
    //to such methods
    public final void transfer(double amount, Account that) throws InsufficientFundsException {
        if(this == that)
            throw new IllegalTransferException();
        this.withdraw(amount);
        that.deposit(amount);
    }
}
