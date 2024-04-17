class Program {
    
    static class JointAccount {

        private int balance;

        public int balance() {
            return balance;
        }

        public boolean withdraw(int amount){
            boolean success = false;
            //in order to execute code within a synchronized block a thread
            //must acquire the ownership of the built-in monitor of the 
            //specified object(this), only one thread can be the owner of a
            //given object's monitor at a time while other threads must wait 
            //for this thread to release the ownership
            synchronized(this){
                if(balance >= amount){
                    balance = Activity.perform(balance, amount, -1);
                    success = true;
                }
            }
            return success;
        }

        public synchronized boolean withdrawAfterDeposit(int amount) throws InterruptedException {
            //release the ownership of this object's monitor, wait for
            //this monitor to be notified and resume execution after
            //reaquring the monitor 
            this.wait();
            return withdraw(amount);
        }

        public synchronized void deposit(int amount) {
            balance = Activity.perform(balance, amount, 1);
            //when the monitor is released it should go to any thread
            //which released the monitor by calling wait
            this.notify();
        }
    }

    public static void main(String[] args) throws Exception {
        var acc = new JointAccount();
        acc.deposit(10000);
        System.out.println("Joint account opened for Jack and Jill.");
        System.out.printf("Initial Balance: %d%n", acc.balance());
        Thread child1 = new Thread(() -> {
            System.out.println("Jack is withdrawing 6000...");
            if(!acc.withdraw(6000))
                System.out.println("Jack's withdraw operation failed!");
        });
        Thread child2 = new Thread(() -> {
            System.out.println("Jill is withdrawing 7000...");
            if(!acc.withdraw(7000))
                System.out.println("Jill's withdraw operation failed!");
        });
        child1.start();
        child2.start();
        child1.join(); //wait for child1 to exit
        child2.join(); //wait for child2 to exit
        System.out.printf("Final Balance  : %d%n", acc.balance());
    }
}
