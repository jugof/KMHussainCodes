package banking;

//factory class
public class Banker {
    
    private static long nid = System.currentTimeMillis();

    public static Account openCurrentAccount() {
        var acc = new CurrentAccount();
        acc.id = ++nid;
        return acc;
    }

    public static Account openSavingsAccount() {
        var acc = new SavingsAccount();
        acc.id = ++nid;
        return acc;
    }
}
