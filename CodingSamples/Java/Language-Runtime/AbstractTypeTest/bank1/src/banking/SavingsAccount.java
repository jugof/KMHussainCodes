package banking;

final class SavingsAccount extends Account {
    
    //value of a field declared with 'static' modifier is shared by
    //all the instances of its class, a field declared with 'final' 
    //modifier cannot be reassinged after it is initialized
    static final double MIN_BAL = 5000;

    SavingsAccount() {
        balance = MIN_BAL;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if(balance - amount < MIN_BAL)
            throw new InsufficientFundsException();
        balance -= amount;
    }
}
