namespace DemoApp;

class Program
{
    record JobInfo(int Id, string User);

    static void HandleJob(JobInfo job)
    {
        Console.WriteLine("Thread<{0}> has accepted job<{1}> for {2}", Environment.CurrentManagedThreadId, job.Id, job.User);
        Activity.Perform(job.Id);
        Console.WriteLine("Thread<{0}> has finshed job<{1}> for {2}", Environment.CurrentManagedThreadId, job.Id, job.User);
        //a thread that owns monitor associared wit object obj
        //calls Monitor.Pulse(obj) to signal this monitor
        lock(job) Monitor.Pulse(job);
    }

    static void Main(string[] args)
    {
        int n = args.Length > 0 ? int.Parse(args[0]) : 2;
        var childJob = new JobInfo(n, "Jack");
        ThreadPool.QueueUserWorkItem<JobInfo>(HandleJob, childJob, true);
        HandleJob(new JobInfo(1, "Jill"));
        //a thread that owns monitor associated with object obj 
        //calls Monitor.Wait(obj) to temporarily release its ownership
        //and wait for reacquiring it until it is signalled by
        //its present owner
        lock(childJob) Monitor.Wait(childJob, 5000);
        Console.WriteLine("Goodbye!");
    }
}
