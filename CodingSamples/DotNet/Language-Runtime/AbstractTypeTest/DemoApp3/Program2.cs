using Taxation;

namespace DemoApp;

class Program
{
    //nested class
    class Auditor
    {
        internal Auditor()
        {
            Console.WriteLine("Auditor - acquiring resources");
        }

        public void Audit(string id, ITaxPayer client)
        {
            if(id.Length < 4)
                throw new ArgumentException("Invalid ID");
            decimal payment = client.IncomeTax() + 500;
            Console.WriteLine("Total tax payment for {0} is {1:0.00}", id, payment);
        }

        public void Dispose()
        {
            Console.WriteLine("Auditor - releasing resources");
        }
    }

    static void Process(string name, int count)
    {
        ITaxPayer t = name == "jack" ? new Supervisor(count) : new Worker(count);
        Auditor a = new Auditor();
        try
        {
            a.Audit(name, t);
        }
        finally
        {
            a.Dispose();
        }
        
    }

    static void Main(string[] args)
    {
        try
        {
            string m = args[0].ToLower();
            int n = int.Parse(args[1]);
            Process(m, n); 
        }
        catch(Exception ex)
        {
            Console.WriteLine("Error: {0}", ex.Message);
        }
    }
}
