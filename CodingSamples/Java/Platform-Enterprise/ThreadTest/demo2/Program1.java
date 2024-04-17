class Program {
    
    static class JointAccount {

        private int balance;

        public int balance() {
            return balance;
        }

        public boolean withdraw(int amount){
            boolean success = false;
            if(balance >= amount){
                balance = Activity.perform(balance, amount, -1);
                success = true;
            }
            return success;
        }

        public void deposit(int amount) {
            balance = Activity.perform(balance, amount, 1);
        }
    }

    public static void main(String[] args) throws Exception {
        var acc = new JointAccount();
        acc.deposit(10000);
        System.out.println("Joint account opened for Jack and Jill.");
        System.out.printf("Initial Balance: %d%n", acc.balance());
        System.out.println("Jack is withdrawing 6000...");
        if(!acc.withdraw(6000))
            System.out.println("Jack's withdraw operation failed!");
        System.out.println("Jill is withdrawing 7000...");
                if(!acc.withdraw(7000))
                    System.out.println("Jill's withdraw operation failed!");
        System.out.printf("Final Balance  : %d%n", acc.balance());
    }
}
