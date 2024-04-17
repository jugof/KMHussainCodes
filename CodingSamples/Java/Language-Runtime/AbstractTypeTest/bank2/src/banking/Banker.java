package banking;

//factory class
public class Banker {
    
    private static long nid = System.currentTimeMillis() % 1000000;

    public static Account openCurrentAccount() {
        var acc = new CurrentAccount();
        acc.id = ++nid + 10000000;
        return acc;
    }

    public static Account openSavingsAccount() {
        var acc = new SavingsAccount();
        acc.id = ++nid + 20000000;
        return acc;
    }
}
