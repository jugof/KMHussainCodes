namespace DemoApp;

class Program
{
    [ThreadStatic]
    static string user;

    static void HandleJob(int jid)
    {
        Console.WriteLine("Thread<{0}> has accepted job<{1}> for {2}", Environment.CurrentManagedThreadId, jid, user);
        Activity.Perform(jid);
        Console.WriteLine("Thread<{0}> has finished job<{1}> for {2}", Environment.CurrentManagedThreadId, jid, user);
    }

    static void Main(string[] args)
    {
        int n = args.Length > 0 ? int.Parse(args[0]) : 1;
        var child = new Thread(() => 
        {
            user = "Jack";
            HandleJob(n);
        });
        child.IsBackground = n > 5; //CLR does not wait for a background thread to exit
        child.Start();
        user = "Jill";
        HandleJob(2);
    }
}
