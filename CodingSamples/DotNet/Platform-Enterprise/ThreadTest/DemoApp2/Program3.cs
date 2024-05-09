namespace DemoApp;

class Program
{
    class JointAccount
    {
        public int Balance { get; private set; }

        public bool Withdraw(int amount)
        {
            bool success = false;
            //a thread requests ownership of the monitor associated with object obj
            //by calling Monitor.Enter(obj), if this monitor is not presently owned
            //by another thread the caller thread acquires the ownership and resumes
            //otherwise it must wait until the present owner releases the ownership
            Monitor.Enter(this);
            try
            {
                if(Balance >= amount)
                {
                    Balance = Activity.Perform(amount, Balance, Activity.Debit);
                    success = true;
                }
            }
            finally
            {
                //thread which owns the monitor associated with object obj
                //calls Monitor.Exit(obj) to release its ownership
                Monitor.Exit(this);
            }
            return success;
        }

        public void Deposit(int amount)
        {
            lock(this)
            {
                Balance = Activity.Perform(amount, Balance, Activity.Credit);
            }
        }
    }

    static void Main(string[] args)
    {
        var acc = new JointAccount();
        acc.Deposit(10000);
        Console.WriteLine("Joint account opened for Jack and Jill.");
        Console.WriteLine("Initial Balance = {0}", acc.Balance);
        var child1 = new Thread(() => 
        {
            Console.WriteLine("Jack is withdrawing 6000...");
            if(!acc.Withdraw(6000))
                Console.WriteLine("Jack's withdrawal failed!");
        });
        var child2 = new Thread(() => 
        {
            Console.WriteLine("Jill is withdrawing 7000...");
            if(!acc.Withdraw(7000))
                Console.WriteLine("Jill's withdrawal failed!");
        });
        child1.Start();
        child2.Start();
        child1.Join();
        child2.Join();
        Console.WriteLine("Final Balance = {0}", acc.Balance);
    }
}
