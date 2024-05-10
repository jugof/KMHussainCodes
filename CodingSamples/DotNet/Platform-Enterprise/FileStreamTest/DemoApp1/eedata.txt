namespace DemoApp;

using System.Diagnostics;

class Program
{
    class Computation
    {
        private readonly Stopwatch watch = new ();

        public long Compute(int first, int last)
        {
            watch.Start();
            return Enumerable.Range(first, last - first + 1)
                        .AsParallel()
                        .Select(Activity.Perform)
                        .Sum();
        }

        public Task<long> ComputeAsync(int first, int last)
        {
            //the specified operation is scheduled to execute on a thread-pool
            //worker allowing the caller to resume and obtain the result from
            //the returned task once the worker has completed the operation
            return Task<long>.Run(() => Compute(first, last));
        }

        public double Time()
        {
            watch.Stop();
            return watch.Elapsed.TotalSeconds;
        }

    }

    //a method declared with async keyword can return the
    //task yielded by await operator
    static async Task HandleJob(int jid)
    {
        Console.Write("Computing...");
        var c = new Computation();
        //await operator yields to the caller the task that continues 
        //after its target task to execute remaining part of the code
        long r = await c.ComputeAsync(1, jid);
        Console.WriteLine("Done!");
        Console.WriteLine("Result = {0}, computed in {1:0.000} seconds.", r, c.Time());
    }

    static void Main(string[] args)
    {
        int n = int.Parse(args[0]);
        var job = HandleJob(n);
        while(!job.IsCompleted)
        {
            Console.Write(".");
            Thread.Sleep(500);
        }
    }
}
